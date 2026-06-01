package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzby implements AudioManager.OnAudioFocusChangeListener {
    private final Handler zza;
    private final AudioManager.OnAudioFocusChangeListener zzb;

    public zzby(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        this.zzb = onAudioFocusChangeListener;
        Looper looper = handler.getLooper();
        String str = zzep.zza;
        this.zza = new Handler(looper, null);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(final int i2) {
        zzep.zzd(this.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzbx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zza(i2);
            }
        });
    }

    public final /* synthetic */ void zza(int i2) {
        this.zzb.onAudioFocusChange(i2);
    }
}
