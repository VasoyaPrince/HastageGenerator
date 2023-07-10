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

public class Fragment_Sport extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#cheerleading #cheer #cheerleader #cheerleaders #tumbling #cheerlife #cheerathletics #stunting #cheerbow #cheering #cheerstagram #cheerpractice #cheersport #cheerislife #cheerbows #backtuck #backflip #stunt #gymnasticsshoutouts #scorpion #gymnastics #gymnast #acro #bows #acrobatics #flexible #dancemoms", "#goals #instagramanet #gate #skate #hockey #play #hockeytown #playtime #hockeygram #nhl #hockeyplayers #hockeystick #hockeylife #hockeyboy #hockeyplayer #iceskating #playing #hockeygirl #ice #instahockey #shot #goal #instatag #fight #hockeygame #puck #hockeyislife", "#instasoccer #footballplayer #soccergame #instafootball #football #footballgame #playerr #stadium #kicks #kick #team #play #playing #instatag #ball #kicksonfire #soccerball #soccer #fans #instagramanet #soccerlife #kickstagram #footballseason #field #pass #futbol", "#dancing #dancemoms #instatag #choreography #flexibility #flexible #dancehall #dancerecital #dancelife #dancingmachine #songs #dancefloor #music #dance #danceparty #dancemoms2 #dancemom #fun #instagramanet #dancemoms1 #dancers #song #ballet #dancingqueen #flex #dancer #dancers #instadance", "#sports #soccer #crowd #score #action #gametime #football #playing #sporty #instagramanet #instasports #game #kick #hockey #instasport #player #fans #winning #win #play #games #goal #sportsday #box #sport #fun #instatag", "#skateboarding #skatelife #skate #skateboard #skateeverydamnday #skatepark #skater #skatecrunch #skateanddestroy #sk8 #skateordie #skateboardingisfun #metrogrammed #shralpin #skatespot #skateboards #skateclipsdaily #skategram #skating #skateboarder #longboard #hellaclips #longboarding #thankyouskateboarding #thrasher #skateshop #skatefam #berrics #stackinclips #skatephotoaday", "#swimming #swim #swimmingpool #pool #triathlon #swimmer #swimbikerun #triathlete #watertank #aquaria #tropicalfish #saltwater #instafish #underwater #freshwater #water #swimwear #triathlontraining #tropical #swimsuit #reeftank #reef #coral #fishtank #trilife #fishporn #fish #aquarium #ironmantraining #diving", "#git #gymnastics #flex #gymnastic #training #flexin #beam #flip #leap #fun #gym #flexfriday #flexibledieting #stunt #bars #instagramanet #motivation #flexing #gymnasticslife #instaflex #flexibility #instatag #instagym #love #gymnasticbodies #sport #gym #flexible #vault", "#boxing #mma #kickboxing #muaythai #ufc #bjj #fight #jiujitsu #fighter #judo #karate #martialarts #wrestling #ko #knockout #taekwondo #boxeo #бокс #conormcgregor #boxer #fighting #boxinglife #bellator #mixedmartialarts #grappling #miketyson #ufc202 #sparring #kungfu #k1", "#barbell #fit #muscle #healthy #crossbar #heavy #muscles #instagramanet #powerful #health #instagramanet #bodybuildingmotivation #squat #fitness #flex #bodybuilding #strong #gymlife #instafit #instatag #muscleandhealth #bodybuildinglifestyle #instafitness #powerlifting #instatag #stronger #motivation #gym #instabodybuilding", "#baseball #mlb #beisbol #homerun #baseballseason #baseballlife #baseballislife #baseballgame #dodgers #pitcher #bluejays #BallPark #sports #mets #baseballbat #catch #baseballswag #firstbase  #yankees #bat #thirdbase #inning #bases #secondbase #BaseballIsBetter #newyorkmets #mitt #cubs #swing", "#instahealth #instarun #active #runchat #instatag #marathon #healthychoices #runners #marathontraining #runningman #runaway #runhappy #instagramanet #trailrunner #furtherfasterstronger #runtoinspire #health #run #trailrunning #instarunner #runner #runway #healthy #fitness #trailrun #running", "#basketball #nba #ballislife #bball #sports #dunk #basketballneverstops #cavs #kobe #lebron #basket #lakers #lebronjames #kobebryant #warriors #stephcurry #ball #striveforgreatness #cleveland #baller #dubnation #nikebasketball #curry #mvp #hoops #kicks #clevelandcavaliers #theland #stephencurry #cavsnation"};
    String[] strnm = {"Cheerleading", "Hockey", "Football", "Dance", "Sport", "Skate Boarding", "Swimming", "Gymnastics", "Boxing", "Bodybuilding", "Baseball", "Running", "Basketball"};

   @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_all, viewGroup, false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        tag_adapter = new Tag_Adapter(getActivity(), this.str, this.strnm);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(tag_adapter);
        tag_adapter.notifyDataSetChanged();
        return inflate;
    }
}