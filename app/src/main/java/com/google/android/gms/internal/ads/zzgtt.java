package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgtt extends zzgtk {
    private List zza;

    public zzgtt(zzgpa zzgpaVar, boolean z2) {
        super(zzgpaVar, z2, true);
        List listZzb = zzgpaVar.isEmpty() ? Collections.EMPTY_LIST : zzgqe.zzb(zzgpaVar.size());
        for (int i2 = 0; i2 < zzgpaVar.size(); i2++) {
            listZzb.add(null);
        }
        this.zza = listZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    public final void zzA(int i2) {
        super.zzA(i2);
        this.zza = null;
    }

    public abstract Object zzD(List list);

    @Override // com.google.android.gms.internal.ads.zzgtk
    public final void zzw(int i2, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i2, new zzgts(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    public final void zzx() {
        List list = this.zza;
        if (list != null) {
            zza(zzD(list));
        }
    }
}
