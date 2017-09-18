package com.example.merxu.testactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.merxu.testactivity.adapter.MyAdapter;
import com.example.merxu.testactivity.bean.MyItemBean;
import com.example.merxu.testactivity.decoration.MyDecoration;
import com.example.merxu.testactivity.listener.MyItemClickListener;
import com.example.merxu.testactivity.listener.MyItemLongClickListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements MyItemClickListener,MyItemLongClickListener {

	private RecyclerView mRecyclerView;

	private List<MyItemBean > mData;
	private MyAdapter mAdapter;
	private TextView textView;
	private int sum;
	private MyItemBean entity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}
	
	/**
	 * ��ʼ��RecylerView
	 */
	private void initView(){
		mRecyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
		textView = (TextView) findViewById(R.id.TextView);
		textView.setText("");
//		MyLayoutManager manager = new MyLayoutManager(this);
//		manager.setOrientation(LinearLayout.HORIZONTAL);//Ĭ����LinearLayout.VERTICAL
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
	}
	
	private void initData(){
		this.mData = new ArrayList<MyItemBean>();
		for(int i=0;i<30;i++){
			MyItemBean bean = new MyItemBean();
			bean.tv = i+"";
			mData.add(bean);
		}
		this.mAdapter = new MyAdapter(mData);
		this.mRecyclerView.setAdapter(mAdapter);
		RecyclerView.ItemDecoration decoration = new MyDecoration(this);
		this.mRecyclerView.addItemDecoration(decoration);
		this.mAdapter.setOnItemClickListener(this);
		this.mAdapter.setOnItemLongClickListener(this);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		int size = mData.size();
//		switch (item.getItemId()) {
//		case R.id.action_add:
//			MyItemBean bean = new MyItemBean();
//			bean.tv = "Xmy"+(size);
//			mData.add(1,bean);
//			mAdapter.notifyItemInserted(1);
//			break;
//		case R.id.action_remove:
//			mData.remove(size-1);
//			mAdapter.notifyItemRemoved(1);
//			break;
//		default:
//			break;
//		}
//		return super.onOptionsItemSelected(item);
//	}

	/**
	 * Item click
	 */
	@Override
	public void onItemClick(View view, int postion,List<MyItemBean> mData) {
		entity = new MyItemBean();
		String result = textView.getText().toString().trim();
		Log.e("TAG","result"+result);
		entity  = mData.get(postion);
		if(!result .equals("")){
			int data=Integer.parseInt(result);
			int num = Integer.parseInt(entity.getTv());
			Log.e("TAG","data"+data);
			Log.e("TAG","num"+num);
			Toast.makeText(this, entity.getTv(), Toast.LENGTH_SHORT).show();
			if(entity.getState() == 0){ //判断是不是第一次点击  0是  1不是
				Log.e("entity.getState ","entity.getState(0) "+ entity.getState() );
				entity.setState(1);
				sum = data + num ;
				textView.setText(sum+"");
			}else{
				Log.e("entity.getState ","entity.getState(1)****** "+ entity.getState() );
				entity.setState(0);
				sum = data - num ;
				textView.setText(sum+"");
			}
		}else{
			textView.setText(entity.getTv());
			entity.setState(1);
		}

	}

	@Override
	public void onItemLongClick(View view, int postion,List<MyItemBean> mData) {
		MyItemBean bean = mData.get(postion);
		if(bean != null){
			Toast.makeText(this, "LongClick "+bean, Toast.LENGTH_SHORT).show();
		}
	}
}
