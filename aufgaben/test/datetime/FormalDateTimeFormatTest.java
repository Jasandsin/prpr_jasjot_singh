package datetime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormalDateTimeFormatTest {
    // TODO

    @Test
    void formatDate() {
        var format = new FormalDateTimeFormat();

        assertEquals("24.06.2024", format.formatDate(2024, 6, 24));
        assertEquals("01.01.2025", format.formatDate(2025, 1, 1));
    }

    @Test
    void formatTime() {
        var format = new FormalDateTimeFormat();

        assertEquals("09:00", format.formatTime(9, 0));
        assertEquals("18:30", format.formatTime(18, 30));
    }

}
