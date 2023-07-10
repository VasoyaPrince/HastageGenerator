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

public class Fragment_Life extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#school #schoolflow #schoolsucks #schooltime #schoolgirl #schooltrip #schooldays #schoolday #schooltomorrow #schoollife #class #classof2018 #classof2019 #classmates #classmate #classroom #classe #classes #teacher #teachers #teacherlife #student #students #studentlife #instaschool #instagramanet #instatag #bored #books #book", "#learning #instatag #science #college #student #collegebound #collegedays #instacollege #collegestudent #collegelife #studentlife #collegegirl #learnlife #studying #collegefriends #students #book #classmates #bored #books #collegeproblems #instagramanet #knowledge #study #learn #classmate", "#strong #cardio #exercise #train #fitnessaddict #muscle #getfit #fitnessmodel #abs #determination #active #running #crossfit #gymlife #instafit #instahealth #shredded #run #strength #nopainnogain #trainhard #fitnessmotivation #cleaneating #aesthetics #healthychoices #physique #gains #body #dedication #beastmode", "#officemate #business #businessman #life #working #workinprogress #biz #workout #instajob #instatag #office #jobs #workhard #ilovemyjob #workshop #workingout #atwork #instagramanet #officelife #workhardplayhard #job #instawork #businesswoman #businesstrip #workflow #work #businessowner #jobb #dayjob", "#psychology #psychologist #mentalhealth #psicologia #philosophy #exercise #nutrition #wellness #cleaneating #active #weightloss #instahealth #strong #fitnessaddict #cardio #healthychoices #fitnessmodel #getfit #train #determination #healthyfood #healthylifestyle #muscle #healthyliving #abs #instafit #gymlife #organic #fitlife #healthyeating", "#spiritual #spirituality #meditation #consciousness #enlightenment #universe #awakening #thirdeye #loveandlight #wisdom #lightworker #chakra #metaphysical #crystals #energy #meditate #spirit #knowledge #soul #zen #namaste #chakras #peace #healing #hippie #psychic #lawofattraction #newage #manifest #mind", "#dollar #moneyteam #moneymaker #payda #moneygram #cashout #greens @instagramanet #cash #money #bank #benjamins #dollars #cashflow #moneymotivated #instatag #instacash #cashmoney #moneyonmymind #cashton #instagramanet #instagold #benjamin #cashfollowtrain #crisp #capital #crispy #moneypak #gold", "#bussiness #money #success #entrepreneur #motivation #like #startup #marketing #love #startups #pro #millionaire #likes #empresario #frases #forexsignals #forextrading #bitcoin #entrepreneurlife #riqueza #frasedeldia #exito #investing #motivationalquotes #foco #motivacion #empreendedor #binary #forexlifestyle"};
    String[] strnm = {"School", "Collage", "Training", "Work", "Psychology health", "Spiritual", "Money", "Bussiness"};

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