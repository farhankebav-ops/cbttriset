package com.bytedance.sdk.component.lEW;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private static NV IlO = new NV() { // from class: com.bytedance.sdk.component.lEW.Cc.1
        @Override // com.bytedance.sdk.component.lEW.NV
        public DmF createThreadFactory(int i2, String str) {
            return new DmF(i2, str);
        }
    };

    public static void IlO(NV nv) {
        IlO = nv;
    }

    public static NV IlO() {
        return IlO;
    }
}
