package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfiq {
    private final HashMap zza = new HashMap();

    public final zzfip zza(zzfig zzfigVar, Context context, zzfhy zzfhyVar, zzfiv zzfivVar) {
        HashMap map = this.zza;
        zzfip zzfipVar = (zzfip) map.get(zzfigVar);
        if (zzfipVar != null) {
            return zzfipVar;
        }
        zzfid zzfidVar = new zzfid(zzfij.zza(zzfigVar, context));
        zzfip zzfipVar2 = new zzfip(zzfidVar, new zzfiy(zzfidVar, zzfhyVar, zzfivVar));
        map.put(zzfigVar, zzfipVar2);
        return zzfipVar2;
    }
}
