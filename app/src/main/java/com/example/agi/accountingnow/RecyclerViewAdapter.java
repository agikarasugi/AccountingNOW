package com.example.agi.accountingnow;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mDateHolder = new ArrayList<>();
    private ArrayList<String> mItemHolder = new ArrayList<>();
    private ArrayList<String> mPriceHolder = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mDateHolder, ArrayList<String> mItemHolder, ArrayList<String> mPriceHolder) {
        this.mDateHolder = mDateHolder;
        this.mItemHolder = mItemHolder;
        this.mPriceHolder = mPriceHolder;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        holder.dateHolder.setText(mDateHolder.get(position));
        holder.priceHolder.setText(mPriceHolder.get(position));
        holder.itemHolder.setText(mItemHolder.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mItemHolder.get(position));

                //ini ke intent
                Intent intent = new Intent(mContext, ListDetail.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_DATE", mDateHolder.get(position));
                extras.putString("EXTRA_ITEM", mItemHolder.get(position));
                extras.putString("EXTRA_PRICE", mPriceHolder.get(position));
                intent.putExtras(extras);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemHolder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dateHolder;
        TextView itemHolder;
        TextView priceHolder;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateHolder = itemView.findViewById(R.id.dateAdd);
            itemHolder = itemView.findViewById(R.id.NameItem);
            priceHolder = itemView.findViewById(R.id.priceItem);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
