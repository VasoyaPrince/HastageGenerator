package wimble.hashtag.hashtagram;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import wimble.hashtag.hashtagram.databases.DBHCustomTag;
import wimble.hashtag.hashtagram.databases.ItemsPost;
import co.lujun.androidtagview.ColorFactory;
import co.lujun.androidtagview.TagContainerLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCustomTagsAdapter extends BaseAdapter {
    private List<String> tags;
    public static Context mContext;
    private List<ItemsPost> postList;
    private DBHCustomTag mDbhCustomTag;

    private static class ViewHolder {
        LinearLayout lin_copy, lin_insta, lin_more_share, lin_delete;
        TagContainerLayout mTagContainerLayout;
        TextView tvName;

        private ViewHolder() {
        }
    }

    public ListCustomTagsAdapter(Context context, List<ItemsPost> list) {
        mContext = context;
        this.postList = list;
    }

    public int getCount() {
        return this.postList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(this.postList.size());
    }

    public long getItemId(int i) {
        return (long) this.postList.get(i).getId();
    }

    public View getView(final int position, View view, ViewGroup viewGroup) {
        this.mDbhCustomTag = new DBHCustomTag(mContext);
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.item_tag_save, (ViewGroup) null);
        final ViewHolder createViewHolder = createViewHolder(inflate);
        createViewHolder.mTagContainerLayout.setTheme(ColorFactory.NONE);
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fontregulare.ttf");
        createViewHolder.mTagContainerLayout.setTagTypeface(typeface);
        createViewHolder.tvName.setText(this.postList.get(position).getName());
        this.tags = Arrays.asList(this.postList.get(position).getTags());
        createViewHolder.mTagContainerLayout.setTags(getTagList(this.postList.get(position).getTags()));
        createViewHolder.lin_insta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                copyClipboard(createViewHolder.mTagContainerLayout, false, 0);
                ListCustomTagsAdapter.shareOnSocialApp("com.instagram.android");
            }
        });
        createViewHolder.lin_more_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str = "";
                for (int i = 0; i < createViewHolder.mTagContainerLayout.getTags().size(); i++) {
                    if (i == 0) {
                        str = str + createViewHolder.mTagContainerLayout.getTags().get(i).toString();
                    } else {
                        str = str + " " + createViewHolder.mTagContainerLayout.getTags().get(i).toString();
                    }
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", ListCustomTagsAdapter.mContext.getResources().getString(R.string.app_name));
                intent.putExtra("android.intent.extra.TEXT", str);
                ListCustomTagsAdapter.mContext.startActivity(Intent.createChooser(intent, "Share"));
            }
        });
        createViewHolder.lin_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.delete_dialog);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.show();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = dialog.getWindow();
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
                window.setAttributes(layoutParams);
                TextView txt_cancel = (TextView) dialog.findViewById(R.id.txt_cancel);
                TextView txt_ok = (TextView) dialog.findViewById(R.id.txt_ok);
                txt_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title;
                        DBHCustomTag mDbhCustomTag = new DBHCustomTag(mContext);
                        title = postList.get(position).getName();
                        mDbhCustomTag.removeSingleContact(title);
                        postList = mDbhCustomTag.getAllPost();
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                txt_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
        createViewHolder.lin_copy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                copyClipboard(createViewHolder.mTagContainerLayout, false, 0);
                Toast.makeText(mContext, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        return inflate;
    }

    private ViewHolder createViewHolder(View view) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvName = (TextView) view.findViewById(R.id.txt_cat_name);
        viewHolder.mTagContainerLayout = (TagContainerLayout) view.findViewById(R.id.tagcontainerLayout);
        viewHolder.lin_insta = (LinearLayout) view.findViewById(R.id.lin_insta);
        viewHolder.lin_more_share = (LinearLayout) view.findViewById(R.id.lin_more_share);
        viewHolder.lin_copy = (LinearLayout) view.findViewById(R.id.lin_copy);
        viewHolder.lin_delete = (LinearLayout) view.findViewById(R.id.lin_delete);
        return viewHolder;
    }

    private List<String> getTagList(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("#");
        for (String str2 : split) {
            if (str2.length() > 0) {
                arrayList.add("#" + str2);
            }
        }
        return arrayList;
    }

    public static void shareOnSocialApp(String str) {
        Intent launchIntentForPackage = mContext.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage != null) {
            mContext.startActivity(launchIntentForPackage);
            return;
        }
        Toast.makeText(mContext, "No App Found", Toast.LENGTH_SHORT);
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
        ClipboardManager clipboardManager = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        if (str2 != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("text", str2.replace("null", "")));
            Toast.makeText(mContext, "Copied to Clipboard", Toast.LENGTH_SHORT);
        }
    }

}