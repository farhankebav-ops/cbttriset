package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfac implements zzeya {
    final ScheduledExecutorService zza;

    public zzfac(zzbvm zzbvmVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return zzgui.zzk(zzgui.zzi(zzgui.zza(new Bundle()), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeM)).longValue(), TimeUnit.MILLISECONDS, this.zza), zzfab.zza, zzcbv.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 49;
    }
}
