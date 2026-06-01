package com.bytedance.adsdk.ugeno.vCE;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static int IlO(boolean z2, int i2, int i8) {
        if (i8 == 0 || !z2) {
            return i2;
        }
        int i9 = i2 - 512;
        int iAbs = Math.abs(i9) % i8;
        return (i9 >= 0 || iAbs == 0) ? iAbs : i8 - iAbs;
    }

    public static boolean IlO(int i2, Collection<?> collection) {
        return i2 >= 0 && i2 < collection.size();
    }
}
