package com.xunta.android.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xunta.android.R;

public class HomeFragmentListViewItem extends LinearLayout implements
		OnClickListener {

	private TextView itemName, itemDistance, itemTime, itemDetail, itemHeart,
			itemMessage, itemRelay;
	private ImageView headImage, oneImage, twoImage, threeImage;

	public HomeFragmentListViewItem(Context context) {
		super(context);
		init(context);
	}

	public HomeFragmentListViewItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public HomeFragmentListViewItem(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context c) {
		View view = inflate(c, R.layout.fragment_home_hot_listview_item, null);
		this.addView(view, new LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		headImage = (ImageView) view.findViewById(R.id.head_picture);
		itemName = (TextView) view.findViewById(R.id.name);
		itemDistance = (TextView) view.findViewById(R.id.distance);
		itemTime = (TextView) view.findViewById(R.id.time);
		itemDetail = (TextView) view.findViewById(R.id.detail);
		itemHeart = (TextView) view.findViewById(R.id.heart);
		itemMessage = (TextView) view.findViewById(R.id.message);
		itemRelay = (TextView) view.findViewById(R.id.relay);
		oneImage = (ImageView) view.findViewById(R.id.one);
		twoImage = (ImageView) view.findViewById(R.id.two);
		threeImage = (ImageView) view.findViewById(R.id.three);

		itemHeart.setOnClickListener(this);
		oneImage.setOnClickListener(this);
		twoImage.setOnClickListener(this);
		threeImage.setOnClickListener(this);

	}

	/**
	 * flag 1:hot don't show distance    
	 * flag other:near 
	 * 
	 * @param flag
	 */
	public void setShowDistance(int flag) {
			itemDistance.setVisibility(flag);
	}

	public void setName(String name) {
		itemName.setText(name);
	}

	public void setDistance(String distance) {
		itemDistance.setText(distance);
	}

	public void setTime(String time) {
		itemTime.setText(time);
	}

	public void setDetail(String detail) {
		itemDetail.setText(detail);
	}

	public void setHeart(String heart) {
		itemHeart.setText(heart);
	}

	public void setMessage(String message) {
		itemMessage.setText(message);
	}

	public void setRelay(String relay) {
		itemRelay.setText(relay);
	}

	public void setHeadImageUrl(String url) {

	}

	public void setOneImageUrl(String url) {

	}

	public void setTwoImageUrl(String url) {

	}

	public void setThreeImageUrl(String url) {

	}

	@Override
	public void onClick(View v) {

	}

}
