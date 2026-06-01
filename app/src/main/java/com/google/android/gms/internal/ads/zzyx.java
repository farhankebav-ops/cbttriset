package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzyx {
    private final Handler zza;
    private final zzyz zzb;
    private boolean zzc;

    public zzyx(Handler handler, zzyz zzyzVar) {
        this.zza = handler;
        this.zzb = zzyzVar;
    }

    public final void zza() {
        this.zzc = true;
    }

    public final /* synthetic */ Handler zzb() {
        return this.zza;
    }

    public final /* synthetic */ zzyz zzc() {
        return this.zzb;
    }

    public final /* synthetic */ boolean zzd() {
        return this.zzc;
    }
}
