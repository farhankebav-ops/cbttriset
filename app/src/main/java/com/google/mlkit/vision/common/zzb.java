package com.google.mlkit.vision.common;

import android.media.Image;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzb {
    private final Image zza;

    public zzb(Image image) {
        this.zza = image;
    }

    public final Image zza() {
        return this.zza;
    }

    public final Image.Plane[] zzb() {
        return this.zza.getPlanes();
    }
}
