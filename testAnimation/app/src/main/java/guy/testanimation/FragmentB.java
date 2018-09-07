package guy.testanimation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    View rootView;
    Item item;
    public static FragmentB newInstance(Item item) {
        FragmentB fragmentB = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ITEM", item);
        fragmentB.setArguments(bundle);
        return fragmentB;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        postponeEnterTransition();

        TransitionSet enterTransitionSet = new TransitionSet();
        enterTransitionSet.addTransition(android.transition.TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        setSharedElementEnterTransition(enterTransitionSet);
        setSharedElementReturnTransition(null);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            item = (Item) arguments.getSerializable("ITEM");
            ((TextView)rootView.findViewById(R.id.details_title)).setText(item.getText());
            rootView.findViewById(R.id.details_title).setTransitionName(item.getText());
            startPostponedEnterTransition();
        }

        return rootView;
    }

    public void setItem(Item item) {
        this.item = item;
        if (rootView != null) {
            ((TextView)rootView.findViewById(R.id.details_title)).setText(item.getText());
        }
    }
}
