package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.vCE;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends vCE {
    private static volatile Cc IlO;

    private Cc(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.vCE
    public /* bridge */ /* synthetic */ vCE.EO IlO() {
        return super.IlO();
    }

    public static Cc IlO(Context context) {
        if (IlO == null) {
            synchronized (Cc.class) {
                try {
                    if (IlO == null) {
                        IlO = new Cc(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }
}
