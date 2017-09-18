package com.example.merxu.testactivity.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.merxu.testactivity.R;
import com.example.merxu.testactivity.bean.MyItemBean;
import com.example.merxu.testactivity.listener.MyItemClickListener;
import com.example.merxu.testactivity.listener.MyItemLongClickListener;
import com.example.merxu.testactivity.viewholder.MyViewHolder;

import java.util.List;


public class MyAdapter extends Adapter<MyViewHolder> {

	private List<MyItemBean> mData;
	private MyItemClickListener mItemClickListener;
	private MyItemLongClickListener mItemLongClickListener;
	private MyItemBean entity;
	
	public MyAdapter(List<MyItemBean> data){
		this.mData = data;
	}
	
	@Override
	public int getItemCount() {
		return mData.size();
	}

	
	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		entity = mData.get(position);
		holder.tv.setText(entity.getTv());
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
		MyViewHolder vh = new MyViewHolder(itemView,mItemClickListener,mItemLongClickListener,mData);
		return vh;
	}

	/**
	 * ����Item�������
	 * @param listener
	 */
	public void setOnItemClickListener(MyItemClickListener listener){
		this.mItemClickListener = listener;
	}
	
	public void setOnItemLongClickListener(MyItemLongClickListener listener){
		this.mItemLongClickListener = listener;
	}
}
