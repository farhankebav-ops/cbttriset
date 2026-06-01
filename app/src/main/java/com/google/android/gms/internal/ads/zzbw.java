package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbw {

    @Nullable
    private AudioManager.OnAudioFocusChangeListener zza;

    @Nullable
    private Handler zzb;
    private zzd zzc = zzd.zza;

    public zzbw(int i2) {
    }

    public final zzbw zza(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        this.zza = onAudioFocusChangeListener;
        this.zzb = handler;
        return this;
    }

    public final zzbw zzb(zzd zzdVar) {
        this.zzc = zzdVar;
        return this;
    }

    public final zzbz zzc() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.zza;
        if (onAudioFocusChangeListener == null) {
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }
        Handler handler = this.zzb;
        handler.getClass();
        return new zzbz(1, onAudioFocusChangeListener, handler, this.zzc, false);
    }
}
