package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaym {
    private static final String[] zza = {"android:establish_vpn_service", "android:establish_vpn_manager"};
    private long zzb = 0;
    private long zzc = 0;
    private long zzd = -1;
    private boolean zze = false;

    public zzaym(@NonNull Context context, @NonNull Executor executor, @NonNull String[] strArr) {
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        try {
            ((AppOpsManager) context.getSystemService("appops")).startWatchingActive(strArr, executor, new zzayl(this));
        } catch (IllegalArgumentException | NoSuchMethodError unused) {
        }
    }

    public static zzaym zza(@NonNull Context context, @NonNull Executor executor) {
        return new zzaym(context, executor, zza);
    }

    public final void zzb() {
        if (this.zze) {
            this.zzc = System.currentTimeMillis();
        }
    }

    public final long zzc() {
        if (this.zze) {
            return this.zzc - this.zzb;
        }
        return -1L;
    }

    public final long zzd() {
        long j = this.zzd;
        this.zzd = -1L;
        return j;
    }

    public final /* synthetic */ void zze(long j) {
        this.zzb = j;
    }

    public final /* synthetic */ long zzf() {
        return this.zzc;
    }

    public final /* synthetic */ void zzg(long j) {
        this.zzd = j;
    }

    public final /* synthetic */ void zzh(boolean z2) {
        this.zze = z2;
    }
}
