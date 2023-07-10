package wimble.hashtag.hashtagram.splash;

import android.os.StrictMode;

import androidx.multidex.MultiDexApplication;



public class MyApplication extends MultiDexApplication {


    public void onCreate() {
        super.onCreate();





        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}