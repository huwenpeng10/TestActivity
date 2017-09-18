package com.example.merxu.testactivity.viewholder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

import com.example.merxu.testactivity.R;
import com.example.merxu.testactivity.bean.MyItemBean;
import com.example.merxu.testactivity.listener.MyItemClickListener;
import com.example.merxu.testactivity.listener.MyItemLongClickListener;

import java.util.ArrayList;
import java.util.List;


public class MyViewHolder extends ViewHolder implements OnClickListener,OnLongClickListener{

//	public ImageView iv;
	public TextView tv;
	private MyItemClickListener mListener;
	private MyItemLongClickListener mLongClickListener;
	private List<MyItemBean> mData = new ArrayList<>();
	
	public MyViewHolder(View arg0,MyItemClickListener listener,MyItemLongClickListener longClickListener,List<MyItemBean> mData) {
		super(arg0);
//		iv = (ImageView)arg0.findViewById(R.id.item_iv);
		tv = (TextView)arg0.findViewById(R.id.item_tv);
		this.mData = mData;
		this.mListener = listener;
		this.mLongClickListener = longClickListener;
		arg0.setOnClickListener(this);
		arg0.setOnLongClickListener(this);
	}

	/**
	 * �������
	 */
	@Override
	public void onClick(View v) {
		if(mListener != null){
			mListener.onItemClick(v,getPosition(),mData);
		}
	}

	/**
	 * ��������
	 */
	@Override
	public boolean onLongClick(View arg0) {
		if(mLongClickListener != null){
			mLongClickListener.onItemLongClick(arg0, getPosition(),mData);
		}
		return true;
	}

}
