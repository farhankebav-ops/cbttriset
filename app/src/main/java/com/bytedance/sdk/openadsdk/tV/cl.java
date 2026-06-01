package com.bytedance.sdk.openadsdk.tV;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl implements com.bytedance.sdk.openadsdk.tV.tV.Cc {
    private JSONArray Bc;
    private Boolean Cc;
    private Boolean EO;
    private String IlO;
    private oeT MY;
    private JSONArray lEW;
    private Boolean tV;
    private JSONObject vCE;

    public cl(int i2, String str, oeT oet) {
        Boolean bool = Boolean.FALSE;
        this.EO = bool;
        this.tV = bool;
        this.Cc = bool;
        this.IlO = str;
        this.MY = oet;
        this.vCE = new JSONObject();
        this.Bc = new JSONArray();
        this.lEW = new JSONArray();
        IlO(this.vCE, "webview_source", Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cl() {
        if (this.Cc.booleanValue()) {
            return true;
        }
        return this.tV.booleanValue() && this.EO.booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.EO
    public void Bc() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.30
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "native_endcard_show", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.EO
    public void DmF() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.3
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl.this.IlO(jSONObject, "type", "native_enterBackground");
                cl clVar = cl.this;
                clVar.IlO(clVar.Bc, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.Cc
    public void EV() {
        this.EO = Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.EO
    public void NV() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.4
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl.this.IlO(jSONObject, "type", "native_enterForeground");
                cl clVar = cl.this;
                clVar.IlO(clVar.Bc, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.MY
    public void bWL() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.15
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "no_native_render", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.tV
    public void ea() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.16
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "render_failed", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.MY
    public void hp() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.14
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "native_render_end", jSONObject);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                cl.this.IlO(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis2));
                cl clVar2 = cl.this;
                clVar2.IlO(clVar2.vCE, "render_success", jSONObject2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.EO
    public void lEW() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.2
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "native_endcard_close", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.Cc
    public void rp() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.10
            @Override // java.lang.Runnable
            public void run() {
                if (cl.this.cl()) {
                    if (cl.this.Bc != null && cl.this.Bc.length() != 0) {
                        try {
                            cl.this.vCE.put("native_switchBackgroundAndForeground", cl.this.Bc);
                        } catch (Exception unused) {
                        }
                    }
                    if (cl.this.lEW != null && cl.this.lEW.length() != 0) {
                        try {
                            cl.this.vCE.put("intercept_source", cl.this.lEW);
                        } catch (Exception unused2) {
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("webview_time_track", cl.this.vCE);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.oeT.IlO("WebviewTimeTrack", "trySendTrackInfo json error", e);
                    }
                    if (com.bytedance.sdk.openadsdk.core.DmF.MY().es() && cl.this.vCE != null) {
                        JSONObject unused3 = cl.this.vCE;
                    }
                    EO.MY(cl.this.MY, cl.this.IlO, "webview_time_track", jSONObject);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.tV
    public void zPa() {
        try {
            com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.17
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    cl clVar = cl.this;
                    clVar.IlO(clVar.vCE, "render_did_finish", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.IlO
    public void Bc(final String str) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.22
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.vCE
    public void Cc() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.27
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "webview_load_start", (Object) jSONObject, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.MY
    public void EO() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.25
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "native_render_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.tV
    public void MY() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.12
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "render_success", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.EO
    public void tV() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.26
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "native_render_end", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.vCE
    public void vCE() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.28
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "webview_load_success", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.IlO
    public void Cc(final String str) {
        try {
            com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.19
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    cl clVar = cl.this;
                    clVar.IlO(clVar.vCE, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.IlO
    public void EO(final String str) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.11
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.vCE
    public void MY(final String str, final long j, final long j3, final int i2) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.6
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str) || j3 < j) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "start_ts", Long.valueOf(j));
                cl.this.IlO(jSONObject, "end_ts", Long.valueOf(j3));
                cl.this.IlO(jSONObject, "intercept_type", Integer.valueOf(i2));
                cl.this.IlO(jSONObject, "type", "intercept_js");
                cl.this.IlO(jSONObject, "url", str);
                cl.this.IlO(jSONObject, "duration", Long.valueOf(j3 - j));
                cl clVar = cl.this;
                clVar.IlO(clVar.lEW, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.IlO
    public void tV(final String str) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.18
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.IlO
    public void vCE(final String str) {
        try {
            com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.20
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    cl clVar = cl.this;
                    clVar.IlO(clVar.vCE, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.IlO
    public void EO(final int i2, final String str) {
        try {
            com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.21
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    cl.this.IlO(jSONObject, "code", Integer.valueOf(i2));
                    cl clVar = cl.this;
                    clVar.IlO(clVar.vCE, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.vCE
    public void MY(final String str) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl.this.IlO(jSONObject, "jsb", str);
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "webview_jsb_end", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.vCE
    public void MY(final JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.9
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2;
                if (cl.this.vCE == null || (jSONObject2 = jSONObject) == null) {
                    return;
                }
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    cl clVar = cl.this;
                    clVar.IlO(clVar.vCE, next, jSONObject.opt(next));
                }
                cl.this.tV = Boolean.TRUE;
                cl.this.rp();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.tV
    public void IlO() {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.1
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl clVar = cl.this;
                clVar.IlO(jSONObject, "render_sequence", Integer.valueOf(clVar.MY.nvX()));
                if (cl.this.MY != null) {
                    if (cl.this.MY.uvo() != null) {
                        if (cl.this.MY.uvo().bWL()) {
                            cl.this.IlO(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().tV()));
                            cl.this.IlO(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().tV()));
                        } else {
                            cl.this.IlO(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().EO()));
                            cl.this.IlO(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().EO()));
                        }
                    } else if (cl.this.MY.Ea() != null) {
                        cl.this.IlO(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().tV()));
                        cl.this.IlO(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().tV()));
                    }
                }
                cl clVar2 = cl.this;
                clVar2.IlO(clVar2.vCE, "render_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.IlO
    public void MY(final int i2, final String str) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.13
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl.this.IlO(jSONObject, "code", Integer.valueOf(i2));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.tV
    public void IlO(final int i2, final String str) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.23
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl.this.IlO(jSONObject, "code", Integer.valueOf(i2));
                String str2 = str;
                if (str2 != null) {
                    cl.this.IlO(jSONObject, "reason", str2);
                }
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "render_error", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.vCE
    public void IlO(final JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.29
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                cl.this.IlO(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "webview_load_error", jSONObject2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.vCE
    public void IlO(final String str, final long j, final long j3, final int i2) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.5
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str) || j3 < j) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "start_ts", Long.valueOf(j));
                cl.this.IlO(jSONObject, "end_ts", Long.valueOf(j3));
                cl.this.IlO(jSONObject, "intercept_type", Integer.valueOf(i2));
                cl.this.IlO(jSONObject, "type", "intercept_html");
                cl.this.IlO(jSONObject, "url", str);
                cl.this.IlO(jSONObject, "duration", Long.valueOf(j3 - j));
                cl clVar = cl.this;
                clVar.IlO(clVar.lEW, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.vCE
    public void IlO(final String str) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.7
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl.this.IlO(jSONObject, "jsb", str);
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "webview_jsb_start", jSONObject);
            }
        });
    }

    public cl() {
        this.IlO = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.EO = bool;
        this.tV = bool;
        this.Cc = bool;
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.Cc
    public void IlO(boolean z2) {
        this.Cc = Boolean.valueOf(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(JSONObject jSONObject, String str, Object obj, boolean z2) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z2) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(JSONObject jSONObject, String str, Object obj) {
        IlO(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tV.tV.vCE
    public void IlO(final int i2) {
        com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.cl.24
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                cl.this.IlO(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                cl.this.IlO(jSONObject, "isWebViewCache", Integer.valueOf(i2));
                if (cl.this.MY != null) {
                    if (cl.this.MY.KC()) {
                        cl.this.IlO(jSONObject, "engine_version", "v3");
                    } else {
                        cl.this.IlO(jSONObject, "engine_version", "v1");
                    }
                }
                cl clVar = cl.this;
                clVar.IlO(clVar.vCE, "before_webview_request", jSONObject);
            }
        });
    }
}
