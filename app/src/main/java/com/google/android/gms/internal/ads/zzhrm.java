package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhrm {
    public static byte[] zza(byte[]... bArr) throws GeneralSecurityException {
        int i2 = 0;
        int i8 = 0;
        while (true) {
            if (i2 >= bArr.length) {
                byte[] bArr2 = new byte[i8];
                int i9 = 0;
                for (byte[] bArr3 : bArr) {
                    int length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i9, length);
                    i9 += length;
                }
                return bArr2;
            }
            int length2 = bArr[i2].length;
            if (i8 > Integer.MAX_VALUE - length2) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i8 += length2;
            i2++;
        }
    }

    public static final byte[] zzb(byte[] bArr, int i2, byte[] bArr2, int i8, int i9) {
        if (bArr.length - 16 < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[16];
        for (int i10 = 0; i10 < 16; i10++) {
            bArr3[i10] = (byte) (bArr[i10 + i2] ^ bArr2[i10]);
        }
        return bArr3;
    }

    public static final void zzc(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2) {
        if (i2 < 0 || byteBuffer2.remaining() < i2 || byteBuffer3.remaining() < i2 || byteBuffer.remaining() < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i8 = 0; i8 < i2; i8++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }
}
