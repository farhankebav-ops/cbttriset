package com.instagram.common.viewpoint.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1934lE implements GP {
    public static String[] A03 = {"Qzrb2NyX11iip4M0Dun9HjrVhDBjGiaF", "S4lxERGEQHczdoRlIRLlXReEKfWFWSGc", "txU8e6wljbe290bqTydjfEMDFUDvEmx5", "ZB68ibpDVF3DEFIIdRwQIG37zRUG2jhG", "NKfzuQ6LKFKezVni40AKhLW9Qs", "gUOm4cnsv29C5J2bDVOWEpGrIAhYUn7e", "xRx4EoAOCCZ90h8tA3pJ1YmFxzetviZR", "6LlO7okteSZZNTbDPWq3J1SHLhykMwkf"};
    public final int A00;
    public final C0764Gc A01;
    public final C0769Gh A02;

    @Override // com.instagram.common.viewpoint.core.GP
    public final /* synthetic */ void AFA() {
    }

    public C1934lE(C0769Gh c0769Gh, int i2) {
        this.A02 = c0769Gh;
        this.A00 = i2;
        this.A01 = new C0764Gc();
    }

    private long A00(InterfaceC1943lN interfaceC1943lN) throws IOException {
        while (interfaceC1943lN.A8a() < interfaceC1943lN.A8G() - 6 && !AbstractC0765Gd.A09(interfaceC1943lN, this.A02, this.A00, this.A01)) {
            String[] strArr = A03;
            if (strArr[1].charAt(7) == strArr[7].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[6] = "MdA2mB0qiCN7NKRKcBY3aVGEnEzRIKP4";
            strArr2[3] = "Kp5wPJFyOGMB7tBJUi3Fl7WX9iQtExSk";
            interfaceC1943lN.A3z(1);
        }
        if (interfaceC1943lN.A8a() >= interfaceC1943lN.A8G() - 6) {
            interfaceC1943lN.A3z((int) (interfaceC1943lN.A8G() - interfaceC1943lN.A8a()));
            return this.A02.A09;
        }
        return this.A01.A00;
    }

    @Override // com.instagram.common.viewpoint.core.GP
    public final GN AIC(InterfaceC1943lN interfaceC1943lN, long j) throws IOException {
        long rightFrameFirstSampleNumber = interfaceC1943lN.A8f();
        long leftFrameFirstSampleNumber = A00(interfaceC1943lN);
        long jA8a = interfaceC1943lN.A8a();
        interfaceC1943lN.A3z(Math.max(6, this.A02.A06));
        long searchPosition = A00(interfaceC1943lN);
        long leftFramePosition = interfaceC1943lN.A8a();
        if (leftFrameFirstSampleNumber <= j && searchPosition > j) {
            return GN.A03(jA8a);
        }
        if (searchPosition <= j) {
            return GN.A05(searchPosition, leftFramePosition);
        }
        return GN.A04(leftFrameFirstSampleNumber, rightFrameFirstSampleNumber);
    }
}
