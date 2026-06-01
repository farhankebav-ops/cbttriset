package com.bytedance.adsdk.ugeno.IlO.IlO;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends IlO {
    private String Bc;
    private Paint Cc;
    private boolean DmF;
    private float EO;
    private Path EV;
    private Path NV;
    private PorterDuffXfermode hp;
    private boolean lEW;
    private Path rp;
    private float tV;
    private float vCE;

    public Cc(com.bytedance.adsdk.ugeno.MY.EO eo, JSONObject jSONObject) {
        super(eo, jSONObject);
        this.lEW = true;
        this.DmF = true;
        Paint paint = new Paint();
        this.Cc = paint;
        paint.setAntiAlias(true);
        this.MY.EV().setLayerType(2, null);
        this.hp = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.NV = new Path();
        this.EV = new Path();
        this.rp = new Path();
    }

    private void EO(Canvas canvas) {
        int iQuf;
        int iQuf2;
        if (this.MY.quf() > 0.0f) {
            iQuf = (int) (this.MY.quf() * this.EO);
            iQuf2 = (int) (this.MY.quf() * this.tV);
            this.Cc.setXfermode(this.hp);
            String str = this.Bc;
            str.getClass();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, iQuf2, this.EO, this.tV, this.Cc);
                    break;
                case "center":
                    this.NV.reset();
                    this.EV.reset();
                    this.rp.reset();
                    Path.Direction direction = Path.Direction.CW;
                    this.NV.addCircle(this.EO / 2.0f, this.tV / 2.0f, iQuf, direction);
                    Path path = this.EV;
                    float f4 = this.EO;
                    path.addRect(f4 / 2.0f, 0.0f, f4, this.tV, direction);
                    Path path2 = this.EV;
                    Path path3 = this.NV;
                    Path.Op op = Path.Op.DIFFERENCE;
                    path2.op(path3, op);
                    this.rp.addRect(0.0f, 0.0f, this.EO / 2.0f, this.tV, direction);
                    this.rp.op(this.NV, op);
                    canvas.drawPath(this.EV, this.Cc);
                    canvas.drawPath(this.rp, this.Cc);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.EO, this.tV - iQuf2, this.Cc);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.EO - iQuf, this.tV, this.Cc);
                    break;
                case "right":
                    canvas.drawRect(iQuf, 0.0f, this.EO, this.tV, this.Cc);
                    break;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void IlO(Canvas canvas) {
        EO(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void MY() {
        this.vCE = (float) this.IlO.optDouble("start", 0.0d);
        this.Bc = this.IlO.optString("direction", "center");
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void IlO(int i2, int i8) {
        if (i2 > 0 && this.lEW) {
            this.EO = i2;
            this.lEW = false;
        }
        if (i8 <= 0 || !this.DmF) {
            return;
        }
        this.tV = i8;
        this.DmF = false;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void MY(Canvas canvas) {
        EO(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public List<PropertyValuesHolder> EO() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(tV(), this.vCE, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
