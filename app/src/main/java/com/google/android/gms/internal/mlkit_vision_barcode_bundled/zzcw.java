package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.core.processing.util.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcw extends zzcs implements RandomAccess, zzeo {
    private boolean[] zza;
    private int zzb;

    static {
        new zzcw(new boolean[0], 0, false);
    }

    public zzcw() {
        this(new boolean[10], 0, true);
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
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i2 < 0 || i2 > (i8 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i2));
        }
        int i9 = i2 + 1;
        boolean[] zArr = this.zza;
        if (i8 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i9, i8 - i2);
        } else {
            boolean[] zArr2 = new boolean[a.a(i8, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.zza, i2, zArr2, i9, this.zzb - i2);
            this.zza = zArr2;
        }
        this.zza[i2] = zBooleanValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzep.zzb;
        collection.getClass();
        if (!(collection instanceof zzcw)) {
            return super.addAll(collection);
        }
        zzcw zzcwVar = (zzcw) collection;
        int i2 = zzcwVar.zzb;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzb;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        boolean[] zArr = this.zza;
        if (i9 > zArr.length) {
            this.zza = Arrays.copyOf(zArr, i9);
        }
        System.arraycopy(zzcwVar.zza, 0, this.zza, this.zzb, zzcwVar.zzb);
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
        if (!(obj instanceof zzcw)) {
            return super.equals(obj);
        }
        zzcw zzcwVar = (zzcw) obj;
        if (this.zzb != zzcwVar.zzb) {
            return false;
        }
        boolean[] zArr = zzcwVar.zza;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            if (this.zza[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzh(i2);
        return Boolean.valueOf(this.zza[i2]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZza = 1;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            iZza = (iZza * 31) + zzep.zza(this.zza[i2]);
        }
        return iZza;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i2 = this.zzb;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zza[i8] == zBooleanValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zza();
        zzh(i2);
        boolean[] zArr = this.zza;
        boolean z2 = zArr[i2];
        if (i2 < this.zzb - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zza();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zza;
        System.arraycopy(zArr, i8, zArr, i2, this.zzb - i8);
        this.zzb -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzh(i2);
        boolean[] zArr = this.zza;
        boolean z2 = zArr[i2];
        zArr[i2] = zBooleanValue;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo
    public final /* bridge */ /* synthetic */ zzeo zzd(int i2) {
        if (i2 >= this.zzb) {
            return new zzcw(Arrays.copyOf(this.zza, i2), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z2) {
        zza();
        int i2 = this.zzb;
        boolean[] zArr = this.zza;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[a.a(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.zza = zArr2;
        }
        boolean[] zArr3 = this.zza;
        int i8 = this.zzb;
        this.zzb = i8 + 1;
        zArr3[i8] = z2;
    }

    public final boolean zzf(int i2) {
        zzh(i2);
        return this.zza[i2];
    }

    private zzcw(boolean[] zArr, int i2, boolean z2) {
        super(z2);
        this.zza = zArr;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
