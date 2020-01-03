package ver0.village.Slider;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ver0.village.BorrowDetailActivity;
import ver0.village.R;
import ver0.village.Recycler.RecyclerViewAdapterBorrow;
import ver0.village.Recycler.RecyclerViewAdapterLend;

public class SlideAdapterHome extends PagerAdapter {

    Context context;
    LayoutInflater inflater;



    public SlideAdapterHome(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view==(ConstraintLayout)obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_home,container,false);

        TextView typeText = view.findViewById(R.id.typeText);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = null;

        if(position==0){
            typeText.setText(context.getString(R.string.borrowTitle));

            RecyclerViewAdapterBorrow borrowAdapter = new RecyclerViewAdapterBorrow();

            borrowAdapter.addItem(true, "축구화 빌립니다.", "이창훈");
            borrowAdapter.addItem(false, "축구공 빌립니다.", "박성주");
            borrowAdapter.addItem(true, "축구화 빌립니다.", "이창훈");
            borrowAdapter.addItem(false, "축구공 빌립니다.", "박성주");
            borrowAdapter.addItem(true, "축구화 빌립니다.", "이창훈");
            borrowAdapter.addItem(false, "축구공 빌립니다.", "박성주");
            borrowAdapter.addItem(true, "축구화 빌립니다.", "이창훈");
            borrowAdapter.addItem(false, "축구공 빌립니다.", "박성주");
            borrowAdapter.addItem(true, "축구화 빌립니다.", "이창훈");
            borrowAdapter.addItem(false, "축구공 빌립니다.", "박성주");
            borrowAdapter.addItem(true, "축구화 빌립니다.", "이창훈");
            borrowAdapter.addItem(false, "축구공 빌립니다.", "박성주");
            borrowAdapter.addItem(true, "축구화 빌립니다.", "이창훈");
            borrowAdapter.addItem(false, "축구공 빌립니다.", "박성주");

            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.addItemDecoration(new DividerItemDecoration((Activity)context, DividerItemDecoration.VERTICAL));
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(borrowAdapter);


        }
        else{
            typeText.setText(context.getString(R.string.lendTitle));

            RecyclerViewAdapterLend lendAdapter = new RecyclerViewAdapterLend();

            lendAdapter.addItem("축구공 빌려드립니다.", "박성주", "10000원", true);
            lendAdapter.addItem("축구화 빌려드립니다.", "이창훈", "20000원", false);
            lendAdapter.addItem("축구공 빌려드립니다.", "박성주", "10000원", true);
            lendAdapter.addItem("축구화 빌려드립니다.", "이창훈", "20000원", false);
            lendAdapter.addItem("축구공 빌려드립니다.", "박성주", "10000원", true);
            lendAdapter.addItem("축구화 빌려드립니다.", "이창훈", "20000원", false);
            lendAdapter.addItem("축구공 빌려드립니다.", "박성주", "10000원", true);
            lendAdapter.addItem("축구화 빌려드립니다.", "이창훈", "20000원", false);


            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.addItemDecoration(new DividerItemDecoration((Activity)context, DividerItemDecoration.VERTICAL));
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(lendAdapter);
        }

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
