package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zziff implements zzifh {
    private zzifq zza;

    public static void zza(zzifq zzifqVar, zzifq zzifqVar2) {
        zziff zziffVar = (zziff) zzifqVar;
        if (zziffVar.zza != null) {
            throw new IllegalStateException();
        }
        zziffVar.zza = zzifqVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final Object zzb() {
        zzifq zzifqVar = this.zza;
        if (zzifqVar != null) {
            return zzifqVar.zzb();
        }
        throw new IllegalStateException();
    }
}
