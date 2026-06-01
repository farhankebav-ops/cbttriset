package com.bytedance.sdk.component.vCE.IlO.vCE;

import com.bytedance.sdk.component.vCE.IlO.lEW;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static volatile MY IlO;

    public static MY IlO() {
        if (IlO == null) {
            synchronized (MY.class) {
                try {
                    if (IlO == null) {
                        IlO = new EO(lEW.Bc().vCE(), new vCE(lEW.Bc().vCE()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }
}
