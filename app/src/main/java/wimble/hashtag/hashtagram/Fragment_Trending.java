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

public class Fragment_Trending extends Fragment {
    public static Tag_Adapter tag_adapter;
    int pos;
    RecyclerView recyclerView;
    String[] str = {"#fun #instalike #me #l4l #love #picoftheday #follow #instagramanet #likeforlike #follow4follow #happy #smile #instatag #photooftheday #friends #followme #fashion #instadaily #summer #amazing #like4like #beautiful #swag #igers #bestoftheday #tflers #instagood #selfie #cute #tbt #repost #all_shots #eyes #pretty #night #followforfollow #lol #iphoneonly #instagramanet #instafollow #tweegram #l4l #my #party #style #fitness #instatag #bored #life #girls #cool #nature #instamood #funny #instacool #f4f #instago #nofilter #hot#doubletap #harrystyles #model #instagramhub #home #instalove #instatag #instapic #picstitch #awesome #beauty #day #photo #pink #tired #followback #igdaily #loveit #makeup #instagramanet #instaphoto #shoutout #iphonesia #20likes #throwback #throwbackthursday #instagramers #colorful"};
    String[] strnm = {""};

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