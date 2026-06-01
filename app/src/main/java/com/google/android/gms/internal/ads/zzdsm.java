package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdsm implements zzczj {

    @Nullable
    private final zzcgy zza;

    public zzdsm(@Nullable zzcgy zzcgyVar) {
        this.zza = zzcgyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zza(@Nullable Context context) {
        zzcgy zzcgyVar = this.zza;
        if (zzcgyVar != null) {
            zzcgyVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zzb(@Nullable Context context) {
        zzcgy zzcgyVar = this.zza;
        if (zzcgyVar != null) {
            zzcgyVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zzc(@Nullable Context context) {
        zzcgy zzcgyVar = this.zza;
        if (zzcgyVar != null) {
            zzcgyVar.destroy();
        }
    }
}
