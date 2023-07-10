package wimble.hashtag.hashtagram;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

import java.util.ArrayList;
import java.util.List;

public class Tag_Adapter extends RecyclerView.Adapter<Tag_Adapter.MyViewHolder> {
    public static Context context;
    public String[] str;
    public String[] strnm;
    TagContainerLayout mTagContainerLayout;
    ImageView iv_share, iv_insta, iv_copy;
    LinearLayout lin_copy, lin_insta, lin_more_share;
    TextView txt_cat_name, tv_share, tv_insta, tv_copy;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View view) {
            super(view);
            tv_share = (TextView) view.findViewById(R.id.tv_share);
            tv_insta = (TextView) view.findViewById(R.id.tv_insta);
            tv_copy = (TextView) view.findViewById(R.id.tv_copy);
            iv_share = (ImageView) view.findViewById(R.id.iv_share);
            iv_insta = (ImageView) view.findViewById(R.id.iv_insta);
            iv_copy = (ImageView) view.findViewById(R.id.iv_copy);
            lin_more_share = (LinearLayout) view.findViewById(R.id.lin_more_share);
            lin_insta = (LinearLayout) view.findViewById(R.id.lin_insta);
            lin_copy = (LinearLayout) view.findViewById(R.id.lin_copy);

            txt_cat_name = (TextView) view.findViewById(R.id.txt_cat_name);
            mTagContainerLayout = (TagContainerLayout) view.findViewById(R.id.tagcontainerLayout);
        }
    }

    public Tag_Adapter(Context context2, String[] strArr, String[] strArr2) {
        context = context2;
        this.str = strArr;
        this.strnm = strArr2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tag_list, viewGroup, false));
    }

    public void onBindViewHolder(final MyViewHolder myViewHolder, int i) {
        txt_cat_name.setText(this.strnm[i]);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fontregulare.ttf");
        mTagContainerLayout.setTagTypeface(typeface);
        mTagContainerLayout.setTags(getTagList(this.str[i]), getColorList(this.str[i]));
        mTagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            public void onSelectedTagDrag(int i, String str) {
            }

            public void onTagCrossClick(int i) {
            }

            public void onTagLongClick(int i, String str) {
            }

            @SuppressLint({"ResourceType"})
            public void onTagClick(int i, String str) {
                if (Choose_Hashtags_Activity.selectedTagList.contains(str)) {
                    Choose_Hashtags_Activity.selectedTagList.remove(str);
                    Choose_Hashtags_Activity.tagscolor.remove(0);
                } else {
                    Choose_Hashtags_Activity.selectedTagList.add(str);
                }
                notifyDataSetChanged();
            }
        });
        lin_insta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    copyClipboard(mTagContainerLayout, false, 0);
                    Tag_Adapter.shareOnSocialApp("com.instagram.android");
                } catch (Exception e) {
                    Toast.makeText(context, "Instagram doesn't installed", Toast.LENGTH_LONG).show();
                }
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
                intent.putExtra("android.intent.extra.SUBJECT", Tag_Adapter.context.getResources().getString(R.string.app_name));
                intent.putExtra("android.intent.extra.TEXT", str);
                Tag_Adapter.context.startActivity(Intent.createChooser(intent, "Share"));
            }
        });
        lin_copy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                copyClipboard(mTagContainerLayout, false, 0);
                Toast.makeText(context, "Copy to Clipboard", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getItemCount() {
        return this.str.length;
    }

    public static void shareOnSocialApp(String str2) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str2);
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
            return;
        }
        Toast.makeText(context, "No App Found", Toast.LENGTH_SHORT);
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
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (str3 != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("text", str3.replace("null", "")));
            Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT);
        }
    }

    private List<int[]> getColorList(String str2) {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {Color.parseColor("#D365D0"), Color.parseColor("#D365D0"), Color.parseColor("#ffffff"), -256};
        int[] iArr2 = {Color.parseColor("#273A49"), Color.parseColor("#273A49"), Color.parseColor("#BED1E4"), -256};
        String[] split = str2.split("#");
        for (String str3 : split) {
            if (str3.length() > 0) {
                if (Choose_Hashtags_Activity.selectedTagList.contains("#" + str3)) {
                    arrayList.add(iArr);
                } else {
                    arrayList.add(iArr2);
                }
            }
        }
        return arrayList;
    }

    private List<String> getTagList(String str2) {
        ArrayList arrayList = new ArrayList();
        String[] split = str2.split("#");
        for (String str3 : split) {
            if (str3.length() > 0) {
                arrayList.add("#" + str3);
                Choose_Hashtags_Activity.tagscolor.add(Integer.valueOf(Color.parseColor("#BED1E4")));
            }
        }
        return arrayList;
    }

}