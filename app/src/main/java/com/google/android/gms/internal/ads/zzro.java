package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzro extends zzch {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    private static void zzq(int i2, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i2) * 4.656612875245797E-10d));
        if (iFloatToIntBits == zzd) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final void zzd(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferZzk;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        int i8 = this.zzb.zzd;
        if (i8 == 21) {
            byteBufferZzk = zzk((i2 / 3) * 4);
            while (iPosition < iLimit) {
                zzq(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferZzk);
                iPosition += 3;
            }
        } else if (i8 == 22) {
            byteBufferZzk = zzk(i2);
            while (iPosition < iLimit) {
                int i9 = byteBuffer.get(iPosition) & 255;
                int i10 = (byteBuffer.get(iPosition + 1) & 255) << 8;
                zzq(i9 | i10 | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferZzk);
                iPosition += 4;
            }
        } else if (i8 == 1342177280) {
            byteBufferZzk = zzk((i2 / 3) * 4);
            while (iPosition < iLimit) {
                zzq(((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferZzk);
                iPosition += 3;
            }
        } else {
            if (i8 != 1610612736) {
                throw new IllegalStateException();
            }
            byteBufferZzk = zzk(i2);
            while (iPosition < iLimit) {
                int i11 = byteBuffer.get(iPosition + 3) & 255;
                int i12 = (byteBuffer.get(iPosition + 2) & 255) << 8;
                zzq(i11 | i12 | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferZzk);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferZzk.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final zzcd zzm(zzcd zzcdVar) throws zzcf {
        int i2 = zzcdVar.zzd;
        String str = zzep.zza;
        if (i2 == 21 || i2 == 1342177280 || i2 == 22 || i2 == 1610612736) {
            return new zzcd(zzcdVar.zzb, zzcdVar.zzc, 4);
        }
        if (i2 == 4) {
            return zzcd.zza;
        }
        throw new zzcf("Unhandled input format:", zzcdVar);
    }
}
