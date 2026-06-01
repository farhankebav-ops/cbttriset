package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzamr {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;

    public zzamr(int i2) {
    }

    public final void zza() {
        this.zze = false;
        this.zza = 0;
        this.zzb = 0;
    }

    public final boolean zzb(int i2, int i8) {
        if (this.zze) {
            int i9 = this.zza - i8;
            this.zza = i9;
            if (this.zzb != 0 || i2 != 181) {
                this.zze = false;
                return true;
            }
            this.zzb = i9;
        } else if (i2 == 179) {
            this.zze = true;
        }
        zzc(zzd, 0, 3);
        return false;
    }

    public final void zzc(byte[] bArr, int i2, int i8) {
        if (this.zze) {
            int i9 = i8 - i2;
            byte[] bArr2 = this.zzc;
            int length = bArr2.length;
            int i10 = this.zza + i9;
            if (length < i10) {
                this.zzc = Arrays.copyOf(bArr2, i10 + i10);
            }
            System.arraycopy(bArr, i2, this.zzc, this.zza, i9);
            this.zza += i9;
        }
    }
}
