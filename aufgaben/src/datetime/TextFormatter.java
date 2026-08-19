package datetime;

import java.util.Scanner;

public class TextFormatter {

    private final DateTimeFormat format;

    public TextFormatter(DateTimeFormat format) {
        this.format = format;
    }

    public String format(String text) {

        if (!text.contains("${")) {
            return text;
        }

        int start = text.indexOf("${");
        int end = text.indexOf("}");

        String placeholder = text.substring(start + 2, end).trim();

        Scanner scanner = new Scanner(placeholder);

        int first = scanner.nextInt();
        int second = scanner.nextInt();

        String formatted;

        if (scanner.hasNextInt()) {
            int third = scanner.nextInt();
            // Drei Zahlen bedeuten: Jahr, Monat, Tag
            formatted = format.formatDate(first, second, third);
        } else {
            // Zwei Zahlen bedeuten: Stunde, Minute
            formatted = format.formatTime(first, second);
        }

        String result = text.substring(0, start)
            + formatted
            + text.substring(end + 1);

        return format(result);
    }

}
