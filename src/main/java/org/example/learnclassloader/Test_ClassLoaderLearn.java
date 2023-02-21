package org.example.learnclassloader;


public class Test_ClassLoaderLearn {
    public static void main(String[] args) throws ClassNotFoundException {
        // 类加载器 Boostrap 用C实现，没有java类对应，所以返回空值
        System.out.println(((String.class.getClassLoader())));
        // 类加载器 Boostrap
        System.out.println(((sun.awt.HKSCS.class.getClassLoader())));
        // Extension Loader
        System.out.println(((sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader())));

        // App Loader
        // 使用loadClass方法将class加载进内存
        // 类似于类加载器
        System.out.println(((Test_ClassLoaderLearn.class.getClassLoader().loadClass("org.example.learnclassloader.Test_ClassLoaderLearn"))));

        // 自定义加载器 。。。
    }
}
