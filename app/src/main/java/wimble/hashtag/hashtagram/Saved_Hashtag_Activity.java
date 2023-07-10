package wimble.hashtag.hashtagram;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import wimble.hashtag.hashtagram.databases.DBHCustomTag;
import wimble.hashtag.hashtagram.databases.ItemsPost;


import java.util.List;

public class Saved_Hashtag_Activity extends AppCompatActivity {
    private ListCustomTagsAdapter mCustomTagsAdapter;
    private DBHCustomTag mDbhCustomTag;
    static List<ItemsPost> posts;
    private GridView mListView;
    private ImageView iv_back;
    private TextView tv_nodate;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_hashtag_saved);



        LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);
        FrameLayout adMobView = (FrameLayout) findViewById(R.id.adMobView);

        LinearLayout adLayout1 = (LinearLayout) findViewById(R.id.adLayout1);
        FrameLayout adMobView1 = (FrameLayout) findViewById(R.id.adMobView1);

        mListView = (GridView) findViewById(R.id.listView);
        tv_nodate = (TextView) findViewById(R.id.tv_nodate);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mDbhCustomTag = new DBHCustomTag(this);
        posts = mDbhCustomTag.getAllPost();
        mCustomTagsAdapter = new ListCustomTagsAdapter(Saved_Hashtag_Activity.this,  posts);
        mListView.setAdapter((ListAdapter) mCustomTagsAdapter);
        if (posts.size() == 0) {
            mListView.setVisibility(View.GONE);
            tv_nodate.setVisibility(View.VISIBLE);
        } else {
            tv_nodate.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
        }
    }

    public void onBackPressed() {
        finish();
    }

}