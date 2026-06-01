package com.bytedance.sdk.openadsdk.hp;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.openadsdk.Bc.MY;
import com.bytedance.sdk.openadsdk.core.model.cl;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.wPn;
import com.bytedance.sdk.openadsdk.core.widget.IlO.Cc;
import com.bytedance.sdk.openadsdk.core.widget.IlO.EO;
import com.bytedance.sdk.openadsdk.tV.EV;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static int EO = 2;
    private static volatile IlO IlO = null;
    private static long tV = 3600000;
    private LinkedHashMap<Integer, SoftReference<vCE>> Cc;
    private final Handler MY;

    public IlO() {
        EO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("pre_render_count", 2);
        long jIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("pre_render_duration", 3600000);
        tV = jIlO;
        if (EO <= 0) {
            EO = 2;
        }
        if (jIlO <= 0) {
            tV = 3600000L;
        }
        this.Cc = new LinkedHashMap<>();
        this.MY = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.hp.IlO.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(@NonNull Message message) {
                SoftReference softReference;
                int i2 = message.what;
                if (IlO.this.Cc == null || (softReference = (SoftReference) IlO.this.Cc.get(Integer.valueOf(i2))) == null) {
                    return false;
                }
                vCE vce = (vCE) softReference.get();
                IlO.this.IlO(i2, 2, new wPn(), vce == null ? "" : vce.getTag());
                return false;
            }
        });
    }

    public static boolean EO(oeT oet) {
        return es.vCE(oet) || es.MY(oet) || es.EO(oet);
    }

    public vCE MY(oeT oet) {
        if (oet == null || TextUtils.isEmpty(oet.pFe())) {
            return null;
        }
        String strPFe = oet.pFe();
        if (TextUtils.isEmpty(strPFe)) {
            return null;
        }
        int iHashCode = strPFe.hashCode();
        SoftReference<vCE> softReference = this.Cc.get(Integer.valueOf(iHashCode));
        if (softReference == null || softReference.get() == null) {
            return null;
        }
        vCE vce = softReference.get();
        IlO(oet, vce.getTag(), Double.valueOf((System.currentTimeMillis() / 1000) - oet.ZUt()).floatValue(), "web_use_pre_render");
        IlO(iHashCode, 3, oet, vce.getTag());
        return vce;
    }

    public static IlO IlO() {
        if (IlO == null) {
            synchronized (IlO.class) {
                try {
                    if (IlO == null) {
                        IlO = new IlO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public void IlO(final oeT oet) {
        final String str;
        if (oet == null || !EO(oet)) {
            return;
        }
        cl clVarZPa = oet.zPa();
        if (clVarZPa == null) {
            clVarZPa = new cl();
        }
        oet.CuC();
        if (oet.CuC()) {
            String strPFe = oet.pFe();
            if (TextUtils.isEmpty(strPFe)) {
                return;
            }
            final int iHashCode = strPFe.hashCode();
            if (es.MY(oet)) {
                str = "landingpage_split_screen";
            } else if (es.tV(oet)) {
                str = "landingpage_direct";
            } else if (es.EO(oet)) {
                str = "landingpage_split_ceiling";
            } else {
                str = "";
            }
            LinkedHashMap<Integer, SoftReference<vCE>> linkedHashMap = this.Cc;
            if (linkedHashMap == null || !linkedHashMap.containsKey(Integer.valueOf(iHashCode))) {
                HashMap map = new HashMap();
                map.put(oet.tU(), oet);
                if (clVarZPa.MY() == 2) {
                    MY.IlO().IlO((Map<String, oeT>) map, new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.hp.IlO.2
                        @Override // com.bytedance.sdk.openadsdk.Bc.MY.IlO
                        public void IlO() {
                            IlO.this.IlO(iHashCode, oet, str, true);
                        }
                    }, true);
                    return;
                }
                if (clVarZPa.MY() == 1) {
                    MY.IlO().IlO((Map<String, oeT>) map, (MY.IlO) null, true);
                    IlO(iHashCode, oet, str, true);
                } else if (clVarZPa.MY() == 0) {
                    IlO(iHashCode, oet, str, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final int i2, final oeT oet, final String str, final boolean z2) {
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.hp.IlO.3
            private Cc IlO(@NonNull final vCE vce, EV ev) {
                Cc cc = new Cc(com.bytedance.sdk.openadsdk.core.cl.IlO(), null, oet.ED(), ev, true) { // from class: com.bytedance.sdk.openadsdk.hp.IlO.3.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str2) {
                        vCE vce2 = vce;
                        if (vce2 != null) {
                            vce2.setPreFinish(true);
                        }
                        super.onPageFinished(webView, str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                    public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                        vCE vce2 = vce;
                        if (vce2 != null) {
                            vce2.setPreStart(true);
                        }
                        super.onPageStarted(webView, str2, bitmap);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i8, String str2, String str3) {
                        String strTV = Cc.tV(str3);
                        boolean z7 = false;
                        boolean z8 = strTV != null && strTV.startsWith("image");
                        if (strTV != null && strTV.startsWith("mp4")) {
                            z7 = true;
                        }
                        if (!z8 && !z7 && !vce.EO()) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            IlO.this.IlO(i2, 4, oet, str);
                        }
                        super.onReceivedError(webView, i8, str2, str3);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        if (sslErrorHandler != null) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            IlO.this.IlO(i2, 4, oet, str);
                        }
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                        try {
                            if (!z2) {
                                return super.shouldInterceptRequest(webView, str2);
                            }
                            vCE vce2 = vce;
                            if (vce2 != null) {
                                vce2.IlO++;
                            }
                            WebResourceResponseModel webResourceResponseModelIlO = MY.IlO().IlO(MY.IlO().MY(), oet.tU(), str2);
                            if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getWebResourceResponse() != null) {
                                vCE vce3 = vce;
                                if (vce3 != null) {
                                    vce3.MY++;
                                }
                                return webResourceResponseModelIlO.getWebResourceResponse();
                            }
                            if (vce != null && webResourceResponseModelIlO != null && webResourceResponseModelIlO.getMsg() == 2) {
                                vce.EO++;
                            }
                            return super.shouldInterceptRequest(webView, str2);
                        } catch (Throwable unused) {
                            return super.shouldInterceptRequest(webView, str2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                        return super.shouldOverrideUrlLoading(webView, str2);
                    }
                };
                cc.IlO(oet);
                cc.IlO(str);
                return cc;
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x00d2  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 385
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.hp.IlO.AnonymousClass3.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(int i2, int i8, oeT oet, String str) {
        LinkedHashMap<Integer, SoftReference<vCE>> linkedHashMap = this.Cc;
        if (linkedHashMap != null && linkedHashMap.containsKey(Integer.valueOf(i2))) {
            this.Cc.remove(Integer.valueOf(i2));
        }
        Handler handler = this.MY;
        if (handler != null) {
            handler.removeMessages(i2);
        }
        IlO(oet, str, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(vCE vce, String str) {
        if (vce == null) {
            return;
        }
        EO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO()).IlO(false).MY(false).IlO(vce.getWebView());
        vce.setMixedContentMode(0);
        com.bytedance.sdk.openadsdk.utils.oeT.IlO(vce, str);
    }

    public static void IlO(oeT oet, String str, final float f4, String str2) {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.hp.IlO.4
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", f4);
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void IlO(oeT oet, final String str, final int i2) {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), oet, str, "web_delete_pre_render", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.hp.IlO.5
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("reason", i2);
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                jSONObject2.toString();
                return jSONObject;
            }
        });
    }
}
