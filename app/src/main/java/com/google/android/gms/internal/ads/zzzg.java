package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzzg implements zzdg {
    static final /* synthetic */ zzzg zza = new zzzg();

    private /* synthetic */ zzzg() {
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final /* synthetic */ void zza(Object obj) {
        ((ExecutorService) obj).shutdown();
    }
}
