package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsc implements zzrz {

    @VisibleForTesting
    final List zza;

    public zzsc(Context context, zzsb zzsbVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzsbVar.zzc()) {
            arrayList.add(new zzsp(context, zzsbVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzrz
    public final void zza(zzry zzryVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzrz) it.next()).zza(zzryVar);
        }
    }
}
