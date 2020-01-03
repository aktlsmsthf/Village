package ver0.village.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ver0.village.R;
import ver0.village.Slider.SlideAdapterHome;

public class HomeFragment extends Fragment {

    ViewPager viewPager;
    SlideAdapterHome slideAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewPager);

        slideAdapter = new SlideAdapterHome(getContext());
        viewPager.setAdapter(slideAdapter);

        return view;
    }
}
