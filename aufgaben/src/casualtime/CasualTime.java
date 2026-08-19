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


        if (formal == null || formal.isEmpty()) {return "Input empty";}
        if (!formal.matches("[0-9:]+")) {return "Invalid Input try again!";}

        //String input converting to numbers
        String[] parts = formal.split(":");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return "Please include hours and minutes";
        }
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        //Check if hours in 0-23 range and minutes is in 0-59 range
        if (hour < 0 || hour > 23) { return ("Invalid input. The hours are from 0 to 23!");}
        if (minute < 0 || minute > 59) { return ("Invalid input. The minutes are from 0-59!");}

        // 0-12 not 0-24
        int hour12 = hour % 12;
        if(hour12 == 0){
            hour12 = 12;
        }

        int nextHour = hour12 + 1;
        if(nextHour == 13){
            nextHour = 1;
        }

        //Time wtihout minutes
        if(minute == 0){
            return hour12 + " o'clock";
        }

        //30 minutes
        if(minute == 30){
            return "half past " + hour12;
        }

        //quarter past&to
        if(minute == 45){
            return "quarter to " + nextHour;
        } else if (minute == 15){
            return "quarter past " + hour12;
        }

        // minutes past&to
        if(minute < 30 && minute > 1){
            return minute + " past " + hour12;
        } else if (minute > 30 && minute < 59) {
            return (60-minute) + " minutes to " + nextHour;
            // Singular 1 minute to or past
        } else if (minute == 1){
            return minute + " minute past " + hour12;
        } else {
            return (60-minute) + " minute to " + nextHour;
        }
    }
}
