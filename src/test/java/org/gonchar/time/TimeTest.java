package org.gonchar.time;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class TimeTest {

    @Test
    public void testGetters() {
        Time24 time = new Time24("23:13:45.727");

        assertEquals(23, time.getHour());
        assertEquals(13, time.getMin());
        assertEquals(45, time.getSec());
        assertEquals(727, time.getMsec());
    }

    @Test
    public void test24string() {
        Time24 time = new Time24(3, 5, 7, 4);

        String time24string = time.getTime();

        assertEquals("03:05:07.004", time24string);
    }

    @Test
    public void test12stringPM() {
        Time12 time = new Time12("11:02:03.052 pm");

        String time12string = time.getTime();

        assertEquals("11:02:03.052 pm", time12string);
    }

    @Test
    public void test12stringAM() {
        Time12 time = new Time12("11:02:03.052 am");

        String time12string = time.getTime();

        assertEquals("11:02:03.052 am", time12string);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailedFormat() {
        new Time24("26:02:03.052");
    }
}
