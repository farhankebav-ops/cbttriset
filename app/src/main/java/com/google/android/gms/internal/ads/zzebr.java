package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzebr implements zzguf {
    final /* synthetic */ Context zza;

    public zzebr(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        if (((Boolean) zzbgm.zzh.zze()).booleanValue() && (th instanceof com.google.android.gms.ads.internal.util.zzaz)) {
            zzbef.zze(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        if (((Boolean) zzbgm.zzj.zze()).booleanValue()) {
            zzbef.zze(this.zza);
        }
    }
}
