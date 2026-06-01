package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeer {
    private final zzeen zza;
    private final zzgus zzb;

    public zzeer(zzeen zzeenVar, zzgus zzgusVar) {
        this.zza = zzeenVar;
        this.zzb = zzgusVar;
    }

    public final void zza(zzfjx zzfjxVar) {
        final zzeen zzeenVar = this.zza;
        Objects.requireNonNull(zzeenVar);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzeeq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzeenVar.getWritableDatabase();
            }
        };
        zzgus zzgusVar = this.zzb;
        zzgui.zzr(zzgusVar.zzc(callable), new zzeep(this, zzfjxVar), zzgusVar);
    }
}
