package com.bytedance.sdk.component.vCE.IlO.IlO.IlO;

import android.content.Context;
import com.bytedance.sdk.component.vCE.IlO.IlO.IlO.MY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends MY {
    private static volatile IlO IlO;

    private IlO(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.IlO.MY
    public /* bridge */ /* synthetic */ MY.C0062MY IlO() {
        return super.IlO();
    }

    public static IlO IlO(Context context) {
        if (IlO == null) {
            synchronized (IlO.class) {
                try {
                    if (IlO == null) {
                        IlO = new IlO(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }
}
