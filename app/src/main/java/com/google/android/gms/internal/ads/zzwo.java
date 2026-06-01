package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwo extends zzbf {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;
    private final boolean zze;

    @Nullable
    private final zzak zzf;

    @Nullable
    private final zzaf zzg;

    static {
        zzz zzzVar = new zzz();
        zzzVar.zza("SinglePeriodTimeline");
        zzzVar.zzb(Uri.EMPTY);
        zzzVar.zzc();
    }

    public zzwo(long j, long j3, long j8, long j9, long j10, long j11, long j12, boolean z2, boolean z7, boolean z8, @Nullable Object obj, zzak zzakVar, @Nullable zzaf zzafVar) {
        this.zzc = j9;
        this.zzd = j10;
        this.zze = z2;
        zzakVar.getClass();
        this.zzf = zzakVar;
        this.zzg = zzafVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbe zzb(int i2, zzbe zzbeVar, long j) {
        zzgmd.zzm(i2, 1, FirebaseAnalytics.Param.INDEX);
        boolean z2 = this.zze;
        zzbeVar.zza(zzbe.zza, this.zzf, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, z2, false, this.zzg, 0L, this.zzd, 0, 0, 0L);
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i2, zzbd zzbdVar, boolean z2) {
        zzgmd.zzm(i2, 1, FirebaseAnalytics.Param.INDEX);
        zzbdVar.zza(null, z2 ? zzb : null, 0, this.zzc, 0L, zzc.zza, false);
        return zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zze(Object obj) {
        return zzb.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final Object zzf(int i2) {
        zzgmd.zzm(i2, 1, FirebaseAnalytics.Param.INDEX);
        return zzb;
    }
}
