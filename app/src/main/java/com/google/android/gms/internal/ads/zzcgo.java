package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcgo {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    public zzcgo(String str) {
    }

    public final boolean zza() {
        return this.zza.get();
    }

    public final void zzb() {
        this.zza.set(true);
    }

    public final void zzc() {
        this.zza.set(false);
    }

    public final void zzd() {
        this.zza.set(false);
    }
}
