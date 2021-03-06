package gpsoff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.root.otpex2.R;

import java.io.IOException;

import chrome.ChromeActivity;
import speak.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class GpsoffActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpsoff);
        Process proc = null;
        try {
            proc = Runtime.getRuntime().exec(new String[]{"su",
                    "pm grant com.imran.mycloud.mytest android.permission.WRITE_SECURE_SETTINGS",
                    "settings get secure location_providers_disabled"});
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            proc.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void backgpsoff(View view)
    {
        Intent intent = new Intent(GpsoffActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
}
