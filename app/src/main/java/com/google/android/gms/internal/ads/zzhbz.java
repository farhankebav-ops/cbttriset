package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzhbz {
    int[] zza;
    private final int zzb;

    public zzhbz(byte[] bArr, int i2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzhbx.zzd(bArr);
        this.zzb = i2;
    }

    public abstract int[] zza(int[] iArr, int i2);

    public abstract int zzb();

    public final byte[] zzc(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length != zzb()) {
            int iZzb = zzb();
            throw new GeneralSecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZzb).length() + 36), "The nonce length (in bytes) must be ", iZzb));
        }
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining / 64;
        for (int i8 = 0; i8 < i2 + 1; i8++) {
            ByteBuffer byteBufferZzd = zzd(bArr, this.zzb + i8);
            if (i8 == i2) {
                zzhrm.zzc(byteBufferAllocate, byteBuffer, byteBufferZzd, iRemaining % 64);
            } else {
                zzhrm.zzc(byteBufferAllocate, byteBuffer, byteBufferZzd, 64);
            }
        }
        return byteBufferAllocate.array();
    }

    public final ByteBuffer zzd(byte[] bArr, int i2) {
        int[] iArrZza = zza(zzhbx.zzd(bArr), i2);
        int[] iArr = (int[]) iArrZza.clone();
        zzhbx.zzb(iArr);
        for (int i8 = 0; i8 < 16; i8++) {
            iArrZza[i8] = iArrZza[i8] + iArr[i8];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZza, 0, 16);
        return byteBufferOrder;
    }
}
