package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiveNextDateTest {

    @Test
    public void testInvalidDayNegative() {
        GiveNextDate date = new GiveNextDate(5, -1, 1900);
        assertEquals("invalid Input Date", date.run());
    }

    @Test
    public void testInvalidDayZero() {
        GiveNextDate date = new GiveNextDate(5, 0, 1900);
        assertEquals("invalid Input Date", date.run());
    }

    @Test
    public void testInvalidMonthNegative() {
        GiveNextDate date = new GiveNextDate(-1, 15, 1900);
        assertEquals("invalid Input Date", date.run());
    }

    @Test
    public void testInvalidMonthZero() {
        GiveNextDate date = new GiveNextDate(0, 15, 1900);
        assertEquals("invalid Input Date", date.run());
    }

    @Test
    public void testInvalidMonthTooLarge() {
        GiveNextDate date = new GiveNextDate(13, 15, 1900);
        assertEquals("invalid Input Date", date.run());
    }

    @Test
    public void testInvalidYearTooSmall() {
        GiveNextDate date = new GiveNextDate(5, 15, 1800);
        assertEquals("invalid Input Date", date.run());
    }

    @Test
    public void testInvalidYearTooLarge() {
        GiveNextDate date = new GiveNextDate(5, 15, 2022);
        assertEquals("invalid Input Date", date.run());
    }

    @Test
    public void testThirtyOneDayMonth_MidDay() {
        GiveNextDate date = new GiveNextDate(1, 15, 1900);
        assertEquals("1/16/1900", date.run());
    }

    @Test
    public void testThirtyOneDayMonth_LastDay() {
        GiveNextDate date = new GiveNextDate(1, 31, 1900);
        assertEquals("2/1/1900", date.run());
    }

    @Test
    public void testThirtyDayMonth_MidDay() {
        GiveNextDate date = new GiveNextDate(4, 15, 1900);
        assertEquals("4/16/1900", date.run());
    }

    @Test
    public void testThirtyDayMonth_LastDay() {
        GiveNextDate date = new GiveNextDate(4, 30, 1900);
        assertEquals("5/1/1900", date.run());
    }

    @Test
    public void testThirtyDayMonth_InvalidDay() {
        GiveNextDate date = new GiveNextDate(4, 31, 1900);
        assertEquals("Invalid Input Date", date.run());
    }

    @Test
    public void testDecember_MidDay() {
        GiveNextDate date = new GiveNextDate(12, 15, 1900);
        assertEquals("12/16/1900", date.run());
    }

    @Test
    public void testDecember_LastDay_ValidNextYear() {
        GiveNextDate date = new GiveNextDate(12, 31, 1900);
        assertEquals("1/1/1901", date.run());
    }

    @Test
    public void testDecember_LastDay_InvalidNextYear() {
        GiveNextDate date = new GiveNextDate(12, 31, 2021);
        assertEquals("Invalid Next Year", date.run());
    }

    @Test
    public void testFebruary_MidDay() {
        GiveNextDate date = new GiveNextDate(2, 15, 1900);
        assertEquals("2/16/1900", date.run());
    }

    @Test
    public void testFebruary_28th_NonLeapYear() {
        // 1900 is not a leap year (century year, not div by 400)
        GiveNextDate date = new GiveNextDate(2, 28, 1900);
        assertEquals("3/1/1900", date.run());
    }

    @Test
    public void testFebruary_28th_LeapYear() {
        // 2000 is a leap year (century year, div by 400)
        GiveNextDate date = new GiveNextDate(2, 28, 2000);
        assertEquals("2/29/2000", date.run());
    }

    @Test
    public void testFebruary_29th_LeapYear() {
        // 2004 is a leap year (div by 4, not century)
        GiveNextDate date = new GiveNextDate(2, 29, 2004);
        assertEquals("3/1/2004", date.run());
    }

    @Test
    public void testFebruary_29th_NonLeapYear() {
        // 1900 is not a leap year
        GiveNextDate date = new GiveNextDate(2, 29, 1900);
        assertEquals("Invalid Input Date", date.run());
    }

    @Test
    public void testFebruary_InvalidDay() {
        GiveNextDate date = new GiveNextDate(2, 30, 2000);
        assertEquals("Invalid Input Date", date.run());
    }

    @Test
    public void testMonthNotCovered() {
        // July (7) is not included in any of the if/else statements
        GiveNextDate date = new GiveNextDate(7, 15, 1900);
        assertEquals("7/16/1900", date.run());
    }
}
