package com.bytedance.adsdk.ugeno.IlO.IlO;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Bc.IlO;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends IlO {
    private static final float bWL;
    private static final float cl;
    private static final float ea;
    private static final float zPa;
    private int Bc;
    private Path Cc;
    private float DmF;
    private int EO;
    private int EV;
    private int NV;
    private float cL;
    private Path hp;
    private int lEW;
    private boolean rp;
    private Paint tV;
    private IlO.C0026IlO vCE;

    static {
        float radians = (float) Math.toRadians(30.0d);
        bWL = radians;
        ea = (float) Math.tan(radians);
        zPa = (float) Math.cos(radians);
        cl = (float) Math.sin(radians);
    }

    public tV(com.bytedance.adsdk.ugeno.MY.EO eo, JSONObject jSONObject) {
        super(eo, jSONObject);
        this.rp = true;
        Paint paint = new Paint();
        this.tV = paint;
        paint.setAntiAlias(true);
        this.Cc = new Path();
        this.DmF = this.MY.oeT();
        this.hp = new Path();
    }

    private void EO(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.MY.AK() > 0.0f) {
                int i2 = this.NV;
                float f4 = ea;
                float fAK = ((i2 * f4) + i2) * this.MY.AK();
                this.hp.reset();
                this.hp.moveTo(fAK, 0.0f);
                int i8 = this.EV;
                float f8 = fAK - (i8 * f4);
                this.hp.lineTo(f8, i8);
                this.hp.lineTo(f8 + this.EO, this.EV);
                this.hp.lineTo(this.EO + fAK, 0.0f);
                this.hp.close();
                float f9 = this.cL;
                float f10 = zPa * f9;
                float f11 = f9 * cl;
                if (!this.rp || this.vCE == null) {
                    int i9 = this.lEW;
                    linearGradient = new LinearGradient(fAK, 0.0f, fAK + f10, f11, new int[]{i9, this.Bc, i9}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(fAK, 0.0f, fAK + f10, f11, this.vCE.MY, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.tV.setShader(linearGradient);
                Path path = this.Cc;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.hp, this.tV);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void IlO(Canvas canvas) {
        EO(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void MY() {
        this.EO = (int) lEW.IlO(this.MY.EV().getContext(), this.IlO.optInt("shineWidth", 30));
        String strOptString = this.IlO.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith("linear")) {
            this.vCE = com.bytedance.adsdk.ugeno.Bc.IlO.MY(str);
        } else {
            int iIlO = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str);
            this.Bc = iIlO;
            this.lEW = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(iIlO, 32);
            this.rp = false;
        }
        this.cL = zPa * this.EO;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void IlO(int i2, int i8) {
        this.NV = i2;
        this.EV = i8;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i2, i8);
            Path path = this.Cc;
            float f4 = this.DmF;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void MY(Canvas canvas) {
        EO(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public List<PropertyValuesHolder> EO() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(tV(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
