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

public class Fragment_Transport extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#train #active #instahealth #determination #strong #cardio #getfit #railway #fitnessaddict #exercise #fitnessmodel #healthychoices #train_nerds #cleaneating #railways_of_our_world #daily_crossing #pocket_rail #trains_worldwide #railroad #trainhard #trb_express #lift #trains #gymlife #shredded #excercise #trainstation #muscle #station #eisenbahnfotografie", "#bikeride #bike #motorcycle #instamotor #streetbike #instatag #biker #motorbike #instagramanet #speedy #race #instabike #instamotorcycle #racing #motorcycles #bikes #bikersofinstagram #bikeporn #cycle #wheels #helmets #bikers #helmet #motorsport #bikergang #supermoto #bikelife #speed #wheel #bikestagram", "#bicyclelove #instatag #ride #bicyclelove #bikeride #travel #cycle #bicycle #bicyclette #speed #ridebikes #bike #bicycle #bicycleporn #wheels #rims #bikelife #wheel #bicycles #biker #instagramanet #rim #instabike #velocipede #pedal #bicycleporn #bicyclette #bicycles #speedy #bikes #cycling", "#ride #driver #speedy #vehicles #drive #cars #sportscar #carporn #instatag #vehicle #carsofinstagram #cars #freeway #speed #carstagram #road #roadtrip #sportscars #car #instacar #carshow #tires #street #instacars #streetracing #instagramanet"};
    String[] strnm = {"Train", "Motorcycle", "Bicycle", "Cars"};

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