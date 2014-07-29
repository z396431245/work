package com.xunta.android.activity; 

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import cn.bmob.v3.Bmob;

import com.xunta.android.R;
import com.xunta.android.base.BaseActivity;
import com.xunta.android.common.Constent;
import com.xunta.android.common.LoginState;

/**   
 * @Title: WelComeActivity.java 
 * @Package com.seekta.android.activity 
 * @Description: TODO(»¶Ó­Ò³) 
 * @author zhangchao   
 * @date 2014Äê7ÔÂ23ÈÕ ÏÂÎç10:41:58   
 */
public class WelComeActivity extends BaseActivity{

	private ImageView imageView;
	private int ss;
	/*sss*/
	
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if(LoginState.isLogin(WelComeActivity.this)){
				//ÒÑµÇÂ¼
				
			}else{
				//Î´µÇÂ¼
				
			}
		}
		
	};
	
	@Override
	protected void process(Bundle savedInstanceState) {
		
		//³õÊ¼»¯bmob
		Bmob.initialize(this, Constent.ApplicationID);
		//Ò³ÃæÔÝÍ£3ÃëºóÌø×ª
		pause();
	}

	@Override
	protected void initPageView() {
		imageView = (ImageView)findViewById(R.id.imageView);
	}

	@Override
	protected void initPageViewListener() {
		
	}

	@Override
	protected int loadContentLayout() {
		return R.layout.activity_welcome;
	}

	/**
	 * ÔÝÍ£3ÃëÖÓ
	 * */
	public void pause(){
		new Thread(){

			@Override
			public void run() {
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				handler.sendEmptyMessage(1);
			}
			
		}.start();
	}
	
}
 