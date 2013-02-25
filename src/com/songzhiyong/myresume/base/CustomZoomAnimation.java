package com.songzhiyong.myresume.base;
import android.graphics.Canvas;
import com.slidingmenu.lib.SlidingMenu.CanvasTransformer;
import com.songzhiyong.myresume.R;
public class CustomZoomAnimation extends CustomAnimation {
	public CustomZoomAnimation() {
		// see the class CustomAnimation for how to attach
		// the CanvasTransformer to the SlidingMenu
		super(R.string.anim_zoom, new CanvasTransformer() {
			public void transformCanvas(Canvas canvas, float percentOpen) {
				float scale = (float) (percentOpen * 0.25 + 0.75);
				canvas.scale(scale, scale, canvas.getWidth() / 2, canvas.getHeight() / 2);
			}
		});
	}
}