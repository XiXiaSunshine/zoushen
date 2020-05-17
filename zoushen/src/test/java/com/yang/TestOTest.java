package com.yang;

import com.yang.zoushen.domain.TestO;

import org.junit.Test;

public class TestOTest {
    
    @Test
    public void test01(){
        TestO t = new TestO();
        t.setAttr01("attr01");
        t.setAttr02(2);

        System.out.println(t);
    }
}