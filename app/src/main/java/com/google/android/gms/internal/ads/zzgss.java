package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgss extends AbstractList implements RandomAccess, Serializable {
    final int[] zza;
    final int zzb;
    final int zzc;

    public zzgss(int[] iArr, int i2, int i8) {
        this.zza = iArr;
        this.zzb = i2;
        this.zzc = i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return (obj instanceof Integer) && zzgst.zzi(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc) != -1;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgss)) {
            return super.equals(obj);
        }
        zzgss zzgssVar = (zzgss) obj;
        int i2 = this.zzc;
        int i8 = this.zzb;
        int i9 = zzgssVar.zzc;
        int i10 = zzgssVar.zzb;
        int i11 = i2 - i8;
        if (i9 - i10 != i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.zza[i8 + i12] != zzgssVar.zza[i10 + i12]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        int i8 = this.zzc;
        int i9 = this.zzb;
        zzgmd.zzm(i2, i8 - i9, FirebaseAnalytics.Param.INDEX);
        return Integer.valueOf(this.zza[i9 + i2]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i8 = this.zzb; i8 < this.zzc; i8++) {
            i2 = (i2 * 31) + this.zza[i8];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int[] iArr = this.zza;
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.zzb;
        int iZzi = zzgst.zzi(iArr, iIntValue, i2, this.zzc);
        if (iZzi >= 0) {
            return iZzi - i2;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.zza;
            int iIntValue = ((Integer) obj).intValue();
            int i2 = this.zzb;
            int i8 = this.zzc - 1;
            while (true) {
                if (i8 < i2) {
                    i8 = -1;
                    break;
                }
                if (iArr[i8] == iIntValue) {
                    break;
                }
                i8--;
            }
            if (i8 >= 0) {
                return i8 - i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        int i8 = this.zzc;
        int i9 = this.zzb;
        Integer num = (Integer) obj;
        zzgmd.zzm(i2, i8 - i9, FirebaseAnalytics.Param.INDEX);
        int[] iArr = this.zza;
        int i10 = i9 + i2;
        int i11 = iArr[i10];
        num.getClass();
        iArr[i10] = num.intValue();
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc - this.zzb;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return Spliterators.spliterator(this.zza, this.zzb, this.zzc, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i8) {
        int i9 = this.zzc;
        int i10 = this.zzb;
        zzgmd.zzo(i2, i8, i9 - i10);
        return i2 == i8 ? Collections.EMPTY_LIST : new zzgss(this.zza, i2 + i10, i10 + i8);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        int i2 = this.zzc;
        int i8 = this.zzb;
        StringBuilder sb = new StringBuilder((i2 - i8) * 5);
        sb.append('[');
        int[] iArr = this.zza;
        sb.append(iArr[i8]);
        while (true) {
            i8++;
            if (i8 >= i2) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(iArr[i8]);
        }
    }
}
