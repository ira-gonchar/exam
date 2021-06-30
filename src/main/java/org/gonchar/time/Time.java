package org.gonchar.time;

/**
 * Класс текущего времени
 */
public class Time extends Unit {

	/**
	 * Конструктор по величинам
	 */
	public Time(final int hour, final int min, final int sec, final int msec) {
		super(hour, min, sec, msec);
	}

	/**
	 * Конструктор по строке
	 */
	public Time(final String str) {
		super(str);
	}

	/**
	 * Получить строку в 12-часовом формате
	 */
	public String get12string() {
		int h = hour;
		String dh = "am";
		if (hour > 12) {
			h = hour % 12;
			dh = "pm";
		}
		return getTwoDigits(h) + ":" + getTwoDigits(min) + ":" + getTwoDigits(sec) + "." + getThreeDigits(msec) + ' ' + dh;
	}
}
