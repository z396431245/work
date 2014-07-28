package com.xunta.android.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.xunta.android.R;
import com.xunta.android.base.BaseFragment;

public class MyCentreFragment extends BaseFragment{

	private RelativeLayout userinfo_rl;
	
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
		return getActivity().getLayoutInflater().inflate(R.layout.fragment_mycenter, null);
	}

	@Override
	protected void process(Bundle savedInstanceState) {
		
	}

}
