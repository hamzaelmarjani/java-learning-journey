package cc.hamzaelmarjani.utils;

public class ConsoleUtils {
    public static void clear() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                return;
            }
            Runtime.getRuntime().exec(new String[]{"clear"});
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
