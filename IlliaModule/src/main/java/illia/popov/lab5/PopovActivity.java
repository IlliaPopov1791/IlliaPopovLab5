package illia.popov.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class PopovActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy{

    //global variables
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);
        titles = new ArrayList<String>();
        titles.add("Home");
        titles.add("Settings");
        titles.add("Favorites");

        new TabLayoutMediator(tabLayout, viewPager2, this).attach();
    }



    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
        switch (position) {
            case 0:
                tab.setText("Home");
                tab.setIcon(R.drawable.ic_home_foreground);
                break;
            case 1:
                tab.setText("Settings");
                tab.setIcon(R.drawable.ic_setting_foreground);
                break;
            case 2:
                tab.setText("Favorites");
                tab.setIcon(R.drawable.ic_favorit_foreground);
                break;
        }
    }
}