package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazc extends zzazr {
    private final zzaxg zzh;
    private final long zzi;
    private final long zzj;

    public zzazc(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8, zzaxg zzaxgVar, long j, long j3) {
        super(zzaydVar, "1MiCMWad12oLn5alnMxHwTvbBZm7RpaUcGFZ/LjrpVbPksWcBk53Qc+euKdOo/dG", "/cnUVQvNHFqi3ggOmiA4o/IdQSFHoegJ/H9a2xERT14=", zzaucVar, i2, 11);
        this.zzh = zzaxgVar;
        this.zzi = j;
        this.zzj = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaxg zzaxgVar = this.zzh;
        if (zzaxgVar != null) {
            zzaxe zzaxeVar = new zzaxe((String) this.zze.invoke(null, zzaxgVar.zzb(), Long.valueOf(this.zzi), Long.valueOf(this.zzj)));
            zzauc zzaucVar = this.zzd;
            synchronized (zzaucVar) {
                try {
                    zzaucVar.zzf(zzaxeVar.zza.longValue());
                    if (zzaxeVar.zzb.longValue() >= 0) {
                        zzaucVar.zzW(zzaxeVar.zzb.longValue());
                    }
                    if (zzaxeVar.zzc.longValue() >= 0) {
                        zzaucVar.zzX(zzaxeVar.zzc.longValue());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
