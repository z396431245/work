package com.xunta.android.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity{

	/** 抽象方法 ，子类必须实现，逻辑处理 */
	protected abstract void process(Bundle savedInstanceState);
	/** 抽象方法 ，子类必须实现，初始化页面控件。 */
	protected abstract void initPageView();

	/** 抽象方法 ，子类必须实现，页面控件点击事件处理 */
	protected abstract void initPageViewListener();
	
	/**
	 * 获取内容布局
	 */
	protected abstract int loadContentLayout();
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(loadContentLayout());
		initPageView();
		initPageViewListener();
		process(arg0);
	}
	
	/**
	 * toast提示
	 * */
	public void showToast(String content){
		Toast.makeText(this, content, 1000).show();
	}
	
	public TextView getTextView(int id){
		return ((TextView)findViewById(id));
	}
	
	public EditText getEditText(int id){
		return ((EditText)findViewById(id));
	}
	
	public Button getButton(int id){
		return ((Button)findViewById(id));
	}
	
}
