package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaqa {

    @Nullable
    public final Object zza;

    @Nullable
    public final zzapd zzb;

    @Nullable
    public final zzaqd zzc;
    public boolean zzd;

    private zzaqa(zzaqd zzaqdVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzaqdVar;
    }

    public static zzaqa zza(@Nullable Object obj, @Nullable zzapd zzapdVar) {
        return new zzaqa(obj, zzapdVar);
    }

    public static zzaqa zzb(zzaqd zzaqdVar) {
        return new zzaqa(zzaqdVar);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }

    private zzaqa(@Nullable Object obj, @Nullable zzapd zzapdVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzapdVar;
        this.zzc = null;
    }
}
