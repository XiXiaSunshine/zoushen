package com.yang.zoushen.domain;

import lombok.Data;

@Data
public class TestO {
    private String attr01;
    private int attr02;

    

    /**
     * @return String return the attr01
     */
    public String getAttr01() {
        return attr01;
    }

    /**
     * @param attr01 the attr01 to set
     */
    public void setAttr01(String attr01) {
        this.attr01 = attr01;
    }

    /**
     * @return int return the attr02
     */
    public int getAttr02() {
        return attr02;
    }

    /**
     * @param attr02 the attr02 to set
     */
    public void setAttr02(int attr02) {
        this.attr02 = attr02;
    }

}