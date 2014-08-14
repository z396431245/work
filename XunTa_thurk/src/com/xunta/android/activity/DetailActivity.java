package com.xunta.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xunta.android.R;
import com.xunta.android.base.BaseActivity;
import com.xunta.android.item.DatailActivityListViewItem;

public class DetailActivity extends BaseActivity implements OnClickListener,
		OnItemClickListener {
	private ImageView headImage, ImageOne, ImageTwo, ImageThree;
	private TextView nameText, distanceText, timeText, detailText, heartText,
			messageText, relayText;
	private ListView revertListView;

	private int count = 10;

	@Override
	protected void process(Bundle savedInstanceState) {
		ListAdapter adapter = new ListAdapter();
		revertListView.setAdapter(adapter);
	}

	@Override
	protected void initPageView() {
		headImage = (ImageView) findViewById(R.id.head_image);
		nameText = (TextView) findViewById(R.id.name);
		distanceText = (TextView) findViewById(R.id.distance);
		timeText = (TextView) findViewById(R.id.time);
		detailText = (TextView) findViewById(R.id.detail);
		messageText = (TextView) findViewById(R.id.message_count);
		heartText = (TextView) findViewById(R.id.heart_count);
		relayText = (TextView) findViewById(R.id.relay_count);
		revertListView = (ListView) findViewById(R.id.revert_listview);
		ImageOne = (ImageView) findViewById(R.id.image_one);
		ImageTwo = (ImageView) findViewById(R.id.image_two);
		ImageThree = (ImageView) findViewById(R.id.image_three);
	}

	@Override
	protected void initPageViewListener() {
		headImage.setOnClickListener(this);
		messageText.setOnClickListener(this);
		heartText.setOnClickListener(this);
		relayText.setOnClickListener(this);
		revertListView.setOnItemClickListener(this);
		ImageOne.setOnClickListener(this);
		ImageTwo.setOnClickListener(this);
		ImageThree.setOnClickListener(this);
	}

	@Override
	protected int loadContentLayout() {
		return R.layout.activity_detail;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.image_one:
			startActivity(new Intent(this,BigPictureActivity.class));
			break;
		case R.id.image_two:

			break;
		case R.id.image_three:

			break;

		default:
			break;
		}
	}

	public class ListAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return count;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = new ViewHolder();
			if (convertView == null) {
				holder.item = new DatailActivityListViewItem(
						DetailActivity.this);
				convertView = holder.item;
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			return convertView;
		}

		private class ViewHolder {
			DatailActivityListViewItem item;
		}

	}

}
