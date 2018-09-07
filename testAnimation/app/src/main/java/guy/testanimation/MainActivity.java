package guy.testanimation;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("FRAGMENT_A");
        if (fragmentA == null) {
            fragmentA = FragmentA.newInstance();
        }
        fragmentManager.beginTransaction().add(R.id.container, fragmentA, "FRAGMENT_A").commit();
    }

    public void showItem(Item item, View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("FRAGMENT_B");
        if (fragmentB == null) {
            fragmentB = FragmentB.newInstance(item);
        }
        else {
            fragmentB.setItem(item);
        }
        fragmentManager.beginTransaction().addSharedElement(view, item.getText()).replace(R.id.container, fragmentB, "FRAGMENT_B").addToBackStack(null).commit();
    }
}
