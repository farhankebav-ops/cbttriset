package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdz;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdrq implements zzifh {
    private final zzifq zza;

    private zzdrq(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdrq zza(zzifq zzifqVar) {
        return new zzdrq(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbdz.zza.EnumC0130zza enumC0130zza = ((zzcyf) this.zza).zza().zzp.zza == 3 ? zzbdz.zza.EnumC0130zza.REWARDED_INTERSTITIAL : zzbdz.zza.EnumC0130zza.REWARD_BASED_VIDEO_AD;
        zzifp.zzb(enumC0130zza);
        return enumC0130zza;
    }
}
