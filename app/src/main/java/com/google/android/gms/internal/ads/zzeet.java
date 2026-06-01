package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeet implements zzdac, zzcyr {
    private static final Object zza = new Object();
    private static int zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private final zzefd zzd;

    public zzeet(zzefd zzefdVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzd = zzefdVar;
        this.zzc = zzgVar;
    }

    private final void zzb(boolean z2) {
        int i2;
        int iIntValue;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgL)).booleanValue() && !this.zzc.zzx()) {
            Object obj = zza;
            synchronized (obj) {
                i2 = zzb;
                iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgM)).intValue();
            }
            if (i2 < iIntValue) {
                this.zzd.zza(z2);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyr
    public final void zzdN(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdac
    public final void zzg() {
        zzb(true);
    }
}
