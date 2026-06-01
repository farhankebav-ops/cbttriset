package com.google.android.gms.internal.ads;

import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaml implements zzada {
    private final zzamm zza;
    private final zzeg zzb;
    private final zzeg zzc;
    private final zzef zzd;
    private zzadd zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;

    public zzaml() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzeg zzegVar;
        int i2 = 0;
        while (true) {
            zzegVar = this.zzc;
            zzacr zzacrVar = (zzacr) zzadbVar;
            zzacrVar.zzh(zzegVar.zzi(), 0, 10, false);
            zzegVar.zzh(0);
            if (zzegVar.zzx() != 4801587) {
                break;
            }
            zzegVar.zzk(3);
            int iZzG = zzegVar.zzG();
            i2 += iZzG + 10;
            zzacrVar.zzj(iZzG, false);
        }
        zzadbVar.zzl();
        zzacr zzacrVar2 = (zzacr) zzadbVar;
        zzacrVar2.zzj(i2, false);
        if (this.zzg == -1) {
            this.zzg = i2;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = i2;
        do {
            zzacrVar2.zzh(zzegVar.zzi(), 0, 2, false);
            zzegVar.zzh(0);
            if (zzamm.zzf(zzegVar.zzt())) {
                i8++;
                if (i8 >= 4 && i9 > 188) {
                    return true;
                }
                zzacrVar2.zzh(zzegVar.zzi(), 0, 4, false);
                zzef zzefVar = this.zzd;
                zzefVar.zzf(14);
                int iZzj = zzefVar.zzj(13);
                if (iZzj <= 6) {
                    i10++;
                    zzadbVar.zzl();
                    zzacrVar2.zzj(i10, false);
                } else {
                    zzacrVar2.zzj(iZzj - 6, false);
                    i9 += iZzj;
                }
            } else {
                i10++;
                zzadbVar.zzl();
                zzacrVar2.zzj(i10, false);
            }
            i8 = 0;
            i9 = 0;
        } while (i10 - i2 < 8192);
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zze = zzaddVar;
        this.zza.zzb(zzaddVar, new zzaoe(Integer.MIN_VALUE, 0, 1));
        zzaddVar.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        this.zze.getClass();
        zzeg zzegVar = this.zzb;
        int iZza = zzadbVar.zza(zzegVar.zzi(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzw(new zzaec(-9223372036854775807L, 0L));
            this.zzi = true;
        }
        if (iZza == -1) {
            return -1;
        }
        zzegVar.zzh(0);
        zzegVar.zzf(iZza);
        if (!this.zzh) {
            this.zza.zzc(this.zzf, 4);
            this.zzh = true;
        }
        this.zza.zzd(zzegVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        this.zzh = false;
        this.zza.zza();
        this.zzf = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }

    public zzaml(int i2) {
        this.zza = new zzamm(true, null, 0, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE);
        this.zzb = new zzeg(2048);
        this.zzg = -1L;
        zzeg zzegVar = new zzeg(10);
        this.zzc = zzegVar;
        byte[] bArrZzi = zzegVar.zzi();
        this.zzd = new zzef(bArrZzi, bArrZzi.length);
    }
}
