package calculator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.root.otpex2.R;

import java.util.Locale;

import brighton.BrightonActivity;
import speak.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class CalculatorActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);mTTS = new TextToSpeech(this, this);
        Intent calculator = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.popupcalculator");
        startActivity(calculator);
    }
    public void backcalculator(View view)
    {
        Intent intent = new Intent(CalculatorActivity.this, SpeakActivity.class);
        startActivity(intent);
    } @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("calculator application started....................", TextToSpeech.QUEUE_ADD, null, null);
    }

}
