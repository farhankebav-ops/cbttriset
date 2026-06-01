package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhxn extends zzhuu implements RandomAccess, zzhwz, zzhyi {
    private static final long[] zza;
    private static final zzhxn zzb;
    private long[] zzc;
    private int zzd;

    static {
        long[] jArr = new long[0];
        zza = jArr;
        zzb = new zzhxn(jArr, 0, false);
    }

    public zzhxn() {
        this(zza, 0, true);
    }

    public static zzhxn zzg() {
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
        long jLongValue = ((Long) obj).longValue();
        zzea();
        if (i2 < 0 || i2 > (i8 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzl(i2));
        }
        int i9 = i2 + 1;
        long[] jArr = this.zzc;
        int length = jArr.length;
        if (i8 < length) {
            System.arraycopy(jArr, i2, jArr, i9, i8 - i2);
        } else {
            long[] jArr2 = new long[zzj(length)];
            System.arraycopy(this.zzc, 0, jArr2, 0, i2);
            System.arraycopy(this.zzc, i2, jArr2, i9, this.zzd - i2);
            this.zzc = jArr2;
        }
        this.zzc[i2] = jLongValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzea();
        byte[] bArr = zzhxb.zzb;
        collection.getClass();
        if (!(collection instanceof zzhxn)) {
            return super.addAll(collection);
        }
        zzhxn zzhxnVar = (zzhxn) collection;
        int i2 = zzhxnVar.zzd;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.zzd;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        long[] jArr = this.zzc;
        if (i9 > jArr.length) {
            this.zzc = Arrays.copyOf(jArr, i9);
        }
        System.arraycopy(zzhxnVar.zzc, 0, this.zzc, this.zzd, zzhxnVar.zzd);
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
        if (!(obj instanceof zzhxn)) {
            return super.equals(obj);
        }
        zzhxn zzhxnVar = (zzhxn) obj;
        if (this.zzd != zzhxnVar.zzd) {
            return false;
        }
        long[] jArr = zzhxnVar.zzc;
        for (int i2 = 0; i2 < this.zzd; i2++) {
            if (this.zzc[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzk(i2);
        return Long.valueOf(this.zzc[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i8 = 0; i8 < this.zzd; i8++) {
            long j = this.zzc[i8];
            byte[] bArr = zzhxb.zzb;
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
        int i2 = this.zzd;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zzc[i8] == jLongValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzea();
        zzk(i2);
        long[] jArr = this.zzc;
        long j = jArr[i2];
        if (i2 < this.zzd - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        zzea();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzc;
        System.arraycopy(jArr, i8, jArr, i2, this.zzd - i8);
        this.zzd -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        return Long.valueOf(zze(i2, ((Long) obj).longValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhwz
    public final long zzc(int i2) {
        zzk(i2);
        return this.zzc[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhwz
    public final void zzd(long j) {
        zzea();
        int i2 = this.zzd;
        int length = this.zzc.length;
        if (i2 == length) {
            long[] jArr = new long[zzj(length)];
            System.arraycopy(this.zzc, 0, jArr, 0, this.zzd);
            this.zzc = jArr;
        }
        long[] jArr2 = this.zzc;
        int i8 = this.zzd;
        this.zzd = i8 + 1;
        jArr2[i8] = j;
    }

    @Override // com.google.android.gms.internal.ads.zzhwz
    public final long zze(int i2, long j) {
        zzea();
        zzk(i2);
        long[] jArr = this.zzc;
        long j3 = jArr[i2];
        jArr[i2] = j;
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzhxa, com.google.android.gms.internal.ads.zzhwq
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzhwz zzh(int i2) {
        if (i2 >= this.zzd) {
            return new zzhxn(i2 == 0 ? zza : Arrays.copyOf(this.zzc, i2), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzi(int i2) {
        int length = this.zzc.length;
        if (i2 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new long[Math.max(i2, 10)];
            return;
        }
        while (length < i2) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzhxn(long[] jArr, int i2, boolean z2) {
        super(z2);
        this.zzc = jArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzd(((Long) obj).longValue());
        return true;
    }
}
