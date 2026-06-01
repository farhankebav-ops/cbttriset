package com.bytedance.sdk.component.adexpress.vCE;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends View {
    private boolean Bc;
    private float Cc;
    private List<Integer> DmF;
    private float EO;
    private Paint EV;
    private int IlO;
    private int MY;
    private Paint NV;
    private int bWL;
    private float hp;
    private List<Integer> lEW;
    private float rp;
    private int tV;
    private int vCE;

    public tV(Context context) {
        this(context, null);
    }

    private void EO() {
        Paint paint = new Paint();
        this.NV = paint;
        paint.setAntiAlias(true);
        this.NV.setStrokeWidth(this.bWL);
        this.lEW.add(255);
        this.DmF.add(0);
        Paint paint2 = new Paint();
        this.EV = paint2;
        paint2.setAntiAlias(true);
        this.EV.setColor(Color.parseColor("#0FFFFFFF"));
        this.EV.setStyle(Paint.Style.FILL);
    }

    public void IlO() {
        this.Bc = true;
        invalidate();
    }

    public void MY() {
        this.Bc = false;
        this.DmF.clear();
        this.lEW.clear();
        this.lEW.add(255);
        this.DmF.add(0);
        invalidate();
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.NV.setShader(new LinearGradient(this.rp, 0.0f, this.hp, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i2 = 0;
        while (true) {
            if (i2 >= this.lEW.size()) {
                break;
            }
            Integer num = this.lEW.get(i2);
            this.NV.setAlpha(num.intValue());
            Integer num2 = this.DmF.get(i2);
            if (this.EO + num2.intValue() < this.Cc) {
                canvas.drawCircle(this.rp, this.hp, this.EO + num2.intValue(), this.NV);
            }
            if (num.intValue() > 0 && num2.intValue() < this.Cc) {
                this.lEW.set(i2, Integer.valueOf(num.intValue() - this.vCE > 0 ? num.intValue() - (this.vCE * 3) : 1));
                this.DmF.set(i2, Integer.valueOf(num2.intValue() + this.vCE));
            }
            i2++;
        }
        List<Integer> list = this.DmF;
        if (list.get(list.size() - 1).intValue() >= this.Cc / this.tV) {
            this.lEW.add(255);
            this.DmF.add(0);
        }
        if (this.DmF.size() >= 3) {
            this.DmF.remove(0);
            this.lEW.remove(0);
        }
        this.NV.setAlpha(255);
        this.NV.setColor(this.MY);
        canvas.drawCircle(this.rp, this.hp, this.EO, this.EV);
        if (this.Bc) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i8);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        float f4 = i2 / 2.0f;
        this.rp = f4;
        this.hp = i8 / 2.0f;
        float f8 = f4 - (this.bWL / 2.0f);
        this.Cc = f8;
        this.EO = f8 / 4.0f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            invalidate();
        }
    }

    public void setColor(int i2) {
        this.IlO = i2;
    }

    public void setCoreColor(int i2) {
        this.MY = i2;
    }

    public void setCoreRadius(int i2) {
        this.EO = i2;
    }

    public void setDiffuseSpeed(int i2) {
        this.vCE = i2;
    }

    public void setDiffuseWidth(int i2) {
        this.tV = i2;
    }

    public void setMaxWidth(int i2) {
        this.Cc = i2;
    }

    public tV(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public tV(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.IlO = -1;
        this.MY = SupportMenu.CATEGORY_MASK;
        this.EO = 18.0f;
        this.tV = 3;
        this.Cc = 50.0f;
        this.vCE = 2;
        this.Bc = false;
        this.lEW = new ArrayList();
        this.DmF = new ArrayList();
        this.bWL = 24;
        EO();
    }
}
