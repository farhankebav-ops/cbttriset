package com.bytedance.sdk.component.adexpress.Cc;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.bumptech.glide.load.Key;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.component.IlO.tl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private static final byte[] Cc = new byte[0];
    private static volatile Cc DmF = null;
    private static int lEW = 10;
    private static int vCE = 10;
    private final AtomicBoolean Bc = new AtomicBoolean(false);
    private List<vCE> IlO = new ArrayList();
    private List<vCE> MY = new ArrayList();
    private Map<Integer, EO> EO = new HashMap();
    private Map<Integer, tV> tV = new HashMap();

    private Cc() {
        com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
        if (EO != null) {
            vCE = EO.NV();
            lEW = EO.EV();
        }
    }

    private void Bc(vCE vce) {
        try {
            vce.removeAllViews();
            vce.Bc();
            vce.setWebChromeClient(null);
            vce.setWebViewClient(null);
            vce.setDownloadListener(null);
            vce.setJavaScriptEnabled(true);
            vce.setCacheMode(-1);
            vce.setSupportZoom(false);
            vce.setUseWideViewPort(true);
            vce.setJavaScriptCanOpenWindowsAutomatically(true);
            vce.setDomStorageEnabled(true);
            vce.setBuiltInZoomControls(false);
            vce.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            vce.setLoadWithOverviewMode(false);
            vce.setDefaultTextEncodingName(Key.STRING_CHARSET_NAME);
            vce.setDefaultFontSize(16);
        } catch (Throwable unused) {
        }
    }

    public static Cc IlO() {
        if (DmF == null) {
            synchronized (Cc.class) {
                try {
                    if (DmF == null) {
                        DmF = new Cc();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return DmF;
    }

    public boolean Cc(vCE vce) {
        if (vce == null) {
            return false;
        }
        try {
            Context context = vce.getContext();
            if (context instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
            }
            vce.zPa();
            return true;
        } catch (Throwable th) {
            th.getMessage();
            return true;
        }
    }

    @UiThread
    public void EO(vCE vce) {
        if (vce == null) {
            return;
        }
        Bc(vce);
        vce.b_("SDK_INJECT_GLOBAL");
        vCE(vce);
        tV(vce);
    }

    @UiThread
    public void MY(vCE vce) {
        if (vce == null) {
            return;
        }
        Bc(vce);
        vce.b_("SDK_INJECT_GLOBAL");
        vCE(vce);
        IlO(vce);
    }

    public void tV(vCE vce) {
        if (vce == null) {
            return;
        }
        if (this.IlO.size() >= vCE) {
            try {
                Context context = vce.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                }
                vce.zPa();
                return;
            } catch (Throwable th) {
                th.getMessage();
                return;
            }
        }
        if (this.IlO.contains(vce)) {
            return;
        }
        try {
            Context context2 = vce.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                vce.setRecycler(true);
                this.IlO.add(vce);
                EO();
            }
        } catch (Throwable th2) {
            EO();
            th2.getMessage();
        }
    }

    public void vCE(vCE vce) {
        if (vce == null) {
            return;
        }
        EO eo = this.EO.get(Integer.valueOf(vce.hashCode()));
        if (eo != null) {
            eo.IlO(null);
        }
        vce.b_("SDK_INJECT_GLOBAL");
    }

    public int EO() {
        return this.IlO.size();
    }

    @Nullable
    public vCE MY(Context context, String str) {
        if (EO() <= 0) {
            return null;
        }
        if (com.bytedance.sdk.component.adexpress.tV.Cc.IlO(str) && EO() <= 1) {
            EO();
            return null;
        }
        vCE vceRemove = this.IlO.remove(0);
        if (vceRemove == null) {
            return null;
        }
        try {
            Context context2 = vceRemove.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context.getApplicationContext());
                vceRemove.setRecycler(false);
                EO();
            }
            return vceRemove;
        } catch (Throwable unused) {
            EO();
            return null;
        }
    }

    @Nullable
    public vCE IlO(Context context, String str) {
        if (tV() <= 0) {
            return null;
        }
        if (com.bytedance.sdk.component.adexpress.tV.Cc.IlO(str) && tV() <= 1) {
            tV();
            return null;
        }
        vCE vceRemove = this.MY.remove(0);
        if (vceRemove == null) {
            return null;
        }
        try {
            Context context2 = vceRemove.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context.getApplicationContext());
                vceRemove.setRecycler(false);
                tV();
            }
            return vceRemove;
        } catch (Throwable unused) {
            tV();
            return null;
        }
    }

    public void MY() {
        for (vCE vce : this.IlO) {
            if (vce != null) {
                try {
                    Context context = vce.getContext();
                    if (context instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                    }
                    vce.zPa();
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        }
        this.IlO.clear();
        for (vCE vce2 : this.MY) {
            if (vce2 != null) {
                try {
                    Context context2 = vce2.getContext();
                    if (context2 instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                    }
                    vce2.zPa();
                } catch (Throwable th2) {
                    th2.getMessage();
                }
            }
        }
        this.MY.clear();
    }

    public int tV() {
        return this.MY.size();
    }

    public void IlO(vCE vce) {
        if (vce == null) {
            return;
        }
        if (this.MY.size() >= lEW) {
            try {
                Context context = vce.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                }
                vce.zPa();
                return;
            } catch (Throwable th) {
                th.getMessage();
                return;
            }
        }
        if (this.MY.contains(vce)) {
            return;
        }
        try {
            Context context2 = vce.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                vce.setRecycler(true);
                this.MY.add(vce);
                tV();
            }
        } catch (Throwable th2) {
            tV();
            th2.getMessage();
        }
    }

    public void MY(int i2) {
        synchronized (Cc) {
            lEW = i2;
        }
    }

    public void IlO(vCE vce, MY my) {
        if (vce == null || my == null) {
            return;
        }
        EO eo = this.EO.get(Integer.valueOf(vce.hashCode()));
        if (eo != null) {
            eo.IlO(my);
        } else {
            eo = new EO(my);
            this.EO.put(Integer.valueOf(vce.hashCode()), eo);
        }
        vce.IlO(eo, "SDK_INJECT_GLOBAL");
    }

    public void IlO(WebView webView, tl tlVar, String str) {
        if (webView == null || tlVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        tV tVVar = this.tV.get(Integer.valueOf(webView.hashCode()));
        if (tVVar != null) {
            tVVar.IlO(tlVar);
        } else {
            tVVar = new tV(tlVar);
            this.tV.put(Integer.valueOf(webView.hashCode()), tVVar);
        }
        webView.addJavascriptInterface(tVVar, str);
    }

    public void IlO(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        tV tVVar = this.tV.get(Integer.valueOf(webView.hashCode()));
        if (tVVar != null) {
            tVVar.IlO(null);
        }
        webView.removeJavascriptInterface(str);
    }

    public void IlO(int i2) {
        synchronized (Cc) {
            vCE = i2;
        }
    }
}
