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

public class Fragment_Promotion extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#vlog #vlogger #youtube #blogger #blog #youtuber #follow #vlogging #video #funny #love #vloggers #vloglife #youtubers #vlogsquad #like #vloger #travelblogger #youtubechannel #instagram #vloggerlife #blogpost #bloggersgetsocial #subscribe #bloggergirl #bloggerlifestyle #vlogs #blogs #lifestyle ", "#blog #blogger #fashion #fashionblogger #photography #love #ootd #style #travel #vintage #fashionista #outfitoftheday #f #model #vlog #food #instafashion #fashiondiaries #makeup #instagood #follow #instagram #o #styleblogger #lifestyle #like #photooftheday #beauty #lookbook ", "#vines #memes #funny #vine #r #karikat #funnymemes #meme #lol #dankmemes #k #instagram #rk #kad #jokes #instagood #memesdaily #comedy #fortnite #worldstar #funnyvideos #lmao #cringe #edgymemes #dank #viral #follow #rkiye #edgy ", "#blogvlog #pune #sportforeverybody #blogger #futuretechmates #aardbei #newspaper #radio #communication #aardbeitjes #trucje #vlogger #vlog #blog #trucjes #media #doubletap #likeforlikes #publicrelations #pr #foodblogger #commentforcomment #followforfollowback #prmarketingpune #prmarketing #digitalmarketingpune #digitalmarketing #vlogblog #just ", "#nl #nlstar #prilaga #nlinternational #joinmyteam #beauty #moneymaking #energysmartdiet #feelingood #nutrition #clearskin #energypro #energysmart #formum #team #free #fit #sport #businessathome #healthy #amazingproduct #work #family #buildcareer #nlaforher #tasty #money #amazingproducts #dreamteam ", "#amway #nutrilite #artistry #amwayus #amwaylife #amwayhome #diamondalliance #amwayproducts #amwaythailand #motivation #herbalife #amwayteam #amwayindonesia #amwayglobal #amwaycenter #amwayfamily #amwayarena #amwayturkey #prilaga #amwayrussia #amwaygrand #amwaynext #amways #amwayqueen #bodyseries #amwayvenezuela #amwayturkiye #amwaymalaysia #amwaymy "};
    String[] strnm = {"Vlog", "Blog", "Vines", "Blog Vlog", "NLstar", "Amway"};

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