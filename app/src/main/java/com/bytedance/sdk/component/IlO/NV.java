package com.bytedance.sdk.component.IlO;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.IlO.EV;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    boolean Bc;
    Context Cc;
    hp DmF;
    WebView IlO;
    IlO MY;
    bWL NV;
    boolean bWL;
    boolean ea;
    boolean lEW;
    lEW tV;
    boolean vCE;
    EV.IlO zPa;
    String EO = "IESJSBridge";
    String EV = "host";
    final Set<String> rp = new LinkedHashSet();
    final Set<String> hp = new LinkedHashSet();

    public NV(WebView webView) {
        this.IlO = webView;
    }

    private void EO() {
        if ((this.IlO == null && !this.bWL && this.MY == null) || ((TextUtils.isEmpty(this.EO) && this.IlO != null) || this.tV == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public NV IlO(IlO ilO) {
        this.MY = ilO;
        return this;
    }

    public NV MY(boolean z2) {
        this.Bc = z2;
        return this;
    }

    public NV IlO(String str) {
        this.EO = str;
        return this;
    }

    public cl MY() {
        EO();
        return new cl(this);
    }

    public NV IlO(rp rpVar) {
        this.tV = lEW.IlO(rpVar);
        return this;
    }

    public NV IlO(boolean z2) {
        this.vCE = z2;
        return this;
    }

    public NV IlO() {
        this.ea = true;
        return this;
    }

    public NV() {
    }
}
