package ru.gonchar.time;

/**
 * Класс периода
 */
public class Period extends Time24 {

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
    public Period(AbstractTime start, AbstractTime end) {
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
}
