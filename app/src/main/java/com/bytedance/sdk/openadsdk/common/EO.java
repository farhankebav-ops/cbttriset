package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends rp {
    public EO(@NonNull Context context) {
        super(context);
        this.MY = false;
    }

    @Override // com.bytedance.sdk.openadsdk.common.rp
    public void IlO() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.EO.1
            @Override // java.lang.Runnable
            public void run() {
                EO eo = EO.this;
                if (eo.IlO != null) {
                    eo.setVisibility(0);
                }
            }
        });
    }

    public void IlO(oeT oet, String str, int i2, String str2, long j, boolean z2, int i8, long j3) {
        if (getVisibility() != 8) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, i2, str2, SystemClock.elapsedRealtime() - j, z2, i8, j3);
            super.MY();
        }
    }
}
