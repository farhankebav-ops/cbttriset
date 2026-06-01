package com.bytedance.sdk.component.IlO;

import android.webkit.WebView;
import com.bytedance.sdk.component.IlO.tV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl {
    static vAh IlO;
    private final List<bWL> Cc;
    private final WebView EO;
    private final IlO MY;
    private final NV tV;
    private volatile boolean vCE;

    public cl(NV nv) {
        ArrayList arrayList = new ArrayList();
        this.Cc = arrayList;
        this.vCE = false;
        this.tV = nv;
        if (nv.lEW && IlO != null) {
            throw null;
        }
        if (nv.IlO != null) {
            IlO ilO = nv.MY;
            if (ilO == null) {
                this.MY = new tl();
            } else {
                this.MY = ilO;
            }
        } else {
            this.MY = nv.MY;
        }
        this.MY.IlO(nv, (oeT) null);
        this.EO = nv.IlO;
        arrayList.add(nv.NV);
        pP.IlO(nv.Bc);
    }

    public static NV IlO(WebView webView) {
        return new NV(webView);
    }

    private void MY() {
        if (this.vCE) {
            DmF.IlO(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    public cl IlO(String str, Cc<?, ?> cc) {
        return IlO(str, (String) null, cc);
    }

    public cl IlO(String str, String str2, Cc<?, ?> cc) {
        MY();
        this.MY.Bc.IlO(str, cc);
        return this;
    }

    public cl IlO(String str, tV.MY my) {
        return IlO(str, (String) null, my);
    }

    public cl IlO(String str, String str2, tV.MY my) {
        MY();
        this.MY.Bc.IlO(str, my);
        return this;
    }

    public void IlO() {
        if (this.vCE) {
            return;
        }
        this.MY.MY();
        this.vCE = true;
        Iterator<bWL> it = this.Cc.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
