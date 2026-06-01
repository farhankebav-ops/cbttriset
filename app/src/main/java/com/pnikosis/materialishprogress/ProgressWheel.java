package com.pnikosis.materialishprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;
import l3.a;
import l3.b;
import l3.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ProgressWheel extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10843d;
    public double e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f10844f;
    public float g;
    public boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10845i;
    public int j;
    public int k;
    public final Paint l;
    public final Paint m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RectF f10846n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f10847o;
    public long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10848q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f10849r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f10850s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10851t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f10852u;

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10840a = 28;
        this.f10841b = 4;
        this.f10842c = 4;
        this.f10843d = false;
        this.e = 0.0d;
        this.f10844f = 460.0d;
        this.g = 0.0f;
        this.h = true;
        this.f10845i = 0L;
        this.j = -1442840576;
        this.k = ViewCompat.MEASURED_SIZE_MASK;
        this.l = new Paint();
        this.m = new Paint();
        this.f10846n = new RectF();
        this.f10847o = 230.0f;
        this.p = 0L;
        this.f10849r = 0.0f;
        this.f10850s = 0.0f;
        this.f10851t = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.f12770a);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f10841b = (int) TypedValue.applyDimension(1, this.f10841b, displayMetrics);
        this.f10842c = (int) TypedValue.applyDimension(1, this.f10842c, displayMetrics);
        int iApplyDimension = (int) TypedValue.applyDimension(1, this.f10840a, displayMetrics);
        this.f10840a = iApplyDimension;
        this.f10840a = (int) typedArrayObtainStyledAttributes.getDimension(3, iApplyDimension);
        this.f10843d = typedArrayObtainStyledAttributes.getBoolean(4, false);
        this.f10841b = (int) typedArrayObtainStyledAttributes.getDimension(2, this.f10841b);
        this.f10842c = (int) typedArrayObtainStyledAttributes.getDimension(8, this.f10842c);
        this.f10847o = typedArrayObtainStyledAttributes.getFloat(9, this.f10847o / 360.0f) * 360.0f;
        this.f10844f = typedArrayObtainStyledAttributes.getInt(1, (int) this.f10844f);
        this.j = typedArrayObtainStyledAttributes.getColor(0, this.j);
        this.k = typedArrayObtainStyledAttributes.getColor(7, this.k);
        this.f10848q = typedArrayObtainStyledAttributes.getBoolean(5, false);
        if (typedArrayObtainStyledAttributes.getBoolean(6, false)) {
            this.p = SystemClock.uptimeMillis();
            this.f10851t = true;
            invalidate();
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f10852u = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f;
    }

    public final void a() {
        int i2 = this.j;
        Paint paint = this.l;
        paint.setColor(i2);
        paint.setAntiAlias(true);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(this.f10841b);
        int i8 = this.k;
        Paint paint2 = this.m;
        paint2.setColor(i8);
        paint2.setAntiAlias(true);
        paint2.setStyle(style);
        paint2.setStrokeWidth(this.f10842c);
    }

    public int getBarColor() {
        return this.j;
    }

    public int getBarWidth() {
        return this.f10841b;
    }

    public int getCircleRadius() {
        return this.f10840a;
    }

    public float getProgress() {
        if (this.f10851t) {
            return -1.0f;
        }
        return this.f10849r / 360.0f;
    }

    public int getRimColor() {
        return this.k;
    }

    public int getRimWidth() {
        return this.f10842c;
    }

    public float getSpinSpeed() {
        return this.f10847o / 360.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f4;
        super.onDraw(canvas);
        canvas.drawArc(this.f10846n, 360.0f, 360.0f, false, this.m);
        if (this.f10852u) {
            boolean z2 = this.f10851t;
            Paint paint = this.l;
            float fPow = 0.0f;
            boolean z7 = true;
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis() - this.p;
                float f8 = (jUptimeMillis * this.f10847o) / 1000.0f;
                long j = this.f10845i;
                if (j >= 200) {
                    double d8 = this.e + jUptimeMillis;
                    this.e = d8;
                    double d9 = this.f10844f;
                    if (d8 > d9) {
                        this.e = d8 - d9;
                        this.f10845i = 0L;
                        this.h = !this.h;
                    }
                    float fCos = (((float) Math.cos(((this.e / d9) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
                    if (this.h) {
                        this.g = fCos * 254.0f;
                    } else {
                        float f9 = (1.0f - fCos) * 254.0f;
                        this.f10849r = (this.g - f9) + this.f10849r;
                        this.g = f9;
                    }
                } else {
                    this.f10845i = j + jUptimeMillis;
                }
                float f10 = this.f10849r + f8;
                this.f10849r = f10;
                if (f10 > 360.0f) {
                    this.f10849r = f10 - 360.0f;
                }
                this.p = SystemClock.uptimeMillis();
                float f11 = this.f10849r - 90.0f;
                float f12 = this.g + 16.0f;
                if (isInEditMode()) {
                    f12 = 135.0f;
                    f4 = 0.0f;
                } else {
                    f4 = f11;
                }
                canvas.drawArc(this.f10846n, f4, f12, false, paint);
            } else {
                if (this.f10849r != this.f10850s) {
                    this.f10849r = Math.min(this.f10849r + (((SystemClock.uptimeMillis() - this.p) / 1000.0f) * this.f10847o), this.f10850s);
                    this.p = SystemClock.uptimeMillis();
                } else {
                    z7 = false;
                }
                float fPow2 = this.f10849r;
                if (!this.f10848q) {
                    fPow = ((float) (1.0d - Math.pow(1.0f - (fPow2 / 360.0f), 4.0f))) * 360.0f;
                    fPow2 = ((float) (1.0d - Math.pow(1.0f - (this.f10849r / 360.0f), 2.0f))) * 360.0f;
                }
                canvas.drawArc(this.f10846n, fPow - 90.0f, isInEditMode() ? 360.0f : fPow2, false, paint);
            }
            if (z7) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        int paddingRight = getPaddingRight() + getPaddingLeft() + this.f10840a;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + this.f10840a;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        if (mode == 1073741824) {
            paddingRight = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingRight = Math.min(paddingRight, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingBottom = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingBottom = Math.min(paddingBottom, size2);
        }
        setMeasuredDimension(paddingRight, paddingBottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.f10849r = bVar.f12764a;
        this.f10850s = bVar.f12765b;
        this.f10851t = bVar.f12766c;
        this.f10847o = bVar.f12767d;
        this.f10841b = bVar.e;
        this.j = bVar.f12768f;
        this.f10842c = bVar.g;
        this.k = bVar.h;
        this.f10840a = bVar.f12769i;
        this.f10848q = bVar.j;
        this.f10843d = bVar.k;
        this.p = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f12764a = this.f10849r;
        bVar.f12765b = this.f10850s;
        bVar.f12766c = this.f10851t;
        bVar.f12767d = this.f10847o;
        bVar.e = this.f10841b;
        bVar.f12768f = this.j;
        bVar.g = this.f10842c;
        bVar.h = this.k;
        bVar.f12769i = this.f10840a;
        bVar.j = this.f10848q;
        bVar.k = this.f10843d;
        return bVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.f10843d) {
            int i11 = this.f10841b;
            this.f10846n = new RectF(paddingLeft + i11, paddingTop + i11, (i2 - paddingRight) - i11, (i8 - paddingBottom) - i11);
        } else {
            int i12 = (i2 - paddingLeft) - paddingRight;
            int iMin = Math.min(Math.min(i12, (i8 - paddingBottom) - paddingTop), (this.f10840a * 2) - (this.f10841b * 2));
            int i13 = ((i12 - iMin) / 2) + paddingLeft;
            int i14 = ((((i8 - paddingTop) - paddingBottom) - iMin) / 2) + paddingTop;
            int i15 = this.f10841b;
            this.f10846n = new RectF(i13 + i15, i14 + i15, (i13 + iMin) - i15, (i14 + iMin) - i15);
        }
        a();
        invalidate();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            this.p = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i2) {
        this.j = i2;
        a();
        if (this.f10851t) {
            return;
        }
        invalidate();
    }

    public void setBarWidth(int i2) {
        this.f10841b = i2;
        if (this.f10851t) {
            return;
        }
        invalidate();
    }

    public void setCircleRadius(int i2) {
        this.f10840a = i2;
        if (this.f10851t) {
            return;
        }
        invalidate();
    }

    public void setInstantProgress(float f4) {
        if (this.f10851t) {
            this.f10849r = 0.0f;
            this.f10851t = false;
        }
        if (f4 > 1.0f) {
            f4 -= 1.0f;
        } else if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 == this.f10850s) {
            return;
        }
        float fMin = Math.min(f4 * 360.0f, 360.0f);
        this.f10850s = fMin;
        this.f10849r = fMin;
        this.p = SystemClock.uptimeMillis();
        invalidate();
    }

    public void setLinearProgress(boolean z2) {
        this.f10848q = z2;
        if (this.f10851t) {
            return;
        }
        invalidate();
    }

    public void setProgress(float f4) {
        if (this.f10851t) {
            this.f10849r = 0.0f;
            this.f10851t = false;
        }
        if (f4 > 1.0f) {
            f4 -= 1.0f;
        } else if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        float f8 = this.f10850s;
        if (f4 == f8) {
            return;
        }
        if (this.f10849r == f8) {
            this.p = SystemClock.uptimeMillis();
        }
        this.f10850s = Math.min(f4 * 360.0f, 360.0f);
        invalidate();
    }

    public void setRimColor(int i2) {
        this.k = i2;
        a();
        if (this.f10851t) {
            return;
        }
        invalidate();
    }

    public void setRimWidth(int i2) {
        this.f10842c = i2;
        if (this.f10851t) {
            return;
        }
        invalidate();
    }

    public void setSpinSpeed(float f4) {
        this.f10847o = f4 * 360.0f;
    }

    public void setCallback(a aVar) {
    }
}
