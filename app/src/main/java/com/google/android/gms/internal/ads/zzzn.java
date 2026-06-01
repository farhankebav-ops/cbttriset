package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzzn {
    public static final zzzh zza = new zzzh(2, -9223372036854775807L, null);
    public static final zzzh zzb = new zzzh(3, -9223372036854775807L, null);
    private final zzzt zzc = t0.a(zzep.zzf("ExoPlayer:Loader:ProgressiveMediaPeriod"), zzzg.zza);

    @Nullable
    private zzzi zzd;

    @Nullable
    private IOException zze;

    public zzzn(String str) {
    }

    public static zzzh zza(boolean z2, long j) {
        return new zzzh(z2 ? 1 : 0, j, null);
    }

    public final boolean zzb() {
        return this.zze != null;
    }

    public final void zzc() {
        this.zze = null;
    }

    public final long zzd(zzzj zzzjVar, zzzf zzzfVar, int i2) {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        this.zze = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new zzzi(this, looperMyLooper, zzzjVar, zzzfVar, i2, jElapsedRealtime).zzb(0L);
        return jElapsedRealtime;
    }

    public final boolean zze() {
        return this.zzd != null;
    }

    public final void zzf() {
        zzzi zzziVar = this.zzd;
        zzziVar.getClass();
        zzziVar.zzc(false);
    }

    public final void zzg(@Nullable zzzk zzzkVar) {
        zzzi zzziVar = this.zzd;
        if (zzziVar != null) {
            zzziVar.zzc(true);
        }
        zzzt zzztVar = this.zzc;
        zzztVar.execute(new zzzl(zzzkVar));
        zzztVar.zza();
    }

    public final void zzh(int i2) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null) {
            throw iOException;
        }
        zzzi zzziVar = this.zzd;
        if (zzziVar != null) {
            zzziVar.zza(i2);
        }
    }

    public final /* synthetic */ zzzt zzi() {
        return this.zzc;
    }

    public final /* synthetic */ zzzi zzj() {
        return this.zzd;
    }

    public final /* synthetic */ void zzk(zzzi zzziVar) {
        this.zzd = zzziVar;
    }

    public final /* synthetic */ void zzl(IOException iOException) {
        this.zze = iOException;
    }
}
