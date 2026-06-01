package com.bytedance.sdk.component.adexpress.vCE;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import androidx.webkit.internal.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp extends ImageView {
    private float Bc;
    private boolean Cc;
    private float DmF;
    private int EO;
    private int EV;
    private Movie IlO;
    private long MY;
    private int NV;
    private boolean bWL;
    private boolean hp;
    private float lEW;
    private volatile boolean rp;
    private AnimatedImageDrawable tV;
    private boolean vCE;

    public hp(Context context) {
        super(context);
        this.Cc = Build.VERSION.SDK_INT >= 28;
        this.vCE = false;
        this.hp = true;
        this.bWL = true;
        IlO();
    }

    private void EO() {
        if (this.IlO == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.MY == 0) {
            this.MY = jUptimeMillis;
        }
        int iDuration = this.IlO.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (this.bWL || Math.abs(iDuration - this.EO) >= 60) {
            this.EO = (int) ((jUptimeMillis - this.MY) % ((long) iDuration));
        } else {
            this.EO = iDuration;
            this.rp = true;
        }
    }

    private void MY() {
        if (this.IlO == null || this.Cc || !this.hp) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && b.x(drawable)) {
            AnimatedImageDrawable animatedImageDrawableG = b.g(drawable);
            this.tV = animatedImageDrawableG;
            if (!this.rp) {
                animatedImageDrawableG.start();
            }
            if (!this.bWL) {
                animatedImageDrawableG.setRepeatCount(0);
            }
        }
        MY();
    }

    public void IlO() {
        if (this.Cc) {
            return;
        }
        setLayerType(1, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.IlO == null || this.Cc) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.rp) {
                IlO(canvas);
                return;
            }
            EO();
            IlO(canvas);
            MY();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        if (this.IlO != null && !this.Cc) {
            this.Bc = (getWidth() - this.NV) / 2.0f;
            this.lEW = (getHeight() - this.EV) / 2.0f;
        }
        this.hp = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i8) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i2, i8);
        if (this.Cc || (movie = this.IlO) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.IlO.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i2) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i2))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i8) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i8))) ? 1.0f : iHeight / size);
        this.DmF = fMax;
        int i9 = (int) (iWidth * fMax);
        this.NV = i9;
        int i10 = (int) (iHeight * fMax);
        this.EV = i10;
        setMeasuredDimension(i9, i10);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i2) {
        super.onScreenStateChanged(i2);
        if (this.IlO != null) {
            this.hp = i2 == 1;
            MY();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (this.IlO != null) {
            this.hp = i2 == 0;
            MY();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.IlO != null) {
            this.hp = i2 == 0;
            MY();
        }
    }

    public void setRepeatConfig(boolean z2) {
        AnimatedImageDrawable animatedImageDrawable;
        this.bWL = z2;
        if (z2) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.tV) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception unused) {
        }
    }

    private void IlO(Canvas canvas) {
        Movie movie = this.IlO;
        if (movie == null) {
            return;
        }
        movie.setTime(this.EO);
        float f4 = this.DmF;
        if (f4 == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.IlO.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f4, f4);
            Movie movie2 = this.IlO;
            float f8 = this.Bc;
            float f9 = this.DmF;
            movie2.draw(canvas, f8 / f9, this.lEW / f9);
        }
        canvas.restore();
    }
}
