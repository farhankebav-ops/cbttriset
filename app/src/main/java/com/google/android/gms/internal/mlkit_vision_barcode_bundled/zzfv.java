package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.core.processing.util.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfv extends zzcs implements RandomAccess {
    private static final zzfv zza = new zzfv(new Object[0], 0, false);
    private Object[] zzb;
    private int zzc;

    public zzfv() {
        this(new Object[10], 0, true);
    }

    public static zzfv zze() {
        return zza;
    }

    private final String zzf(int i2) {
        return a.i("Index:", i2, ", Size:", this.zzc);
    }

    private final void zzg(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i8;
        zza();
        if (i2 < 0 || i2 > (i8 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
        int i9 = i2 + 1;
        Object[] objArr = this.zzb;
        if (i8 < objArr.length) {
            System.arraycopy(objArr, i2, objArr, i9, i8 - i2);
        } else {
            Object[] objArr2 = new Object[a.a(i8, 3, 2, 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.zzb, i2, objArr2, i9, this.zzc - i2);
            this.zzb = objArr2;
        }
        this.zzb[i2] = obj;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        zzg(i2);
        return this.zzb[i2];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        zza();
        zzg(i2);
        Object[] objArr = this.zzb;
        Object obj = objArr[i2];
        if (i2 < this.zzc - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        zza();
        zzg(i2);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo
    public final /* bridge */ /* synthetic */ zzeo zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzfv(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    private zzfv(Object[] objArr, int i2, boolean z2) {
        super(z2);
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i2 = this.zzc;
        Object[] objArr = this.zzb;
        if (i2 == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i8 = this.zzc;
        this.zzc = i8 + 1;
        objArr2[i8] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
