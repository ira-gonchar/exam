package org.gonchar.time;

public class Time12 extends AbstractTime {
    /**
     * Конструктор по величинам
     */
    public Time12(int hour, int min, int sec, int msec) {
        super(hour, min, sec, msec);
    }


    public Time12(String str) {
        hour = Integer.parseInt(str.substring(0, 2));
        min = Integer.parseInt(str.substring(3, 5));
        sec = Integer.parseInt(str.substring(6, 8));
        msec = Integer.parseInt(str.substring(9, 12));
        String dh = str.substring(13);
        if (dh.equalsIgnoreCase("pm")) {
            hour = hour + 12;
        }
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
