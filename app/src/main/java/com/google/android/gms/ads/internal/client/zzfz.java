package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfz extends zzef {
    private final VideoController.VideoLifecycleCallbacks zza;

    public zzfz(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zza = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zze() {
        this.zza.onVideoStart();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzf() {
        this.zza.onVideoPlay();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzg() {
        this.zza.onVideoPause();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzh() {
        this.zza.onVideoEnd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzi(boolean z2) {
        this.zza.onVideoMute(z2);
    }
}
