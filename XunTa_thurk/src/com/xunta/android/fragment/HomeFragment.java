package com.xunta.android.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xunta.android.R;
import com.xunta.android.base.BaseFragment;
import com.xunta.android.item.HomeFragmentListViewItem;

public class HomeFragment extends BaseFragment implements OnItemClickListener,
		OnClickListener {

	private ListView hotListView = null;
	private ListView nearListView = null;
	private RelativeLayout hotLayout = null;
	private RelativeLayout nearLayout = null;
	int count = 10;
	private View parentCenterView;
	private View parentTopView;
	private TextView titleHot, titleNear;

	@Override
	protected void initPageView() {
		titleHot = (TextView) parentTopView.findViewById(R.id.hot_title);
		titleNear = (TextView) parentTopView.findViewById(R.id.near_title);
		titleNear.setOnClickListener(this);
		titleHot.setOnClickListener(this);
		hotLayout = (RelativeLayout) parentCenterView
				.findViewById(R.id.hot_layout);
		nearLayout = (RelativeLayout) parentCenterView
				.findViewById(R.id.near_layout);
		
		hotListView = (ListView) parentCenterView.findViewById(R.id.hot_list);
		ListAdapter adapterHot = new ListAdapter(View.INVISIBLE);
		hotListView.setAdapter(adapterHot);
		
		nearListView = (ListView) parentCenterView.findViewById(R.id.near_list);
		ListAdapter adapterNear = new ListAdapter(View.VISIBLE);
		nearListView.setAdapter(adapterNear);
	}

	@Override
	protected void initPageViewListener() {
		hotListView.setOnItemClickListener(this);
	}

	@Override
	protected View loadTopLayout() {
		parentTopView = getActivity().getLayoutInflater().inflate(
				R.layout.fragment_home_title, null);
		return parentTopView;
	}

	@Override
	protected View loadContentLayout() { 
		parentCenterView = getActivity().getLayoutInflater().inflate(
				R.layout.fragment_home, null);
		return parentCenterView;
	}

	@Override
	protected void process(Bundle savedInstanceState) {

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

	}

	public class ListAdapter extends BaseAdapter {

		// type 1:hot other:near
		private int showDistance;

		public ListAdapter(int isShowDistance) {
			this.showDistance = isShowDistance;
		}

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
				holder.item = new HomeFragmentListViewItem(getActivity());
				convertView = holder.item;
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.item.setShowDistance(showDistance);
			
			return convertView;
		}

		private class ViewHolder {
			HomeFragmentListViewItem item;
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.hot_title:
			hotLayout.setVisibility(View.VISIBLE);
			nearLayout.setVisibility(View.GONE);
			break;
		case R.id.near_title:
			hotLayout.setVisibility(View.GONE);
			nearLayout.setVisibility(View.VISIBLE);
			break;

		default:
			break;
		}
	}

}
