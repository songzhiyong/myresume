package com.songzhiyong.myresume;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.songzhiyong.myresume.utils.AnimationUtil;
/**
 * 创建人：SongZhiyong
 * 创建时间：2013-2-25
 */
/**
 * @author SongZhiyong
 * 
 */
public class CenterFragment extends Fragment {
	SampleAdapter adapter;
	SampleAdapter evaAdapter;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_main, null);
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public void onResume() {
		adapter = new SampleAdapter(getActivity());
		// 基本信息
		String[] basicInfos = getResources().getStringArray(R.array.basic_infos);
		for (int i = 0; i < basicInfos.length; i++) {
			adapter.add(new SampleItem(basicInfos[i], R.drawable.indicator));
		}
		((ListView) getView().findViewById(R.id.lv_basic)).setAdapter(adapter);
		((ListView) getView().findViewById(R.id.lv_evaluation)).setLayoutAnimation(AnimationUtil
				.getAnimationController());
		// 个人评价
		String[] evaluation = getResources().getStringArray(R.array.evaluation);
		evaAdapter = new SampleAdapter(getActivity());
		for (int i = 0; i < evaluation.length; i++) {
			evaAdapter.add(new SampleItem(evaluation[i], R.drawable.indicator));
		}
		((ListView) getView().findViewById(R.id.lv_evaluation)).setAdapter(evaAdapter);
		((ListView) getView().findViewById(R.id.lv_evaluation)).setLayoutAnimation(AnimationUtil
				.getAnimationController());
		super.onResume();
	}
	private class SampleItem {
		public String tag;  
		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag;
			this.iconRes = iconRes;
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
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);
			return convertView;
		}
	}
}
