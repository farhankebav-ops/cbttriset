package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhyk extends zzhuu implements RandomAccess {
    private static final Object[] zza;
    private static final zzhyk zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzhyk(objArr, 0, false);
    }

    public zzhyk() {
        this(zza, 0, true);
    }

    public static zzhyk zzd() {
        return zzb;
    }

    private static int zzf(int i2) {
        return Math.max(((i2 * 3) / 2) + 1, 10);
    }

    private final void zzg(int i2) {
        if (i2 < 0 || i2 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzi(i2));
        }
    }

    private final String zzi(int i2) {
        int i8 = this.zzd;
        return a1.a.f(i2, i8, "Index:", ", Size:", new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i8).length()));
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i8;
        zzea();
        if (i2 < 0 || i2 > (i8 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzi(i2));
        }
        int i9 = i2 + 1;
        Object[] objArr = this.zzc;
        int length = objArr.length;
        if (i8 < length) {
            System.arraycopy(objArr, i2, objArr, i9, i8 - i2);
        } else {
            Object[] objArr2 = new Object[zzf(length)];
            System.arraycopy(this.zzc, 0, objArr2, 0, i2);
            System.arraycopy(this.zzc, i2, objArr2, i9, this.zzd - i2);
            this.zzc = objArr2;
        }
        this.zzc[i2] = obj;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        zzg(i2);
        return this.zzc[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        zzea();
        zzg(i2);
        Object[] objArr = this.zzc;
        Object obj = objArr[i2];
        if (i2 < this.zzd - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        zzea();
        zzg(i2);
        Object[] objArr = this.zzc;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    public final void zze(int i2) {
        int length = this.zzc.length;
        if (i2 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new Object[Math.max(i2, 10)];
            return;
        }
        while (length < i2) {
            length = zzf(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    @Override // com.google.android.gms.internal.ads.zzhxa, com.google.android.gms.internal.ads.zzhwq
    public final /* bridge */ /* synthetic */ zzhxa zzh(int i2) {
        if (i2 >= this.zzd) {
            return new zzhyk(i2 == 0 ? zza : Arrays.copyOf(this.zzc, i2), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    private zzhyk(Object[] objArr, int i2, boolean z2) {
        super(z2);
        this.zzc = objArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhuu, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzea();
        int i2 = this.zzd;
        int length = this.zzc.length;
        if (i2 == length) {
            this.zzc = Arrays.copyOf(this.zzc, zzf(length));
        }
        Object[] objArr = this.zzc;
        int i8 = this.zzd;
        this.zzd = i8 + 1;
        objArr[i8] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
