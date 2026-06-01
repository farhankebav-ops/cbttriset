package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfkv implements zzifh {
    private final zzifq zza;

    private zzfkv(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzfkv zzc(zzifq zzifqVar) {
        return new zzfkv(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfkr zzb() {
        return new zzfkr(((zzift) this.zza).zzb());
    }
}
