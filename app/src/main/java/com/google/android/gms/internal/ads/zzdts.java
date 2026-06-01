package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdts implements zzifh {
    private final zzifq zza;

    private zzdts(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar2;
    }

    public static zzdts zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdts(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgus zzgusVarZzc = zzfjn.zzc();
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfJ)).booleanValue() ? Collections.singleton(new zzdgn(((zzdul) this.zza).zzb(), zzgusVarZzc)) : Collections.EMPTY_SET;
        zzifp.zzb(setSingleton);
        return setSingleton;
    }
}
