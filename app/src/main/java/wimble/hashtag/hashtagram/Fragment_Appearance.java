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

public class Fragment_Appearance extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#eyeless #art #artist #digital #oc #mm #blind #redrose #memes #originalcharacter #arts #mywork #myart #work #rose #app #furryart #wolf #meme #update #furry #red #eyelessjack #picsart #fursona #style #glitch #myoc #eyelesscatsofinsta", "#fashionhair #hairstylist #longhair #hairs #curly #hairstyles #hairoftheday #hairup #hairstyle #instagramanet #braid #haircut #coolhair #instatag #instahair #hairofinstagram #hairfashion #blonde #black #brown #straighthair #haircolor #hairdo #hairideas #brunette #hair #haircolour", "#nailgasm #nailsdone #instatag #nailaddict #instanail #naildesigns #nailsofinstagram #nailsdesign #instagramanet #nailsoftheday #nails2inspire #nailedit #nailartaddict #nailporn #nails #nail #nailpromote #nailsalon #nailsofig #instanails #nailsdid #nailstyle #nailsart #nailstagram #naildesign #nailartwow #nailswag #nailart", "#makeupjunkie #lip #cosmetics #makeupbyme #makeuplover #makeupaddict #palettes #makeupartist #powder #mascara #eyes #makeup #lashes #instagramanet #instatag #lipstick #tar #eyebrows #concealer #cosmetic #pomade #instamakeup #gloss #lips #eyeliner #foundation #makeupforever #eyeshadow #lash", "#beautyblogger #eyes #cosmetics #makeupaddict #lipstick #skincare #instabeauty #lips #instamakeup #lashes #makeupjunkie #motd #stylish #makeuplover #hudabeauty #wakeupandmakeup #nailart #gorgeous #hairstyle #anastasiabeverlyhills #eyeshadow #glam #natural #bblogger", "#lipstick #lips #eyeshadow #eyeliner #mascara #cosmetics #lip #foundation #lashes #eyebrows #gloss #instamakeup #concealer #palettes #cosmetic #makeupaddict #powder #crease #base #primers #lash #glitter #eyes #lipgloss #glue #makeupjunkie #makeuplover #tar #liquidlipstick #beautyblogger", "#eye #batom #cabelo #unhas #eyes #lashes #make #eyelash #maquiagem #eyelashes #eyedrawing #tutorial #videos #inlove #eyemakeup #lips #lipstick #eyesshadow #eyeshadow #instaeyes #eyeshadowpalette #eyebrows #eyeliner #prettyeyes #eyeball #brighteyes #makeupaddict #eyesmakeup #angeleyes #darkeyes", "#hairstyle #haircut #haircolor #hairstylist #hairstyles #longhair #eyes #blonde #instahair #hairdo #hairfashion #balayage #lips #ombre #hairdresser #hairofinstagram #barber #hairoftheday #curly #curls #naturalhair #brunette #modernsalon #color #braid #stylist #stylish #haircolour #curlyhair #pink", "#mylook #outfit #ootdshare #outfitpost #ootdmagazine #outfitoftheday #instagramanet #beautiful #mylooktoday #look #fashion #style #lookoftheday #whatiwore #fashionpost #instatag #outfits #wiw #fashiongram #instafashion #instastyle #fashiondiaries #todayimwearing #ootdindo #whatiworetoday #clothes #ootd #todaysoutfit #lookbook", "#brows #microblading #browsonfleek #lashes #eyebrows #highlight  #contour #browgame #permanentmakeup #brow #motd #anastasiabeverlyhills #micropigmentation #semipermanentmakeup #browsonpoint #eotd #eyebrowsonfleek #browhenna #wakeupandmakeup #hairstrokes #waxing #eyeshadow #eyeliner"};
    String[] strnm = {"Eyeless", "Hairstyle", "Nails", "Makeup", "Beauty", "lipstick", "Eyes", "Hair", "Look", "Brows"};

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