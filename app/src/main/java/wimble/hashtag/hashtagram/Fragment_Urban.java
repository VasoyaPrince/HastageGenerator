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

public class Fragment_Urban extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#streetart #graffiti #urbanart #graffitiart #streetarteverywhere #mural #instagraffiti #graffitiporn #sprayart #streetartistry #graff #urbanwalls #spraypaint #wallart #instagraff #wall #stencil #tv_streetart #streetartphotography #rsa_graffiti #streetartist #stencilart #wallporn #graffitiigers #instagrafite #stickerart #dsb_graff #arteurbano #instaart #pasteup", "#property #properties #realty #broker #realtor #realestate #investment #housing #househunting #homesforsale #listing #justlisted #HomeSale #milliondollarlisting #realestateagent #newhome #mortgage #homeinspection #homes #CreditScore #forsale #villa #Foreclosure #dreamhome #condo #creditreport #apartment #renovated #luxuryrealestate #investor", "#citylights #style #urbanwalls #buildings #city #architecture #skyscrapers #architecturephotography #skyscraper #abstract #architecturelovers #urbanoutfitters #architectureporn #lines #citybestpics #urbandecay #architectures #cityview #buildingporn #architexture #instatag #urban #geometric #instagramanet #building #urbanart #citylife #cityscape #cityofbones"};
    String[] strnm = {"Street art", "Property", "Architecture"};

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