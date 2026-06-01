package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.core.processing.util.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfb extends zzcs implements RandomAccess, zzeo {
    private long[] zza;
    private int zzb;

    static {
        new zzfb(new long[0], 0, false);
    }

    public zzfb() {
        this(new long[10], 0, true);
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
        long jLongValue = ((Long) obj).longValue();
        zza();
        if (i2 < 0 || i2 > (i8 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i2));
        }
        int i9 = i2 + 1;
        long[] jArr = this.zza;
        if (i8 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i9, i8 - i2);
        } else {
            long[] jArr2 = new long[a.a(i8, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.zza, i2, jArr2, i9, this.zzb - i2);
            this.zza = jArr2;
        }
        this.zza[i2] = jLongValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzep.zzb;
        collection.getClass();
        if (!(collection instanceof zzfb)) {
            return super.addAll(collection);
        }
        zzfb zzfbVar = (zzfb) collection;
        int i2 = zzfbVar.zzb;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzb;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        long[] jArr = this.zza;
        if (i9 > jArr.length) {
            this.zza = Arrays.copyOf(jArr, i9);
        }
        System.arraycopy(zzfbVar.zza, 0, this.zza, this.zzb, zzfbVar.zzb);
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
        if (!(obj instanceof zzfb)) {
            return super.equals(obj);
        }
        zzfb zzfbVar = (zzfb) obj;
        if (this.zzb != zzfbVar.zzb) {
            return false;
        }
        long[] jArr = zzfbVar.zza;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            if (this.zza[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzh(i2);
        return Long.valueOf(this.zza[i2]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i8 = 0; i8 < this.zzb; i8++) {
            long j = this.zza[i8];
            byte[] bArr = zzep.zzb;
            i2 = (i2 * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i2 = this.zzb;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zza[i8] == jLongValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zza();
        zzh(i2);
        long[] jArr = this.zza;
        long j = jArr[i2];
        if (i2 < this.zzb - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zza();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zza;
        System.arraycopy(jArr, i8, jArr, i2, this.zzb - i8);
        this.zzb -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zza();
        zzh(i2);
        long[] jArr = this.zza;
        long j = jArr[i2];
        jArr[i2] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo
    public final /* bridge */ /* synthetic */ zzeo zzd(int i2) {
        if (i2 >= this.zzb) {
            return new zzfb(Arrays.copyOf(this.zza, i2), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i2) {
        zzh(i2);
        return this.zza[i2];
    }

    public final void zzf(long j) {
        zza();
        int i2 = this.zzb;
        long[] jArr = this.zza;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[a.a(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.zza = jArr2;
        }
        long[] jArr3 = this.zza;
        int i8 = this.zzb;
        this.zzb = i8 + 1;
        jArr3[i8] = j;
    }

    private zzfb(long[] jArr, int i2, boolean z2) {
        super(z2);
        this.zza = jArr;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
