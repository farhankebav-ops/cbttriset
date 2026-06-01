package com.instagram.common.viewpoint.core;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1504dm extends AbstractRunnableC1164Vt {
    public static String[] A05 = {"peP5GJDM9me8QDpiMTE0HYbhk5UQvsuj", "UmJsGkUZcFFvxG21gGzKuNxtLbnsNH0B", "InCZKAYVJ2xyVT3RLHGk", "cxu83bHx4KSubY78z6WW", "55WyHuuOCemh1dLUozRA9kNqY", "hUMsj3tCoCX6inz1bILbzXUTN", "Ib1pT8H4oQaxudtz", "STVRCs5pIYaR1pHj"};
    public final /* synthetic */ S7 A00;
    public final /* synthetic */ S8 A01;
    public final /* synthetic */ SF A02;
    public final /* synthetic */ ArrayList A03;
    public final /* synthetic */ ArrayList A04;

    public C1504dm(SF sf, ArrayList arrayList, S8 s8, S7 s7, ArrayList arrayList2) {
        this.A02 = sf;
        this.A03 = arrayList;
        this.A01 = s8;
        this.A00 = s7;
        this.A04 = arrayList2;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        AtomicBoolean atomicBooleanA0D = SF.A0D(this.A03);
        if (this.A02.A04 instanceof C1477dL) {
            C1477dL c1477dL = (C1477dL) this.A02.A04;
            if (this.A01.A00 == -1) {
                boolean z2 = atomicBooleanA0D.get();
                String[] strArr = A05;
                if (strArr[6].length() == strArr[7].length()) {
                    String[] strArr2 = A05;
                    strArr2[3] = "VVOoEaVD2AhQqE2eihnl";
                    strArr2[2] = "7KTPepw5ZZxiUEMCto3C";
                    if (z2) {
                        c1477dL.A0F().A4h(XG.A01(this.A02.A00));
                    } else {
                        c1477dL.A0F().A4f(XG.A01(this.A02.A00));
                    }
                }
                throw new RuntimeException();
            }
            if (atomicBooleanA0D.get()) {
                LH lhA0F = c1477dL.A0F();
                long jA01 = XG.A01(this.A02.A00);
                S8 s8 = this.A01;
                String[] strArr3 = A05;
                if (strArr3[4].length() == strArr3[5].length()) {
                    String[] strArr4 = A05;
                    strArr4[4] = "xsAs6ZK2AKeTr6tr707KlGvOM";
                    strArr4[5] = "GxI5mwrGpMJ9ldsuxbhmmAcT7";
                    lhA0F.A4i(jA01, s8.A00);
                }
                throw new RuntimeException();
            }
            c1477dL.A0F().A4g(XG.A01(this.A02.A00), this.A01.A00);
        }
        this.A02.A02.post(new C1505dn(this, atomicBooleanA0D));
        SF.A0D(this.A04);
    }
}
