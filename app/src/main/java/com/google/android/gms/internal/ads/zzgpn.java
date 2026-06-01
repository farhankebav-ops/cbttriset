package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgpn extends zzgoy {
    Object[] zzd;
    private int zze;

    public zzgpn() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzgoy, com.google.android.gms.internal.ads.zzgoz
    public final /* bridge */ /* synthetic */ zzgoz zzd(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzgpn zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzn = zzgpo.zzn(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzn <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzgox.zza(iHashCode);
                while (true) {
                    int i2 = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i2];
                    if (obj2 == null) {
                        objArr2[i2] = obj;
                        this.zze += iHashCode;
                        zza(obj);
                        return this;
                    }
                    if (obj2.equals(obj)) {
                        return this;
                    }
                    iZza = i2 + 1;
                }
            }
        }
        this.zzd = null;
        zza(obj);
        return this;
    }

    public final zzgpn zzg(Object... objArr) {
        if (this.zzd == null) {
            zzb(objArr, 2);
            return this;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            zzf(objArr[i2]);
        }
        return this;
    }

    public final zzgpn zzh(Iterable iterable) {
        iterable.getClass();
        if (this.zzd == null) {
            zzc(iterable);
            return this;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzf(it.next());
        }
        return this;
    }

    public final zzgpo zzi() {
        zzgpo zzgpoVarZzv;
        int i2 = this.zzb;
        if (i2 == 0) {
            return zzgrf.zza;
        }
        if (i2 == 1) {
            Object obj = this.zza[0];
            Objects.requireNonNull(obj);
            return new zzgrp(obj);
        }
        if (this.zzd == null || zzgpo.zzn(i2) != this.zzd.length) {
            zzgpoVarZzv = zzgpo.zzv(this.zzb, this.zza);
            this.zzb = zzgpoVarZzv.size();
        } else {
            int i8 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzgpo.zzw(i8, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i8);
            }
            zzgpoVarZzv = new zzgrf(objArrCopyOf, this.zze, this.zzd, r6.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzgpoVarZzv;
    }

    public zzgpn(int i2, boolean z2) {
        super(i2);
        this.zzd = new Object[zzgpo.zzn(i2)];
    }
}
