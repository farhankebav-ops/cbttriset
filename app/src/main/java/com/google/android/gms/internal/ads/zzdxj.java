package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdxj implements zzguf {
    final /* synthetic */ zzdxt zza;

    public zzdxj(zzdxt zzdxtVar) {
        Objects.requireNonNull(zzdxtVar);
        this.zza = zzdxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        synchronized (this) {
            zzdxt zzdxtVar = this.zza;
            zzdxtVar.zzn(true);
            zzdxtVar.zzm("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzdxtVar.zzo()));
            zzdxtVar.zzp().zzd(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        final String str = (String) obj;
        synchronized (this) {
            zzdxt zzdxtVar = this.zza;
            zzdxtVar.zzn(true);
            zzdxtVar.zzm("com.google.android.gms.ads.MobileAds", true, "", (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzdxtVar.zzo()));
            zzdxtVar.zzq().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zza.zzl(str);
                }
            });
        }
    }
}
