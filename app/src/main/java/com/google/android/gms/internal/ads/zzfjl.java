package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfjl implements zzifh {
    public static zzfjl zza() {
        return zzfjk.zza;
    }

    public static zzgus zzc() {
        zzgus zzgusVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgp)).booleanValue()) {
            zzgusVar = zzcbv.zzc;
        } else {
            zzgusVar = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgo)).booleanValue() ? zzcbv.zza : zzcbv.zzf;
        }
        zzifp.zzb(zzgusVar);
        return zzgusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzc();
    }
}
