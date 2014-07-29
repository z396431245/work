package com.xunta.android.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.xunta.android.R;
import com.xunta.android.base.BaseFragment;

public class HomeFragment extends BaseFragment implements OnItemClickListener{

	
//	private ListView hotListView=null;
//	private RelativeLayout hotLayout=null;
//	private RelativeLayout nearLayout=null;
//	
	
	@Override
	protected void initPageView() {
//		hotLayout=(RelativeLayout) getActivity().findViewById(R.id.hot_layout);
//		nearLayout=(RelativeLayout) getActivity().findViewById(R.id.near_layout);
//		hotListView =  (ListView) getActivity().findViewById(R.id.hot_list);

	}

	@Override
	protected void initPageViewListener() {
//		hotListView.setOnItemClickListener(this);
	}

	@Override
	protected View loadTopLayout() {
		return getActivity().getLayoutInflater().inflate(R.layout.fragment_home_title, null);
	}

	@Override
	protected View loadContentLayout() {
		return getActivity().getLayoutInflater().inflate(
				R.layout.fragment_home, null);
	}

	@Override
	protected void process(Bundle savedInstanceState) {

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

}
