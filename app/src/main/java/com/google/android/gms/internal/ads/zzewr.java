package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzewr implements zzexy {

    @Nullable
    private final Bundle zza;

    public zzewr(@Nullable Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = this.zza;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (bundle != null) {
            zzcxqVar.zza.putAll(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = this.zza;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (bundle != null) {
            zzcxqVar.zzb.putAll(bundle);
        }
    }
}
