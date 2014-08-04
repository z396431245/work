package com.xunta.android.activity;

import java.util.List;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;

import com.xunta.android.R;
import com.xunta.android.base.BaseActivity;
import com.xunta.android.bean.Users;
import com.xunta.android.common.LoginState;
import com.xunta.android.tools.Tools;
import com.xunta.android.tools.Utils;

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
				showToast("请输入手机号");
			}else if(!Tools.isMobileNO(telphone)){
				showToast("手机格式不正确");
			}else if(!Tools.isNull(password)){
				showToast("请输入密码");
			}else{
				//去数据库验证
				checkLogin();
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
	
	/**登录验证*/
	public void checkLogin(){
		BmobQuery<Users> query = new BmobQuery<Users>();
		query.addWhereEqualTo("phoneNum", telphone);
		query.addWhereEqualTo("password", Utils.md5(password));
		query.findObjects(this, new FindListener<Users>() {
			
			@Override
			public void onSuccess(List<Users> list) {
				if(list.size() > 0){
					LoginState.setUserId(LoginActivity.this, list.get(0).getObjectId());
					Intent intent = new Intent(LoginActivity.this,IndexActivity.class);
					startActivity(intent);
					finish();
				}else{
					showToast("用户名或密码错误");
				}
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				showToast("失败" + arg1);
			}
		});
		
	}

}
