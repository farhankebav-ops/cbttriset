package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzmc {
    final /* synthetic */ zzme zza;
    private final int zzb;

    @Nullable
    private Object zzc;
    private int zzd;
    private int zze;
    private boolean zzf;
    private long zzg;

    public zzmc(zzme zzmeVar, int i2) {
        Objects.requireNonNull(zzmeVar);
        this.zza = zzmeVar;
        this.zzb = i2;
    }

    public final void zza() {
        long jZzt;
        zzme zzmeVar = this.zza;
        zzbf zzbfVarZzq = zzmeVar.zzw().zzq();
        Object objZzf = zzbfVarZzq.zzg() ? null : zzbfVarZzq.zzf(zzmeVar.zzw().zzr());
        zzbb zzbbVarZzw = zzmeVar.zzw();
        zzbb zzbbVarZzw2 = zzmeVar.zzw();
        zzbb zzbbVarZzw3 = zzmeVar.zzw();
        int iZzy = zzbbVarZzw.zzy();
        int iZzz = zzbbVarZzw2.zzz();
        long jZzu = zzbbVarZzw3.zzu();
        if (objZzf == null || iZzy != -1) {
            jZzt = iZzy != -1 ? zzmeVar.zzw().zzt() : -9223372036854775807L;
        } else {
            zzbfVarZzq.zzo(objZzf, zzmeVar.zzy());
            jZzu -= zzep.zzp(0L);
            jZzt = zzep.zzp(zzmeVar.zzy().zzd);
            iZzy = -1;
        }
        boolean zZza = zzmeVar.zzw().zza();
        if (!zZza || jZzt == -9223372036854775807L || jZzu < jZzt) {
            zzmeVar.zzz().zzk(3);
            if (zZza && jZzt != -9223372036854775807L) {
                zzmeVar.zzz().zzi(3, (int) Math.ceil((jZzt - jZzu) / zzmeVar.zzw().zzn().zzb));
            }
            this.zzf = false;
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzf && Objects.equals(objZzf, this.zzc) && iZzy == this.zzd && iZzz == this.zze) {
            long j = jElapsedRealtime - this.zzg;
            int i2 = this.zzb;
            if (j >= i2) {
                zzmeVar.zzx().zzx(new zzmf(3, i2));
                return;
            }
            return;
        }
        this.zzf = true;
        this.zzg = jElapsedRealtime;
        this.zzc = objZzf;
        this.zzd = iZzy;
        this.zze = iZzz;
        zzmeVar.zzz().zzk(3);
        zzmeVar.zzz().zzi(3, this.zzb);
    }
}
