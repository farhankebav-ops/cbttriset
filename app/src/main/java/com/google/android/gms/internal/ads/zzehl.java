package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzehl implements zzehk {

    @VisibleForTesting
    public final zzehk zza;
    private final zzglu zzb;

    public zzehl(zzehk zzehkVar, zzglu zzgluVar) {
        this.zza = zzehkVar;
        this.zzb = zzgluVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final boolean zza(zzfgf zzfgfVar, zzffu zzffuVar) {
        return this.zza.zza(zzfgfVar, zzffuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final j2.q zzb(zzfgf zzfgfVar, zzffu zzffuVar) {
        return zzgui.zzk(this.zza.zzb(zzfgfVar, zzffuVar), this.zzb, zzcbv.zza);
    }
}
