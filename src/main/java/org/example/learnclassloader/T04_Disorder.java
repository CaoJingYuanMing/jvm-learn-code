package org.example.learnclassloader;

/**
 * 乱序排序的证明
 * 如果顺序执行，执行顺序可能是
 *
 * 1 a=1 x=b b=1 y=a，此时 x=0，y=1
 *
 * 2 a=1 b=1 x=b y=a，此时 x=1，y=1
 *
 * 3 b=1 y=a a=1 x=b，此时 x=1，y=0
 *
 * 如果是乱序执行，比如说执行顺序如下
 *
 * x=b y=a a=1 b=1，此时 x=0，b=0
 *
 * 如果结果出现 x=0，b=0，证明cpu乱序执行
 */
public class T04_Disorder {
    private static int a = 0, b = 0;
    private static int x = 0, y = 0;
    public static void main(String[] args) throws Exception {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    x = a;
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            String result = "第" + i + "次(" + x + "," + y + ")";
            if (x == 0 && y == 0) {
                System.out.println(result);
            } else {
            }
        }
    }
}
