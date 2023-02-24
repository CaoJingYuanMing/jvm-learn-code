package org.example.learnclassloader;

public class Test_Compiler_Exe {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            m();
        }

        long start = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++) {
            m();
        }
        long end = System.currentTimeMillis();

        System.out.println(String.format("执行时间为：%d", end - start));

    }

    private static void m() {
        for (long i = 1; i < 100000; i++) {
            long j = i % 3;
        }
    }
}
