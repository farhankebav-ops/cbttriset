package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.ironsource.C2300e4;
import com.ironsource.Q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeyn implements zzexy {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzeyn(String str, int i2, int i8, int i9, boolean z2, int i10) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = i9;
        this.zze = z2;
        this.zzf = i10;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcxq) obj).zza;
        zzfhc.zzb(bundle, Q6.P0, this.zza, !TextUtils.isEmpty(r0));
        int i2 = this.zzb;
        zzfhc.zzc(bundle, "cnt", i2, i2 != -2);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt("pt", this.zzd);
        Bundle bundleZza = zzfhc.zza(bundle, C2300e4.h.G);
        bundle.putBundle(C2300e4.h.G, bundleZza);
        Bundle bundleZza2 = zzfhc.zza(bundleZza, "network");
        bundleZza.putBundle("network", bundleZza2);
        bundleZza2.putInt("active_network_state", this.zzf);
        bundleZza2.putBoolean("active_network_metered", this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* synthetic */ void zzb(Object obj) {
        p.a(this, obj);
    }
}
