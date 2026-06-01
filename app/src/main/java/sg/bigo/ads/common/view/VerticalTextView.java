package sg.bigo.ads.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/* JADX INFO: loaded from: classes6.dex */
public class VerticalTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16122a;

    public VerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16122a = true;
        int gravity = getGravity();
        if (!Gravity.isVertical(gravity) || (gravity & 112) != 80) {
            this.f16122a = true;
        } else {
            setGravity((gravity & 7) | 48);
            this.f16122a = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        float f4;
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        canvas.save();
        if (this.f16122a) {
            canvas.translate(getWidth(), 0.0f);
            f4 = 90.0f;
        } else {
            canvas.translate(0.0f, getHeight());
            f4 = -90.0f;
        }
        canvas.rotate(f4);
        canvas.translate(getCompoundPaddingLeft(), getExtendedPaddingTop());
        getLayout().draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i8, i2);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }
}
