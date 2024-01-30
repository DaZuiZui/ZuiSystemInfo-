package com.dazuizui.client.service;

import com.dazuizui.client.domain.SystemInfo;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

@Service
public class SystemServiceImpl {

    public static void main(String[] args) {
        SystemInfo systemInfo = getSystemInfo();
        System.err.println(systemInfo);
    }

    public static SystemInfo getSystemInfo() {
        // 获取内存使用情况
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();

        // 获取 CPU 使用情况
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double cpuUsage = osBean.getSystemLoadAverage();

        double maxCpuUsage = -1;

        // 获取网络信息
        String networkInfo = getNetworkInfo();

        // 获取硬盘使用情况
        String diskUsage = getDiskUsage();

        return new SystemInfo(heapMemoryUsage, nonHeapMemoryUsage, cpuUsage, maxCpuUsage, networkInfo, diskUsage);
    }

    public static String getNetworkInfo() {
        try {
            Process process = Runtime.getRuntime().exec("netstat -i");
            process.waitFor();
            java.io.InputStream inputStream = process.getInputStream();
            java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error getting network information.";
        }
    }

    public static String getDiskUsage() {
        try {
            Process process = Runtime.getRuntime().exec("df -h /");
            process.waitFor();
            java.io.InputStream inputStream = process.getInputStream();
            java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error getting disk usage information.";
        }
    }

}
