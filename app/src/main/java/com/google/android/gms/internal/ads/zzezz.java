package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzezz implements zzeya {
    final zzgus zza;
    final List zzb;

    public zzezz(zzbee zzbeeVar, zzgus zzgusVar, List list) {
        this.zza = zzgusVar;
        this.zzb = list;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzezy
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzfaa(this.zza.zzb);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 48;
    }
}
