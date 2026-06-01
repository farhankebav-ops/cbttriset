package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.unity3d.services.core.di.ServiceProvider;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaba {
    private final zzaaz zza;
    private final zzabf zzb;
    private boolean zzc;
    private long zzf;
    private boolean zzi;
    private boolean zzl;
    private boolean zzm;
    private int zzd = 0;
    private long zze = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private float zzj = 1.0f;
    private zzdc zzk = zzdc.zza;

    public zzaba(Context context, zzaaz zzaazVar, long j) {
        this.zza = zzaazVar;
        this.zzb = new zzabf(context);
    }

    private final void zzo(int i2) {
        this.zzd = Math.min(this.zzd, i2);
    }

    public final void zza(int i2) {
        if (i2 == 0) {
            this.zzd = 1;
        } else if (i2 != 1) {
            zzo(2);
        } else {
            this.zzd = 0;
        }
    }

    public final void zzb() {
        this.zzc = true;
        this.zzf = zzep.zzq(this.zzk.zzb());
        this.zzb.zzb();
    }

    public final void zzc() {
        this.zzc = false;
        this.zzh = -9223372036854775807L;
        this.zzb.zzh();
    }

    public final void zzd(@Nullable Surface surface) {
        this.zzl = surface != null;
        this.zzm = false;
        this.zzb.zzc(surface);
        zzo(1);
    }

    public final void zze(float f4) {
        this.zzb.zzf(f4);
    }

    public final boolean zzf() {
        int i2 = this.zzd;
        this.zzd = 3;
        this.zzf = zzep.zzq(this.zzk.zzb());
        return i2 != 3;
    }

    public final void zzg(zzdc zzdcVar) {
        this.zzk = zzdcVar;
    }

    public final void zzh() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final boolean zzi(boolean z2) {
        if (z2 && (this.zzd == 3 || (!this.zzl && this.zzm))) {
            this.zzh = -9223372036854775807L;
            return true;
        }
        if (this.zzh == -9223372036854775807L) {
            return false;
        }
        if (this.zzk.zzb() < this.zzh) {
            return true;
        }
        this.zzh = -9223372036854775807L;
        return false;
    }

    public final void zzj(boolean z2) {
        this.zzi = z2;
        this.zzh = -9223372036854775807L;
    }

    public final int zzk(long j, long j3, long j8, long j9, boolean z2, boolean z7, zzaay zzaayVar) throws zzib {
        boolean z8;
        zzaayVar.zzc();
        if (this.zzc && this.zze == -9223372036854775807L) {
            this.zze = j3;
        }
        if (this.zzg != j) {
            this.zzb.zzg(j);
            this.zzg = j;
        }
        long jZzq = (long) ((j - j3) / ((double) this.zzj));
        if (this.zzc) {
            jZzq -= zzep.zzq(this.zzk.zzb()) - j8;
        }
        zzaayVar.zze(jZzq);
        if (z2 && !z7) {
            return 3;
        }
        if (!this.zzl) {
            this.zzm = true;
            if (this.zza.zzao(zzaayVar.zzd(), j3, j8, z7, true)) {
                return 4;
            }
            return (!this.zzc || zzaayVar.zzd() >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) ? 5 : 3;
        }
        long jZzd = zzaayVar.zzd();
        if (this.zzh == -9223372036854775807L || this.zzi) {
            int i2 = this.zzd;
            if (i2 == 0) {
                z8 = false;
                if (this.zzc) {
                    return 0;
                }
            } else {
                if (i2 == 1) {
                    return 0;
                }
                if (i2 == 2) {
                    z8 = false;
                    if (j3 >= j9) {
                        return 0;
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                    z8 = false;
                    long jZzq2 = zzep.zzq(this.zzk.zzb()) - this.zzf;
                    if (this.zzc) {
                        long j10 = this.zze;
                        if (j10 != -9223372036854775807L && j10 != j3 && jZzd < -30000 && jZzq2 > 100000) {
                            return 0;
                        }
                    }
                }
            }
        } else {
            z8 = false;
        }
        if (!this.zzc || j3 == this.zze) {
            return 5;
        }
        long jZzc = this.zzk.zzc();
        zzaayVar.zzg(this.zzb.zzi((zzaayVar.zzd() * 1000) + jZzc));
        zzaayVar.zze((zzaayVar.zzf() - jZzc) / 1000);
        boolean z9 = (this.zzh == -9223372036854775807L || this.zzi) ? z8 : true;
        if (this.zza.zzao(zzaayVar.zzd(), j3, j8, z7, z9)) {
            return 4;
        }
        return (zzaayVar.zzd() >= -30000 || z7) ? zzaayVar.zzd() > ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT ? 5 : 1 : z9 ? 3 : 2;
    }

    public final void zzl() {
        this.zzb.zzd();
        this.zzg = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        zzo(1);
        this.zzh = -9223372036854775807L;
    }

    public final void zzm(int i2) {
        this.zzb.zza(i2);
    }

    public final void zzn(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        zzgmd.zza(f4 > 0.0f);
        if (f4 == this.zzj) {
            return;
        }
        this.zzj = f4;
        this.zzb.zze(f4);
    }
}
