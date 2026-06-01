package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbpz implements zzcce {
    final /* synthetic */ zzbqa zza;

    public zzbpz(zzbqa zzbqaVar) {
        Objects.requireNonNull(zzbqaVar);
        this.zza = zzbqaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        final zzbow zzbowVar = (zzbow) obj;
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbpy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzbow zzbowVar2 = zzbowVar;
                zzbowVar2.zzn("/result", zzblw.zzo);
                zzbowVar2.zzj();
            }
        });
    }
}
