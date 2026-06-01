package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends View {
    private static final int[] IlO = {Color.parseColor("#1AFFFFFF"), Color.parseColor("#4DFFFFFF"), Color.parseColor("#99FFFFFF")};
    private int Bc;
    private final Paint Cc;
    private int DmF;
    private final RectF EO;
    private final RectF MY;
    private int lEW;
    private final ArrayList<IlO> tV;
    private final Paint vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO {
        float EO;
        public Paint IlO;
        public float MY;
        float tV;

        public IlO(Paint paint, float f4, float f8, float f9) {
            this.IlO = paint;
            this.MY = f4;
            this.EO = f8;
            this.tV = f9;
        }
    }

    public lEW(Context context) {
        super(context);
        this.MY = new RectF();
        this.EO = new RectF();
        this.tV = new ArrayList<>();
        this.vCE = new Paint();
        Paint paint = new Paint();
        this.Cc = paint;
        paint.setColor(Color.parseColor("#D9D9D9"));
    }

    private void IlO() {
        if (this.Bc <= 0) {
            return;
        }
        int width = (int) (((this.lEW * 1.0f) / 100.0f) * getWidth());
        this.EO.right = Math.max(this.DmF, width);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.MY;
        int i2 = this.Bc;
        canvas.drawRoundRect(rectF, i2, i2, this.Cc);
        RectF rectF2 = this.EO;
        int i8 = this.Bc;
        canvas.drawRoundRect(rectF2, i8, i8, this.vCE);
        int iSave = canvas.save();
        canvas.translate(this.EO.right - this.DmF, 0.0f);
        ArrayList<IlO> arrayList = this.tV;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            IlO ilO = arrayList.get(i9);
            i9++;
            IlO ilO2 = ilO;
            canvas.drawCircle(ilO2.EO, ilO2.tV, ilO2.MY, ilO2.IlO);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        int i11 = i8 / 2;
        this.Bc = i11;
        this.DmF = i11 * 5;
        float f4 = i2;
        float f8 = i8;
        this.MY.set(0.0f, 0.0f, f4, f8);
        this.EO.set(0.0f, 0.0f, 0.0f, f8);
        this.vCE.setShader(new LinearGradient(0.0f, 0.0f, f4, f8, new int[]{Color.parseColor("#90C0FF"), Color.parseColor("#196BE4")}, (float[]) null, Shader.TileMode.CLAMP));
        this.tV.clear();
        float f9 = this.Bc / 4.0f;
        for (int i12 : IlO) {
            Paint paint = new Paint();
            paint.setColor(i12);
            this.tV.add(new IlO(paint, this.Bc / 2.0f, f9, f8 / 2.0f));
            f9 += (this.Bc / 2.0f) * 3.0f;
        }
        IlO();
    }

    public void setProgress(int i2) {
        int i8 = this.lEW;
        if (i8 == i2) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 100) {
            i2 = 100;
        }
        if (i8 == i2) {
            return;
        }
        this.lEW = i2;
        IlO();
    }
}
