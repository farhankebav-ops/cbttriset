package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhsz {
    private final byte[] zza;

    private zzhsz(byte[] bArr, int i2, int i8) {
        byte[] bArr2 = new byte[i8];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i8);
    }

    public static zzhsz zza(byte[] bArr) {
        if (bArr != null) {
            return zzb(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public static zzhsz zzb(byte[] bArr, int i2, int i8) {
        if (bArr == null) {
            throw new NullPointerException("data must be non-null");
        }
        int length = bArr.length;
        if (i8 > length) {
            i8 = length;
        }
        return new zzhsz(bArr, 0, i8);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzhsz) {
            return Arrays.equals(((zzhsz) obj).zza, this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b8 : bArr) {
            sb.append("0123456789abcdef".charAt((b8 & 255) >> 4));
            sb.append("0123456789abcdef".charAt(b8 & 15));
        }
        String string = sb.toString();
        return a1.a.s(new StringBuilder(string.length() + 7), "Bytes(", string, ")");
    }

    public final byte[] zzc() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public final int zzd() {
        return this.zza.length;
    }
}
