package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbcb extends zzbbw {
    private MessageDigest zzb;

    @Override // com.google.android.gms.internal.ads.zzbbw
    public final byte[] zza(String str) {
        byte[] bArr;
        byte[] bArrArray;
        String[] strArrSplit = str.split(" ");
        int length = strArrSplit.length;
        int i2 = 4;
        if (length == 1) {
            int iZza = zzbca.zza(strArrSplit[0]);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.putInt(iZza);
            bArrArray = byteBufferAllocate.array();
        } else {
            if (length < 5) {
                bArr = new byte[length + length];
                for (int i8 = 0; i8 < strArrSplit.length; i8++) {
                    int iZza2 = zzbca.zza(strArrSplit[i8]);
                    int i9 = (iZza2 >> 16) ^ ((char) iZza2);
                    byte b8 = (byte) i9;
                    byte b9 = (byte) (i9 >> 8);
                    int i10 = i8 + i8;
                    bArr[i10] = new byte[]{b8, b9}[0];
                    bArr[i10 + 1] = b9;
                }
            } else {
                bArr = new byte[length];
                for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                    int iZza3 = zzbca.zza(strArrSplit[i11]);
                    bArr[i11] = (byte) ((iZza3 >> 24) ^ (((iZza3 & 255) ^ ((iZza3 >> 8) & 255)) ^ ((iZza3 >> 16) & 255)));
                }
            }
            bArrArray = bArr;
        }
        this.zzb = zzb();
        synchronized (this.zza) {
            try {
                MessageDigest messageDigest = this.zzb;
                if (messageDigest == null) {
                    return new byte[0];
                }
                messageDigest.reset();
                this.zzb.update(bArrArray);
                byte[] bArrDigest = this.zzb.digest();
                int length2 = bArrDigest.length;
                if (length2 <= 4) {
                    i2 = length2;
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArrDigest, 0, bArr2, 0, i2);
                return bArr2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
