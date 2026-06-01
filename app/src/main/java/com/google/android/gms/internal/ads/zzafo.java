package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzafo implements zzada {
    private zzadd zzf;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzafm zzo;
    private zzafs zzp;
    private final zzeg zza = new zzeg(4);
    private final zzeg zzb = new zzeg(9);
    private final zzeg zzc = new zzeg(11);
    private final zzeg zzd = new zzeg();
    private final zzafp zze = new zzafp();
    private int zzg = 1;

    private final zzeg zzg(zzadb zzadbVar) throws IOException {
        zzeg zzegVar = this.zzd;
        if (this.zzl > zzegVar.zzj()) {
            int iZzj = zzegVar.zzj();
            zzegVar.zzb(new byte[Math.max(iZzj + iZzj, this.zzl)], 0);
        } else {
            zzegVar.zzh(0);
        }
        zzegVar.zzf(this.zzl);
        zzadbVar.zzc(zzegVar.zzi(), 0, this.zzl);
        return zzegVar;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzh() {
        if (this.zzn) {
            return;
        }
        this.zzf.zzw(new zzaec(-9223372036854775807L, 0L));
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzeg zzegVar = this.zza;
        zzacr zzacrVar = (zzacr) zzadbVar;
        zzacrVar.zzh(zzegVar.zzi(), 0, 3, false);
        zzegVar.zzh(0);
        if (zzegVar.zzx() != 4607062) {
            return false;
        }
        zzacrVar.zzh(zzegVar.zzi(), 0, 2, false);
        zzegVar.zzh(0);
        if ((zzegVar.zzt() & 250) != 0) {
            return false;
        }
        zzacrVar.zzh(zzegVar.zzi(), 0, 4, false);
        zzegVar.zzh(0);
        int iZzB = zzegVar.zzB();
        zzadbVar.zzl();
        zzacr zzacrVar2 = (zzacr) zzadbVar;
        zzacrVar2.zzj(iZzB, false);
        zzacrVar2.zzh(zzegVar.zzi(), 0, 4, false);
        zzegVar.zzh(0);
        return zzegVar.zzB() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zzf = zzaddVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzada
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzadb r15, com.google.android.gms.internal.ads.zzaea r16) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafo.zzd(com.google.android.gms.internal.ads.zzadb, com.google.android.gms.internal.ads.zzaea):int");
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        if (j == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }
}
