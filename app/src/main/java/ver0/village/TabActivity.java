package ver0.village;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import ver0.village.utils.BaseActivity;
import ver0.village.utils.CustomViewPager;
import ver0.village.utils.TabPagerAdapter;

public class TabActivity extends BaseActivity {

    TabLayout tabLayout;
    CustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.pager);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.house));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.chat));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.bell));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.upload));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Initializing ViewPager
        viewPager = findViewById(R.id.pager);

        // Creating TabPagerAdapter adapter
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setPagingEnabled(false);

        // Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
