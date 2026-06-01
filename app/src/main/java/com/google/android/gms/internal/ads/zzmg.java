package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzmg {
    private boolean zza;

    public zzmg(Context context, Looper looper, zzdc zzdcVar) {
        context.getApplicationContext();
        zzdcVar.zzd(looper, null);
    }

    public final void zza(boolean z2) {
        if (this.zza == z2) {
            return;
        }
        this.zza = z2;
    }
}
