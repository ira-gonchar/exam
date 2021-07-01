package org.gonchar.time;

import static org.junit.Assert.assertEquals;

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

		String time24string = time.get24string();

		assertEquals("03:05:07.004", time24string);
	}

	@Test
	public void test12string() {
		Time time = new Time("23:02:03.052");

		String time12string = time.get12string();

		assertEquals("11:02:03.052 pm", time12string);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailedFormat() {
		new Time24("26:02:03.052");
	}
}
