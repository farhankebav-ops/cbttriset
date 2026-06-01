package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzccm implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzccv zzb;

    public zzccm(zzccv zzccvVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        Objects.requireNonNull(zzccvVar);
        this.zzb = zzccvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzccv zzccvVar = this.zzb;
        zzccvVar.zzs(this.zza);
        if (zzccvVar.zzt() != null) {
            zzccvVar.zzt().zzb();
        }
    }
}
