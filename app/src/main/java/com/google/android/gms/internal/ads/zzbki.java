package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbki {
    private final com.google.android.gms.ads.formats.zze zza;

    @Nullable
    private final com.google.android.gms.ads.formats.zzd zzb;

    @Nullable
    @GuardedBy("this")
    private zzbjd zzc;

    public zzbki(com.google.android.gms.ads.formats.zze zzeVar, @Nullable com.google.android.gms.ads.formats.zzd zzdVar) {
        this.zza = zzeVar;
        this.zzb = zzdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final synchronized zzbjd zze(zzbjc zzbjcVar) {
        zzbjd zzbjdVar = this.zzc;
        if (zzbjdVar != null) {
            return zzbjdVar;
        }
        zzbjd zzbjdVar2 = new zzbjd(zzbjcVar);
        this.zzc = zzbjdVar2;
        return zzbjdVar2;
    }

    public final zzbjp zza() {
        return new zzbkh(this, null);
    }

    @Nullable
    public final zzbjm zzb() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbkg(this, null);
    }

    public final /* synthetic */ com.google.android.gms.ads.formats.zze zzc() {
        return this.zza;
    }

    public final /* synthetic */ com.google.android.gms.ads.formats.zzd zzd() {
        return this.zzb;
    }
}
