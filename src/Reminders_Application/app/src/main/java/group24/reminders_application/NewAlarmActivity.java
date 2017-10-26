package group24.reminders_application;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class NewAlarmActivity extends AppCompatActivity {

    private TextView timeTextView;
    private EditText createMessageET;
    private Button saveBtn;
    private Button createMsgBtn;
    private Calendar cal;
    private TimePicker timePicker;
    private int year, month, day, hour, minute;
    private String date;
    private int[] timeArray = new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);
        timeTextView = (TextView) findViewById(R.id.newAlarmTextView);
        createMessageET = (EditText) findViewById(R.id.msgET);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        createMsgBtn = (Button) findViewById(R.id.msgBtn);

        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        // Default display will be current time
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        date = year + "-" + month + "-" + day;

        // Running the time picker
        setTime(new View(this));

    }

    public void msg(View v){
        if (timeTextView != null) {
            showAlarm(date, hour, minute, createMessageET.getText().toString());
        }
    }

    public void save(View v){
        Intent intent = new Intent(NewAlarmActivity.this, MainActivity.class);
        intent.putExtra("alarmMsg", timeTextView.getText().toString());
        startActivity(intent);
    }

    @SuppressWarnings("deprecation")
    public void setTime(View v){
        showDialog(99);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Dialog onCreateDialog(int id){
        if (id == 99){
            return new TimePickerDialog(this, timeListener, hour, minute,
                    android.text.format.DateFormat.is24HourFormat(this));
        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker tp, int hour, int minute) {
            timeArray[0] = hour;
            timeArray[1] = minute;
            // Setting text to display current alarm times
            showAlarm(date, hour, minute, "");
        }
    };

    private void showAlarm(String date, int hour, int minute, String msg){
        timeTextView.setText(new StringBuilder().append("New Alarm\nDate: " + date + "\nTime: " + hour + ":" + minute + "\nMessage: " + msg));

    }

}
