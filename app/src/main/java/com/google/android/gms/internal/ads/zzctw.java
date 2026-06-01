package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzctw implements zzekw {
    public final List zza;

    public zzctw(List list) {
        this.zza = list;
    }

    public static zzehk zza(@NonNull zzejq zzejqVar) {
        return new zzehl(zzejqVar, zzctv.zza);
    }

    public static zzehk zzb(@NonNull zzehk zzehkVar) {
        return new zzehl(zzehkVar, zzctu.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzekw
    public final void zzm() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzgui.zzr((j2.q) it.next(), new zzctt(this), zzguz.zza());
        }
    }

    public zzctw(zzcto zzctoVar) {
        this.zza = Collections.singletonList(zzgui.zza(zzctoVar));
    }
}
