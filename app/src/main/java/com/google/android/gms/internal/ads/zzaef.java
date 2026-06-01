package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaef implements zzada {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private int zzd;
    private int zze;
    private zzadd zzf;
    private zzaem zzg;

    public zzaef(int i2, int i8, String str) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        int i2 = this.zza;
        zzgmd.zzh((i2 == -1 || this.zzb == -1) ? false : true);
        int i8 = this.zzb;
        zzeg zzegVar = new zzeg(i8);
        ((zzacr) zzadbVar).zzh(zzegVar.zzi(), 0, i8, false);
        return zzegVar.zzt() == i2;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zzf = zzaddVar;
        zzaem zzaemVarZzu = zzaddVar.zzu(1024, 4);
        this.zzg = zzaemVarZzu;
        zzt zztVar = new zzt();
        String str = this.zzc;
        zztVar.zzl(str);
        zztVar.zzm(str);
        zzaemVarZzu.zzu(zztVar.zzM());
        this.zzf.zzv();
        this.zzf.zzw(new zzaeg(-9223372036854775807L));
        this.zze = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        int i2 = this.zze;
        if (i2 != 1) {
            if (i2 == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        zzaem zzaemVar = this.zzg;
        zzaemVar.getClass();
        int iZzy = zzaemVar.zzy(zzadbVar, 1024, true);
        if (iZzy == -1) {
            this.zze = 2;
            this.zzg.zzx(0L, 1, this.zzd, 0, null);
            this.zzd = 0;
        } else {
            this.zzd += iZzy;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        if (j == 0 || this.zze == 1) {
            this.zze = 1;
            this.zzd = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }
}
