package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzifh;
import com.google.android.gms.internal.ads.zzifp;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzba implements zzifh {
    private final zzay zza;

    private zzba(zzay zzayVar) {
        this.zza = zzayVar;
    }

    public static zzba zza(zzay zzayVar) {
        return new zzba(zzayVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        String strZzb = this.zza.zzb();
        zzifp.zzb(strZzb);
        return strZzb;
    }
}
