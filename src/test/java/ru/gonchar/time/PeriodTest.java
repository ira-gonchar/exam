package ru.gonchar.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeriodTest {

    @Test(expected = IllegalArgumentException.class)
    public void testFailedFormat() {
        new Period("52:00:00.000");
    }

    @Test
    public void test24string() {
        Period period = new Period(3, 5, 7, 4);

        String period24string = period.getTime();

        assertEquals("03:05:07.004", period24string);
    }

    @Test
    public void testNewPeriod1() {
        Time24 start = new Time24("03:04:05.006");
        Time24 end = new Time24("23:54:45.606");
        Period period = new Period(start, end);

        final String period24string = period.getTime();

        assertEquals("20:50:40.600", period24string);
    }

    @Test
    public void testNewPeriod2() {
        Time12 start = new Time12(3, 4, 5, 6);
        Time12 end = new Time12("11:54:45.606 pm");
        Period period = new Period(start, end);

        final String period24string = period.getTime();

        assertEquals("20:50:40.600", period24string);
    }

    @Test
    public void testNewPeriod3() {
        Time24 start = new Time24("03:04:05.006");
        Time12 end = new Time12("11:54:45.606 pm");
        Period period = new Period(start, end);

        final String period24string = period.getTime();

        assertEquals("20:50:40.600", period24string);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectPeriod() {
        Time12 start = new Time12("11:54:45.606 pm");
        Time24 end = new Time24("03:04:05.006");
        new Period(start, end);
    }

}
