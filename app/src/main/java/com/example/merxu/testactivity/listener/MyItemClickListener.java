package com.example.merxu.testactivity.listener;

import android.view.View;

import com.example.merxu.testactivity.bean.MyItemBean;

import java.util.List;

public interface MyItemClickListener {
	public void onItemClick(View view, int postion,List<MyItemBean> mData);
}
