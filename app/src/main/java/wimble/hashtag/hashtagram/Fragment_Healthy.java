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

public class Fragment_Healthy extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#weightloss #weightlossjourney #transformation #slimmingworld #cleaneating #weightwatchers #weightlossmotivation #healthyeating #losingweight #fatloss #exercise #weightlosstransformation #fitnessjourney #slimmingworlduk #nutrition #healthylifestyle #healthyfood #getfit #fitspiration #cardio #healthyliving #fitmom #girlswholift #beforeandafter #sw #lowcarb #ww #fitnessmotivation #fattofit #iifym", "#fitnessgear #fitnessmotivation #fitnessfood #gymnast #healthy #fitnessfreak #fitnessmodel #gymfreak #gym #healthyliving #fitness #gymlife #fitnesslifestyle #fitnessaddict #gymtime #instafitness #fitnessjourney #gymrat #fitnessgirls #gymmotivation #fitnesslife #gymflow #fitnessgirl #gymnastics #health #healthylife #instatag #instagramanet #healthylifestyle #healthychoices", "#motivation #yogapractice #yogapants #instayoga #yogateacher #yogalove #yogagram #yogajourney #yoga #yogaaday #yogaaddict #yogafit #yogaeverydamnday #yogamom #yogaeveryday #instagramanet #yogapose #meditation #yogadaily #yogainspiration #pose #yogachallenge #yogagirl #yogalife #yogaeverywhere #instatag #yogafun", "#wellness #active #instahealth #healthychoices #train #determination #healthyfood #healthylifestyle #healthyliving #organic #healthyeating #protein #healthylife #transformation #exercise #nutrition #fitnessaddict #fitnessmodel #cardio #weightloss #strong #muscle #abs #cleaneating #instafit #getfit #gymlife #fitnessmotivation #fitlife #gains #fitgirl #shredded #crossfit #girlswholift #aesthetics #body #fitspiration #physique #dedication #muscles #yoga #nopainnogain #strength #bodybuilder"};
    String[] strnm = {"Weight Loss", "Fitness", "Yoga", "Health Fitness"};

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