package wimble.hashtag.hashtagram;

import android.util.SparseArray;
import android.view.View;

public class ViewFindUtils {
    public static <T extends View> T hold(View view, int i) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            view.setTag(sparseArray);
        }
        T t = (T) sparseArray.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = view.findViewById(i);
        sparseArray.put(i, findViewById);
        return findViewById;
    }

    public static <T extends View> T find(View view, int i) {
        return view.findViewById(i);
    }
}
