package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayw implements Callable {
    private final zzayd zza;
    private final zzauc zzb;

    public zzayw(zzayd zzaydVar, zzauc zzaucVar) {
        this.zza = zzaydVar;
        this.zzb = zzaucVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzayd zzaydVar = this.zza;
        if (zzaydVar.zzm() != null) {
            zzaydVar.zzm().get();
        }
        zzauz zzauzVarZzl = zzaydVar.zzl();
        if (zzauzVarZzl == null) {
            return null;
        }
        try {
            zzauc zzaucVar = this.zzb;
            synchronized (zzaucVar) {
                zzaucVar.zzaY(zzauzVarZzl.zzaN(), zzhvy.zza());
            }
            return null;
        } catch (zzhxd | NullPointerException unused) {
            return null;
        }
    }
}
