package com.dazuizui.client.domain;

import java.lang.management.MemoryUsage;

public class SystemInfo {
    private MemoryUsage heapMemoryUsage;
    private MemoryUsage nonHeapMemoryUsage;
    private double cpuUsage;
    private double maxCpuUsage;
    private String networkInfo;
    private String diskUsage;

    // 添加构造方法和相应的 getter 方法

    public SystemInfo(MemoryUsage heapMemoryUsage, MemoryUsage nonHeapMemoryUsage,
                      double cpuUsage, double maxCpuUsage, String networkInfo, String diskUsage) {
        this.heapMemoryUsage = heapMemoryUsage;
        this.nonHeapMemoryUsage = nonHeapMemoryUsage;
        this.cpuUsage = cpuUsage;
        this.maxCpuUsage = maxCpuUsage;
        this.networkInfo = networkInfo;
        this.diskUsage = diskUsage;
    }

    public MemoryUsage getHeapMemoryUsage() {
        return heapMemoryUsage;
    }

    public MemoryUsage getNonHeapMemoryUsage() {
        return nonHeapMemoryUsage;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public double getMaxCpuUsage() {
        return maxCpuUsage;
    }

    public String getNetworkInfo() {
        return networkInfo;
    }

    public String getDiskUsage() {
        return diskUsage;
    }

    @Override
    public String toString() {
        return "SystemInfo{" +
                "heapMemoryUsage=" + heapMemoryUsage +
                ",\n nonHeapMemoryUsage=" + nonHeapMemoryUsage +
                ",\n cpuUsage=" + cpuUsage +
                ",\n maxCpuUsage=" + maxCpuUsage +
                ",\n diskUsage='" + diskUsage + '\'' +
                '}';
    }
}
