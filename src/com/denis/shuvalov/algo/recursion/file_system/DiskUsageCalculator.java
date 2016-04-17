package com.denis.shuvalov.algo.recursion.file_system;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DiskUsageCalculator {

    static double diskUsage(Path path) {
        double total = path.toFile().length();
        if (path.toFile().isDirectory()) {
            for (File file : path.toFile().listFiles()) {
                total = total + diskUsage(file.toPath());
            }
        }

        System.out.println(total + "\t" + path.toFile());
        return total;
    }

    public static void main(String[] args) {
        System.out.printf("Total size: %,.3f Mb",
                (DiskUsageCalculator.diskUsage(Paths.get("C:\\Users\\denis.shuvalov\\Desktop\\Test")) / 1024) / 1024);
    }
}
