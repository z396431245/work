package com.xunta.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

import com.xunta.android.R;
import com.xunta.android.base.BaseActivity;
import com.xunta.android.bean.XuntaData;
import com.xunta.android.common.Constent;
import com.xunta.android.common.LoginState;

/**
 * @Title: WelComeActivity.java
 * @Package com.seekta.android.activity
 * @Description: TODO(欢迎页)
 * @author zhangchao
 * @date 2014年7月23日 下午10:41:58
 */
public class WelComeActivity extends BaseActivity {

	private ImageView imageView;

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (LoginState.isLogin(WelComeActivity.this)) {
				// 已登录
				startActivity(new Intent(WelComeActivity.this,
						IndexActivity.class));
				finish();
			} else {
				// 未登录
				startActivity(new Intent(WelComeActivity.this,
						LoginActivity.class));
				finish();
			}
		}

	};

	@Override
	protected void process(Bundle savedInstanceState) {

		// 初始化bmob
		Bmob.initialize(this, Constent.ApplicationID);
		BmobPush.startWork(this, Constent.ApplicationID);
		// 页面暂停3秒后跳转
		pause();
	}

	@Override
	protected void initPageView() {
		imageView = (ImageView) findViewById(R.id.imageView);
	}

	@Override
	protected void initPageViewListener() {

	}

	@Override
	protected int loadContentLayout() {
		return R.layout.activity_welcome;
	}

	/**
	 * 暂停3秒钟
	 * */
	public void pause() {
		handler.sendEmptyMessageDelayed(1, 3000);
	}

}
