package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzel {
    private long[] zza;
    private Object[] zzb;
    private int zzc;
    private int zzd;

    public zzel() {
        throw null;
    }

    @Nullable
    private final Object zzf() {
        zzgmd.zzh(this.zzd > 0);
        Object[] objArr = this.zzb;
        int i2 = this.zzc;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.zzc = (i2 + 1) % objArr.length;
        this.zzd--;
        return obj;
    }

    public final synchronized void zza(long j, Object obj) {
        try {
            if (this.zzd > 0) {
                if (j <= this.zza[((this.zzc + r0) - 1) % this.zzb.length]) {
                    zzb();
                }
            }
            int length = this.zzb.length;
            if (this.zzd >= length) {
                int i2 = length + length;
                long[] jArr = new long[i2];
                Object[] objArr = new Object[i2];
                int i8 = this.zzc;
                int i9 = length - i8;
                System.arraycopy(this.zza, i8, jArr, 0, i9);
                System.arraycopy(this.zzb, this.zzc, objArr, 0, i9);
                int i10 = this.zzc;
                if (i10 > 0) {
                    System.arraycopy(this.zza, 0, jArr, i9, i10);
                    System.arraycopy(this.zzb, 0, objArr, i9, this.zzc);
                }
                this.zza = jArr;
                this.zzb = objArr;
                this.zzc = 0;
            }
            int i11 = this.zzc;
            int i12 = this.zzd;
            Object[] objArr2 = this.zzb;
            int length2 = (i11 + i12) % objArr2.length;
            this.zza[length2] = j;
            objArr2[length2] = obj;
            this.zzd = i12 + 1;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        Arrays.fill(this.zzb, (Object) null);
    }

    public final synchronized int zzc() {
        return this.zzd;
    }

    @Nullable
    public final synchronized Object zzd() {
        if (this.zzd == 0) {
            return null;
        }
        return zzf();
    }

    @Nullable
    public final synchronized Object zze(long j) {
        Object objZzf;
        objZzf = null;
        while (this.zzd > 0 && j - this.zza[this.zzc] >= 0) {
            objZzf = zzf();
        }
        return objZzf;
    }

    public zzel(int i2) {
        this.zza = new long[10];
        this.zzb = new Object[10];
    }
}
