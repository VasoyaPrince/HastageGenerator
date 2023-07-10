package wimble.hashtag.hashtagram.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import wimble.hashtag.hashtagram.R;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        nextIntent();
//        if (!AppCommon.CheckNet(this)) {
//            new Handler().postDelayed(new Runnable() {
//                public void run() {
//                    nextIntent();
//                }
//            }, 2000);
//        }
    }


    @Override
    public void onBackPressed() {
    }


    public void nextIntent() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_Activity.this, SplashStart_Activity.class);
                i.putExtra("fromSplash", true);
                startActivity(i);
                finish();
            }
        }, 2100);
    }

}