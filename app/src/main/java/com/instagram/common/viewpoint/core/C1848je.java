package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.util.SparseArray;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.je, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1848je implements GX {
    public static String[] A0B = {"UBvRkgXOGDkhiRviOullp8V", "VkNaXMTzU8N2w", "EmncOItxREzVuvRcJiesLUTUZ", "GKNHQwhZeE13dvoU8lLSXwuEJRZ0Rb8T", "UfDFEQBLtd8kFCM7fNQpR1e2paOBi7mP", "RVi2VPuM0SECIbGMRSZvlBLvqxfM7S", "lPCpjqdMUX8JsRnbL9v7kcIYKByBL6xe", "JprIbG5eTccKgwX6h6kDKt0luN"};
    public static final InterfaceC0763Gb A0C = new InterfaceC0763Gb() { // from class: com.facebook.ads.redexgen.X.jf
        @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
        public final GX[] A5F() {
            return C1848je.A01();
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
        public final /* synthetic */ GX[] A5G(Uri uri, Map map) {
            return AbstractC0762Ga.A01(this, uri, map);
        }
    };
    public long A00;
    public GY A01;
    public C1850jg A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final SparseArray<KV> A07;
    public final C4J A08;
    public final C4R A09;
    public final KU A0A;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b1  */
    @Override // com.instagram.common.viewpoint.core.GX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int AGb(com.instagram.common.viewpoint.core.InterfaceC1943lN r12, com.instagram.common.viewpoint.core.C0781Gt r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1848je.AGb(com.facebook.ads.redexgen.X.lN, com.facebook.ads.redexgen.X.Gt):int");
    }

    public C1848je() {
        this(new C4R(0L));
    }

    public C1848je(C4R c4r) {
        this.A09 = c4r;
        this.A08 = new C4J(4096);
        this.A07 = new SparseArray<>();
        this.A0A = new KU();
    }

    @RequiresNonNull({"output"})
    private void A00(long j) {
        if (!this.A06) {
            this.A06 = true;
            if (this.A0A.A0C() != -9223372036854775807L) {
                this.A02 = new C1850jg(this.A0A.A0D(), this.A0A.A0C(), j);
                this.A01.AIN(this.A02.A07());
            } else {
                this.A01.AIN(new C1938lI(this.A0A.A0C()));
            }
        }
    }

    public static /* synthetic */ GX[] A01() {
        return new GX[]{new C1848je()};
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AA4(GY gy) {
        this.A01 = gy;
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AGr() {
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AIM(long j, long j3) {
        boolean z2 = false;
        boolean resetTimestampAdjuster = this.A09.A04() == -9223372036854775807L;
        if (!resetTimestampAdjuster) {
            long jA02 = this.A09.A02();
            if (jA02 != -9223372036854775807L && jA02 != 0 && jA02 != j3) {
                z2 = true;
            }
            resetTimestampAdjuster = z2;
        }
        if (resetTimestampAdjuster) {
            this.A09.A07(j3);
        }
        if (this.A02 != null) {
            this.A02.A08(j3);
        }
        for (int i2 = 0; i2 < this.A07.size(); i2++) {
            this.A07.valueAt(i2).A02();
        }
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final boolean AJL(InterfaceC1943lN interfaceC1943lN) throws IOException {
        byte[] bArr = new byte[14];
        interfaceC1943lN.AG9(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        byte b8 = bArr[13];
        if (A0B[3].charAt(12) == 'n') {
            throw new RuntimeException();
        }
        A0B[2] = "VV5ZPjEmtEUa5x1ycfEwWXr";
        int packStuffingLength = b8 & 7;
        interfaceC1943lN.A3z(packStuffingLength);
        interfaceC1943lN.AG9(bArr, 0, 3);
        int packStuffingLength2 = bArr[0];
        int i2 = (packStuffingLength2 & 255) << 16;
        int packStuffingLength3 = bArr[1];
        int i8 = i2 | ((packStuffingLength3 & 255) << 8);
        int packStuffingLength4 = bArr[2];
        return 1 == ((packStuffingLength4 & 255) | i8);
    }
}
