package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgpe extends zzgpa implements List, RandomAccess {
    private static final zzgrt zza = new zzgpc(zzgqz.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    public static zzgpe zzi() {
        return zzgqz.zza;
    }

    public static zzgpe zzj(Object obj) {
        Object[] objArr = {obj};
        zzgqx.zza(objArr, 1);
        return zzt(objArr, 1);
    }

    public static zzgpe zzk(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzgqx.zza(objArr, 2);
        return zzt(objArr, 2);
    }

    public static zzgpe zzl(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        zzgqx.zza(objArr, 3);
        return zzt(objArr, 3);
    }

    public static zzgpe zzm(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5};
        zzgqx.zza(objArr, 5);
        return zzt(objArr, 5);
    }

    public static zzgpe zzn(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5, obj6};
        zzgqx.zza(objArr, 6);
        return zzt(objArr, 6);
    }

    @SafeVarargs
    public static zzgpe zzo(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        int length = objArr.length;
        int i2 = length + 12;
        Object[] objArr2 = new Object[i2];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, length);
        zzgqx.zza(objArr2, i2);
        return zzt(objArr2, i2);
    }

    public static zzgpe zzp(Iterable iterable) {
        iterable.getClass();
        return zzq((Collection) iterable);
    }

    public static zzgpe zzq(Collection collection) {
        if (!(collection instanceof zzgpa)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzgqx.zza(array, length);
            return zzt(array, length);
        }
        zzgpe zzgpeVarZze = ((zzgpa) collection).zze();
        if (!zzgpeVarZze.zzf()) {
            return zzgpeVarZze;
        }
        Object[] array2 = zzgpeVarZze.toArray();
        return zzt(array2, array2.length);
    }

    public static zzgpe zzr(Object[] objArr) {
        if (objArr.length == 0) {
            return zzgqz.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzgqx.zza(objArr2, length);
        return zzt(objArr2, length);
    }

    public static zzgpe zzs(Comparator comparator, Iterable iterable) {
        Object[] array = (iterable instanceof Collection ? (Collection) iterable : zzgqe.zza(((zzgpe) iterable).listIterator(0))).toArray();
        int length = array.length;
        zzgqx.zza(array, length);
        Arrays.sort(array, comparator);
        return zzt(array, length);
    }

    public static zzgpe zzt(Object[] objArr, int i2) {
        return i2 == 0 ? zzgqz.zza : new zzgqz(objArr, i2);
    }

    public static zzgpb zzv(int i2) {
        zzgoc.zzb(i2, "expectedSize");
        return new zzgpb(i2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i2 = 0; i2 < size; i2++) {
                if (!Objects.equals(get(i2), list.get(i2))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.equals(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i2 = 0; i2 < size; i2++) {
            iHashCode = (iHashCode * 31) + get(i2).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj.equals(get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    /* JADX INFO: renamed from: zza */
    public final zzgrs iterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public int zzg(Object[] objArr, int i2) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            objArr[i2 + i8] = get(i8);
        }
        return i2 + size;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public zzgpe subList(int i2, int i8) {
        zzgmd.zzo(i2, i8, size());
        int i9 = i8 - i2;
        return i9 == size() ? this : i9 == 0 ? zzgqz.zza : new zzgpd(this, i2, i9);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final zzgrt listIterator(int i2) {
        zzgmd.zzn(i2, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? zza : new zzgpc(this, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    @Deprecated
    public final zzgpe zze() {
        return this;
    }
}
