package com.ruins.android.ui.widget.FloatingActionButton;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/**
 * 可拖拽悬浮按钮
 */
public class DragFloatingActionButton extends FloatingActionButton {

	private int parentHeight;
	private int parentWidth;
	private int lastX;
	private int lastY;

	private boolean isDrag;
	//最小滑动距离
	private int mTouchSlop;

	public DragFloatingActionButton(Context context) {
		super(context);
	}

	public DragFloatingActionButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	//主要代码：
	@Override public boolean onTouchEvent(MotionEvent event) {
		//记录 控件当前位置
		int rawX = (int) event.getRawX();
		int rawY = (int) event.getRawY();
		//获取系统的最小滑动距离,大于这个距离才移动控件
		ViewConfiguration configuration = ViewConfiguration.get(getContext());
		mTouchSlop = configuration.getScaledTouchSlop();

		switch (event.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
				//按下操作时 设置按下 即非拖拽状态
				setPressed(true);
				isDrag = false;
				//告知父控件不做拦截处理，之后的一些操作即不拦截
				getParent().requestDisallowInterceptTouchEvent(true);
				//记录按下时坐标位置
				lastX = rawX;
				lastY = rawY;
				ViewGroup parent;
				if (getParent() != null) {
					parent = (ViewGroup) getParent();
					parentHeight = parent.getHeight();
					parentWidth = parent.getWidth();
				}
				break;
			case MotionEvent.ACTION_MOVE:
				//滑动状态下计算x,y相对位移
				int dx = rawX - lastX;
				int dy = rawY - lastY;
				//根据 移动距离 是否大于最小滑动距离来判断是否在进行拖拽
				//两点间距离公式
				if (Math.sqrt(dx * dx + dy * dy) > mTouchSlop) {
					isDrag = true;
				} else {
					isDrag = false;
				}
				//如果拖拽
				if (isDrag) {
					float x = getX() + dx;
					float y = getY() + dy;
					//检测是否到达边缘 左上右下  上下边缘设限
					x = x < 0 ? 0 : x > parentWidth - getWidth() ? parentWidth - getWidth() : x;
					y = getY() < 300 ? 300 : getY() + getHeight() > parentHeight-300 ? parentHeight - getHeight()-300 : y;
					setX(x);
					setY(y);
					lastX = rawX;
					lastY = rawY;
				}
				break;
			case MotionEvent.ACTION_UP:
				//拖拽到靠边
				if (!isNotDrag()) {
					setPressed(false);
					//根据坐标 判断 靠左还是靠右吸附
					if (rawX >= parentWidth / 2) {
						//靠右吸附
						animate().setInterpolator(new DecelerateInterpolator()).setDuration(500).xBy(parentWidth - getWidth() - getX()).start();
					} else {
						//靠左吸附
						ObjectAnimator oa = ObjectAnimator.ofFloat(this, "x", getX(), 0);
						oa.setInterpolator(new DecelerateInterpolator());
						oa.setDuration(500);
						oa.start();
					}
				}
				break;
			case MotionEvent.ACTION_CANCEL:
				getParent().requestDisallowInterceptTouchEvent(false);
				setPressed(false);
				break;
		}

		//如果是拖拽则消耗事件，否则正常传递即可。
		return !isNotDrag() || super.onTouchEvent(event);
	}

	//靠边拖拽
	private boolean isNotDrag() {
		//靠边时，&&右边为true，!isDrag为false,整体为false
		return !isDrag && (getX() == 0 || (getX() == parentWidth - getWidth()));
	}

}
