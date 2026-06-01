package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioRouting$OnRoutingChangedListener;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
final class zzrb {
    private final AudioTrack zza;
    private final zzpj zzb;
    private final Handler zzc;

    @Nullable
    private AudioRouting$OnRoutingChangedListener zzd = new AudioRouting$OnRoutingChangedListener() { // from class: com.google.android.gms.internal.ads.zzra
        public final /* synthetic */ void onRoutingChanged(AudioRouting audioRouting) {
            this.zza.zzb(audioRouting);
        }
    };

    public zzrb(AudioTrack audioTrack, zzpj zzpjVar) {
        this.zza = audioTrack;
        this.zzb = zzpjVar;
        Handler handler = new Handler(Looper.myLooper());
        this.zzc = handler;
        audioTrack.addOnRoutingChangedListener(this.zzd, handler);
    }

    public final void zza() {
        AudioRouting$OnRoutingChangedListener audioRouting$OnRoutingChangedListener = this.zzd;
        audioRouting$OnRoutingChangedListener.getClass();
        this.zza.removeOnRoutingChangedListener(y.h(audioRouting$OnRoutingChangedListener));
        this.zzd = null;
    }

    public final /* synthetic */ void zzb(final AudioRouting audioRouting) {
        if (this.zzd == null) {
            return;
        }
        zzcw.zza().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc(audioRouting);
            }
        });
    }

    public final /* synthetic */ void zzc(AudioRouting audioRouting) {
        final AudioDeviceInfo routedDevice = audioRouting.getRoutedDevice();
        if (routedDevice != null) {
            this.zzc.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqz
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzd(routedDevice);
                }
            });
        }
    }

    public final /* synthetic */ void zzd(AudioDeviceInfo audioDeviceInfo) {
        if (this.zzd == null) {
            return;
        }
        this.zzb.zzc(audioDeviceInfo);
    }
}
