package com.xunta.android.fragment;

import android.os.Bundle;
import android.view.View;

import com.xunta.android.R;
import com.xunta.android.base.BaseFragment;

public class HomeFragment extends BaseFragment{

	@Override
	protected void initPageView() {
		
	}

	@Override
	protected void initPageViewListener() {
		
	}

	@Override
	protected View loadTopLayout() {
		return null;
	}

	@Override
	protected View loadContentLayout() {
		return getActivity().getLayoutInflater().inflate(R.layout.fragment_home, null);
	}

	@Override
	protected void process(Bundle savedInstanceState) {
		
	}

}
