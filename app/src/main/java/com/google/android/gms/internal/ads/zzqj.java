package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import androidx.work.WorkRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzqj {
    private final zzqi zza;
    private final int zzb;
    private final zzqk zzc;
    private int zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    public zzqj(AudioTrack audioTrack, zzqk zzqkVar) {
        this.zza = new zzqi(audioTrack);
        this.zzb = audioTrack.getSampleRate();
        this.zzc = zzqkVar;
        zzf(0);
    }

    private final void zzf(int i2) {
        this.zzd = i2;
        long j = WorkRequest.MIN_BACKOFF_MILLIS;
        if (i2 == 0) {
            this.zzg = 0L;
            this.zzh = -1L;
            this.zzi = -9223372036854775807L;
            this.zze = System.nanoTime() / 1000;
        } else {
            if (i2 == 1) {
                this.zzf = WorkRequest.MIN_BACKOFF_MILLIS;
                return;
            }
            j = (i2 == 2 || i2 == 3) ? 10000000L : 500000L;
        }
        this.zzf = j;
    }

    private final long zzg(long j, float f4) {
        zzqi zzqiVar = this.zza;
        return zzh(zzqiVar.zzc(), zzqiVar.zzb(), j, f4);
    }

    private final long zzh(long j, long j3, long j8, float f4) {
        long j9 = j8 - j3;
        return zzep.zzv(j9, f4) + zzep.zzr(j, this.zzb);
    }

    public final void zza(long j, float f4, long j3) {
        if (j - this.zzg < this.zzf) {
            return;
        }
        this.zzg = j;
        zzqi zzqiVar = this.zza;
        boolean zZza = zzqiVar.zza();
        if (zZza) {
            long jZzb = zzqiVar.zzb();
            long jZzg = zzg(j, f4);
            if (Math.abs(jZzb - j) > 5000000) {
                this.zzc.zzc(zzqiVar.zzc(), jZzb, j, j3);
                zzf(4);
            } else if (Math.abs(jZzg - j3) > 5000000) {
                this.zzc.zzb(zzqiVar.zzc(), jZzb, j, j3);
                zzf(4);
            } else if (this.zzd == 4) {
                zzf(0);
            }
        }
        int i2 = this.zzd;
        if (i2 == 0) {
            if (!zZza) {
                if (j - this.zze > 500000) {
                    zzf(3);
                    return;
                }
                return;
            } else {
                if (zzqiVar.zzb() >= this.zze) {
                    this.zzh = zzqiVar.zzc();
                    this.zzi = zzqiVar.zzb();
                    zzf(1);
                    return;
                }
                return;
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                if (zZza) {
                    return;
                }
                zzf(0);
                return;
            } else {
                if (i2 == 3 && zZza) {
                    zzf(0);
                    return;
                }
                return;
            }
        }
        if (!zZza) {
            zzf(0);
            return;
        }
        long jZzc = zzqiVar.zzc();
        long j8 = this.zzh;
        if (jZzc > j8) {
            if (Math.abs(zzg(j, f4) - zzh(j8, this.zzi, j, f4)) < 1000) {
                zzf(2);
                return;
            }
        }
        if (j - this.zze > 2000000) {
            zzf(3);
        } else {
            this.zzh = zzqiVar.zzc();
            this.zzi = zzqiVar.zzb();
        }
    }

    public final boolean zzb() {
        return this.zzd == 2;
    }

    public final boolean zzc() {
        int i2 = this.zzd;
        return i2 == 0 || i2 == 1;
    }

    public final void zzd() {
        zzf(0);
    }

    public final long zze(long j, float f4) {
        return zzg(j, f4);
    }
}
