package com.google.android.gms.ads.formats;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class UnifiedNativeAd {
    @KeepForSdk
    public abstract void performClick(@NonNull Bundle bundle);

    @KeepForSdk
    public abstract boolean recordImpression(@NonNull Bundle bundle);

    @KeepForSdk
    public abstract void reportTouchEvent(@NonNull Bundle bundle);

    @NonNull
    public abstract String zza();

    @NonNull
    public abstract List zzb();

    @NonNull
    public abstract String zzc();

    @NonNull
    public abstract NativeAd.Image zzd();

    @NonNull
    public abstract String zze();

    @NonNull
    public abstract String zzf();

    @NonNull
    public abstract Double zzg();

    @NonNull
    public abstract String zzh();

    @NonNull
    public abstract String zzi();

    @NonNull
    @Deprecated
    public abstract VideoController zzj();

    @NonNull
    public abstract Object zzk();
}
