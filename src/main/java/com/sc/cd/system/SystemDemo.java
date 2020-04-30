package com.sc.cd.system;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.Map;

public class SystemDemo {

    public static void main(String[] args) {
        RuntimeMXBean mxb = ManagementFactory.getRuntimeMXBean();
        String name = mxb.getName();
        System.out.println(name);
        System.out.println("========");
        System.out.println(System.getProperty("java.version"));
        //System.out.println(System.getProperty("java.vendor"));
        //System.out.println(System.getProperty("java.vendor.url"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.vm.specification.version"));
        //System.out.println(System.getProperty("java.vm.specification.vendor"));
        System.out.println(System.getProperty("java.vm.specification.name"));
        System.out.println(System.getProperty("java.vm.version"));
        //System.out.println(System.getProperty("java.vm.vendor"));
        System.out.println(System.getProperty("java.vm.name"));
        System.out.println(System.getProperty("java.specification.version"));
        System.out.println(System.getProperty("java.specification.vendor"));
        System.out.println(System.getProperty("java.specification.name"));
        System.out.println(System.getProperty("java.class.version"));
        //System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println(System.getProperty("java.compiler"));
        System.out.println(System.getProperty("java.ext.dirs"));


        System.out.println("---------os---------");

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.getSystemLoadAverage"));
        //System.out.println(System.getProperty("file.separator"));
        //System.out.println(System.getProperty("path.separator"));
        //System.out.println(System.getProperty("line.separator"));
        //System.out.println(System.getProperty("user.name"));
        //System.out.println(System.getProperty("user.home"));
        //System.out.println(System.getProperty("user.dir"));

        OperatingSystemMXBean osb = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(osb.getName()); //Windows 10
        System.out.println(osb.getArch()); //amd 64
        System.out.println(osb.getAvailableProcessors()); //4
        System.out.println(osb.getVersion()); //10.0
        System.out.println(osb.getSystemLoadAverage()); //-1.0


        System.out.println("==========");
        mxb = ManagementFactory.getRuntimeMXBean();
        Map<String, String> systemProperties = mxb.getSystemProperties();
        System.out.println(systemProperties);
        System.out.println(mxb.getInputArguments());
    }
}
