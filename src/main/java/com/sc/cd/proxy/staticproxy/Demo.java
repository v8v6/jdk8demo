package com.sc.cd.proxy.staticproxy;

import com.sc.cd.proxy.UserManager;
import com.sc.cd.proxy.UserManagerImpl;

public class Demo {
    public static void main(String[] args) {
        //UserManager userManager=new UserManagerImpl();
        UserManager userManager = new UserManagerImplProxy(new UserManagerImpl());
        userManager.addUser("1111", "张三");
    }
}
