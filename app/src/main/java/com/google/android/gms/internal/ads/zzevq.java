package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzevq implements zzexy {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;

    public zzevq(String str, boolean z2, boolean z7, boolean z8, boolean z9) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = z7;
        this.zzd = z8;
        this.zze = z9;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcxq) obj).zza;
        String str = this.zza;
        if (!str.isEmpty()) {
            bundle.putString("inspector_extras", str);
        }
        boolean z2 = this.zzb;
        bundle.putInt("test_mode", z2 ? 1 : 0);
        boolean z7 = this.zzc;
        bundle.putInt("linked_device", z7 ? 1 : 0);
        if (z2 || z7) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkj)).booleanValue()) {
                bundle.putInt("risd", !this.zzd ? 1 : 0);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkn)).booleanValue()) {
                bundle.putBoolean("collect_response_logs", this.zze);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcxq) obj).zzb;
        String str = this.zza;
        if (!str.isEmpty()) {
            bundle.putString("inspector_extras", str);
        }
        boolean z2 = this.zzb;
        bundle.putInt("test_mode", z2 ? 1 : 0);
        boolean z7 = this.zzc;
        bundle.putInt("linked_device", z7 ? 1 : 0);
        if (z2 || z7) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkn)).booleanValue()) {
                bundle.putBoolean("collect_response_logs", this.zze);
            }
        }
    }
}
