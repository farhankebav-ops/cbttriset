package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzerd implements zzeya {
    private final zzgus zza;
    private final zzfgn zzb;
    private final zzcbn zzc;

    public zzerd(zzgus zzgusVar, zzfgn zzfgnVar, zzcbn zzcbnVar) {
        this.zza = zzgusVar;
        this.zzb = zzfgnVar;
        this.zzc = zzcbnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzerc
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 9;
    }

    public final /* synthetic */ zzere zzc() {
        return new zzere(this.zzb.zzk, this.zzc.zzl());
    }
}
