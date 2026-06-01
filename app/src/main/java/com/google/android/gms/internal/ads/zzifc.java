package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzifc {
    final LinkedHashMap zza;

    public zzifc(int i2) {
        this.zza = zzife.zzc(i2);
    }

    public final zzifc zza(Object obj, zzifq zzifqVar) {
        zzifp.zza(obj, C2300e4.h.W);
        zzifp.zza(zzifqVar, IronSourceConstants.EVENTS_PROVIDER);
        this.zza.put(obj, zzifqVar);
        return this;
    }
}
