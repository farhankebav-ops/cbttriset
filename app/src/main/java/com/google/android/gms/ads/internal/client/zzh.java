package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdLoadCallback;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzh extends zzbm {
    private final AdLoadCallback zza;
    private final Object zzb;

    public zzh(AdLoadCallback adLoadCallback, Object obj) {
        this.zza = adLoadCallback;
        this.zzb = obj;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb() {
        Object obj;
        AdLoadCallback adLoadCallback = this.zza;
        if (adLoadCallback == null || (obj = this.zzb) == null) {
            return;
        }
        adLoadCallback.onAdLoaded(obj);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzc(zze zzeVar) {
        AdLoadCallback adLoadCallback = this.zza;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }
}
