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

public class Fragment_Countries extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#europeancountries #europe #sosnicaragua #queserindatumadre #mexico #caribe #centroamerica #libertad #crisisnicaragua #suramerica #usa #prayfornicaragua #pray #sosmanagua #justicia #azulyblanco #dequesevansevan #belgium #gritopornicaragua #antwerpen #tourist #antwerp #nicaragualibre #compartir #freedom #nicaragua #helpnow #danielortega #elsavalle", "#sicilia #siciliabedda #igerssicilia #igersicilia #sicilian #volgosicilia #vivosicilia #siciliangirl #loves_sicilia #ig_sicilia #ig_sicilians #likes_sicilia #sicilianjourney #sicilianfood #sicilians_world #sicilia_nel_sangue #siciliano #siciliana #instasicilia #sicilianinsta #kings_sicilia #loves_united_sicilia #igsicilia #tradizionisicilia #nuevossicilianos #top_sicilia_photo #cannolosiciliano #sicilia_nel_cuore #citymapsicilia #sicilia_super_pics", "#saudiarabia #riyadh #jeddah #saudi #ksa #qatar #oman #bahrain #kingdomofsaudiarabia #doha #abudhabi #dammam #saudistyle #kuwait #khobar #uae #lebanon #saudi_arabia #middleeast #jeddah_ksa #makkah #madinah #  #emirates  #jeddahcity #saudia #saudinationalday #egypt", "#sardinia #sardegna #igersardegna #lanuovasardegna #sardegnaofficial #instasardegna #volgosardegna #sardiniaexperience #loves_sardegna #focusardegna #sardinien #sardegna_super_pics #vivosardegna #ig_sardinia #sardegnagram #sardegna_reporter #cerdeña #unionesarda #sardiniamylove #cagliari #sardaigne #igerscagliari #loves_united_sardegna #sardegnageographic #thehub_sardegna #bestsardegnapics  #olbia #sardiniaphotos #santeodoro ", "#minsk #belarus  #minskgram #instaminsk #minskcity #belinsta #vscobelarus #vscominsk #brest #vitebsk #instabelarus  #mogilev #belarusgram #minskgood #minskgirl #minsktut  #belarusnow #vscocollection #vscotop  #minskinstagram", "#italy #madeinitaly #ig_italy #whatitalyis #igersitaly #instaitaly #vscoitaly #gf_italy #littleitaly #italytrip #visititaly #loveitaly #italygram #iloveitaly #browsingitaly #huntgramitaly #italyiloveyou #ilikeitaly #igitaly #italya #loves_madeinitaly #italytravel #gayitaly #veniceitaly #igfriends_italy #italytour #travelitaly #weddinginitaly #italyfood #italyfoodporn", "#asianstyle #asianfashion #igasia #igs_asia #asiatrip #asianmen #vscoasia #asianbaby #asiatique #everydayasia #asianbabe #seasia #asiangay #gimnasia #eurasian #rahasiagadis #asiancuisine #hotasian #festaafantasia #asianpersuasion #asiatravel #jualanastasiabeverlyhills #festafantasia #asianboys #asiana #ink361_asia #asiaprince #aplikasiapple #asianeyes #asianart"};
    String[] strnm = {"European Countries", "Sicilia", "Saudi Arabia", "Sardinia", "Minsk", "Italy", "Asia"};

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