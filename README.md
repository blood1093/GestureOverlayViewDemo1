# GestureOverlayViewDemo1
用于学习GestureOverlayView的一个简单demo,用来绘制手写签名
主要核心代码
   //设置手势可多笔画绘制，默认情况为单笔画绘制
    mGestureOverlayView.setGestureStrokeTy(GestureOverlayView.GESTURE_STROKE_TYPE_MULTIPLE);
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