package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhvv extends zzhuu implements RandomAccess, zzhwr, zzhyi {
    private static final double[] zza;
    private static final zzhvv zzb;
    private double[] zzc;
    private int zzd;

    static {
        double[] dArr = new double[0];
        zza = dArr;
        zzb = new zzhvv(dArr, 0, false);
    }

    public zzhvv() {
        this(zza, 0, true);
    }

    public static zzhvv zzd() {
        return zzb;
    }

    private static int zzj(int i2) {
        return Math.max(((i2 * 3) / 2) + 1, 10);
    }

    private final void zzk(int i2) {
        if (i2 < 0 || i2 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzl(i2));
        }
    }

    private final String zzl(int i2) {
        int i8 = this.zzd;
        return a1.a.f(i2, i8, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i8).length()));
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i8;
        double dDoubleValue = ((Double) obj).doubleValue();
        zzea();
        if (i2 < 0 || i2 > (i8 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzl(i2));
        }
        int i9 = i2 + 1;
        double[] dArr = this.zzc;
        int length = dArr.length;
        if (i8 < length) {
            System.arraycopy(dArr, i2, dArr, i9, i8 - i2);
        } else {
            double[] dArr2 = new double[zzj(length)];
            System.arraycopy(this.zzc, 0, dArr2, 0, i2);
            System.arraycopy(this.zzc, i2, dArr2, i9, this.zzd - i2);
            this.zzc = dArr2;
        }
        this.zzc[i2] = dDoubleValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzea();
        byte[] bArr = zzhxb.zzb;
        collection.getClass();
        if (!(collection instanceof zzhvv)) {
            return super.addAll(collection);
        }
        zzhvv zzhvvVar = (zzhvv) collection;
        int i2 = zzhvvVar.zzd;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzd;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        double[] dArr = this.zzc;
        if (i9 > dArr.length) {
            this.zzc = Arrays.copyOf(dArr, i9);
        }
        System.arraycopy(zzhvvVar.zzc, 0, this.zzc, this.zzd, zzhvvVar.zzd);
        this.zzd = i9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhvv)) {
            return super.equals(obj);
        }
        zzhvv zzhvvVar = (zzhvv) obj;
        if (this.zzd != zzhvvVar.zzd) {
            return false;
        }
        double[] dArr = zzhvvVar.zzc;
        for (int i2 = 0; i2 < this.zzd; i2++) {
            if (Double.doubleToLongBits(this.zzc[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzk(i2);
        return Double.valueOf(this.zzc[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i8 = 0; i8 < this.zzd; i8++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zzc[i8]);
            byte[] bArr = zzhxb.zzb;
            i2 = (i2 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i2 = this.zzd;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zzc[i8] == dDoubleValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzea();
        zzk(i2);
        double[] dArr = this.zzc;
        double d8 = dArr[i2];
        if (i2 < this.zzd - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zzea();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzc;
        System.arraycopy(dArr, i8, dArr, i2, this.zzd - i8);
        this.zzd -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzea();
        zzk(i2);
        double[] dArr = this.zzc;
        double d8 = dArr[i2];
        dArr[i2] = dDoubleValue;
        return Double.valueOf(d8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhxa, com.google.android.gms.internal.ads.zzhwq
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzhwr zzh(int i2) {
        if (i2 >= this.zzd) {
            return new zzhvv(i2 == 0 ? zza : Arrays.copyOf(this.zzc, i2), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zzf(int i2) {
        zzk(i2);
        return this.zzc[i2];
    }

    public final void zzg(double d8) {
        zzea();
        int i2 = this.zzd;
        int length = this.zzc.length;
        if (i2 == length) {
            double[] dArr = new double[zzj(length)];
            System.arraycopy(this.zzc, 0, dArr, 0, this.zzd);
            this.zzc = dArr;
        }
        double[] dArr2 = this.zzc;
        int i8 = this.zzd;
        this.zzd = i8 + 1;
        dArr2[i8] = d8;
    }

    public final void zzi(int i2) {
        int length = this.zzc.length;
        if (i2 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new double[Math.max(i2, 10)];
            return;
        }
        while (length < i2) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzhvv(double[] dArr, int i2, boolean z2) {
        super(z2);
        this.zzc = dArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Double) obj).doubleValue());
        return true;
    }
}
