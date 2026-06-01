package com.bytedance.sdk.component.DmF.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static volatile IlO MY;
    private volatile MY IlO;

    private IlO() {
    }

    public static IlO IlO() {
        if (MY == null) {
            synchronized (IlO.class) {
                try {
                    if (MY == null) {
                        MY = new IlO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    public MY MY() {
        return this.IlO;
    }

    public void IlO(MY my) {
        this.IlO = my;
    }
}
