package com.bytedance.adsdk.ugeno.IlO.IlO;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends IlO {
    private Paint Bc;
    private float Cc;
    private PorterDuffXfermode DmF;
    private String EO;
    private Matrix EV;
    private LinearGradient NV;
    private Paint lEW;
    private float tV;
    private View vCE;

    public EO(com.bytedance.adsdk.ugeno.MY.EO eo, JSONObject jSONObject) {
        super(eo, jSONObject);
        this.vCE = this.MY.EV();
        Paint paint = new Paint();
        this.Bc = paint;
        paint.setAntiAlias(true);
        this.vCE.setLayerType(2, null);
        this.DmF = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.lEW = new Paint();
        this.EV = new Matrix();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void EO(Canvas canvas) {
        try {
            if (this.MY.uvo() > 0.0f) {
                int iUvo = (int) (this.tV * this.MY.uvo());
                int iUvo2 = (int) (this.Cc * this.MY.uvo());
                this.Bc.setXfermode(this.DmF);
                String str = this.EO;
                switch (str.hashCode()) {
                    case -1383228885:
                        if (str.equals("bottom")) {
                            float f4 = iUvo2;
                            canvas.drawRect(0.0f, f4, this.tV, this.Cc, this.Bc);
                            this.EV.setTranslate(0.0f, f4);
                            this.NV.setLocalMatrix(this.EV);
                            this.lEW.setShader(this.NV);
                            if (this.MY.uvo() <= 1.0f && this.MY.uvo() > 0.9f) {
                                this.lEW.setAlpha((int) (255.0f - (this.MY.uvo() * 255.0f)));
                            }
                            canvas.drawRect(0.0f, 0.0f, this.tV, f4, this.lEW);
                        }
                        break;
                    case 115029:
                        if (str.equals("top")) {
                            float f8 = iUvo2;
                            canvas.drawRect(0.0f, 0.0f, this.tV, this.Cc - f8, this.Bc);
                            this.EV.setTranslate(0.0f, this.Cc - f8);
                            this.NV.setLocalMatrix(this.EV);
                            this.lEW.setShader(this.NV);
                            if (this.MY.uvo() <= 1.0f && this.MY.uvo() > 0.9f) {
                                this.lEW.setAlpha((int) (255.0f - (this.MY.uvo() * 255.0f)));
                            }
                            float f9 = this.tV;
                            float f10 = this.Cc;
                            canvas.drawRect(f9, f10, 0.0f, f10 - f8, this.lEW);
                        }
                        break;
                    case 3317767:
                        if (str.equals("left")) {
                            float f11 = iUvo;
                            canvas.drawRect(0.0f, 0.0f, this.tV - f11, this.Cc, this.Bc);
                            this.EV.setTranslate(this.tV - f11, 0.0f);
                            this.NV.setLocalMatrix(this.EV);
                            this.lEW.setShader(this.NV);
                            if (this.MY.uvo() <= 1.0f && this.MY.uvo() > 0.9f) {
                                this.lEW.setAlpha((int) (255.0f - (this.MY.uvo() * 255.0f)));
                            }
                            float f12 = this.tV;
                            canvas.drawRect(f12, this.Cc, f12 - f11, 0.0f, this.lEW);
                        }
                        break;
                    case 108511772:
                        if (str.equals("right")) {
                            float f13 = iUvo;
                            canvas.drawRect(f13, 0.0f, this.tV, this.Cc, this.Bc);
                            this.EV.setTranslate(f13, this.Cc);
                            this.NV.setLocalMatrix(this.EV);
                            this.lEW.setShader(this.NV);
                            if (this.MY.uvo() <= 1.0f && this.MY.uvo() > 0.9f) {
                                this.lEW.setAlpha((int) (255.0f - (this.MY.uvo() * 255.0f)));
                            }
                            canvas.drawRect(0.0f, 0.0f, f13, this.Cc, this.lEW);
                        }
                        break;
                }
            }
        } catch (Throwable th) {
            Log.e("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void IlO(Canvas canvas) {
        EO(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void MY() {
        this.EO = this.IlO.optString("direction", "left");
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void IlO(int i2, int i8) {
        this.tV = i2;
        this.Cc = i8;
        String str = this.EO;
        str.getClass();
        switch (str) {
            case "bottom":
                this.NV = new LinearGradient(0.0f, -this.Cc, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.NV = new LinearGradient(0.0f, this.Cc, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.NV = new LinearGradient(this.tV, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.NV = new LinearGradient(-this.tV, 0.0f, 0.0f, this.Cc, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void MY(Canvas canvas) {
        EO(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public List<PropertyValuesHolder> EO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.IlO.tV.ALPHA.MY(), 0.0f, 1.0f));
        return arrayList;
    }
}
