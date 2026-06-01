package com.bytedance.adsdk.MY;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class rp<V> {
    private final V IlO;
    private final Throwable MY;

    public rp(V v2) {
        this.IlO = v2;
        this.MY = null;
    }

    public V IlO() {
        return this.IlO;
    }

    public Throwable MY() {
        return this.MY;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rp)) {
            return false;
        }
        rp rpVar = (rp) obj;
        if (IlO() != null && IlO().equals(rpVar.IlO())) {
            return true;
        }
        if (MY() == null || rpVar.MY() == null) {
            return false;
        }
        return MY().toString().equals(MY().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{IlO(), MY()});
    }

    public rp(Throwable th) {
        this.MY = th;
        this.IlO = null;
    }
}
