package com.songzhiyong.myresume;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.CanvasTransformer;
import com.songzhiyong.myresume.base.BaseActivity;
/**
 * My resume main activity 简历
 * 
 * @author SongZhiyong
 * 
 */
public class MainActivity extends BaseActivity implements ActionBar.OnNavigationListener {
	public static int THEME = R.style.Theme_Sherlock;
	String[] mItems;// 个人信息条目
	private CanvasTransformer mTransformer; // slidingMenu滑入动画
	public MainActivity() {
		super(R.string.resume_main);// 设置上方标题
		mTransformer = new CanvasTransformer() {
			public void transformCanvas(Canvas canvas, float percentOpen) {
				float scale = (float) (percentOpen * 0.25 + 0.75);
				canvas.scale(scale, scale, canvas.getWidth() / 2, canvas.getHeight() / 2);
			}
		};
	}
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// SubMenu sub = menu.addSubMenu("主题");
	// sub.add(0, R.style.Theme_Sherlock, 0, "暗黑");
	// sub.add(0, R.style.Theme_Sherlock_Light, 0, "亮白");
	// sub.add(0, R.style.Theme_Sherlock_Light_DarkActionBar, 0, "混合");
	// sub.getItem().setShowAsAction(
	// MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
	// return true;
	// }
	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// if (item.getItemId() == android.R.id.home || item.getItemId() == 0) {
	// return false;
	// }
	// THEME = item.getItemId();
	// setTheme(THEME);
	// return true;
	// }
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		setContentView(R.layout.content_frame);
		// center
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, new CenterFragment()).commit();
		getSlidingMenu().setSecondaryMenu(R.layout.menu_frame_two);
		getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
		getSlidingMenu().setBehindScrollScale(0.0f);
		getSlidingMenu().setBehindCanvasTransformer(mTransformer);
		// right
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame_two, new RightFragment()).commit();
		// 加载导航列表
		mItems = getResources().getStringArray(R.array.items);
		Context context = getSupportActionBar().getThemedContext();
		ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(context, R.array.items,
				R.layout.sherlock_spinner_item);
		list.setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		getSupportActionBar().setListNavigationCallbacks(list, this);
		getSupportActionBar().setSubtitle("Enchant me!");
	}
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		switch (itemPosition) {
		case 0:// 显示个人基本信息
			findViewById(R.id.layout_basic).setVisibility(View.VISIBLE);
			findViewById(R.id.layout_evaluation).setVisibility(View.GONE);
			break;
		case 1:// 显示个人评价
			findViewById(R.id.layout_basic).setVisibility(View.GONE);
			findViewById(R.id.layout_evaluation).setVisibility(View.VISIBLE);
			break;
		default:
			break;
		}
		return true;
	}
}
