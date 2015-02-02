package me.jiho.animatedtogglebutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * Created by user on 2015. 2. 2..
 */
public class MenuAnimatedToggleButton extends AnimatedToggleButton {
    private Paint paint;

    public MenuAnimatedToggleButton(Context context) {
        super(context);
        init();
    }

    public MenuAnimatedToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MenuAnimatedToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
    }

    public void setColor(int color) {
        paint.setColor(color);
    }

    @Override
    protected void draw(Canvas canvas, float animationProgress) {
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int contentWidth = canvasWidth - getPaddingLeft() - getPaddingRight();
        int contentHeight = canvasHeight - getPaddingTop() - getPaddingBottom();

        // smaller square
        int iconSize = (contentWidth < contentHeight? contentWidth : contentHeight);
        int iconLeft = (canvasWidth - iconSize) / 2;
        int iconRight = (canvasWidth - iconLeft);
        int iconTop = (canvasHeight - iconSize) / 2;
        int iconBottom = (canvasHeight - iconTop);

        float[] targetPoints = {
                iconLeft, iconTop,
                iconRight, iconTop,
                iconRight, iconBottom,
                iconLeft, iconBottom,
                iconLeft, iconTop
        };

        canvas.drawRect(
                getPaddingLeft(),
                getPaddingTop(),
                canvasWidth-getPaddingRight(),
                canvasHeight - getPaddingBottom(), paint
        );

    }


    private float[] createRect(int position, int )
}
