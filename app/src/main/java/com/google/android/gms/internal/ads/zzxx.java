package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(32)
final class zzxx {

    @Nullable
    private final Spatializer zza;
    private final boolean zzb;

    @Nullable
    private final Handler zzc;

    @Nullable
    private final Spatializer$OnSpatializerStateChangedListener zzd;

    public zzxx(@Nullable Context context, zzyi zzyiVar, @Nullable Boolean bool) {
        AudioManager audioManagerZza = context == null ? null : zzcb.zza(context);
        if (audioManagerZza == null || (bool != null && bool.booleanValue())) {
            this.zza = null;
            this.zzb = false;
            this.zzc = null;
            this.zzd = null;
            return;
        }
        Spatializer spatializer = audioManagerZza.getSpatializer();
        this.zza = spatializer;
        this.zzb = spatializer.getImmersiveAudioLevel() != 0;
        zzxv zzxvVar = new zzxv(this, zzyiVar);
        this.zzd = zzxvVar;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        final Handler handler = new Handler(looperMyLooper);
        this.zzc = handler;
        spatializer.addOnSpatializerStateChangedListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzxw
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, zzxvVar);
    }

    public final boolean zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return androidx.core.view.accessibility.a.c(spatializer).isAvailable();
    }

    public final boolean zzc() {
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return androidx.core.view.accessibility.a.c(spatializer).isEnabled();
    }

    public final boolean zzd(zzd zzdVar, zzv zzvVar) {
        int i2;
        String str = zzvVar.zzo;
        if (Objects.equals(str, "audio/eac3-joc")) {
            i2 = zzvVar.zzG;
            if (i2 == 16) {
                i2 = 12;
            }
        } else if (Objects.equals(str, "audio/iamf")) {
            i2 = zzvVar.zzG;
            if (i2 == -1) {
                i2 = 6;
            }
        } else if (Objects.equals(str, "audio/ac4")) {
            i2 = zzvVar.zzG;
            if (i2 == 18 || i2 == 21) {
                i2 = 24;
            }
        } else {
            i2 = zzvVar.zzG;
        }
        int iZzB = zzep.zzB(i2);
        if (iZzB == 0) {
            return false;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(iZzB);
        int i8 = zzvVar.zzH;
        if (i8 != -1) {
            channelMask.setSampleRate(i8);
        }
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return androidx.core.view.accessibility.a.c(spatializer).canBeSpatialized(zzdVar.zza(), channelMask.build());
    }

    public final void zze() {
        Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener;
        Handler handler;
        Spatializer spatializer = this.zza;
        if (spatializer == null || (spatializer$OnSpatializerStateChangedListener = this.zzd) == null || (handler = this.zzc) == null) {
            return;
        }
        spatializer.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
        handler.removeCallbacksAndMessages(null);
    }
}
