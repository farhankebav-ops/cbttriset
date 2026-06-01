package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzanu implements zzacl {
    private final zzem zza;
    private final zzeg zzb = new zzeg();
    private final int zzc;

    public zzanu(int i2, zzem zzemVar, int i8) {
        this.zzc = i2;
        this.zza = zzemVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final zzack zza(zzadb zzadbVar, long j) throws IOException {
        int iZza;
        int iZza2;
        long jZzn = zzadbVar.zzn();
        int iMin = (int) Math.min(112800L, zzadbVar.zzo() - jZzn);
        zzeg zzegVar = this.zzb;
        zzegVar.zza(iMin);
        zzadbVar.zzi(zzegVar.zzi(), 0, iMin);
        int iZze = zzegVar.zze();
        long j3 = -1;
        long j8 = -9223372036854775807L;
        long j9 = -1;
        while (zzegVar.zzd() >= 188 && (iZza2 = (iZza = zzaog.zza(zzegVar.zzi(), zzegVar.zzg(), iZze)) + 188) <= iZze) {
            long jZzb = zzaog.zzb(zzegVar, iZza, this.zzc);
            if (jZzb != -9223372036854775807L) {
                long jZze = this.zza.zze(jZzb);
                if (jZze > j) {
                    return j8 == -9223372036854775807L ? zzack.zza(jZze, jZzn) : zzack.zzc(jZzn + j9);
                }
                j9 = iZza;
                if (100000 + jZze > j) {
                    return zzack.zzc(jZzn + j9);
                }
                j8 = jZze;
            }
            zzegVar.zzh(iZza2);
            j3 = iZza2;
        }
        return j8 != -9223372036854775807L ? zzack.zzb(j8, jZzn + j3) : zzack.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzb() {
        byte[] bArr = zzep.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
    }
}
