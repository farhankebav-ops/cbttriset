package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeyh implements zzexy {
    private final int zza;
    private final int zzb;

    public zzeyh(int i2, int i8) {
        this.zza = i2;
        this.zzb = i8;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        int i2;
        Bundle bundle = ((zzcxq) obj).zza;
        int i8 = this.zza;
        if (i8 == -1 || (i2 = this.zzb) == -1) {
            return;
        }
        bundle.putInt("sessions_without_flags", i8);
        bundle.putInt("crashes_without_flags", i2);
        int i9 = com.google.android.gms.ads.internal.client.zzbb.zza;
        if (com.google.android.gms.ads.internal.client.zzbd.zzc().zzc()) {
            bundle.putBoolean("did_reset", true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* synthetic */ void zzb(Object obj) {
        p.a(this, obj);
    }
}
