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

public class Fragment_Holiday_Celebration extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#halloweencostume #halloweenhorrornights #instagramanet #pumpkins #halloweenie #halloweennails #31 #halloween #halloweenfun #party #halloweenmakeup #halloween2015 #fall #oct #october #instatag #halloweentime #halloween2014 #pumpkin #autumn #halloweenparty #pumpkinpatch #halloweennight #boo #scared #spooky #scary", "#happyday #smiles #instawedding #bestofday #weddingdress #bestday #ceremony #bridesmaids #bride #together #instatag #happy #romance #bestoftheday #bridesmaid #brides #weddingcake #family #weddingday #smiles #weddingphotographer #bridetobe #weddings #weddingphotography #weddingparty #marriage #wedding #love #instagramanet #forever", "#newyears #christmastree #newyear #christmaseve #holidays #christmasparty #green #snow #newyearseve #christmas2015 #bye2015 #christmastime #2015 #2016 #xmas #instagramanet #merrychristmas #happynewyear #hello2016 #newyearsday #holiday #instatag #christmas #christmastree #family #christmas2016 #newyears2016 #winter #christmaslights", "#easter #love #p #jesus #god #phoenix #ques #troms #hdr #instagood #beautiful #nature #dieu #parque #sus #sauv #surrection #ais #j #fran #mots #r #word #saved #world #wedding #english #instafood #bibleapp", "#traveling #holiday #vacationtime #happyholidays #vacations #restday #happydays #instatag #family #bestday #travelling #happy #trip #intagramanet #fun #2018 #travel #vacation #holidays #holidayseason #travelgram #breakaway #happyholidays2018 #holidays2018 #rest #love #happyday #vacation2018", "#newyear #happynewyear #cristmas  #newyearseve  #newyearscelebration #newyearsparty #dec31 #jan1 #christmastree #newyears #merrychristmas #newyearsday #2019 #christmas", "#thanksgivingday #thanksgiving #love #thanksgivingbreak #holiday #instagood #family #stuffing #thanksgivingdinner #thanks #friends #thanksgivingdecor #giving #toptags #food #thanksgivings #familytime #feast #thankful #blessed #thanksgivingfun #givethanks #photooftheday #life #happythanksgiving #celebrate #thanksgivingprep #foodporn #fun", "#valentineday #love #weddingdress #hudabeauty #sephora #partytime #nightout #sale #mensfashion #girls #fashion #shoes #shoppingaddict #bags #shaadi #trendy #brandedbag #vacation #fashiondesigner #valentine #iloveyou #hyderabad #handmadecards #boyfriend #creativity #girlfriend #anniversary #birthday #quotes", "#funtime #music #party #cute #celebrate #goodtimes #smile #funtimes #happy #night #picoftheday #intagramanet #celebrations #bestoftheday #goodtime #fun #memories #instatag #instaparty #smile #amazing #partytime #love #partying #cool #instalike #celebration", "#victorsday #goblue #universityofmichigan #autismmom #michigan #puremichigan #momlife #cheerleaders #autismacceptanceeveryday #chocolatecoveredapples #bronxtreatmaker #mom #twallfoundation #momblog #christeningtime #biggreekfamily #livetolove #lifeisshort #theseriousversion #weareahappyfamily #annarbor #sweettreats #mommyblogger #mommyblog #uofm #momblogger #birthdaytreats #ridepics #fusion", "#dj #birthday #edm #nightlife #club #rave #housemusic #partytime #drinks #tomorrowland #goodtimes #celebrate #beats #festa #plur #dubstep #celebration #goodtime #remix #festival #techno #nightclub #song #djlife #event #fiesta #goodmusic #partymusic #happybirthday #memories"};
    String[] strnm = {"Halloween", "Wedding", "Christmas", "Easter", "Vacations", "New Year", "Thanks Giving Day", "Valentineday", "Birthday", "Victors day", "Party"};

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