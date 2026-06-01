package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ql, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1029Ql {
    public C1026Qi A00 = new C1026Qi();
    public final InterfaceC1027Qj A01;

    public C1029Ql(InterfaceC1027Qj interfaceC1027Qj) {
        this.A01 = interfaceC1027Qj;
    }

    public final View A00(int i2, int i8, int i9, int i10) {
        int iA8Z = this.A01.A8Z();
        int next = this.A01.A8Y();
        int childEnd = i8 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i8) {
            View viewA79 = this.A01.A79(i2);
            int iA7C = this.A01.A7C(viewA79);
            int i11 = this.A01.A7B(viewA79);
            this.A00.A03(iA8Z, next, iA7C, i11);
            if (i9 != 0) {
                this.A00.A01();
                this.A00.A02(i9);
                if (this.A00.A04()) {
                    return viewA79;
                }
            }
            if (i10 != 0) {
                this.A00.A01();
                this.A00.A02(i10);
                if (this.A00.A04()) {
                    view = viewA79;
                }
            }
            i2 += childEnd;
        }
        return view;
    }
}
