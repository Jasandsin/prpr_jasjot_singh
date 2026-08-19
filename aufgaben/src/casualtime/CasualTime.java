package casualtime;

import java.util.Scanner;

public class CasualTime {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Enter a time in HH:MM format (or 'quit'):");

        System.out.print("> ");
        var input = scanner.nextLine();

        while (!input.equals("quit")) {
            var casual = convertToCasual(input);
            System.out.println("It's " + casual + ".");

            System.out.print("> ");
            input = scanner.nextLine();
        }
    }

    public static String convertToCasual(String formal) {

        //String eingabe convertieren zu Zahlen
        String[] parts = formal.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        // 0-12 nicht 0-24
        int hour12 = hour % 12;
        if(hour12 == 0){
            hour12 = 12;
        }

        //Zeiten ohne minute
        if(minute == 0){
            return hour12 + " o'clock";
        }


        // TODO: Zeitangabe in Parameter 'formal' in Stunde und Minute
        //  aufteilen und anschliessend in Umgangssprache umwandeln.
        //  Tipp: Methoden 'split' von String und 'Integer.parseInt'.

        return "TODO";
    }
}
