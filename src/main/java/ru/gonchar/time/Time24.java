package ru.gonchar.time;

public class Time24 extends AbstractTime {

    protected Time24() {
    }

    /**
     * Конструктор по величинам
     */
    public Time24(int hour, int min, int sec, int msec) {
        super(hour, min, sec, msec);
    }

    /**
     * Конструктор по строке
     */
    public Time24(String str) {
        super(
                Integer.parseInt(str.substring(0, 2)),
                Integer.parseInt(str.substring(3, 5)),
                Integer.parseInt(str.substring(6, 8)),
                Integer.parseInt(str.substring(9))
        );
    }

    @Override
    public String getTime() {
        return getTwoDigits(hour) + ":" + getTwoDigits(min) + ":" + getTwoDigits(sec) + "." + getThreeDigits(msec);
    }
}
