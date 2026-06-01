package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafi implements zzacl {
    private final zzadn zza;
    private final int zzb;
    private final zzadh zzc = new zzadh();

    public /* synthetic */ zzafi(zzadn zzadnVar, int i2, byte[] bArr) {
        this.zza = zzadnVar;
        this.zzb = i2;
    }

    private final long zzc(zzadb zzadbVar) throws IOException {
        while (zzadbVar.zzm() < zzadbVar.zzo() - 6) {
            zzadn zzadnVar = this.zza;
            int i2 = this.zzb;
            zzadh zzadhVar = this.zzc;
            long jZzm = zzadbVar.zzm();
            zzeg zzegVar = new zzeg(17);
            zzadbVar.zzi(zzegVar.zzi(), 0, 2);
            if (zzegVar.zzo() != i2) {
                zzadbVar.zzl();
                zzadbVar.zzk((int) (jZzm - zzadbVar.zzn()));
            } else {
                zzegVar.zzf(zzade.zzb(zzadbVar, zzegVar.zzi(), 2, 15) + 2);
                zzadbVar.zzl();
                zzadbVar.zzk((int) (jZzm - zzadbVar.zzn()));
                if (zzadi.zza(zzegVar, zzadnVar, i2, zzadhVar)) {
                    break;
                }
            }
            zzadbVar.zzk(1);
        }
        if (zzadbVar.zzm() < zzadbVar.zzo() - 6) {
            return this.zzc.zza;
        }
        zzadbVar.zzk((int) (zzadbVar.zzo() - zzadbVar.zzm()));
        return this.zza.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final zzack zza(zzadb zzadbVar, long j) throws IOException {
        long jZzn = zzadbVar.zzn();
        long jZzc = zzc(zzadbVar);
        long jZzm = zzadbVar.zzm();
        zzadbVar.zzk(Math.max(6, this.zza.zzc));
        long jZzc2 = zzc(zzadbVar);
        return (jZzc > j || jZzc2 <= j) ? jZzc2 <= j ? zzack.zzb(jZzc2, zzadbVar.zzm()) : zzack.zza(jZzc, jZzn) : zzack.zzc(jZzm);
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final /* synthetic */ void zzb() {
        c.a(this);
    }
}
