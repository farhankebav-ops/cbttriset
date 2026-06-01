package com.google.mlkit.common.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DownloadConditions {
    private final boolean zza;
    private final boolean zzb;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        private boolean zza = false;
        private boolean zzb = false;

        @NonNull
        public DownloadConditions build() {
            return new DownloadConditions(this.zza, this.zzb, null);
        }

        @NonNull
        @RequiresApi(24)
        public Builder requireCharging() {
            this.zza = true;
            return this;
        }

        @NonNull
        public Builder requireWifi() {
            this.zzb = true;
            return this;
        }
    }

    public /* synthetic */ DownloadConditions(boolean z2, boolean z7, zzb zzbVar) {
        this.zza = z2;
        this.zzb = z7;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DownloadConditions)) {
            return false;
        }
        DownloadConditions downloadConditions = (DownloadConditions) obj;
        return this.zza == downloadConditions.zza && this.zzb == downloadConditions.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb));
    }

    public boolean isChargingRequired() {
        return this.zza;
    }

    public boolean isWifiRequired() {
        return this.zzb;
    }
}
