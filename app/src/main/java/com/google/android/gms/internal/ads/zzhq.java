package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class zzhq {
    private final zzgmv zza;
    private final Handler zzb;

    @Nullable
    private zzhp zzc;

    @Nullable
    private zzd zzd;
    private int zzf;
    private zzbz zzh;
    private float zzg = 1.0f;
    private int zze = 0;

    public zzhq(final Context context, Looper looper, zzhp zzhpVar) {
        this.zza = zzgmz.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzho
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return zzcb.zza(context);
            }
        });
        this.zzc = zzhpVar;
        this.zzb = new Handler(looper);
    }

    private final void zzf() {
        int i2 = this.zze;
        if (i2 == 1 || i2 == 0 || this.zzh == null) {
            return;
        }
        zzcb.zzc((AudioManager) this.zza.zza(), this.zzh);
    }

    private final void zzg(int i2) {
        if (this.zze == i2) {
            return;
        }
        this.zze = i2;
        float f4 = i2 == 4 ? 0.2f : 1.0f;
        if (this.zzg != f4) {
            this.zzg = f4;
            zzhp zzhpVar = this.zzc;
            if (zzhpVar != null) {
                zzhpVar.zza(f4);
            }
        }
    }

    private final void zzh(int i2) {
        zzhp zzhpVar = this.zzc;
        if (zzhpVar != null) {
            zzhpVar.zzb(i2);
        }
    }

    public final float zza() {
        return this.zzg;
    }

    public final void zzb(@Nullable zzd zzdVar) {
        if (Objects.equals(this.zzd, zzdVar)) {
            return;
        }
        this.zzd = zzdVar;
        this.zzf = zzdVar == null ? 0 : 1;
    }

    public final int zzc(boolean z2, int i2) {
        if (i2 == 1 || this.zzf != 1) {
            zzf();
            zzg(0);
            return 1;
        }
        if (!z2) {
            int i8 = this.zze;
            if (i8 != 1) {
                return i8 != 3 ? 1 : 0;
            }
            return -1;
        }
        if (this.zze == 2) {
            return 1;
        }
        if (this.zzh == null) {
            zzbw zzbwVar = new zzbw(1);
            zzd zzdVar = this.zzd;
            zzdVar.getClass();
            zzbwVar.zzb(zzdVar);
            zzbwVar.zza(new AudioManager.OnAudioFocusChangeListener() { // from class: com.google.android.gms.internal.ads.zzhn
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final /* synthetic */ void onAudioFocusChange(int i9) {
                    this.zza.zze(i9);
                }
            }, this.zzb);
            this.zzh = zzbwVar.zzc();
        }
        if (zzcb.zzb((AudioManager) this.zza.zza(), this.zzh) == 1) {
            zzg(2);
            return 1;
        }
        zzg(1);
        return -1;
    }

    public final void zzd() {
        this.zzc = null;
        zzf();
        zzg(0);
    }

    public final /* synthetic */ void zze(int i2) {
        if (i2 == -3 || i2 == -2) {
            if (i2 != -2) {
                zzg(4);
                return;
            } else {
                zzh(0);
                zzg(3);
                return;
            }
        }
        if (i2 == -1) {
            zzh(-1);
            zzf();
            zzg(1);
        } else if (i2 != 1) {
            com.google.android.gms.ads.internal.client.a.s(new StringBuilder(String.valueOf(i2).length() + 27), "Unknown focus change type: ", i2, "AudioFocusManager");
        } else {
            zzg(2);
            zzh(1);
        }
    }
}
