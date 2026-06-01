package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzecy {
    private final zzcjn zza;
    private final Context zzb;
    private final Executor zzc;

    public zzecy(zzcjn zzcjnVar, Context context, Executor executor) {
        this.zza = zzcjnVar;
        this.zzb = context;
        this.zzc = executor;
    }

    public final void zza() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzecx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb();
            }
        });
    }

    public final /* synthetic */ void zzb() {
        zzeda zzedaVarZzh = this.zza.zzh();
        zzedaVarZzh.zzb(this.zzb);
        zzedaVarZzh.zza().zza().zza();
    }
}
