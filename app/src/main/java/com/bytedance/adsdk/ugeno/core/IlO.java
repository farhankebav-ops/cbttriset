package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private long Cc;
    private List<C0033IlO> EO;
    private String IlO;
    private float MY;
    private long tV;
    private String vCE;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.core.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0033IlO {
        private float Bc;
        private String Cc;
        private String DmF;
        private String EO;
        private long IlO;
        private float MY;
        private String NV;
        private float[] lEW;
        private long tV;
        private float vCE;

        public float Bc() {
            return this.Bc;
        }

        public String Cc() {
            return this.Cc;
        }

        public String DmF() {
            return this.DmF;
        }

        public String EO() {
            return this.EO;
        }

        public long IlO() {
            return this.IlO;
        }

        public float MY() {
            return this.MY;
        }

        public String NV() {
            return this.NV;
        }

        public float[] lEW() {
            return this.lEW;
        }

        public long tV() {
            return this.tV;
        }

        public float vCE() {
            return this.vCE;
        }

        public void EO(float f4) {
            this.Bc = f4;
        }

        public void IlO(long j) {
            this.IlO = j;
        }

        public void MY(long j) {
            this.tV = j;
        }

        public void tV(String str) {
            this.DmF = str;
        }

        public void EO(String str) {
            this.NV = str;
        }

        public void IlO(float f4) {
            this.MY = f4;
        }

        public void MY(String str) {
            this.Cc = str;
        }

        public void IlO(String str) {
            this.EO = str;
        }

        public void MY(float f4) {
            this.vCE = f4;
        }

        public void IlO(float[] fArr) {
            this.lEW = fArr;
        }

        public static C0033IlO IlO(JSONObject jSONObject, com.bytedance.adsdk.ugeno.MY.EO eo) {
            if (jSONObject == null) {
                return null;
            }
            C0033IlO c0033IlO = new C0033IlO();
            c0033IlO.IlO(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0033IlO.IlO(-1.0f);
            } else {
                try {
                    c0033IlO.IlO(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0033IlO.IlO(0.0f);
                }
            }
            c0033IlO.IlO(jSONObject.optString("loopMode"));
            c0033IlO.MY(jSONObject.optString("type"));
            if (TextUtils.equals(c0033IlO.Cc(), "ripple")) {
                c0033IlO.EO(jSONObject.optString("rippleColor"));
            }
            View viewEV = eo.EV();
            Context context = viewEV != null ? viewEV.getContext() : null;
            if (TextUtils.equals(c0033IlO.Cc(), "backgroundColor")) {
                String strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObject.optString("valueTo"), eo.rp());
                int iIlO = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(jSONObject.optString("valueFrom"));
                int iIlO2 = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(strIlO);
                c0033IlO.MY(iIlO);
                c0033IlO.EO(iIlO2);
            } else if ((TextUtils.equals(c0033IlO.Cc(), "translateX") || TextUtils.equals(c0033IlO.Cc(), "translateY")) && context != null) {
                try {
                    float fIlO = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(context, (float) jSONObject.optDouble("valueFrom"));
                    float fIlO2 = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(context, (float) jSONObject.optDouble("valueTo"));
                    c0033IlO.MY(fIlO);
                    c0033IlO.EO(fIlO2);
                } catch (Exception unused2) {
                    Log.e("animation", "animation ");
                }
            } else {
                c0033IlO.MY((float) jSONObject.optDouble("valueFrom"));
                c0033IlO.EO((float) jSONObject.optDouble("valueTo"));
            }
            c0033IlO.tV(jSONObject.optString("interpolator"));
            String strIlO2 = com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObject.optString("startDelay"), eo.rp());
            Log.d("TAG", "createAnimationModel: ");
            c0033IlO.MY(com.bytedance.adsdk.ugeno.Bc.EO.IlO(strIlO2, 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i2 = 0;
                if ((TextUtils.equals(c0033IlO.Cc(), "translateX") || TextUtils.equals(c0033IlO.Cc(), "translateY")) && context != null) {
                    while (i2 < jSONArrayOptJSONArray.length()) {
                        fArr[i2] = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(context, (float) IlO.IlO(jSONArrayOptJSONArray.optString(i2), eo.rp()));
                        i2++;
                    }
                } else {
                    while (i2 < jSONArrayOptJSONArray.length()) {
                        fArr[i2] = (float) IlO.IlO(jSONArrayOptJSONArray.optString(i2), eo.rp());
                        i2++;
                    }
                }
                c0033IlO.IlO(fArr);
            }
            return c0033IlO;
        }
    }

    public long Cc() {
        return this.Cc;
    }

    public List<C0033IlO> EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public float MY() {
        return this.MY;
    }

    public long tV() {
        return this.tV;
    }

    public String vCE() {
        return this.vCE;
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void MY(long j) {
        this.Cc = j;
    }

    public void IlO(float f4) {
        this.MY = f4;
    }

    public void MY(String str) {
        this.vCE = str;
    }

    public void IlO(List<C0033IlO> list) {
        this.EO = list;
    }

    public void IlO(long j) {
        this.tV = j;
    }

    public static IlO IlO(String str, com.bytedance.adsdk.ugeno.MY.EO eo) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return IlO(new JSONObject(str), eo);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static IlO IlO(JSONObject jSONObject, com.bytedance.adsdk.ugeno.MY.EO eo) {
        return IlO(jSONObject, null, eo);
    }

    public static IlO IlO(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.MY.EO eo) {
        if (jSONObject == null) {
            return null;
        }
        IlO ilO = new IlO();
        ilO.IlO(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            ilO.IlO(-1.0f);
        } else {
            try {
                ilO.IlO(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                ilO.IlO(0.0f);
            }
        }
        ilO.IlO(jSONObject.optLong("duration", 0L));
        ilO.MY(com.bytedance.adsdk.ugeno.Bc.EO.IlO(com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObject.optString("startDelay"), eo.rp()), 0L));
        ilO.MY(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.Bc.MY.IlO(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0033IlO.IlO(jSONObjectOptJSONObject, eo));
            }
            ilO.IlO(arrayList);
        }
        return ilO;
    }

    public static double IlO(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.Bc.EO.IlO(com.bytedance.adsdk.ugeno.EO.MY.IlO((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
