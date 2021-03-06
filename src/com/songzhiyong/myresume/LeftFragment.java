package com.songzhiyong.myresume;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.songzhiyong.myresume.utils.AnimationUtil;
/**
 * 创建人：SongZhiyong
 * 创建时间：2013-2-25
 */
/**
 * 左侧Fragment
 * 
 * @author SongZhiyong
 * 
 */
public class LeftFragment extends ListFragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public void onResume() {
		SampleAdapter adapter = new SampleAdapter(getActivity());
		String[] skillItems = getResources().getStringArray(R.array.skills);
		for (int i = 0; i < skillItems.length; i++) {
			adapter.add(new SampleItem(skillItems[i], android.R.drawable.ic_menu_search));
		}
		getListView().setLayoutAnimation(AnimationUtil.getAnimationController());
		setListAdapter(adapter);
		super.onResume();
	}
	private class SampleItem {
		public String tag;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag;
		}
	}
	public class SampleAdapter extends ArrayAdapter<SampleItem> {
		public SampleAdapter(Context context) {
			super(context, 0);
		}
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setVisibility(View.GONE);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);
			return convertView;
		}
	}
}
