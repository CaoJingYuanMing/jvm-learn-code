package org.example.learnclassloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("/Users/banqiongyue/hand/adidas-ecp/code/practice-code-source/test-jvm-code-parctice/target/classes");
        Class<?> aClass = myClassLoader.findClass("org.example.learnclassloader.TestClass");
        Object object = aClass.newInstance();
        Method hello = aClass.getDeclaredMethod("hello");
        hello.invoke(object);
    }
}
