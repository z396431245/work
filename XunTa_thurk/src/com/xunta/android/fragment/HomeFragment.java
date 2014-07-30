package com.xunta.android.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.xunta.android.R;
import com.xunta.android.base.BaseFragment;
import com.xunta.android.item.HomeFragmentListViewItem;

public class HomeFragment extends BaseFragment implements OnItemClickListener,
		OnClickListener {

	private RelativeLayout homeNormalTitleLyout = null;
	private RelativeLayout homeFilterTitleLyout = null;
	private RelativeLayout hotLayout = null;
	private RelativeLayout nearLayout = null;
	private LinearLayout filterLayout = null;

	int count = 10;
	private View parentCenterView;
	private View parentTopView;

	private Button titleHot, titleNear;

	private int pageIndex = 1;

	@Override
	protected void initPageView() {

		homeNormalTitleLyout = (RelativeLayout) parentTopView
				.findViewById(R.id.home_title_normal_layout);
		homeFilterTitleLyout = (RelativeLayout) parentTopView
				.findViewById(R.id.home_title_filter_layout);

		titleHot = (Button) parentTopView.findViewById(R.id.hot_title);
		titleNear = (Button) parentTopView.findViewById(R.id.near_title);
		titleNear.setOnClickListener(this);
		titleHot.setOnClickListener(this);

		Button filterButton = (Button) parentTopView
				.findViewById(R.id.filter_bt);
		Button backButton = (Button) parentTopView
				.findViewById(R.id.filter_back);
		filterButton.setOnClickListener(this);
		backButton.setOnClickListener(this);

		hotLayout = (RelativeLayout) parentCenterView
				.findViewById(R.id.hot_layout);
		nearLayout = (RelativeLayout) parentCenterView
				.findViewById(R.id.near_layout);
		filterLayout = (LinearLayout) parentCenterView
				.findViewById(R.id.filter_layout);

		ListView hotListView = (ListView) parentCenterView
				.findViewById(R.id.hot_list_view);
		ListAdapter adapterHot = new ListAdapter(View.INVISIBLE);
		hotListView.setAdapter(adapterHot);
		hotListView.setOnItemClickListener(this);

		ListView nearListView = (ListView) parentCenterView
				.findViewById(R.id.near_list_view);
		ListAdapter adapterNear = new ListAdapter(View.VISIBLE);
		nearListView.setAdapter(adapterNear);
	}

	@Override
	protected void initPageViewListener() {
		titleHot.performClick();
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
			titleHot.setTextColor(this.getResources().getColor(R.color.white));
			titleNear.setTextColor(this.getResources().getColor(R.color.black));
			pageIndex = 1;
			hotLayout.setVisibility(View.VISIBLE);
			nearLayout.setVisibility(View.GONE);
			filterLayout.setVisibility(View.GONE);
			break;
		case R.id.near_title:
			titleHot.setTextColor(this.getResources().getColor(R.color.black));
			titleNear.setTextColor(this.getResources().getColor(R.color.white));
			pageIndex = 2;
			hotLayout.setVisibility(View.GONE);
			nearLayout.setVisibility(View.VISIBLE);
			break;
		case R.id.filter_bt:
			homeNormalTitleLyout.setVisibility(View.GONE);
			homeFilterTitleLyout.setVisibility(View.VISIBLE);
			hotLayout.setVisibility(View.GONE);
			nearLayout.setVisibility(View.GONE);
			filterLayout.setVisibility(View.VISIBLE);
			break;
		case R.id.filter_back:
			if (pageIndex == 1) {
				hotLayout.setVisibility(View.VISIBLE);
				nearLayout.setVisibility(View.GONE);
				filterLayout.setVisibility(View.GONE);
			} else if (pageIndex == 2) {
				hotLayout.setVisibility(View.GONE);
				nearLayout.setVisibility(View.VISIBLE);
				filterLayout.setVisibility(View.GONE);
			}

			homeFilterTitleLyout.setVisibility(View.GONE);
			homeNormalTitleLyout.setVisibility(View.VISIBLE);
			filterLayout.setVisibility(View.GONE);
			break;

		default:
			break;
		}
	}

}
