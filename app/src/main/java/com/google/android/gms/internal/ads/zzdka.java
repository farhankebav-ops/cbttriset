package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdka implements zzifh {
    private final zzifq zza;

    private zzdka(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdka zza(zzifq zzifqVar) {
        return new zzdka(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((zzdjx) this.zza).zza().zzd() != null ? Collections.singleton("banner") : Collections.EMPTY_SET;
        zzifp.zzb(setSingleton);
        return setSingleton;
    }
}
