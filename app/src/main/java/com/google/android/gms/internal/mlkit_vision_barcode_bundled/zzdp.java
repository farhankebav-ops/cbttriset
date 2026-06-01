package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.core.processing.util.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdp extends zzcs implements RandomAccess, zzeo {
    private double[] zza;
    private int zzb;

    static {
        new zzdp(new double[0], 0, false);
    }

    public zzdp() {
        this(new double[10], 0, true);
    }

    private final String zzg(int i2) {
        return a.i("Index:", i2, ", Size:", this.zzb);
    }

    private final void zzh(int i2) {
        if (i2 < 0 || i2 >= this.zzb) {
            throw new IndexOutOfBoundsException(zzg(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i8;
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        if (i2 < 0 || i2 > (i8 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i2));
        }
        int i9 = i2 + 1;
        double[] dArr = this.zza;
        if (i8 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i9, i8 - i2);
        } else {
            double[] dArr2 = new double[a.a(i8, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.zza, i2, dArr2, i9, this.zzb - i2);
            this.zza = dArr2;
        }
        this.zza[i2] = dDoubleValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzep.zzb;
        collection.getClass();
        if (!(collection instanceof zzdp)) {
            return super.addAll(collection);
        }
        zzdp zzdpVar = (zzdp) collection;
        int i2 = zzdpVar.zzb;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzb;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        double[] dArr = this.zza;
        if (i9 > dArr.length) {
            this.zza = Arrays.copyOf(dArr, i9);
        }
        System.arraycopy(zzdpVar.zza, 0, this.zza, this.zzb, zzdpVar.zzb);
        this.zzb = i9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdp)) {
            return super.equals(obj);
        }
        zzdp zzdpVar = (zzdp) obj;
        if (this.zzb != zzdpVar.zzb) {
            return false;
        }
        double[] dArr = zzdpVar.zza;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            if (Double.doubleToLongBits(this.zza[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzh(i2);
        return Double.valueOf(this.zza[i2]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i8 = 0; i8 < this.zzb; i8++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zza[i8]);
            byte[] bArr = zzep.zzb;
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
        int i2 = this.zzb;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zza[i8] == dDoubleValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zza();
        zzh(i2);
        double[] dArr = this.zza;
        double d8 = dArr[i2];
        if (i2 < this.zzb - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zza();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zza;
        System.arraycopy(dArr, i8, dArr, i2, this.zzb - i8);
        this.zzb -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        zzh(i2);
        double[] dArr = this.zza;
        double d8 = dArr[i2];
        dArr[i2] = dDoubleValue;
        return Double.valueOf(d8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo
    public final /* bridge */ /* synthetic */ zzeo zzd(int i2) {
        if (i2 >= this.zzb) {
            return new zzdp(Arrays.copyOf(this.zza, i2), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zze(int i2) {
        zzh(i2);
        return this.zza[i2];
    }

    public final void zzf(double d8) {
        zza();
        int i2 = this.zzb;
        double[] dArr = this.zza;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[a.a(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.zza = dArr2;
        }
        double[] dArr3 = this.zza;
        int i8 = this.zzb;
        this.zzb = i8 + 1;
        dArr3[i8] = d8;
    }

    private zzdp(double[] dArr, int i2, boolean z2) {
        super(z2);
        this.zza = dArr;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Double) obj).doubleValue());
        return true;
    }
}
