package wimble.hashtag.hashtagram;

import android.app.Dialog;
import android.app.ProgressDialog;
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
import wimble.hashtag.hashtagram.databases.DBHCustomTag;
import wimble.hashtag.hashtagram.databases.ItemsPost;
import wimble.hashtag.hashtagram.hashtaggenerate.SearchHashTagImp;
import wimble.hashtag.hashtagram.hashtaggenerate.SearchHashTagPresentor;
import co.lujun.androidtagview.ColorFactory;
import co.lujun.androidtagview.TagContainerLayout;


import java.util.ArrayList;
import java.util.List;

public class Generate_Hashtag_Activity extends AppCompatActivity implements SearchHashTagImp.ISearchHashTagView {
    String str;
    static Context context;
    ProgressDialog dlg = null;
    public EditText etHashTagCat;
    private String hashTagStings = "";
    public DBHCustomTag mDbhCustomTag = new DBHCustomTag(this);
    public SearchHashTagPresentor searchHashTagPresentor;
    TagContainerLayout mTagContainerLayout;
    TextView tv_share, tv_insta, tv_copy;
    LinearLayout lin_copy, lin_insta, lin_more_share;
    ImageView iv_back, iv_share, iv_insta, iv_copy, iv_save, iv_search;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_hashtag_generate);


        LinearLayout adLayout1 = (LinearLayout) findViewById(R.id.adLayout1);
        FrameLayout adMobView1 = (FrameLayout) findViewById(R.id.adMobView1);

        etHashTagCat = (EditText) findViewById(R.id.etHashTagCat);
        mTagContainerLayout = (TagContainerLayout) findViewById(R.id.tagcontainerLayout);

        lin_more_share = (LinearLayout) findViewById(R.id.lin_more_share);
        lin_insta = (LinearLayout) findViewById(R.id.lin_insta);
        lin_copy = (LinearLayout) findViewById(R.id.lin_copy);

        tv_share = (TextView) findViewById(R.id.tv_share);
        tv_insta = (TextView) findViewById(R.id.tv_insta);
        tv_copy = (TextView) findViewById(R.id.tv_copy);

        iv_share = (ImageView) findViewById(R.id.iv_share);
        iv_insta = (ImageView) findViewById(R.id.iv_insta);
        iv_copy = (ImageView) findViewById(R.id.iv_copy);
        iv_save = (ImageView) findViewById(R.id.iv_save);
        iv_search = (ImageView) findViewById(R.id.iv_search);
        iv_back = (ImageView) findViewById(R.id.iv_back);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        context = this;
        searchHashTagPresentor = new SearchHashTagPresentor(this, this);
        dlg = new ProgressDialog(this);
        iv_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setColor();
                Generate_Hashtag_Activity generate_Hashtag_Activity = Generate_Hashtag_Activity.this;
                generate_Hashtag_Activity.str = generate_Hashtag_Activity.etHashTagCat.getText().toString();
                if (str.equals("")) {
                    Toast.makeText(getApplicationContext(), "please enter word ", Toast.LENGTH_SHORT);
                    return;
                } else {
                    showProgress("Generate Hashtag.......");
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            dismissProgress();
                            searchHashTagPresentor.onSearchHashTag(str);
                        }
                    }, 3000);
                }
            }
        });
        mTagContainerLayout.setTheme(ColorFactory.NONE);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fontregulare.ttf");
        mTagContainerLayout.setTagTypeface(typeface);
        lin_more_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setColor();
                tv_share.setTextColor(getResources().getColor(R.color.white));
                iv_share.setColorFilter(getResources().getColor(R.color.white));

                if (mTagContainerLayout.getTags().size() == 0) {
                    Toast.makeText(Generate_Hashtag_Activity.this, "No any tags here...", Toast.LENGTH_SHORT).show();
                    return;
                } else {
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
                    intent.putExtra("android.intent.extra.SUBJECT", Generate_Hashtag_Activity.context.getResources().getString(R.string.app_name));
                    intent.putExtra("android.intent.extra.TEXT", str);
                    Generate_Hashtag_Activity.context.startActivity(Intent.createChooser(intent, "Share"));
                }
            }
        });
        lin_insta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setColor();
                tv_insta.setTextColor(getResources().getColor(R.color.white));
                iv_insta.setColorFilter(getResources().getColor(R.color.white));

                if (mTagContainerLayout.getTags().size() == 0) {
                    Toast.makeText(Generate_Hashtag_Activity.this, "No any tags here...", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Generate_Hashtag_Activity generate_Hashtag_Activity = Generate_Hashtag_Activity.this;
                    generate_Hashtag_Activity.copyClipboard(generate_Hashtag_Activity.mTagContainerLayout, false, 0);
                    Generate_Hashtag_Activity.shareOnSocialApp("com.instagram.android");
                }
            }
        });
        lin_copy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setColor();
                tv_copy.setTextColor(getResources().getColor(R.color.white));
                iv_copy.setColorFilter(getResources().getColor(R.color.white));

                if (mTagContainerLayout.getTags().size() == 0) {
                    Toast.makeText(Generate_Hashtag_Activity.this, "No any tags here...", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Generate_Hashtag_Activity generate_Hashtag_Activity = Generate_Hashtag_Activity.this;
                    generate_Hashtag_Activity.copyClipboard(generate_Hashtag_Activity.mTagContainerLayout, false, 0);
                }
            }
        });
        iv_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setColor();
                if (mTagContainerLayout.getTags().size() == 0) {
                    Toast.makeText(Generate_Hashtag_Activity.this, "No any tags here...", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    final Dialog dialog = new Dialog(Generate_Hashtag_Activity.this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                    dialog.setContentView(R.layout.dialoge_tag_save);
                    dialog.show();
                    final TagContainerLayout tagContainerLayout = (TagContainerLayout) dialog.findViewById(R.id.tagcontainerLayout);
                    tagContainerLayout.setTheme(ColorFactory.NONE);
                    Typeface typeface = Typeface.createFromAsset(getAssets(), "fontregulare.ttf");
                    mTagContainerLayout.setTagTypeface(typeface);
                    final EditText editText = (EditText) dialog.findViewById(R.id.et_name);
                    editText.requestFocus();
                    tagContainerLayout.setTags(mTagContainerLayout.getTags());
                    ((ImageView) dialog.findViewById(R.id.lin_cancle)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    ((LinearLayout) dialog.findViewById(R.id.lin_save)).setOnClickListener(new View.OnClickListener() {
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
                                Toast.makeText(Generate_Hashtag_Activity.this, "Please, Give tag group name...", Toast.LENGTH_SHORT).show();
                                return;
                            } else {
                                mDbhCustomTag.AddtoPosts(new ItemsPost(trim, str.replace("null", "").trim()));
                            }
                            dialog.dismiss();
                            startActivity(new Intent(Generate_Hashtag_Activity.this, Saved_Hashtag_Activity.class));
                            finish();
                        }
                    });
                }
            }
        });
        setColor();
    }

    public void setColor() {
        tv_share.setTextColor(getResources().getColor(R.color.tint));
        tv_insta.setTextColor(getResources().getColor(R.color.tint));
        tv_copy.setTextColor(getResources().getColor(R.color.tint));
        iv_share.setColorFilter(getResources().getColor(R.color.tint));
        iv_insta.setColorFilter(getResources().getColor(R.color.tint));
        iv_copy.setColorFilter(getResources().getColor(R.color.tint));
    }

    public static void shareOnSocialApp(String str2) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str2);
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
        } else {
            Toast.makeText(context, "No app found...", Toast.LENGTH_SHORT).show();
        }
    }

    public void copyClipboard(TagContainerLayout tagContainerLayout, boolean z, int i) {
        String str2;
        String str3 = "";
        for (int i2 = 0; i2 < i; i2++) {
            str3 = str3 + ".\n";
        }
        if (z) {
            str3 = str3 + " @fondpaper ";
        }
        for (int i3 = 0; i3 < tagContainerLayout.getTags().size(); i3++) {
            if (i3 == 0) {
                str2 = str3 + tagContainerLayout.getTags().get(i3).toString();
            } else {
                str2 = str3 + " " + tagContainerLayout.getTags().get(i3).toString();
            }
            str3 = str2;
        }
        if (tagContainerLayout.getTags().size() < 30) {
            str3 = str3 + " #besthashtagforsocialmedia";
        }
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
        if (str3 != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("text", str3.replace("null", "")));
            Toast.makeText(context, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
        }
    }

    public void showProgress(String str2) {
        try {
            this.dlg.setMessage(str2);
            this.dlg.show();
        } catch (Exception unused) {
        }
    }

    public void dismissProgress() {
        try {
            this.dlg.dismiss();
        } catch (Exception unused) {
        }
    }

    private List<String> getTagList(String str2) {
        ArrayList arrayList = new ArrayList();
        String[] split = str2.split("#");
        for (String str3 : split) {
            if (str3.length() > 0) {
                arrayList.add("#" + str3);
            }
        }
        return arrayList;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void onGetSearchHastTagResult(ArrayList<String> arrayList) {
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("final hashTagsList at index -=>");
                sb.append(i);
                this.hashTagStings += arrayList.get(i);
            }
            this.mTagContainerLayout.setTags(getTagList(this.hashTagStings));
        }
    }
}