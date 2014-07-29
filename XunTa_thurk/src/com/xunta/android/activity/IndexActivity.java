package com.xunta.android.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

import com.xunta.android.R;
import com.xunta.android.base.BaseActivity;
import com.xunta.android.fragment.HomeFragment;
import com.xunta.android.fragment.MessageFragment;
import com.xunta.android.fragment.MyCentreFragment;
import com.xunta.android.fragment.NearbyFragment;
import com.xunta.android.fragment.PublishFragment;
public class IndexActivity extends BaseActivity implements OnClickListener{

	private HomeFragment homeFragment;
	private MessageFragment messageFragment;
	private NearbyFragment nearbyFragment;
	private MyCentreFragment myCentreFragment;
	private PublishFragment publishFragment;
	private int ss;
	
	/**
	 * 当前Fragment显示的页面，0表示主页，1表示附近，2表示发布页面 3 消息 4 我的
	 */
	private int mcurrentPage = 0;
	
	@Override
	protected void process(Bundle savedInstanceState) {
		mcurrentPage = 0;
		pageTo(mcurrentPage);
	}

	@Override
	protected void initPageView() {
		
	}

	@Override
	protected void initPageViewListener() {
		(findViewById(R.id.homeLin)).setOnClickListener(this);
		(findViewById(R.id.nearbyLin)).setOnClickListener(this);
		(findViewById(R.id.publishLin)).setOnClickListener(this);
		(findViewById(R.id.messageLin)).setOnClickListener(this);
		(findViewById(R.id.myCentreLin)).setOnClickListener(this);
	}

	@Override
	protected int loadContentLayout() {
		return R.layout.activity_index;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.homeLin:
			if(mcurrentPage != 0){
				mcurrentPage = 0;
				pageTo(mcurrentPage);
			}
			break;
		case R.id.nearbyLin:
			if(mcurrentPage != 1){
				mcurrentPage = 1;
				pageTo(mcurrentPage);
			}
			break;
		case R.id.publishLin:
			if(mcurrentPage != 2){
				mcurrentPage = 2;
				pageTo(mcurrentPage);
			}
			break;
		case R.id.messageLin:
			if(mcurrentPage != 3){
				mcurrentPage = 3;
				pageTo(mcurrentPage);
			}
			break;
		case R.id.myCentreLin:
			if(mcurrentPage != 4){
				mcurrentPage = 4;
				pageTo(mcurrentPage);
			}
			break;
		default:
			break;
		}
	}

	public void pageTo(int pageFlag){
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		if(homeFragment != null && homeFragment.isShowingPage){
			transaction.hide(homeFragment);
		}
		if(nearbyFragment != null && nearbyFragment.isShowingPage){
			transaction.hide(nearbyFragment);
		}
		if(publishFragment != null && publishFragment.isShowingPage){
			transaction.hide(publishFragment);
		}
		if(messageFragment != null && messageFragment.isShowingPage){
			transaction.hide(messageFragment);
		}
		if(myCentreFragment != null && myCentreFragment.isShowingPage){
			transaction.hide(myCentreFragment);
		}
		
		switch(pageFlag){
		case 1:
			if(nearbyFragment == null){
				nearbyFragment = new NearbyFragment();
				transaction.add(R.id.fragmentContainer, nearbyFragment);
				transaction.commit();
			}else{
				transaction.show(nearbyFragment);
				transaction.commit();
			}
			break;
		case 2:
			if(publishFragment == null){
				publishFragment = new PublishFragment();
				transaction.add(R.id.fragmentContainer, publishFragment);
				transaction.commit();
			}else{
				transaction.show(publishFragment);
				transaction.commit();
			}
			break;
		case 3:
			if(messageFragment == null){
				messageFragment = new MessageFragment();
				transaction.add(R.id.fragmentContainer, messageFragment);
				transaction.commit();
			}else{
				transaction.show(messageFragment);
				transaction.commit();
			}
			break;
		case 4:
			if(myCentreFragment == null){
				myCentreFragment = new MyCentreFragment();
				transaction.add(R.id.fragmentContainer, myCentreFragment);
				transaction.commit();
			}else{
				transaction.show(myCentreFragment);
				transaction.commit();
			}
			break;
		default:
			if(homeFragment == null){
				homeFragment = new HomeFragment();
				transaction.add(R.id.fragmentContainer, homeFragment);
				transaction.commit();
			}else{
				transaction.show(homeFragment);
				transaction.commit();
			}
			break;
		}
		
		
	}
	
}
