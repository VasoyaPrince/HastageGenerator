package wimble.hashtag.hashtagram.hashtaggenerate;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchHashTagPresentor implements SearchHashTagImp.ISearchHashTagPresnt {
    public Context context;
    private DbHelper dbHelper;
    public SearchHashTagImp.ISearchHashTagView iSearchHashTagView;

    public SearchHashTagPresentor(Context context2, SearchHashTagImp.ISearchHashTagView iSearchHashTagView2) {
        this.context = context2;
        this.iSearchHashTagView = iSearchHashTagView2;
        this.dbHelper = new DbHelper(context2);
    }

    public void onSearchHashTag(String str) {
        ArrayList<String> allHashTags = this.dbHelper.getAllHashTags(str);
        ArrayList arrayList = new ArrayList<>();
        if (allHashTags.size() > 0) {
            for (int i = 0; i < allHashTags.size(); i++) {
                String[] split = allHashTags.get(i).split(" ");
                if (split != null) {
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (split[i2].contains(str)) {
                            arrayList.add(split[i2]);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SearchHashTagPresentor At index ");
                    sb.append(i3);
                    sb.append(" hashtagram -=> ");
                }
                this.iSearchHashTagView.onGetSearchHastTagResult(arrayList);
//                return;
            }else {
                Toast.makeText(this.context, "No HashTag Found", 0).show();
            }
//            return;
        }
        else {
        Toast.makeText(this.context, "No HashTag Found", 0).show();
        }
    }
}
