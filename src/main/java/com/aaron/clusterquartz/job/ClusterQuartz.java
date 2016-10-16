package com.aaron.clusterquartz.job;

import com.aaron.clusterquartz.util.DateUtil;
import org.springframework.stereotype.Controller;

import java.lang.management.ManagementFactory;
import java.util.Date;
import java.util.Map;

/**
 * @author FengHaixin
 * @description 一句话描述该文件的用途
 * @date 2016-05-23
 */
@Controller
public class ClusterQuartz {
    public void printUserInfo() {
        System.out.println("***      start " + DateUtil.date2Str("yyyy-MM-dd HH:mm:ss:SSS", new Date()) + "    *************");

        System.out.println("*");
        System.out.println("*        current username is " + System.getProperty("user.name"));
        System.out.println("*        current os name is " + System.getProperty("os.name"));


        String pid = ManagementFactory.getRuntimeMXBean().getName();
        Map<String ,String> path = ManagementFactory.getRuntimeMXBean().getSystemProperties();
        int indexOf = pid.indexOf('@');
        if (indexOf > 0)
        {
            pid = pid.substring(0, indexOf);
        }

        System.out.println("当前JVM Process ID: " + pid);
        System.out.println("*");

        System.out.println("*********current user information end******************");
    }
}
