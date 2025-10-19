package cc.hamzaelmarjani.console;

import java.util.Scanner;

public class ConsoleRead<T> {
    Scanner scanner;
    Class<T> type;

    public ConsoleRead(Class<T> type) {
        scanner = new Scanner(System.in);
        this.type = type;
    }

    public T parse(String title) {
        System.out.print(title);
        String input = scanner.nextLine();

        if (type == Short.class) {
            return type.cast(Short.parseShort(input));
        } else if (type == Integer.class) {
            return type.cast(Integer.parseInt(input));
        } else if (type == Double.class) {
            return type.cast(Double.parseDouble(input));
        } else if (type == Float.class) {
            return type.cast(Float.parseFloat(input));
        } else if (type == Long.class) {
            return type.cast(Long.parseLong(input));
        } else {
            return type.cast(input);
        }
    }
}
