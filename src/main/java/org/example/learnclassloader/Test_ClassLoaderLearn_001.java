package org.example.learnclassloader;

import sun.misc.Launcher;

public class Test_ClassLoaderLearn_001 {
    public static void main(String[] args) {
        String bootClassPath = System.getProperty("sun.boot.class.path");
        System.out.println(bootClassPath.replace(":", "\n"));
        System.out.println("=============================");

        String extStr = System.getProperty("java.ext.dirs");
        System.out.println(extStr.replace(":", "\n"));
        System.out.println("=============================");

        final String appPathStr = System.getProperty("java.class.path");
        System.out.println(appPathStr.replace(":", "\n"));
        System.out.println("=============================");
    }
}
