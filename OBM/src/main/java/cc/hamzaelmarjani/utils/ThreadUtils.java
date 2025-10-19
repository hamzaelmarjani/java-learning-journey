package cc.hamzaelmarjani.utils;

public class ThreadUtils {
    public static void sleep(long mill)  {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
