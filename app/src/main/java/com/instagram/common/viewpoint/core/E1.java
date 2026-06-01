package com.instagram.common.viewpoint.core;

import android.animation.AnimatorSet;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class E1 extends RelativeLayout implements InterfaceC1548eV, InterfaceC1482dQ {
    public static byte[] A0F;
    public static String[] A0G = {"3L6CoO6YtrcW", "MjcsiBOYcGfrGyZBxeZgAjKXsDYhFJK", "NbVxNqWnj3", "Ob7MM92eIAC3XgmL", "XSQst8sM3v9Waw60ED5t21eOsn1IQUtw", "wvdS5a619fbySZdqvbmzcB7w", "WLvo7626w9dzVwCTBg7InBeeg1a7HKE3", "kYDrs41aRZaYTR0SA8npQuCfjZz7Tio6"};
    public static final DW A0H;
    public static final DQ A0I;
    public static final DO A0J;
    public static final DJ A0K;
    public static final DI A0L;
    public static final DF A0M;
    public static final DD A0N;
    public static final DC A0O;
    public float A00;
    public int A01;
    public C1120Ua A02;
    public C1490dY A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final Handler A08;
    public final Handler A09;
    public final View.OnTouchListener A0A;
    public final C1477dL A0B;
    public final C1099Te<AbstractC1100Tf, C1098Td> A0C;
    public final List<InterfaceC1494dc> A0D;
    public final InterfaceC1545eS A0E;

    public static String A0G(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0G;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[6] = "HxnswxUpcuHv1wuLD4berTHtADZcXTin";
            strArr2[4] = "I3xDTi7RY5fAtwEllKfD6KKH3DCBcY9z";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 57);
            i10++;
        }
    }

    public static void A0J() {
        A0F = new byte[]{93, -80, -94, -96, 93, -79, -84, -79, -98, -87, 93, -76, -98, -79, -96, -91, 93, -79, -90, -86, -94, 125, -81, -84, -84, -97, -88, -82, -90, -77, 90, -101, -82, 90};
    }

    static {
        A0J();
        A0J = new DO();
        A0H = new DW();
        A0K = new DJ();
        A0L = new DI();
        A0I = new DQ();
        A0M = new DF();
        A0O = new DC();
        A0N = new DD();
    }

    public E1(C1477dL c1477dL) {
        super(c1477dL);
        this.A0D = new ArrayList();
        this.A08 = new Handler();
        this.A09 = new Handler();
        this.A0C = new C1099Te<>();
        this.A06 = true;
        this.A01 = 200;
        this.A00 = 1.0f;
        this.A0A = new ViewOnTouchListenerC1481dP(this);
        this.A0B = c1477dL;
        if (A0W(c1477dL)) {
            this.A0E = new CM(c1477dL);
        } else {
            this.A0E = new CJ(c1477dL);
        }
        A0H();
    }

    public E1(C1477dL c1477dL, AttributeSet attributeSet) {
        super(c1477dL, attributeSet);
        this.A0D = new ArrayList();
        this.A08 = new Handler();
        this.A09 = new Handler();
        this.A0C = new C1099Te<>();
        this.A06 = true;
        this.A01 = 200;
        this.A00 = 1.0f;
        this.A0A = new ViewOnTouchListenerC1481dP(this);
        this.A0B = c1477dL;
        if (A0W(c1477dL)) {
            this.A0E = new CM(c1477dL, attributeSet);
        } else {
            this.A0E = new CJ(c1477dL, attributeSet);
        }
        A0H();
    }

    public E1(C1477dL c1477dL, AttributeSet attributeSet, int i2) {
        super(c1477dL, attributeSet, i2);
        this.A0D = new ArrayList();
        this.A08 = new Handler();
        this.A09 = new Handler();
        this.A0C = new C1099Te<>();
        this.A06 = true;
        this.A01 = 200;
        this.A00 = 1.0f;
        this.A0A = new ViewOnTouchListenerC1481dP(this);
        this.A0B = c1477dL;
        if (A0W(c1477dL)) {
            this.A0E = new CM(c1477dL, attributeSet, i2);
        } else {
            this.A0E = new CJ(c1477dL, attributeSet, i2);
        }
        A0H();
    }

    private float A06(InterfaceC1545eS interfaceC1545eS) {
        int videoHeight = interfaceC1545eS.getVideoHeight();
        if (videoHeight == 0) {
            return 1.0f;
        }
        int height = interfaceC1545eS.getVideoWidth();
        return height / videoHeight;
    }

    public static /* synthetic */ DJ A0E() {
        DJ dj = A0K;
        if (A0G[7].charAt(27) == '4') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[5] = "Ykw7x5qbt5Y8x48JghoZKWeO";
        strArr[0] = "cKnPTPxPmv7r";
        return dj;
    }

    private void A0H() {
        this.A07 = U7.A0t(this.A0B);
        this.A0B.A0F().A3V();
        this.A0E.setRequestedVolume(1.0f);
        this.A0E.setVideoStateChangeListener(this);
        this.A03 = new C1490dY(this.A0B, this.A0E);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        XP.A0I(this.A03);
        addView(this.A03, layoutParams);
        setOnTouchListener(this.A0A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I() {
        this.A08.postDelayed(new EF(this), this.A01);
    }

    private final void A0K() {
        for (InterfaceC1494dc interfaceC1494dc : this.A0D) {
            boolean z2 = interfaceC1494dc instanceof AbstractC0684Da;
            String[] strArr = A0G;
            if (strArr[6].charAt(13) != strArr[4].charAt(13)) {
                throw new RuntimeException();
            }
            A0G[3] = "f6iKlyOeYddBSkQQnaXOCc7KzH8j";
            if (z2) {
                A0R((AbstractC0684Da) interfaceC1494dc);
            }
            interfaceC1494dc.AAm(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L(int i2) {
        if (U7.A10(this.A0B)) {
            Toast.makeText(this.A0B, A0G(21, 13, 1) + (i2 / 1000.0f) + A0G(0, 21, 4), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(UZ uz) {
        if (this.A02 == null) {
            return;
        }
        this.A02.A04(uz, null);
    }

    private void A0Q(InterfaceC1494dc interfaceC1494dc) {
        if (interfaceC1494dc instanceof AbstractC0684Da) {
            A0S((AbstractC0684Da) interfaceC1494dc);
        }
        interfaceC1494dc.AJk(this);
    }

    private void A0R(AbstractC0684Da abstractC0684Da) {
        if (abstractC0684Da.getParent() == null) {
            if (abstractC0684Da instanceof C04292p) {
                this.A03.A02(abstractC0684Da);
            } else {
                addView(abstractC0684Da);
            }
        }
    }

    private void A0S(AbstractC0684Da abstractC0684Da) {
        if (abstractC0684Da instanceof C04292p) {
            this.A03.A03(abstractC0684Da);
        } else {
            XP.A0H(abstractC0684Da);
        }
    }

    public static boolean A0T(float f4) {
        return f4 <= 0.7f;
    }

    public static boolean A0U(float f4) {
        return f4 == 1.0f;
    }

    public static boolean A0V(float f4) {
        return f4 >= 1.2f;
    }

    private boolean A0W(C1477dL c1477dL) {
        return U7.A2t(c1477dL, C1532eF.A03());
    }

    public final void A0Z() {
        this.A0E.setVideoStateChangeListener(null);
        this.A0E.destroy();
    }

    public final void A0a() {
        if (A0q()) {
            return;
        }
        this.A0E.A9V();
    }

    public final void A0b() {
        Iterator<InterfaceC1494dc> it = this.A0D.iterator();
        while (it.hasNext()) {
            A0Q(it.next());
        }
        this.A0D.clear();
    }

    public final void A0c(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A03.getLayoutParams();
        layoutParams.removeRule(13);
        layoutParams.removeRule(10);
        layoutParams.removeRule(9);
        if (this.A00 == 1.0f) {
            this.A00 = A06(this.A0E);
        }
        if (i2 == 1) {
            layoutParams.addRule(10);
        } else if (A0V(this.A00)) {
            layoutParams.addRule(13);
        } else {
            layoutParams.addRule(9);
        }
        C1490dY c1490dY = this.A03;
        if (A0G[3].length() == 1) {
            throw new RuntimeException();
        }
        A0G[7] = "Fk13SNDKaQVX0dV87s1e6TAwbDOb9nQX";
        c1490dY.setLayoutParams(layoutParams);
    }

    public final void A0d(int i2) {
        this.A08.removeCallbacksAndMessages(null);
        this.A0E.seekTo(i2);
    }

    public final void A0e(int i2) {
        this.A0E.AJU(i2);
    }

    public final void A0f(AnimatorSet animatorSet, boolean z2) {
        this.A03.A01(animatorSet, z2);
    }

    public final void A0g(EnumC1485dT enumC1485dT) {
        E8 e8 = new E8(this);
        if (this.A07) {
            XJ.A00(e8);
        } else {
            this.A09.post(e8);
        }
        this.A0E.AJH(enumC1485dT.A03());
    }

    public final void A0h(EnumC1493db enumC1493db, int i2) {
        if (this.A04 && this.A0E.getState() == EnumC1547eU.A06) {
            this.A04 = false;
        }
        this.A0E.AJM(enumC1493db, i2);
        if (A0G[7].charAt(27) == '4') {
            throw new RuntimeException();
        }
        A0G[3] = "hMpnI8E";
    }

    public final void A0i(InterfaceC1494dc interfaceC1494dc) {
        this.A0D.add(interfaceC1494dc);
    }

    public final void A0j(InterfaceC1494dc interfaceC1494dc) {
        this.A0D.remove(interfaceC1494dc);
        A0Q(interfaceC1494dc);
    }

    public final void A0k(boolean z2) {
        A0l(z2, 0);
    }

    public final void A0l(boolean z2, int i2) {
        if (A0q()) {
            return;
        }
        this.A0E.AG7(z2, i2);
    }

    public final void A0m(boolean z2, boolean z7, int i2) {
        this.A06 = z7;
        A0l(z2, i2);
    }

    public final boolean A0n() {
        return this.A0E.A9i();
    }

    public final boolean A0o() {
        return this.A0E.A9j();
    }

    public final boolean A0p() {
        return getVolume() == 0.0f;
    }

    public final boolean A0q() {
        return getState() == EnumC1547eU.A05;
    }

    public final boolean A0r() {
        return A0q() && this.A0E.AAT();
    }

    public final boolean A0s() {
        return getState() == EnumC1547eU.A0A;
    }

    public final boolean A0t() {
        return this.A07;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1482dQ
    public final boolean AAH() {
        return A0W(this.A0B);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1482dQ
    public final boolean AAM() {
        return this.A05;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1548eV
    public final void ADK(final long j, final long j3, final long j8, final float f4) {
        if (!U7.A1v(this.A0B)) {
            return;
        }
        this.A0C.A02(new DZ(j, j3, j8, f4) { // from class: com.facebook.ads.redexgen.X.3Z
        });
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1548eV
    public final void AE9() {
        A0l(true, 4);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1548eV
    public final void AEA() {
        A0h(EnumC1493db.A04, 6);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1548eV
    public final void AF9(int i2, int i8) {
        EB eb = new EB(this, i2, i8);
        if (this.A07) {
            XJ.A00(eb);
        } else {
            this.A09.post(eb);
        }
        A0I();
        if (A0G[3].length() == 1) {
            throw new RuntimeException();
        }
        A0G[7] = "9p5A7Zams3NJ3CBp1FBA5yfXzv5AdeGa";
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1548eV
    public final void AFt(EnumC1547eU enumC1547eU) {
        int currentPositionInMillis = getCurrentPositionInMillis();
        int currentPositionMS = getDuration();
        ED ed = new ED(this, enumC1547eU, currentPositionInMillis, currentPositionMS);
        if (this.A07) {
            XJ.A00(ed);
        } else {
            this.A09.post(ed);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1482dQ
    public int getCurrentPositionInMillis() {
        return this.A0E.getCurrentPosition();
    }

    public int getDuration() {
        return this.A0E.getDuration();
    }

    public C1099Te<AbstractC1100Tf, C1098Td> getEventBus() {
        return this.A0C;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1482dQ
    public long getInitialBufferTime() {
        return this.A0E.getInitialBufferTime();
    }

    public List<InterfaceC1494dc> getPlugins() {
        return this.A0D;
    }

    public EnumC1547eU getState() {
        return this.A0E.getState();
    }

    public Handler getStateHandler() {
        return this.A09;
    }

    public TextureView getTextureView() {
        return (TextureView) this.A0E;
    }

    public int getVideoHeight() {
        return this.A0E.getVideoHeight();
    }

    public View getVideoImplView() {
        return this.A0E.getView();
    }

    public int getVideoProgressReportIntervalMs() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1482dQ
    public EnumC1493db getVideoStartReason() {
        return this.A0E.getStartReason();
    }

    public View getVideoView() {
        return this.A03;
    }

    public int getVideoWidth() {
        return this.A0E.getVideoWidth();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1482dQ
    public float getVolume() {
        return this.A0E.getVolume();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.A0C.A02(A0N);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.A0C.A02(A0O);
        super.onDetachedFromWindow();
    }

    public void setControlsAnchorView(View view) {
        if (this.A0E != null) {
            this.A0E.setControlsAnchorView(view);
        }
    }

    public void setFunnelLoggingHandler(C1120Ua c1120Ua) {
        this.A02 = c1120Ua;
    }

    public void setIsFullScreen(boolean z2) {
        this.A05 = z2;
        this.A0E.setFullScreen(z2);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setRoundedCornerVideoView(float f4) {
        this.A03.setRoundedCornersVideoStyle(f4);
    }

    public void setVideoMPD(String str) {
        this.A0E.setVideoMPD(str);
    }

    public void setVideoProgressReportIntervalMs(int i2) {
        this.A01 = i2;
    }

    public void setVideoURI(Uri uri) {
        if (uri == null) {
            A0b();
        } else {
            A0K();
            if (A0G[2].length() != 10) {
                throw new RuntimeException();
            }
            A0G[2] = "2vtziZXFfU";
            this.A0E.setup(uri);
        }
        this.A04 = false;
    }

    public void setVideoURI(String str) {
        this.A0B.A0F().A3c(str);
        setVideoURI(str != null ? WQ.A00(str) : null);
    }

    public void setVolume(float f4) {
        if (f4 == 1.0f) {
            A0M(UZ.A0n);
            this.A0B.A0F().A3g();
        } else {
            A0M(UZ.A0m);
            this.A0B.A0F().A3f();
        }
        this.A0E.setRequestedVolume(f4);
        getEventBus().A02(A0M);
    }
}
