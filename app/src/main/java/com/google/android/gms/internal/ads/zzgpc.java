package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgpc extends zzgnd {
    private final zzgpe zza;

    public zzgpc(zzgpe zzgpeVar, int i2) {
        super(zzgpeVar.size(), i2);
        this.zza = zzgpeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgnd
    public final Object zza(int i2) {
        return this.zza.get(i2);
    }
}
