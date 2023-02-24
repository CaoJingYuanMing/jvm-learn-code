package org.example.learnclassloader;

public class Test_Lazy_Loading {
    public static void main(String[] args) {
        P p = new P();
        System.out.println(p.i);
    }

    public static class P {
        final static int i = 8;
        static int j = 9 ;
        static {
            System.out.println("P");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}

