package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzghy {
    private final Set zza;
    private final zzgip zzb;

    public zzghy(zzgip zzgipVar, Set set) {
        this.zza = set;
        this.zzb = zzgipVar;
    }

    public final void zza(List list) {
        this.zzb.zza(list);
    }

    public final Map zzb() {
        HashMap map = new HashMap();
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzgia) it.next()).zzb(map);
        }
        return map;
    }

    public final Map zzc(Context context, View view) {
        HashMap map = new HashMap();
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzgia) it.next()).zzc(map, context, view);
        }
        return map;
    }

    public final Map zzd() {
        HashMap map = new HashMap();
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzgia) it.next()).zzd(map);
        }
        return map;
    }
}
