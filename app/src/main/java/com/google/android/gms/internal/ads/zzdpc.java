package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzdpc implements zzglu {
    static final /* synthetic */ zzdpc zza = new zzdpc();

    private /* synthetic */ zzdpc() {
    }

    @Override // com.google.android.gms.internal.ads.zzglu
    public final /* synthetic */ Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzdpa zzdpaVar : (List) obj) {
            if (zzdpaVar != null) {
                arrayList.add(zzdpaVar);
            }
        }
        return arrayList;
    }
}
