package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhg extends IllegalStateException {
    public zzhg(int i2, int i8) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 21 + String.valueOf(i8).length() + 1);
        com.google.android.gms.ads.internal.client.a.k(i2, i8, "Buffer too small (", " < ", sb);
        sb.append(")");
        super(sb.toString());
    }
}
