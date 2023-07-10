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

public class Fragment_WeatherandSeassons extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#cold #winter #snow #ice #snowing #snowflakes #warm #instawinter #rainy #wintertime #chilly #blizzard #snowfall #frost #frosty #deepsleep #lingoware #eaters #getup #fatigue #blanket #frio #weather", "#instasun #sundayfunday #instagramanet #light #sundays #goodday #photooftheday #shine #sun #sundaymorning #sky #sunglasses #sunburn #sundown #sunsets #nature #sunshine #sunset #sunset_madness #sunrise #sunnydays #sunnies #sunrays #sunnyday #thesun #sunny #instatag #sunlight #sunday #skywatcher", "#snowflake #snowbunny #snowmobile #snowing #snow #coldday #wintertime #snowflakes #winterwonderland #frost #winter #snowedin #nature #isntagramanet #coldweather #snowstorm #snowwhite #instatag #snowday #snowy #frosty #frosting #cold #weather #white #winteriscoming #snowfall #instawinter #snowball", "#autumncolors #autumn2015 #autumnweather #seasons #autumnweather #season #autumntime #fallweather #leaffall #fall #nature #autumncolours #autumnsky #autumndays #instaautumn #autumnstyle #autumnleaves #falltime #red #instafall #leaf #instatag #instagramanet #autumn #autumnal #orange", "##sky #instagramanet #cloudchasing #skyporn #cloudstagram #cloudysky #cloudlovers #cloud_skye #cloudchasers #cloudyday #instaclouds #skyviewers #instacloud #cloudscape #clouds #skywatcher #cloud9 #instatag #clouds_of_our_world #skyline #cloudsporn #cloudlife #skyscraper #cloudy #cloudporn #cloudnine #cloudchaser #cloud #skylovers", "#summer2018 #instasummer #sun #instagramanet #summerlovin #fun #summerfun #summeriscoming #warm #vacationtime #summerbody #season #summervacation #summer #summernights #instatag #seasons #summerdays #sunshine #summerlove #summertimeshine #sunny #summerweather #hot #summertime #summer2018 #summerweather", "#winterjam #winterfun #instagramanet #winterbreak #winterishere #holidays #coldworld #wintersun #winter2016 #winter #winter2015 #blizzard #colddays #wintertime #cold #winterfashion #snowing #coldday #winterwonderland #wintertime #snow #seasons #winters #season #instawinter #winterpark #wintersoldier #winteriscoming #instatag", "#instagramanet #puddlegram #rains #rainyday #raindrops #photooftheday #instarain #rainydays #instatag #rainclouds #puddle #clouds #rain #rainingday #rainy #puddles #pouring #rainraingoaway #rainday #pouringrain #cloudy #raindrop #rainyweather #rainyseason #rainstorm #raining", "#instatag #blossoms #flowerstagram #ilovespring #instaspring #blossom #green #springishere #instagramanet #sun #springbreak #bloom #springtime #color #springbreakers #flower #greenday #floweroftheday #season #blooms #spring #flowers #blooming #springfashion #spring2019 #seasons #tree"};
    String[] strnm = {"Cold", "Sun", "Snow", "Autumn", "Cloud", "Summer", "Winter", "Rain", "Spring"};

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