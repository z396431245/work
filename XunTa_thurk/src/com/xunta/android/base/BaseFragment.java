package com.xunta.android.base;

import com.xunta.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public abstract class BaseFragment extends Fragment{

	/** 是否执行了OnAttach */
	private boolean isExceOnAttach = false;
	/** 是否隐藏页面了 */
	private boolean isHidePage = false;
	/** 是否正在展示页面 */
	public boolean isShowingPage = true;
	
	/** 页面跳转传递的参数 */
	private Bundle bundle;
	/** 基类view */
	public View baseMainView;
	/** 顶部title布局 */
	public RelativeLayout topFragmentLayout;
	/** 底部菜单布局 */
	public RelativeLayout contentFramentLayout;
	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		isExceOnAttach = true;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		baseMainView = inflater.inflate(R.layout.fragment_base, container,false);
		findBaseViewById();
		/** 初始化页面控件。 */
		initPageView();
		initPageViewListener();
		return baseMainView;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		process(savedInstanceState);
	}
	
	public void findBaseViewById(){
		topFragmentLayout = (RelativeLayout)baseMainView.findViewById(R.id.topLayout);
		contentFramentLayout = (RelativeLayout)baseMainView.findViewById(R.id.contentLayout);
		View topView = loadTopLayout();
		if (topView == null) {
			topFragmentLayout.setVisibility(View.GONE);
		} else {
			RelativeLayout.LayoutParams layoutParamsTop = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			topFragmentLayout.setVisibility(View.VISIBLE);
			topFragmentLayout.addView(topView, layoutParamsTop);
		}
		View contentView = loadContentLayout();
		if (contentView == null) {
			contentFramentLayout.setVisibility(View.GONE);
		} else {
			RelativeLayout.LayoutParams layoutParamsContent = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.FILL_PARENT);
			contentFramentLayout.setVisibility(View.VISIBLE);
			contentFramentLayout.addView(contentView, layoutParamsContent);
		}
		
	}
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		isHidePage = hidden;
		isShowingPage = !hidden;
		if (!hidden) {
			
		} else {
			
		}
	}


	@Override
	public void onPause() {
		super.onPause();
		isExceOnAttach = false;
		isShowingPage = false;
	}


	@Override
	public void onResume() {
		super.onResume();
		if (!isExceOnAttach && !isHidePage) {
			// 不是第一次进来并且没有隐藏，需要刷新页面可以实现此方法
			isShowingPage = true;
			
		}
	}


	/**
	 * 页面跳转传递的参数
	 * 
	 * @param bundle
	 */
	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	/**
	 * 获取页面传递的参数
	 * 
	 * @return
	 */
	public Bundle getBundle() {
		return bundle;
	}
	
	/** 抽象方法 ，子类必须实现，初始化页面控件。 */
	protected abstract void initPageView();

	/** 抽象方法 ，子类必须实现，页面控件点击事件处理 */
	protected abstract void initPageViewListener();

	/**
	 * 获取顶部布局
	 */
	protected abstract View loadTopLayout();

	/**
	 * 获取内容布局
	 */
	protected abstract View loadContentLayout();

	/** 抽象方法 ，子类必须实现，逻辑处理 */
	protected abstract void process(Bundle savedInstanceState);
	
}
