package org.example.learnclassloader;

/**
 * test padding
 */
public class Test_CacheLine_002 {
    private static class TF {
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    /* T独占一个缓存行 */
    private static class T extends TF {
        public volatile long x = 0L;
    }

    public static Test_CacheLine_002.T[] arr = new Test_CacheLine_002.T[2];

    static {
        arr[0] = new Test_CacheLine_002.T();
        arr[1] = new Test_CacheLine_002.T();
    }

    public static void main(String[] args) throws InterruptedException {
        // 开启两个线程同时跑
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10_0000; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10_0000; i++) {
                arr[1].x = i;
            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println((System.nanoTime() - start)/10000);
    }
}
