package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp extends YogaNodeJNIBase {
    public void finalize() throws Throwable {
        try {
            hp();
        } finally {
            super.finalize();
        }
    }

    public void hp() {
        long j = this.IlO;
        if (j != 0) {
            this.IlO = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
