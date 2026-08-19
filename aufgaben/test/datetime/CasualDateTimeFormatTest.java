package datetime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CasualDateTimeFormatTest {
    // TODO
    @Test
    void formatDate() {
        var format = new CasualDateTimeFormat();

        assertEquals("24 Juni 24", format.formatDate(2024, 6, 24));
    }

    @Test
    void formatTime() {
        var format = new CasualDateTimeFormat();

        assertEquals("9 Uhr", format.formatTime(9, 0));
    }
}
