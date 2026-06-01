package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgpt extends zzgne {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzgme zzb;

    public zzgpt(Iterator it, zzgme zzgmeVar) {
        this.zza = it;
        this.zzb = zzgmeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgne
    public final Object zza() {
        zzgme zzgmeVar;
        Object next;
        do {
            Iterator it = this.zza;
            if (!it.hasNext()) {
                zzb();
                return null;
            }
            zzgmeVar = this.zzb;
            next = it.next();
        } while (!zzgmeVar.zza(next));
        return next;
    }
}
