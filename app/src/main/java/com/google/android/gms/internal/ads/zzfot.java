package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfot {
    private boolean zza;

    public final boolean zza() {
        return this.zza;
    }

    public final void zzb(Context context) {
        zzfqs.zzb(context, "Application Context cannot be null");
        if (this.zza) {
            return;
        }
        this.zza = true;
        zzfqa.zza().zzb(context);
        zzfpr.zza().zzd(context);
        zzfqn.zza(context);
        zzfqo.zza(context);
        zzfqr.zza(context);
        zzfpx.zza().zzc(context);
        zzfpq.zza().zzc(context);
        zzfqc.zza().zzb(context);
    }
}
