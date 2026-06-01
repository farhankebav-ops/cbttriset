package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaqy implements zzaqp {
    final /* synthetic */ Context zza;
    private File zzb = null;

    public zzaqy(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
