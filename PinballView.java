package com.example.pinball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class PinballView extends View {
    private Paint paint;
    private RectF ball;
    private float ballX, ballY, ballVelocityX, ballVelocityY;
    private float flipperLeftAngle, flipperRightAngle;
    private boolean flipperLeftActive, flipperRightActive;

    public PinballView(Context context) {
        super(context);
        paint = new Paint();
        ball = new RectF();
        ballX = 200;
        ballY = 200;
        ballVelocityX = 10;
        ballVelocityY = 10;
        flipperLeftAngle = 0;
        flipperRightAngle = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Update ball position
        ballX += ballVelocityX;
        ballY += ballVelocityY;

        // Check for collision with walls
        if (ballX <= 0 || ballX >= getWidth() - 50) {
            ballVelocityX *= -1;
        }
        if (ballY <= 0 || ballY >= getHeight() - 50) {
            ballVelocityY *= -1;
        }

        // Draw the ball
        ball.set(ballX, ballY, ballX + 50, ballY + 50);
        paint.setColor(Color.RED);
        canvas.drawOval(ball, paint);

        // Draw the left flipper
        paint.setColor(Color.BLUE);
        canvas.save();
        canvas.rotate(flipperLeftAngle, 150, getHeight() - 100);
        canvas.drawRect(100, getHeight() - 120, 200, getHeight() - 80, paint);
        canvas.restore();

        // Draw the right flipper
        paint.setColor(Color.GREEN);
        canvas.save();
        canvas.rotate(-flipperRightAngle, getWidth() - 150, getHeight() - 100);
        canvas.drawRect(getWidth() - 200, getHeight() - 120, getWidth() - 100
