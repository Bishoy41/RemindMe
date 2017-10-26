package group24.reminders_application;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/*
 * Alarm object storing date, time and message
 */
public class Alarm {

    private String msg;
    private String date;
    private String time;

    public Alarm (Calendar date, String msg){
        this.msg = msg;
        String cal = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date.getTime());
        this.date = cal.substring(0,10);
        this.time = cal.substring(11);
    }

    // Retrieves current message from the alarm
    public String getMsg(){ return this.msg; }

    // Returns date from the alarm in yyyy-MM-dd form
    public String getDate(){ return this.date; }

    // Returns time from the alarm in HH:mm form
    public String getTime(){ return this.time; }
}
