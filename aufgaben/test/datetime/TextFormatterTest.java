package datetime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextFormatterTest {
    @Test
    void formatDateFormal() {
        var formatter = new TextFormatter(new FormalDateTimeFormat());
        assertEquals("Heute ist der 24.06.2024.",
            formatter.format("Heute ist der ${ 2024 06 24 }."));
        assertEquals("Mein Geburtstag ist am 10.05.2000.",
            formatter.format("Mein Geburtstag ist am ${ 2000 05 10 }."));
        assertEquals("Das Treffen beginnt um 09:00.",
            formatter.format("Das Treffen beginnt um ${ 09 00 }."));
    }

    @Test
    void formatMultiplePlaceholders() {
        var formatter = new TextFormatter(new FormalDateTimeFormat());

        assertEquals("Am 24.06.2024 findet das Kickoff für das Modul statt. " +
                "Es beginnt um 09:00 und dauert bis 14:30 (spätestens). " +
                "Die Abgabefrist für das Projekt ist am 01.09.1999 um Mitternacht.",
            formatter.format("Am ${ 2024 06 24 } findet das Kickoff für das Modul statt. " +
                "Es beginnt um ${ 09 00 } und dauert bis ${ 14 30 } (spätestens). " +
                "Die Abgabefrist für das Projekt ist am ${ 1999 09 01 } um Mitternacht."));

        assertEquals("Am 24.06.2024 findet das Kickoff für das Modul statt. " +
                "Es beginnt um 09:00 und dauert bis 14:30 (spätestens). " +
                "Die Abgabefrist für das Projekt ist am 01.09.2024 um Mitternacht.",
            formatter.format("Am ${ 2024 06 24 } findet das Kickoff für das Modul statt. " +
                "Es beginnt um ${ 09 00 } und dauert bis ${ 14 30 } (spätestens). " +
                "Die Abgabefrist für das Projekt ist am ${ 2024 09 01 } um Mitternacht."));
    }
}

