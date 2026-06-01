package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF extends Drawable {
    private int EO;
    private Paint IlO;
    private int MY;
    private RectF tV;

    public xF(int i2, int i8) {
        this.EO = i2;
        this.MY = i8;
        Paint paint = new Paint();
        this.IlO = paint;
        paint.setColor(0);
        this.IlO.setAntiAlias(true);
        this.IlO.setShadowLayer(i8, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        this.IlO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        RectF rectF = this.tV;
        int i2 = this.EO;
        canvas.drawRoundRect(rectF, i2, i2, this.IlO);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.IlO.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i8, int i9, int i10) {
        super.setBounds(i2, i8, i9, i10);
        int i11 = this.MY;
        this.tV = new RectF(i2 + i11, i8 + i11, i9 - i11, i10 - i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.IlO.setColorFilter(colorFilter);
    }
}
