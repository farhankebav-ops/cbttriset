package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhuy extends zzhuu implements RandomAccess, zzhwq, zzhyi {
    private static final boolean[] zza;
    private static final zzhuy zzb;
    private boolean[] zzc;
    private int zzd;

    static {
        boolean[] zArr = new boolean[0];
        zza = zArr;
        zzb = new zzhuy(zArr, 0, false);
    }

    public zzhuy() {
        this(zza, 0, true);
    }

    public static zzhuy zzd() {
        return zzb;
    }

    private static int zzi(int i2) {
        return Math.max(((i2 * 3) / 2) + 1, 10);
    }

    private final void zzj(int i2) {
        if (i2 < 0 || i2 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzk(i2));
        }
    }

    private final String zzk(int i2) {
        int i8 = this.zzd;
        return a1.a.f(i2, i8, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i8).length()));
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i8;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzea();
        if (i2 < 0 || i2 > (i8 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzk(i2));
        }
        int i9 = i2 + 1;
        boolean[] zArr = this.zzc;
        int length = zArr.length;
        if (i8 < length) {
            System.arraycopy(zArr, i2, zArr, i9, i8 - i2);
        } else {
            boolean[] zArr2 = new boolean[zzi(length)];
            System.arraycopy(this.zzc, 0, zArr2, 0, i2);
            System.arraycopy(this.zzc, i2, zArr2, i9, this.zzd - i2);
            this.zzc = zArr2;
        }
        this.zzc[i2] = zBooleanValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzea();
        byte[] bArr = zzhxb.zzb;
        collection.getClass();
        if (!(collection instanceof zzhuy)) {
            return super.addAll(collection);
        }
        zzhuy zzhuyVar = (zzhuy) collection;
        int i2 = zzhuyVar.zzd;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzd;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        boolean[] zArr = this.zzc;
        if (i9 > zArr.length) {
            this.zzc = Arrays.copyOf(zArr, i9);
        }
        System.arraycopy(zzhuyVar.zzc, 0, this.zzc, this.zzd, zzhuyVar.zzd);
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
        if (!(obj instanceof zzhuy)) {
            return super.equals(obj);
        }
        zzhuy zzhuyVar = (zzhuy) obj;
        if (this.zzd != zzhuyVar.zzd) {
            return false;
        }
        boolean[] zArr = zzhuyVar.zzc;
        for (int i2 = 0; i2 < this.zzd; i2++) {
            if (this.zzc[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzj(i2);
        return Boolean.valueOf(this.zzc[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzb = 1;
        for (int i2 = 0; i2 < this.zzd; i2++) {
            iZzb = (iZzb * 31) + zzhxb.zzb(this.zzc[i2]);
        }
        return iZzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i2 = this.zzd;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zzc[i8] == zBooleanValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzea();
        zzj(i2);
        boolean[] zArr = this.zzc;
        boolean z2 = zArr[i2];
        if (i2 < this.zzd - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zzea();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzc;
        System.arraycopy(zArr, i8, zArr, i2, this.zzd - i8);
        this.zzd -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzea();
        zzj(i2);
        boolean[] zArr = this.zzc;
        boolean z2 = zArr[i2];
        zArr[i2] = zBooleanValue;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhxa, com.google.android.gms.internal.ads.zzhwq
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzhwq zzh(int i2) {
        if (i2 >= this.zzd) {
            return new zzhuy(i2 == 0 ? zza : Arrays.copyOf(this.zzc, i2), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean zzf(int i2) {
        zzj(i2);
        return this.zzc[i2];
    }

    public final void zzg(boolean z2) {
        zzea();
        int i2 = this.zzd;
        int length = this.zzc.length;
        if (i2 == length) {
            boolean[] zArr = new boolean[zzi(length)];
            System.arraycopy(this.zzc, 0, zArr, 0, this.zzd);
            this.zzc = zArr;
        }
        boolean[] zArr2 = this.zzc;
        int i8 = this.zzd;
        this.zzd = i8 + 1;
        zArr2[i8] = z2;
    }

    private zzhuy(boolean[] zArr, int i2, boolean z2) {
        super(z2);
        this.zzc = zArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Boolean) obj).booleanValue());
        return true;
    }
}
