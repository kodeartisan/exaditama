package com.exaditama.testapp.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by kodeartisan on 28/12/17.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder> {

    public static final String TAG = BaseAdapter.class.getSimpleName();

    protected List<T> mData = new ArrayList<>();
    protected T mIdentifier;
    protected Context mContext;
    protected LayoutInflater mLayoutInflater;
    protected ItemClickListener mItemClickListener;
    protected ItemLongClickListener mItemLongClickListener;

    public BaseAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        holder.fillView(position);
        holder.itemView.setOnClickListener(view -> {
            if(mItemClickListener != null) {
                mItemClickListener.onItemClick(position, mData.get(0).getClass());
            }
        });
        holder.itemView.setOnLongClickListener(view -> {
            if(mItemLongClickListener != null) {
                mItemLongClickListener.onItemLongClick(position);
            }

            return true;
        });
    }

    public void setData(List<T> data) {

        if(data == null || data.isEmpty()) {
            mData.clear();
        } else {
            mData = new ArrayList<>(data);
        }
        notifyDataSetChanged();
    }

    public void addSingleData(T data) {
        mData.add(data);
    }



    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setItemClickListener(ItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public void setItemLongClickListener(ItemLongClickListener listener) {
        this.mItemLongClickListener = listener;
    }

    public interface ItemClickListener<T> {
        void onItemClick(int position, Class<?> classz);
    }

    public interface ItemLongClickListener {
        void onItemLongClick(int position);
    }

    protected abstract class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected abstract void fillView(int position);

    }
}