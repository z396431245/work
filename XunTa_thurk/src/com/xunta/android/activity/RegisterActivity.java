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
import cn.bmob.v3.listener.SaveListener;

import com.xunta.android.R;
import com.xunta.android.base.BaseActivity;
import com.xunta.android.bean.Users;
import com.xunta.android.common.LoginState;
import com.xunta.android.tools.Tools;
import com.xunta.android.tools.Utils;

/**
 * @Title: RegisterActivity.java 
 * @Package com.xunta.android.activity
 * @Description: TODO(注册) 
 * @author zhangchao
 * @date 2014年7月30日 下午10:46:43 
 */
public class RegisterActivity extends BaseActivity implements OnClickListener{

	private EditText telphone_edit;
	private EditText password_edit;
	private EditText confirmpassword_edit;
	private Button login_btn;
	private Button register_btn;
	private TextView stroll_btn;//随便看看
	
	private String telphone;
	private String password;
	private String confirmpassword;
	
	@Override
	protected void process(Bundle savedInstanceState) {
		
	}

	@Override
	protected void initPageView() {
		telphone_edit = getEditText(R.id.telphone_edit);
		password_edit = getEditText(R.id.password_edit);
		confirmpassword_edit = getEditText(R.id.confirmpassword_edit);
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
		return R.layout.activity_register;
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId()){
		case R.id.login_btn://登录
			intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.register_btn://注册
			telphone = telphone_edit.getText().toString();
			password = password_edit.getText().toString();
			confirmpassword = confirmpassword_edit.getText().toString();
			if(!Tools.isNull(telphone)){
				telphone_edit.setError("请输入手机号");
				showToast("请输入手机号");
			}else if(!Tools.isMobileNO(telphone)){
				showToast("手机格式不正确");
			}else if(!Tools.isNull(password)){
				showToast("请输入密码");
			}else if(!Tools.isNull(confirmpassword)){
				showToast("请再次输入密码");
			}else if(!password.equals(confirmpassword)){
				showToast("两次密码不一致，请重新输入");
			}else{
				//去数据库验证
				checkPhone();
			}
			break;
		case R.id.stroll_btn://随便看看
			intent = new Intent(this,IndexActivity.class);
			startActivity(intent);
			finish();
			break;
		}
	}
	
	/**检测手机号是否可用*/
	public void checkPhone(){
		BmobQuery<Users> query = new BmobQuery<Users>();
		query.addWhereEqualTo("phoneNum", telphone);
		query.findObjects(this, new FindListener<Users>() {
			
			@Override
			public void onSuccess(List<Users> list) {
				if(list.size() > 0){
					showToast("手机已被注册");
				}else{
					register();
				}
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				showToast("失败" + arg1);
			}
		});
	}
	
	/**注册*/
	public void register(){
		final Users users = new Users();
		users.setPhoneNum(telphone);
		users.setPassword(Utils.md5(password));
		users.save(this, new SaveListener() {
			
			@Override
			public void onSuccess() {
				showToast("注册成功");
				LoginState.setUserId(RegisterActivity.this, users.getObjectId());
				Intent intent = new Intent(RegisterActivity.this,IndexActivity.class);
				startActivity(intent);
				finish();
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				showToast("注册失败，请检查网络是否连接。");
			}
		});
	}

}
