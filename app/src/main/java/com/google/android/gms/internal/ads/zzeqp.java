package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeqp implements zzeya {
    private final Set zza;

    public zzeqp(Set set) {
        this.zza = set;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return zzgui.zza(new zzeqo(arrayList, null));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 8;
    }
}
