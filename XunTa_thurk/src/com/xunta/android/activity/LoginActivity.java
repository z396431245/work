package com.xunta.android.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xunta.android.R;
import com.xunta.android.base.BaseActivity;
import com.xunta.android.tools.Tools;

/**
 * @Title: LoginActivity.java 
 * @Package com.xunta.android.activity
 * @Description: TODO(登录) 
 * @author zhangchao
 * @date 2014年7月30日 下午9:52:42 
 */
public class LoginActivity extends BaseActivity implements OnClickListener{

	private EditText telphone_edit;
	private EditText password_edit;
	private Button login_btn;
	private Button register_btn;
	private TextView stroll_btn;//随便看看
	
	private String telphone;
	private String password;
	
	@Override
	protected void process(Bundle savedInstanceState) {
		
	}

	@Override
	protected void initPageView() {
		telphone_edit = getEditText(R.id.telphone_edit);
		password_edit = getEditText(R.id.password_edit);
		login_btn = getButton(R.id.login_btn);
		register_btn = getButton(R.id.register_btn);
		stroll_btn = getTextView(R.id.stroll_btn);
		stroll_btn.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);  
		stroll_btn.getPaint().setAntiAlias(true); 
	}

	@Override
	protected void initPageViewListener() {
		login_btn.setOnClickListener(this);
		register_btn.setOnClickListener(this);
		stroll_btn.setOnClickListener(this);
	}

	@Override
	protected int loadContentLayout() {
		return R.layout.activity_login;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.login_btn://登录
			telphone = telphone_edit.getText().toString();
			password = password_edit.getText().toString();
			if(!Tools.isNull(telphone)){
				telphone_edit.setError("请输入手机号");
			}else if(!Tools.isMobileNO(telphone)){
				telphone_edit.setError("手机格式不正确");
			}else if(!Tools.isNull(password)){
				password_edit.setError("请输入密码");
			}else{
				//去数据库验证
				Intent intent = new Intent(this,IndexActivity.class);
				startActivity(intent);
				finish();
			}
			break;
		case R.id.register_btn://注册
			Intent intent = new Intent(this,RegisterActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.stroll_btn://随便看看
			intent = new Intent(this,IndexActivity.class);
			startActivity(intent);
			finish();
			break;
		}
	}

}
