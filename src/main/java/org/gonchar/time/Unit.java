package org.gonchar.time;

/**
 * Абстрактный класс
 */
public abstract class Unit {

	protected int hour;
	protected int min;
	protected int sec;
	protected int msec;

	protected Unit() {
	}

	/**
	 * Конструктор по величинам
	 */
	public Unit(int hour, int min, int sec, int msec) {
		if (hour > 23 || hour < 0
			|| min > 59 || min < 0
			|| sec > 59 || sec < 0
			|| msec > 999 || msec < 0) {
			throw new IllegalArgumentException();
		}
		this.hour = hour;
		this.min = min;
		this.sec = sec;
		this.msec = msec;
	}

	/**
	 * Конструктор по строке
	 */
	public Unit(String str) {
		this(
			Integer.parseInt(str.substring(0, 2)),
			Integer.parseInt(str.substring(3, 5)),
			Integer.parseInt(str.substring(6, 8)),
			Integer.parseInt(str.substring(9))
		);
	}

	/**
	 * Получить строку в 24-часовом формате
	 */
	public String get24string() {
		return getTwoDigits(hour) + ":" + getTwoDigits(min) + ":" + getTwoDigits(sec) + "." + getThreeDigits(msec);
	}

	protected String getTwoDigits(int number) {
		return String.format("%02d", number);
	}

	protected String getThreeDigits(int number) {
		return String.format("%03d", number);
	}

	/**
	 * Получить часы
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Получить минуты
	 */
	public int getMin() {
		return min;
	}

	/**
	 * Получить секунды
	 */
	public int getSec() {
		return sec;
	}

	/**
	 * Получить миллисекунды
	 */
	public int getMsec() {
		return msec;
	}
}
