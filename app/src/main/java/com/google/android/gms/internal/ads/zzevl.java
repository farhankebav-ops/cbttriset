package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzevl implements zzeya {
    private final Context zza;
    private final Intent zzb;

    public zzevl(Context context, Intent intent) {
        this.zza = context;
        this.zzb = intent;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        com.google.android.gms.ads.internal.util.zze.zza("HsdpMigrationSignal.produce");
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznP)).booleanValue()) {
            return zzgui.zza(new zzevm(null));
        }
        boolean z2 = false;
        try {
            if (this.zzb.resolveActivity(this.zza.getPackageManager()) != null) {
                com.google.android.gms.ads.internal.util.zze.zza("HSDP intent is supported");
                z2 = true;
            }
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "HsdpMigrationSignal.isHsdpMigrationSupported");
        }
        return zzgui.zza(new zzevm(Boolean.valueOf(z2)));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 60;
    }
}
