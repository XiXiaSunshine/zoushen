package com.yang.zoushen.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataVo implements Serializable {
    private Integer code;
    private String data;
    private String msg;
}
