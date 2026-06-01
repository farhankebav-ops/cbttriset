package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaab implements zzabx {
    private final zzaba zza;
    private final zzabb zzb;
    private final zzabg zzc;
    private final Queue zzd;

    @Nullable
    private Surface zze;
    private zzv zzf;
    private long zzg;
    private zzabu zzh;
    private Executor zzi;
    private zzaax zzj;

    public zzaab(zzaba zzabaVar, zzabb zzabbVar, zzdc zzdcVar) {
        this.zza = zzabaVar;
        this.zzb = zzabbVar;
        zzabaVar.zzg(zzdcVar);
        this.zzc = new zzabg(new zzaaa(this, null), zzabaVar, zzabbVar);
        this.zzd = new ArrayDeque();
        this.zzf = new zzt().zzM();
        this.zzg = -9223372036854775807L;
        this.zzh = zzabu.zzb;
        this.zzi = zzzw.zza;
        this.zzj = zzzu.zza;
    }

    public final /* synthetic */ Surface zzA() {
        return this.zze;
    }

    public final /* synthetic */ zzabu zzB() {
        return this.zzh;
    }

    public final /* synthetic */ Executor zzC() {
        return this.zzi;
    }

    public final /* synthetic */ zzaax zzD() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zza() {
        this.zzb.zzd();
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzb() {
        this.zzb.zzd();
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzc(zzabu zzabuVar, Executor executor) {
        this.zzh = zzabuVar;
        this.zzi = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzd(zzv zzvVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzf() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzg(boolean z2) {
        if (z2) {
            this.zza.zzl();
        }
        this.zzb.zzd();
        this.zzc.zza();
        this.zzd.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzh(boolean z2) {
        return this.zza.zzi(z2);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzi() {
        this.zzc.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzj() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final Surface zzk() {
        Surface surface = this.zze;
        surface.getClass();
        return surface;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzl(zzaax zzaaxVar) {
        this.zzj = zzaaxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzm(float f4) {
        this.zza.zzn(f4);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzn(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzo(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzp(Surface surface, zzeh zzehVar) {
        this.zze = surface;
        this.zza.zzd(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzq() {
        this.zze = null;
        this.zza.zzd(null);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzr(int i2) {
        this.zza.zzm(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzs(int i2, zzv zzvVar, long j, int i8, List list) {
        zzgmd.zzh(list.isEmpty());
        int i9 = zzvVar.zzv;
        zzv zzvVar2 = this.zzf;
        if (i9 != zzvVar2.zzv || zzvVar.zzw != zzvVar2.zzw) {
            this.zzc.zzc(i9, zzvVar.zzw);
        }
        float f4 = zzvVar.zzz;
        if (f4 != this.zzf.zzz) {
            this.zza.zze(f4);
        }
        this.zzf = zzvVar;
        if (j != this.zzg) {
            this.zzc.zzd(i8, j);
            this.zzg = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzt() {
        this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzu(long j, zzabv zzabvVar) {
        this.zzd.add(zzabvVar);
        this.zzc.zze(j);
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzy();
            }
        });
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzv(long j, long j3) throws zzabw {
        try {
            this.zzc.zzb(j, j3);
        } catch (zzib e) {
            throw new zzabw(e, this.zzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzw(boolean z2) {
        this.zza.zzj(z2);
    }

    public final /* synthetic */ void zzy() {
        this.zzh.zza();
    }

    public final /* synthetic */ Queue zzz() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzx() {
    }
}
