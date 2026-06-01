package com.bytedance.sdk.openadsdk.core.NV.Cc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.EV;
import com.bytedance.sdk.openadsdk.core.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private final Context Bc;
    private com.bytedance.adsdk.ugeno.MY.EO Cc;
    private final String DmF;
    private com.bytedance.adsdk.ugeno.MY.EO EO;
    private JSONObject EV;
    private com.bytedance.sdk.openadsdk.core.widget.Cc NV;
    private boolean bWL;
    private boolean ea;
    private boolean hp;
    private final oeT lEW;
    private final JSONObject rp;
    private com.bytedance.adsdk.ugeno.MY.EO tV;
    private JSONArray zPa;
    private int IlO = -1;
    private int MY = -1;
    private final String vCE = "UGenSwiperEvent";

    public tV(Context context, oeT oet, String str, JSONObject jSONObject) {
        this.Bc = context;
        this.lEW = oet;
        this.DmF = str;
        this.rp = jSONObject;
    }

    public JSONObject tV() {
        return this.EV;
    }

    public void EO() {
        int i2;
        com.bytedance.adsdk.ugeno.MY.EO eo = this.Cc;
        if (!(eo instanceof com.bytedance.adsdk.ugeno.EO) || (i2 = this.IlO) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.EO) eo).IlO(i2 + 1);
    }

    public void MY() {
        int i2;
        com.bytedance.adsdk.ugeno.MY.EO eo = this.Cc;
        if (!(eo instanceof com.bytedance.adsdk.ugeno.EO) || (i2 = this.IlO) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.EO) eo).IlO(i2 - 1);
    }

    public void IlO(com.bytedance.adsdk.ugeno.MY.EO<View> eo) {
        com.bytedance.adsdk.ugeno.MY.EO<T> EO = eo.EO("swiperLayout");
        this.Cc = EO;
        if (EO instanceof com.bytedance.adsdk.ugeno.EO) {
            this.zPa = this.rp.optJSONArray("dpa_data");
            this.EO = eo.EO("swiperLeftArrow");
            this.tV = eo.EO("swiperRightArrow");
            ((com.bytedance.adsdk.ugeno.EO) this.Cc).IlO(new com.bytedance.adsdk.ugeno.vCE.EO() { // from class: com.bytedance.sdk.openadsdk.core.NV.Cc.tV.1
                @Override // com.bytedance.adsdk.ugeno.vCE.EO
                public void IlO(boolean z2, int i2) {
                }

                @Override // com.bytedance.adsdk.ugeno.vCE.EO
                public void IlO(boolean z2, int i2, float f4, int i8) {
                }

                @Override // com.bytedance.adsdk.ugeno.vCE.EO
                public void IlO(boolean z2, int i2, int i8, boolean z7, boolean z8) {
                    tV.this.MY = i2;
                    tV.this.IlO = i8;
                    tV.this.hp = z2;
                    tV.this.bWL = z7;
                    tV.this.ea = z8;
                    tV.this.IlO(z2, z7, z8);
                    tV.this.IlO(i2);
                }
            });
        }
    }

    public void IlO() {
        IlO(this.hp, this.bWL, this.ea);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(boolean z2, boolean z7, boolean z8) {
        com.bytedance.adsdk.ugeno.MY.EO eo = this.EO;
        if (eo == null || this.tV == null) {
            return;
        }
        View viewEV = eo.EV();
        View viewEV2 = this.tV.EV();
        JSONArray jSONArray = this.zPa;
        if (jSONArray != null && jSONArray.length() == 1) {
            viewEV.setVisibility(8);
            viewEV2.setVisibility(8);
            return;
        }
        if (z2) {
            return;
        }
        if (z7) {
            if (viewEV instanceof TextView) {
                IlO((TextView) viewEV, 90);
            }
            if (viewEV2 instanceof TextView) {
                IlO((TextView) viewEV2, 255);
                return;
            }
            return;
        }
        if (z8) {
            if (viewEV instanceof TextView) {
                IlO((TextView) viewEV, 255);
            }
            if (viewEV2 instanceof TextView) {
                IlO((TextView) viewEV2, 90);
                return;
            }
            return;
        }
        if (viewEV instanceof TextView) {
            IlO((TextView) viewEV, 255);
        }
        if (viewEV2 instanceof TextView) {
            IlO((TextView) viewEV2, 255);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FirebaseAnalytics.Param.INDEX, i2);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.MY(this.lEW, this.DmF, "carousel_show", jSONObject);
    }

    private void IlO(TextView textView, int i2) {
        int currentTextColor = textView.getCurrentTextColor();
        textView.setTextColor(Color.argb(i2, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.widget.Cc cc) {
        this.NV = cc;
    }

    public boolean IlO(EV ev) {
        JSONObject jSONObjectOptJSONObject;
        this.EV = null;
        int i2 = this.MY;
        if (i2 != -1 && i2 != 0) {
            try {
                JSONObject jSONObjectEO = ev.EO();
                if (jSONObjectEO != null && (jSONObjectOptJSONObject = jSONObjectEO.optJSONObject("related_dpa_click")) != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enableOpenExternalUrl");
                    int iOptInt = jSONObjectOptJSONObject.optInt("landingStyle");
                    if (zOptBoolean && iOptInt != -1) {
                        if (this.zPa != null) {
                            String strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObjectOptJSONObject.optString("url"), this.zPa.optJSONObject(this.MY));
                            String strIlO2 = com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObjectOptJSONObject.optString("fallback_url"), this.zPa.optJSONObject(this.MY));
                            jSONObjectOptJSONObject.put("url", strIlO);
                            jSONObjectOptJSONObject.put("fallback_url", strIlO2);
                            IlO(jSONObjectOptJSONObject, this.zPa.optJSONObject(this.MY));
                        }
                        IlO(jSONObjectOptJSONObject, ev.IlO().EV());
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("UGenSwiperEvent", th.getMessage());
            }
        }
        return false;
    }

    private void IlO(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
        this.EV = jSONObjectOptJSONObject;
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    this.EV.putOpt(next, com.bytedance.adsdk.ugeno.EO.MY.IlO((String) this.EV.opt(next), jSONObject2));
                } catch (Throwable unused) {
                }
            }
            try {
                jSONObject.putOpt("clickInfo", this.EV);
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean IlO(int r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            r0 = 0
            r1 = 1
            if (r4 == r1) goto L1f
            r2 = 2
            if (r4 == r2) goto Lb
            r6 = 3
            if (r4 == r6) goto L1f
            goto L26
        Lb:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 == 0) goto L18
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 == 0) goto L18
            return r0
        L18:
            boolean r4 = com.bytedance.sdk.component.utils.xF.IlO(r6)
            if (r4 != 0) goto L26
            return r0
        L1f:
            boolean r4 = com.bytedance.sdk.component.utils.xF.IlO(r5)
            if (r4 != 0) goto L26
            return r0
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.NV.Cc.tV.IlO(int, java.lang.String, java.lang.String):boolean");
    }

    private void IlO(JSONObject jSONObject, View view) {
        if (IlO(jSONObject.optInt("landingStyle"), jSONObject.optString("url"), jSONObject.optString("fallback_url"))) {
            es.IlO(IlO(view), this.Bc instanceof Activity, jSONObject, this.lEW, this.DmF, zLG.IlO(this.DmF), null, this.NV);
        }
    }

    private Context IlO(View view) {
        Activity activityIlO = view != null ? com.bytedance.sdk.component.utils.MY.IlO(view) : null;
        return activityIlO == null ? this.Bc : activityIlO;
    }
}
