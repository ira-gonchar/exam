package org.gonchar.time;

/**
 * Класс периода
 */
public class Period extends Unit {

	/**
	 * Конструктор по строке
	 */
	public Period(String str) {
		super(str);
	}

	/**
	 * Конструктор по величинам
	 */
	public Period(int hour, int min, int sec, int msec) {
		super(hour, min, sec, msec);
	}

	/**
	 * Конструктор по временам
	 */
	public Period(Time start, Time end) {
		int t1ms = start.msec + start.sec * 1000 + start.min * 60 * 1000 + start.hour * 60 * 60 * 1000;
		int t2ms = end.msec + end.sec * 1000 + end.min * 60 * 1000 + end.hour * 60 * 60 * 1000;

		int d = t2ms - t1ms; // сначала вычисляем количество миллисекунд разницы в общем
		hour = d / (1000 * 60 * 60); // потом часов, минут, секунд и миллисекунд
		d = d % (1000 * 60 * 60);
		min = d / (1000 * 60);
		d = d % (1000 * 60);
		sec = d / 1000;
		msec = d % 1000;
	}

	/**
	 * Отнять период
	 */
	public Period minus(final Period period) {
		// TODO удалить дубликаты
		int t1ms = period.msec + period.sec * 1000 + period.min * 60 * 1000 + period.hour * 60 * 60 * 1000;
		int t2ms = this.msec + this.sec * 1000 + this.min * 60 * 1000 + this.hour * 60 * 60 * 1000;

		int d = t2ms - t1ms; // сначала вычисляем количество миллисекунд разницы в общем
		hour = d / (1000 * 60 * 60); // потом часов, минут, секунд и миллисекунд
		d = d % (1000 * 60 * 60);
		min = d / (1000 * 60);
		d = d % (1000 * 60);
		sec = d / 1000;
		msec = d % 1000;

		return new Period(hour, min, sec, msec);
	}
}
