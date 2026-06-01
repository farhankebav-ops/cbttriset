package com.bytedance.sdk.openadsdk.ea.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class tV implements MY {
    private static volatile tV IlO;

    private tV() {
    }

    @Override // com.bytedance.sdk.openadsdk.ea.EO.MY
    public void IlO(com.bytedance.sdk.openadsdk.ea.MY my) {
    }

    @Override // com.bytedance.sdk.openadsdk.ea.EO.MY
    public void IlO(com.bytedance.sdk.openadsdk.ea.MY my, boolean z2) {
    }

    public static tV IlO() {
        if (IlO == null) {
            synchronized (tV.class) {
                try {
                    if (IlO == null) {
                        IlO = new tV();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }
}
