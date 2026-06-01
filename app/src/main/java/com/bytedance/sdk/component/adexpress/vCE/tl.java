package com.bytedance.sdk.component.adexpress.vCE;

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
import android.widget.ImageView;
import androidx.webkit.internal.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tl extends ImageView {
    private int EO;
    private Paint IlO;
    private int MY;
    private Matrix tV;

    public tl(Context context) {
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
        Drawable drawable = getDrawable();
        if (Build.VERSION.SDK_INT >= 28 && b.x(drawable)) {
            super.onDraw(canvas);
            return;
        }
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap bitmapIlO = IlO(drawable);
        if (bitmapIlO == null) {
            super.onDraw(canvas);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        BitmapShader bitmapShader = new BitmapShader(bitmapIlO, tileMode, tileMode);
        float fMax = (bitmapIlO.getWidth() == getWidth() && bitmapIlO.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapIlO.getWidth(), (getHeight() * 1.0f) / bitmapIlO.getHeight());
        this.tV.setScale(fMax, fMax);
        bitmapShader.setLocalMatrix(this.tV);
        this.IlO.setShader(bitmapShader);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.MY, this.EO, this.IlO);
    }

    public void setXRound(int i2) {
        this.MY = i2;
        postInvalidate();
    }

    public void setYRound(int i2) {
        this.EO = i2;
        postInvalidate();
    }

    public tl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public tl(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.MY = 25;
        this.EO = 25;
        Paint paint = new Paint();
        this.IlO = paint;
        paint.setAntiAlias(true);
        this.IlO.setFilterBitmap(true);
        this.tV = new Matrix();
    }
}
