package com.pointofsalesandroid.androidbasedpos_inventory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.pointofsalesandroid.androidbasedpos_inventory.R;
import com.pointofsalesandroid.androidbasedpos_inventory.Utils;
import com.pointofsalesandroid.androidbasedpos_inventory.models.CategoryModel;

import java.util.ArrayList;

/**
 * Created by Keji's Lab on 26/11/2017.
 */

public class RecycleItemCategoryAdapter extends RecyclerView.Adapter<RecycleItemCategoryAdapter.MyViewHolder> {

    private ArrayList<CategoryModel> categoryItem;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView text_category;
        public MyViewHolder(View view){
            super(view);
               text_category = (TextView) view.findViewById(R.id.itemCategory);
        }
    }

    public RecycleItemCategoryAdapter(Context c, ArrayList<CategoryModel> categoryItem){
        this.categoryItem = categoryItem;
        this.context = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_recycler_list,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecycleItemCategoryAdapter.MyViewHolder holder, final int position) {
        holder.text_category.setText(categoryItem.get(position).getCategory());
        holder.text_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickLitener.onItemClick(holder.itemView,position);
            }
        });
        holder.text_category.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                monItemLongClickListener.onItemLongClick(holder.itemView,position);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryItem.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

    }
    public interface OnItemLongClickListener{
        void onItemLongClick(View view, int posistion);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickListener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    private OnItemLongClickListener monItemLongClickListener;

    public void setonItemLongClickListener(OnItemLongClickListener monItemLongClickListener){
        this.monItemLongClickListener = monItemLongClickListener;
    }
}
