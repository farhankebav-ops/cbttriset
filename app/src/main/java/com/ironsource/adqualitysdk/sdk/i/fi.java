package com.ironsource.adqualitysdk.sdk.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class fi<T> extends ee {

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private T f2052;

    public fi(T t3, Cdo cdo) {
        super(cdo);
        this.f2052 = t3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            T t3 = this.f2052;
            T t7 = ((fi) obj).f2052;
            if (t3 != null) {
                return t3.equals(t7);
            }
            if (t7 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        T t3 = this.f2052;
        if (t3 != null) {
            return t3.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2052);
        return sb.toString();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        return new du(this.f2052);
    }
}
