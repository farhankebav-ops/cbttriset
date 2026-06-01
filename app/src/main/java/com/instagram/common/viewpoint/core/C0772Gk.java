package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0772Gk {
    public final C4J A00 = new C4J(10);

    public final Metadata A00(InterfaceC1943lN interfaceC1943lN, InterfaceC0790Hc interfaceC0790Hc) throws IOException {
        int tagLength = 0;
        Metadata metadataA0S = null;
        while (true) {
            try {
                interfaceC1943lN.AG9(this.A00.A0l(), 0, 10);
                this.A00.A0f(0);
                if (this.A00.A0K() != 4801587) {
                    break;
                }
                this.A00.A0g(3);
                int iA0H = this.A00.A0H();
                int framesLength = iA0H + 10;
                if (metadataA0S == null) {
                    byte[] bArr = new byte[framesLength];
                    System.arraycopy(this.A00.A0l(), 0, bArr, 0, 10);
                    interfaceC1943lN.AG9(bArr, 10, iA0H);
                    metadataA0S = new C05748i(interfaceC0790Hc).A0S(bArr, framesLength);
                } else {
                    interfaceC1943lN.A3z(iA0H);
                }
                tagLength += framesLength;
            } catch (EOFException unused) {
            }
        }
        interfaceC1943lN.AI1();
        interfaceC1943lN.A3z(tagLength);
        return metadataA0S;
    }
}
