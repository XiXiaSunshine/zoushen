package com.yang.zoushen.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String data;
    private String msg;
}
