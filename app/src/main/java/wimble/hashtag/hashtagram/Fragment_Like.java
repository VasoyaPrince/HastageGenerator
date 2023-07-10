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

public class Fragment_Like extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] strnm = {"Instagram", "Follow", "Like", "Comment", "Shoutout"};
    String[] str = {"#instagrammers #igers #instalove #instamood #instagood #followme #follow #comment #shoutout #iphoneography #androidography #filter #filters #hipster #contests #photo #instadaily #igaddict #photooftheday #pics #insta #picoftheday #bestoftheday #instadaily #instafamous #popularpic #popularphoto", "#follow #f4f #followme #followforfollow #follow4follow #teamfollowback #followher #followbackteam #followhim #followall #followalways #followback #me #love #pleasefollow #follows #follower #following", "#followme #like4like #liker #likes #l4l #likes4likes #photooftheday #love #likeforlike #likesforlikes #liketeam #likeback #likebackteam #instagood #likeall #likealways #liking", "#comment #comment4comment #c4c #commenter #comments #commenting #love #comments4comments #instagood #commentteam #commentback #commentbackteam #commentbelow #photooftheday #commentall #commentalways #pleasecomment", "#shoutout #shoutouts #shout #out #shoutouter #instagood #s4s #shoutoutforshoutout #shoutout4shoutout #so #so4so #photooftheday #ilovemyfollowers #love #sobackteam #soback #follow #f4f #followforfollow #followback #followhim #followher #followall #followme #shout_out"};

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