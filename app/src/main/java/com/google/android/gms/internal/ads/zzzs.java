package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzs implements zzzt {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzdg zzb;

    public zzzs(Executor executor, zzdg zzdgVar) {
        this.zza = executor;
        this.zzb = zzdgVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzzt
    public final void zza() {
        this.zzb.zza(this.zza);
    }
}
