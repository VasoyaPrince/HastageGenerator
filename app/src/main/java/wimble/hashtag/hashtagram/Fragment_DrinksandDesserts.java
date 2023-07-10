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

public class Fragment_DrinksandDesserts extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#energydrinks #energydrink #energy #energyboost #goodenergy #monsterenergy #energydiet #energyhealing #energyslim #energypro #energysmart #energybooster #energywork #energyballs #energyhealer #energydrinkaddiction #instalike #energyfood #energydrinkneeded #energybites #energydrinktime #preworkout #happy #lifestyle #drink #drinks #bestenergydrink #energydrinkaddict #energyefficiency", "#chocolate #food #cake #foodporn #yummy #instafood #delicious #sweet #dessert #desserts #foodie #strawberry #icecream #love #yum #instagood #cakes #homemade #tasty #cookies #brigadeiro #vegan #baking #coffee #nutella #healthy #birthdaycake #foodgasm #foodblogger", "#instagramanet #tealovers #mug #instatea #teaoftheday #tealover #instatag #teaholic #teastagram #teaaddict #hot #teagram #teatime #tealove #drink #tealife #teacup #ilovetea #healthy", "#thirstythursday #slurp #slurpee #instadrink #drinkdrankdrunk #beerme #drinking #bar #drinkin #beerporn #beer #instatag #beers #drinkporn #drinkup #thirsty #bars #cocktail #wine #beerstagram #thirst #instadrinks #instagramanet #cocktails #drink #drinklocal #beerpong #winetasting", "#coffeeoftheday #cafelife #coffeegram #coffeesesh #coffeeholic #instacoffee #instagramanet #coffeeaddict #coffeeshop #coffeecup #coffeelover #coffeedate #instatag #coffeemug #coffeelovers #coffeebreak #coffeebean #coffeetime #caffeine #coffeehouse #coffeelife #coffeeporn #drink #hot #coffee #coffeelove #coffeeart", "#tasty #yum #cake #dessertforbreakfast #desserts #dessertbuffet #dessertoftheday #instatag #desserttime #delicious #chocolate #instagramanet #instafood #dessertporn #food #eat #dessertbar #foodporn #sweet #icecream #dessertstagram #food #yummy #dessertlover #dessertporn #desserttable #delish #foods #dessert"};
    String[] strnm = {"Energy Drinks", "Chocolate", "Tea", "Drinks", "Coffee", "Dessert"};

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