package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgpf {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    public zzgpf(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public final IllegalArgumentException zza() {
        Object obj = this.zzc;
        Object obj2 = this.zzb;
        Object obj3 = this.zza;
        String strValueOf = String.valueOf(obj3);
        String strValueOf2 = String.valueOf(obj2);
        String strValueOf3 = String.valueOf(obj3);
        String strValueOf4 = String.valueOf(obj);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        StringBuilder sb = new StringBuilder(length + 33 + length2 + 5 + strValueOf3.length() + 1 + strValueOf4.length());
        androidx.camera.core.processing.util.a.A(sb, "Multiple entries with same key: ", strValueOf, C2300e4.i.f8399b, strValueOf2);
        return new IllegalArgumentException(androidx.camera.core.processing.util.a.n(sb, " and ", strValueOf3, C2300e4.i.f8399b, strValueOf4));
    }
}
