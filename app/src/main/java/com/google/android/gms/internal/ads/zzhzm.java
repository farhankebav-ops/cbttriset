package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhzm extends zzhzl {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0080, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    @Override // com.google.android.gms.internal.ads.zzhzl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(int r12, byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhzm.zza(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final String zzb(byte[] bArr, int i2, int i8) throws zzhxd {
        int i9;
        int length = bArr.length;
        if ((((length - i2) - i8) | i2 | i8) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i8)));
        }
        int i10 = i2 + i8;
        char[] cArr = new char[i8];
        int i11 = 0;
        while (i2 < i10) {
            byte b8 = bArr[i2];
            if (!zzhzk.zza(b8)) {
                break;
            }
            i2++;
            cArr[i11] = (char) b8;
            i11++;
        }
        int i12 = i11;
        while (i2 < i10) {
            int i13 = i2 + 1;
            byte b9 = bArr[i2];
            if (zzhzk.zza(b9)) {
                cArr[i12] = (char) b9;
                i12++;
                i2 = i13;
                while (i2 < i10) {
                    byte b10 = bArr[i2];
                    if (zzhzk.zza(b10)) {
                        i2++;
                        cArr[i12] = (char) b10;
                        i12++;
                    }
                }
            } else {
                if (zzhzk.zzb(b9)) {
                    if (i13 >= i10) {
                        throw new zzhxd("Protocol message had invalid UTF-8.");
                    }
                    i9 = i12 + 1;
                    i2 += 2;
                    zzhzk.zzd(b9, bArr[i13], cArr, i12);
                } else if (zzhzk.zzc(b9)) {
                    if (i13 >= i10 - 1) {
                        throw new zzhxd("Protocol message had invalid UTF-8.");
                    }
                    i9 = i12 + 1;
                    int i14 = i2 + 2;
                    i2 += 3;
                    zzhzk.zze(b9, bArr[i13], bArr[i14], cArr, i12);
                } else {
                    if (i13 >= i10 - 2) {
                        throw new zzhxd("Protocol message had invalid UTF-8.");
                    }
                    byte b11 = bArr[i13];
                    int i15 = i2 + 3;
                    byte b12 = bArr[i2 + 2];
                    i2 += 4;
                    zzhzk.zzf(b9, b11, b12, bArr[i15], cArr, i12);
                    i12 += 2;
                }
                i12 = i9;
            }
        }
        return new String(cArr, 0, i12);
    }
}
