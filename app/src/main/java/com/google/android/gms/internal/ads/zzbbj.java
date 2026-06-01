package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbbj extends com.google.android.gms.ads.internal.client.zzcn {
    private final AppEventListener zza;

    public zzbbj(AppEventListener appEventListener) {
        this.zza = appEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzb(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }

    public final AppEventListener zzc() {
        return this.zza;
    }
}
