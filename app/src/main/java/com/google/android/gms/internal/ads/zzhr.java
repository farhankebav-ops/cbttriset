package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhr implements zzln, zzlp {
    private final int zzb;

    @Nullable
    private zzlq zzd;
    private int zze;
    private zzpc zzf;
    private zzdc zzg;
    private int zzh;

    @Nullable
    private zzwk zzi;

    @Nullable
    private zzv[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;

    @Nullable
    private zzuu zzq;

    @Nullable
    @GuardedBy("lock")
    private zzlo zzr;
    private final Object zza = new Object();
    private final zzkj zzc = new zzkj();
    private long zzm = Long.MIN_VALUE;
    private zzbf zzp = zzbf.zza;

    public zzhr(int i2) {
        this.zzb = i2;
    }

    private final void zzac(long j, boolean z2, boolean z7) throws zzib {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        if (!z7) {
            z7 = zzP(j) != 0;
        }
        zzA(j, z2, z7);
    }

    public void zzA(long j, boolean z2, boolean z7) throws zzib {
        throw null;
    }

    public void zzD() {
        throw null;
    }

    public final long zzG() {
        return this.zzl;
    }

    public final zzkj zzH() {
        zzkj zzkjVar = this.zzc;
        zzkjVar.zza = null;
        zzkjVar.zzb = null;
        return zzkjVar;
    }

    public final zzv[] zzI() {
        zzv[] zzvVarArr = this.zzj;
        zzvVarArr.getClass();
        return zzvVarArr;
    }

    public final zzlq zzJ() {
        zzlq zzlqVar = this.zzd;
        zzlqVar.getClass();
        return zzlqVar;
    }

    public final zzpc zzK() {
        zzpc zzpcVar = this.zzf;
        zzpcVar.getClass();
        return zzpcVar;
    }

    public final zzdc zzL() {
        zzdc zzdcVar = this.zzg;
        zzdcVar.getClass();
        return zzdcVar;
    }

    public final zzbf zzM() {
        return this.zzp;
    }

    public final zzib zzN(Throwable th, @Nullable zzv zzvVar, boolean z2, int i2) {
        int iZzab = 4;
        if (zzvVar != null && !this.zzo) {
            this.zzo = true;
            try {
                iZzab = zzab(zzvVar) & 7;
            } catch (zzib unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzib.zzb(th, zzS(), this.zze, zzvVar, iZzab, this.zzq, z2, i2);
    }

    public final int zzO(zzkj zzkjVar, zzhh zzhhVar, int i2) {
        zzwk zzwkVar = this.zzi;
        zzwkVar.getClass();
        int iZzd = zzwkVar.zzd(zzkjVar, zzhhVar, i2);
        if (iZzd == -4) {
            if (zzhhVar.zzb()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzhhVar.zze + this.zzk;
            zzhhVar.zze = j;
            this.zzm = Math.max(this.zzm, j);
            return iZzd;
        }
        if (iZzd == -5) {
            zzv zzvVar = zzkjVar.zzb;
            zzvVar.getClass();
            long j3 = zzvVar.zzt;
            if (j3 != LocationRequestCompat.PASSIVE_INTERVAL) {
                zzt zztVarZza = zzvVar.zza();
                zztVarZza.zzr(j3 + this.zzk);
                zzkjVar.zzb = zztVarZza.zzM();
                return -5;
            }
        }
        return iZzd;
    }

    public final int zzP(long j) {
        zzwk zzwkVar = this.zzi;
        zzwkVar.getClass();
        return zzwkVar.zze(j - this.zzk);
    }

    public final boolean zzQ() {
        if (zzdb()) {
            return this.zzn;
        }
        zzwk zzwkVar = this.zzi;
        zzwkVar.getClass();
        return zzwkVar.zzb();
    }

    public final void zzR() {
        zzlo zzloVar;
        synchronized (this.zza) {
            zzloVar = this.zzr;
        }
        if (zzloVar != null) {
            zzloVar.zza(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public /* synthetic */ long zzT(long j, long j3) {
        return g0.a(this, j, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public /* synthetic */ boolean zzU(long j) {
        return g0.b(this, j);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public /* synthetic */ void zzV(float f4, float f8) {
        g0.c(this, f4, f8);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public /* synthetic */ void zzW() {
        g0.d(this);
    }

    @Override // com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzlp
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzc(int i2, zzpc zzpcVar, zzdc zzdcVar) {
        this.zze = i2;
        this.zzf = zzpcVar;
        this.zzg = zzdcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzcY() throws zzib {
        zzgmd.zzh(this.zzh == 1);
        this.zzh = 2;
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzcZ(zzv[] zzvVarArr, zzwk zzwkVar, long j, long j3, zzuu zzuuVar) throws zzib {
        zzgmd.zzh(!this.zzn);
        this.zzi = zzwkVar;
        this.zzq = zzuuVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzvVarArr;
        this.zzk = j3;
        zzz(zzvVarArr, j, j3, zzuuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    @Nullable
    public zzko zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    @Nullable
    public final zzwk zzda() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final boolean zzdb() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final int zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzf(zzlq zzlqVar, zzv[] zzvVarArr, zzwk zzwkVar, long j, boolean z2, boolean z7, long j3, long j8, zzuu zzuuVar) throws zzib {
        zzgmd.zzh(this.zzh == 0);
        this.zzd = zzlqVar;
        this.zzq = zzuuVar;
        this.zzh = 1;
        zzy(z2, z7);
        zzcZ(zzvVarArr, zzwkVar, j3, j8, zzuuVar);
        zzac(j3, z2, true);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final long zzk() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzl() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final boolean zzm() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzn() throws IOException {
        zzwk zzwkVar = this.zzi;
        zzwkVar.getClass();
        zzwkVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzo(zzbf zzbfVar) {
        if (Objects.equals(this.zzp, zzbfVar)) {
            return;
        }
        this.zzp = zzbfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzp(long j, boolean z2) throws zzib {
        zzac(j, false, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzq() {
        zzgmd.zzh(this.zzh == 2);
        this.zzh = 1;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzr() {
        zzgmd.zzh(this.zzh == 1);
        zzkj zzkjVar = this.zzc;
        zzkjVar.zza = null;
        zzkjVar.zzb = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzD();
        this.zzq = null;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzs() {
        zzgmd.zzh(this.zzh == 0);
        zzkj zzkjVar = this.zzc;
        zzkjVar.zza = null;
        zzkjVar.zzb = null;
        zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzt() {
        zzgmd.zzh(this.zzh == 0);
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public int zzu() throws zzib {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final void zzv(zzlo zzloVar) {
        synchronized (this.zza) {
            this.zzr = zzloVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final void zzw() {
        synchronized (this.zza) {
            this.zzr = null;
        }
    }

    public void zzB() throws zzib {
    }

    public void zzC() {
    }

    public void zzE() {
    }

    public void zzF() {
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final zzlp zzb() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public void zzx(int i2, @Nullable Object obj) throws zzib {
    }

    public void zzy(boolean z2, boolean z7) throws zzib {
    }

    public void zzz(zzv[] zzvVarArr, long j, long j3, zzuu zzuuVar) throws zzib {
    }
}
