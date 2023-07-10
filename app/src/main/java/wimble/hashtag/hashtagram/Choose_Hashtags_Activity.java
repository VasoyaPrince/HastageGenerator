package wimble.hashtag.hashtagram;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import wimble.hashtag.hashtagram.databases.DBHCustomTag;
import wimble.hashtag.hashtagram.databases.ItemsPost;
import co.lujun.androidtagview.ColorFactory;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

import java.util.ArrayList;
import java.util.List;

public class Choose_Hashtags_Activity extends AppCompatActivity {
    static Context context;
    public static ArrayList tagscolor;
    public static ArrayList selectedTagList;
    public DBHCustomTag mDbhCustomTag = new DBHCustomTag(this);
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String[] str_title = {"like", "promotion", "animal", "food", "fashion", "drinks & desserts", "nature", "family", "people", "weather $ season", "holiday", "urban", "art",
            "sport", "trending", "appearance", "health & life-style", "transport", "entertainment", "electronic", "life", "feeling", "celebrity", "country", "photo", "car"};
    final int[] tabIcons = {R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag,
            R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag,
            R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag,
            R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag,
            R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag,
            R.drawable.btn_unselect_tag, R.drawable.btn_unselect_tag};
    final int[] selectedtabIcons = {R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag,
            R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag,
            R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag,
            R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag,
            R.drawable.btn_select_tag, R.drawable.btn_select_tag, R.drawable.btn_select_tag};
    SlidingTabLayout tabLayout;
    TextView txt_count;
    ViewPager viewPager;
    ImageView iv_back, iv_save;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_hashtags_choose);



        LinearLayout adLayout1 = (LinearLayout) findViewById(R.id.adLayout1);
        FrameLayout adMobView1 = (FrameLayout) findViewById(R.id.adMobView1);


        iv_save = (ImageView) findViewById(R.id.iv_save);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        int i = 0;
        context = this;
        selectedTagList = new ArrayList();
        tagscolor = new ArrayList();
        View decorView = getWindow().getDecorView();
        while (true) {
            String[] strArr = this.str_title;
            if (i < strArr.length) {
                this.mTabEntities.add(new TabEntity(strArr[i], this.selectedtabIcons[i], this.tabIcons[i]));
                i++;
            } else {
                this.viewPager = (ViewPager) ViewFindUtils.find(decorView, R.id.viewpager);
                setupViewPager(this.viewPager);
                this.tabLayout = (SlidingTabLayout) ViewFindUtils.find(decorView, R.id.tabs1);
                this.tabLayout.setViewPager(this.viewPager, this.mTabEntities);
                this.txt_count = (TextView) findViewById(R.id.txt_count);
                iv_save.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (selectedTagList.size() == 0) {
                            Toast.makeText(context, "Please, Select tags first...", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            final Dialog dialog = new Dialog(Choose_Hashtags_Activity.this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                            dialog.setContentView(R.layout.dialoge_tag_select);
                            dialog.show();
                            LinearLayout lin_copy = (LinearLayout) dialog.findViewById(R.id.lin_copy);
                            LinearLayout lin_more_share = (LinearLayout) dialog.findViewById(R.id.lin_more_share);
                            LinearLayout lin_save = (LinearLayout) dialog.findViewById(R.id.lin_save);
                            ImageView tv_no = (ImageView) dialog.findViewById(R.id.tv_no);
                            final TagContainerLayout mTagContainerLayout = (TagContainerLayout) dialog.findViewById(R.id.tagcontainerLayout);
                            mTagContainerLayout.setTheme(ColorFactory.NONE);
                            Typeface typeface = Typeface.createFromAsset(getAssets(), "fontregulare.ttf");
                            mTagContainerLayout.setTagTypeface(typeface);
                            mTagContainerLayout.setTags(selectedTagList);
                            mTagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
                                public void onSelectedTagDrag(int i, String str) {
                                }

                                public void onTagLongClick(int i, String str) {
                                }

                                public void onTagClick(int i, String str) {
                                    selectedTagList.remove(str);
                                    tagscolor.remove(0);
                                    mTagContainerLayout.setTags(selectedTagList);
                                }

                                public void onTagCrossClick(int i) {
                                    selectedTagList.remove(selectedTagList.get(i));
                                    tagscolor.remove(0);
                                    mTagContainerLayout.setTags(selectedTagList);
                                }
                            });
                            tv_no.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                            lin_copy.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    copyClipboard(mTagContainerLayout, false, 0);
                                    dialog.dismiss();
                                }
                            });
                            lin_more_share.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    String str = "";
                                    for (int i = 0; i < mTagContainerLayout.getTags().size(); i++) {
                                        if (i == 0) {
                                            str = str + mTagContainerLayout.getTags().get(i).toString();
                                        } else {
                                            str = str + " " + mTagContainerLayout.getTags().get(i).toString();
                                        }
                                    }
                                    Intent intent = new Intent("android.intent.action.SEND");
                                    intent.setType("text/plain");
                                    intent.putExtra("android.intent.extra.SUBJECT", context.getResources().getString(R.string.app_name));
                                    intent.putExtra("android.intent.extra.TEXT", str);
                                    Choose_Hashtags_Activity.context.startActivity(Intent.createChooser(intent, "Share"));
                                    dialog.dismiss();
                                }
                            });
                            lin_save.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    dialog.dismiss();
                                    final Dialog dialog1 = new Dialog(Choose_Hashtags_Activity.this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                                    dialog1.setContentView(R.layout.dialoge_tag_save);
                                    dialog1.show();
                                    ImageView lin_cancle = (ImageView) dialog1.findViewById(R.id.lin_cancle);
                                    LinearLayout lin_save = (LinearLayout) dialog1.findViewById(R.id.lin_save);
                                    final EditText editText = (EditText) dialog1.findViewById(R.id.et_name);
                                    final TagContainerLayout tagContainerLayout = (TagContainerLayout) dialog1.findViewById(R.id.tagcontainerLayout);
                                    tagContainerLayout.setTheme(ColorFactory.NONE);
                                    Typeface typeface = Typeface.createFromAsset(getAssets(), "fontregulare.ttf");
                                    tagContainerLayout.setTagTypeface(typeface);
                                    editText.requestFocus();
                                    tagContainerLayout.setTags(mTagContainerLayout.getTags());
                                    lin_cancle.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View view) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    lin_save.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View view) {
                                            String trim = editText.getText().toString().trim();
                                            String str = "";
                                            for (int i = 0; i < tagContainerLayout.getTags().size(); i++) {
                                                if (i == 0) {
                                                    str = str + tagContainerLayout.getTags().get(i).toString();
                                                } else {
                                                    str = str + " " + tagContainerLayout.getTags().get(i).toString();
                                                }
                                            }
                                            if (trim.isEmpty() || str == null) {
                                                Toast.makeText(Choose_Hashtags_Activity.this, "Please, Give tag group name...", Toast.LENGTH_SHORT);
                                                return;
                                            } else {
                                                mDbhCustomTag.AddtoPosts(new ItemsPost(trim, str.replace("null", "").trim()));
                                            }
                                            dialog1.dismiss();
                                            startActivity(new Intent(Choose_Hashtags_Activity.this, Saved_Hashtag_Activity.class));
                                            finish();

                                        }
                                    });
                                }
                            });
                        }
                    }
                });
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        TextView textView = txt_count;
                        textView.setText("#  " + selectedTagList.size() + "");
                        handler.postDelayed(this, 500);
                    }
                }, 500);
                return;
            }
        }
    }

    private void setupViewPager(ViewPager viewPager2) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFrag(new Fragment_Like(), "like");
        viewPagerAdapter.addFrag(new Fragment_Promotion(), "promotion");
        viewPagerAdapter.addFrag(new Fragment_Animal(), "animal");
        viewPagerAdapter.addFrag(new Fragment_Food(), "food");
        viewPagerAdapter.addFrag(new Fragment_Fashion(), "fashion");
        viewPagerAdapter.addFrag(new Fragment_DrinksandDesserts(), "drinks & dessert");
        viewPagerAdapter.addFrag(new Fragment_Nature(), "nature");
        viewPagerAdapter.addFrag(new Fragment_Family(), "family");
        viewPagerAdapter.addFrag(new Fragment_People(), "people");
        viewPagerAdapter.addFrag(new Fragment_WeatherandSeassons(), "weather & sasson");
        viewPagerAdapter.addFrag(new Fragment_Holiday_Celebration(), "holiday");
        viewPagerAdapter.addFrag(new Fragment_Urban(), "urban");
        viewPagerAdapter.addFrag(new Fragment_Art(), "art");
        viewPagerAdapter.addFrag(new Fragment_Sport(), "sport");
        viewPagerAdapter.addFrag(new Fragment_Trending(), "trending");
        viewPagerAdapter.addFrag(new Fragment_Appearance(), "appearance");
        viewPagerAdapter.addFrag(new Fragment_Healthy(), "health & life-style");
        viewPagerAdapter.addFrag(new Fragment_Transport(), "transport");
        viewPagerAdapter.addFrag(new Fragment_Entertainment(), "entertainment");
        viewPagerAdapter.addFrag(new Fragment_Electronics(), "electronic");
        viewPagerAdapter.addFrag(new Fragment_Life(), "life");
        viewPagerAdapter.addFrag(new Fragment_Feelings(), "feeling");
        viewPagerAdapter.addFrag(new Fragment_Celebrity(), "celebrity");
        viewPagerAdapter.addFrag(new Fragment_Countries(), "country");
        viewPagerAdapter.addFrag(new Fragment_Photo(), "photo");
        viewPagerAdapter.addFrag(new Fragment_Cars(), "car");
        viewPager2.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList();
        private final List<String> mFragmentTitleList = new ArrayList();

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            return this.mFragmentList.get(i);
        }

        public int getCount() {
            return this.mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String str) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(str);
        }

        public CharSequence getPageTitle(int i) {
            return this.mFragmentTitleList.get(i);
        }
    }

    public void copyClipboard(TagContainerLayout tagContainerLayout, boolean z, int i) {
        String str;
        String str2 = "";
        for (int i2 = 0; i2 < i; i2++) {
            str2 = str2 + ".\n";
        }
        if (z) {
            str2 = str2 + " @fondpaper ";
        }
        for (int i3 = 0; i3 < tagContainerLayout.getTags().size(); i3++) {
            if (i3 == 0) {
                str = str2 + tagContainerLayout.getTags().get(i3).toString();
            } else {
                str = str2 + " " + tagContainerLayout.getTags().get(i3).toString();
            }
            str2 = str;
        }
        if (tagContainerLayout.getTags().size() < 30) {
            str2 = str2 + " #besthashtagforsocialmedia";
        }
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
        if (str2 != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("text", str2.replace("null", "")));
            Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}