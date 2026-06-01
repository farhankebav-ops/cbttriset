package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazb extends zzazr {
    private final zzaxv zzh;

    public zzazb(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8, zzaxv zzaxvVar) {
        super(zzaydVar, "sl6J6ogR1CQFBNHXqYqYlsoHhQEQ3GzqykotbgjuxxtAslvwVDD28XhO/FGDcWNY", "etPaLFHhmzrmC9guV7/txSJ19uqkwWx/gSnrE4vBCvs=", zzaucVar, i2, 94);
        this.zzh = zzaxvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int iIntValue = ((Integer) this.zze.invoke(null, this.zzh.zzb())).intValue();
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzaj(zzauo.zza(iIntValue));
        }
    }
}
