package wimble.hashtag.hashtagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class OptionActivity extends AppCompatActivity implements View.OnClickListener {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_option);


        FrameLayout native_ad = (FrameLayout) findViewById(R.id.native_ad);


        LinearLayout ll_qlbanner = (LinearLayout) findViewById(R.id.ll_qlbanner);
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_choose) {
            Intent intent = new Intent(OptionActivity.this, Choose_Hashtags_Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            OptionActivity.this.startActivity(intent);
        } else if (id == R.id.btn_generate) {
            Intent intent1 = new Intent(OptionActivity.this, Generate_Hashtag_Activity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            OptionActivity.this.startActivity(intent1);
        }
    }

    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }

}