package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhwp extends zzhuu implements RandomAccess, zzhww, zzhyi {
    private static final int[] zza;
    private static final zzhwp zzb;
    private int[] zzc;
    private int zzd;

    static {
        int[] iArr = new int[0];
        zza = iArr;
        zzb = new zzhwp(iArr, 0, false);
    }

    public zzhwp() {
        this(zza, 0, true);
    }

    public static zzhwp zzd() {
        return zzb;
    }

    private static int zzk(int i2) {
        return Math.max(((i2 * 3) / 2) + 1, 10);
    }

    private final void zzl(int i2) {
        if (i2 < 0 || i2 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzm(i2));
        }
    }

    private final String zzm(int i2) {
        int i8 = this.zzd;
        return a1.a.f(i2, i8, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i8).length()));
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i8;
        int iIntValue = ((Integer) obj).intValue();
        zzea();
        if (i2 < 0 || i2 > (i8 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzm(i2));
        }
        int i9 = i2 + 1;
        int[] iArr = this.zzc;
        int length = iArr.length;
        if (i8 < length) {
            System.arraycopy(iArr, i2, iArr, i9, i8 - i2);
        } else {
            int[] iArr2 = new int[zzk(length)];
            System.arraycopy(this.zzc, 0, iArr2, 0, i2);
            System.arraycopy(this.zzc, i2, iArr2, i9, this.zzd - i2);
            this.zzc = iArr2;
        }
        this.zzc[i2] = iIntValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzea();
        byte[] bArr = zzhxb.zzb;
        collection.getClass();
        if (!(collection instanceof zzhwp)) {
            return super.addAll(collection);
        }
        zzhwp zzhwpVar = (zzhwp) collection;
        int i2 = zzhwpVar.zzd;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzd;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        int[] iArr = this.zzc;
        if (i9 > iArr.length) {
            this.zzc = Arrays.copyOf(iArr, i9);
        }
        System.arraycopy(zzhwpVar.zzc, 0, this.zzc, this.zzd, zzhwpVar.zzd);
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
        if (!(obj instanceof zzhwp)) {
            return super.equals(obj);
        }
        zzhwp zzhwpVar = (zzhwp) obj;
        if (this.zzd != zzhwpVar.zzd) {
            return false;
        }
        int[] iArr = zzhwpVar.zzc;
        for (int i2 = 0; i2 < this.zzd; i2++) {
            if (this.zzc[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzl(i2);
        return Integer.valueOf(this.zzc[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i8 = 0; i8 < this.zzd; i8++) {
            i2 = (i2 * 31) + this.zzc[i8];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.zzd;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zzc[i8] == iIntValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzea();
        zzl(i2);
        int[] iArr = this.zzc;
        int i8 = iArr[i2];
        if (i2 < this.zzd - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zzea();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzc;
        System.arraycopy(iArr, i8, iArr, i2, this.zzd - i8);
        this.zzd -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        return Integer.valueOf(zzg(i2, ((Integer) obj).intValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhxa, com.google.android.gms.internal.ads.zzhwq
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzhww zzh(int i2) {
        if (i2 >= this.zzd) {
            return new zzhwp(i2 == 0 ? zza : Arrays.copyOf(this.zzc, i2), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzhww
    public final int zzf(int i2) {
        zzl(i2);
        return this.zzc[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhww
    public final int zzg(int i2, int i8) {
        zzea();
        zzl(i2);
        int[] iArr = this.zzc;
        int i9 = iArr[i2];
        iArr[i2] = i8;
        return i9;
    }

    @Override // com.google.android.gms.internal.ads.zzhww
    public final void zzi(int i2) {
        zzea();
        int i8 = this.zzd;
        int length = this.zzc.length;
        if (i8 == length) {
            int[] iArr = new int[zzk(length)];
            System.arraycopy(this.zzc, 0, iArr, 0, this.zzd);
            this.zzc = iArr;
        }
        int[] iArr2 = this.zzc;
        int i9 = this.zzd;
        this.zzd = i9 + 1;
        iArr2[i9] = i2;
    }

    public final void zzj(int i2) {
        int length = this.zzc.length;
        if (i2 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new int[Math.max(i2, 10)];
            return;
        }
        while (length < i2) {
            length = zzk(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzhwp(int[] iArr, int i2, boolean z2) {
        super(z2);
        this.zzc = iArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzi(((Integer) obj).intValue());
        return true;
    }
}
