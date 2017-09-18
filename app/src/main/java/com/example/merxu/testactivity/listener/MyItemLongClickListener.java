package com.example.merxu.testactivity.listener;

import android.view.View;

import com.example.merxu.testactivity.bean.MyItemBean;

import java.util.List;

public interface MyItemLongClickListener {
	public void onItemLongClick(View view, int postion,List<MyItemBean> mData);
}
