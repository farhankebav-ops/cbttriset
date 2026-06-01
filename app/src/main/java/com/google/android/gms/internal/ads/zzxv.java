package com.google.android.gms.internal.ads;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxv implements Spatializer$OnSpatializerStateChangedListener {
    final /* synthetic */ zzyi zza;

    public zzxv(zzxx zzxxVar, zzyi zzyiVar) {
        this.zza = zzyiVar;
        Objects.requireNonNull(zzxxVar);
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z2) {
        this.zza.zzl();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z2) {
        this.zza.zzl();
    }
}
