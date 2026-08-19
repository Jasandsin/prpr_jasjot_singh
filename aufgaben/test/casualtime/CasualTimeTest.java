package casualtime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CasualTimeTest {

    @Test
    void sharpSimple() {
        assertEquals("1 o'clock", CasualTime.convertToCasual("01:00"));
        assertEquals("2 o'clock", CasualTime.convertToCasual("02:00"));
        assertEquals("9 o'clock", CasualTime.convertToCasual("09:00"));
        assertEquals("11 o'clock", CasualTime.convertToCasual("11:00"));
        assertEquals("12 o'clock", CasualTime.convertToCasual("12:00"));
    }

    @Test
    void sharp() {
        assertEquals("1 o'clock", CasualTime.convertToCasual("13:00"));
        assertEquals("2 o'clock", CasualTime.convertToCasual("14:00"));
        assertEquals("6 o'clock", CasualTime.convertToCasual("18:00"));
        assertEquals("11 o'clock", CasualTime.convertToCasual("23:00"));
        assertEquals("12 o'clock", CasualTime.convertToCasual("00:00"));
    }

    @Test
    void half() {
        assertEquals("half past 11", CasualTime.convertToCasual("11:30"));
        assertEquals("half past 11", CasualTime.convertToCasual("23:30"));
        assertEquals("half past 1", CasualTime.convertToCasual("01:30"));
        assertEquals("half past 1", CasualTime.convertToCasual("13:30"));
        assertEquals("half past 12", CasualTime.convertToCasual("00:30"));
        assertEquals("half past 12", CasualTime.convertToCasual("12:30"));
    }

    @Test
    void past(){
        assertEquals("20 past 4", CasualTime.convertToCasual("04:20"));
        assertEquals("20 past 4", CasualTime.convertToCasual("16:20"));
        assertEquals("25 past 9", CasualTime.convertToCasual("09:25"));
        assertEquals("25 past 9", CasualTime.convertToCasual("21:25"));
        assertEquals("28 past 11", CasualTime.convertToCasual("23:28"));
    }

    @Test
    void minutesTo(){
        assertEquals("20 minutes to 10", CasualTime.convertToCasual("09:40"));
        assertEquals("20 minutes to 10", CasualTime.convertToCasual("21:40"));
        assertEquals("10 minutes to 10", CasualTime.convertToCasual("09:50"));
        assertEquals("10 minutes to 10", CasualTime.convertToCasual("21:50"));
        assertEquals("5 minutes to 10", CasualTime.convertToCasual("09:55"));
        assertEquals("18 minutes to 10", CasualTime.convertToCasual("09:42"));
        assertEquals("11 minutes to 6", CasualTime.convertToCasual("17:49"));
    }

    @Test
    void quarter(){
        assertEquals("quarter to 10", CasualTime.convertToCasual("09:45"));
        assertEquals("quarter to 10", CasualTime.convertToCasual("21:45"));
        assertEquals("quarter to 1", CasualTime.convertToCasual("12:45"));
        assertEquals("quarter to 3", CasualTime.convertToCasual("14:45"));
        assertEquals("quarter past 1", CasualTime.convertToCasual("01:15"));
        assertEquals("quarter past 1", CasualTime.convertToCasual("13:15"));
    }

    @Test
    void singularMinute(){
        assertEquals("1 minute to 1", CasualTime.convertToCasual("00:59"));
        assertEquals("1 minute to 1", CasualTime.convertToCasual("12:59"));
        assertEquals("1 minute past 12", CasualTime.convertToCasual("00:01"));
        assertEquals("1 minute past 1", CasualTime.convertToCasual("13:01"));
    }

    @Test
    void invalidInputs() {
        assertEquals("Invalid input. The hours are from 0 to 23!", CasualTime.convertToCasual("24:00"));
        assertEquals("Invalid input. The minutes are from 0-59!", CasualTime.convertToCasual("12:60"));
        assertEquals("Invalid Input try again!", CasualTime.convertToCasual("ab:cd"));
        assertEquals("Invalid Input try again!", CasualTime.convertToCasual("df"));
        assertEquals("Input empty", CasualTime.convertToCasual(""));
        assertEquals("Please include hours and minutes", CasualTime.convertToCasual("123"));
        assertEquals("Please include hours and minutes", CasualTime.convertToCasual("123:"));
        assertEquals("Please include hours and minutes", CasualTime.convertToCasual(":234"));
    }

}
