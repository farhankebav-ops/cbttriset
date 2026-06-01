package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcew extends com.google.android.gms.ads.internal.util.zzb {
    final zzcdr zza;
    final zzcfe zzb;
    private final String zzc;
    private final String[] zzd;

    public zzcew(zzcdr zzcdrVar, zzcfe zzcfeVar, String str, String[] strArr) {
        this.zza = zzcdrVar;
        this.zzb = zzcfeVar;
        this.zzc = str;
        this.zzd = strArr;
        com.google.android.gms.ads.internal.zzt.zzB().zzc(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        try {
            this.zzb.zzf(this.zzc, this.zzd);
        } finally {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzceu(this));
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final j2.q zzb() {
        return (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcn)).booleanValue() && (this.zzb instanceof zzcfn)) ? zzcbv.zzf.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzcev
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zze();
            }
        }) : super.zzb();
    }

    public final String zzd() {
        return this.zzc;
    }

    public final /* synthetic */ Boolean zze() {
        return Boolean.valueOf(this.zzb.zzg(this.zzc, this.zzd, this));
    }
}
