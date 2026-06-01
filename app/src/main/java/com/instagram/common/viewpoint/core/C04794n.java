package com.instagram.common.viewpoint.core;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.mlkit.common.MlKitException;
import com.ironsource.G9;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C04794n extends AbstractC0804Hr {
    public static byte[] A0b;
    public static String[] A0c = {"uwiFFMiPjkxeIpnCelDmRbiHk5Vwnfgt", "wLfFuslsjBH4uPGwj2Xycf6hIgRvR8Oe", "HvNwre", "LU1P5nNd", "IrSP0rhp", "3tH6XBAURu1AudBFEixfPGQY1Q", "mKjuxDaulnRYw", "yhw0zrPGEZfB7fyQoDKXN69L0o"};
    public static final int A0d;
    public static final int A0e;
    public static final int A0f;
    public static final int A0g;
    public static final int A0h;
    public static final int A0i;
    public static final int A0j;
    public static final int A0k;
    public static final int A0l;
    public static final int A0m;
    public static final int A0n;
    public static final int A0o;
    public static final int A0p;
    public static final int A0q;
    public float A00;
    public C0940My A01;
    public C1174Wd A02;
    public C1467dA A03;
    public EnumC1493db A04;
    public C0672Co A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final int A0A;
    public final int A0B;
    public final int A0C;
    public final int A0D;
    public final int A0E;
    public final Handler A0F;
    public final View A0G;
    public final C1477dL A0H;
    public final C1120Ua A0I;
    public final AbstractC1207Xm A0J;
    public final AbstractC1268Zv A0K;
    public final KE A0L;
    public final InterfaceC1424cT A0M;
    public final C1461d4 A0N;
    public final EG A0O;
    public final E1 A0P;
    public final C04483i A0Q;
    public final DX A0R;
    public final DV A0S;
    public final DR A0T;
    public final DP A0U;
    public final DN A0V;
    public final DM A0W;
    public final D9 A0X;
    public final C0680Cw A0Y;
    public final boolean A0Z;
    public final boolean A0a;

    public static String A0C(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0b, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 71);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0J() {
        A0b = new byte[]{82, 94, 92, 31, 87, 80, 82, 84, 83, 94, 94, 90, 31, 80, 85, 66, 31, 88, 95, 69, 84, 67, 66, 69, 88, 69, 88, 80, 93, 31, 82, 93, 88, 82, 90, 84, 85, 54, 33, 51, 37, 54, 32, 33, 32, 27, 50, 45, 32, 33, 43, 105, 118, 123, 122, 112};
    }

    static {
        A0J();
        A0k = (int) (AbstractC1180Wl.A02 * 48.0f);
        A0i = OP.A02(-1, 77);
        A0p = (int) (AbstractC1180Wl.A02 * 26.0f);
        A0q = (int) (AbstractC1180Wl.A02 * 12.0f);
        A0m = (int) (AbstractC1180Wl.A02 * 12.0f);
        A0n = (int) (AbstractC1180Wl.A02 * 44.0f);
        A0l = (int) (AbstractC1180Wl.A02 * 8.0f);
        A0o = (int) (AbstractC1180Wl.A02 * 16.0f);
        A0j = OP.A02(A0i, 90);
        A0h = (int) (AbstractC1180Wl.A02 * 4.0f);
        A0g = (int) (AbstractC1180Wl.A03 * 32.0f);
        A0d = (int) (AbstractC1180Wl.A02 * 12.0f);
        A0e = (int) (AbstractC1180Wl.A02 * 16.0f);
        A0f = (int) (AbstractC1180Wl.A02 * 48.0f);
    }

    public C04794n(C1477dL c1477dL, US us, AbstractC1752hy abstractC1752hy, SF sf, YY yy, int i2, InterfaceC1208Xn interfaceC1208Xn, C1120Ua c1120Ua, AbstractC1207Xm abstractC1207Xm, int i8, int customVideoDurationMs, int i9, boolean z2, int i10, boolean z7, boolean z8, boolean z9, InterfaceC1424cT interfaceC1424cT, int i11, int i12) {
        C0940My c0940MyA00;
        super(c1477dL, yy, us, abstractC1752hy, i2, z8, z9, interfaceC1208Xn, i12);
        this.A0F = new Handler(Looper.getMainLooper());
        this.A00 = 0.0f;
        this.A06 = false;
        this.A07 = false;
        this.A09 = false;
        this.A0V = new DN() { // from class: com.facebook.ads.redexgen.X.4y
            public static String[] A01 = {"7gUYNYKFrrI6cUcpcHgvAqL4Gs6ZbmaO", "eulXJJXioKb3UmnXwerKdv", "DeECHluE8BU5loeJcqNW1HYG1mHcuBH8", "x81kE4wfDh8vlLxHq80CctXU2mbMn00Z", "zBHmazzeC9pHgiKU9uedQ6l4AdxQz", "WRgOWCAEbqLirqS5ZGHJuFqEkTHfhP5W", "572CNMLKJv9WD0LgrUqd1zfS4LkJfaLe", "B1saI0DOHUkU6pw"};

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(DO r11) {
                this.A00.A09 = true;
                if (this.A00.getAdDataBundle().A1U()) {
                    this.A00.A0H.A0F().AJw(AbstractC1171Wa.A00((float) ((AbstractC0804Hr) this.A00).A06.A0h()), this.A00.getResources().getConfiguration().orientation, true, true, MH.A0C(MI.A00(this.A00.A0H, ((AbstractC0804Hr) this.A00).A08, "", WQ.A00(((AbstractC0804Hr) this.A00).A06.A20().A0J().A05()), new HashMap(), ((AbstractC0804Hr) this.A00).A06.A21())));
                    this.A00.A0L(this.A00.getResources().getConfiguration().orientation);
                    this.A00.A0K.setVisibility(0);
                    if (this.A00.A0K instanceof KL) {
                        ((KL) this.A00.A0K).A0q(this.A00.getResources().getConfiguration().orientation);
                    }
                }
                if (this.A00.getAdDataBundle().A1W()) {
                    C04794n c04794n = this.A00;
                    if (A01[7].length() != 15) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[2] = "UfF1b519MGYLAJGTcPK3SRNJ7v4WOh3N";
                    strArr[0] = "9iqifXeSGzjDh5N7cdDazqMOJ7agOy96";
                    c04794n.A0Y.setOnClickListener(this.A00.A0L);
                }
            }
        };
        this.A0U = new DP() { // from class: com.facebook.ads.redexgen.X.4x
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(DQ dq) {
                if (!((AbstractC0804Hr) this.A00).A0A.A07()) {
                    this.A00.A1C();
                }
            }
        };
        this.A0T = new DR() { // from class: com.facebook.ads.redexgen.X.4s
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            public final /* bridge */ /* synthetic */ void A03(C1098Td c1098Td) {
            }
        };
        this.A0W = new DM() { // from class: com.facebook.ads.redexgen.X.4r
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C3Q c3q) {
                this.A00.A0Q(c3q);
                this.A00.A0M.ADI((this.A00.A00 * this.A00.A0P.getDuration()) + c3q.A00());
            }
        };
        this.A0R = new DX() { // from class: com.facebook.ads.redexgen.X.4q
            public static String[] A01 = {"wKs2F0CoKZ83CrYftessGgwUooVDkZ8i", "2Ibb583RxwN39nWjhOn5WWPQj1VmynHE", "A0Qs557f", "DKPVxx7rRSfdfe4bDqdhQ5dEhLiH9LON", "bebhf1UP90kEJwgsUj64UnMMPskca", "Y97MwE7h44FvVbPafIuJT7XHPF7ToAyu", "yGLwGxqGR6Hkk5b2IyfusTMojDv2e", "vJPYkkaf"};

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C04433d c04433d) {
                this.A00.A0M.ACy(this.A00.A0P.getDuration());
                if (this.A00.A00 < ((AbstractC0804Hr) this.A00).A06.A20().A0G()) {
                    C04794n.A01(this.A00, 1.0f);
                    this.A00.A0P.A0h(EnumC1493db.A02, 28);
                    return;
                }
                C04794n c04794n = this.A00;
                String[] strArr = A01;
                if (strArr[3].charAt(6) != strArr[5].charAt(6)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[0] = "gUju5w26hU6oOlSn7mf4ATVXJhH4p8zJ";
                strArr2[1] = "33WeYKtkMTovDIRRTCZ4bD6vTYI44Qru";
                if (!c04794n.A1I()) {
                    this.A00.A0M.ACZ();
                } else {
                    this.A00.A1D();
                }
            }
        };
        this.A0S = new C04814p(this);
        this.A0H = c1477dL;
        this.A0I = c1120Ua;
        this.A0J = abstractC1207Xm;
        this.A0E = i11;
        int i13 = -1;
        if (!super.A06.A1U()) {
            this.A0G = new D1(this.A0H, c1120Ua);
        } else {
            i13 = i11;
            this.A0G = new D0(this.A0H, c1120Ua);
        }
        this.A0Y = new C0680Cw(this.A0H, i13);
        if (this.A00 < abstractC1752hy.A20().A0G()) {
            this.A0Y.setShouldClearAnimationWhenVideoCompleted(false);
        }
        this.A0C = i10;
        this.A0a = z7;
        this.A0B = i8;
        this.A0D = customVideoDurationMs;
        this.A0M = interfaceC1424cT;
        this.A0A = i9;
        this.A0Z = z2;
        this.A0N = new C1461d4(this.A0H, us, super.A06);
        if (customVideoDurationMs == 1) {
            c0940MyA00 = super.A06.A1z().A01();
        } else {
            c0940MyA00 = super.A06.A1z().A00();
        }
        this.A01 = c0940MyA00;
        this.A0P = new E1(this.A0H);
        this.A0P.getEventBus().A03(this.A0V, this.A0U, this.A0T, this.A0W, this.A0R, this.A0S);
        this.A0Q = new C04483i(c1477dL, us, this.A0P, abstractC1752hy.A25(), 0, 0, abstractC1752hy.A20().A0U(), null, null);
        A0I();
        this.A0P.setVideoURI(sf.A0T(super.A06.A20().A0H().A09()));
        A0H();
        C1175Wg c1175WgA02 = super.A09.A02(abstractC1752hy);
        this.A0H.A0H().A00(c1175WgA02.A01);
        this.A0K = A06();
        if (this.A0K instanceof C0863Jy) {
            new CU(this.A0K, 400, 100, 0).A42(true, false);
        } else {
            this.A0K.setVisibility(8);
        }
        this.A0X = new D9(true, abstractC1752hy.A20().A0U());
        A0K();
        this.A0L = this.A0K.getCTAButton();
        if (c1175WgA02.A00) {
            this.A0P.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.c5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A1L(view);
                }
            });
        }
        XP.A0E(1001, this.A0L);
        A0G();
        if (!getAdDataBundle().A1U()) {
            A0F();
        }
        this.A0K.bringToFront();
        if (U7.A1u(this.A0H)) {
            this.A0H.A0B().AK2(this.A0P, super.A06.A25(), true);
        }
        if (U7.A1v(this.A0H)) {
            this.A0O = new EG(this.A0H, us, this.A0P, super.A06.A25(), abstractC1752hy.A20().A0U(), this.A0Q, null);
        } else {
            this.A0O = null;
        }
    }

    public static /* synthetic */ float A01(C04794n c04794n, float f4) {
        float f8 = c04794n.A00 + f4;
        c04794n.A00 = f8;
        return f8;
    }

    private AbstractC1268Zv A06() {
        String strA0C;
        AbstractC1268Zv c0863Jy;
        RelativeLayout.LayoutParams adDetailsParams = new RelativeLayout.LayoutParams(-1, -2);
        adDetailsParams.addRule(12);
        if (super.A06.A0v().equals(A0C(37, 14, 3))) {
            strA0C = EnumC1499dh.A04.A03();
        } else {
            strA0C = A0C(0, 37, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
        }
        double dA0h = super.A06.A0h();
        if (getAdDataBundle().A1U()) {
            if (E1.A0T((float) dA0h)) {
                c0863Jy = new C05085q(this.A0H, this.A0L, AbstractC0804Hr.A0G, false, getColors(), strA0C, super.A08, super.A0B, super.A0D, super.A0A, super.A06, this.A0Y, this.A0I, false);
            } else {
                if (A0c[1].charAt(3) != 'F') {
                    throw new RuntimeException();
                }
                String[] strArr = A0c;
                strArr[5] = "xymrPLzTH8UHDAaiBZe05WSUA2";
                strArr[7] = "XCaDYNVy2gwp6c65cWzWipC7tC";
                if (E1.A0V((float) dA0h)) {
                    c0863Jy = new C05075p(this.A0H, this.A0L, AbstractC0804Hr.A0G, false, getColors(), strA0C, super.A08, super.A0B, super.A0D, super.A0A, super.A06, this.A0Y, this.A0I, false);
                } else {
                    c0863Jy = new C05095r(this.A0H, this.A0L, AbstractC0804Hr.A0G, false, getColors(), strA0C, super.A08, super.A0B, super.A0D, super.A0A, super.A06, this.A0Y, this.A0I, false);
                }
            }
            ((KL) c0863Jy).setChainedAdInfo(super.A00);
        } else {
            c0863Jy = new C0863Jy(this.A0H, null, A0k, super.A06.A20().A0I().A00() == EnumC0936Mu.A05, getColors(), super.A06.A20().A0J().A06(), strA0C, super.A08, super.A0B, super.A0D, super.A0A, super.A06);
        }
        c0863Jy.getCTAButton().getCtaActionHelper().A08(super.A06);
        c0863Jy.getCTAButton().setCreativeAsCtaLoggingHelper(super.A09);
        XP.A0E(1008, c0863Jy);
        c0863Jy.A0h(this.A0D);
        addView(c0863Jy, adDetailsParams);
        c0863Jy.setInfo(super.A06.A20().A0I(), super.A06.A20().A0J(), super.A06.A25(), super.A06.A23().A01(), null, null);
        return c0863Jy;
    }

    private void A0D() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (this.A03 != null) {
            C1467dA c1467dA = this.A03;
            if (A0c[6].length() != 13) {
                throw new RuntimeException();
            }
            A0c[0] = "pczVUfQTZlSxQoKEEMr5D2oLadoOsoUQ";
            c1467dA.A0a(false);
            addView(this.A03.A0T(), layoutParams);
        }
    }

    private void A0E() {
        if (getAdDataBundle().A20().A0K().A03() && !getAdDataBundle().A20().A0K().A02().isEmpty()) {
            XP.A0Z(this.A0K, this.A0G, this.A0L);
            this.A03 = new C1467dA(this.A0H, getAdDataBundle(), super.A0B, this.A0L, this.A0F, this.A0I);
            A0D();
        } else {
            if (getAdDataBundle().A20().A0K().A04() || getAdDataBundle().A20().A0K().A03()) {
                XP.A0Z(this.A0K, this.A0G, this.A0L);
                C1327au c1327au = new C1327au(this.A0H, super.A06, this.A0I, this.A0F, super.A0B);
                c1327au.A0D(false);
                addView(c1327au.A09(this.A0L));
                return;
            }
            Pair<EnumC1460d3, View> pairA03 = this.A0N.A03(this.A0L);
            View endCardView = (View) pairA03.second;
            XP.A0E(1101, endCardView);
            A0P((EnumC1460d3) pairA03.first, endCardView);
        }
    }

    private void A0F() {
        this.A0Y.A08(-1, A0i, false);
        this.A0Y.setPadding(A0q, A0q, A0q, A0q);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0p);
        layoutParams.addRule(12);
        addView(this.A0Y, layoutParams);
    }

    private void A0G() {
        RelativeLayout.LayoutParams layoutParams;
        if (!super.A06.A1U()) {
            this.A0G.setPadding(A0m, A0m, A0m, A0m);
            layoutParams = new RelativeLayout.LayoutParams(A0n, A0n);
            layoutParams.setMargins(0, AbstractC1207Xm.A00, A0l, 0);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(A0g, A0g);
            layoutParams.setMargins(A0e, A0f, A0e, A0d);
            layoutParams.addRule(9);
        }
        ViewGroup.LayoutParams videoViewParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.A0P, videoViewParams);
        addView(this.A0G, layoutParams);
    }

    private void A0H() {
        postDelayed(new HL(this), U7.A0P(this.A0H));
    }

    private void A0I() {
        this.A0P.A0i(this.A0Y);
        if (this.A0G instanceof InterfaceC1494dc) {
            this.A0P.A0i((InterfaceC1494dc) this.A0G);
        }
        if (!TextUtils.isEmpty(super.A06.A20().A0H().A08())) {
            C04292p c04292p = new C04292p(this.A0H);
            this.A0P.A0i(c04292p);
            c04292p.setImage(super.A06.A20().A0H().A08());
        }
        this.A0P.A0i(new C2Y(this.A0H));
    }

    private final void A0K() {
        View expandableLayout = this.A0K.getExpandableLayout();
        if (expandableLayout != null) {
            if (this.A05 != null) {
                D9 d9 = this.A0X;
                C0672Co c0672Co = this.A05;
                String[] strArr = A0c;
                if (strArr[5].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                A0c[1] = "yPUFQNIw4jpGFPLG5nXj9YsdQuCVJrWl";
                d9.A0L(c0672Co);
            }
            C0940My c0940MyA01 = super.A06.A1z().A01();
            this.A0X.A0L(new CY(this.A0K.getCTAButton(), MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, -1, c0940MyA01.A0A(true)));
            Drawable drawableA08 = XP.A08(A0i, A0j, A0h);
            Drawable endDrawable = XP.A05(c0940MyA01.A09(true), A0h);
            this.A0X.A0L(new C0673Cp(this.A0K.getCTAButton(), MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, drawableA08, endDrawable));
            this.A0X.A0L(new CZ(expandableLayout, 150, false));
            this.A0X.AAm(this.A0P);
            this.A0X.A0K(G9.b.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L(int i2) {
        if (!getAdDataBundle().A1U()) {
            return;
        }
        this.A0H.A0F().AJy(i2);
        this.A0P.A0c(i2);
        A0M(i2, this.A0P, (RelativeLayout) this.A0P.getVideoView());
    }

    private final void A0M(int i2, ViewGroup viewGroup, RelativeLayout relativeLayout) {
        if (this.A0K instanceof KL) {
            boolean z2 = this.A0K instanceof C05095r;
            if (A0c[0].charAt(8) == 'J') {
                throw new RuntimeException();
            }
            String[] strArr = A0c;
            strArr[5] = "oeSYnKfd6qg69aJdYBhoeO0UNx";
            strArr[7] = "WvPjUISg3i5kB9lwMl0NPsGMqU";
            if (z2 || (this.A0K instanceof C05085q)) {
                XP.A0H(this.A0K);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                if (getResources().getConfiguration().orientation == 2) {
                    layoutParams.addRule(1, relativeLayout.getId());
                    this.A0K.setLayoutParams(layoutParams);
                    viewGroup.addView(this.A0K);
                } else {
                    addView(this.A0K, layoutParams);
                }
            }
            this.A0K.A0h(i2);
            ((KL) this.A0K).A0s(viewGroup, relativeLayout, i2);
        }
    }

    private void A0P(EnumC1460d3 enumC1460d3, View view) {
        this.A0P.A0k(false);
        this.A0P.setVisibility(8);
        switch (C1402c7.A00[enumC1460d3.ordinal()]) {
            case 1:
                this.A0K.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, AbstractC1207Xm.A00, 0, 0);
                layoutParams.addRule(2, this.A0K.getId());
                addView(view, layoutParams);
                break;
            case 2:
                XP.A0Z(this.A0K);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.setMargins(A0o, A0o, A0o, A0o);
                addView(view, layoutParams2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0Q(C3Q c3q) {
        if (this.A0P.getState() == EnumC1547eU.A02 && U7.A1Z(this.A0H)) {
            postDelayed(new HJ(this, c3q), 5000L);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final ME A1A(String str) {
        return this.A0L.A0E(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1B() {
        super.A1B();
        if (this.A02 != null) {
            C1174Wd c1174Wd = this.A02;
            String[] strArr = A0c;
            if (strArr[4].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0c;
            strArr2[4] = "vVds5dTr";
            strArr2[3] = "mwltsewL";
            c1174Wd.A06();
        }
        this.A0F.removeCallbacksAndMessages(null);
        if (U7.A1u(this.A0H)) {
            this.A0H.A0B().AJj(this.A0P);
        }
        if (this.A0O != null) {
            this.A0O.A07();
        }
        if (this.A0P != null) {
            this.A0P.getEventBus().A04(this.A0V, this.A0U, this.A0T, this.A0W, this.A0R, this.A0S);
            XP.A0F(this.A0P);
            this.A0P.A0Z();
        }
        this.A0Q.A0p();
        XP.A0Z(this.A0P, this.A0Y, this.A0G);
        super.A0D.A0V();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1D() {
        this.A0H.A0F().A4p();
        this.A06 = true;
        XP.A0R(this);
        XP.A0F(this.A0P);
        XP.A0Z(this.A0P, this.A0Y, this.A0G);
        A0E();
        if (this.A0A != 0 || !this.A0Z) {
            this.A0M.AFE(true);
            if (this.A0J != null && getAdDataBundle().A20().A0K().A00() > 0) {
                this.A07 = false;
                if (getAdDataBundle().A2G()) {
                    this.A0J.setToolbarActionMode(8);
                } else {
                    this.A0J.setToolbarActionMode(2);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1401c6(this), getAdDataBundle().A20().A0K().A00());
                return;
            }
            this.A07 = true;
            return;
        }
        if (this.A0a) {
            this.A0M.AJr();
        }
        if (this.A0J != null) {
            this.A0J.setToolbarActionMode(getAdDataBundle().A2G() ? 8 : 2);
        }
        this.A02 = new C1174Wd(this.A0C, 100.0f, 100L, new Handler(Looper.getMainLooper()), new HP(this));
        this.A02.A07();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1E() {
        E1 e12 = this.A0P;
        int secondsForNextCta = super.A06.A20().A0H().A0A() ? 0 : 1065353216;
        e12.setVolume(secondsForNextCta);
        this.A0P.A0h(EnumC1493db.A02, 20);
        int iA02 = super.A06.A20().A0H().A02();
        if (iA02 >= 0) {
            this.A0J.setProgressSpinnerInvisible(true);
        }
        if (iA02 != 0) {
            int secondsForNextCta2 = this.A0E;
            if (iA02 < secondsForNextCta2) {
                if (iA02 > 0) {
                    new C1174Wd(iA02, new HM(this)).A07();
                    return;
                }
                return;
            }
        }
        AbstractC1207Xm abstractC1207Xm = this.A0J;
        if (A0c[6].length() != 13) {
            throw new RuntimeException();
        }
        A0c[6] = "z6ph3MLFkPTln";
        abstractC1207Xm.setToolbarActionMode(8);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1G(boolean z2) {
        if (this.A02 != null) {
            this.A02.A06();
        }
        if (this.A0P.A0q()) {
            return;
        }
        this.A04 = this.A0P.getVideoStartReason();
        this.A08 = z2;
        this.A0P.A0l(false, 13);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1H(boolean z2) {
        if (this.A02 != null && !this.A02.A05()) {
            this.A02.A07();
        }
        if (this.A06 || this.A0P.getState() == EnumC1547eU.A06 || this.A04 == null) {
            return;
        }
        if (!this.A08 || z2) {
            this.A0P.A0h(this.A04, 19);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final boolean A1I() {
        return (this.A0A == 2 || !super.A06.A20().A0V() || this.A06) ? false : true;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final boolean A1J() {
        return this.A06;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final boolean A1K() {
        return this.A07;
    }

    public final /* synthetic */ void A1L(View view) {
        this.A0L.A0E(A0C(51, 5, 88));
    }

    public C0940My getColors() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public C1422cR getFullScreenAdStyle() {
        return new C1422cR(true, C1422cR.A06, super.A06.A1z().A01(), KE.A05(super.A06), super.A06.A1z().A01().A08(true), super.A06.A20().A0H().A08());
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public XH getTouchDataRecorder() {
        return super.A0A;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        C0940My c0940MyA00;
        super.onConfigurationChanged(configuration);
        if (!this.A06) {
            if (getAdDataBundle().A1U()) {
                A0L(configuration.orientation);
                return;
            }
            if (configuration.orientation == 1) {
                C0928Ml c0928MlA1z = super.A06.A1z();
                String[] strArr = A0c;
                if (strArr[4].length() != strArr[3].length()) {
                    throw new RuntimeException();
                }
                A0c[1] = "ZWQFADQdeKHmDIXasxpY6pydlWSUwrFV";
                c0940MyA00 = c0928MlA1z.A01();
            } else {
                c0940MyA00 = super.A06.A1z().A00();
            }
            this.A01 = c0940MyA00;
            this.A0L.setViewShowsOverMedia(true);
            this.A0L.setUpButtonColors(this.A01);
            this.A0K.A0h(configuration.orientation);
            return;
        }
        if (this.A03 == null) {
            return;
        }
        this.A03.A0W(configuration.orientation);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        View expandableLayout;
        super.onLayout(z2, i2, i8, i9, i10);
        if (!getAdDataBundle().A1U() && (expandableLayout = this.A0K.getExpandableLayout()) != null && z2 && this.A05 == null) {
            this.A05 = new C0672Co(expandableLayout, MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, expandableLayout.getHeight(), 0);
            this.A0X.A0L(this.A05);
            this.A0X.A0J();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            A1H(false);
        } else {
            A1G(false);
        }
    }
}
