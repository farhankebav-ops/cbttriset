package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgfb implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzgfb(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzgfb zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzgfb(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbaa zzbaaVarZzb = zzfsp.zzb((Context) this.zza.zzb(), (zzfrs) this.zzb.zzb());
        zzifp.zzb(zzbaaVarZzb);
        return zzbaaVarZzb;
    }
}
