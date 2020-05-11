package com.yang.zoushen.web;

import com.yang.zoushen.domain.DataVo;
import com.yang.zoushen.domain.RegistVo;
import com.yang.zoushen.domain.UserInfo;
import com.yang.zoushen.service.UserService;
import com.yang.zoushen.util.SSMUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("info.do")
    public String info(@CookieValue("loginToken") String loginToken, String username) throws SQLException, ParseException {
        String sLoginToken = (String) session.getAttribute("loginToken");
        List<UserInfo> users = userService.findUserByName(username);

        if (loginToken.equals(sLoginToken) && users.size() == 1) {

            request.setAttribute("userInfo", users.get(0));
            return "info";

        } else {
            request.setAttribute("msg","哎呀，访问错误……");
            request.setAttribute("url","user/login.do?username=" + username);
        }

        return "error";
    }

    /**
     * 检测用户名是否存在
     * 返回code：2001-可注册的用户名  2002-已存在用户名
     *
     * @param username
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    @ResponseBody
    @GetMapping("checkName.do")
    public DataVo checkName(String username, HttpServletResponse response) throws SQLException, IOException, ParseException {
        DataVo dv = new DataVo();
        List<UserInfo> userInfos = userService.findUserByName(username);

        if (userInfos.size() >= 1) {
            dv.setCode(2002);
            dv.setMsg("已存在的用户名");
        } else if (userInfos.size() == 0) {
            dv.setCode(2001);
            dv.setMsg("可注册的用户名");
            dv.setData(request.getContextPath() + "/user/register.do");
        }

        return dv;
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("logout")
    public String logout() {
        session.removeAttribute("loginToken");
        return "redirect:/index.jsp";
    }

    /**
     * 登录
     * @param loginToken
     * @param username
     * @param response
     * @return
     */
    @GetMapping("login.do")
    public String login(@CookieValue("loginToken") String loginToken, String username, HttpServletResponse response) {
        // 判断是否已正常登录下，获得token
        UserInfo userInfo = null;
        List<UserInfo> userInfoList = null;

        try {
            userInfoList = userService.findUserByName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (userInfoList.size() == 1) {
            userInfo = userInfoList.get(0);
        } else {
            request.setAttribute("msg", "登录失败，无效的验证！");
            return "/error.jsp";
        }

        String sLoginToken = (String) session.getAttribute("loginToken");
        if (loginToken.equals(sLoginToken)) {
            userInfo.setNextExperience(userService.findNextExperienceByUsername(username));
            request.setAttribute("userInfo", userInfo);
            System.out.println(userInfo);
            return "main";
        }

        request.setAttribute("msg", "登录失败，无效的验证！");

        return "/error.jsp";
    }

    /**
     * 登录
     * 返回代码 1001-登录成功 1002-验证码错误 1003-密码错误 1004-用户不存在
     * @param username
     * @param password
     * @param code
     * @return
     * @throws SQLException
     * @throws IOException
     */
    @PostMapping("check.do")
    @ResponseBody
    public DataVo check(String username, String password, String code, HttpServletResponse response) throws SQLException, IOException, ParseException {
        String code_session = (String) session.getAttribute("code_session");
        DataVo dv = new DataVo();

        if (!code_session.equalsIgnoreCase(code)) {
            dv.setCode(1002);
            dv.setMsg("验证码错误！");
            return dv;
        }

        List<UserInfo> userInfos = userService.findUserByName(username);

        if (userInfos.size() == 1) {

            if (userInfos.get(0).getPassword().equals(password)) {

                String loginToken = SSMUtils.generateLoginToken(request, response);
                System.out.println(loginToken);

                dv.setCode(1001);
                dv.setMsg("登录成功！");
                dv.setData(request.getContextPath() + "/user/login.do");

                return dv;
            } else {
                dv.setCode(1003);
                dv.setMsg("密码错误！");

                return dv;
            }

        } else {
            dv.setCode(1004);
            dv.setMsg("用户不存在！");

            return dv;
        }
    }

    /**
     * 生成验证码
     * @param response
     * @throws IOException
     */
    @RequestMapping("code.do")
    public void code(HttpServletResponse response) throws IOException {
        SSMUtils.checkcode(request, response);
    }

    /**
     * 注册
     * 返回code：2001-可注册的用户名  2002-已存在用户名
     * @param vo
     * @throws SQLException
     */
    @PostMapping(value = "regist.do")
    public ModelAndView register(RegistVo vo) throws SQLException, ParseException {
        ModelAndView modelAndView = new ModelAndView();
        String msg = "";
        String url = request.getContextPath() + "/";

        List<UserInfo> userInfos = userService.findUserByName(vo.getUsername());
        if (userInfos.size() == 0) {
            UserInfo userInfo = new UserInfo(vo);
            int res = -1;
            try {
                res = userService.addByUser(userInfo);
            }catch (Exception e){
                System.err.println(e);
                msg = "注册失败，请点击返回……";
                url += "register.jsp";
            }

            if (res == -1){
                msg = "注册失败，请点击返回……";
                url += "register.jsp";
            }else {
                msg = "注册成功,请点击前往登录……";
                url += "index.jsp";
            }

        } else if (userInfos.size() == 1) {
            msg = "注册失败，请点击返回……";
            url += "register.jsp";
        }

        userInfos = userService.findUserByName(vo.getUsername());
        if (userInfos.size() == 0) {
            msg = "注册失败，请点击返回……";
            url += "register.jsp";
        }

        modelAndView.addObject("msg", msg);
        modelAndView.addObject("url", url);
        modelAndView.setViewName("result");
        return modelAndView;
    }
}