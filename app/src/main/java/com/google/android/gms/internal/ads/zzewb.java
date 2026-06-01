package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzewb implements zzexy {
    private final zzfgn zza;

    @Nullable
    private final PackageInfo zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;

    public zzewb(zzfgn zzfgnVar, @Nullable PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzfgnVar;
        this.zzb = packageInfo;
        this.zzc = zzgVar;
    }

    private final void zzc(Bundle bundle) {
        int i2;
        zzbhx zzbhxVar = this.zza.zzj;
        if (zzbhxVar == null || (i2 = zzbhxVar.zzi) == 0) {
            return;
        }
        bundle.putBoolean("sccg_tap", zzbhxVar.zzj);
        bundle.putInt("sccg_dir", i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00e1  */
    @Override // com.google.android.gms.internal.ads.zzexy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zza(java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewb.zza(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ArrayList arrayList = this.zza.zzh;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        zzc(zzcxqVar.zzb);
    }
}
