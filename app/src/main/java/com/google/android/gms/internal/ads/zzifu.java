package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzifu implements zzifq {
    private static final Object zza = new Object();
    private volatile zzifq zzb;
    private volatile Object zzc = zza;

    private zzifu(zzifq zzifqVar) {
        this.zzb = zzifqVar;
    }

    public static zzifq zza(zzifq zzifqVar) {
        return ((zzifqVar instanceof zzifu) || (zzifqVar instanceof zzifg)) ? zzifqVar : new zzifu(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzifq zzifqVar = this.zzb;
        if (zzifqVar == null) {
            return this.zzc;
        }
        Object objZzb = zzifqVar.zzb();
        this.zzc = objZzb;
        this.zzb = null;
        return objZzb;
    }
}
