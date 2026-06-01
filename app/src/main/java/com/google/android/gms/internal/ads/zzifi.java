package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzifi implements zzifh, zzifb {
    private static final zzifi zza = new zzifi(null);
    private final Object zzb;

    private zzifi(Object obj) {
        this.zzb = obj;
    }

    public static zzifh zza(Object obj) {
        zzifp.zza(obj, "instance cannot be null");
        return new zzifi(obj);
    }

    public static zzifh zzc(Object obj) {
        return obj == null ? zza : new zzifi(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final Object zzb() {
        return this.zzb;
    }
}
