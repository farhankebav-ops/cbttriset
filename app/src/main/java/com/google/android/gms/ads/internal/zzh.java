package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfsq;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzh implements zzfsq {
    final /* synthetic */ zzk zza;

    public zzh(zzk zzkVar) {
        Objects.requireNonNull(zzkVar);
        this.zza = zzkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final void zza(int i2, long j) {
        this.zza.zzo().zzb(i2, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final void zzb(int i2, long j, String str) {
        this.zza.zzo().zzf(i2, System.currentTimeMillis() - j, str);
    }
}
