package com.google.android.gms.ads.preload;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzcg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzea;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zza extends zzcg {
    final /* synthetic */ PreloadCallbackV2 zza;

    public zza(zzb zzbVar, PreloadCallbackV2 preloadCallbackV2) {
        this.zza = preloadCallbackV2;
        Objects.requireNonNull(zzbVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zze(String str, @Nullable zzea zzeaVar) {
        this.zza.onAdPreloaded(str, ResponseInfo.zzb(zzeaVar));
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzf(String str) {
        this.zza.onAdsExhausted(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzg(String str, zze zzeVar) {
        this.zza.onAdFailedToPreload(str, zzeVar.zzb());
    }
}
