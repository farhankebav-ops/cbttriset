package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5G, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5G extends FrameLayout implements I3 {
    public static byte[] A0A;
    public static String[] A0B = {"cNW8ZlUzhquZSz6XSi", "gKIjGDOIeaOzZR9qeyStr8duZ", "mQKfIuNnQZgt5ES8sx19fjwTYxycx0Lp", "WvoZHe7VElSdYX15O8PPMcOC5YskUK4l", "BfRVnLJiFu3hDnD", "WxgvJAZOXh", "crPtNK55mSnLeOXFeJGYeBq3ABMrpYK", "K6RBlZSEjGoukPcRXJY4znE0whNpCjIj"};
    public C1550eX A00;
    public final int A01;
    public final AbstractC1752hy A02;
    public final C1477dL A03;
    public final US A04;
    public final XH A05;
    public final InterfaceC1377bi A06;
    public final C1388bt A07;
    public final String A08;
    public final boolean A09;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{100, 70, 73, 0, 83, 7, 84, 83, 70, 85, 83, 7, 102, 82, 67, 78, 66, 73, 68, 66, 105, 66, 83, 80, 72, 85, 76, 102, 68, 83, 78, 81, 78, 83, 94, 9, 7, 106, 70, 76, 66, 7, 84, 82, 85, 66, 7, 83, 79, 70, 83, 7, 78, 83, 0, 84, 7, 78, 73, 7, 94, 72, 82, 85, 7, 102, 73, 67, 85, 72, 78, 67, 106, 70, 73, 78, 65, 66, 84, 83, 9, 95, 74, 75, 7, 65, 78, 75, 66, 9, 24, 28, 31, 43, 58, 55, 59, 48, 61, 59, 16, 59, 42, 41, 49, 44, 53, 69, 74, 123, 69, 71, 80, 77, 82, 77, 80, 93, 4, 11, 14, 4, 12, 56, 20, 8, 18, 21, 4, 2, 90, 85, 64, 93, 66, 81, 117, 80, 112, 85, 64, 85, 118, 65, 90, 80, 88, 81, 27, 29, 11, 28, 13, 2, 7, 13, 5, 22, 9, 5, 23, 52, 25, 16, 5};
    }

    static {
        A02();
    }

    public C5G(C1477dL c1477dL, US us, InterfaceC1377bi interfaceC1377bi, AbstractC1752hy abstractC1752hy, String str, int i2, XH xh) {
        super(c1477dL);
        this.A03 = c1477dL;
        this.A04 = us;
        this.A02 = abstractC1752hy;
        this.A08 = str;
        this.A06 = interfaceC1377bi;
        this.A01 = i2;
        C1388bt preloadedDynamicWebViewController = AbstractC1389bu.A02(abstractC1752hy.A17());
        if (preloadedDynamicWebViewController != null) {
            this.A07 = preloadedDynamicWebViewController;
            this.A09 = true;
        } else {
            this.A07 = new C1388bt(this.A03, abstractC1752hy, us, i2);
            AbstractC1389bu.A03(abstractC1752hy, this.A07);
            this.A09 = false;
        }
        if (xh != null) {
            this.A05 = xh;
            this.A07.A0Z(xh);
        } else {
            this.A05 = this.A07.A0L();
        }
        this.A07.A0c(new IT(this));
        this.A07.A0a(interfaceC1377bi);
        EnumC1185Wq.A04(this, EnumC1185Wq.A0B);
        if (U7.A1u(c1477dL)) {
            c1477dL.A0B().AK4(this.A07.A0O(), abstractC1752hy.A25(), false, false, true);
        }
        A04();
    }

    private final void A03() {
        this.A07.A0d(this);
        if (!this.A09) {
            this.A03.A0F().A5y();
            this.A07.A0X();
        } else {
            this.A03.A0F().A5z();
            if (this.A07.A0k()) {
                if (this.A01 == 4) {
                    if (this.A06 != null) {
                        this.A06.AD8(this);
                    }
                    if (U7.A1u(this.A03)) {
                        InterfaceC1124Ue interfaceC1124UeA0B = this.A03.A0B();
                        if (A0B[1].length() != 25) {
                            throw new RuntimeException();
                        }
                        A0B[5] = "";
                        interfaceC1124UeA0B.ACx();
                    }
                } else {
                    AJS();
                }
            }
        }
        A08();
    }

    private final void A04() {
        C1388bt.A0B().incrementAndGet();
        A03();
        this.A07.A0W();
    }

    private void A05(Intent intent, AbstractC1752hy abstractC1752hy) {
        intent.putExtra(A01(157, 8, 110), EnumC1147Vb.A07);
        intent.putExtra(A01(Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 18, 58), abstractC1752hy);
        intent.addFlags(268435456);
    }

    private final void A06(AbstractC1752hy abstractC1752hy) {
        AdActivityIntent adActivityIntentA05 = WB.A05(this.A03);
        A05(adActivityIntentA05, abstractC1752hy);
        try {
            WB.A0B(this.A03, adActivityIntentA05);
        } catch (Exception e) {
            this.A03.A08().AAy(A01(107, 11, 42), AbstractC1090Sv.A0D, new C1091Sw(e));
            Log.e(A01(90, 17, 80), A01(0, 90, 41), e);
        }
    }

    private void A07(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a5 a5Var = new a5(this.A03, this.A08, this.A00, this.A05, this.A04, this.A02.A21());
        HashMap map = new HashMap();
        map.put(A01(Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 12, 105), A01(148, 9, 96));
        a5Var.A05(this.A02.A25(), str, map);
    }

    public final void A08() {
        XP.A0H(this.A07.A0O());
        addView(this.A07.A0O(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void A9X() {
        A07(this.A02.A20().A0J().A05());
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void A9Y(String str) {
        A07(str);
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void A9c() {
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AAd() {
        new Handler(Looper.getMainLooper()).post(new IH(this));
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void ADM() {
        A06(this.A02);
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void ADQ() {
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AEF(boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AFG() {
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AFn(boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AFp(boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AG4(String str) {
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AJS() {
        if (this.A06 != null) {
            this.A06.AD8(this);
        }
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void close() {
    }

    public US getAdEventManager() {
        return this.A04;
    }

    public C1388bt getDynamicWebViewController() {
        return this.A07;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setAdViewabilityChecker(C1550eX c1550eX) {
        this.A00 = c1550eX;
        this.A07.A0e(c1550eX);
    }
}
