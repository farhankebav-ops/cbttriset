package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfxh implements zzifh {
    private final zzifq zza;

    private zzfxh(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzfxh zza(zzifq zzifqVar) {
        return new zzfxh(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgus zzgusVarZzb = zzguz.zzb((ExecutorService) this.zza.zzb());
        zzifp.zzb(zzgusVarZzb);
        return zzgusVarZzb;
    }
}
