package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ boolean zzg;
    final /* synthetic */ String zzh;
    final /* synthetic */ zzlj zzi;

    public zzkc(zzlj zzljVar, String str, String str2, long j, Bundle bundle, boolean z2, boolean z7, boolean z8, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = bundle;
        this.zze = z2;
        this.zzf = z7;
        this.zzg = z8;
        this.zzh = str3;
        Objects.requireNonNull(zzljVar);
        this.zzi = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzi.zzH(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
    }
}
