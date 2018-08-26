package com.dong.marqueelib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class MarqueeTextviewNofocus extends AppCompatTextView {

    public static final String TAG = "MarqueeTextView";

    /**
     * 字幕滚动的速度 0:慢, 1:普通, 2:快
     */
    public static final int SCROLL_SLOW = 0;
    public static final int SCROLL_NORM = 1;
    public static final int SCROLL_FAST = 2;
    /**
     * 字幕滚动的方向 0:左往右, 1:右往左
     */
    public static final int LEFT_TO_RIGHT = 0;
    public static final int RIGHT_TO_LEFT = 1;
    /**
     * 默认是从右往左
     */
    public int direction = RIGHT_TO_LEFT;

    /**
     * 文字的横坐标偏移量
     */
    private float offX = 0f;
    /**
     * 默认的移动速度
     */
    private float mStep = 2f;
    /**
     * 画笔
     */
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    /**
     * 文本长度
     */
    private float textLength = 0f;
    /**
     * view 的宽度
     */
    private float viewWidth = 0f;
    /**
     * 文字的纵坐标
     */
    private float y = 0f;
    /**
     * 文本和view的长度之和
     */
    private float viewTextWidth = 0.0f;
    /**
     * 滚动文本
     */
    private String text = "";

    public MarqueeTextviewNofocus(Context context) {
        this(context, null);
        setSingleLine(true);

    }

    public MarqueeTextviewNofocus(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        setSingleLine(true);
    }

    public MarqueeTextviewNofocus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSingleLine(true);
    }

    /**
     * 初始化
     *
     * @param windowManager
     */
    public void init(WindowManager windowManager) {
        mPaint = getPaint();
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(sp2px(getContext(), 16));

        text = getText().toString();
        textLength = mPaint.measureText(text);

        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
//        int height = metrics.heightPixels;
        viewWidth = metrics.widthPixels;
        viewWidth = viewWidth - getLeft() - getLeft();
        // 滚动文本的长度: view 长度 + 文本滑出屏幕的长度
        viewTextWidth = viewWidth + textLength;
        // 滚动文本的绘制起始 y 坐标
        y = getTextSize() + getPaddingTop();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (direction == RIGHT_TO_LEFT) {
            if (offX <= viewTextWidth) {
                /**
                 * viewWidth - offX： x 坐标逐渐变小,往左移动
                 */
                canvas.drawText(text, viewWidth - offX, y, mPaint);
            } else {
                offX = viewWidth / 3;
            }
        } else {
            if (offX <= viewTextWidth) {
                /**
                 * -textLength+offX： x 坐标逐渐变大,往右移动
                 */
                canvas.drawText(text, -textLength + offX, y, mPaint);
            } else {
                offX = 0;
            }
        }

        // 滚动文本的偏移量
        offX += mStep;

        // 重绘
        invalidate();
    }

    /**
     * 设置字幕滚动的速度
     *
     * @param scrollMod
     */
    public void setScrollMode(int scrollMod) {
        if (scrollMod == SCROLL_SLOW) {
            mStep = 1f;
        } else if (scrollMod == SCROLL_NORM) {
            mStep = 2f;
        } else {
            mStep = 3f;
        }
    }

    /**
     * 设置字幕滚动的方向
     *
     * @param direction 0:LEFT_TO_RIGHT  1:RIGHT_TO_LEFT
     */
    public void setScrollDirection(int direction) {
        this.direction = direction;
    }

    /**
     * 将sp值转换为px值
     *
     * @param context
     * @param spValue
     * @return
     */
    private int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
