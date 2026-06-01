package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.internal.ads.zzbhx;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MediationNativeAdConfiguration extends MediationAdConfiguration {

    @Nullable
    private final zzbhx zza;

    public MediationNativeAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z2, @Nullable Location location, int i2, int i8, @Nullable String str2, String str3, @Nullable zzbhx zzbhxVar) {
        super(context, str, bundle, bundle2, z2, location, i2, i8, str2, str3);
        this.zza = zzbhxVar;
    }

    @NonNull
    public NativeAdOptions getNativeAdOptions() {
        return zzbhx.zza(this.zza);
    }
}
