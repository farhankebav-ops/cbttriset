package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeva implements zzeya {
    private final Context zza;
    private final zzgus zzb;

    public zzeva(zzgus zzgusVar, Context context) {
        this.zzb = zzgusVar;
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zzb.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuz
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 57;
    }

    public final /* synthetic */ zzevb zzc() {
        com.google.android.gms.ads.internal.zzt.zzc();
        return new zzevb(com.google.android.gms.ads.internal.util.zzs.zzw(this.zza));
    }
}
