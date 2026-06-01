package com.instagram.common.viewpoint.core;

import java.io.ByteArrayInputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1829jK implements L9 {
    public ByteArrayInputStream A00;
    public final byte[] A01;

    public C1829jK(byte[] bArr) {
        this.A01 = bArr;
    }

    @Override // com.instagram.common.viewpoint.core.L9
    public final void AFz(int i2) throws C1828jJ {
        this.A00 = new ByteArrayInputStream(this.A01);
        this.A00.skip(i2);
    }

    @Override // com.instagram.common.viewpoint.core.L9
    public final void close() throws C1828jJ {
    }

    @Override // com.instagram.common.viewpoint.core.L9
    public final int length() throws C1828jJ {
        return this.A01.length;
    }

    @Override // com.instagram.common.viewpoint.core.L9
    public final int read(byte[] bArr) throws C1828jJ {
        return this.A00.read(bArr, 0, bArr.length);
    }
}
