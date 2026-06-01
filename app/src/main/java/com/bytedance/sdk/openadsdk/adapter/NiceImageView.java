package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.Cc.tV;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NiceImageView extends tV {
    private final RectF AXM;
    private int Bc;
    private int Cc;
    private int DmF;
    private boolean EO;
    private int EV;
    private final Context IlO;
    private boolean MY;
    private int NV;
    private final Xfermode bWL;
    private final float[] cL;
    private float cl;
    private int ea;
    private final float[] es;
    private int hp;
    private Path kBB;
    private int lEW;
    private final Paint oeT;
    private int rp;
    private int tV;
    private final Path vAh;
    private int vCE;
    private RectF xF;
    private int zPa;

    public NiceImageView(Context context) {
        this(context, null);
    }

    private void EO() {
        if (this.MY) {
            return;
        }
        int i2 = 0;
        if (this.lEW <= 0) {
            float[] fArr = this.cL;
            int i8 = this.DmF;
            float f4 = i8;
            fArr[1] = f4;
            fArr[0] = f4;
            int i9 = this.NV;
            float f8 = i9;
            fArr[3] = f8;
            fArr[2] = f8;
            int i10 = this.rp;
            float f9 = i10;
            fArr[5] = f9;
            fArr[4] = f9;
            int i11 = this.EV;
            float f10 = i11;
            fArr[7] = f10;
            fArr[6] = f10;
            float[] fArr2 = this.es;
            int i12 = this.tV;
            float f11 = i8 - (i12 / 2.0f);
            fArr2[1] = f11;
            fArr2[0] = f11;
            float f12 = i9 - (i12 / 2.0f);
            fArr2[3] = f12;
            fArr2[2] = f12;
            float f13 = i10 - (i12 / 2.0f);
            fArr2[5] = f13;
            fArr2[4] = f13;
            float f14 = i11 - (i12 / 2.0f);
            fArr2[7] = f14;
            fArr2[6] = f14;
            return;
        }
        while (true) {
            float[] fArr3 = this.cL;
            if (i2 >= fArr3.length) {
                return;
            }
            int i13 = this.lEW;
            fArr3[i2] = i13;
            this.es[i2] = i13 - (this.tV / 2.0f);
            i2++;
        }
    }

    private void IlO(Canvas canvas) {
        if (!this.MY) {
            int i2 = this.tV;
            if (i2 > 0) {
                IlO(canvas, i2, this.Cc, this.AXM, this.cL);
                return;
            }
            return;
        }
        int i8 = this.tV;
        if (i8 > 0) {
            IlO(canvas, i8, this.Cc, this.cl - (i8 / 2.0f));
        }
        int i9 = this.vCE;
        if (i9 > 0) {
            IlO(canvas, i9, this.Bc, (this.cl - this.tV) - (i9 / 2.0f));
        }
    }

    private void MY() {
        if (!this.MY) {
            this.xF.set(0.0f, 0.0f, this.ea, this.zPa);
            if (this.EO) {
                this.xF = this.AXM;
                return;
            }
            return;
        }
        float fMin = Math.min(this.ea, this.zPa) / 2.0f;
        this.cl = fMin;
        RectF rectF = this.xF;
        int i2 = this.ea;
        int i8 = this.zPa;
        rectF.set((i2 / 2.0f) - fMin, (i8 / 2.0f) - fMin, (i2 / 2.0f) + fMin, (i8 / 2.0f) + fMin);
    }

    private void tV() {
        if (this.MY) {
            return;
        }
        this.vCE = 0;
    }

    public void isCircle(boolean z2) {
        this.MY = z2;
        tV();
        MY();
        invalidate();
    }

    public void isCoverSrc(boolean z2) {
        this.EO = z2;
        MY();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.saveLayer(this.xF, null, 31);
        if (!this.EO) {
            int i2 = this.ea;
            int i8 = this.tV;
            int i9 = this.vCE;
            int i10 = this.zPa;
            canvas.scale((((i2 - (i8 * 2)) - (i9 * 2)) * 1.0f) / i2, (((i10 - (i8 * 2)) - (i9 * 2)) * 1.0f) / i10, i2 / 2.0f, i10 / 2.0f);
        }
        super.onDraw(canvas);
        this.oeT.reset();
        this.vAh.reset();
        if (this.MY) {
            this.vAh.addCircle(this.ea / 2.0f, this.zPa / 2.0f, this.cl, Path.Direction.CCW);
        } else {
            this.vAh.addRoundRect(this.xF, this.es, Path.Direction.CCW);
        }
        this.oeT.setAntiAlias(true);
        this.oeT.setStyle(Paint.Style.FILL);
        this.oeT.setXfermode(this.bWL);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.vAh, this.oeT);
        } else {
            this.kBB.addRect(this.xF, Path.Direction.CCW);
            this.kBB.op(this.vAh, Path.Op.DIFFERENCE);
            canvas.drawPath(this.kBB, this.oeT);
        }
        this.oeT.setXfermode(null);
        int i11 = this.hp;
        if (i11 != 0) {
            this.oeT.setColor(i11);
            canvas.drawPath(this.vAh, this.oeT);
        }
        canvas.restore();
        IlO(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.ea = i2;
        this.zPa = i8;
        IlO();
        MY();
    }

    public void setBorderColor(@ColorInt int i2) {
        this.Cc = i2;
        invalidate();
    }

    public void setBorderWidth(int i2) {
        this.tV = BS.MY(this.IlO, i2);
        IlO(false);
    }

    public void setCornerBottomLeftRadius(int i2) {
        this.EV = BS.MY(this.IlO, i2);
        IlO(true);
    }

    public void setCornerBottomRightRadius(int i2) {
        this.rp = BS.MY(this.IlO, i2);
        IlO(true);
    }

    public void setCornerRadius(int i2) {
        this.lEW = BS.MY(this.IlO, i2);
        IlO(false);
    }

    public void setCornerTopLeftRadius(int i2) {
        this.DmF = BS.MY(this.IlO, i2);
        IlO(true);
    }

    public void setCornerTopRightRadius(int i2) {
        this.NV = BS.MY(this.IlO, i2);
        IlO(true);
    }

    public void setInnerBorderColor(@ColorInt int i2) {
        this.Bc = i2;
        invalidate();
    }

    public void setInnerBorderWidth(int i2) {
        this.vCE = BS.MY(this.IlO, i2);
        tV();
        invalidate();
    }

    public void setMaskColor(@ColorInt int i2) {
        this.hp = i2;
        invalidate();
    }

    public NiceImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Cc = -1;
        this.Bc = -1;
        this.IlO = context;
        this.lEW = BS.MY(context, 10.0f);
        this.cL = new float[8];
        this.es = new float[8];
        this.AXM = new RectF();
        this.xF = new RectF();
        this.oeT = new Paint();
        this.vAh = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.bWL = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.bWL = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.kBB = new Path();
        }
        EO();
        tV();
    }

    private void IlO(Canvas canvas, int i2, int i8, float f4) {
        IlO(i2, i8);
        this.vAh.addCircle(this.ea / 2.0f, this.zPa / 2.0f, f4, Path.Direction.CCW);
        canvas.drawPath(this.vAh, this.oeT);
    }

    private void IlO(Canvas canvas, int i2, int i8, RectF rectF, float[] fArr) {
        IlO(i2, i8);
        this.vAh.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.vAh, this.oeT);
    }

    private void IlO(int i2, int i8) {
        this.vAh.reset();
        this.oeT.setStrokeWidth(i2);
        this.oeT.setColor(i8);
        this.oeT.setStyle(Paint.Style.STROKE);
    }

    private void IlO() {
        if (this.MY) {
            return;
        }
        RectF rectF = this.AXM;
        int i2 = this.tV;
        rectF.set(i2 / 2.0f, i2 / 2.0f, this.ea - (i2 / 2.0f), this.zPa - (i2 / 2.0f));
    }

    private void IlO(boolean z2) {
        if (z2) {
            this.lEW = 0;
        }
        EO();
        IlO();
        invalidate();
    }
}
