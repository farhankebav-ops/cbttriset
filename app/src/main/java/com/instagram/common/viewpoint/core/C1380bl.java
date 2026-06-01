package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1380bl extends FrameLayout {
    public static byte[] A0L;
    public static String[] A0M = {"nL4f6tElOIWkWIMY", "pafc", "mmt", "r2KL", "cPD1EcNrMsc9Il", "HjHry0SxIHtlyHB0wW8GJ6CkWWRugdPq", "pjLQgfnHLp272wJByK44k5CENQyu64qM", "USuv5isgmNE5xLLzg"};
    public EnumC1493db A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final AbstractC1752hy A05;
    public final SF A06;
    public final C1477dL A07;
    public final C1120Ua A08;
    public final InterfaceC1208Xn A09;
    public final YY A0A;
    public final InterfaceC1379bk A0B;
    public final EG A0C;
    public final E1 A0D;
    public final C04483i A0E;
    public final DX A0F;
    public final DV A0G;
    public final DR A0H;
    public final DP A0I;
    public final DN A0J;
    public final DM A0K;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0L, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0M[0].length() != 16) {
                throw new RuntimeException();
            }
            A0M[0] = "7kRjpWt7kPSYf5Zn";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 13);
            i10++;
        }
    }

    public static void A0C() {
        A0L = new byte[]{-112, -94, -97, -97, -110, -101, -95, -127, -106, -102, -110, -81, -64, -67, -84, -65, -76, -70, -71, -20, -12, -13, -28, -29, -14, -29, -9, -11, -25, -26, -60, -5, -41, -11, -25, -12, -19, -17, -20, -28, -17, -30, -16, -16};
    }

    static {
        A0C();
    }

    public C1380bl(C1477dL c1477dL, US us, AbstractC1752hy abstractC1752hy, SF sf, C1120Ua c1120Ua, InterfaceC1208Xn interfaceC1208Xn, YY yy, InterfaceC1379bk interfaceC1379bk) {
        boolean z2;
        super(c1477dL);
        this.A0J = new DN() { // from class: com.facebook.ads.redexgen.X.5F
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i2, int i8, int i9) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
                for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
                    bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 124);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{53, 55, 42, 53, 38, 55, 42, 41};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
            public final void A03(DO r62) {
                this.A00.A03 = true;
                this.A00.A0B.AFh(A00(0, 8, 73), this.A00.A03());
            }
        };
        this.A0I = new DP() { // from class: com.facebook.ads.redexgen.X.5E
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i2, int i8, int i9) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
                for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
                    bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 106);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{112, 108, 97, 121};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
            public final void A03(DQ dq) {
                this.A00.A04 = true;
                this.A00.A0B.AFh(A00(0, 4, 106), this.A00.A03());
            }
        };
        this.A0H = new DR() { // from class: com.facebook.ads.redexgen.X.5B
            public static byte[] A01;
            public static String[] A02 = {"QUZtp6d2PVvxohxxHBY0lFVIZrOHPJmP", "NfxzKLWElZxETrhEeUBSDM4deWBqLSti", "M1wrkGT1p8fg9I16hadPO98y5LyXX3HA", "lshWtPbnAXBsXbgnJLDmxkjrZI", "6PixpSZW8UzyowqAm", "UIpIdTluG2bhvKFOHpQ9k0cfwSXrRmCx", "lSmcWeUXMp1pu4geeqYJMaSrMHF509BD", "gheUZ0KSYWPh4kTG81LfbEHF2a7TTHcT"};

            public static String A00(int i2, int i8, int i9) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
                int i10 = 0;
                while (true) {
                    int length = bArrCopyOfRange.length;
                    if (A02[6].charAt(28) != '0') {
                        throw new RuntimeException();
                    }
                    A02[6] = "QE45n4HEQOiTUZDVXPk8ylx4JLny0ok5";
                    if (i10 >= length) {
                        return new String(bArrCopyOfRange);
                    }
                    bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 111);
                    i10++;
                }
            }

            public static void A01() {
                A01 = new byte[]{59, 44, 64, 62, 48};
            }

            static {
                A01();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
            public final void A03(C3Y c3y) {
                this.A00.A0B.AFh(A00(0, 5, 92), this.A00.A03());
            }
        };
        this.A0K = new DM() { // from class: com.facebook.ads.redexgen.X.5A
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C3Q c3q) {
                this.A00.A0H(c3q);
                this.A00.A0A();
            }
        };
        this.A0F = new DX() { // from class: com.facebook.ads.redexgen.X.55
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i2, int i8, int i9) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
                for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
                    bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 95);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{107, 103, 101, 120, 100, 109, 124, 109, 108};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
            public final void A03(C04433d c04433d) {
                this.A00.A07();
                this.A00.A0B.AFh(A00(0, 9, 87), this.A00.A04(this.A00.A0D.getDuration()));
            }
        };
        this.A0G = new AnonymousClass54(this);
        this.A03 = false;
        this.A04 = false;
        this.A02 = false;
        this.A01 = false;
        this.A07 = c1477dL;
        this.A05 = abstractC1752hy;
        this.A06 = sf;
        this.A08 = c1120Ua;
        this.A09 = interfaceC1208Xn;
        this.A0A = yy;
        this.A0D = new E1(c1477dL);
        this.A0B = interfaceC1379bk;
        this.A0D.setFunnelLoggingHandler(c1120Ua);
        this.A0D.getEventBus().A03(this.A0J, this.A0I, this.A0H, this.A0K, this.A0F, this.A0G);
        this.A0E = new C04483i(c1477dL, us, this.A0D, abstractC1752hy.A25());
        if (U7.A1v(this.A07)) {
            z2 = true;
            this.A0C = new EG(c1477dL, us, this.A0D, abstractC1752hy.A25(), false, this.A0E, null);
        } else {
            z2 = true;
            this.A0C = null;
        }
        A0B();
        this.A0D.setVideoURI(this.A06.A0T(this.A05.A20().A0H().A09()));
        A09();
        XP.A0K(this, this.A05.A1z().A01().A08(z2));
        String videoUrl = abstractC1752hy.A20().A0H().A08();
        if (!TextUtils.isEmpty(videoUrl)) {
            AbstractC1298aR.A00(c1477dL, this, videoUrl);
        }
        addView(this.A0D, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject A03() {
        return A04(this.A0D.getCurrentPositionInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject A04(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A02(0, 11, 32), i2);
            jSONObject.put(A02(11, 8, 62), this.A0D.getDuration());
            jSONObject.put(A02(19, 5, 114), this.A0D.A0p());
            jSONObject.put(A02(24, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), this.A0D.A0r());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        if (this.A02) {
            return;
        }
        this.A02 = true;
    }

    private void A08() {
        this.A0D.postDelayed(new IF(this), U7.A0O(this.A07));
    }

    private void A09() {
        this.A0D.postDelayed(new IB(this), U7.A0P(this.A07));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        this.A0B.AFh(A02(36, 8, 112), A03());
    }

    private void A0B() {
        if (!TextUtils.isEmpty(this.A05.A20().A0H().A08())) {
            C04292p c04292p = new C04292p(this.A07);
            this.A0D.A0i(c04292p);
            c04292p.setImage(this.A05.A20().A0H().A08());
        }
        C2R c2r = new C2R(this.A07, true, this.A08);
        this.A0D.A0i(c2r);
        this.A0D.A0i(new D4(c2r, EnumC1508dr.A02, true));
        this.A0D.A0i(new C2Y(this.A07));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(C3Q c3q) {
        if (this.A0D.getState() == EnumC1547eU.A02 && U7.A1Z(this.A07)) {
            this.A0D.postDelayed(new I7(this, c3q), 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I(String str) {
        this.A07.A0F().A3S(str);
        if (U7.A1a(this.A07)) {
            A07();
        } else {
            this.A09.A4b(this.A0A.A7t());
            this.A09.A4b(this.A0A.A7o());
        }
    }

    public final void A0N() {
        this.A0D.setVolume(this.A05.A20().A0H().A0A() ? 0.0f : 1.0f);
        this.A0D.A0h(EnumC1493db.A02, 26);
        A08();
    }

    public final void A0O() {
        if (this.A0D != null) {
            if (!this.A02) {
                this.A0D.A0g(EnumC1485dT.A03);
            }
            this.A0D.getEventBus().A04(this.A0J, this.A0I, this.A0H, this.A0K, this.A0F, this.A0G);
            this.A0D.A0Z();
        }
        if (this.A0C != null) {
            this.A0C.A07();
        }
        this.A0E.A0p();
    }

    public final void A0P() {
        this.A0D.A0e(9);
        XP.A0R(this);
        XP.A0F(this.A0D);
        XP.A0Z(this.A0D);
    }

    public final void A0Q() {
        this.A0D.A0g(EnumC1485dT.A04);
    }

    public final void A0R(boolean z2) {
        if (z2) {
            this.A0D.setVolume(0.0f);
        } else {
            this.A0D.setVolume(1.0f);
        }
        A0A();
    }

    public final void A0S(boolean z2) {
        if (this.A0D.A0q()) {
            return;
        }
        this.A00 = this.A0D.getVideoStartReason();
        this.A01 = z2;
        this.A0D.A0l(false, 19);
    }

    public final void A0T(boolean z2) {
        if (this.A0D.A0r() || this.A02 || this.A0D.getState() == EnumC1547eU.A06 || this.A00 == null) {
            return;
        }
        if (!this.A01 || z2) {
            this.A0D.A0h(this.A00, 27);
        }
    }

    public final void A0U(boolean z2) {
        this.A0D.A0l(z2, 18);
    }

    public final void A0V(boolean z2) {
        this.A0D.A0h(EnumC1493db.A04, 25);
    }
}
