package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.unity3d.services.core.device.MimeTypes;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcb {

    @Nullable
    private static AudioManager zza;

    public static synchronized AudioManager zza(Context context) {
        try {
            final Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                zza = null;
            }
            AudioManager audioManager = zza;
            if (audioManager != null) {
                return audioManager;
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
                final zzdf zzdfVar = new zzdf(zzdc.zza);
                zzcw.zza().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzca
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzcb.zzd(applicationContext, zzdfVar);
                    }
                });
                zzdfVar.zzd();
                AudioManager audioManager2 = zza;
                if (audioManager2 != null) {
                    return audioManager2;
                }
                throw null;
            }
            AudioManager audioManager3 = (AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            zza = audioManager3;
            if (audioManager3 != null) {
                return audioManager3;
            }
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static int zzb(AudioManager audioManager, zzbz zzbzVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return audioManager.requestAudioFocus(zzbzVar.zzc());
        }
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListenerZzb = zzbzVar.zzb();
        zzbzVar.zza();
        return audioManager.requestAudioFocus(onAudioFocusChangeListenerZzb, 3, 1);
    }

    public static int zzc(AudioManager audioManager, zzbz zzbzVar) {
        return Build.VERSION.SDK_INT >= 26 ? audioManager.abandonAudioFocusRequest(zzbzVar.zzc()) : audioManager.abandonAudioFocus(zzbzVar.zzb());
    }

    public static /* synthetic */ void zzd(Context context, zzdf zzdfVar) {
        zza = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        zzdfVar.zza();
    }
}
