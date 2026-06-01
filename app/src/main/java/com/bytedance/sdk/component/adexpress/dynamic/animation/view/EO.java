package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.EV;
import com.bytedance.sdk.component.adexpress.dynamic.tV.Bc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private int Cc;
    Paint IlO;
    private int tV;
    private int vCE;
    Path MY = new Path();
    Path EO = new Path();

    public EO() {
        Paint paint = new Paint();
        this.IlO = paint;
        paint.setAntiAlias(true);
    }

    public void IlO(Canvas canvas, IAnimation iAnimation, View view) {
        int iIntValue;
        String str;
        float[] fArrMY;
        int iIntValue2 = 0;
        if (iAnimation.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO() != null) {
                try {
                    str = (String) view.getTag(2097610712);
                } catch (Exception unused) {
                    str = "";
                }
                try {
                    fArrMY = Bc.MY(str);
                } catch (Exception unused2) {
                    fArrMY = null;
                }
                if (str.startsWith("#")) {
                    this.IlO.setColor(Color.parseColor(str));
                    this.IlO.setAlpha(90);
                } else if (fArrMY != null) {
                    this.IlO.setColor(com.bytedance.sdk.component.adexpress.tV.Bc.IlO((1.0f - iAnimation.getRippleValue()) * fArrMY[3], fArrMY[0] / 256.0f, fArrMY[1] / 256.0f, fArrMY[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            canvas.drawCircle(this.tV, this.Cc, iAnimation.getRippleValue() * Math.min(r2, r5) * 2, this.IlO);
        }
        if (iAnimation.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.MY.reset();
            try {
                iIntValue = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                int shineValue = ((int) (iAnimation.getShineValue() * ((this.Cc * 2) + ((iIntValue * 2) + (this.tV * 4))))) - ((this.Cc * 2) + iIntValue);
                float f4 = shineValue;
                int i2 = this.Cc;
                this.IlO.setShader(new LinearGradient(f4, 0.0f, ((iIntValue + i2) / 2) + shineValue, i2 / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.IlO.setStrokeWidth(this.tV * 2);
                Path path = this.EO;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i8 = shineValue + iIntValue;
                canvas.drawLine(f4, 0.0f, i8 + r2, this.Cc, this.IlO);
            }
        }
        if (iAnimation.getMarqueeValue() != 0.0f) {
            try {
                iIntValue2 = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
            }
            if (iIntValue2 >= 0) {
                this.MY.reset();
                this.MY.moveTo(0.0f, 0.0f);
                this.MY.lineTo(this.tV * 2, 0.0f);
                this.MY.lineTo(this.tV * 2, this.Cc * 2);
                this.MY.lineTo(0.0f, this.Cc * 2);
                this.MY.lineTo(0.0f, 0.0f);
                this.IlO.setShader(new LinearGradient(0.0f, 0.0f, this.tV * 2, this.Cc * 2, new int[]{(int) (iAnimation.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - iAnimation.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.IlO.setColor(SupportMenu.CATEGORY_MASK);
                this.IlO.setStyle(Paint.Style.STROKE);
                this.IlO.setStrokeWidth(iIntValue2);
                canvas.drawPath(this.MY, this.IlO);
            }
        }
    }

    public void IlO(View view, float f4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.vCE * f4);
        view.setTranslationX((r1 - r6) / 2);
        if (view instanceof EV) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i2).setTranslationX((-(this.vCE - layoutParams.width)) / 2);
                i2++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void IlO(View view, int i2, int i8) {
        String str;
        this.tV = i2 / 2;
        this.Cc = i8 / 2;
        if (this.vCE == 0 && view.getLayoutParams().width > 0) {
            this.vCE = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.EO.addRoundRect(new RectF(0.0f, 0.0f, i2, i8), i8 / 2, i8 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.tV * 2);
            view.setPivotY(this.Cc);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.Cc);
        } else {
            view.setPivotX(this.tV);
            view.setPivotY(this.Cc);
        }
    }
}
