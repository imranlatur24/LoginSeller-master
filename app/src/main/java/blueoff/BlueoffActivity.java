package blueoff;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.root.otpex2.R;

import java.util.Locale;

import blueon.BlueonActivity;
import chrome.ChromeActivity;
import speak.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class BlueoffActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blueoff);
        mTTS = new TextToSpeech(this, this);
        BluetoothAdapter btAdapter;
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            Toast.makeText(getApplicationContext(), "Device does not support bluetooth", Toast.LENGTH_LONG).show();
        } else {
            if (!btAdapter.disable()) {
                btAdapter.disable();
                Toast.makeText(getApplicationContext(), "Bluetooth switched OFF", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void backblueoff(View view)
    {
        Intent intent = new Intent(BlueoffActivity.this, SpeakActivity.class);
        startActivity(intent);
    } @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Bluetooth turned off.....................", TextToSpeech.QUEUE_ADD, null, null);
    }

}
