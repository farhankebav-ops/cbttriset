package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzmd {
    final /* synthetic */ zzme zza;
    private final int zzb;
    private int zzc;
    private boolean zzd;
    private long zze;

    public zzmd(zzme zzmeVar, int i2) {
        Objects.requireNonNull(zzmeVar);
        this.zza = zzmeVar;
        this.zzb = i2;
    }

    public final void zza() {
        zzme zzmeVar = this.zza;
        int iZzi = zzmeVar.zzw().zzi();
        if (!zzmeVar.zzw().zzk() || zzmeVar.zzw().zzh() == 1 || zzmeVar.zzw().zzh() == 4 || iZzi == 0 || iZzi == 1) {
            if (this.zzd) {
                zzmeVar.zzz().zzk(4);
            }
            this.zzd = false;
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzd && this.zzc == iZzi) {
            long j = jElapsedRealtime - this.zze;
            int i2 = this.zzb;
            if (j >= i2) {
                zzmeVar.zzx().zzx(new zzmf(4, i2));
                return;
            }
            return;
        }
        this.zzd = true;
        this.zze = jElapsedRealtime;
        this.zzc = iZzi;
        zzmeVar.zzz().zzk(4);
        zzmeVar.zzz().zzi(4, this.zzb);
    }
}
