package com.example.totalbattle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;
    private List<Model> mItems;
    private final OnItemClickListener listener;
    public Adapter(Context context, List<Model> items, OnItemClickListener listener) {
        mContext = context;
        mItems = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_view_columnist_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model itemData = mItems.get(position);

        holder.image.setImageResource(itemData.getImage());
        holder.name.setText(itemData.getName());
        holder.point.setText("Point: " + itemData.getPoint());
        holder.sum.setText(itemData.getSum() + "");


        holder.plus.setOnClickListener(view -> {
            int x = itemData.getSum() + 1;
            itemData.setSum(x);
            holder.sum.setText(x + "");
            listener.onItemClick(itemData.getKey(), 1, itemData.getPoint());
        });

        holder.neg.setOnClickListener(view -> {
            if (itemData.getSum() > 0) {
                int x = itemData.getSum() - 1;
                itemData.setSum(x);
                holder.sum.setText(x + "");
                listener.onItemClick(itemData.getKey(), -1, -itemData.getPoint());
            }
        });


        // Set progress bar visibility
//        holder.progressView.setVisibility(itemData.isProgressBarVisible() ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView point;
        TextView sum;
        CardView neg;
        CardView plus;


        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            point = itemView.findViewById(R.id.point);
            sum = itemView.findViewById(R.id.sum);
            neg = itemView.findViewById(R.id.neg);
            plus = itemView.findViewById(R.id.plus);
        }
    }


    public interface OnItemClickListener {
        void onItemClick(String key, int sum, int point);
    }
}
