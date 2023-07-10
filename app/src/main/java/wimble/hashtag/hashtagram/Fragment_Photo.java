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

public class Fragment_Photo extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#blackandwhite #bnw #monochrome #envywear #PleaseForgiveMe #instablackandwhite #monoart #insta_bw #bnw_society #bw_lover #bw_photooftheday #photooftheday #bw #instagood #bw_society #bw_crew #bwwednesday #insta_pick_bw #bwstyles_gf #irox_bw #igersbnw #bwstyleoftheday #monotone #monochromatic#noir #fineart_photobw", "#photography #streetphotography #travelphotography #naturephotography #foodphotography #weddingphotography #blackandwhitephotography #landscapephotography #fashionphotography #iphonephotography #nikonphotography #portraitphotography #filmphotography #mobilephotography #canonphotography #photographylovers #architecturephotography #macrophotography #toyphotography #nightphotography #photographyislifee #wildlifephotography #photographyislife #photographysouls #photographyeveryday #newbornphotography #urbanphotography #instaphotography #analogphotography #concertphotography", "#macro #macros #macrophotography #macro_perfection #flowersandmacro #macroworld_tr #macromood #rsa_macro #macro_captures #macroclique #macroworld #macro_secrets #macrophoto #ifitfitsyourmacros #macrogardener #tgif_macro #macroshot #macro_holic #bns_macro #fabmacro #macro_spotlight #macro_highlight #macro_x #macrolens #md_macro #macroaddictsanonymous #macro_creature_feature #macrooftheday #my_daily_macro #macrolove", "#vscocam #vsco #vscogood #vscophile #vscorussia #vscogrid #vscodaily #vscogram #vscoph #vscofood #vscobest #bestofvsco #vscophoto #vsconature #vscoedit #vscofilm #vscocamphotos #vscofeature #vscolove #vsco_hub #vscoonly #instavsco #vscolife #vscobrasil #vscostyle #vscoturkey #vscomoscow #vscoaward #vscomoment #vscoukraine", "#hdr #hdriphoneographer #envywear #PleaseForgiveMe #hdrspotters #hdrstyles_gf #hdri #hdroftheday #hdriphonegraphy #hdrepublic #hdr_lovers #awesome_hdr #instagood #hdrphotography #photooftheday #hdrimage #hdr_gallery #hdr_love #hdrfreak #hdrama #hdrart #hdrphoto #hdrfusion #hdrmania #hdrstyles #ihdr #str8hdr #hdr_edits"};
    String[] strnm = {"Black and White", "Photography", "Macro", "vsco", "HDR"};

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