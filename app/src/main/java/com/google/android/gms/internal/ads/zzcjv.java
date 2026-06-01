package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcjv implements zzifh {
    private final zzcjp zza;

    private zzcjv(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
    }

    public static zzcjv zzc(zzcjp zzcjpVar) {
        return new zzcjv(zzcjpVar);
    }

    public static Context zzd(zzcjp zzcjpVar) {
        Context contextZza = zzcjpVar.zza();
        zzifp.zzb(contextZza);
        return contextZza;
    }

    public final Context zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
