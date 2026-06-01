package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdqg implements zzblx {

    @Nullable
    private final zzbjm zza;
    private final zzdqt zzb;
    private final zzifb zzc;

    public zzdqg(zzdma zzdmaVar, zzdlq zzdlqVar, zzdqt zzdqtVar, zzifb zzifbVar) {
        this.zza = zzdmaVar.zzg(zzdlqVar.zzS());
        this.zzb = zzdqtVar;
        this.zzc = zzifbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbjc) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            String strS = a1.a.s(new StringBuilder(String.valueOf(str).length() + 40), "Failed to call onCustomClick for asset ", str, ".");
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strS, e);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzd("/nativeAdCustomClick", this);
    }
}
