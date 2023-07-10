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

public class Fragment_Nature extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#instaflowers #petals #spring #photooftheday #instagramanet #flowerslovers #instatag #plants #flowerporn #blossom #petal #flowerstyles_gf #flowermagic #flowerstalking #love #flowerpower #beautiful #flowerstagram #summer #floweroftheday #instaflower #flower #beauty #pretty #flowers #nature #flowercrown #flowersofinstagram", "#river #nature #water #photography #summer #travel #landscape #sky #naturephotography #mountains #bridge #naturelovers #love #view #clouds #mountain #sunset #forest #picoftheday #instagood #adventure #japan #fishing #like #photo #city #boat #instatravel #explore", "#ocean #beachlife #sand #waves #surf #paradise #water #playa #bikini #island #relax #sunrise #holidays #seaside #summertime #surfing #cloudporn #beachday #praia #hawaii #wave", "#landscap #nature #like #photos #art #instadays #sp #olharesemimagens #outside #ramires #olhareseimagens #grafiqx #fotosmobiles #dea #riobrilhantems #cio #presidentrepit #presidenteepitacio #panelagram #picsofbrasil #myskynow #instameetms #instameetsp #photochallenge #riobrilhante #rededefotografos #respirofotografia #artofinstagram #photograph", "#goodnight #lights #light #stars #moon #nightphotography #dark #day #nightsky #longexposure #red #nighttime #sleep #sunrise #cloudporn #good #nightlife #tree #morning #horizon", "#skyporn #cloudporn #skylovers #sunrise #cloud #tree #bluesky #skyline #water #trees #horizon #sunshine #weather #instasky #light #空 #mountain #sunsetlovers #morning #ocean #cielo #cloudy #red #sunny #day #landscape_lovers #lake #scenery #sunsetporn #landscapes", "#mare #海 #море #relax #holidays #greece #mar #summertime #summer2016 #bluesky #seascape #ocean #waves #water #sand #surf #island #seaside #wave #beachlife #paradise #boat #coast #surfing #underwater #fish #diving #underwaterphotography #oceano #hawaii #horizon #fishing #reflection #dive #cloudporn #scuba #reef #cloud #surfer #saltlife #islandlife", "#moon #moonlight #luna #stars #fullmoon #nighttime #nightsky #nightynight #dark #lightsout #sleeptime #space #lunar #instagoodnight #nightowl #bedtime #themoon #sleep #sleepyhead #passout #knockedout #rest #astrophotography #knockout #bed #moonrise #star #galaxy #out #sleepy", "#forest #woods #trees #tree #лес #hiking #wilderness #wood #hike #mountain #outdoors #autumn #instanature #camping #river #wild #wald #leaves #walk #woodland #lake #bushcraft", "#space #nasa #galaxy #astronomy #universe #cosmos #stars #astrophotography #milkyway #science #astronaut #nightsky #moon #planet #natgeospace #nebula #acid #trippy #космос #hubble #psychedelicart #dmt #alien #earth #solarsystem #universetoday #psychedelic #planets #stargazing #thirdeye", "#sun #beautiful #beauty #view #photooftheday #skyporn #hot #night #warm #instasky #instatag #instasun #sunrise #instagramanet #morning #sunsets #amazing #all_sunsets #sunset_madness #instasunsets #cloudporn #horizon #pretty #sunset #vision #sunrise_sunsets_aroundworld", "#trees #tree #forest #leaves #treestagram #woods #treescape #autumn #park #naturelover #lake #fall #landscapes #hiking #water #landscapelovers #naturegram #naturelove #landscapestyles #naturewalk #naturediversity #landscape_lover #outdoors #naturephoto #grass #natureonly #landscapehunter #nature_prefection #landscape_lovers #nature_seekers", "#mountain #hiking #hike #trekking #mountainlife #outdoor #mountaineering #mountainview #wilderness #summit #scenery #climbing #forest #alps #outdoors #peak #landscapes #lake #tree #snow #instanature #mountainbike #montaña #camping #montagna #landscape_lovers #nature_seekers #trees #climb #trail"};
    String[] strnm = {"Flowers", "River", "Beach", "Landscape", "Night", "Sky", "Sea Ocean", "Moon", "Forest", "Space", "Sunrise Sunset", "Trees", "Mountain"};

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