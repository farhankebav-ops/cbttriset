package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzabf {
    private final zzaad zza = new zzaad();

    @Nullable
    private final zzabd zzb;

    @Nullable
    private final zzabe zzc;
    private boolean zzd;

    @Nullable
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzabf(@Nullable Context context) {
        DisplayManager displayManager;
        zzabd zzabdVar = (context == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : new zzabd(this, displayManager);
        this.zzb = zzabdVar;
        this.zzc = zzabdVar != null ? zzabe.zza() : null;
        this.zzk = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    private final void zzk() {
        this.zzm = 0L;
        this.zzp = -1L;
        this.zzn = -1L;
    }

    private final void zzl() {
        if (Build.VERSION.SDK_INT < 30 || this.zze == null) {
            return;
        }
        zzaad zzaadVar = this.zza;
        float fZzg = zzaadVar.zzc() ? zzaadVar.zzg() : this.zzf;
        float f4 = this.zzg;
        if (fZzg != f4) {
            if (fZzg != -1.0f && f4 != -1.0f) {
                float f8 = 1.0f;
                if (zzaadVar.zzc() && zzaadVar.zze() >= 5000000000L) {
                    f8 = 0.1f;
                }
                if (Math.abs(fZzg - this.zzg) < f8) {
                    return;
                }
            } else if (fZzg == -1.0f && zzaadVar.zzd() < 30) {
                return;
            }
            this.zzg = fZzg;
            zzm(false);
        }
    }

    private final void zzm(boolean z2) {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE) {
            return;
        }
        float f4 = 0.0f;
        if (this.zzd) {
            float f8 = this.zzg;
            if (f8 != -1.0f) {
                f4 = this.zzi * f8;
            }
        }
        if (z2 || this.zzh != f4) {
            this.zzh = f4;
            zzabc.zza(surface, f4);
        }
    }

    private final void zzn() {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE || this.zzh == 0.0f) {
            return;
        }
        this.zzh = 0.0f;
        zzabc.zza(surface, 0.0f);
    }

    public final void zza(int i2) {
        if (this.zzj == i2) {
            return;
        }
        this.zzj = i2;
        zzm(true);
    }

    public final void zzb() {
        this.zzd = true;
        zzk();
        zzabd zzabdVar = this.zzb;
        if (zzabdVar != null) {
            zzabe zzabeVar = this.zzc;
            zzabeVar.getClass();
            zzabeVar.zzb();
            zzabdVar.zza();
        }
        zzm(false);
    }

    public final void zzc(@Nullable Surface surface) {
        if (this.zze == surface) {
            return;
        }
        zzn();
        this.zze = surface;
        zzm(true);
    }

    public final void zzd() {
        zzk();
    }

    public final void zze(float f4) {
        this.zzi = f4;
        zzk();
        zzm(false);
    }

    public final void zzf(float f4) {
        this.zzf = f4;
        this.zza.zza();
        zzl();
    }

    public final void zzg(long j) {
        long j3 = this.zzn;
        if (j3 != -1) {
            this.zzp = j3;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zzb(j * 1000);
        zzl();
    }

    public final void zzh() {
        this.zzd = false;
        zzabd zzabdVar = this.zzb;
        if (zzabdVar != null) {
            zzabdVar.zzb();
            zzabe zzabeVar = this.zzc;
            zzabeVar.getClass();
            zzabeVar.zzc();
        }
        zzn();
    }

    public final long zzi(long j) {
        long j3;
        if (this.zzp != -1) {
            zzaad zzaadVar = this.zza;
            if (zzaadVar.zzc()) {
                long jZzf = zzaadVar.zzf();
                long j8 = this.zzq + ((long) (((this.zzm - this.zzp) * jZzf) / this.zzi));
                if (Math.abs(j - j8) > 20000000) {
                    zzk();
                } else {
                    j = j8;
                }
            }
        }
        this.zzn = this.zzm;
        this.zzo = j;
        zzabe zzabeVar = this.zzc;
        if (zzabeVar != null && this.zzk != -9223372036854775807L) {
            long j9 = zzabeVar.zza;
            if (j9 != -9223372036854775807L) {
                long j10 = this.zzk;
                long j11 = (((j - j9) / j10) * j10) + j9;
                if (j <= j11) {
                    j3 = j11 - j10;
                } else {
                    j3 = j11;
                    j11 = j10 + j11;
                }
                long j12 = this.zzl;
                if (j11 - j >= j - j3) {
                    j11 = j3;
                }
                return j11 - j12;
            }
        }
        return j;
    }

    public final /* synthetic */ void zzj(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.zzk = refreshRate;
            this.zzl = (refreshRate * 80) / 100;
        } else {
            zzdt.zzc("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.zzk = -9223372036854775807L;
            this.zzl = -9223372036854775807L;
        }
    }
}
