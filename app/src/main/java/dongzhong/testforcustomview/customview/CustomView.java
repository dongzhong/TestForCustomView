package dongzhong.testforcustomview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by dongzhong on 2017/12/19.
 */

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
        Log.d("Constructor", "一个参数");
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("Constructor", "两个个参数");
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("Constructor", "三个参数");
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        // 对wrap_content的支持，可根据情况设置setMeasuredDimension(measuredWidth, measuredHeight);
        switch (widthSpecMode) {
            case MeasureSpec.AT_MOST:
                // 父控件为子控件指定最大确切大小，希望子控件不要超过这个大小
                Log.d("MeasureMode", "Width是AT_MOST");
                widthSpecSize = 300;
                break;
            case MeasureSpec.EXACTLY:
                // 父控件为子控件指定确切大小，希望子控件完全按照自己给定的尺寸来处理
                Log.d("MeasureMode", "Width是EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                // 父控件对子控件不加任何约束
                Log.d("MeasureMode", "Width是UNSPECIFIED");
                break;
            default:
                break;
        }
        switch (heightSpecMode) {
            case MeasureSpec.AT_MOST:
                Log.d("MeasureMode", "Height是AT_MOST");
                heightSpecSize = 300;
                break;
            case MeasureSpec.EXACTLY:
                Log.d("MeasureMode", "Height是EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                Log.d("MeasureMode", "Height是UNSPECIFIED");
                break;
            default:
                break;
        }

        setMeasuredDimension(widthSpecSize, heightSpecSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 对padding的支持
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();

        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;

        Paint paddingPaint = new Paint();
        paddingPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paddingPaint);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(new Rect(paddingLeft, paddingTop, paddingLeft + width, paddingTop + height), paint);

    }
}
