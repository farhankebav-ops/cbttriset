package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.core.processing.util.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzei extends zzcs implements RandomAccess, zzen {
    private static final zzei zza = new zzei(new int[0], 0, false);
    private int[] zzb;
    private int zzc;

    public zzei() {
        this(new int[10], 0, true);
    }

    public static zzei zzf() {
        return zza;
    }

    private final String zzh(int i2) {
        return a.i("Index:", i2, ", Size:", this.zzc);
    }

    private final void zzi(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i8;
        int iIntValue = ((Integer) obj).intValue();
        zza();
        if (i2 < 0 || i2 > (i8 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i2));
        }
        int i9 = i2 + 1;
        int[] iArr = this.zzb;
        if (i8 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i9, i8 - i2);
        } else {
            int[] iArr2 = new int[a.a(i8, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.zzb, i2, iArr2, i9, this.zzc - i2);
            this.zzb = iArr2;
        }
        this.zzb[i2] = iIntValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzep.zzb;
        collection.getClass();
        if (!(collection instanceof zzei)) {
            return super.addAll(collection);
        }
        zzei zzeiVar = (zzei) collection;
        int i2 = zzeiVar.zzc;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzc;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        int[] iArr = this.zzb;
        if (i9 > iArr.length) {
            this.zzb = Arrays.copyOf(iArr, i9);
        }
        System.arraycopy(zzeiVar.zzb, 0, this.zzb, this.zzc, zzeiVar.zzc);
        this.zzc = i9;
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
        if (!(obj instanceof zzei)) {
            return super.equals(obj);
        }
        zzei zzeiVar = (zzei) obj;
        if (this.zzc != zzeiVar.zzc) {
            return false;
        }
        int[] iArr = zzeiVar.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (this.zzb[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzi(i2);
        return Integer.valueOf(this.zzb[i2]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            i2 = (i2 * 31) + this.zzb[i8];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.zzc;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zzb[i8] == iIntValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zza();
        zzi(i2);
        int[] iArr = this.zzb;
        int i8 = iArr[i2];
        if (i2 < this.zzc - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zza();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzb;
        System.arraycopy(iArr, i8, iArr, i2, this.zzc - i8);
        this.zzc -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zza();
        zzi(i2);
        int[] iArr = this.zzb;
        int i8 = iArr[i2];
        iArr[i2] = iIntValue;
        return Integer.valueOf(i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo
    public final /* bridge */ /* synthetic */ zzeo zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzei(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zze(int i2) {
        zzi(i2);
        return this.zzb[i2];
    }

    public final void zzg(int i2) {
        zza();
        int i8 = this.zzc;
        int[] iArr = this.zzb;
        if (i8 == iArr.length) {
            int[] iArr2 = new int[a.a(i8, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i8);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        iArr3[i9] = i2;
    }

    private zzei(int[] iArr, int i2, boolean z2) {
        super(z2);
        this.zzb = iArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Integer) obj).intValue());
        return true;
    }
}
