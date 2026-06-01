package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzewi implements zzeya {
    private final zzgus zza;
    private final zzdwl zzb;

    public zzewi(zzgus zzgusVar, zzdwl zzdwlVar) {
        this.zza = zzgusVar;
        this.zzb = zzdwlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzewh
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 62;
    }

    public final /* synthetic */ zzewj zzc() {
        return new zzewj(this.zzb.zzb());
    }
}
