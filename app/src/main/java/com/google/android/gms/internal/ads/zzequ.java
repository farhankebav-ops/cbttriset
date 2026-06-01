package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzequ {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    @Nullable
    private zzeqt zzb;

    public final void zza(boolean z2) {
        this.zza.set(true);
    }

    public final boolean zzb() {
        return this.zza.get();
    }

    public final void zzc(zzeqt zzeqtVar) {
        this.zzb = zzeqtVar;
    }

    @Nullable
    public final zzeqt zzd() {
        return this.zzb;
    }
}
