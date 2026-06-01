package com.instagram.common.viewpoint.core;

import android.text.Layout;
import java.util.Comparator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class JC {
    public static final Comparator<JC> A02 = new Comparator() { // from class: com.facebook.ads.redexgen.X.JB
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((JC) obj2).A00, ((JC) obj).A00);
        }
    };
    public final int A00;
    public final C2105o2 A01;

    public JC(CharSequence charSequence, Layout.Alignment alignment, float f4, int i2, int i8, float f8, int i9, float f9, boolean z2, int i10, int i11) {
        C3C cueBuilder = new C3C().A0G(charSequence).A0F(alignment).A07(f4, i2).A09(i8).A04(f8).A0A(i9).A06(f9);
        if (z2) {
            cueBuilder.A0C(i10);
        }
        this.A01 = cueBuilder.A0H();
        this.A00 = i11;
    }
}
