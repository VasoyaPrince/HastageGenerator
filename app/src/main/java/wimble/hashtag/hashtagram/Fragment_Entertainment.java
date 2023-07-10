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

public class Fragment_Entertainment extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#fidget #fidgetspinner #like #toy #magical #toys #d #satisfying #spinner #fidgetspinners #bichonfrise #fidgettoy #marvel #fidgets #skilltoy #everydaycarry #majestic #ps #fun #magnets #magnet #follow #asmr #lol #slime #dope #cars #edc #glass", "#pokemon #pokemongo #pikachu #nintendo #pokeball #naruto #teamvalor #attackontitan #teammystic #tokyoghoul #fairytail #teaminstinct #onepiece #manga #pokemonx #pokemontrainer #otaku #pokemonxy #pokemon20 #pokémon #videogames #gamer #pokemoncommunity #charizard #gaming #bleach #gottacatchemall #pokemony #pokemoncards #deathnote", "#news #newspaper #media  #noticias  #breakingnews  #instasports #sportsnews #journalist", "#musicislife #musicfestival #musiclife #instatag #songlyrics #musicians #musiclover #melody #goodmusic #musica #rap #songs #instagramanet #pop #bestsong #electro #musicismylife #dubstep #instamusic #musical #songoftheday #song #music #musician #hiphop #musicvideo #songwriter #rnb", "#comedy #hilarious #lmao #nochill #relatable #jokes #memes #lmfao #humor #comedian #haha #meme #laugh #funnyshit #savage #bruh #textpost #hoodcomedy #vine #funnymemes #niggasbelike #funnyaf #textposts #funnyvideos #standup #ctfu #funnytumblr #instafunny #oktweet #nochillbutton", "#booklove #bookstagram #literature #words #booknerd #bookaholic #bookstore #reading #bookaddict #read #reader #instagramanet #readingtime #books #text #book #bookme #bookworm #instabook #instatag #readingfestival #booknow #stories #booklover #instaread #bookshelf #literatura #bookmark #bookporn", "#movies #videostar #instamovie #moviestar #video #instafilm #videooftheday #movieday #movietime #videos #instavid #instagramanet #videogameaddict #films #filmphotography #instamovies #filming #videoshoot #videogram #instatag #instavideo #film #filme #movie #theatre #сinema #moviedate #filmisnotdead", "#videos #instavideo #tutorial #vine #videooftheday #youtube  #videogram #film #movie #diy #vines #lovely #loveit #videography #hairstyle #inlove #maquiagem #sulawesi #creative #papua #kalimantan", "#disney #disneyland #disneygram #disneyworld #disneyparks #instadisney #waltdisneyworld #disneyside #wdw #disneylove #disneymagic #waltdisney #disneyprincess #mickeymouse #magickingdom #disneyphoto #disneylife #disneyfan #mickey #disneyaddict #tokyodisneyresort #disneylandresort  #disnerd #starwars #disneysea #tokyodisneyland #disneyig #tdl", "#playstation4 #xbox1 #xbox360 #playstation #instatag #instagamer #xboxlive #online #videogameaddict #gaming #videogame #instagamers #xbox #videogames #playtime #winning #onlinegaming #playdate #xboxone #instagaming #games #playing #gaminglife #instagame #player #video #gamestagram #players #instagramanet"};
    String[] strnm = {"Fidget", "Pokemon", "News", "Music", "Comedy", "Book", "Movie", "Video", "Disney", "Game"};

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