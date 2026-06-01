package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzma {
    final /* synthetic */ zzme zza;
    private final int zzb;

    @Nullable
    private Object zzc;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private long zzi;

    public zzma(zzme zzmeVar, int i2) {
        Objects.requireNonNull(zzmeVar);
        this.zza = zzmeVar;
        this.zzb = i2;
    }

    public final void zza() {
        zzme zzmeVar = this.zza;
        if (zzmeVar.zzw().zzh() != 2 || !zzmeVar.zzw().zzk() || zzmeVar.zzw().zzi() != 0) {
            if (this.zzh) {
                zzmeVar.zzz().zzk(1);
            }
            this.zzh = false;
            return;
        }
        zzbf zzbfVarZzq = zzmeVar.zzw().zzq();
        Object objZzf = zzbfVarZzq.zzg() ? null : zzbfVarZzq.zzf(zzmeVar.zzw().zzr());
        zzbb zzbbVarZzw = zzmeVar.zzw();
        zzbb zzbbVarZzw2 = zzmeVar.zzw();
        zzbb zzbbVarZzw3 = zzmeVar.zzw();
        zzbb zzbbVarZzw4 = zzmeVar.zzw();
        int iZzy = zzbbVarZzw.zzy();
        int iZzz = zzbbVarZzw2.zzz();
        long jZzv = zzbbVarZzw3.zzv();
        long jMax = Math.max(0L, zzmeVar.zzw().zzw() - Math.max(0L, jZzv - zzbbVarZzw4.zzu()));
        if (objZzf != null && iZzy == -1) {
            zzbfVarZzq.zzo(objZzf, zzmeVar.zzy());
            jZzv -= zzep.zzp(0L);
            iZzy = -1;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzh && Objects.equals(objZzf, this.zzc) && iZzy == this.zzd && iZzz == this.zze && jZzv == this.zzf && jMax == this.zzg) {
            long j = jElapsedRealtime - this.zzi;
            int i2 = this.zzb;
            if (j >= i2) {
                zzmeVar.zzx().zzx(new zzmf(1, i2));
                return;
            }
            return;
        }
        this.zzh = true;
        this.zzi = jElapsedRealtime;
        this.zzc = objZzf;
        this.zzd = iZzy;
        this.zze = iZzz;
        this.zzf = jZzv;
        this.zzg = jMax;
        zzmeVar.zzz().zzk(1);
        zzmeVar.zzz().zzi(1, this.zzb);
    }
}
