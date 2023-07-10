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

public class Fragment_Family extends Fragment {
    public static Tag_Adapter tag_adapter;
    RecyclerView recyclerView;
    String[] str = {"#sister #brother #sis #siblings #sisters #related #fam #bro #brothers #dad #father #mother #familytime #sisterlove #mysister #sisterhood #mom #sistertime #sibling #children #sisterforever #sisterforlife #proudsister #lovemysister", "#birth #birthphotography #doula #birthphotographer #midwife #birthisbeautiful #birthstory #childbirth #parto #pregnancy #breastfeeding #newborn #postpartum #babybump #pregnant #maternity", "#father #dad #related #mother #sis #fam #siblings #bro #brother #familytime #fatherandson #son #sister #brothers #fathersday #fatherhood #sisters #daddy #mom #fatheranddaughter #children #daughter #fathers #grandparents #fatherdaughter #proudfather #dadlife #savior #holyspirit #christ", "#mother #father #mom #related #dad #sister #mama #sis #fam #motherhood #bro #mommy #siblings #daughter #children #brother #familytime #motherdaughter #motherandson #mothers #maternity #brothers #motherlove #sisters #parenthood #motheranddaughter #motherday #mum #mothersday #child", "#kids #children #instakids #kidsfashion #kid #instababy #babies #child #childrenphoto #ig_kids #babygirl #kidsofinstagram #дети #fashionkids #toddler #mom #little #親バカ部 #babyboy #adorable #kidsstyle #play #mother #cutekidsclub #инстадети #familytime #momlife #kids_japan #dad #instagram_kids", "#brothers #siblings #brother #bro #related #sisters #fam #sister #sis #dad #father #familytime #mother #brotherlylove #brotherhood #mom #children #twins #myboys #sons #hermanos #brotherlove", "#pregnancy #pregnant #babybump #momtobe #maternity #mommytobe  #preggo #pregnantbelly #bump #babybelly #fitpregnancy #newborn #pregnantlife #mumtobe #thirdtrimester #birth  #maternitystyle #pregnancystyle #embarazo #motherhood #babyontheway #schwanger #breastfeeding #9месяцев #9months #postpartum"};
    String[] strnm = {"Sister", "Birth", "Father", "Mother", "Babbies Kids", "Brothers", "Pregnancy"};

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