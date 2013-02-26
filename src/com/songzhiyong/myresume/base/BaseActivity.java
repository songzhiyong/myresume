package com.songzhiyong.myresume.base;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import com.songzhiyong.myresume.LeftFragment;
import com.songzhiyong.myresume.R;
/**
 * SlidingFragmentActivity基本类
 * 
 * @author SongZhiyong
 * 
 */
public class BaseActivity extends SlidingFragmentActivity {
	private int mTitleRes;
	protected ListFragment mFrag;
	public BaseActivity(int titleRes) {
		mTitleRes = titleRes;
	}
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(mTitleRes);
		setBehindContentView(R.layout.menu_frame);
		FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
		mFrag = new LeftFragment();// 左侧Fragment
		t.replace(R.id.menu_frame, mFrag);
		t.commit();
		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
			// case R.id.github:
			// Util.goToGitHub(this);
			// return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
}// /:~
