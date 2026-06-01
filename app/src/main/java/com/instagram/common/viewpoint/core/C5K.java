package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5K extends FrameLayout implements InterfaceC1209Xo, I3 {
    public static byte[] A0I;
    public static String[] A0J = {"UTx0mthy689a2sWy4JVu0tmbo5tf7DAX", "DpQrJfF4GGVCKG366ycalUQvQmaAeTpv", "eTaJ9UlZkoiVo78onrsfkh8qyWU6l07Y", "ASk", "tRl9yBUHWghtVC3MTlEkON1DGIMHt5L9", "IjjI8eijgHBxehc5IxL2bCSmbEZHlZYm", "ajbOHBl4KDnxYMWXO0J67", "uiq3lL8JcMvDgND3txStxUQziaPHduab"};
    public R0 A00;
    public R6 A01;
    public InterfaceC1395c0 A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final AbstractC1752hy A06;
    public final C1477dL A07;
    public final US A08;
    public final C1120Ua A09;
    public final XC A0A;
    public final XH A0B;
    public final InterfaceC1208Xn A0C;
    public final YY A0D;
    public final C1380bl A0E;
    public final C1388bt A0F;
    public final AbstractC1549eW A0G;
    public final C1550eX A0H;

    public static String A0B(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0I = new byte[]{24, 47, 47, 50, 47, 125, 62, 47, 56, 60, 41, 52, 51, 58, 125, 62, 50, 51, 59, 52, 58, 125, 23, 14, 18, 19, 78, 69, 76, 68, 67, 72, 73, 114, 76, 73, 36, 47, 38, 46, 41, 34, 35, 24, 38, 35, 24, 46, 41, 35, 34, 63, 46, 37, 44, 36, 35, 40, 41, 18, 44, 41, 18, 57, 34, 57, 44, 33, 91, 80, 89, 81, 86, 93, 92, 103, 76, 81, 85, 93, 103, 75, 72, 93, 86, 76, 35, 44, 41, 35, 43, 31, 51, 47, 53, 50, 35, 37, 74, 76, 90, 77, 92, 83, 86, 92, 84};
    }

    static {
        A0D();
    }

    public C5K(C1477dL c1477dL, US us, InterfaceC1208Xn interfaceC1208Xn, AbstractC1752hy abstractC1752hy, YY yy, int i2) {
        super(c1477dL);
        this.A01 = new C0821Ii(this);
        this.A0G = new C0820Ih(this);
        this.A03 = true;
        this.A07 = c1477dL;
        this.A08 = us;
        this.A0C = interfaceC1208Xn;
        this.A06 = abstractC1752hy;
        this.A0D = yy;
        C1388bt c1388btA02 = AbstractC1389bu.A02(abstractC1752hy.A17());
        if (c1388btA02 == null) {
            this.A0F = new C1388bt(this.A07, abstractC1752hy, us, i2);
            this.A04 = false;
        } else {
            this.A0F = c1388btA02;
            this.A04 = true;
        }
        this.A09 = this.A0F.A0K();
        this.A0B = this.A0F.A0L();
        this.A0F.A0c(new C0816Id(this));
        XP.A0E(1003, this.A0F.A0O());
        if (this.A06.A1P()) {
            this.A0E = new C1380bl(this.A07, this.A08, this.A06, new SF(this.A07), this.A09, this.A0C, this.A0D, new C0814Ib(this));
            this.A0E.A0N();
            this.A0F.A0O().setOnTouchListener(new ViewOnTouchListenerC1376bh(this));
            addView(this.A0E, new FrameLayout.LayoutParams(-1, -1));
        } else {
            this.A0E = null;
        }
        ViewGroup mediaView = getMediaView();
        this.A0H = new C1550eX(mediaView, 1, new WeakReference(this.A0G), this.A07);
        this.A0H.A0W(this.A06.A0i());
        this.A0H.A0X(this.A06.A0j());
        this.A0F.A0e(this.A0H);
        this.A0A = new XC(this);
        this.A0A.A05(XB.A02);
        setBackgroundColor(0);
        if (U7.A1u(c1477dL)) {
            c1477dL.A0B().AK4(mediaView, abstractC1752hy.A25(), false, false, true);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            boolean zA2C = abstractC1752hy.A2C();
            String strA0B = A0B(68, 18, 20);
            String strA0B2 = A0B(36, 16, 107);
            String strA0B3 = A0B(52, 16, 97);
            String strA0B4 = A0B(26, 10, 1);
            if (zA2C) {
                jSONObject.put(strA0B4, true);
                jSONObject.put(strA0B3, 2);
                jSONObject.put(strA0B2, 0);
                jSONObject.put(strA0B, this.A06.A0o());
            } else if (WR.A05(abstractC1752hy.A0u())) {
                jSONObject.put(strA0B4, true);
                jSONObject.put(strA0B3, 2);
                jSONObject.put(strA0B2, 1);
                jSONObject.put(strA0B, this.A06.A0o());
            }
            this.A0F.A0j(jSONObject);
        } catch (JSONException unused) {
            this.A0F.A0M().A04(AbstractC1090Sv.A15, A0B(0, 26, 113));
        }
    }

    private void A0C() {
        C1428cX c1428cXA0F = new C1426cV(this.A07, this.A06.A20().A0I(), this.A06.A23()).A0A(this.A06.A1z().A01()).A0F();
        addView(c1428cXA0F, new FrameLayout.LayoutParams(-1, -1));
        c1428cXA0F.A04(new IW(this));
    }

    private final void A0E() {
        this.A0F.A0d(this);
        if (!this.A04) {
            this.A07.A0F().A5y();
            this.A0F.A0X();
        } else {
            this.A07.A0F().A5z();
            if (this.A0F.A0k()) {
                AJS();
                if (U7.A1u(this.A07)) {
                    this.A07.A0B().ACx();
                }
            }
        }
        ViewGroup viewGroup = (ViewGroup) this.A0F.A0O().getParent();
        if (viewGroup != null) {
            C1388bt c1388bt = this.A0F;
            String[] strArr = A0J;
            if (strArr[0].charAt(1) != strArr[2].charAt(1)) {
                throw new RuntimeException();
            }
            A0J[6] = "m5i7x933C7hHEFpC39NkE";
            ViewGroup parent = c1388bt.A0O();
            viewGroup.removeView(parent);
        }
        addView(this.A0F.A0O(), new FrameLayout.LayoutParams(-1, -1));
        this.A0C.A3x(this, new RelativeLayout.LayoutParams(-1, -1));
        if (this.A06.A1Q()) {
            this.A0A.A05(XB.A03);
        }
    }

    private void A0F(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a5 a5Var = new a5(this.A07, this.A0D.A7E(), this.A0H, this.A0B, this.A08, this.A06.A21(), this.A0C);
        HashMap map = new HashMap();
        map.put(A0B(86, 12, 108), A0B(98, 9, 19));
        a5Var.A05(this.A06.A25(), str, map);
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void A9X() {
        A0F(this.A06.A20().A0J().A05());
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void A9Y(String str) {
        A0F(str);
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void A9c() {
        this.A0C.A4b(this.A0D.A6d());
        C1474dI serverSideRewardHandler = new C1474dI(this.A07, this.A0D, this.A06.A1A(), this.A0C);
        serverSideRewardHandler.A05();
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AAd() {
        new Handler(Looper.getMainLooper()).post(new C0813Ia(this));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AAl(Intent intent, Bundle bundle, R0 r02) {
        C1388bt.A0B().incrementAndGet();
        r02.A0A(this.A01);
        this.A00 = r02;
        A0E();
        if (this.A06.A20().A0W()) {
            A0C();
        } else {
            this.A0F.A0W();
        }
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void ADM() {
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void ADQ() {
        if (this.A0E != null) {
            this.A0E.A0P();
        }
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AEF(boolean z2) {
        if (this.A0E != null) {
            this.A0E.A0R(z2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AEV(boolean z2) {
        if (this.A0E != null) {
            this.A0E.A0S(z2);
        }
        if (z2) {
            this.A0F.A0Q();
        } else {
            this.A0F.A0T();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AF0(boolean z2) {
        if (this.A0E != null) {
            this.A0E.A0T(z2);
        }
        if (this.A03) {
            this.A03 = false;
        } else if (z2) {
            this.A0F.A0P();
        } else {
            this.A0F.A0Y();
        }
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AFG() {
        if (this.A0E != null) {
            this.A0E.A0Q();
        }
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AFn(boolean z2) {
        if (this.A0E != null) {
            this.A0E.A0U(z2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AFp(boolean z2) {
        if (this.A0E != null) {
            this.A0E.A0V(z2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AG4(String str) {
        String urlString = this.A06.A26(str);
        if (urlString == null) {
            return;
        }
        WN.A0O(new WN(), this.A07, WQ.A00(urlString), this.A06.A25());
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AIB(Bundle bundle) {
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void AJS() {
        if (!this.A05) {
            this.A0H.A0U();
            this.A05 = true;
        }
    }

    @Override // com.instagram.common.viewpoint.core.I3
    public final void close() {
        if (this.A00 == null) {
            return;
        }
        this.A00.finish(4);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public String getCurrentClientToken() {
        return this.A06.A25();
    }

    private ViewGroup getMediaView() {
        if (this.A0E != null) {
            return this.A0E;
        }
        return this.A0F.A0O();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final boolean onActivityResult(int i2, int i8, Intent intent) {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void onDestroy() {
        if (U7.A1u(this.A07)) {
            this.A07.A0B().AJj(getMediaView());
        }
        C1380bl c1380bl = this.A0E;
        String[] strArr = A0J;
        if (strArr[4].charAt(27) != strArr[5].charAt(27)) {
            throw new RuntimeException();
        }
        A0J[6] = "GZe1biqFkGajjfTMFdC84";
        if (c1380bl != null) {
            this.A0E.A0O();
        }
        this.A0A.A03();
        this.A08.AAt(this.A06.A25(), new C1262Zp().A02(this.A0B).A03(this.A0H).A05());
        this.A01 = null;
        this.A02 = null;
        this.A00 = null;
        AbstractC1389bu.A04(this.A06.A17());
        C1388bt.A0B().decrementAndGet();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(InterfaceC1208Xn interfaceC1208Xn) {
    }

    public void setRtfActionsJavascriptListener(InterfaceC1395c0 interfaceC1395c0) {
        this.A02 = interfaceC1395c0;
    }
}
