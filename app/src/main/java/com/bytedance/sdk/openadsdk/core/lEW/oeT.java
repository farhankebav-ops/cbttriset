package com.bytedance.sdk.openadsdk.core.lEW;

import android.os.SystemClock;
import com.ironsource.C2300e4;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oeT implements com.bytedance.sdk.openadsdk.core.NV.vCE.EO {
    private String vCE;
    private long IlO = 0;
    private long MY = 0;
    private int EO = 0;
    private String tV = null;
    private String Cc = null;
    private final AtomicBoolean Bc = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.EO
    public void IlO(String str) {
        this.vCE = str;
        this.IlO = SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.EO
    public void MY(String str) {
        this.Cc = str;
        this.MY = SystemClock.elapsedRealtime();
        this.Bc.set(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.EO
    public void IlO(int i2, String str, String str2) {
        this.EO = i2;
        this.tV = str;
        this.Cc = str2;
        this.MY = SystemClock.elapsedRealtime();
        this.Bc.set(false);
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, String str) {
        if (this.Bc.get()) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, false, str, "success", this.MY - this.IlO, this.Cc, this.vCE, 0, null);
        } else {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, false, str, C2300e4.f.e, this.MY - this.IlO, this.Cc, this.vCE, this.EO, this.tV);
        }
    }
}
