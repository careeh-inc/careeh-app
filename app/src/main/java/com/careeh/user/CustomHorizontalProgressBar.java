package com.careeh.user;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

public class CustomHorizontalProgressBar extends ProgressBar {
    private static final int CIRCLE_RADIUS_DP = 10; // Adjust the circle size as needed
    private static final int PROGRESS_COLOR = Color.RED; // Adjust the progress color as needed
    private static final int BACKGROUND_COLOR = Color.LTGRAY; // Adjust the background color as needed

    private Paint progressPaint;
    private Paint backgroundPaint;
    private int progress = 0; // Current progress, range: 0 to 100

    public CustomHorizontalProgressBar(Context context) {
        super(context);
        init();
    }

    public CustomHorizontalProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomHorizontalProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        float density = getResources().getDisplayMetrics().density;
        int circleRadiusPx = (int) (CIRCLE_RADIUS_DP * density);

        progressPaint = new Paint();
        progressPaint.setColor(PROGRESS_COLOR);
        progressPaint.setAntiAlias(true);

        backgroundPaint = new Paint();
        backgroundPaint.setColor(BACKGROUND_COLOR);
        backgroundPaint.setAntiAlias(true);

        // Adjust padding to accommodate circle radius on both sides
        setPadding(circleRadiusPx, 0, circleRadiusPx, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int height = getHeight();

        int progressWidth = (int) (width * (progress / 100f));

        // Draw the background
        canvas.drawRect(getPaddingLeft(), 0, width + getPaddingLeft(), height, backgroundPaint);

        // Draw the progress
        canvas.drawRect(getPaddingLeft(), 0, progressWidth + getPaddingLeft(), height, progressPaint);

        // Draw the circles at the start and end
        canvas.drawCircle(getPaddingLeft(), height / 2f, CIRCLE_RADIUS_DP, progressPaint);
        canvas.drawCircle(progressWidth + getPaddingLeft(), height / 2f, CIRCLE_RADIUS_DP, progressPaint);
    }

    public void setProgress(int progress) {
        this.progress = Math.max(0, Math.min(100, progress));
        invalidate();
    }
}
