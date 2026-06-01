package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzed;
import com.google.android.gms.ads.internal.client.zzfz;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoController {

    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;

    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;

    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();

    @Nullable
    private zzed zzb;

    @Nullable
    private VideoLifecycleCallbacks zzc;

    @KeepForSdk
    public int getPlaybackState() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return 0;
            }
            try {
                return zzedVar.zzi();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    @Nullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z2;
        synchronized (this.zza) {
            z2 = this.zzb != null;
        }
        return z2;
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return false;
            }
            try {
                return zzedVar.zzp();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return false;
            }
            try {
                return zzedVar.zzn();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return true;
            }
            try {
                return zzedVar.zzh();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public void mute(boolean z2) {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzg(z2);
            } catch (RemoteException e) {
                zzo.zzg("Unable to call mute on video controller.", e);
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzf();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call pause on video controller.", e);
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zze();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call play on video controller.", e);
            }
        }
    }

    public void setVideoLifecycleCallbacks(@Nullable VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzfz zzfzVar;
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            if (videoLifecycleCallbacks == null) {
                zzfzVar = null;
            } else {
                try {
                    zzfzVar = new zzfz(videoLifecycleCallbacks);
                } catch (RemoteException e) {
                    zzo.zzg("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
            zzedVar.zzl(zzfzVar);
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzq();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call stop on video controller.", e);
            }
        }
    }

    public final void zza(@Nullable zzed zzedVar) {
        synchronized (this.zza) {
            try {
                this.zzb = zzedVar;
                VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
                if (videoLifecycleCallbacks != null) {
                    setVideoLifecycleCallbacks(videoLifecycleCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final zzed zzb() {
        zzed zzedVar;
        synchronized (this.zza) {
            zzedVar = this.zzb;
        }
        return zzedVar;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }

        public void onVideoMute(boolean z2) {
        }
    }
}
