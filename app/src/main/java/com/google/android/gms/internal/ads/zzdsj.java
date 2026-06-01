package com.google.android.gms.internal.ads;

import android.view.InputEvent;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdsj {
    private volatile InputEvent zza;

    @VisibleForTesting(otherwise = 3)
    public zzdsj() {
    }

    public final void zza(InputEvent inputEvent) {
        this.zza = inputEvent;
    }

    public final InputEvent zzb() {
        return this.zza;
    }
}
