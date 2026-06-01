package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzekt implements zzguf {
    final /* synthetic */ long zza;
    final /* synthetic */ zzffx zzb;
    final /* synthetic */ zzffu zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfnc zze;
    final /* synthetic */ zzfgf zzf;
    final /* synthetic */ zzekv zzg;

    public zzekt(zzekv zzekvVar, long j, zzffx zzffxVar, zzffu zzffuVar, String str, zzfnc zzfncVar, zzfgf zzfgfVar) {
        this.zza = j;
        this.zzb = zzffxVar;
        this.zzc = zzffuVar;
        this.zzd = str;
        this.zze = zzfncVar;
        this.zzf = zzfgfVar;
        Objects.requireNonNull(zzekvVar);
        this.zzg = zzekvVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzguf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Throwable r14) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekt.zza(java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        long j;
        zzekv zzekvVar = this.zzg;
        long jElapsedRealtime = zzekvVar.zzj().elapsedRealtime() - this.zza;
        synchronized (zzekvVar) {
            try {
                if (zzekvVar.zzn()) {
                    j = jElapsedRealtime;
                    zzekvVar.zzk().zza(this.zzb, this.zzc, 0, null, j);
                } else {
                    j = jElapsedRealtime;
                }
                if (zzekvVar.zzp()) {
                    return;
                }
                zzffu zzffuVar = this.zzc;
                if (zzekvVar.zzi(zzffuVar)) {
                    ((zzeku) zzekvVar.zzm().get(zzffuVar)).zzd = j;
                } else {
                    long j3 = j;
                    j = j3;
                    zzekvVar.zzm().put(zzffuVar, new zzeku(this.zzd, zzffuVar.zzaf, 0, j3, null));
                }
                zzekvVar.zzo().zzd(zzffuVar, j, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
