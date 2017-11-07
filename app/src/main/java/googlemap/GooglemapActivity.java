package googlemap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.root.otpex2.R;

import brighton.BrightonActivity;
import speak.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class GooglemapActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlemap);
        Intent gmap = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
        startActivity(gmap);
    }
    public void backgooglemap(View view)
    {
        Intent intent = new Intent(GooglemapActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
}
