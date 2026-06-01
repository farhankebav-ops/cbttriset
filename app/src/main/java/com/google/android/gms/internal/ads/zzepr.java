package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzepr implements zzeya {
    private final Context zza;

    public zzepr(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return zzgui.zza(new zzeps(ContextCompat.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 2;
    }
}
