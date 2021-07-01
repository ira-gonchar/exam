package org.gonchar.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Time12Test {

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
}
