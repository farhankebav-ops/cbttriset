package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzevx implements zzexy {
    public final zzfft zza;

    public zzevx(zzfft zzfftVar) {
        this.zza = zzfftVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzcxq zzcxqVar = (zzcxq) obj;
        zzfft zzfftVar = this.zza;
        if (zzfftVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmV)).booleanValue()) {
                return;
            }
            Bundle bundle = zzcxqVar.zza;
            bundle.putBoolean("render_in_browser", zzfftVar.zzb());
            bundle.putBoolean("disable_ml", zzfftVar.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* synthetic */ void zzb(Object obj) {
        p.a(this, obj);
    }
}
