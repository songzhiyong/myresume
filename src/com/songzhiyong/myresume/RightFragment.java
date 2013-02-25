package com.songzhiyong.myresume;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
/**
 * 创建人：SongZhiyong
 * 创建时间：2013-2-25
 */
/**
 * @author SongZhiyong
 * 
 */
public class RightFragment extends ListFragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		adapter.add(new SampleItem(R.drawable.pic_1));
		adapter.add(new SampleItem(R.drawable.pic_2));
		adapter.add(new SampleItem(R.drawable.pic_3));
		adapter.add(new SampleItem(R.drawable.pic_4));
		adapter.add(new SampleItem(R.drawable.pic_5));
		adapter.add(new SampleItem(R.drawable.pic_6));
		adapter.add(new SampleItem(R.drawable.pic_7));
		adapter.add(new SampleItem(R.drawable.pic_8));
		adapter.add(new SampleItem(R.drawable.pic_9));
		adapter.add(new SampleItem(R.drawable.pic_10));
		adapter.add(new SampleItem(R.drawable.pic_11));
		adapter.add(new SampleItem(R.drawable.pic_12));
		adapter.add(new SampleItem(R.drawable.pic_13));
		adapter.add(new SampleItem(R.drawable.pic_14));
		setListAdapter(adapter);
	}
	private class SampleItem {
		public int iconRes;
		public SampleItem(int iconRes) {
			this.iconRes = iconRes;
		}
	}
	public class SampleAdapter extends ArrayAdapter<SampleItem> {
		public SampleAdapter(Context context) {
			super(context, 0);
		}
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_pic, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			return convertView;
		}
	}
}
