package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhvh extends OutputStream {
    private static final byte[] zza = new byte[0];
    private int zzd;
    private int zzf;
    private final int zzb = 128;
    private final ArrayList zzc = new ArrayList();
    private byte[] zze = new byte[128];

    public zzhvh(int i2) {
    }

    private final void zzc(int i2) {
        this.zzc.add(new zzhvg(this.zze));
        int length = this.zzd + this.zze.length;
        this.zzd = length;
        this.zze = new byte[Math.max(this.zzb, Math.max(i2, length >>> 1))];
        this.zzf = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzb()));
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i2) {
        try {
            if (this.zzf == this.zze.length) {
                zzc(1);
            }
            byte[] bArr = this.zze;
            int i8 = this.zzf;
            this.zzf = i8 + 1;
            bArr[i8] = (byte) i2;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized zzhvi zza() {
        try {
            int i2 = this.zzf;
            byte[] bArr = this.zze;
            if (i2 >= bArr.length) {
                this.zzc.add(new zzhvg(this.zze));
                this.zze = zza;
            } else if (i2 > 0) {
                this.zzc.add(new zzhvg(Arrays.copyOf(bArr, i2)));
            }
            this.zzd += this.zzf;
            this.zzf = 0;
        } catch (Throwable th) {
            throw th;
        }
        return zzhvi.zzt(this.zzc);
    }

    public final synchronized int zzb() {
        return this.zzd + this.zzf;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i2, int i8) {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        int i9 = this.zzf;
        int i10 = length - i9;
        if (i8 <= i10) {
            System.arraycopy(bArr, i2, bArr2, i9, i8);
            this.zzf += i8;
            return;
        }
        System.arraycopy(bArr, i2, bArr2, i9, i10);
        int i11 = i8 - i10;
        zzc(i11);
        System.arraycopy(bArr, i2 + i10, this.zze, 0, i11);
        this.zzf = i11;
    }
}
