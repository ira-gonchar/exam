package org.gonchar.time;

public class Time12 extends AbstractTime {
    /**
     * Конструктор по величинам
     */
    public Time12(int hour, int min, int sec, int msec) {
        super(hour, min, sec, msec);
    }

    public Time12(String str) {
        super(12, 34, 35,567); // TODO реализовать
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
