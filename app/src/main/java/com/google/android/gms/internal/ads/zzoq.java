package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzoq {
    final /* synthetic */ zzor zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzuu zze;
    private boolean zzf;
    private boolean zzg;

    public zzoq(zzor zzorVar, String str, @Nullable int i2, zzuu zzuuVar) {
        Objects.requireNonNull(zzorVar);
        this.zza = zzorVar;
        this.zzb = str;
        this.zzc = i2;
        this.zzd = zzuuVar == null ? -1L : zzuuVar.zzd;
        if (zzuuVar == null || !zzuuVar.zzb()) {
            return;
        }
        this.zze = zzuuVar;
    }

    public final boolean zza(zzbf zzbfVar, zzbf zzbfVar2) {
        int i2 = this.zzc;
        if (i2 < zzbfVar.zza()) {
            zzor zzorVar = this.zza;
            zzbfVar.zzb(i2, zzorVar.zzj(), 0L);
            for (int i8 = zzorVar.zzj().zzn; i8 <= zzorVar.zzj().zzo; i8++) {
                int iZze = zzbfVar2.zze(zzbfVar.zzf(i8));
                if (iZze != -1) {
                    i2 = zzbfVar2.zzd(iZze, zzorVar.zzk(), false).zzc;
                    break;
                }
            }
            i2 = -1;
        } else if (i2 >= zzbfVar2.zza()) {
            i2 = -1;
        }
        this.zzc = i2;
        if (i2 == -1) {
            return false;
        }
        zzuu zzuuVar = this.zze;
        return zzuuVar == null || zzbfVar2.zze(zzuuVar.zza) != -1;
    }

    public final boolean zzb(int i2, @Nullable zzuu zzuuVar) {
        if (zzuuVar == null) {
            return i2 == this.zzc;
        }
        zzuu zzuuVar2 = this.zze;
        return zzuuVar2 == null ? !zzuuVar.zzb() && zzuuVar.zzd == this.zzd : zzuuVar.zzd == zzuuVar2.zzd && zzuuVar.zzb == zzuuVar2.zzb && zzuuVar.zzc == zzuuVar2.zzc;
    }

    public final void zzc(int i2, @Nullable zzuu zzuuVar) {
        if (this.zzd == -1 && i2 == this.zzc && zzuuVar != null) {
            zzor zzorVar = this.zza;
            long j = zzuuVar.zzd;
            if (j >= zzorVar.zzi()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzd(zzmj zzmjVar) {
        zzuu zzuuVar = zzmjVar.zzd;
        if (zzuuVar == null) {
            return this.zzc != zzmjVar.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        long j3 = zzuuVar.zzd;
        if (j3 > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzbf zzbfVar = zzmjVar.zzb;
        int iZze = zzbfVar.zze(zzuuVar.zza);
        int iZze2 = zzbfVar.zze(this.zze.zza);
        zzuu zzuuVar2 = this.zze;
        if (j3 < zzuuVar2.zzd || iZze < iZze2) {
            return false;
        }
        if (iZze > iZze2) {
            return true;
        }
        if (!zzuuVar.zzb()) {
            int i2 = zzuuVar.zze;
            return i2 == -1 || i2 > zzuuVar2.zzb;
        }
        int i8 = zzuuVar.zzb;
        int i9 = zzuuVar.zzc;
        int i10 = zzuuVar2.zzb;
        if (i8 <= i10) {
            return i8 == i10 && i9 > zzuuVar2.zzc;
        }
        return true;
    }

    public final /* synthetic */ String zze() {
        return this.zzb;
    }

    public final /* synthetic */ int zzf() {
        return this.zzc;
    }

    public final /* synthetic */ long zzg() {
        return this.zzd;
    }

    public final /* synthetic */ zzuu zzh() {
        return this.zze;
    }

    public final /* synthetic */ boolean zzi() {
        return this.zzf;
    }

    public final /* synthetic */ void zzj(boolean z2) {
        this.zzf = true;
    }

    public final /* synthetic */ boolean zzk() {
        return this.zzg;
    }

    public final /* synthetic */ void zzl(boolean z2) {
        this.zzg = true;
    }
}
