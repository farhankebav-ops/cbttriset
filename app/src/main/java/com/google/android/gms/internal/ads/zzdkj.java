package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdkj implements zzblx {
    private final WeakReference zza;
    private final zzfng zzb;
    private final com.google.android.gms.ads.internal.util.client.zzv zzc;
    private final zzflm zzd;

    public /* synthetic */ zzdkj(zzdkk zzdkkVar, zzfng zzfngVar, com.google.android.gms.ads.internal.util.client.zzv zzvVar, zzflm zzflmVar, byte[] bArr) {
        this.zza = new WeakReference(zzdkkVar);
        this.zzb = zzfngVar;
        this.zzc = zzvVar;
        this.zzd = zzflmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        zzdkk zzdkkVar = (zzdkk) this.zza.get();
        String str = (String) map.get("u");
        if (zzdkkVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.zzb.zzb(str, this.zzc, this.zzd, zzdkkVar.zzF());
    }
}
