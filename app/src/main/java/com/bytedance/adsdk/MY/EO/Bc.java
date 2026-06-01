package com.bytedance.adsdk.MY.EO;

import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc<T> {
    T IlO;
    T MY;

    private static boolean MY(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public void IlO(T t3, T t7) {
        this.IlO = t3;
        this.MY = t7;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return MY(pair.first, this.IlO) && MY(pair.second, this.MY);
    }

    public int hashCode() {
        T t3 = this.IlO;
        int iHashCode = t3 == null ? 0 : t3.hashCode();
        T t7 = this.MY;
        return iHashCode ^ (t7 != null ? t7.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.IlO + " " + this.MY + "}";
    }
}
