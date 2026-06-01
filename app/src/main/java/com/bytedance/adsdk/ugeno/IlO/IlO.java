package com.bytedance.adsdk.ugeno.IlO;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.IlO.IlO.IlO;
import com.bytedance.adsdk.ugeno.IlO.MY;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private int Cc;
    private ValueAnimator EO;
    private com.bytedance.adsdk.ugeno.MY.EO IlO;
    private MY MY;
    private Context tV;
    private com.bytedance.adsdk.ugeno.IlO.IlO.IlO vCE;

    public IlO(Context context, com.bytedance.adsdk.ugeno.MY.EO eo, MY my) {
        this.IlO = eo;
        this.MY = my;
        this.tV = context;
    }

    public ValueAnimator EO() {
        String key;
        com.bytedance.adsdk.ugeno.IlO.MY.IlO eo;
        MY my = this.MY;
        if (my == null || this.IlO == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> mapMY = my.MY();
        ArrayList arrayList = new ArrayList();
        if (mapMY != null && !mapMY.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : mapMY.entrySet()) {
                if (entry != null) {
                    key = entry.getKey();
                    String strEO = tV.IlO(key).EO();
                    strEO.getClass();
                    switch (strEO) {
                        case "int":
                            eo = new com.bytedance.adsdk.ugeno.IlO.MY.EO(this.tV, this.IlO, key, entry.getValue());
                            break;
                        case "float":
                            eo = new com.bytedance.adsdk.ugeno.IlO.MY.MY(this.tV, this.IlO, key, entry.getValue());
                            break;
                        case "point":
                            eo = new com.bytedance.adsdk.ugeno.IlO.MY.tV(this.tV, this.IlO, key, entry.getValue());
                            break;
                        default:
                            eo = null;
                            break;
                    }
                    if (eo != null) {
                        arrayList.addAll(eo.Cc());
                    }
                }
            }
        }
        JSONObject jSONObjectIlO = this.MY.IlO();
        if (jSONObjectIlO != null) {
            com.bytedance.adsdk.ugeno.IlO.IlO.IlO IlO = IlO.C0031IlO.IlO(this.IlO, jSONObjectIlO);
            this.vCE = IlO;
            if (IlO != null) {
                arrayList.addAll(IlO.EO());
            }
        }
        final View viewEV = this.IlO.EV();
        if (viewEV == null) {
            return null;
        }
        final MY.IlO ilOBc = this.MY.Bc();
        if (ilOBc != null) {
            viewEV.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.IlO.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = viewEV.getWidth();
                    int height = viewEV.getHeight();
                    viewEV.setPivotX(EO.IlO(ilOBc.IlO, width));
                    viewEV.setPivotY(EO.IlO(ilOBc.MY, height));
                }
            });
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewEV, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.Cc = EO.IlO(this.MY.tV());
        objectAnimatorOfPropertyValuesHolder.setDuration(this.MY.EO());
        int i2 = this.Cc;
        if (i2 != -2) {
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(i2);
        }
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.MY.vCE());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(EO.IlO(this.MY.Cc()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(EO.MY(this.MY.lEW()));
        this.EO = objectAnimatorOfPropertyValuesHolder;
        return objectAnimatorOfPropertyValuesHolder;
    }

    public void IlO() {
        ValueAnimator valueAnimator = this.EO;
        if (valueAnimator == null || this.Cc == -2) {
            return;
        }
        valueAnimator.start();
    }

    public void MY() {
        ValueAnimator valueAnimator = this.EO;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void MY(Canvas canvas) {
        com.bytedance.adsdk.ugeno.IlO.IlO.IlO ilO = this.vCE;
        if (ilO != null) {
            ilO.MY(canvas);
        }
    }

    public void IlO(Canvas canvas) {
        com.bytedance.adsdk.ugeno.IlO.IlO.IlO ilO = this.vCE;
        if (ilO != null) {
            ilO.IlO(canvas);
        }
    }

    public void IlO(int i2, int i8) {
        com.bytedance.adsdk.ugeno.IlO.IlO.IlO ilO = this.vCE;
        if (ilO != null) {
            ilO.IlO(i2, i8);
        }
    }
}
