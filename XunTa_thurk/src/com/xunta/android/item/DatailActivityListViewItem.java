package com.xunta.android.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xunta.android.R;

public class DatailActivityListViewItem extends LinearLayout implements
		OnClickListener {

	private TextView itemName, itemDetail;
	private ImageView headImage;

	public DatailActivityListViewItem(Context context) {
		super(context);
		init(context);
	}

	public DatailActivityListViewItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public DatailActivityListViewItem(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context c) {
		View view = inflate(c, R.layout.activity_detail_listview_item, null);
		this.addView(view, new LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		headImage = (ImageView) view.findViewById(R.id.head_picture);
		itemName = (TextView) view.findViewById(R.id.name);
		itemDetail = (TextView) view.findViewById(R.id.detail);

	}

	public void setName(String name) {
		itemName.setText(name);
	}

	public void setDetail(String detail) {
		itemDetail.setText(detail);
	}

	public void setHeadImageUrl(String url) {

	}

	@Override
	public void onClick(View v) {

	}

}
