package sg.bigo.ads.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import sg.bigo.ads.common.utils.e;

/* JADX INFO: loaded from: classes6.dex */
public class Indicator extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f16078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f16079d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f16080f;
    private int g;
    private float h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16081i;
    private float j;
    private float k;
    private int l;
    private float m;

    public Indicator(Context context) {
        this(context, null);
    }

    public static float a(int i2, float f4, float f8, float f9) {
        float f10 = i2 - 1;
        return (f4 * f10) + (f8 * 2.0f * f10) + f9;
    }

    public float getDistance() {
        return this.j;
    }

    public float getLengthSelected() {
        return this.h;
    }

    public float getRadius() {
        return this.f16080f;
    }

    public int getType() {
        return this.f16077b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f16077b != 1) {
            a(canvas);
            return;
        }
        if (this.m > 0.0f) {
            float width = canvas.getWidth();
            float height = canvas.getHeight();
            float f4 = this.m;
            canvas.translate(((width - f4) / 2.0f) + this.f16080f, height / 2.0f);
            a();
            float f8 = this.f16080f;
            RectF rectF = new RectF(0.0f, -f8, f4, f8);
            float f9 = this.f16080f;
            canvas.drawRoundRect(rectF, f9, f9, this.f16078c);
            float f10 = (f4 - this.h) * this.f16076a;
            float f11 = this.f16080f;
            RectF rectF2 = new RectF(f10, -f11, this.h + f10, f11);
            float f12 = this.f16080f;
            canvas.drawRoundRect(rectF2, f12, f12, this.f16079d);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i8);
        float f4 = this.f16080f * 2.0f;
        int i9 = this.e;
        float paddingLeft = (this.j * (i9 - 1)) + (f4 * (i9 - 1)) + this.h + getPaddingLeft() + getPaddingRight();
        float paddingTop = (this.f16080f * 2.0f) + getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension((int) paddingLeft, (int) paddingTop);
            return;
        }
        if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension((int) paddingLeft, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, (int) paddingTop);
        } else {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i2), View.getDefaultSize(getSuggestedMinimumHeight(), i8));
        }
    }

    public void setColor(int i2) {
        if (this.g != i2) {
            this.g = i2;
            invalidate();
        }
    }

    public void setColorSelected(int i2) {
        if (this.f16081i != i2) {
            this.f16081i = i2;
            invalidate();
        }
    }

    public void setLineLength(float f4) {
        if (this.m != f4) {
            this.m = f4;
            requestLayout();
            invalidate();
        }
    }

    public void setNum(int i2) {
        if (this.e != i2) {
            sg.bigo.ads.common.t.a.a("Indicator", "onMeasure, setNum=".concat(String.valueOf(i2)));
            this.e = i2;
            requestLayout();
            invalidate();
        }
    }

    public void setRadius(float f4) {
        if (f4 != this.f16080f) {
            this.f16080f = f4;
            this.h = 8.0f * f4;
            this.j = f4 * 2.0f;
            requestLayout();
            invalidate();
        }
    }

    public void setType(int i2) {
        if (this.f16077b != i2) {
            this.f16077b = i2;
            invalidate();
        }
    }

    public Indicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        Paint paint = new Paint();
        this.f16078c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f16078c.setColor(this.g);
        this.f16078c.setAntiAlias(true);
        this.f16078c.setStrokeWidth(3.0f);
        Paint paint2 = new Paint(this.f16078c);
        this.f16079d = paint2;
        paint2.setColor(this.f16081i);
    }

    public Indicator(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16077b = 0;
        this.g = -2130706433;
        float fA = e.a(getContext(), 2);
        this.f16080f = fA;
        this.f16081i = -1;
        this.h = 8.0f * fA;
        this.j = fA * 2.0f;
        this.e = 0;
        this.k = 0.0f;
        this.l = 0;
    }

    public final void a(float f4, int i2) {
        if (i2 == this.l) {
            this.k = (-f4) * 2.0f;
            invalidate();
        }
    }

    public final void a(int i2) {
        if (this.l != i2) {
            this.l = i2;
            this.k = 0.0f;
            invalidate();
        }
    }

    private void a(Canvas canvas) {
        float f4;
        if (this.e <= 0) {
            return;
        }
        canvas.translate(((((canvas.getWidth() - getPaddingLeft()) - getPaddingRight()) - a(this.e, this.j, this.f16080f, this.h)) / 2.0f) + getPaddingLeft() + this.f16080f, (((canvas.getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f) + getPaddingTop());
        a();
        float f8 = -this.f16080f;
        for (int i2 = 0; i2 < this.e; i2++) {
            if (i2 == this.l) {
                float f9 = this.f16080f;
                canvas.drawCircle(f8 + f9, 0.0f, f9, this.f16078c);
                float f10 = this.h + f8;
                float f11 = this.f16080f;
                canvas.drawCircle(f10 - f11, 0.0f, f11, this.f16078c);
                float f12 = (this.j * this.k) + f8;
                float f13 = this.f16080f;
                RectF rectF = new RectF(f12, -f13, this.h + f12, f13);
                float f14 = this.f16080f;
                canvas.drawRoundRect(rectF, f14, f14, this.f16079d);
                f4 = this.h;
            } else {
                float f15 = this.f16080f;
                canvas.drawCircle(f8 + f15, 0.0f, f15, this.f16078c);
                f4 = this.f16080f * 2.0f;
            }
            f8 = f8 + f4 + this.j;
        }
    }
}
