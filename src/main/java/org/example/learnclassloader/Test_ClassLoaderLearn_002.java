package org.example.learnclassloader;

public class Test_ClassLoaderLearn_002 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Test_ClassLoaderLearn_002.class.getClassLoader().loadClass("org.example.learnclassloader.Test_ClassLoaderLearn_002");
        String name = aClass.getName();
        System.out.println(name);
    }
}
