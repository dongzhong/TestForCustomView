package dongzhong.testforcustomview.customview;

import android.content.Context;
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
}
