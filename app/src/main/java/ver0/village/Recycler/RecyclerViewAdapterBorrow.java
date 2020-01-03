package ver0.village.Recycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.Image;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ver0.village.BorrowDetailActivity;
import ver0.village.R;

import java.util.ArrayList;

public class RecyclerViewAdapterBorrow extends RecyclerView.Adapter<RecyclerViewAdapterBorrow.ViewHolder> {
    private ArrayList<RecyclerViewItemBorrow> itemList = new ArrayList<RecyclerViewItemBorrow>();
    Context context;

    private static ClickListener clickListener;

    public interface ClickListener{
        void onItemClick(int position, View v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        View totalView;
        Button urgentBtn;
        TextView titleText;
        TextView nameText;
        ImageView profileImage;

        public ViewHolder(View view){
            super(view);
            view.setOnClickListener(this);

            totalView = view;
            urgentBtn = view.findViewById(R.id.urgentBtn);
            titleText = view.findViewById(R.id.titleText);
            nameText = view.findViewById(R.id.nameText);
            profileImage = view.findViewById(R.id.profileImage);
        }

        @Override
        public void onClick(View v){
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }


    public RecyclerViewAdapterBorrow(){

    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_borrow, parent, false);
        context = parent.getContext();
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        final RecyclerViewItemBorrow item = itemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        if(item.getIsUrgent()){
            holder.urgentBtn.setBackground(ContextCompat.getDrawable(context, R.drawable.urgent));
            holder.urgentBtn.setText(context.getString(R.string.urgent));
        }
        else{
            holder.urgentBtn.setBackground(ContextCompat.getDrawable(context, R.drawable.normal));
            holder.urgentBtn.setText(context.getString(R.string.normal));
        }
        holder.titleText.setText(item.getTitle());
        holder.nameText.setText(item.getName());
        holder.profileImage.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21) {
            holder.profileImage.setClipToOutline(true);
        }

        holder.totalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BorrowDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(boolean isUrgent, String title, String name) {
        RecyclerViewItemBorrow item = new RecyclerViewItemBorrow();
        item.setIsUrgent(isUrgent);
        item.setTitle(title);
        item.setName(name);

        itemList.add(item);
    }


    public void setOnItemClickListener(ClickListener clickListener){
        RecyclerViewAdapterBorrow.clickListener = clickListener;
    }
}

