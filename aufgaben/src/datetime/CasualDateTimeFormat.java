package datetime;

public class CasualDateTimeFormat implements DateTimeFormat {
    @Override
    public String formatDate(int year, int month, int day) {
        String[] months = {
            "Januar", "Februar", "März", "April",
            "Mai", "Juni", "Juli", "August",
            "September", "Oktober", "November", "Dezember"
        };

        return day + " " + months[month - 1] + " " + (year % 100);
    }

    @Override
    public String formatTime(int hour, int minute) {
        return hour + " Uhr";
    }
}
