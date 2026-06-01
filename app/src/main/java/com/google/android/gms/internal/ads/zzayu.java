package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayu extends zzazr {
    private final long zzh;

    public zzayu(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, long j, int i2, int i8) {
        super(zzaydVar, "6Tbgi6IQESKZikJOpZcClcVJxza1rhAf3nfasZu/vDcTd3loITpTNbH23xjyLA5L", "g107GCb4k6+PXON8scRHoxvRnyAK9ZOpFHjKTWKkbXc=", zzaucVar, i2, 25);
        this.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zze.invoke(null, null)).longValue();
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            try {
                zzaucVar.zzac(jLongValue);
                long j = this.zzh;
                if (j != 0) {
                    zzaucVar.zzk(jLongValue - j);
                    zzaucVar.zzn(j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
