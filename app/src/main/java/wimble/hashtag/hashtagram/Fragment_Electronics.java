package wimble.hashtag.hashtagram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment_Electronics extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#electronics #device #instatech #techy #techie #computers #gadgets #laptops #gadget #hack #technology #instaiphone #iphoneographers #appleiphone #iphoneogram #screen #iphonegraphic #iphoneology #teamiphone #iphoneographer #smartphone #electronic #tech #iphone4 #ios #mobile #iphone3gs #phone #iphone3g #iphone5", "#iphone #apple #iphone6 #iphone6s #iphoneonly #samsung #iphone5 #ipad #iphonesia #iphone6plus #case #ios #iphone5s #iphoneography #iphone6splus #iphone7 #iphone4 #iphonecase #iphonephotography #mobile #iphonegraphy #phone #caseiphone #macbook #smartphone #android #iphonese #applewatch", "#android #ios #androidonly #smartphone #instandroid #instadroid #instaandroid #androidcommunity #googleandroid #droid #androidnesia #teamandroid #androidinstagram #teamdroid #androidographer #ics #phone #mobile #androidography #jellybean #google #samsung #samsunggalaxy #samsunggalaxys2 #app #apps #tech #appstore #apple #appdesign"};
    String[] strnm = {"General", "Iphone", "Android"};

 @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.fragment_all, viewGroup, false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        tag_adapter = new Tag_Adapter(getActivity(), this.str, this.strnm);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(tag_adapter);
        tag_adapter.notifyDataSetChanged();
        return inflate;
    }
}