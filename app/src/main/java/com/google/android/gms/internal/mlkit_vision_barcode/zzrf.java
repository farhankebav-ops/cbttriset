package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.annotation.Nullable;
import com.google.firebase.encoders.annotations.Encodable;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Encodable
public final class zzrf {
    private final zzvd zza;
    private final zzrc zzb;
    private final zzra zzc;
    private final zzrr zzd;
    private final zzru zze;
    private final zzfv zzf;
    private final zzut zzg;

    public /* synthetic */ zzrf(zzrd zzrdVar, zzre zzreVar) {
        this.zza = zzrdVar.zza;
        this.zzb = zzrdVar.zzb;
        this.zzc = zzrdVar.zzc;
        this.zzd = zzrdVar.zzd;
        this.zze = zzrdVar.zze;
        this.zzf = zzrdVar.zzf;
        this.zzg = zzrdVar.zzg;
    }

    @Nullable
    @zzfe(zza = 33)
    public final zzfv zza() {
        return this.zzf;
    }

    @Nullable
    @zzfe(zza = Sdk.SDKMetric.SDKMetricType.APP_BACKGROUND_DURING_AD_LOAD_VALUE)
    public final zzra zzb() {
        return this.zzc;
    }

    @Nullable
    @zzfe(zza = 2)
    public final zzrc zzc() {
        return this.zzb;
    }

    @Nullable
    @zzfe(zza = 7)
    public final zzrr zzd() {
        return this.zzd;
    }

    @Nullable
    @zzfe(zza = Sdk.SDKMetric.SDKMetricType.INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE)
    public final zzru zze() {
        return this.zze;
    }

    @Nullable
    @zzfe(zza = 106)
    public final zzut zzf() {
        return this.zzg;
    }

    @Nullable
    @zzfe(zza = 1)
    public final zzvd zzg() {
        return this.zza;
    }
}
