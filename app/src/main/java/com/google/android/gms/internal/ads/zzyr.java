package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzyr {

    @Nullable
    private zzyq zza;

    @Nullable
    private zzza zzb;

    @CallSuper
    public void zzb() {
        this.zza = null;
        this.zzb = null;
    }

    public boolean zzd() {
        throw null;
    }

    public void zze(zzd zzdVar) {
        throw null;
    }

    @Nullable
    public zzlo zzg() {
        throw null;
    }

    public abstract void zzp(@Nullable Object obj);

    public abstract zzys zzq(zzlp[] zzlpVarArr, zzwv zzwvVar, zzuu zzuuVar, zzbf zzbfVar) throws zzib;

    @CallSuper
    public final void zzr(zzyq zzyqVar, zzza zzzaVar) {
        zzgmd.zzh(this.zza == null);
        this.zza = zzyqVar;
        this.zzb = zzzaVar;
    }

    public final void zzs() {
        zzyq zzyqVar = this.zza;
        if (zzyqVar != null) {
            zzyqVar.zzq();
        }
    }

    public final zzza zzt() {
        zzza zzzaVar = this.zzb;
        zzzaVar.getClass();
        return zzzaVar;
    }
}
