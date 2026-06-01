package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcxz implements zzifh {
    private final zzcxx zza;
    private final zzifq zzb;

    private zzcxz(zzcxx zzcxxVar, zzifq zzifqVar) {
        this.zza = zzcxxVar;
        this.zzb = zzifqVar;
    }

    public static zzcxz zza(zzcxx zzcxxVar, zzifq zzifqVar) {
        return new zzcxz(zzcxxVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZzf = this.zza.zzf(((zzcjv) this.zzb).zza());
        zzifp.zzb(contextZzf);
        return contextZzf;
    }
}
