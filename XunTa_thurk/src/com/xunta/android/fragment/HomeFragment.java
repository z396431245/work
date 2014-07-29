package com.xunta.android.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.xunta.android.R;
import com.xunta.android.base.BaseFragment;
import com.xunta.android.item.HomeHotListViewItem;

public class HomeFragment extends BaseFragment implements OnItemClickListener {

	private ListView hotListView = null;
	private RelativeLayout hotLayout = null;
	private RelativeLayout nearLayout = null;
	int count = 10;
	private View parentView;

	@Override
	protected void initPageView() {
		hotLayout = (RelativeLayout) parentView.findViewById(R.id.hot_layout);
		nearLayout = (RelativeLayout) parentView.findViewById(R.id.near_layout);
		hotListView = (ListView) parentView.findViewById(R.id.hot_list);
		ListAdapter adapter = new ListAdapter();
		hotListView.setAdapter(adapter);
	}

	@Override
	protected void initPageViewListener() {
		hotListView.setOnItemClickListener(this);
	}

	@Override
	protected View loadTopLayout() {
		return getActivity().getLayoutInflater().inflate(
				R.layout.fragment_home_title, null);
	}

	@Override
	protected View loadContentLayout() {
		parentView = getActivity().getLayoutInflater().inflate(
				R.layout.fragment_home, null);
		return parentView;
	}

	@Override
	protected void process(Bundle savedInstanceState) {

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

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
				holder.item = new HomeHotListViewItem(getActivity());
				convertView = holder.item;
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			return convertView;
		}

		private class ViewHolder {
			HomeHotListViewItem item;
		}

	}

}
