package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhtf extends zzhtg implements Iterable {
    private final ArrayList zza = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzhtf) && ((zzhtf) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final void zza(zzhtg zzhtgVar) {
        this.zza.add(zzhtgVar);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final zzhtg zzc(int i2) {
        return (zzhtg) this.zza.get(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhtg
    public final String zzd() {
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        if (size == 1) {
            return ((zzhtg) arrayList.get(0)).zzd();
        }
        throw new IllegalStateException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(size).length() + 37), "Array must have size 1, but has size ", size));
    }
}
