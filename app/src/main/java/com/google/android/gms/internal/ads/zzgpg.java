package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgpg {
    Object[] zza;
    int zzb;
    zzgpf zzc;

    public zzgpg() {
        this(4);
    }

    private final void zzd(int i2) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i8 = i2 + i2;
        if (i8 > length) {
            this.zza = Arrays.copyOf(objArr, zzgoz.zze(length, i8));
        }
    }

    public final zzgpg zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzgoc.zza(obj, obj2);
        Object[] objArr = this.zza;
        int i2 = this.zzb;
        int i8 = i2 + i2;
        objArr[i8] = obj;
        objArr[i8 + 1] = obj2;
        this.zzb = i2 + 1;
        return this;
    }

    public final zzgpg zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(((Collection) iterable).size() + this.zzb);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzgph zzc() {
        zzgpf zzgpfVar = this.zzc;
        if (zzgpfVar != null) {
            throw zzgpfVar.zza();
        }
        zzgre zzgreVarZzk = zzgre.zzk(this.zzb, this.zza, this);
        zzgpf zzgpfVar2 = this.zzc;
        if (zzgpfVar2 == null) {
            return zzgreVarZzk;
        }
        throw zzgpfVar2.zza();
    }

    public zzgpg(int i2) {
        this.zza = new Object[i2 + i2];
        this.zzb = 0;
    }
}
