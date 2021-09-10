package com.sc.cd.inter;

/**
 * @author junxchen
 * @date 2020-05-19
 */
public class StudentServiceImpl implements StudentService,ValidService,SaveService{
    @Override
    public String getBizType() {
        return "student";
    }
}
