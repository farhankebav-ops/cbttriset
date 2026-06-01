package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzce {
    public static final zzce zza = new zzce(0);
    public final long zzb;

    public zzce(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j) {
        zzgmd.zza(j >= 0);
        this.zzb = j;
    }
}
