package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhcv implements zzhcx {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    public zzhcv(boolean z2) {
    }

    @Override // com.google.android.gms.internal.ads.zzhcx
    public final boolean zza() {
        return this.zza.get();
    }
}
