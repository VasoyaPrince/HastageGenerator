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

public class Fragment_People extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#beautiful #portrait #selfiequeen #selfiesfordays #selfienation #me #portraits #instaselfie #selfiesaturday #selfietime #igersoftheday #eyes #instagramanet #love #instatag #faceoftheday #selfiesunday #selfiestick #cute #selfies #igers #follow #instame #girls #face #selfiee #selfie #likeme #selfieoftheday", "#guys #boys #guy #vday #followforlikeback #directioner #1direction #hotguys #beawesome #men #bebold #dude #partying #lovedirectioners #nialler #niallerhoran #instaparty #nialhoranfacts #niallers #niallisperfect #niallerwins #niallisbeautiful #1d #niallimagine #socialmediamarketing #kickinit #malik #handsome #man #nialljameshoran", "#people #streetphoto #social #socialmedia #contestalert #socialmediamarketing #sweepstakes #branding #deal #smallbiz #socialmediatips #semplicity #marketing #media #tech #discount #sales #socialite #getcreative #socialmarketing #beawesome #entrepreneurship", "#peace #happiness #live #couple #dating #relationshipadvice #relationships #truthbetold #imjustsaying #nolie #straightup #reallytho #quotekillahs #breakups #thatpart #worstfeeling #lovingyou #trustissues #factsonly #truestory #loyalty #accurate #wordstoliveby #message #realtalk #facts #reallove #relationshipquotes #singles #trust #onlinedating #truelove #LoveLanguage #lonely", "#peace #happiness #live #couple #friend #friendship #bestfriend #instafun #besties #goodtime #bff #bestfriends #crazy #chill #bf #laughing #goodfriends #joking #memories #funnypictures #goodtimes #wacky #joke #witty #silly #best #instahappy #jokes #partying #hilarious #instaparty #lovethem #laugh #forever", "#goodnight #boanoite #buenasnoches #iyigeceler #buonanotte #sweetdreams #sleep #bonnenuit #bedtime #goodday #sleepy #tired #good #gutenacht #bed", "#morning #bomdia #breakfast #buongiorno #buenosdias #gutenmorgen #sunrise #bonjour #goodday #доброеутро #günaydın #goodnight #sunshine #wakeup #good #day #early #gunaydin", "#hot #girlsnight #ladiesnight #follow #beautiful #lady #woman #instagood #instalike #girl #girlswholikegirls #followme #russianwomen #me #followback #ladies #instagirls #girlsgeneration #girlsday #girlsbestfriend #swag #instadaily #womencrushwednesday #instagramanet #womancrushwednesday #love #girls #women #instatag #cute", "#blond #blondhair #frankocean #blondehair #blondgirl #blonde #loiro #blondie #loira #wella #shatush #loirodossonhos #olaplex #cabelo "};
    String[] strnm = {"Selfie", "Guys", "Social People", "Love Dating", "Love Friend", "Good night", "Good Morning", "Girls", "Blond"};

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