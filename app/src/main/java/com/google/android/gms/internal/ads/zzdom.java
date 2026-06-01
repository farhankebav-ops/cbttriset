package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdom implements zzguf {
    final /* synthetic */ zzcca zza;

    public zzdom(zzdoy zzdoyVar, zzcca zzccaVar) {
        this.zza = zzccaVar;
        Objects.requireNonNull(zzdoyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to load media data due to video view load failure.");
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcgy zzcgyVar = (zzcgy) obj;
        if (zzcgyVar == null) {
            this.zza.zzd(new zzekz(1, "Missing webview from video view future."));
            return;
        }
        final zzcca zzccaVar = this.zza;
        zzcgyVar.zzab("/video", new zzceq(new zzcep() { // from class: com.google.android.gms.internal.ads.zzdol
            @Override // com.google.android.gms.internal.ads.zzcep
            public final /* synthetic */ void zza(String str) {
                zzccaVar.zzc(androidx.camera.core.processing.util.a.c("mediaUrl", str));
            }
        }));
        zzcgyVar.zzI();
    }
}
