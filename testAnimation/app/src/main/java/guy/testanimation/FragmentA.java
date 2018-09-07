package guy.testanimation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class FragmentA extends Fragment {

    public static FragmentA newInstance() {
        FragmentA fragmentA = new FragmentA();
        return fragmentA;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        RecyclerView reviewsList = rootView.findViewById(R.id.list);
        reviewsList.setHasFixedSize(true);
        reviewsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), VERTICAL);
        reviewsList.addItemDecoration(itemDecor);
        List<Item> items = new ArrayList<>();
        for (char c = 'A';c<='Z';c++) {
            items.add(new Item(""+c));
        }


        ItemAdapter adapter = new ItemAdapter(items, (MainActivity) getActivity());
        reviewsList.setAdapter(adapter);

        return rootView;
    }
}
