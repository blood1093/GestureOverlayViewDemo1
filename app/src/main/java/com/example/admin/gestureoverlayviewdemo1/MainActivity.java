package com.example.admin.gestureoverlayviewdemo1;

import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView mImageView;
    Button mButton;
    GestureOverlayView mGestureOverlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.image);
        mButton = findViewById(R.id.btn);
        mGestureOverlayView = findViewById(R.id.gesture);
        initData();
        initListener();
    }

    private void initData() {
        //设置手势可多笔画绘制，默认情况为单笔画绘制
        mGestureOverlayView.setGestureStrokeType(GestureOverlayView.GESTURE_STROKE_TYPE_MULTIPLE);
        //设置手势长形识别精度
        mGestureOverlayView.setGestureStrokeLengthThreshold(0.01f);
        //设置手势方形识别精度
        mGestureOverlayView.setGestureStrokeSquarenessTreshold(0.01f);
        //设置手势角度识别精度
        mGestureOverlayView.setGestureStrokeAngleThreshold(0.01f);
        //设置手势的颜色(红色)
        mGestureOverlayView.setGestureColor(0xffff0000);
        //设置还没未能形成手势绘制是的颜色(绿色)
        mGestureOverlayView.setUncertainGestureColor(0xff00ff00);
        //设置手势的粗细
        mGestureOverlayView.setGestureStrokeWidth(7);
        //设置是否使用手势淡出效果的动画
        mGestureOverlayView.setFadeEnabled(false);
        /*手势绘制完成后淡出屏幕的时间间隔，即绘制完手指离开屏幕后相隔多长时间手势从屏幕上消失；
         * 可以理解为手势绘制完成手指离开屏幕后到调用onGesturePerformed的时间间隔
         * 默认值为420毫秒，这里设置为2秒
         */
        mGestureOverlayView.setFadeOffset(Integer.MAX_VALUE);
    }

    private void initListener() {
        //确认签名
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = mGestureOverlayView.getGesture().toBitmap(280, 280, 10, Color.RED);
                mImageView.setImageBitmap(bitmap);
                mGestureOverlayView.setGesture(new Gesture());
            }
        });
        //手势执行监听(此方法去掉后会造成生成的手势的颜色不对)
        mGestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            //手势执行完成
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

            }
        });
        //手势进行监听
        mGestureOverlayView.addOnGesturingListener(new GestureOverlayView.OnGesturingListener() {
            //手势绘制开始
            @Override
            public void onGesturingStarted(GestureOverlayView overlay) {
                mImageView.setImageBitmap(null);
            }

            //手势绘制结束
            @Override
            public void onGesturingEnded(GestureOverlayView overlay) {

            }
        });
    }
}
