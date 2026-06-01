package com.instagram.common.viewpoint.core;

import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1278a6 {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.0g] */
    public static C03700g A00(final C1315ai c1315ai, final C1020Qc c1020Qc, final String str, final C05105s c05105s) {
        final boolean z2 = true;
        return new C04995h(c1315ai, c1020Qc, z2, str, c05105s) { // from class: com.facebook.ads.redexgen.X.0g
            public KE A00;
            public C1444cn A01;
            public final US A02 = this.A0I.A06().A02().A0A();
            public final C1020Qc A03;
            public final C05105s A04;
            public final String A05;
            public static String[] A06 = {"q", "A73Xi2G3GXsP7eqOYxzIEC2a49UqAHwv", "tzkKnItTrh", "5yGem34VUXIU78ICazF0QaKYuuceWMlm", "d26mhKEOwDnFCjn", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "vFFUszWLQFPwstqQ2PhnuKwIvdRc", "cQLhl1S6XoLnT945hQssVDVRJiee0FVC"};
            public static final int A08 = (int) (AbstractC1180Wl.A02 * (-4.0f));
            public static final int A07 = (int) (AbstractC1180Wl.A02 * 6.0f);

            {
                this.A03 = c1020Qc;
                this.A05 = str;
                this.A04 = c05105s;
                this.A03.A1L(this);
            }

            @Override // com.instagram.common.viewpoint.core.AbstractC0830Ir
            public void setupNativeCtaExtension(C1444cn c1444cn) {
                N3 n3A21;
                this.A01 = c1444cn;
                int iA0Q = U7.A0Q(this.A0I.A06());
                C0940My c0940MyA01 = this.A03.A10().A1z().A01();
                C1477dL c1477dLA06 = this.A0I.A06();
                String strA0r = this.A03.A10().A0r();
                US us = this.A02;
                InterfaceC1208Xn dummyListener = C1249Zc.getDummyListener();
                C1550eX c1550eXA0b = this.A04.A0b();
                XH xhA1A = this.A03.A1A();
                if (this.A03.A10() == null) {
                    n3A21 = null;
                } else {
                    n3A21 = this.A03.A10().A21();
                }
                this.A00 = new KE(c1477dLA06, strA0r, c0940MyA01, us, dummyListener, c1550eXA0b, xhA1A, n3A21);
                this.A00.setCta(c1444cn.A03().A0J(), this.A05, new HashMap());
                this.A03.A1L(this.A00);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (iA0Q == 1) {
                    layoutParams.addRule(12);
                    String[] strArr = A06;
                    String str2 = strArr[5];
                    String str3 = strArr[0];
                    int length = str2.length();
                    int extensionVariant = str3.length();
                    if (length != extensionVariant) {
                        throw new RuntimeException();
                    }
                    A06[4] = "cEnNLXyXCc05OsZ";
                    XP.A0N(this.A00, A07, 5, c0940MyA01.A0A(false));
                    ((C04995h) this).A06.addView(this.A00, layoutParams);
                    return;
                }
                if (iA0Q == 2) {
                    layoutParams.addRule(3, ((C04995h) this).A06.getId());
                    int extensionVariant2 = A08;
                    layoutParams.setMargins(0, extensionVariant2, 0, 0);
                    addView(this.A00, 0, layoutParams);
                    ((C04995h) this).A06.bringToFront();
                }
            }
        };
    }
}
