package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzea {
    final /* synthetic */ zzee zza;
    private final WeakReference zzb;
    private final Executor zzc;

    public zzea(zzee zzeeVar, zzdy zzdyVar, Executor executor) {
        Objects.requireNonNull(zzeeVar);
        this.zza = zzeeVar;
        this.zzb = new WeakReference(zzdyVar);
        this.zzc = executor;
    }

    public final boolean zza() {
        return this.zzb.get() == null;
    }

    public final void zzb() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc();
            }
        });
    }

    public final /* synthetic */ void zzc() {
        zzdy zzdyVar = (zzdy) this.zzb.get();
        if (zzdyVar != null) {
            zzdyVar.zza(this.zza.zzc());
        }
    }
}
