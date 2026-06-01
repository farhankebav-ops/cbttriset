package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzami implements zzada {
    private final zzamj zza = new zzamj(null, 0, "audio/ac4");
    private final zzeg zzb = new zzeg(16384);
    private boolean zzc;

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        int i2;
        zzeg zzegVar = new zzeg(10);
        int i8 = 0;
        while (true) {
            zzacr zzacrVar = (zzacr) zzadbVar;
            zzacrVar.zzh(zzegVar.zzi(), 0, 10, false);
            zzegVar.zzh(0);
            if (zzegVar.zzx() != 4801587) {
                break;
            }
            zzegVar.zzk(3);
            int iZzG = zzegVar.zzG();
            i8 += iZzG + 10;
            zzacrVar.zzj(iZzG, false);
        }
        zzadbVar.zzl();
        zzacr zzacrVar2 = (zzacr) zzadbVar;
        zzacrVar2.zzj(i8, false);
        int i9 = 0;
        int i10 = i8;
        while (true) {
            int i11 = 7;
            zzacrVar2.zzh(zzegVar.zzi(), 0, 7, false);
            zzegVar.zzh(0);
            int iZzt = zzegVar.zzt();
            if (iZzt == 44096 || iZzt == 44097) {
                i9++;
                if (i9 >= 4) {
                    return true;
                }
                byte[] bArrZzi = zzegVar.zzi();
                if (bArrZzi.length < 7) {
                    i2 = -1;
                } else {
                    int i12 = ((bArrZzi[2] & 255) << 8) | (bArrZzi[3] & 255);
                    if (i12 == 65535) {
                        i12 = ((bArrZzi[4] & 255) << 16) | ((bArrZzi[5] & 255) << 8) | (bArrZzi[6] & 255);
                    } else {
                        i11 = 4;
                    }
                    if (iZzt == 44097) {
                        i11 += 2;
                    }
                    i2 = i12 + i11;
                }
                if (i2 == -1) {
                    return false;
                }
                zzacrVar2.zzj(i2 - 7, false);
            } else {
                zzadbVar.zzl();
                i10++;
                if (i10 - i8 >= 8192) {
                    return false;
                }
                zzacrVar2.zzj(i10, false);
                i9 = 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zza.zzb(zzaddVar, new zzaoe(Integer.MIN_VALUE, 0, 1));
        zzaddVar.zzv();
        zzaddVar.zzw(new zzaec(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        zzeg zzegVar = this.zzb;
        int iZza = zzadbVar.zza(zzegVar.zzi(), 0, 16384);
        if (iZza == -1) {
            return -1;
        }
        zzegVar.zzh(0);
        zzegVar.zzf(iZza);
        if (!this.zzc) {
            this.zza.zzc(0L, 4);
            this.zzc = true;
        }
        this.zza.zzd(zzegVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        this.zzc = false;
        this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }
}
