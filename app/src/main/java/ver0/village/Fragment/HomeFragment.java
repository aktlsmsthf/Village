package ver0.village.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ver0.village.R;
import ver0.village.Recycler.RecyclerViewAdapterBorrow;
import ver0.village.utils.SlideAdapterHome;

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
