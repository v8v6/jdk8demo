package com.sc.cd.scopeofvariable;

/**
 * 描述:
 * test scope of variable
 *
 * @author junxi.chen
 * @create 2018-11-30 12:47
 */
@SuppressWarnings("ALL")
public class Demo1 {

    static String salutation = "Hello! ";

    public static void main(String[] args) {

        GreetingService greetService1 = message -> {
            salutation = "11";
            System.out.println(salutation + message);
        };

        greetService1.sayMessage("Runoob");
    }



    interface GreetingService {

        /**
         * 测试函数式编程
         * @param message
         */
        void sayMessage(String message);
    }
}
