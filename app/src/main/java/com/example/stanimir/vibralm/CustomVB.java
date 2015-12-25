package com.example.stanimir.vibralm;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

public class CustomVB extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_vb);
        TimePicker myTime = (TimePicker) findViewById(R.id.customVBtimePickerStart);
        myTime.setIs24HourView(true);
        myTime = (TimePicker) findViewById(R.id.customVBtimePickerEnd);
        myTime.setIs24HourView(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_custom_vb, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setCustomVB(View view){

        // Get time for start and end
        TimePicker vbTime = (TimePicker) findViewById(R.id.customVBtimePickerStart);
        vbTime.clearFocus();
        int hoursStart = vbTime.getCurrentHour();
        int minutesStart = vbTime.getCurrentMinute();
        int hoursEnd = vbTime.getCurrentHour();
        int minutesEnd = vbTime.getCurrentMinute();

        // Get current Volume Level
        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int currentVolume = audio.getStreamVolume(AudioManager.STREAM_RING);

        //Set to vibration
        audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    }

}
