package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhf {
    final String zza;
    final /* synthetic */ zzhh zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    public /* synthetic */ zzhf(zzhh zzhhVar, String str, long j, byte[] bArr) {
        Objects.requireNonNull(zzhhVar);
        this.zzb = zzhhVar;
        Preconditions.checkNotEmpty("health_monitor");
        Preconditions.checkArgument(j > 0);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j;
    }

    @WorkerThread
    private final void zzc() {
        zzhh zzhhVar = this.zzb;
        zzhhVar.zzg();
        long jCurrentTimeMillis = zzhhVar.zzu.zzaZ().currentTimeMillis();
        SharedPreferences.Editor editorEdit = zzhhVar.zzd().edit();
        editorEdit.remove(this.zzc);
        editorEdit.remove(this.zzd);
        editorEdit.putLong(this.zza, jCurrentTimeMillis);
        editorEdit.apply();
    }

    @WorkerThread
    private final long zzd() {
        return this.zzb.zzd().getLong(this.zza, 0L);
    }

    @WorkerThread
    public final void zza(String str, long j) {
        zzhh zzhhVar = this.zzb;
        zzhhVar.zzg();
        if (zzd() == 0) {
            zzc();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences sharedPreferencesZzd = zzhhVar.zzd();
        String str2 = this.zzc;
        long j3 = sharedPreferencesZzd.getLong(str2, 0L);
        if (j3 <= 0) {
            SharedPreferences.Editor editorEdit = zzhhVar.zzd().edit();
            editorEdit.putString(this.zzd, str);
            editorEdit.putLong(str2, 1L);
            editorEdit.apply();
            return;
        }
        long jNextLong = zzhhVar.zzu.zzk().zzf().nextLong() & LocationRequestCompat.PASSIVE_INTERVAL;
        long j8 = j3 + 1;
        long j9 = LocationRequestCompat.PASSIVE_INTERVAL / j8;
        SharedPreferences.Editor editorEdit2 = zzhhVar.zzd().edit();
        if (jNextLong < j9) {
            editorEdit2.putString(this.zzd, str);
        }
        editorEdit2.putLong(str2, j8);
        editorEdit2.apply();
    }

    @WorkerThread
    public final Pair zzb() {
        long jAbs;
        zzhh zzhhVar = this.zzb;
        zzhhVar.zzg();
        zzhhVar.zzg();
        long jZzd = zzd();
        if (jZzd == 0) {
            zzc();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jZzd - zzhhVar.zzu.zzaZ().currentTimeMillis());
        }
        long j = this.zze;
        if (jAbs < j) {
            return null;
        }
        if (jAbs > j + j) {
            zzc();
            return null;
        }
        String string = zzhhVar.zzd().getString(this.zzd, null);
        long j3 = zzhhVar.zzd().getLong(this.zzc, 0L);
        zzc();
        return (string == null || j3 <= 0) ? zzhh.zza : new Pair(string, Long.valueOf(j3));
    }
}
