package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzere implements zzexy {
    private final com.google.android.gms.ads.internal.client.zzx zza;
    private final boolean zzb;

    public zzere(com.google.android.gms.ads.internal.client.zzx zzxVar, boolean z2) {
        this.zza = zzxVar;
        this.zzb = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcxq) obj).zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfZ)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzb);
        }
        com.google.android.gms.ads.internal.client.zzx zzxVar = this.zza;
        if (zzxVar != null) {
            int i2 = zzxVar.zza;
            if (i2 == 1) {
                bundle.putString("avo", NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON);
            } else if (i2 == 2) {
                bundle.putString("avo", "l");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* synthetic */ void zzb(Object obj) {
        p.a(this, obj);
    }
}
