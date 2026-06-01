package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class AppUpdateInfo {

    @NonNull
    private final String zza;
    private final int zzb;

    @UpdateAvailability
    private final int zzc;

    @InstallStatus
    private final int zzd;

    @Nullable
    private final Integer zze;
    private final int zzf;
    private final long zzg;
    private final long zzh;
    private final long zzi;
    private final long zzj;

    @Nullable
    private final PendingIntent zzk;

    @Nullable
    private final PendingIntent zzl;

    @Nullable
    private final PendingIntent zzm;

    @Nullable
    private final PendingIntent zzn;
    private final Map zzo;
    private boolean zzp = false;

    private AppUpdateInfo(@NonNull String str, int i2, @UpdateAvailability int i8, @InstallStatus int i9, @Nullable Integer num, int i10, long j, long j3, long j8, long j9, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4, Map map) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = i9;
        this.zze = num;
        this.zzf = i10;
        this.zzg = j;
        this.zzh = j3;
        this.zzi = j8;
        this.zzj = j9;
        this.zzk = pendingIntent;
        this.zzl = pendingIntent2;
        this.zzm = pendingIntent3;
        this.zzn = pendingIntent4;
        this.zzo = map;
    }

    public static AppUpdateInfo zzb(@NonNull String str, int i2, @UpdateAvailability int i8, @InstallStatus int i9, @Nullable Integer num, int i10, long j, long j3, long j8, long j9, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4, Map map) {
        return new AppUpdateInfo(str, i2, i8, i9, num, i10, j, j3, j8, j9, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    private static Set zze(@Nullable Set set) {
        return set == null ? new HashSet() : set;
    }

    private final boolean zzf(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() && this.zzi <= this.zzj;
    }

    public int availableVersionCode() {
        return this.zzb;
    }

    public long bytesDownloaded() {
        return this.zzg;
    }

    @Nullable
    public Integer clientVersionStalenessDays() {
        return this.zze;
    }

    public Set<Integer> getFailedUpdatePreconditions(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() ? appUpdateOptions.appUpdateType() == 0 ? zze((Set) this.zzo.get("nonblocking.destructive.intent")) : zze((Set) this.zzo.get("blocking.destructive.intent")) : appUpdateOptions.appUpdateType() == 0 ? zze((Set) this.zzo.get("nonblocking.intent")) : zze((Set) this.zzo.get("blocking.intent"));
    }

    @InstallStatus
    public int installStatus() {
        return this.zzd;
    }

    public boolean isUpdateTypeAllowed(@AppUpdateType int i2) {
        return zza(AppUpdateOptions.defaultOptions(i2)) != null;
    }

    @NonNull
    public String packageName() {
        return this.zza;
    }

    public long totalBytesToDownload() {
        return this.zzh;
    }

    @UpdateAvailability
    public int updateAvailability() {
        return this.zzc;
    }

    public int updatePriority() {
        return this.zzf;
    }

    @Nullable
    public final PendingIntent zza(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() == 0) {
            PendingIntent pendingIntent = this.zzl;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (zzf(appUpdateOptions)) {
                return this.zzn;
            }
            return null;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            PendingIntent pendingIntent2 = this.zzk;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (zzf(appUpdateOptions)) {
                return this.zzm;
            }
        }
        return null;
    }

    public final void zzc() {
        this.zzp = true;
    }

    public final boolean zzd() {
        return this.zzp;
    }

    public boolean isUpdateTypeAllowed(@NonNull AppUpdateOptions appUpdateOptions) {
        return zza(appUpdateOptions) != null;
    }
}
