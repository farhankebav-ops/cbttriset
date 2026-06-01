package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqn {

    @Nullable
    private final Context zza;
    private Boolean zzb;

    public zzqn() {
        this(null);
    }

    public final zzpl zza(zzv zzvVar, zzd zzdVar) {
        int i2;
        boolean zBooleanValue;
        zzvVar.getClass();
        zzdVar.getClass();
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 29 || (i2 = zzvVar.zzH) == -1) {
            return zzpl.zza;
        }
        Context context = this.zza;
        Boolean bool = this.zzb;
        boolean z2 = false;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            if (context != null) {
                String parameters = zzcb.zza(context).getParameters("offloadVariableRateSupported");
                this.zzb = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
            } else {
                this.zzb = Boolean.FALSE;
            }
            zBooleanValue = this.zzb.booleanValue();
        }
        String str = zzvVar.zzo;
        str.getClass();
        int iZzh = zzas.zzh(str, zzvVar.zzk);
        if (iZzh == 0 || i8 < zzep.zzD(iZzh)) {
            return zzpl.zza;
        }
        int iZzB = zzep.zzB(zzvVar.zzG);
        if (iZzB == 0) {
            return zzpl.zza;
        }
        try {
            AudioFormat audioFormatZzC = zzep.zzC(i2, iZzB, iZzh);
            if (i8 < 31) {
                if (!AudioManager.isOffloadedPlaybackSupported(audioFormatZzC, zzdVar.zza())) {
                    return zzpl.zza;
                }
                zzpk zzpkVar = new zzpk();
                zzpkVar.zza(true);
                zzpkVar.zzc(zBooleanValue);
                return zzpkVar.zzd();
            }
            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormatZzC, zzdVar.zza());
            if (playbackOffloadSupport == 0) {
                return zzpl.zza;
            }
            zzpk zzpkVar2 = new zzpk();
            if (i8 > 32 && playbackOffloadSupport == 2) {
                z2 = true;
            }
            zzpkVar2.zza(true);
            zzpkVar2.zzb(z2);
            zzpkVar2.zzc(zBooleanValue);
            return zzpkVar2.zzd();
        } catch (IllegalArgumentException unused) {
            return zzpl.zza;
        }
    }

    public zzqn(@Nullable Context context) {
        this.zza = context == null ? null : context.getApplicationContext();
    }
}
