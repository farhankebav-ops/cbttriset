package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zziex implements Iterator {
    int zza = 0;
    final /* synthetic */ zziey zzb;

    public zziex(zziey zzieyVar) {
        this.zzb = zzieyVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.zza;
        zziey zzieyVar = this.zzb;
        return i2 < zzieyVar.zza.size() || zzieyVar.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.zza;
        zziey zzieyVar = this.zzb;
        List list = zzieyVar.zza;
        if (i2 >= list.size()) {
            list.add(zzieyVar.zzb.next());
            return next();
        }
        int i8 = this.zza;
        this.zza = i8 + 1;
        return list.get(i8);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
