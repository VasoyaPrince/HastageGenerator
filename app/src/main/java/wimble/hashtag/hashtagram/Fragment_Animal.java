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

public class Fragment_Animal extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#dogoftheday #doglife #puppypalace #dogs #doglover #pets #dogsofinstagram #dogsofig #doglovers #doggy #doggie #ilovemydog #pup #dogs_of_instagram #puppygram #doggies #instagramanet #dogsitting #dogstagram #dogscorner #instagramdogs #instapuppy #pet #doglove #instatag #puppy #dogslife #dog #puppylove", "#catstagram #catoftheday #kitten #cats_of_instagram #kitty #kittylove #catlove #caturday #pets #kittensofinstagram #pet #catwang #catlovers #instatag #cats #catlady #kittens #kittiesofinstagram #kitties #instacat #catwalk #kittycat #instagramanet #cat #catsagram #cathedral #catsofinstagram #catvalentine #catlover", "#horseslove #pony #gallop #mane #nature #horsesofinstagram #ilovemyhorse #ponies #horseswag #horseselfie #horseshows #horseshoe #horselover #horse #jockey #horseshow #riding #instatag #horses_of_instagram #instagramanet #horseshowlife #horses #wild #rider #horseriding #horsestagram #horsesplanet #horse #riders", "#water #aquariumcase #tropical #fishtank #ocean #saltwater #photooftheday #aquariumfish #aquariumofthepacific #tropicalfish #instagramanet #swim #reeftank #fish #instafish #coral #aquarium #aquariumofthebay #aquariumlife #aquariumfun #fishporn #beautiful #fishface #instatag #watertank #reef #tank", "#instabird #birdy #beak #birdman #wing #birdsofinstagram #instagramanet #feathered #bird #wings #feathers #birdstagram #feather_perfection #birdhouse #birdlover #fly #birdwatching #feather #birds #instabirds #flight #birdcage #birdgang #instatag #featheredfriends #birdland #birdie", "#macros #bug #naturelover #macromood #wildlife #insects #nature #instagramanet #bugslife #macrophotography #insect_addict #bugs #photooftheday #closeup #macro_perfection #nature_shooters #macro_secrets #macro #instanature #insectagram #macro #macro_captures #instatag #lovenature #insect #insect_perfection", "#animalgeneral #stemcells #talenttalks #talenttalk #veterinarian #animals #smallanimalclinic #petdoctor #animaltalk #pets #talkinghumans #animaldoctor #animaldoctors #animalcare #emergencyanimals #humantalk #talkinganimals #agedgewater #monday #scaries #weloveourvet #notfeelingwell #bigbaby #puglife #pugs #edgewaternj #listenerquestions #agonhudson #bestface "};
    String[] strnm = {"Dog", "Cats", "Horse", "Fish", "Bird", "Insects", "Animal General"};

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