package com.bytedance.adsdk.ugeno.IlO.IlO;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO {
    private String EO;
    protected JSONObject IlO;
    protected com.bytedance.adsdk.ugeno.MY.EO MY;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.IlO.IlO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0031IlO {
        public static IlO IlO(com.bytedance.adsdk.ugeno.MY.EO eo, JSONObject jSONObject) {
            if (eo == null || jSONObject == null) {
                return null;
            }
            String strOptString = jSONObject.optString("type");
            strOptString.getClass();
            switch (strOptString) {
                case "stretch":
                    return new Cc(eo, jSONObject);
                case "ripple":
                    return new MY(eo, jSONObject);
                case "rub_in":
                    return new EO(eo, jSONObject);
                case "shine":
                    return new tV(eo, jSONObject);
                default:
                    return null;
            }
        }
    }

    public IlO(com.bytedance.adsdk.ugeno.MY.EO eo, JSONObject jSONObject) {
        this.IlO = jSONObject;
        this.MY = eo;
        IlO();
    }

    public abstract List<PropertyValuesHolder> EO();

    public void IlO() {
        this.EO = this.IlO.optString("type");
        MY();
    }

    public abstract void IlO(int i2, int i8);

    public abstract void IlO(Canvas canvas);

    public abstract void MY();

    public abstract void MY(Canvas canvas);

    public String tV() {
        return this.EO;
    }
}
