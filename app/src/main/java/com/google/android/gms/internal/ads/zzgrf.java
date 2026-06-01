package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgrf extends zzgpo {
    static final zzgrf zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzgrf(objArr, 0, objArr, 0, 0);
    }

    public zzgrf(Object[] objArr, int i2, Object[] objArr2, int i8, int i9) {
        this.zzb = objArr;
        this.zze = i2;
        this.zzc = objArr2;
        this.zzf = i8;
        this.zzg = i9;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZzb = zzgox.zzb(obj);
                while (true) {
                    int i2 = iZzb & this.zzf;
                    Object obj2 = objArr[i2];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZzb = i2 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgpo, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgpo, com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgpo, com.google.android.gms.internal.ads.zzgpa
    /* JADX INFO: renamed from: zza */
    public final zzgrs iterator() {
        return zze().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final int zzd() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final int zzg(Object[] objArr, int i2) {
        Object[] objArr2 = this.zzb;
        int i8 = this.zzg;
        System.arraycopy(objArr2, 0, objArr, i2, i8);
        return i2 + i8;
    }

    @Override // com.google.android.gms.internal.ads.zzgpo
    public final boolean zzq() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgpo
    public final zzgpe zzr() {
        return zzgpe.zzt(this.zzb, this.zzg);
    }
}
