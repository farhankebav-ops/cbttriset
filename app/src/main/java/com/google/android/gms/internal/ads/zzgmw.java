package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgmw implements Serializable, zzgmv {
    final zzgmv zza;
    volatile transient boolean zzb;
    transient Object zzc;
    private final transient zzgnc zzd = new zzgnc();

    public zzgmw(zzgmv zzgmvVar) {
        this.zza = zzgmvVar;
    }

    public final String toString() {
        Object objS;
        if (this.zzb) {
            String strValueOf = String.valueOf(this.zzc);
            objS = a1.a.s(new StringBuilder(strValueOf.length() + 25), "<supplier that returned ", strValueOf, ">");
        } else {
            objS = this.zza;
        }
        String string = objS.toString();
        return a1.a.s(new StringBuilder(string.length() + 19), "Suppliers.memoize(", string, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this.zzd) {
                try {
                    if (!this.zzb) {
                        Object objZza = this.zza.zza();
                        this.zzc = objZza;
                        this.zzb = true;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzc;
    }
}
