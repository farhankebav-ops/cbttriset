package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcf extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzcf(String str, zzcd zzcdVar) {
        String strValueOf = String.valueOf(zzcdVar);
        super(a1.a.s(new StringBuilder(str.length() + 1 + strValueOf.length()), str, " ", strValueOf));
    }
}
