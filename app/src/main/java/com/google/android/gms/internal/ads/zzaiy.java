package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaiy {
    public final zzajf zza;
    public final zzaji zzb;
    public final zzaem zzc;

    @Nullable
    public final zzaen zzd;
    public int zze;

    @Nullable
    public zzv zzf;

    public zzaiy(zzajf zzajfVar, zzaji zzajiVar, zzaem zzaemVar) {
        this.zza = zzajfVar;
        this.zzb = zzajiVar;
        this.zzc = zzaemVar;
        this.zzd = "audio/true-hd".equals(zzajfVar.zzg.zzo) ? new zzaen() : null;
    }
}
