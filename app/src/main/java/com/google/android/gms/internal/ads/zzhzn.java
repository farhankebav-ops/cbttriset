package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhzn extends IllegalArgumentException {
    public zzhzn(int i2, int i8) {
        super(a1.a.f(i2, i8, "Unpaired surrogate at index ", " of ", new StringBuilder(String.valueOf(i2).length() + 32 + String.valueOf(i8).length())));
    }
}
