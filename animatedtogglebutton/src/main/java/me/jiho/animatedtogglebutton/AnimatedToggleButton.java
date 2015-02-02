package me.jiho.animatedtogglebutton;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/**
 * Created by user on 2015. 2. 2..
 */
public abstract class AnimatedToggleButton extends CompoundButton {
    public static final int DEFAULT_ANIMATION_DURATION = 200;
    protected float animationProgress = 0f;
    protected int animationDuration = DEFAULT_ANIMATION_DURATION;

    public AnimatedToggleButton(Context context) {
        super(context);
    }

    public AnimatedToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimatedToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    final protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        draw(canvas, animationProgress);
    }

    protected abstract void draw(Canvas canvas, float animationProgress);

    public void setDuration(int duration) {
        this.animationDuration = duration;
    }

    public void setProgress(float newProgress) {
        if (newProgress < 0f || newProgress > 1f) {
            // Throw exception
            throw new IllegalArgumentException("Progress must in range 0f to 1f");
        }
        this.animationProgress = newProgress;
        invalidate();
    }


    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        ValueAnimator animator;
        if (checked) {
            animator = ValueAnimator.ofFloat(0f, 1f);
        } else {
            animator = ValueAnimator.ofFloat(1f, 0f);
        }

        animator.setDuration(animationDuration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setProgress((float) animation.getAnimatedValue());
            }
        });
        animator.start();
    }
}
