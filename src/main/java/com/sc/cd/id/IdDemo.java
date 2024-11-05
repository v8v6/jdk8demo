package com.sc.cd.id;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;

@Slf4j
public class IdDemo {

    private static final long workerIdBits = 5L;
    private static final long datacenterIdBits = 5L;

    private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private static final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    public static void main(String[] args) {
        long maxWorkerId1 = getMaxWorkerId(maxDatacenterId, maxWorkerId);
        System.out.printf("maxWorkerId1" + maxWorkerId1);
    }

    private static long getMaxWorkerId(long datacenterId, long maxWorkerId) {
        StringBuilder mpid = new StringBuilder();
        mpid.append(datacenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (StringUtils.isNotBlank(name)) {
            /*
             * GET jvmPid
             */
            mpid.append(name.split(StringPool.AT)[0]);
        }
        /*
         * MAC + PID 的 hashcode 获取16个低位
         */
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }

    private static long getDatacenterId(long maxDatacenterId) {
        long id = 0L;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                if (null != mac) {
                    id = ((0x000000FF & (long) mac[mac.length - 2]) | (0x0000FF00 & (((long) mac[mac.length - 1]) << 8))) >> 6;
                    id = id % (maxDatacenterId + 1);
                }
            }
        } catch (Exception e) {
            log.error(" getDatacenterId: " + e.getMessage(), e);
        }
        return id;
    }


}
