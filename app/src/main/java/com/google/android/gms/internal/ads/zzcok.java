package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcok implements zzcnu {
    private final Context zza;
    private final com.google.android.gms.ads.internal.util.zzg zzb = com.google.android.gms.ads.internal.zzt.zzh().zzo();

    public zzcok(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcnu
    public final void zza(Map map) {
        String str;
        if (map.isEmpty() || (str = (String) map.get("gad_idless")) == null) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzb;
        boolean z2 = Boolean.parseBoolean(str);
        zzgVar.zzw(z2);
        if (z2) {
            com.google.android.gms.ads.internal.util.zzac.zza(this.zza);
        }
    }
}
