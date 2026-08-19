package datetime;

public class CasualDateTimeFormat implements DateTimeFormat {
    @Override
    public String formatDate(int year, int month, int day) {
        String[] months = {
            "Januar", "Februar", "März", "April",
            "Mai", "Juni", "Juli", "August",
            "September", "Oktober", "November", "Dezember"
        };

        String formattedYear;
        if (year >= 2000 && year <= 2099) {
            formattedYear = "'" + (year % 100);
        } else {
            formattedYear = Integer.toString(year);
        }

        return day + ". " + months[month - 1] + " " + formattedYear;
    }

    @Override
    public String formatTime(int hour, int minute) {
        if (minute == 0) {
            return hour + " Uhr";
        }
        return hour + " Uhr " + minute;
    }

}
