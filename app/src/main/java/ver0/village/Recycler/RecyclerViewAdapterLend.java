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
import ver0.village.LendDetailActivity;
import ver0.village.R;

import java.util.ArrayList;

public class RecyclerViewAdapterLend extends RecyclerView.Adapter<RecyclerViewAdapterLend.ViewHolder> {
    private ArrayList<RecyclerViewItemLend> itemList = new ArrayList<RecyclerViewItemLend>();
    Context context;

    private static ClickListener clickListener;

    public interface ClickListener{
        void onItemClick(int position, View v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        View totalView;
        TextView titleText;
        TextView nameText;
        TextView priceText;
        ImageView profileImage;
        ImageView productImage;
        ImageView likeBtn;

        public ViewHolder(View view){
            super(view);
            view.setOnClickListener(this);

            totalView = view;
            titleText = view.findViewById(R.id.titleText);
            nameText = view.findViewById(R.id.nameText);
            priceText = view.findViewById(R.id.priceText);
            profileImage = view.findViewById(R.id.profileImage);
            productImage = view.findViewById(R.id.productImage);
            likeBtn = view.findViewById(R.id.likeBtn);
        }

        @Override
        public void onClick(View v){
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }


    public RecyclerViewAdapterLend(){

    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_lend, parent, false);
        context = parent.getContext();
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        final RecyclerViewItemLend item = itemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        holder.titleText.setText(item.getTitle());
        holder.nameText.setText(item.getName());
        holder.priceText.setText(item.getPrice());
        holder.profileImage.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21) {
            holder.profileImage.setClipToOutline(true);
        }

        if(item.getIsLike()){
            holder.likeBtn.setImageResource(R.drawable.like);
        }
        else{
            holder.likeBtn.setImageResource(R.drawable.unlike);
        }

        holder.totalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LendDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String title, String name, String price, boolean isLike) {
        RecyclerViewItemLend item = new RecyclerViewItemLend();
        item.setTitle(title);
        item.setName(name);
        item.setPrice(price);
        item.setIsLike(isLike);

        itemList.add(item);
    }


    public void setOnItemClickListener(ClickListener clickListener){
        RecyclerViewAdapterLend.clickListener = clickListener;
    }
}

