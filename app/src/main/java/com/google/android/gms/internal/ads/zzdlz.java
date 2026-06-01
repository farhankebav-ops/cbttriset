package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdlz {
    zzbjj zza;
    zzbjg zzb;
    zzbjw zzc;
    zzbjt zzd;
    zzbor zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdlz zza(zzbjj zzbjjVar) {
        this.zza = zzbjjVar;
        return this;
    }

    public final zzdlz zzb(zzbjg zzbjgVar) {
        this.zzb = zzbjgVar;
        return this;
    }

    public final zzdlz zzc(zzbjw zzbjwVar) {
        this.zzc = zzbjwVar;
        return this;
    }

    public final zzdlz zzd(zzbjt zzbjtVar) {
        this.zzd = zzbjtVar;
        return this;
    }

    public final zzdlz zze(zzbor zzborVar) {
        this.zze = zzborVar;
        return this;
    }

    public final zzdlz zzf(String str, zzbjp zzbjpVar, @Nullable zzbjm zzbjmVar) {
        this.zzf.put(str, zzbjpVar);
        if (zzbjmVar != null) {
            this.zzg.put(str, zzbjmVar);
        }
        return this;
    }

    public final zzdma zzg() {
        return new zzdma(this, null);
    }
}
