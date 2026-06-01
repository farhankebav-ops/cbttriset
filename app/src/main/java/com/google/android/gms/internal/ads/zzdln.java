package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdln {

    @Nullable
    private zzbif zza;

    public zzdln(zzdky zzdkyVar) {
        this.zza = zzdkyVar;
    }

    @Nullable
    public final synchronized zzbif zza() {
        return this.zza;
    }

    public final synchronized void zzb(@Nullable zzbif zzbifVar) {
        this.zza = zzbifVar;
    }
}
