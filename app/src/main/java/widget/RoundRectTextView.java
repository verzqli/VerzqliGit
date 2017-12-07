package widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.verzqli.application.R;


/**
 * Created by aiya on 17/10/31.
 */

public class RoundRectTextView extends AppCompatTextView{
    private  int width ,height;
    private Paint mPaint;
    private RectF rect;
    private float radius,leftTopRadius,leftBottomRadius,rightTopRadius,rightBottomRadius;
    private int bgColor,pressedBgColor;
    private Path mPath;
    private onTextClickListener listener;
    //判断四个角是否都是圆角
    private boolean isNormal;
    private float[] radiusArray =new float[8];
    public RoundRectTextView(Context context) {
        this(context, null);
    }

    public RoundRectTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPath = new Path();
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.RoundRectTextView);
        if (ta != null) {
            bgColor = ta.getColor(R.styleable.RoundRectTextView_back_ground, Color.BLUE);
            pressedBgColor = ta.getColor(R.styleable.RoundRectTextView_pressedBackground, Color.GRAY);
            radius = ta.getFloat(R.styleable.RoundRectTextView_rect_radius, 2);
            leftTopRadius = ta.getFloat(R.styleable.RoundRectTextView_leftTopRadius,2);
            leftBottomRadius = ta.getFloat(R.styleable.RoundRectTextView_leftBottomRadius, 2);
            rightTopRadius = ta.getFloat(R.styleable.RoundRectTextView_rightTopRadius,2);
            rightBottomRadius = ta.getFloat(R.styleable.RoundRectTextView_rightBottomRadius, 2);
            if (leftTopRadius==leftBottomRadius&&leftTopRadius==rightTopRadius&&leftTopRadius==rightBottomRadius){
                setRadius(radius,radius,radius,radius);
            }else {
                setRadius(leftTopRadius,rightTopRadius,rightBottomRadius,leftBottomRadius);
            }
            ta.recycle();
        }
        mPaint.setColor(bgColor);
    }
    /**
     * 设置四个角的圆角半径
     */
    public void setRadius(float leftTop, float rightTop, float rightBottom, float leftBottom) {
        radiusArray[0] = leftTop;
        radiusArray[1] = leftTop;
        radiusArray[2] = rightTop;
        radiusArray[3] = rightTop;
        radiusArray[4] = rightBottom;
        radiusArray[5] = rightBottom;
        radiusArray[6] = leftBottom;
        radiusArray[7] = leftBottom;

        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        rect = new RectF(0,0,w,h);
        Log.i("DDDDDD", "onSizeChanged: "+getX()+"   "+getY());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPath.addRoundRect(rect, radiusArray, Path.Direction.CW);
        canvas.drawPath(mPath,mPaint);
        super.onDraw(canvas);
//        780.0   105.0
//        11-08 18:48:30.988 4199-4199/? I/DDDDDD: onSizeChanged: 90.0   338.0
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                 mPaint.setColor(pressedBgColor);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                 mPaint.setColor(bgColor);
                listener.click(this);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y =event.getY();
                if (x<0||x>getWidth()||y<0||y>getHeight()){
                    mPaint.setColor(bgColor);
                    invalidate();
                }

                Log.i("ddddddd", "onTouchEvent: "+event.getX()+"  "+event.getY());
                break;
        }
        return true;
    }
    public interface onTextClickListener{
        void click(View view);
    }
    public void setOnTextClickListener(onTextClickListener listener){
        this.listener = listener;
    }
}