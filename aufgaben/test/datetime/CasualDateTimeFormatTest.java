package datetime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CasualDateTimeFormatTest {


    @Test
    void formatDate() {
        var format = new CasualDateTimeFormat();
        assertEquals("24. Juni '24", format.formatDate(2024, 6, 24));
        assertEquals("1. September '24", format.formatDate(2024, 9, 1));
        assertEquals("24. Juni 1999", format.formatDate(1999, 6, 24));
        assertEquals("24. Juni 925", format.formatDate(925, 6, 24));
    }

    @Test
    void formatTime() {
        var format = new CasualDateTimeFormat();
        assertEquals("9 Uhr", format.formatTime(9, 0));
        assertEquals("14 Uhr 30", format.formatTime(14, 30));
    }

    @Test
    void formatCasual() {
        var formatter = new TextFormatter(new CasualDateTimeFormat());
        assertEquals("Am 24. Juni '24 findet das Kickoff für das Modul statt. " +
                "Es beginnt um 9 Uhr und dauert bis 14 Uhr 30 (spätestens). " +
                "Die Abgabefrist für das Projekt ist am 1. September '24 um Mitternacht.",
            formatter.format("Am ${ 2024 06 24 } findet das Kickoff für das Modul statt. " +
                "Es beginnt um ${ 09 00 } und dauert bis ${ 14 30 } (spätestens). " +
                "Die Abgabefrist für das Projekt ist am ${ 2024 09 01 } um Mitternacht."));

        assertEquals("Am 24. Juni '24 findet das Kickoff für das Modul statt. " +
                "Es beginnt um 9 Uhr und dauert bis 14 Uhr 30 (spätestens). " +
                "Die Abgabefrist für das Projekt ist am 1. September 1999 um Mitternacht.",
            formatter.format("Am ${ 2024 06 24 } findet das Kickoff für das Modul statt. " +
                "Es beginnt um ${ 09 00 } und dauert bis ${ 14 30 } (spätestens). " +
                "Die Abgabefrist für das Projekt ist am ${ 1999 09 01 } um Mitternacht."));
    }


}
