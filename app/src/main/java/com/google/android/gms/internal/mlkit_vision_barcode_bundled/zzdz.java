package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.core.processing.util.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdz extends zzcs implements RandomAccess, zzem {
    private static final zzdz zza = new zzdz(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    public zzdz() {
        this(new float[10], 0, true);
    }

    public static zzdz zzf() {
        return zza;
    }

    private final String zzi(int i2) {
        return a.i("Index:", i2, ", Size:", this.zzc);
    }

    private final void zzj(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzi(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i8;
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        if (i2 < 0 || i2 > (i8 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzi(i2));
        }
        int i9 = i2 + 1;
        float[] fArr = this.zzb;
        if (i8 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i9, i8 - i2);
        } else {
            float[] fArr2 = new float[a.a(i8, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.zzb, i2, fArr2, i9, this.zzc - i2);
            this.zzb = fArr2;
        }
        this.zzb[i2] = fFloatValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzep.zzb;
        collection.getClass();
        if (!(collection instanceof zzdz)) {
            return super.addAll(collection);
        }
        zzdz zzdzVar = (zzdz) collection;
        int i2 = zzdzVar.zzc;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzc;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        float[] fArr = this.zzb;
        if (i9 > fArr.length) {
            this.zzb = Arrays.copyOf(fArr, i9);
        }
        System.arraycopy(zzdzVar.zzb, 0, this.zzb, this.zzc, zzdzVar.zzc);
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
        if (!(obj instanceof zzdz)) {
            return super.equals(obj);
        }
        zzdz zzdzVar = (zzdz) obj;
        if (this.zzc != zzdzVar.zzc) {
            return false;
        }
        float[] fArr = zzdzVar.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (Float.floatToIntBits(this.zzb[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzj(i2);
        return Float.valueOf(this.zzb[i2]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzb[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i2 = this.zzc;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zzb[i8] == fFloatValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zza();
        zzj(i2);
        float[] fArr = this.zzb;
        float f4 = fArr[i2];
        if (i2 < this.zzc - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zza();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzb;
        System.arraycopy(fArr, i8, fArr, i2, this.zzc - i8);
        this.zzc -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        zzj(i2);
        float[] fArr = this.zzb;
        float f4 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    public final float zze(int i2) {
        zzj(i2);
        return this.zzb[i2];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzem zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzdz(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzem
    public final void zzh(float f4) {
        zza();
        int i2 = this.zzc;
        float[] fArr = this.zzb;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[a.a(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i8 = this.zzc;
        this.zzc = i8 + 1;
        fArr3[i8] = f4;
    }

    private zzdz(float[] fArr, int i2, boolean z2) {
        super(z2);
        this.zzb = fArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Float) obj).floatValue());
        return true;
    }
}
