package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgjl extends zzgjt {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzgjt
    public final zzgjt zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgjt
    public final zzgjt zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgjt
    public final zzgju zzc() {
        return new zzgjm(this.zza, this.zzb, null);
    }
}
