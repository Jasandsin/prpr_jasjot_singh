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
            System.out.println(casual + ".");

            System.out.print("> ");
            input = scanner.nextLine();
        }
    }

    public static String convertToCasual(String formal) {


        if (formal.isEmpty()) {
            return "Input empty";
        }
        if (!formal.matches("[0-9:]+")) {
            return "Invalid Input try again!";
        }

        //String input converting to numbers
        String[] parts = formal.split(":");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return "Please include hours and minutes";
        }
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        //Check if hours in 0-23 range and minutes is in 0-59 range
        if (hour < 0 || hour > 23) {
            return ("Invalid input. The hours are from 0 to 23!");
        }
        if (minute < 0 || minute > 59) {
            return ("Invalid input. The minutes are from 0-59!");
        }

        int hour12 = convertTo12Hour(hour);
        int nextHour = convertTo12Hour((hour + 1) % 24);

        if (minute == 0) {
            return hour12 + " o'clock";
        }

        if (minute == 30) {
            return "half past " + hour12;
        }

        if (minute == 45) {
            return "quarter to " + nextHour;
        }

            if (minute == 15) {
            return "quarter past " + hour12;
        }

        //Singular 1 minute past&to
        if (minute == 1) {
            return "1 minute past " + hour12;
        }
        if (minute == 59) {
            return "1 minute to " + nextHour;
        }

        //Minutes past&to without half and quarter
        if (minute < 30) {
            return minute + " past " + hour12;
        }
        return (60 - minute) + " minutes to " + nextHour;

    }

    // Convert 24-hour format to 12-hour format
    private static int convertTo12Hour(int hour24) {
        int hour12 = hour24 % 12;
        return hour12 == 0 ? 12 : hour12;
    }



}

