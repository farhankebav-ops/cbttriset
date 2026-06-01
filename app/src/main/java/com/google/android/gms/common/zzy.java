package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
public class zzy {
    private static final zzy zze = new zzy(true, 3, 1, null, null, -1);
    final boolean zza;
    final String zzb;
    final Throwable zzc;
    final int zzd;

    private zzy(boolean z2, int i2, int i8, String str, Throwable th, long j) {
        this.zza = z2;
        this.zzd = i2;
        this.zzb = str;
        this.zzc = th;
    }

    @Deprecated
    public static zzy zzb() {
        return zze;
    }

    public static zzy zzc(@NonNull String str) {
        return new zzy(false, 1, 5, str, null, -1L);
    }

    public static zzy zzd(@NonNull String str, @NonNull Throwable th) {
        return new zzy(false, 1, 5, str, th, -1L);
    }

    @VisibleForTesting(otherwise = 3)
    public static zzy zzf(int i2, long j) {
        return new zzy(true, i2, 1, null, null, j);
    }

    public static zzy zzg(int i2, int i8, @NonNull String str, Throwable th) {
        return new zzy(false, i2, i8, str, th, -1L);
    }

    public String zza() {
        return this.zzb;
    }

    public final void zze() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        Throwable th = this.zzc;
        if (th != null) {
            Log.d("GoogleCertificatesRslt", zza(), th);
        } else {
            Log.d("GoogleCertificatesRslt", zza());
        }
    }

    public /* synthetic */ zzy(boolean z2, int i2, int i8, String str, Throwable th, long j, byte[] bArr) {
        this(false, 1, 5, null, null, -1L);
    }
}
