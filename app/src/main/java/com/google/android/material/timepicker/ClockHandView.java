package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import com.cbt.exam.browser.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f5494n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueAnimator f5495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5498d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f5499f;
    public final RectF g;
    public final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f5500i;
    public boolean j;
    public double k;
    public int l;
    public int m;

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f5495a = valueAnimator;
        this.f5497c = new ArrayList();
        Paint paint = new Paint();
        this.f5499f = paint;
        this.g = new RectF();
        this.m = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b1.a.g, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        a.a.S(context, R.attr.motionDurationLong2, 200);
        a.a.T(context, R.attr.motionEasingEmphasizedInterpolator, c1.a.f4169b);
        this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f5498d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.h = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.e = r5.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i2 = ClockHandView.f5494n;
                this.f5506a.c(((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new e());
    }

    public final int a(int i2) {
        return i2 == 2 ? Math.round(this.l * 0.66f) : this.l;
    }

    public final void b(float f4) {
        this.f5495a.cancel();
        c(f4);
    }

    public final void c(float f4) {
        float f8 = f4 % 360.0f;
        this.f5500i = f8;
        this.k = Math.toRadians(f8 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fA = a(this.m);
        float fCos = (((float) Math.cos(this.k)) * fA) + width;
        float fSin = (fA * ((float) Math.sin(this.k))) + height;
        float f9 = this.f5498d;
        this.g.set(fCos - f9, fSin - f9, fCos + f9, fSin + f9);
        ArrayList arrayList = this.f5497c;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ClockFaceView clockFaceView = (ClockFaceView) ((f) obj);
            if (Math.abs(clockFaceView.f5492q - f8) > 0.001f) {
                clockFaceView.f5492q = f8;
                clockFaceView.b();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f4 = width;
        float fA = a(this.m);
        float fCos = (((float) Math.cos(this.k)) * fA) + f4;
        float f8 = height;
        float fSin = (fA * ((float) Math.sin(this.k))) + f8;
        Paint paint = this.f5499f;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f5498d, paint);
        double dSin = Math.sin(this.k);
        paint.setStrokeWidth(this.h);
        canvas.drawLine(f4, f8, width + ((int) (Math.cos(this.k) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f4, f8, this.e, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        if (this.f5495a.isRunning()) {
            return;
        }
        b(this.f5500i);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z7;
        int actionMasked = motionEvent.getActionMasked();
        float x2 = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z8 = false;
        if (actionMasked == 0) {
            this.j = false;
            z2 = true;
            z7 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z7 = this.j;
            if (this.f5496b) {
                this.m = ((float) Math.hypot((double) (x2 - ((float) (getWidth() / 2))), (double) (y - ((float) (getHeight() / 2))))) <= ((float) a(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z2 = false;
        } else {
            z7 = false;
            z2 = false;
        }
        boolean z9 = this.j;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x2 - (getWidth() / 2)));
        int i2 = degrees + 90;
        if (i2 < 0) {
            i2 = degrees + 450;
        }
        float f4 = i2;
        boolean z10 = this.f5500i != f4;
        if (z2 && z10) {
            z8 = true;
        } else if (z10 || z7) {
            b(f4);
            z8 = true;
        }
        this.j = z9 | z8;
        return true;
    }
}
