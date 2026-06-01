package com.ironsource.adqualitysdk.sdk.i;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hv {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private List<List<Field>> f2398;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private int f2399;

    public hv() {
        ArrayList arrayList = new ArrayList();
        this.f2398 = arrayList;
        int i2 = (-1) + 1;
        this.f2399 = i2;
        arrayList.add(i2, new ArrayList());
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final List<List<Field>> m2390() {
        return this.f2398;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2391(Field field) {
        this.f2398.get(this.f2399).remove(field);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2393(Field field) {
        this.f2398.get(this.f2399).add(field);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m2394() {
        int i2 = this.f2399 + 1;
        this.f2399 = i2;
        this.f2398.add(i2, new ArrayList());
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2392() {
        this.f2398.remove(this.f2399);
        this.f2399--;
    }
}
