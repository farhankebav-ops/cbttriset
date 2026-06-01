package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafj extends zzacm {
    public zzafj(final zzadn zzadnVar, int i2, long j, long j3) {
        long j8;
        Objects.requireNonNull(zzadnVar);
        zzacj zzacjVar = new zzacj() { // from class: com.google.android.gms.internal.ads.zzafh
            @Override // com.google.android.gms.internal.ads.zzacj
            public final /* synthetic */ long zza(long j9) {
                return zzadnVar.zzb(j9);
            }
        };
        zzafi zzafiVar = new zzafi(zzadnVar, i2, null);
        long jZza = zzadnVar.zza();
        long j9 = zzadnVar.zzj;
        int i8 = zzadnVar.zzd;
        if (i8 > 0) {
            j8 = ((((long) i8) + ((long) zzadnVar.zzc)) / 2) + 1;
        } else {
            int i9 = zzadnVar.zza;
            long j10 = 4096;
            if (i9 == zzadnVar.zzb && i9 > 0) {
                j10 = i9;
            }
            j8 = 64 + (((j10 * ((long) zzadnVar.zzg)) * ((long) zzadnVar.zzh)) / 8);
        }
        super(zzacjVar, zzafiVar, jZza, 0L, j9, j, j3, j8, Math.max(6, zzadnVar.zzc));
    }
}
