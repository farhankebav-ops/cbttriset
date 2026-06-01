package com.google.android.play.core.install;

import androidx.camera.core.processing.util.a;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zza extends InstallState {
    private final int zza;
    private final long zzb;
    private final long zzc;
    private final int zzd;
    private final String zze;

    public zza(int i2, long j, long j3, int i8, String str) {
        this.zza = i2;
        this.zzb = j;
        this.zzc = j3;
        this.zzd = i8;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.zze = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long bytesDownloaded() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.zza == installState.installStatus() && this.zzb == installState.bytesDownloaded() && this.zzc == installState.totalBytesToDownload() && this.zzd == installState.installErrorCode() && this.zze.equals(installState.packageName())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zza ^ 1000003;
        long j = this.zzb;
        long j3 = this.zzc;
        return (((((((i2 * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.zzd) * 1000003) ^ this.zze.hashCode();
    }

    @Override // com.google.android.play.core.install.InstallState
    @InstallErrorCode
    public final int installErrorCode() {
        return this.zzd;
    }

    @Override // com.google.android.play.core.install.InstallState
    @InstallStatus
    public final int installStatus() {
        return this.zza;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String packageName() {
        return this.zze;
    }

    public final String toString() {
        int i2 = this.zza;
        long j = this.zzb;
        long j3 = this.zzc;
        int i8 = this.zzd;
        String str = this.zze;
        StringBuilder sb = new StringBuilder("InstallState{installStatus=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        a.y(sb, ", totalBytesToDownload=", j3, ", installErrorCode=");
        sb.append(i8);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long totalBytesToDownload() {
        return this.zzc;
    }
}
