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

public class Fragment_Celebrity extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#taylorswift #selenagomez #arianagrande #demilovato #justinbieber #swiftie #1989 #swifties #taylor #mileycyrus #swift #nickiminaj #kendalljenner #selenator #kimkardashian #onedirection #gainpost #gaintrick #kyliejenner #tayloralisonswift #followtrain #taylena #beyonce #katyperry #speaknow #rihanna #gigihadid #revivaltour #dancemoms #arianator", "#selenagomez #justinbieber #arianagrande #taylorswift #selenator #demilovato #gainpost #gaintrick #revivaltour #selenators #selena #kendalljenner #jelena #onedirection #kyliejenner #followtrain #revival #mileycyrus #gomez #kimkardashian #belieber #gigihadid #nickiminaj #selenamariegomez #arianator #katyperry #dancemoms #fifthharmony #harrystyles #zaynmalik", "#rihanna #singer #rihannanavy #envywear #navy #rihannanavi #rihannafenty #TFLers #rihannadiamonds #instagood #diamonds #unapologetic #riri #photooftheday #music #pop #robyn #fenty #rih #rihnavy #beautiful #pretty #robynfenty", "#katyperry #katyperrysweeps #katyperry84 #katyperryconcert #katyperryfans #ilovekatyperry #votekatyperry #emabiggestfanskatyperry #katyperryjkt #katyperryprismcollection #happybirthdaykatyperry #parfumkatyperry", "#celebrity #celebritystyle #celebritystylist #celebritybarber #celebrityfashion #celebrityhairstylist #celebritycrush #celebritylass #celebrityfitness #celebritymakeupartist #pawcelebrity #celebrityhair #celebritychef #celebritynews #celebrityfitnessindonesia #celebritylook #celebrityhairdresser #celebritymua #celebritygossip #celebritystatus #celebrityskin #celebrityfeet #celebritylookalike #celebritycruises #celebritytrainer #celebrityinspired #celebritysighting #celebritykids #localcelebrity #celebritysaturdays", "#justinbieber #emabiggestfansjustinbieber #justinbieberswag #justinbieberrp #justinbieberimagines #justinbieberfan #happybirthdayjustinbieber #justinbieberimagine #justinbieberhot #justinbieberfans #justinbieberconcert #justinbiebervideos #justinbieberfanpage #ilovejustinbieber #jfcjustinbieber #justinbieberupdates #justinbieberfanfiction #lovejustinbieber #justinbieberedits #justinbieberfanfic #justinbiebernews #justinbiebers #justinbieberedit #justinbiebervideo #justinbieberforever #justinbiebersucks #justinbieberfanfics #justinbieberfunny #justinbieberlove #justinbieberfacts", "#demilovato #demilovatoicons #demilovato_20 #demilovatoconcert #demilovatoedit #demilovatoisperfect #demilovatoworldtour #demilovatofanfic #demilovatoquotes #demilovatorp #demilovatoedits #demilovatostyle #staystrongdemilovato #demilovatofans #demilovatooutfits #demilovatofan #demilovatolive #demilovatofanpage #demilovatoconfident #demilovatoisbeautiful #demilovatolookalike #demilovatovideos #demilovatoconfessions #demilovatoquote #demilovatosexy #demilovatoforever #demilovatoturkey #demilovatolyrics #demilovatovideo #demilovatoismyinspiration", "#beyonceknowles #iheartbeyonce #teambeyonce #beyoncealwaysonbeat #beyoncecarter #queenbeyonce #beyonceconcert #ichoosebeyonce #beyoncefan #istandwithbeyonce #beyonceknowlescarter #ilovebeyonce #beyoncegiselleknowlescarter #beyoncefans #happybirthdaybeyonce #girlslovebeyonce #beyoncegiselleknowles #beyonceandjayz #beyoncelive #beyonceart #jayzandbeyonce #lovebeyonce #instabeyonce #beyhiveforbeyonce #beyoncebelike #welovebeyonce #mybeyonce #beyonceformation #beyoncequotes #beyoncejayz", "#arianagrande #arianagrandebutera #aribyarianagrande #arianagrandefanpage #arianagranderp #arianagrandeupdates #votearianagrande #arianagrandeedit #emabiggestfansarianagrande #arianagrandefollowtrain #arianagrandenews #arianagrandevideos #arianagrandeedits #lovearianagrande #arianagrandedrawing #arianagrandefan #ilovearianagrande #arianagrandefans #arianagrandevideo #arianagrandestyle #vivaglamarianagrande #arianagrandeconcert #arianagrandeupdatesx #frankiebyarianagrande #arianagrandelookalike #aribyarianagrandefragrances #arianagrandeisperfect #arianagrandefacts"};
    String[] strnm = {"Taylor Swift", "Selena Gomez", "Rihanna miley cyrus", "Katy perry", "Celebrity", "Justin Bieber", "Demilovato", "Beyonce", "Ariana grande"};

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