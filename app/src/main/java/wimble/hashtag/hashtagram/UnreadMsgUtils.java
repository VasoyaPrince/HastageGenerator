package wimble.hashtag.hashtagram;

import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.flyco.roundview.RoundViewDelegate;

public class UnreadMsgUtils {
    public static void show(RoundTextView roundTextView, int i) {
        if (roundTextView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) roundTextView.getLayoutParams();
            DisplayMetrics displayMetrics = roundTextView.getResources().getDisplayMetrics();
            RoundViewDelegate delegate = roundTextView.getDelegate();
            roundTextView.setVisibility(0);
            if (i <= 0) {
                delegate.setStrokeWidth(0);
                roundTextView.setText("");
                layoutParams.width = (int) (displayMetrics.density * 5.0f);
                layoutParams.height = (int) (displayMetrics.density * 5.0f);
                roundTextView.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.height = (int) (displayMetrics.density * 18.0f);
            if (i > 0 && i < 10) {
                layoutParams.width = (int) (displayMetrics.density * 18.0f);
                roundTextView.setText(i + "");
            } else if (i <= 9 || i >= 100) {
                layoutParams.width = -2;
                roundTextView.setPadding((int) (displayMetrics.density * 6.0f), 0, (int) (displayMetrics.density * 6.0f), 0);
                roundTextView.setText("99+");
            } else {
                layoutParams.width = -2;
                roundTextView.setPadding((int) (displayMetrics.density * 6.0f), 0, (int) (displayMetrics.density * 6.0f), 0);
                roundTextView.setText(i + "");
            }
            roundTextView.setLayoutParams(layoutParams);
        }
    }

    public static void setSize(RoundTextView roundTextView, int i) {
        if (roundTextView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) roundTextView.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            roundTextView.setLayoutParams(layoutParams);
        }
    }
}
