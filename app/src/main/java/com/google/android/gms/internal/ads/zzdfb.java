package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdfb implements zzifh {
    private final zzdeo zza;

    private zzdfb(zzdeo zzdeoVar) {
        this.zza = zzdeoVar;
    }

    public static zzdfb zza(zzdeo zzdeoVar) {
        return new zzdfb(zzdeoVar);
    }

    public static Set zzc(zzdeo zzdeoVar) {
        return zzdeoVar.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return this.zza.zzm();
    }
}
