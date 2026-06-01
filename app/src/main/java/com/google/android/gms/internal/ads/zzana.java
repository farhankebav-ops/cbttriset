package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzana implements zzamq {
    private zzaem zzc;
    private boolean zzd;
    private int zzf;
    private int zzg;
    private final String zza = "video/mp2t";
    private final zzeg zzb = new zzeg(10);
    private long zze = -9223372036854775807L;

    public zzana(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzd = false;
        this.zze = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 5);
        this.zzc = zzaemVarZzu;
        zzt zztVar = new zzt();
        zztVar.zza(zzaoeVar.zzc());
        zztVar.zzl(this.zza);
        zztVar.zzm("application/id3");
        zzaemVarZzu.zzu(zztVar.zzM());
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i2) {
        if ((i2 & 4) == 0) {
            return;
        }
        this.zzd = true;
        this.zze = j;
        this.zzf = 0;
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) {
        this.zzc.getClass();
        if (this.zzd) {
            int iZzd = zzegVar.zzd();
            int i2 = this.zzg;
            if (i2 < 10) {
                int iMin = Math.min(iZzd, 10 - i2);
                byte[] bArrZzi = zzegVar.zzi();
                int iZzg = zzegVar.zzg();
                zzeg zzegVar2 = this.zzb;
                System.arraycopy(bArrZzi, iZzg, zzegVar2.zzi(), this.zzg, iMin);
                if (this.zzg + iMin == 10) {
                    zzegVar2.zzh(0);
                    if (zzegVar2.zzs() != 73 || zzegVar2.zzs() != 68 || zzegVar2.zzs() != 51) {
                        zzdt.zzc("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzd = false;
                        return;
                    } else {
                        zzegVar2.zzk(3);
                        this.zzf = zzegVar2.zzG() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iZzd, this.zzf - this.zzg);
            this.zzc.zzz(zzegVar, iMin2);
            this.zzg += iMin2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z2) {
        int i2;
        this.zzc.getClass();
        if (this.zzd && (i2 = this.zzf) != 0 && this.zzg == i2) {
            zzgmd.zzh(this.zze != -9223372036854775807L);
            this.zzc.zzx(this.zze, 1, this.zzf, 0, null);
            this.zzd = false;
        }
    }
}
