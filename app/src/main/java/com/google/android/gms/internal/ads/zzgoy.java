package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzgoy extends zzgoz {
    Object[] zza;
    int zzb;
    boolean zzc;

    public zzgoy(int i2) {
        zzgoc.zzb(i2, "initialCapacity");
        this.zza = new Object[i2];
        this.zzb = 0;
    }

    private final void zzf(int i2) {
        int length = this.zza.length;
        int iZze = zzgoz.zze(length, this.zzb + i2);
        if (iZze > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZze);
            this.zzc = false;
        }
    }

    public final zzgoy zza(Object obj) {
        obj.getClass();
        zzf(1);
        Object[] objArr = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        objArr[i2] = obj;
        return this;
    }

    public final void zzb(Object[] objArr, int i2) {
        zzgqx.zza(objArr, 2);
        zzf(2);
        System.arraycopy(objArr, 0, this.zza, this.zzb, 2);
        this.zzb += 2;
    }

    public final zzgoz zzc(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzf(collection.size());
            if (collection instanceof zzgpa) {
                this.zzb = ((zzgpa) collection).zzg(this.zza, this.zzb);
                return this;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzd(it.next());
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgoz
    public /* bridge */ /* synthetic */ zzgoz zzd(Object obj) {
        throw null;
    }
}
