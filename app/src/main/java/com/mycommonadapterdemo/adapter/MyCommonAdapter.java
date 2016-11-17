package com.mycommonadapterdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mycommonadapterdemo.bean.BasicBean;

import java.util.List;


/**
 * 基础的适配器基类
 *
 * @author wyb
 */
public abstract class MyCommonAdapter<T extends BasicBean> extends BaseAdapter implements View.OnClickListener {
    protected List<T> mData;
    protected final int mItemLayoutId;
    private Context mContext;

    public MyCommonAdapter(Context mContext, int itemLayoutId, List<T> mData) {
        this.mData = mData;
        this.mItemLayoutId = itemLayoutId;
        this.mContext = mContext;
    }

    public int getCount() {
        return mData.size();
    }

    public T getItem(int position) {
        return mData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        getView(viewHolder, getItem(position));
        return viewHolder.getConvertView();

    }

    public abstract void getView(ViewHolder helper, T item);

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);
    }

}
