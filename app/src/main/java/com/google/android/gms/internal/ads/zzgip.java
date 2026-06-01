package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgip implements zzgia {
    private final List zza = new ArrayList();

    public final synchronized void zza(List list) {
        List list2 = this.zza;
        list2.clear();
        list2.addAll(list);
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final synchronized void zzc(Map map, Context context, View view) {
        List list = this.zza;
        map.put("vst", new ArrayList(list));
        list.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzb(Map map) {
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzd(Map map) {
    }
}
