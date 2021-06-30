package org.gonchar.time;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PeriodTest {
	@Test(expected = IllegalArgumentException.class)
	public void testFailedFormat() {
		new Period("52:00:00.000");
	}


	@Test
	public void testGetters() {
		Period period = new Period("23:13:45.727");

		assertEquals(23, period.getHour());
		assertEquals(13, period.getMin());
		assertEquals(45, period.getSec());
		assertEquals(727, period.getMsec());
	}

	@Test
	public void test24string() {
		Period period = new Period(3, 5, 7, 4);

		String period24string = period.get24string();

		assertEquals("03:05:07.004", period24string);
	}

	@Test
	public void testNewPeriod() {
		Time start = new Time("03:04:05.006");
		Time end = new Time("23:54:45.606");
		Period period = new Period(start, end);

		final String period24string = period.get24string();

		assertEquals("20:50:40.600", period24string);
	}

	@Test
	public void testMinusPeriod() {
		Period period = new Period("03:00:00.000");
		Period period2 = new Period("02:00:00.000");

		Period result = period.minus(period2);

		assertEquals("01:00:00.000", result.get24string());
	}

	@Test
	public void testMinusPeriod2() {
		Period period = new Period("12:45:57.123");
		Period period2 = new Period("07:55:59.412");

		Period result = period.minus(period2);

		assertEquals("04:49:57.711", result.get24string());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinusPeriod3() {
		Period period = new Period("12:45:57.123");
		Period period2 = new Period("23:55:59.412");

		period.minus(period2);
	}
}
