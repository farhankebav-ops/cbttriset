package com.bytedance.adsdk.ugeno.tV.tV;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.tV.vCE;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO {
    protected String Bc;
    protected Map<String, String> Cc;
    protected String DmF;
    protected com.bytedance.adsdk.ugeno.tV.vCE EO;
    protected com.bytedance.adsdk.ugeno.tV.EV IlO;
    protected com.bytedance.adsdk.ugeno.MY.EO MY;
    protected Context NV;
    protected String lEW;
    protected vCE.IlO tV;
    protected String vCE;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.tV.tV.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0036IlO {
        public static IlO IlO(Context context, com.bytedance.adsdk.ugeno.MY.EO eo, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.tV.vCE vceIlO;
            vCE.IlO IlO;
            if (eo == null || jSONObject == null || (vceIlO = com.bytedance.adsdk.ugeno.tV.vCE.IlO(jSONObject, jSONObject2)) == null || (IlO = vceIlO.IlO()) == null) {
                return null;
            }
            String strIlO = IlO.IlO();
            if (TextUtils.equals(strIlO, NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM)) {
                MY my = new MY(context);
                my.IlO(eo);
                my.IlO(vceIlO);
                my.IlO();
                return my;
            }
            com.bytedance.adsdk.ugeno.tV.Bc bcIlO = (TextUtils.isEmpty(strIlO) || TextUtils.equals(strIlO, "global")) ? com.bytedance.adsdk.ugeno.tV.NV.IlO(IlO.MY()) : com.bytedance.adsdk.ugeno.tV.NV.IlO(IlO.Cc());
            if (bcIlO == null) {
                return null;
            }
            IlO IlO2 = bcIlO.IlO(context);
            IlO2.IlO(eo);
            IlO2.IlO(vceIlO);
            IlO2.IlO();
            return IlO2;
        }
    }

    public IlO(Context context) {
        this.NV = context;
    }

    public String EO() {
        return this.DmF;
    }

    public void IlO() {
        this.tV = this.EO.IlO();
        com.bytedance.adsdk.ugeno.tV.vCE vce = this.EO;
        if (vce == null) {
            return;
        }
        vCE.IlO IlO = vce.IlO();
        this.tV = IlO;
        if (IlO == null) {
            return;
        }
        this.Cc = IlO.EO();
        this.vCE = this.tV.MY();
        this.Bc = this.tV.IlO();
        this.lEW = this.tV.tV();
        this.DmF = this.tV.Cc();
    }

    public abstract boolean IlO(Object... objArr);

    public String MY() {
        return this.vCE;
    }

    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo) {
        this.MY = eo;
    }

    public void IlO(com.bytedance.adsdk.ugeno.tV.vCE vce) {
        this.EO = vce;
    }

    public void IlO(com.bytedance.adsdk.ugeno.tV.EV ev) {
        this.IlO = ev;
    }
}
