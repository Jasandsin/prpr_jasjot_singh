package datetime;

public class FormalDateTimeFormat implements DateTimeFormat {

    @Override
    public String formatDate(int year, int month, int day) {
        return String.format("%02d.%02d.%04d", day, month, year);
    }

    @Override
    public String formatTime(int hour, int minute) {
        return String.format("%02d:%02d", hour, minute);
    }
}
