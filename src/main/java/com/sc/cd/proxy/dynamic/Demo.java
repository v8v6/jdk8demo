package com.sc.cd.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.sc.cd.proxy.UserManager;
import com.sc.cd.proxy.UserManagerImpl;

public class Demo {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserManager userManager = (UserManager) newProxyInstance(new UserManagerImpl());
        //UserManager userManager=new UserManagerImpl();
        userManager.addUser("1111", "张三");

        String format = "{\"format\":{\"first\":{\"value\":\"恭喜您，您在平台%s接的任务单%s_%s已通过审批\"},\"keyword1\":{\"value\":\"%s_%s\"},\"keyword2\":{\"value\":\"通过\"},\"remark\":{\"value\":\"请在规定的时间内尽快完成任务、提交任务验收结果。\"},\"url\":\"%s/fl-member-front/#/admin/serviceProject/detail/%s\"},\"param\":[\"platform.name\",\"projectName\",\"name\",\"projectName\",\"name\",\"platform.platformDomain\",\"id\"]}";

        String str = String.format(format, "platform", "projectName", "name", "projectName", "name", "platformDomain", "id");
        System.out.println(str);

        String format1 = String.format("%2s", "222ddsd");

        System.out.println(format1);

        String s = "wo111ai222xiaoshuai";

        String regex = "(\\S+)(\\S{5}$)";

        String s2 = s.replaceAll(regex, "*****$2");

        System.out.println(s2);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(1234555.00));

        NumberFormat numberFormat = new DecimalFormat("#,##0.00");
        System.out.println(numberFormat.format(1));
        System.out.println(numberFormat.format(1234555.00));

        String.valueOf(1234555.00).replaceAll(regex, "");

        System.out.println(11/10);

    }


    private static Object newProxyInstance(Object targetObject) {
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        //第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        //第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
        //第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
        //根据传入的目标返回一个代理对象
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("start-->>");
                        for (int i = 0; i < args.length; i++) {
                            System.out.println(args[i]);
                        }
                        Object ret = null;
                        try {
                            /*原对象方法调用前处理日志信息*/
                            System.out.println("satrt-->>");

                            //调用目标方法
                            ret = method.invoke(targetObject, args);
                            /*原对象方法调用后处理日志信息*/
                            System.out.println("success-->>");
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("error-->>");
                            throw e;
                        }
                        return ret;
                    }
                });
    }
}
