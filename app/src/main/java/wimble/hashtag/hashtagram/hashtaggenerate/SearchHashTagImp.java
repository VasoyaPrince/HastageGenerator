package wimble.hashtag.hashtagram.hashtaggenerate;

import java.util.ArrayList;

public class SearchHashTagImp {

    public interface ISearchHashTagPresnt {
        void onSearchHashTag(String str);
    }

    public interface ISearchHashTagView {
        void onGetSearchHastTagResult(ArrayList<String> arrayList);
    }
}
