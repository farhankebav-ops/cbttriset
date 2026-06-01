package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzamt {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;
    private int zzf;

    public zzamt(int i2) {
    }

    public final void zza() {
        this.zze = false;
        this.zza = 0;
        this.zzf = 0;
    }

    public final boolean zzb(int i2, int i8) {
        int i9 = this.zzf;
        if (i9 != 0) {
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 3) {
                        if (i2 == 179 || i2 == 181) {
                            this.zza -= i8;
                            this.zze = false;
                            return true;
                        }
                    } else if ((i2 & 240) != 32) {
                        zzdt.zzc("H263Reader", "Unexpected start code value");
                        zza();
                    } else {
                        this.zzb = this.zza;
                        this.zzf = 4;
                    }
                } else if (i2 > 31) {
                    zzdt.zzc("H263Reader", "Unexpected start code value");
                    zza();
                } else {
                    this.zzf = 3;
                }
            } else if (i2 != 181) {
                zzdt.zzc("H263Reader", "Unexpected start code value");
                zza();
            } else {
                this.zzf = 2;
            }
        } else if (i2 == 176) {
            this.zzf = 1;
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
