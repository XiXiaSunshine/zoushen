package com.yang.zoushen.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

@Slf4j
public class HttpUtils {

    private static ResourceBundle bundle;

    static {
        bundle = ResourceBundle.getBundle("util");
    }

    /**
     * 生成logintoken
     * @param request
     * @param response
     * @return
     */
    public static String generateLoginToken(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        String loginToken = IdUtil.fastSimpleUUID() + "." + DigestUtil.md5Hex(System.currentTimeMillis() + "");

        Cookie cookie = new Cookie("loginToken", loginToken);
        session.setAttribute("loginToken", loginToken);

        cookie.setMaxAge(Integer.parseInt(bundle.getString("login.cookie.maxage")) * 60);
        session.setMaxInactiveInterval(Integer.parseInt(bundle.getString("login.session.lifetime")) * 60);

        log.debug("===新的的token===");
        log.debug("name: " + cookie.getName());
        log.debug("value: " + cookie.getValue());
        log.debug("maxage: " + cookie.getMaxAge());

        response.addCookie(cookie);
        return loginToken;
    }

    /**
     * 生成并获得验证码
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public static String checkcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //  创建画布
        int width = 120;
        int height = 35;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //  获得画笔
        Graphics g = bufferedImage.getGraphics();
        //  填充背景颜色
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        //  绘制边框
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(0, 0, width - 1, height - 1);
        //  生成随机字符
        //  准备数据
        String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        //  准备随机对象
        Random r = new Random();
        //  声明一个变量 保存验证码
        String code = "";
        //  书写4个随机字符
        for (int i = 0; i < 4; i++) {
            //  设置字体
            g.setFont(new Font("宋体", Font.BOLD, 28));
            //  设置随机颜色
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

            String str = data.charAt(r.nextInt(data.length())) + "";
            g.drawString(str, 10 + i * 28, 30);

            //  将新的字符 保存到验证码中
            code = code + str;
        }
        //  绘制干扰线
        for (int i = 0; i < 6; i++) {
            //  设置随机颜色
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
        }

        //  将验证码 打印到控制台
        System.out.println(code);

        //  将验证码放到session中
        request.getSession().setAttribute("code_session", code);

        //  将画布显示在浏览器中
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
        return code;
    }
}
