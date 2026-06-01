package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzasg {
    public static final zzasg zzb = new zzasg(new byte[0]);
    public static final Comparator zzc = new zzasf();
    public final byte[] zza;

    public zzasg(byte[] bArr) {
        this.zza = bArr;
    }

    public static zzasg zze(byte[] bArr) {
        return new zzasg(zzh(bArr, 0, bArr.length));
    }

    public static zzasg zzf(String str) {
        return zze(str.getBytes(Charset.forName(zzase.zza("Hn2H4l0="))));
    }

    public static int zzg(byte b8) {
        int[] iArr = {2107654819, 15074090, 1957914693, -2142502098, -1902504939, -100121615, 100669, 1835342733, 837626799};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        return b8 & ((iArr[7] % 837626799) ^ com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13));
    }

    public static byte[] zzh(byte[] bArr, int i2, int i8) {
        if (i8 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, i2, bArr2, 0, i8);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzasg) {
            return Arrays.equals(this.zza, ((zzasg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        int[] iArr = {936621968, 262671172, 1099388327, 506341952, 1363551406, -1491858486, 110389885, 989492335, 981766422};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        String string = Arrays.toString(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + ((i14 % 981766422) ^ iC));
        sb.append(zzase.zza("CVC1qiQNJHikW0iU1TIPZA=="));
        sb.append(string);
        sb.append(zzase.zza("Ng=="));
        return sb.toString();
    }

    public final byte[] zza() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        return length == 0 ? new byte[0] : zzh(bArr, 0, length);
    }

    public final byte zzb(int i2) {
        int i8 = ((((~2106914653) & 587408197) | 1537377410) + ((2106914653 & 536945509) | 443419704)) - 2137956065;
        int i9 = 2013725218 % 1633938701;
        int i10 = ((((~1287859999) & 62941354) | 437464817) + ((1287859999 & 1639989262) | 1644309956)) - 2060977796;
        int i11 = 1442767057 % 63299708;
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (((length - (i2 + 1)) | i2) >= 0) {
            return bArr[i2];
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(i2, i8 ^ i9));
            sb.append(zzase.zza("Akelqh1fajntGgo="));
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(length, com.google.android.gms.ads.internal.client.a.a(i2, i10 ^ i11)));
        sb2.append(zzase.zza("Akelqh1faDmxRUSK1T9GeQ=="));
        sb2.append(i2);
        sb2.append(zzase.zza("Zwk="));
        sb2.append(length);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    public final String zzc() {
        Charset charsetForName = Charset.forName(zzase.zza("Hn2H4l0="));
        byte[] bArr = this.zza;
        return new String(bArr, 0, bArr.length, charsetForName);
    }

    public final zzasg zzd(zzasg zzasgVar) {
        byte[] bArr = zzasgVar.zza;
        int length = bArr.length;
        byte[] bArr2 = this.zza;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2 + length];
        System.arraycopy(bArr2, 0, bArr3, 0, length2);
        System.arraycopy(bArr, 0, bArr3, length2, length);
        return zze(bArr3);
    }
}
