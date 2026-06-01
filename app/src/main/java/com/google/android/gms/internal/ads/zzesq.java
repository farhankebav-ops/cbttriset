package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzesq implements zzeya {
    private final zzgus zza;

    public zzesq(zzgus zzgusVar) {
        this.zza = zzgusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zza.zzc(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzesp
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzesr(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzb());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 55;
    }
}
