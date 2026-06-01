package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfcs implements zzfiw {
    public final zzfdl zza;
    public final zzfdn zzb;
    public final com.google.android.gms.ads.internal.client.zzm zzc;
    public final String zzd;
    public final Executor zze;
    public final com.google.android.gms.ads.internal.client.zzx zzf;
    public final zzfim zzg;

    public zzfcs(zzfdl zzfdlVar, zzfdn zzfdnVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, Executor executor, com.google.android.gms.ads.internal.client.zzx zzxVar, zzfim zzfimVar) {
        this.zza = zzfdlVar;
        this.zzb = zzfdnVar;
        this.zzc = zzmVar;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzxVar;
        this.zzg = zzfimVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfiw
    public final Executor zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfiw
    public final zzfim zzb() {
        return this.zzg;
    }
}
