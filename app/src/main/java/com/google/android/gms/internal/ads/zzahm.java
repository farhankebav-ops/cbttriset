package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahm {
    private static final long[] zza = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] zzb = new byte[8];
    private int zzc;
    private int zzd;

    public static int zzd(int i2) {
        int i8 = 0;
        while (i8 < 8) {
            int i9 = i8 + 1;
            if ((zza[i8] & ((long) i2)) != 0) {
                return i9;
            }
            i8 = i9;
        }
        return -1;
    }

    public static long zze(byte[] bArr, int i2, boolean z2) {
        long j = ((long) bArr[0]) & 255;
        if (z2) {
            j &= ~zza[i2 - 1];
        }
        for (int i8 = 1; i8 < i2; i8++) {
            j = (j << 8) | (((long) bArr[i8]) & 255);
        }
        return j;
    }

    public final void zza() {
        this.zzc = 0;
        this.zzd = 0;
    }

    public final long zzb(zzadb zzadbVar, boolean z2, boolean z7, int i2) throws IOException {
        if (this.zzc == 0) {
            byte[] bArr = this.zzb;
            if (!zzadbVar.zzb(bArr, 0, 1, z2)) {
                return -1L;
            }
            int iZzd = zzd(bArr[0] & 255);
            this.zzd = iZzd;
            if (iZzd == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.zzc = 1;
        }
        int i8 = this.zzd;
        if (i8 > i2) {
            this.zzc = 0;
            return -2L;
        }
        if (i8 != 1) {
            zzadbVar.zzc(this.zzb, 1, i8 - 1);
        }
        this.zzc = 0;
        return zze(this.zzb, this.zzd, z7);
    }

    public final int zzc() {
        return this.zzd;
    }
}
