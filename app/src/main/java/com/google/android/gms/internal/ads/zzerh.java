package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzerh implements zzeya {
    private final Executor zza;
    private final zzcbj zzb;

    public zzerh(Executor executor, zzcbj zzcbjVar) {
        this.zza = executor;
        this.zzb = zzcbjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzds)).booleanValue()) {
            return zzgui.zza(new zzeri(null));
        }
        zzcbj zzcbjVar = this.zzb;
        return zzgui.zzk(zzcbjVar.zzq(), zzerg.zza, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 10;
    }
}
