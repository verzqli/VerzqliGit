package widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xupei on 17/12/7.
 */

public class MobikeBallView extends View {
    public MobikeBallView(Context context) {
        this(context, null);
    }

    public MobikeBallView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MobikeBallView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
