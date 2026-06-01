package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C04483i extends C0686Dc {
    public static String[] A0F = {"r3hDWnB1R9y4pEiKAURNp99h2b", "kj3t6dP2tWSOfb61zMSBvgjhGLqlygll", "", "sX8uIgx32JWe8q5WuLHBMtkPG7d", "ZlH8xHdCAMZsgB23qoj", "6lejLSjHGD", "XsRzuVWfX96s5Dei3zwO9zjz9s6FXTfu", "pCK0u"};
    public int A00;
    public C1480dO A01;
    public boolean A02;
    public final AbstractC1100Tf<C04433d> A03;
    public final AbstractC1100Tf<C3Y> A04;
    public final AbstractC1100Tf<DQ> A05;
    public final AbstractC1100Tf<C3Q> A06;
    public final AbstractC1100Tf<DL> A07;
    public final AbstractC1100Tf<DJ> A08;
    public final AbstractC1100Tf<DI> A09;
    public final AbstractC1100Tf<DD> A0A;
    public final AbstractC1100Tf<DC> A0B;
    public final E1 A0C;
    public final DN A0D;
    public final DE A0E;

    public C04483i(C1477dL c1477dL, US us, E1 e12, String str) {
        this(c1477dL, us, e12, str, 0, 0, false, null, null);
    }

    public C04483i(C1477dL c1477dL, US us, E1 e12, String str, int i2, int i8, boolean z2, Bundle bundle, Map<String, String> map) {
        super(c1477dL, us, e12, str, !e12.A0p(), i2, i8, z2, bundle, map, new C0685Db(c1477dL, e12));
        this.A0E = new DE() { // from class: com.facebook.ads.redexgen.X.3j
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(DF df) {
                this.A00.A0f();
            }
        };
        this.A08 = new C0696Dm(this);
        this.A04 = new C0695Dl(this);
        this.A05 = new C0694Dk(this);
        this.A06 = new C0693Dj(this);
        this.A03 = new C0692Di(this);
        this.A07 = new C0691Dh(this);
        this.A0A = new C0690Dg(this);
        this.A0B = new C0689Df(this);
        this.A09 = new C0701Dr(this);
        this.A0D = new DN() { // from class: com.facebook.ads.redexgen.X.3k
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(DO r32) {
                this.A00.A00 = this.A00.A0C.getDuration();
            }
        };
        this.A02 = false;
        this.A0C = e12;
        this.A0C.getEventBus().A03(this.A0E, this.A06, this.A08, this.A05, this.A04, this.A03, this.A07, this.A0A, this.A0B, this.A0D, this.A09);
        if (U7.A2m(c1477dL)) {
            this.A01 = new C1480dO(e12, str, z2, null);
        }
    }

    public C04483i(C1477dL c1477dL, US us, E1 e12, String str, Bundle bundle, Map<String, String> extraParams) {
        this(c1477dL, us, e12, str, 0, 0, false, bundle, extraParams);
    }

    @Override // com.instagram.common.viewpoint.core.C0686Dc
    public final void A0n(EnumC1484dS enumC1484dS, Map<String, String> map) {
        super.A0n(enumC1484dS, map);
        if (this.A01 != null && enumC1484dS == EnumC1484dS.A09) {
            Map<String, String> params = this.A01.A06();
            String[] strArr = A0F;
            if (strArr[0].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            A0F[2] = "tc9";
            map.putAll(params);
        }
    }

    public final void A0p() {
        C0698Do c0698Do = new C0698Do(this);
        if (this.A0C.A0t()) {
            XJ.A00(c0698Do);
            return;
        }
        E1 e12 = this.A0C;
        String[] strArr = A0F;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        A0F[1] = "nFCp2DExxe9bklz52WjNRol8ULAuMoj6";
        e12.getStateHandler().post(c0698Do);
    }
}
