package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbcy implements zzbbo {
    final /* synthetic */ zzbdb zza;

    public zzbcy(zzbdb zzbdbVar) {
        Objects.requireNonNull(zzbdbVar);
        this.zza = zzbdbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final void zza(boolean z2) {
        if (z2) {
            this.zza.zzf();
        } else {
            this.zza.zzg();
        }
    }
}
