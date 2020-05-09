package com.yang.zoushen.domain;

import com.yang.zoushen.enums.SimpleMsgEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class SimpleMsgVo implements Serializable {
    private Boolean flag;
    private String msg;
    private String url;

    public SimpleMsgVo(SimpleMsgEnum rmEnum) {
        this(rmEnum.getFlag(), rmEnum.getMsg(), null);
    }

    public SimpleMsgVo(Boolean flag, String msg, String url) {
        this.flag = flag;
        this.msg = msg;

        if (url != null) {
            this.url = url;
        }
    }
}
