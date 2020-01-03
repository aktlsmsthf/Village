package ver0.village;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import ver0.village.Dialog.UploadDialog;
import ver0.village.utils.BaseActivity;
import ver0.village.utils.CustomViewPager;
import ver0.village.utils.TabPagerAdapter;

public class TabActivity extends BaseActivity {

    TabLayout tabLayout;
    CustomViewPager viewPager;

    int prevTab = 0;

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
        final TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setPagingEnabled(false);

        // Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()!=3){
                    viewPager.setCurrentItem(tab.getPosition());
                    prevTab = tab.getPosition();
                }
                else{
                    UploadDialog customDialog = new UploadDialog(TabActivity.this);
                    customDialog.callFunction();
                    tabLayout.getTabAt(prevTab).select();
                }
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
