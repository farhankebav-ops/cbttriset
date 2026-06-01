package com.bytedance.adsdk.ugeno.IlO.IlO;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO {
    private static final int Bc = Color.parseColor("#7ed321");
    private int Cc;
    private int EO;
    private int tV;
    private Paint vCE;

    public MY(com.bytedance.adsdk.ugeno.MY.EO eo, JSONObject jSONObject) {
        super(eo, jSONObject);
        Paint paint = new Paint();
        this.vCE = paint;
        paint.setAntiAlias(true);
    }

    private void EO(Canvas canvas) {
        try {
            if (this.MY.HSR() > 0.0f) {
                this.vCE.setColor(this.EO);
                this.vCE.setAlpha((int) ((1.0f - this.MY.HSR()) * 255.0f));
                ((ViewGroup) this.MY.EV().getParent()).setClipChildren(true);
                canvas.drawCircle(this.tV, this.Cc, Math.min(r0, r2) * 2 * this.MY.HSR(), this.vCE);
            }
        } catch (Throwable th) {
            Log.d("BaseEffectWrapper", "ripple animation error " + th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void IlO(Canvas canvas) {
        EO(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void MY() {
        this.EO = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(this.IlO.optString("backgroundColor"), Bc);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.IlO.IlO
    public void IlO(int i2, int i8) {
        this.tV = i2 / 2;
        this.Cc = i8 / 2;
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
