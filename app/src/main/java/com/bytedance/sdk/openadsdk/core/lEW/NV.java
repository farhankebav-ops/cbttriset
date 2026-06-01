package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import com.bumptech.glide.load.Key;
import com.bytedance.sdk.component.adexpress.tV.DmF;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.ironsource.G5;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends com.bytedance.sdk.openadsdk.core.widget.IlO.Cc {
    public ArrayList<Integer> IlO;
    private final com.bytedance.sdk.openadsdk.core.model.oeT MY;
    private com.bytedance.sdk.component.adexpress.MY.hp NV;

    public NV(Context context, vSq vsq, com.bytedance.sdk.openadsdk.core.model.oeT oet, com.bytedance.sdk.openadsdk.tV.EV ev, com.bytedance.sdk.component.adexpress.MY.hp hpVar) {
        super(context, vsq, oet.ED(), ev, false);
        this.IlO = new ArrayList<>();
        this.MY = oet;
        this.NV = hpVar;
    }

    private WebResourceResponse Cc() {
        InputStream inputStreamOpenRawResource;
        int iDmF = com.bytedance.sdk.openadsdk.core.DmF.MY().DmF();
        if (iDmF == 0) {
            return null;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.cl.IlO().getResources();
        if (resources != null) {
            try {
                inputStreamOpenRawResource = resources.openRawResource(iDmF);
            } catch (Resources.NotFoundException e) {
                com.bytedance.sdk.component.utils.oeT.EO("ExpressClient", e.toString());
                inputStreamOpenRawResource = null;
            }
        } else {
            inputStreamOpenRawResource = null;
        }
        if (inputStreamOpenRawResource != null) {
            return new WebResourceResponse(DmF.IlO.IMAGE.IlO(), Key.STRING_CHARSET_NAME, inputStreamOpenRawResource);
        }
        return null;
    }

    private String tV() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.MY;
        if (oet == null) {
            return null;
        }
        if (oet.uvo() != null) {
            return this.MY.uvo().hp();
        }
        if (this.MY.Ea() != null) {
            return "v3";
        }
        return null;
    }

    public int IlO() {
        ArrayList<Integer> arrayList = this.IlO;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Integer num = arrayList.get(i2);
            i2++;
            Integer num2 = num;
            if (num2.intValue() == 3 || num2.intValue() == 2 || num2.intValue() == -1) {
                return num2.intValue();
            }
        }
        return TextUtils.isEmpty(tV()) ? -1 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.Bc = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.lEW = false;
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r9, java.lang.String r10) {
        /*
            r8 = this;
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L19
            com.bytedance.sdk.component.adexpress.IlO.MY.IlO r0 = r8.IlO(r9, r10)     // Catch: java.lang.Throwable -> L19
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1d
            android.webkit.WebResourceResponse r1 = r0.IlO()     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L1d
            r1 = 1
        L15:
            r6 = r10
            r7 = r1
            r1 = r8
            goto L1f
        L19:
            r0 = move-exception
            r1 = r8
            r6 = r10
            goto L4b
        L1d:
            r1 = 2
            goto L15
        L1f:
            r1.IlO(r2, r4, r6, r7)     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L3e
            int r10 = r0.MY()     // Catch: java.lang.Throwable -> L3c
            r2 = 5
            if (r10 == r2) goto L3e
            r0.MY()     // Catch: java.lang.Throwable -> L3c
            java.util.ArrayList<java.lang.Integer> r10 = r1.IlO     // Catch: java.lang.Throwable -> L3c
            int r2 = r0.MY()     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L3c
            r10.add(r2)     // Catch: java.lang.Throwable -> L3c
            goto L3e
        L3c:
            r0 = move-exception
            goto L4b
        L3e:
            if (r0 == 0) goto L52
            android.webkit.WebResourceResponse r10 = r0.IlO()     // Catch: java.lang.Throwable -> L3c
            if (r10 == 0) goto L52
            android.webkit.WebResourceResponse r9 = r0.IlO()     // Catch: java.lang.Throwable -> L3c
            return r9
        L4b:
            java.lang.String r10 = "ExpressClient"
            java.lang.String r2 = "shouldInterceptRequest error2"
            com.bytedance.sdk.component.utils.oeT.IlO(r10, r2, r0)
        L52:
            android.webkit.WebResourceResponse r9 = super.shouldInterceptRequest(r9, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.lEW.NV.shouldInterceptRequest(android.webkit.WebView, java.lang.String):android.webkit.WebResourceResponse");
    }

    private WebResourceResponse Cc(String str) {
        InputStream inputStreamIlO;
        if (TextUtils.isEmpty(str) || (inputStreamIlO = com.bytedance.sdk.openadsdk.core.tV.IlO.IlO().IlO(str)) == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse("audio/*", Key.STRING_CHARSET_NAME, inputStreamIlO);
        IlO(webResourceResponse);
        return webResourceResponse;
    }

    private com.bytedance.sdk.component.adexpress.IlO.MY.IlO IlO(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.model.zPa zpa = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equals("local://pag_open_icon_id") && !str.equals(com.bytedance.sdk.openadsdk.core.lEW.IlO.MY.IlO)) {
            oeT.IlO ilOUvo = this.MY.uvo();
            if (ilOUvo != null && !TextUtils.isEmpty(str) && str.equals(ilOUvo.tV())) {
                com.bytedance.sdk.component.adexpress.IlO.MY.IlO ilO = new com.bytedance.sdk.component.adexpress.IlO.MY.IlO();
                ilO.IlO(5);
                WebResourceResponse webResourceResponseCc = Cc(str);
                ilO.IlO(webResourceResponseCc);
                com.bytedance.sdk.openadsdk.core.tV.IlO.IlO().IlO(webResourceResponseCc != null);
                return ilO;
            }
            DmF.IlO IlO = com.bytedance.sdk.component.adexpress.tV.DmF.IlO(str);
            if (IlO != DmF.IlO.IMAGE) {
                Iterator<com.bytedance.sdk.openadsdk.core.model.zPa> it = this.MY.Hg().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.bytedance.sdk.openadsdk.core.model.zPa next = it.next();
                    if (!TextUtils.isEmpty(next.IlO()) && !TextUtils.isEmpty(str)) {
                        String strIlO = next.IlO();
                        if (strIlO.startsWith("https")) {
                            strIlO = strIlO.replaceFirst("https", ProxyConfig.MATCH_HTTP);
                        }
                        if ((str.startsWith("https") ? str.replaceFirst("https", ProxyConfig.MATCH_HTTP) : str).equals(strIlO)) {
                            zpa = next;
                            break;
                        }
                    }
                }
            }
            if (IlO != DmF.IlO.IMAGE && zpa == null) {
                return com.bytedance.sdk.component.adexpress.IlO.MY.MY.IlO(str, IlO, "", tV());
            }
            com.bytedance.sdk.component.adexpress.IlO.MY.IlO ilO2 = new com.bytedance.sdk.component.adexpress.IlO.MY.IlO();
            ilO2.IlO(5);
            ilO2.IlO(IlO(str, com.bytedance.sdk.openadsdk.core.lEW.IlO.MY.IlO(this.MY, str)));
            return ilO2;
        }
        com.bytedance.sdk.component.adexpress.IlO.MY.IlO ilO3 = new com.bytedance.sdk.component.adexpress.IlO.MY.IlO();
        ilO3.IlO(5);
        ilO3.IlO(Cc());
        return ilO3;
    }

    private WebResourceResponse IlO(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamIlO = com.bytedance.sdk.openadsdk.DmF.tV.IlO(str, str2);
            if (inputStreamIlO == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(DmF.IlO.IMAGE.IlO(), G5.N, inputStreamIlO);
            try {
                IlO(webResourceResponse2);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        com.bytedance.sdk.component.utils.oeT.IlO("ExpressClient", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }

    private void IlO(long j, long j3, String str, int i2) {
        com.bytedance.sdk.openadsdk.tV.EV ev = this.vCE;
        if (ev == null || ev.MY() == null) {
            return;
        }
        DmF.IlO IlO = com.bytedance.sdk.component.adexpress.tV.DmF.IlO(str);
        if (IlO == DmF.IlO.HTML) {
            this.vCE.MY().IlO(str, j, j3, i2);
        } else if (IlO == DmF.IlO.JS) {
            this.vCE.MY().MY(str, j, j3, i2);
        }
    }

    private void IlO(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("Access-Control-Allow-Origin", ProxyConfig.MATCH_ALL_SCHEMES);
        webResourceResponse.setResponseHeaders(map);
    }
}
