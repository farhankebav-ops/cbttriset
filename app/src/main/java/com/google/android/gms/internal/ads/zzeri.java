package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeri implements zzexy {

    @Nullable
    @VisibleForTesting
    final ArrayList zza;

    public zzeri(@Nullable ArrayList arrayList) {
        this.zza = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzfhc.zzg(((zzcxq) obj).zza, "android_permissions", this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* synthetic */ void zzb(Object obj) {
        p.a(this, obj);
    }
}
