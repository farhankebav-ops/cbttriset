package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.webkit.internal.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa extends com.bytedance.sdk.openadsdk.core.Cc.tV {
    private final RectF Cc;
    private int EO;
    private final Paint IlO;
    private int MY;
    private final Matrix tV;
    private BitmapShader vCE;

    public zPa(Context context) {
        this(context, null);
    }

    private Bitmap IlO(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmapIlO;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && b.x(drawable)) {
            super.onDraw(canvas);
            return;
        }
        if (this.vCE == null && (bitmapIlO = IlO(drawable)) != null) {
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.vCE = new BitmapShader(bitmapIlO, tileMode, tileMode);
            float fMax = (bitmapIlO.getWidth() == getWidth() && bitmapIlO.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapIlO.getWidth(), (getHeight() * 1.0f) / bitmapIlO.getHeight());
            this.tV.setScale(fMax, fMax);
            this.vCE.setLocalMatrix(this.tV);
        }
        BitmapShader bitmapShader = this.vCE;
        if (bitmapShader == null) {
            super.onDraw(canvas);
        } else {
            this.IlO.setShader(bitmapShader);
            canvas.drawRoundRect(this.Cc, this.MY, this.EO, this.IlO);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.Cc.set(0.0f, 0.0f, i2, i8);
    }

    public void setXRound(int i2) {
        this.MY = i2;
        postInvalidate();
    }

    public void setYRound(int i2) {
        this.EO = i2;
        postInvalidate();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        this.vCE = null;
    }

    public zPa(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public zPa(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.MY = 25;
        this.EO = 25;
        this.Cc = new RectF();
        Paint paint = new Paint();
        this.IlO = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        this.tV = new Matrix();
    }
}
