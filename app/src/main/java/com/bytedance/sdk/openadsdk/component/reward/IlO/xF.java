package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import androidx.webkit.internal.b;
import com.bumptech.glide.load.Key;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.nvX;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF implements com.bytedance.sdk.openadsdk.rp.DmF {
    private final AtomicBoolean Bc = new AtomicBoolean(false);
    private boolean Cc;
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO DmF;
    private com.bytedance.sdk.component.DmF.vCE EO;
    private final Activity IlO;
    private final oeT MY;
    private int NV;
    private volatile boolean lEW;
    private ImageView tV;
    private com.bytedance.sdk.openadsdk.core.MY.Bc vCE;

    public xF(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.DmF = ilO;
        this.MY = ilO.MY;
        this.IlO = ilO.BS;
    }

    private void Cc() {
        this.EO.Cc();
        IlO(this.EO);
        this.EO.setDisplayZoomControls(false);
        this.EO.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.xF.3
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                super.onProgressChanged(webView, i2);
                if (i2 == 100) {
                    xF.this.tV();
                }
            }
        });
        this.EO.setWebViewClient(new vCE.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.xF.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                xF.this.tV();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    xF.this.IlO(webResourceResponse.getStatusCode(), webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : null);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (xF.this.IlO(str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV() {
        IlO(Integer.MAX_VALUE, (String) null);
    }

    public boolean EO() {
        if (!this.Cc) {
            return false;
        }
        ImageView imageView = this.tV;
        if (imageView != null) {
            imageView.performClick();
            return true;
        }
        com.bytedance.sdk.component.DmF.vCE vce = this.EO;
        if (vce == null) {
            return false;
        }
        this.vCE.onClick(vce);
        return true;
    }

    public void MY() {
        DeviceUtils.AudioInfoReceiver.MY(this);
        com.bytedance.sdk.component.DmF.vCE vce = this.EO;
        if (vce != null) {
            nvX.IlO(vce.getWebView());
        }
    }

    public void IlO() {
        DeviceUtils.AudioInfoReceiver.IlO(this);
        this.NV = DeviceUtils.Bc();
        if (this.MY.QfH() != null) {
            this.vCE = new com.bytedance.sdk.openadsdk.core.MY.Bc("VAST_END_CARD", this.MY.QfH()) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.xF.1
            };
            com.bytedance.sdk.openadsdk.core.EV.EO EO = this.MY.QfH().EO();
            if (EO != null) {
                String strCc = EO.Cc();
                if (!TextUtils.isEmpty(strCc)) {
                    this.Cc = true;
                    this.tV = (ImageView) this.DmF.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.lEW);
                    IlO(EO.MY(), EO.EO());
                    com.bytedance.sdk.openadsdk.DmF.tV.IlO(strCc).IlO(EO.MY()).MY(EO.EO()).Cc(BS.Cc(com.bytedance.sdk.openadsdk.core.cl.IlO())).tV(BS.EO(com.bytedance.sdk.openadsdk.core.cl.IlO())).EO(1).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(this.MY, strCc, new IlO(this.tV, strCc, this, this.Bc)));
                    return;
                }
                com.bytedance.sdk.component.DmF.vCE vce = (com.bytedance.sdk.component.DmF.vCE) this.DmF.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.DmF);
                this.EO = vce;
                if (vce == null) {
                    return;
                }
                Cc();
                String strTV = EO.tV();
                if (strTV != null) {
                    this.Cc = true;
                    if (strTV.startsWith(ProxyConfig.MATCH_HTTP)) {
                        this.EO.a_(strTV);
                        return;
                    }
                    String strIlO = com.bytedance.sdk.openadsdk.core.EV.Cc.IlO(strTV);
                    String str = TextUtils.isEmpty(strIlO) ? strTV : strIlO;
                    this.EO.setDefaultTextEncodingName("UTF -8");
                    this.EO.IlO(null, str, "text/html", Key.STRING_CHARSET_NAME, null);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.rp.DmF
    public void MY(int i2) {
        int i8 = this.NV;
        if (i8 == 0 && i2 > 0) {
            this.MY.QfH().IlO().DmF(this.DmF.vAh.EV());
        } else if (i8 > 0 && i2 == 0) {
            this.MY.QfH().IlO().lEW(this.DmF.vAh.EV());
        }
        this.NV = i2;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements com.bytedance.sdk.component.Cc.zPa {
        private final WeakReference<xF> EO;
        private final WeakReference<ImageView> IlO;
        private final String MY;
        private final AtomicBoolean tV;

        public IlO(ImageView imageView, String str, xF xFVar, AtomicBoolean atomicBoolean) {
            this.IlO = new WeakReference<>(imageView);
            this.MY = str;
            this.EO = new WeakReference<>(xFVar);
            this.tV = atomicBoolean;
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
            xF xFVar;
            ImageView imageView = this.IlO.get();
            if (imageView == null || (xFVar = this.EO.get()) == null || ev == null) {
                return;
            }
            Object objMY = ev.MY();
            if (objMY == null) {
                xFVar.IlO(-1, this.MY);
                return;
            }
            if (objMY instanceof Bitmap) {
                imageView.setImageBitmap((Bitmap) objMY);
            } else if (objMY instanceof Drawable) {
                if (Build.VERSION.SDK_INT >= 28 && b.y(objMY)) {
                    b.h(objMY).start();
                }
                imageView.setImageDrawable((Drawable) objMY);
            }
            this.tV.set(true);
            xFVar.tV();
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(int i2, String str, @Nullable Throwable th) {
            xF xFVar;
            ImageView imageView = this.IlO.get();
            if (imageView == null || (xFVar = this.EO.get()) == null) {
                return;
            }
            imageView.setVisibility(8);
            xFVar.IlO(-2, this.MY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final int i2, final String str) {
        String strEV;
        if (this.lEW) {
            return;
        }
        this.lEW = true;
        if (this.MY.QfH() != null) {
            strEV = this.MY.QfH().EV();
        } else {
            strEV = "";
        }
        final String str2 = strEV;
        if (i2 == Integer.MAX_VALUE) {
            com.bytedance.sdk.openadsdk.tV.EO.MY(this.MY, str2, "load_vast_endcard_success", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(new com.bytedance.sdk.component.lEW.lEW("load_vast_endcard_fail") { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.xF.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("reason_code", i2);
                        jSONObject.put("error_code", i2);
                        String str3 = str;
                        if (str3 != null) {
                            jSONObject.put("url", str3);
                        }
                        com.bytedance.sdk.openadsdk.tV.EO.MY(xF.this.MY, str2, "load_vast_endcard_fail", jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private void IlO(com.bytedance.sdk.component.DmF.vCE vce) {
        vce.setVerticalScrollBarEnabled(false);
        vce.setHorizontalScrollBarEnabled(false);
        vce.setMixedContentMode(0);
        vce.setJavaScriptEnabled(true);
        vce.setJavaScriptCanOpenWindowsAutomatically(true);
        vce.setDomStorageEnabled(true);
        vce.setDatabaseEnabled(true);
        vce.setCacheMode(-1);
        vce.setAllowFileAccess(false);
        vce.setSupportZoom(true);
        vce.setBuiltInZoomControls(true);
        vce.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        vce.setUseWideViewPort(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlO(String str) {
        oeT oet;
        if (str == null || (oet = this.MY) == null || oet.QfH() == null || this.vCE == null) {
            return false;
        }
        this.MY.QfH().Bc(str);
        this.vCE.onClick(this.EO);
        return true;
    }

    private void IlO(int i2, int i8) {
        if (i2 == 0 || i8 == 0 || this.tV == null) {
            return;
        }
        int iEO = BS.EO((Context) this.IlO);
        int iCc = BS.Cc(this.IlO);
        if (i2 / i8 <= iEO / iCc) {
            iEO = (int) Math.ceil(r5 * r4);
        } else {
            iCc = (int) Math.ceil(r5 / r4);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tV.getLayoutParams();
        layoutParams.width = iEO;
        layoutParams.height = iCc;
        layoutParams.gravity = 17;
        this.tV.setLayoutParams(layoutParams);
        this.tV.setOnClickListener(this.vCE);
        this.tV.setOnTouchListener(this.vCE);
    }

    public boolean IlO(cl clVar) {
        com.bytedance.sdk.openadsdk.core.EV.EO EO;
        if (!this.Cc) {
            return false;
        }
        if (this.tV != null && this.Bc.get()) {
            this.tV.setVisibility(0);
        } else {
            com.bytedance.sdk.component.DmF.vCE vce = this.EO;
            if (vce != null) {
                vce.setVisibility(0);
                if (this.EO.getWebView() != null) {
                    this.EO.getWebView().setOnTouchListener(this.vCE);
                }
            }
        }
        oeT oet = this.MY;
        if (oet == null || oet.QfH() == null || (EO = this.MY.QfH().EO()) == null) {
            return true;
        }
        EO.MY(clVar != null ? clVar.EV() : -1L);
        return true;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.Cc cc) {
        com.bytedance.sdk.openadsdk.core.MY.Bc bc = this.vCE;
        if (bc != null) {
            bc.IlO(cc);
        }
    }
}
