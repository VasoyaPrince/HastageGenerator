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

public class Fragment_Food extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#berries #vegan #fruit #breakfast #food #healthyfood #healthy #yummy #delicious #summer #foodie #chocolate #eatclean #fruits #nature #foodporn #health #instafood #plantbased #blueberries #nutrition #cake #healthylifestyle #blueberry #organic #cleaneating #dessert #veganfood #tasty ", "#sushi #follow #food #like #dinner #lunch #foodporn #foodie #f #sashimi #sushitime #foodstagram #salmon #instafood #followme #sushilovers #japan #japanese #japaneserestaurant #followforfollow #sushiroll #instalike #restaurant #brisbane #love #followmefollowyou #tflers #redbankplains #brisbanerestaurant ", "#postworkout #fitness #protein #preworkout #fit #bodybuilding #chocolate #body #fitgirl #optipep #carbery #vitaminasysuplementos #muscleforce #wetrainwithmf #nosugar #hidrolizado #new #laboratorio #products #fabricacion #novapharma #nocarbo #magazine #probiotic #digestion #salud #video #workout #gym ", "#pizza #food #route #ootd #chicagofood #chicago #college #bio #starbucks #cubs #vibes #anime #berwyncarshow #money #thegrove #twitch #berwyn #lollapalooza #losangeles #filmmaking #carshow #lolla #stonergirl #rich #tailopez #shameless #pilsen #hollywood #california", "#veganfood #vegan #plantbased #veganism #vegansofig #veganlife #healthyfood #veganfoodshare #whatveganseat #govegan #food #veganrecipes #vegansofinstagram #vegano #vegetarian #veganfoodporn #crueltyfree #foodporn #vegancommunity #veganlifestyle #vegans #vegangirl #foodie #veganpower #plantbaseddiet #healthy #veganeats #vegandinner #veganbreakfast", "#summerfood #food #healthyfood #summer #instafood #foodie #foodporn #foodblogger #foodphotography #healthylifestyle #salad #feedfeed #lunch #nutrition #delicious #vegan #vegetarian #yummy #healthyeating #instagood #foodphoto #picoftheday #glutenfree #dessert #fitfood #homemadefood #summertime #thekitchn #eggs", "#healthyeating #healthyfood #healthylifestyle #weightloss #healthy #fitness #healthylife #cleaneating #weightlossjourney #slimmingworld #health #food #diet #nutrition #foodie #slimmingworlduk #eatclean #healthyliving #foodporn #vegan #healthychoices #fitfam #sw #protein #slimmingworldfood #fit #workout #fitnessmotivation #gym", "#healthfood #iherb #vitamins #naturalfood #prebiotic #nutritional #jarrowformulas #solgar #colic #nowfoods #enzymes #immunity #bvitamins #vitaminc #antioxidant #multivitamin #superfoods #vegan #organic #health #healthy #methly #antidepressant #htp #biotin #omega #nutrient #curcumin #supplement", "#fastfood #food #foodporn #foodie #instafood #burger #yummy #pizza #delicious #dinner #breakfast #tasty #errands #lunch #streetfood #fast #foodlover #foodgasm #foodblogger #snacks #foodstagram #fries #fried #junkfood #instagood #foodphotography #cheese #chicken #hamburger"};
    String[] strnm = {"Berries", "Sushi", "Post Workout", "Pizza", "Vegan food", "Summar tasty food", "Healthy eating", "Health food", "Fast food"};

  @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.fragment_all, viewGroup, false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        tag_adapter = new Tag_Adapter(getActivity(), this.str, this.strnm);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(tag_adapter);
        return inflate;
    }
}