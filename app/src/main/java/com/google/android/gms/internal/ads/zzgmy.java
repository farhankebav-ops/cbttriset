package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgmy implements zzgmv {
    private static final zzgmv zzb = zzgmx.zza;
    private final zzgnc zza = new zzgnc();
    private volatile zzgmv zzc;
    private Object zzd;

    public zzgmy(zzgmv zzgmvVar) {
        this.zzc = zzgmvVar;
    }

    public final String toString() {
        Object objS = this.zzc;
        if (objS == zzb) {
            String strValueOf = String.valueOf(this.zzd);
            objS = a1.a.s(new StringBuilder(strValueOf.length() + 25), "<supplier that returned ", strValueOf, ">");
        }
        String strValueOf2 = String.valueOf(objS);
        return a1.a.s(new StringBuilder(strValueOf2.length() + 19), "Suppliers.memoize(", strValueOf2, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final Object zza() {
        zzgmv zzgmvVar = this.zzc;
        zzgmv zzgmvVar2 = zzb;
        if (zzgmvVar != zzgmvVar2) {
            synchronized (this.zza) {
                try {
                    if (this.zzc != zzgmvVar2) {
                        Object objZza = this.zzc.zza();
                        this.zzd = objZza;
                        this.zzc = zzgmvVar2;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzd;
    }
}
