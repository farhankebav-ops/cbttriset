package com.instagram.common.viewpoint.core;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9N, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9N extends AbstractC2040my {
    public int[] A00;
    public int[] A01;

    @Override // com.instagram.common.viewpoint.core.AbstractC2040my
    public final AnonymousClass36 A09(AnonymousClass36 anonymousClass36) throws AnonymousClass37 {
        int[] iArr = this.A01;
        if (iArr == null) {
            return AnonymousClass36.A05;
        }
        if (anonymousClass36.A02 == 2) {
            int i2 = anonymousClass36.A01 != iArr.length ? 1 : 0;
            int i8 = 0;
            while (i8 < iArr.length) {
                int i9 = iArr[i8];
                if (i9 < anonymousClass36.A01) {
                    i2 |= i9 != i8 ? 1 : 0;
                    i8++;
                } else {
                    throw new AnonymousClass37(anonymousClass36);
                }
            }
            if (i2 != 0) {
                return new AnonymousClass36(anonymousClass36.A03, iArr.length, 2);
            }
            return AnonymousClass36.A05;
        }
        throw new AnonymousClass37(anonymousClass36);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2040my
    public final void A0A() {
        this.A00 = this.A01;
    }

    public final void A0C(int[] iArr) {
        this.A01 = iArr;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass38
    public final void AGX(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) C3M.A01(this.A00);
        int iPosition = byteBuffer.position();
        int outputSize = byteBuffer.limit();
        int position = outputSize - iPosition;
        ByteBuffer byteBufferA00 = A00(this.A06.A00 * (position / this.A05.A00));
        while (iPosition < outputSize) {
            for (int i2 : iArr) {
                byteBufferA00.putShort(byteBuffer.getShort((i2 * 2) + iPosition));
            }
            iPosition += this.A05.A00;
        }
        byteBuffer.position(outputSize);
        byteBufferA00.flip();
    }
}
