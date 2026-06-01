package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeng implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzdhx zza;

    public zzeng(zzenh zzenhVar, zzdhx zzdhxVar) {
        this.zza = zzdhxVar;
        Objects.requireNonNull(zzenhVar);
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        this.zza.zzc().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        zzdhx zzdhxVar = this.zza;
        zzdhxVar.zzd().zza();
        zzdhxVar.zze().zza();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
    }
}
