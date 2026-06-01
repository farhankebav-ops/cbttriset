package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcue {
    private final zzfgf zza;
    private final zzffu zzb;
    private final String zzc;

    public zzcue(zzfgf zzfgfVar, zzffu zzffuVar, @Nullable String str) {
        this.zza = zzfgfVar;
        this.zzb = zzffuVar;
        this.zzc = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzfgf zza() {
        return this.zza;
    }

    public final zzffu zzb() {
        return this.zzb;
    }

    public final zzffx zzc() {
        return this.zza.zzb.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }
}
