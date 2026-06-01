package com.bytedance.sdk.openadsdk.tV;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private int Bc;
    private final boolean Cc;
    private final oeT IlO;
    private long NV;
    private final WebView lEW;
    private int vCE;
    private String DmF = "landingpage";
    private final Map<Integer, Long> MY = new HashMap();
    private final List<Integer> EO = new ArrayList();
    private final Map<Integer, String> tV = new HashMap();

    public lEW(oeT oet, WebView webView, boolean z2) {
        this.IlO = oet;
        this.lEW = webView;
        this.Cc = z2;
    }

    public void EO(String str) {
        this.DmF = str;
    }

    public void IlO(String str, int i2) {
        if (this.Cc) {
            i2++;
        }
        if (IlO(true)) {
            EO.IlO(this.IlO, this.DmF, this.vCE, str, i2);
            this.tV.put(Integer.valueOf(this.vCE), str);
            this.NV = SystemClock.elapsedRealtime();
        }
    }

    public void MY(String str) {
        String str2 = this.tV.get(Integer.valueOf(this.vCE));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        String str3 = str2;
        int i2 = this.vCE;
        if (i2 > 0) {
            EO.IlO(this.IlO, this.DmF, i2, str3, str, 1);
        }
    }

    private void MY(boolean z2) {
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = this.lEW.copyBackForwardList();
            if (webBackForwardListCopyBackForwardList != null) {
                if (z2) {
                    int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
                    this.vCE = currentIndex + 1;
                    if (this.Cc) {
                        this.vCE = currentIndex + 2;
                        return;
                    }
                    return;
                }
                int currentIndex2 = webBackForwardListCopyBackForwardList.getCurrentIndex();
                this.Bc = currentIndex2 + 1;
                if (this.Cc) {
                    this.Bc = currentIndex2 + 2;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("ArbitrageLandingLog", th.toString());
        }
    }

    public void IlO(String str) {
        if (IlO(false)) {
            EO.IlO(this.IlO, this.DmF, this.vCE, str, SystemClock.elapsedRealtime() - this.NV);
        }
    }

    public void IlO(WebView webView, String str) {
        oeT oet = this.IlO;
        if (oet == null || !com.bytedance.sdk.component.DmF.MY.IlO(oet.cl().MY(), str)) {
            return;
        }
        String str2 = this.tV.get(Integer.valueOf(this.vCE));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        EO.IlO(this.IlO, this.DmF, this.vCE, str2, str, 2);
    }

    private boolean IlO(boolean z2) {
        int i2 = z2 ? this.vCE : this.Bc;
        MY(z2);
        int i8 = z2 ? this.vCE : this.Bc;
        return i8 > 0 && i8 != i2;
    }
}
