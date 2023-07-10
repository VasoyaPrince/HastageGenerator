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

public class Fragment_Feelings extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#feeling #feelings #emotion #feel #kissing ", "#tired #sleepy #bed #wakingup #sluggish #morn #snooze #wake #daytime #instamorning #awake #gettingready #goingout #earlybird #early #refreshed #sleep #ready #sleepyhead #wakeup #nightynight #sleeptime #bedtime #lightsout #instagoodnight #nightowl #nighttime #passout #knockedout #rest", "#happiness #nice #good #enjoy #adorable", "#sad #depressed #sadness #depression #alone #suicide #suicidal #anxiety #lonely #broken #sadquotes #worthless #grunge #cry #depressing #cutting #crying #selfhate #ana #tears #pain #hate #hurt #anorexia #selfharmmm #death #killme #dead #emo #anorexic", "#meme #memes #lmao #comedy #hilarious #humor #haha #laugh #textpost #lmfao #dankmemes #relatable #nochill #jokes #textposts #dank #savage #joke #funnytumblr #tumblrtextpost #crazy #vine #laughing #funnyshit #funnymemes #tumblrpost #cringe #tumblrfunny #funnypictures #filthyfrank", "#memories #goodtimes #goodtime #besties #friendship #goodfriends #friend #bestfriends #forever #lovethem #chill #bestfriend #throwback #moments #funtimes #childhood #live #partying #best #bff #bf", "#inspire #entrepreneur #inspo #dedication #interior #quotes #quote #quoteoftheday #success #quotestoliveby #instaquote #words #poetry #lovequotes #lifequotes #quotestagram #inspirationalquotes #motivationalquotes #qotd #writer #wisdom #poem #wordporn #writersofinstagram #poetsofinstagram #sad #instaquotes #poems #truth #poetrycommunity"};
    String[] strnm = {"Feeling", "Tired", "Happy", "Sad", "Funny", "Memories", "Inspiration Quotes"};

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