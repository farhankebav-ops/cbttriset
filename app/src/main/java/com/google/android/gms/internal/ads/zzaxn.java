package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaxn implements zzaxr {
    final /* synthetic */ Activity zza;

    public zzaxn(zzaxs zzaxsVar, Activity activity) {
        this.zza = activity;
        Objects.requireNonNull(zzaxsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.zza);
    }
}
