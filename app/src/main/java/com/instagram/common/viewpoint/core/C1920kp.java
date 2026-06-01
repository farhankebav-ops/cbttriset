package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1920kp implements I8 {
    public final /* synthetic */ MatroskaExtractor A00;

    public C1920kp(MatroskaExtractor matroskaExtractor) {
        this.A00 = matroskaExtractor;
    }

    @Override // com.instagram.common.viewpoint.core.I8
    public final void A4a(int i2, int i8, InterfaceC1943lN interfaceC1943lN) throws IOException {
        this.A00.A0U(i2, i8, interfaceC1943lN);
    }

    @Override // com.instagram.common.viewpoint.core.I8
    public final void A6F(int i2) throws C04222i {
        this.A00.A0S(i2);
    }

    @Override // com.instagram.common.viewpoint.core.I8
    public final void A6S(int i2, double d8) throws C04222i {
        this.A00.A0T(i2, d8);
    }

    @Override // com.instagram.common.viewpoint.core.I8
    public final int A7m(int i2) {
        return this.A00.A0R(i2);
    }

    @Override // com.instagram.common.viewpoint.core.I8
    public final void AA9(int i2, long j) throws C04222i {
        this.A00.A0V(i2, j);
    }

    @Override // com.instagram.common.viewpoint.core.I8
    public final boolean AAN(int i2) {
        return this.A00.A0Y(i2);
    }

    @Override // com.instagram.common.viewpoint.core.I8
    public final void AJO(int i2, long j, long j3) throws C04222i {
        this.A00.A0W(i2, j, j3);
    }

    @Override // com.instagram.common.viewpoint.core.I8
    public final void AJZ(int i2, String str) throws C04222i {
        this.A00.A0X(i2, str);
    }
}
