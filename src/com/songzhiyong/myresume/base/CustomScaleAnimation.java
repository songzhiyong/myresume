package com.songzhiyong.myresume.base;
import android.graphics.Canvas;
import com.slidingmenu.lib.SlidingMenu.CanvasTransformer;
import com.songzhiyong.myresume.R;
public class CustomScaleAnimation extends CustomAnimation {
	public CustomScaleAnimation() {
		super(R.string.anim_scale, new CanvasTransformer() {
			public void transformCanvas(Canvas canvas, float percentOpen) {
				canvas.scale(percentOpen, 1, 0, 0);
			}
		});
	}
}
