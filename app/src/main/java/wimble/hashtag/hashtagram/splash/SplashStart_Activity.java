package wimble.hashtag.hashtagram.splash;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;


import wimble.hashtag.hashtagram.OptionActivity;
import wimble.hashtag.hashtagram.R;
import wimble.hashtag.hashtagram.Saved_Hashtag_Activity;

public class SplashStart_Activity extends AppCompatActivity implements View.OnClickListener {
    public static final String ACTION_CLOSE = "ACTION_CLOSE";
    private FirstReceiver firstReceiver;
    private Uri urishare;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashstart);




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkAndRequestPermissions();
        } else {
            checkAndRequestPermissions();
        }

        IntentFilter intentFilter = new IntentFilter(ACTION_CLOSE);
        this.firstReceiver = new FirstReceiver();
        registerReceiver(this.firstReceiver, intentFilter);
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_start) {
            startActivityForResult(new Intent(SplashStart_Activity.this, OptionActivity.class), 101);
        } else if (id == R.id.btn_saved) {
            Intent intent = new Intent(SplashStart_Activity.this, Saved_Hashtag_Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (id == R.id.btn_rate) {
            Uri uri1 = Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName());
            Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri1);
            try {
                startActivity(myAppLinkToMarket);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(SplashStart_Activity.this, "You don't have Google Play installed", Toast.LENGTH_LONG).show();
            }
        } else if (id == R.id.btn_share) {
            Bitmap bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_foreground);
            File f = new File(getExternalCacheDir() + "/image.png");
            try {
                FileOutputStream outStream = new FileOutputStream(f);
                bm.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                outStream.flush();
                outStream.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("image/*");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getPackageName());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                urishare = FileProvider.getUriForFile(SplashStart_Activity.this, "wimble.hashtag.hashtagram" + ".provider", f);
            } else {
                urishare = Uri.fromFile(f);
            }
            shareIntent.putExtra(Intent.EXTRA_STREAM, urishare);
            startActivity(Intent.createChooser(shareIntent, "Share Image using"));
        }
    }

    private boolean checkAndRequestPermissions() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(this, "android.permission.CAMERA");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE");
        ArrayList arrayList = new ArrayList();
        if (checkSelfPermission2 != 0) {
            arrayList.add("android.permission.CAMERA");
        }
        if (checkSelfPermission != 0) {
            arrayList.add("android.permission.READ_PHONE_STATE");
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 1);
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 0) {
            if (i == 1 && iArr.length > 0) {
                int i2 = iArr[0];
            }
        } else if (iArr.length > 0) {
            int i3 = iArr[0];
        }
    }

    class FirstReceiver extends BroadcastReceiver {
        FirstReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Log.e("FirstReceiver", "FirstReceiver");
            if (intent.getAction().equals(ACTION_CLOSE)) {
                finish();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        startActivityForResult(new Intent(SplashStart_Activity.this, Exit_Activity.class), 1010);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 101) {
        }
        if (resultCode == RESULT_OK && requestCode == 1010) {
            finish();
        }
    }

}