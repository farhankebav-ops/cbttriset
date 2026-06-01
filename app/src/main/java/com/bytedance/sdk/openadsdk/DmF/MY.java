package com.bytedance.sdk.openadsdk.DmF;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.camera.core.processing.util.a;
import com.bytedance.sdk.component.Cc.EV;
import com.bytedance.sdk.component.Cc.zPa;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.Y1;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY<T> implements zPa<T> {
    private final zPa<T> EO;
    private final long IlO = SystemClock.elapsedRealtime();
    private final String MY;
    private final oeT tV;

    public MY(final oeT oet, String str, zPa<T> zpa) {
        this.EO = zpa;
        this.tV = oet;
        this.MY = str;
        if (tV.MY()) {
            com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.DmF.MY.1
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    com.bytedance.sdk.openadsdk.cl.MY.IlO ilOD = a.d("load_img");
                    oeT oet2 = oet;
                    if (oet2 != null) {
                        ilOD.EO(oet2.pP(Y1.f7808f));
                        ilOD.tV(zLG.EO(oet.fHv()));
                    }
                    ilOD.IlO(BuildConfig.VERSION_NAME);
                    return ilOD;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.Cc.zPa
    public void IlO(EV<T> ev) {
        zPa<T> zpa = this.EO;
        if (zpa != null) {
            zpa.IlO(ev);
        }
        if (this.tV != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime() - this.IlO;
            final int iBc = ev.Bc() / 1024;
            final int i2 = ev.vCE() ? 1 : 0;
            com.bytedance.sdk.openadsdk.ea.EO.IlO("load_image_success", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.DmF.MY.2
                @Override // com.bytedance.sdk.openadsdk.ea.MY
                @Nullable
                public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jElapsedRealtime);
                    jSONObject.put("url", MY.this.MY);
                    jSONObject.put("preload_size", iBc);
                    jSONObject.put("local_cache", i2);
                    jSONObject.put("image_mode", MY.this.tV.uI());
                    jSONObject.put("use_new_img", tV.MY() ? 1 : 0);
                    return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("load_image_success").IlO(MY.this.tV.fHv()).MY(jSONObject.toString());
                }
            });
            if (tV.MY()) {
                com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.DmF.MY.3
                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                        com.bytedance.sdk.openadsdk.cl.MY.IlO ilOD = a.d("load_img");
                        if (MY.this.tV != null) {
                            ilOD.EO(MY.this.tV.pP(Y1.f7808f));
                            ilOD.tV(zLG.EO(MY.this.tV.fHv()));
                        }
                        ilOD.IlO(BuildConfig.VERSION_NAME);
                        return ilOD;
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.Cc.zPa
    public void IlO(final int i2, final String str, @Nullable final Throwable th) {
        zPa<T> zpa = this.EO;
        if (zpa != null) {
            zpa.IlO(i2, str, th);
        }
        oeT oet = this.tV;
        if (oet != null) {
            if (!TextUtils.isEmpty(zLG.IlO(oet))) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - this.IlO;
                com.bytedance.sdk.openadsdk.ea.EO.IlO("load_image_error", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.DmF.MY.4
                    @Override // com.bytedance.sdk.openadsdk.ea.MY
                    @Nullable
                    public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("duration", jElapsedRealtime);
                        jSONObject.put("url", MY.this.MY);
                        jSONObject.put("error_code", i2);
                        Throwable th2 = th;
                        if (th2 instanceof NullPointerException) {
                            ApmHelper.reportCustomError("image load fail", "image_load", th2);
                        }
                        jSONObject.put("error_message", str);
                        jSONObject.put("image_mode", MY.this.tV.uI());
                        jSONObject.put("use_new_img", tV.MY() ? 1 : 0);
                        return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("load_image_error").IlO(MY.this.tV.fHv()).MY(jSONObject.toString());
                    }
                });
            }
            if (tV.MY()) {
                com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.DmF.MY.5
                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                        com.bytedance.sdk.openadsdk.cl.MY.IlO ilOD = a.d("load_img");
                        if (MY.this.tV != null) {
                            ilOD.EO(MY.this.tV.pP(Y1.f7808f));
                            ilOD.tV(zLG.EO(MY.this.tV.fHv()));
                        }
                        ilOD.IlO(BuildConfig.VERSION_NAME);
                        return ilOD;
                    }
                });
            }
        }
    }
}
