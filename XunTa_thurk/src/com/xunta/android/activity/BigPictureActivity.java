package com.xunta.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

import com.xunta.android.R;
import com.xunta.android.base.BaseActivity;

public class BigPictureActivity extends BaseActivity implements ViewFactory {
	private ImageSwitcher switcher;

	@Override
	protected void process(Bundle savedInstanceState) {
		switcher.setFactory(this);
		switcher.setImageResource(R.drawable.ic_launcher);
	}

	@Override
	protected void initPageView() {
		switcher = (ImageSwitcher) findViewById(R.id.viewswitcher);
		switcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		switcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));
	}

	@Override
	protected void initPageViewListener() {

	}

	@Override
	protected int loadContentLayout() {
		return R.layout.activity_bigpicture;
	}

	@Override
	public View makeView() {
		ImageView i = new ImageView(this);
		i.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		i.setScaleType(ScaleType.FIT_XY);
		return i;
	}

	public void next(View v) {
	}

	public void up(View v) {

	}
}
