package com.bytedance.sdk.component.adexpress.dynamic.tV;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF {
    public float IlO;
    public float MY;

    public DmF(float f4, float f8) {
        this.IlO = f4;
        this.MY = f8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DmF dmF = (DmF) obj;
            if (Float.compare(dmF.IlO, this.IlO) == 0 && Float.compare(dmF.MY, this.MY) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.IlO), Float.valueOf(this.MY)});
    }
}
