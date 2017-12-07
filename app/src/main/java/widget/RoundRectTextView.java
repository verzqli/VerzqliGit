package widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.verzqli.application.R;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by aiya on 17/10/31.
 */

public class RoundRectTextView extends AppCompatTextView{
    private  int width ,height;
    private Paint mPaint;
    RectF rect;
    public RoundRectTextView(Context context) {
        this(context, null);
    }

    public RoundRectTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;

        rect = new RectF(0,0,w,h);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(rect,20,20 ,mPaint);
        super.onDraw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPaint.setColor(Color.BLUE);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                mPaint.setColor(Color.RED);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }
        return super.onTouchEvent(event);
    }
}