package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgbm {
    private final byte[] zza = new byte[256];
    private int zzb;
    private int zzc;

    public zzgbm(byte[] bArr) {
        for (int i2 = 0; i2 < 256; i2++) {
            this.zza[i2] = (byte) i2;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < 256; i9++) {
            byte[] bArr2 = this.zza;
            byte b8 = bArr2[i9];
            i8 = (i8 + b8 + bArr[i9 % bArr.length]) & 255;
            bArr2[i9] = bArr2[i8];
            bArr2[i8] = b8;
        }
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zza(byte[] bArr) {
        int i2 = this.zzb;
        int i8 = this.zzc;
        for (int i9 = 0; i9 < 256; i9++) {
            byte[] bArr2 = this.zza;
            i2 = (i2 + 1) & 255;
            byte b8 = bArr2[i2];
            i8 = (i8 + b8) & 255;
            bArr2[i2] = bArr2[i8];
            bArr2[i8] = b8;
            bArr[i9] = (byte) (bArr2[(bArr2[i2] + b8) & 255] ^ bArr[i9]);
        }
        this.zzb = i2;
        this.zzc = i8;
    }
}
