package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhwf extends zzhuu implements RandomAccess, zzhwv, zzhyi {
    private static final float[] zza;
    private static final zzhwf zzb;
    private float[] zzc;
    private int zzd;

    static {
        float[] fArr = new float[0];
        zza = fArr;
        zzb = new zzhwf(fArr, 0, false);
    }

    public zzhwf() {
        this(zza, 0, true);
    }

    public static zzhwf zzd() {
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
        float fFloatValue = ((Float) obj).floatValue();
        zzea();
        if (i2 < 0 || i2 > (i8 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzl(i2));
        }
        int i9 = i2 + 1;
        float[] fArr = this.zzc;
        int length = fArr.length;
        if (i8 < length) {
            System.arraycopy(fArr, i2, fArr, i9, i8 - i2);
        } else {
            float[] fArr2 = new float[zzj(length)];
            System.arraycopy(this.zzc, 0, fArr2, 0, i2);
            System.arraycopy(this.zzc, i2, fArr2, i9, this.zzd - i2);
            this.zzc = fArr2;
        }
        this.zzc[i2] = fFloatValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzea();
        byte[] bArr = zzhxb.zzb;
        collection.getClass();
        if (!(collection instanceof zzhwf)) {
            return super.addAll(collection);
        }
        zzhwf zzhwfVar = (zzhwf) collection;
        int i2 = zzhwfVar.zzd;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzd;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        float[] fArr = this.zzc;
        if (i9 > fArr.length) {
            this.zzc = Arrays.copyOf(fArr, i9);
        }
        System.arraycopy(zzhwfVar.zzc, 0, this.zzc, this.zzd, zzhwfVar.zzd);
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
        if (!(obj instanceof zzhwf)) {
            return super.equals(obj);
        }
        zzhwf zzhwfVar = (zzhwf) obj;
        if (this.zzd != zzhwfVar.zzd) {
            return false;
        }
        float[] fArr = zzhwfVar.zzc;
        for (int i2 = 0; i2 < this.zzd; i2++) {
            if (Float.floatToIntBits(this.zzc[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzk(i2);
        return Float.valueOf(this.zzc[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.zzd; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzc[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i2 = this.zzd;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zzc[i8] == fFloatValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzea();
        zzk(i2);
        float[] fArr = this.zzc;
        float f4 = fArr[i2];
        if (i2 < this.zzd - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zzea();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzc;
        System.arraycopy(fArr, i8, fArr, i2, this.zzd - i8);
        this.zzd -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zzea();
        zzk(i2);
        float[] fArr = this.zzc;
        float f4 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhxa, com.google.android.gms.internal.ads.zzhwq
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzhwv zzh(int i2) {
        if (i2 >= this.zzd) {
            return new zzhwf(i2 == 0 ? zza : Arrays.copyOf(this.zzc, i2), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final float zzf(int i2) {
        zzk(i2);
        return this.zzc[i2];
    }

    public final void zzg(float f4) {
        zzea();
        int i2 = this.zzd;
        int length = this.zzc.length;
        if (i2 == length) {
            float[] fArr = new float[zzj(length)];
            System.arraycopy(this.zzc, 0, fArr, 0, this.zzd);
            this.zzc = fArr;
        }
        float[] fArr2 = this.zzc;
        int i8 = this.zzd;
        this.zzd = i8 + 1;
        fArr2[i8] = f4;
    }

    public final void zzi(int i2) {
        int length = this.zzc.length;
        if (i2 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new float[Math.max(i2, 10)];
            return;
        }
        while (length < i2) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzhwf(float[] fArr, int i2, boolean z2) {
        super(z2);
        this.zzc = fArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Float) obj).floatValue());
        return true;
    }
}
