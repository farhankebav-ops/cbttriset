package com.bytedance.sdk.openadsdk.core.EV;

import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.core.cl;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import n7.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    final Set<Pair<View, FriendlyObstructionPurpose>> IlO = new HashSet();
    private Bc MY;

    private vCE() {
        Cc.IlO(cl.IlO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bc() {
        Bc bc = this.MY;
        if (bc != null) {
            try {
                bc.tV();
            } catch (Throwable unused) {
            }
        }
    }

    private Handler Cc() {
        return com.bytedance.sdk.component.utils.DmF.MY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lEW() {
        Bc bc = this.MY;
        if (bc != null) {
            try {
                bc.EO();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vCE() {
        if (this.MY != null) {
            try {
                IlO((View) null, (FriendlyObstructionPurpose) null);
                this.MY.MY();
            } catch (Throwable unused) {
            }
        }
    }

    @UiThread
    public void tV() {
        if (b.b()) {
            lEW();
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.8
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.lEW();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(WebView webView) {
        try {
            if (this.MY == null) {
                this.MY = lEW.IlO(webView);
            }
        } catch (Throwable th) {
            oeT.EO("createWebViewSession failed : ".concat(String.valueOf(th)), new Object[0]);
            HashMap map = new HashMap();
            map.put("scene", "createWebViewSession");
            map.put("message", th.getMessage());
            Cc.IlO(map);
        }
    }

    @UiThread
    public void EO() {
        if (b.b()) {
            Bc();
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.7
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.Bc();
                }
            });
        }
    }

    public static vCE IlO() {
        return new vCE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(View view, Set<NV> set) {
        try {
            if (this.MY == null) {
                this.MY = lEW.IlO(view, set);
            }
        } catch (Throwable th) {
            oeT.EO("createVideoSession failed : ".concat(String.valueOf(th)), new Object[0]);
            HashMap map = new HashMap();
            map.put("scene", "createVideoSession");
            map.put("message", th.getMessage());
            Cc.IlO(map);
        }
    }

    @UiThread
    public void IlO(final WebView webView) {
        if (webView == null || this.MY != null) {
            return;
        }
        if (b.b()) {
            MY(webView);
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.1
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.MY(webView);
                }
            });
        }
    }

    public void IlO(final View view, final Set<NV> set) {
        if (this.MY != null || view == null || set == null) {
            return;
        }
        if (b.b()) {
            MY(view, set);
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.4
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.MY(view, (Set<NV>) set);
                }
            });
        }
    }

    @UiThread
    public void MY() {
        if (b.b()) {
            vCE();
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.5
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.vCE();
                }
            });
        }
    }

    @UiThread
    public void IlO(final boolean z2, final float f4) {
        if (b.b()) {
            MY(z2, f4);
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.6
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.MY(z2, f4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(boolean z2, float f4) {
        if (this.MY != null) {
            try {
                IlO((View) null, (FriendlyObstructionPurpose) null);
                this.MY.IlO(z2, f4);
            } catch (Throwable unused) {
            }
        }
    }

    @UiThread
    public void IlO(@Nullable final View view, @Nullable final FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (b.b()) {
            MY(view, friendlyObstructionPurpose);
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.9
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.MY(view, friendlyObstructionPurpose);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(@Nullable View view, @Nullable FriendlyObstructionPurpose friendlyObstructionPurpose) {
        Bc bc = this.MY;
        try {
            if (bc == null) {
                if (view == null || friendlyObstructionPurpose == null) {
                    return;
                }
                this.IlO.add(new Pair<>(view, friendlyObstructionPurpose));
                return;
            }
            if (view != null && friendlyObstructionPurpose != null) {
                bc.IlO(view, friendlyObstructionPurpose);
            }
            if (this.IlO.size() > 0) {
                bc.IlO(this.IlO);
                this.IlO.clear();
            }
        } catch (Throwable unused) {
        }
    }

    @UiThread
    public void IlO(final long j, final boolean z2) {
        if (b.b()) {
            MY(j, z2);
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.10
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.MY(j, z2);
                }
            });
        }
    }

    @UiThread
    public void IlO(final boolean z2) {
        if (b.b()) {
            MY(z2);
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.2
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.MY(z2);
                }
            });
        }
    }

    public void MY(long j, boolean z2) {
        Bc bc = this.MY;
        if (bc != null) {
            try {
                bc.IlO(j / 1000.0f, z2);
            } catch (Throwable unused) {
            }
        }
    }

    @UiThread
    public void IlO(final int i2) {
        if (b.b()) {
            MY(i2);
        } else {
            Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.vCE.3
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.MY(i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(boolean z2) {
        Bc bc = this.MY;
        if (bc != null) {
            try {
                bc.IlO(z2);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(int i2) {
        Bc bc = this.MY;
        if (bc != null) {
            try {
                bc.MY(i2);
            } catch (Throwable unused) {
            }
        }
    }
}
