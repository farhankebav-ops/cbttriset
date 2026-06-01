package com.bytedance.sdk.openadsdk.core.EV;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.EV.MY.EO;
import com.bytedance.sdk.openadsdk.core.EV.MY.IlO;
import com.bytedance.sdk.openadsdk.core.EV.MY.MY;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.ironsource.C2318f4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private String AXM;
    private boolean cL;
    private oeT cl;
    private boolean es;
    private final IlO hp;
    private boolean xF;
    private long zPa;
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> IlO = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> MY = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> EO = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> tV = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> Cc = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> vCE = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> Bc = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> lEW = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> DmF = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> NV = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.MY> EV = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.EV.MY.IlO> rp = new ArrayList();
    private final AtomicBoolean bWL = new AtomicBoolean(false);
    private final AtomicBoolean ea = new AtomicBoolean(false);

    public tV(IlO ilO) {
        this.hp = ilO;
    }

    public void Bc(long j) {
        IlO(j, this.lEW, null, new EO.MY(C2318f4.f8523d, this.cl));
    }

    public void Cc(long j) {
        if (this.ea.compareAndSet(false, true)) {
            IlO(j, this.vCE, (com.bytedance.sdk.openadsdk.core.EV.IlO.IlO) null);
        }
    }

    public void DmF(long j) {
        IlO(j, this.NV, (com.bytedance.sdk.openadsdk.core.EV.IlO.IlO) null);
    }

    public void EO(long j) {
        IlO(j, this.tV, (com.bytedance.sdk.openadsdk.core.EV.IlO.IlO) null);
    }

    public void EV(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.DmF.addAll(list);
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.EV.IlO.IlO ilO) {
        IlO(-1L, this.IlO, ilO);
    }

    public void MY(long j) {
        IlO(j, this.EO, (com.bytedance.sdk.openadsdk.core.EV.IlO.IlO) null);
    }

    public void NV(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.IlO.addAll(list);
    }

    public void lEW(long j) {
        IlO(j, this.DmF, (com.bytedance.sdk.openadsdk.core.EV.IlO.IlO) null);
    }

    public void rp(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.NV.addAll(list);
    }

    public void tV(long j) {
        IlO(j, this.Cc, null, new EO.MY("video_progress", this.cl, 1.0f));
    }

    public void vCE(long j) {
        IlO(j, this.Bc, (com.bytedance.sdk.openadsdk.core.EV.IlO.IlO) null);
    }

    private void MY(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            com.bytedance.sdk.openadsdk.tV.EO.MY(this.cl, this.AXM, "vast_play_track", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void Bc(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.lEW.addAll(list);
    }

    public void DmF(List<com.bytedance.sdk.openadsdk.core.EV.MY.IlO> list) {
        this.rp.addAll(list);
        Collections.sort(this.rp);
    }

    public void EO(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.tV.addAll(list);
    }

    public void IlO(long j) {
        if (this.bWL.compareAndSet(false, true)) {
            IlO(j, this.MY, null, new EO.MY("show_impression", this.cl));
        }
    }

    public void lEW(List<com.bytedance.sdk.openadsdk.core.EV.MY.MY> list) {
        this.EV.addAll(list);
        Collections.sort(this.EV);
    }

    public void tV(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.Cc.addAll(list);
    }

    public void vCE(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.Bc.addAll(list);
    }

    private JSONArray EO() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.EV.MY.IlO> it = this.rp.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().IlO());
        }
        return jSONArray;
    }

    public void Cc(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.vCE.addAll(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(long r8, long r10, com.bytedance.sdk.openadsdk.core.EV.vCE r12) {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r7.zPa
            long r0 = r0 - r2
            r2 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto Lf
            goto L88
        Lf:
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 < 0) goto L88
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 <= 0) goto L88
            long r0 = java.lang.System.currentTimeMillis()
            r7.zPa = r0
            float r0 = (float) r8
            float r10 = (float) r10
            float r0 = r0 / r10
            java.util.List r4 = r7.IlO(r8, r0)
            r10 = 1048576000(0x3e800000, float:0.25)
            int r11 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            r1 = 1
            if (r11 < 0) goto L40
            boolean r11 = r7.cL
            if (r11 != 0) goto L40
            java.lang.String r11 = "firstQuartile"
            r7.MY(r11)
            r7.cL = r1
            if (r12 == 0) goto L3e
            r11 = 6
            r7.IlO(r12, r11)
        L3e:
            r0 = r10
            goto L71
        L40:
            r10 = 1056964608(0x3f000000, float:0.5)
            int r11 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r11 < 0) goto L58
            boolean r11 = r7.es
            if (r11 != 0) goto L58
            java.lang.String r11 = "midpoint"
            r7.MY(r11)
            r7.es = r1
            if (r12 == 0) goto L3e
            r11 = 7
            r7.IlO(r12, r11)
            goto L3e
        L58:
            r10 = 1061158912(0x3f400000, float:0.75)
            int r11 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r11 < 0) goto L71
            boolean r11 = r7.xF
            if (r11 != 0) goto L71
            java.lang.String r11 = "thirdQuartile"
            r7.MY(r11)
            r7.xF = r1
            if (r12 == 0) goto L3e
            r11 = 8
            r7.IlO(r12, r11)
            goto L3e
        L71:
            r10 = 1022739087(0x3cf5c28f, float:0.03)
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 >= 0) goto L79
            r0 = 0
        L79:
            com.bytedance.sdk.openadsdk.core.EV.MY.EO$MY r6 = new com.bytedance.sdk.openadsdk.core.EV.MY.EO$MY
            java.lang.String r10 = "video_progress"
            com.bytedance.sdk.openadsdk.core.model.oeT r11 = r7.cl
            r6.<init>(r10, r11, r0)
            r5 = 0
            r1 = r7
            r2 = r8
            r1.IlO(r2, r4, r5, r6)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.EV.tV.IlO(long, long, com.bytedance.sdk.openadsdk.core.EV.vCE):void");
    }

    public void MY(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.EO.addAll(list);
    }

    private JSONArray MY() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.EV.MY.MY> it = this.EV.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().MY());
        }
        return jSONArray;
    }

    private void IlO(final vCE vce, final int i2) {
        com.bytedance.sdk.component.utils.DmF.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.tV.1
            @Override // java.lang.Runnable
            public void run() {
                vCE vce2 = vce;
                if (vce2 != null) {
                    vce2.IlO(i2);
                }
            }
        });
    }

    private void IlO(long j, List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list, com.bytedance.sdk.openadsdk.core.EV.IlO.IlO ilO, EO.MY my) {
        IlO ilO2 = this.hp;
        com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(list, ilO, j, ilO2 != null ? ilO2.Bc() : null, my);
    }

    private void IlO(long j, List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list, com.bytedance.sdk.openadsdk.core.EV.IlO.IlO ilO) {
        IlO(j, list, ilO, null);
    }

    public List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> IlO(long j, float f4) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.EV.size(); i2++) {
            com.bytedance.sdk.openadsdk.core.EV.MY.MY my = this.EV.get(i2);
            if (my.IlO(f4)) {
                arrayList.add(my);
            }
        }
        for (int i8 = 0; i8 < this.rp.size(); i8++) {
            com.bytedance.sdk.openadsdk.core.EV.MY.IlO ilO = this.rp.get(i8);
            if (ilO.IlO(j)) {
                arrayList.add(ilO);
            }
        }
        return arrayList;
    }

    public void IlO(List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) {
        this.MY.addAll(list);
    }

    public JSONObject IlO() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.IlO));
        jSONObject.put("impressionTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.MY));
        jSONObject.put("pauseTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.EO));
        jSONObject.put("resumeTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.tV));
        jSONObject.put("completeTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.Cc));
        jSONObject.put("closeTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.vCE));
        jSONObject.put("skipTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.Bc));
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.lEW));
        jSONObject.put("muteTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.DmF));
        jSONObject.put("unMuteTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.NV));
        jSONObject.put("fractionalTrackers", MY());
        jSONObject.put("absoluteTrackers", EO());
        return jSONObject;
    }

    public void IlO(JSONObject jSONObject) {
        NV(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("errorTrackers")));
        IlO(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("impressionTrackers")));
        MY(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("pauseTrackers"), true));
        EO(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("resumeTrackers"), true));
        tV(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("completeTrackers")));
        Cc(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("closeTrackers")));
        vCE(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("skipTrackers")));
        Bc(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("clickTrackers")));
        EV(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("muteTrackers"), true));
        rp(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(jSONObject.optJSONArray("unMuteTrackers"), true));
        lEW(com.bytedance.sdk.openadsdk.core.EV.MY.EO.MY(jSONObject.optJSONArray("fractionalTrackers")));
        DmF(com.bytedance.sdk.openadsdk.core.EV.MY.EO.EO(jSONObject.optJSONArray("absoluteTrackers")));
    }

    public void IlO(oeT oet) {
        this.cl = oet;
    }

    public void IlO(String str) {
        this.AXM = str;
    }

    public void IlO(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        DmF(Collections.singletonList(new IlO.C0086IlO(str, j).IlO()));
    }

    public void IlO(String str, float f4) {
        if (TextUtils.isEmpty(str) || f4 < 0.0f) {
            return;
        }
        lEW(Collections.singletonList(new MY.IlO(str, f4).IlO()));
    }

    public void IlO(tV tVVar) {
        NV(tVVar.IlO);
        IlO(tVVar.MY);
        MY(tVVar.EO);
        EO(tVVar.tV);
        tV(tVVar.Cc);
        Cc(tVVar.vCE);
        vCE(tVVar.Bc);
        Bc(tVVar.lEW);
        EV(tVVar.DmF);
        rp(tVVar.NV);
        lEW(tVVar.EV);
        DmF(tVVar.rp);
    }
}
