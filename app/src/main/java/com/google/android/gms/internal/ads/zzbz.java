package com.google.android.gms.internal.ads;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbz {
    private final AudioManager.OnAudioFocusChangeListener zzb;
    private final Handler zzc;
    private final zzd zzd;

    @Nullable
    private final Object zzf;
    private final int zza = 1;
    private final boolean zze = false;

    public zzbz(int i2, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, zzd zzdVar, boolean z2) {
        this.zzc = handler;
        this.zzd = zzdVar;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 26) {
            this.zzb = new zzby(onAudioFocusChangeListener, handler);
        } else {
            this.zzb = onAudioFocusChangeListener;
        }
        this.zzf = i8 >= 26 ? com.facebook.ads.internal.dynamicloading.a.h().setAudioAttributes(zzdVar.zza()).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build() : null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbz)) {
            return false;
        }
        zzbz zzbzVar = (zzbz) obj;
        return Objects.equals(this.zzb, zzbzVar.zzb) && Objects.equals(this.zzc, zzbzVar.zzc) && Objects.equals(this.zzd, zzbzVar.zzd);
    }

    public final int hashCode() {
        return Objects.hash(1, this.zzb, this.zzc, this.zzd, Boolean.FALSE);
    }

    public final zzd zza() {
        return this.zzd;
    }

    public final AudioManager.OnAudioFocusChangeListener zzb() {
        return this.zzb;
    }

    @RequiresApi(26)
    public final AudioFocusRequest zzc() {
        Object obj = this.zzf;
        obj.getClass();
        return com.facebook.ads.internal.dynamicloading.a.m(obj);
    }
}
