package com.bytedance.sdk.openadsdk.core.DmF;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.rp;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.multipro.tV.tV;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.pgl.ssdk.ces.out.PglSSCallBack;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class IlO {
    private PglSSManager IlO;
    private volatile boolean MY;
    private volatile boolean EO = true;
    private volatile boolean tV = false;

    public IlO() {
        IlO();
    }

    private void DmF() {
        if (this.IlO == null) {
            this.IlO = PglSSManager.getInstance();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Class NV() {
        try {
            this.EO = true;
            return PglSSManager.class;
        } catch (Throwable unused) {
            this.EO = false;
            return PglSSManager.class;
        }
    }

    private boolean lEW() {
        if (!this.MY && this.EO) {
            IlO();
        }
        return this.MY;
    }

    public int Bc() {
        if (this.EO) {
            return PglSSManager.getInitStatus();
        }
        return 5;
    }

    public String Cc() {
        if (!lEW()) {
            return "";
        }
        DmF();
        PglSSManager pglSSManager = this.IlO;
        return pglSSManager != null ? pglSSManager.getSofChara() : "";
    }

    public void EO() {
        if (lEW()) {
            DmF();
            if (this.IlO != null) {
                bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.DmF.IlO.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HashMap map = new HashMap();
                            map.put(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ, cl.tV().OW());
                            IlO.this.IlO.setCustomInfo(map);
                        } catch (Throwable th) {
                            oeT.EO("MSSdkImpl", "setCustomInfo", th.getMessage());
                        }
                    }
                });
            }
        }
    }

    public boolean MY() {
        return this.MY;
    }

    public String tV() {
        if (!lEW()) {
            return "";
        }
        DmF();
        PglSSManager pglSSManager = this.IlO;
        return pglSSManager != null ? pglSSManager.getToken() : "";
    }

    public long vCE() {
        if (!lEW()) {
            return 0L;
        }
        DmF();
        PglSSManager pglSSManager = this.IlO;
        if (pglSSManager != null) {
            return pglSSManager.getECForBidding();
        }
        return 0L;
    }

    public synchronized void IlO() {
        if (!this.MY) {
            try {
                Context contextIlO = cl.IlO();
                String strTV = DmF.MY().tV();
                if (TextUtils.isEmpty(strTV)) {
                    strTV = DmF.IlO("app_id", LocationRequestCompat.PASSIVE_INTERVAL);
                }
                if (TextUtils.isEmpty(strTV)) {
                    return;
                }
                String strIlO = rp.IlO(contextIlO);
                String strMY = com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().MY();
                PglSSConfig pglSSConfigBuild = PglSSConfig.builder().setAppId(strTV).setOVRegionType(2).setAdsdkVersion(BuildConfig.VERSION_NAME).build();
                String strMY2 = tV.MY("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
                HashMap map = new HashMap();
                if (!TextUtils.isEmpty(strMY2)) {
                    map.put(PglSSConfig.CUSTOMINFO_KEY_IPV6, strMY2);
                }
                Set<String> setLa = hp.aP().La();
                if (setLa != null && !setLa.isEmpty()) {
                    map.put(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS, setLa);
                }
                String strHp = zLG.hp();
                if (!TextUtils.isEmpty(strHp)) {
                    map.put(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST, strHp);
                }
                map.put(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC, hp.aP().eDn());
                String strIlO2 = com.bytedance.sdk.openadsdk.AXM.IlO.IlO(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, "");
                if (!TextUtils.isEmpty(strIlO2)) {
                    map.put(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, strIlO2);
                }
                pglSSConfigBuild.setCustomInfo(map);
                pglSSConfigBuild.setCallBack(new PglSSCallBack() { // from class: com.bytedance.sdk.openadsdk.core.DmF.IlO.1
                    @Override // com.pgl.ssdk.ces.out.PglSSCallBack
                    public void reportSoftDecData(final String str, final String str2) {
                        com.bytedance.sdk.openadsdk.ea.EO.IlO(str, false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.DmF.IlO.1.1
                            @Override // com.bytedance.sdk.openadsdk.ea.MY
                            @Nullable
                            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                                return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO(str).MY(str2);
                            }
                        });
                    }
                });
                PglSSManager.init(contextIlO, pglSSConfigBuild, null, null, strIlO, strMY);
                DmF();
                this.MY = true;
            } catch (Throwable unused) {
                NV();
                this.MY = false;
            }
            try {
                if (this.EO) {
                    EO(PglSSManager.getLoadError());
                }
            } catch (Throwable th) {
                oeT.EO("mssdk", th.getMessage());
            }
        }
    }

    public void MY(String str) {
        if (lEW()) {
            DmF();
            PglSSManager pglSSManager = this.IlO;
            if (pglSSManager != null) {
                pglSSManager.setDeviceId(str);
            }
        }
    }

    private void EO(final String str) {
        if (this.tV || TextUtils.isEmpty(str)) {
            return;
        }
        cl.Cc().IlO(new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.DmF.IlO.4
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("secsdk_init_error").MY(str);
            }
        }, false);
        this.tV = true;
    }

    public void IlO(String str) {
        if (lEW()) {
            DmF();
            PglSSManager pglSSManager = this.IlO;
            if (pglSSManager != null) {
                pglSSManager.setGaid(str);
            }
        }
    }

    public void IlO(final Map<String, Object> map) {
        if (lEW()) {
            DmF();
            if (this.IlO != null) {
                bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.DmF.IlO.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            IlO.this.IlO.setCustomInfo(map);
                        } catch (Throwable th) {
                            oeT.EO("MSSdkImpl", "setCustomInfo", th.getMessage());
                        }
                    }
                });
            }
        }
    }

    public void IlO(String str, Map<String, Object> map) {
        if (lEW()) {
            DmF();
            PglSSManager pglSSManager = this.IlO;
            if (pglSSManager != null) {
                pglSSManager.reportNow(str, map);
            }
        }
    }

    public void IlO(MotionEvent motionEvent) {
        if (MY()) {
            DmF();
            PglSSManager pglSSManager = this.IlO;
            if (pglSSManager != null) {
                pglSSManager.checkEventVirtual(motionEvent);
            }
        }
    }

    public Map<String, String> IlO(String str, byte[] bArr) {
        Map<String, String> featureHash;
        return (!lEW() || (featureHash = this.IlO.getFeatureHash(str, bArr)) == null) ? new HashMap() : featureHash;
    }
}
