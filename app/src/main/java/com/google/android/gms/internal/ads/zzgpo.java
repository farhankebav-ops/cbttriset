package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgpo<E> extends zzgpa<E> implements Set<E> {
    private transient zzgpe zza;

    public static zzgpo zzh() {
        return zzgrf.zza;
    }

    public static zzgpo zzi(Object obj) {
        return new zzgrp(obj);
    }

    public static zzgpo zzj(Object obj, Object obj2) {
        return zzv(2, obj, obj2);
    }

    public static zzgpo zzk(Object obj, Object obj2, Object obj3) {
        return zzv(3, obj, obj2, obj3);
    }

    public static zzgpo zzl(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzv(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzgpo zzm(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        int length = objArr.length;
        int i2 = length + 6;
        Object[] objArr2 = new Object[i2];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, length);
        return zzv(i2, objArr2);
    }

    public static int zzn(int i2) {
        int iMax = Math.max(i2, 2);
        if (iMax >= 751619276) {
            zzgmd.zzb(iMax < 1073741824, "collection too large");
            return BasicMeasure.EXACTLY;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzgpo zzo(Collection collection) {
        if ((collection instanceof zzgpo) && !(collection instanceof SortedSet)) {
            zzgpo zzgpoVar = (zzgpo) collection;
            if (!zzgpoVar.zzf()) {
                return zzgpoVar;
            }
        }
        Object[] array = collection.toArray();
        return zzv(array.length, array);
    }

    public static zzgpo zzp(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? zzv(length, (Object[]) objArr.clone()) : new zzgrp(objArr[0]) : zzgrf.zza;
    }

    public static zzgpn zzs(int i2) {
        zzgoc.zzb(i2, "expectedSize");
        return new zzgpn(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgpo zzv(int i2, Object... objArr) {
        if (i2 == 0) {
            return zzgrf.zza;
        }
        if (i2 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzgrp(obj);
        }
        int iZzn = zzn(i2);
        Object[] objArr2 = new Object[iZzn];
        int i8 = iZzn - 1;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i2; i11++) {
            Object obj2 = objArr[i11];
            zzgqx.zzb(obj2, i11);
            int iHashCode = obj2.hashCode();
            int iZza = zzgox.zza(iHashCode);
            while (true) {
                int i12 = iZza & i8;
                Object obj3 = objArr2[i12];
                if (obj3 == null) {
                    objArr[i10] = obj2;
                    objArr2[i12] = obj2;
                    i9 += iHashCode;
                    i10++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iZza++;
                }
            }
        }
        Arrays.fill(objArr, i10, i2, (Object) null);
        if (i10 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new zzgrp(obj4);
        }
        if (zzn(i10) < iZzn / 2) {
            return zzv(i10, objArr);
        }
        if (zzw(i10, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i10);
        }
        return new zzgrf(objArr, i9, objArr2, i8, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzw(int i2, int i8) {
        return i2 < (i8 >> 1) + (i8 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzgpo) && zzq() && ((zzgpo) obj).zzq() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzgro.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzgro.zzc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract zzgrs iterator();

    @Override // com.google.android.gms.internal.ads.zzgpa
    public zzgpe zze() {
        zzgpe zzgpeVar = this.zza;
        if (zzgpeVar != null) {
            return zzgpeVar;
        }
        zzgpe zzgpeVarZzr = zzr();
        this.zza = zzgpeVarZzr;
        return zzgpeVarZzr;
    }

    public boolean zzq() {
        return false;
    }

    public zzgpe zzr() {
        Object[] array = toArray();
        int i2 = zzgpe.zzd;
        return zzgpe.zzt(array, array.length);
    }
}
