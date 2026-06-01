package com.instagram.common.viewpoint.core;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1446cp extends FrameLayout {
    public static final int A08 = (int) (AbstractC1180Wl.A02 * 16.0f);
    public C05165y A00;
    public EG A01;
    public C04483i A02;
    public D1 A03;
    public C04292p A04;
    public C2R A05;
    public final C1477dL A06;
    public final C1120Ua A07;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 12 out of bounds for length 12
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A04(US us, String str, Map<String, String> map) {
        A02();
        this.A02 = new C04483i(this.A06, us, this.A00, str, null, map);
        if (U7.A1v(this.A06)) {
            this.A01 = new EG(this.A06, us, this.A00, str, false, this.A02, map);
        } else {
            this.A01 = null;
        }
    }

    public C1446cp(C1477dL c1477dL, C1120Ua c1120Ua) {
        super(c1477dL);
        this.A07 = c1120Ua;
        this.A06 = c1477dL;
        setUpView(c1477dL);
    }

    public final void A01() {
        A0l(true, 10);
    }

    public final void A02() {
        if (this.A01 != null) {
            this.A01.A07();
            this.A01 = null;
        }
        if (this.A02 != null) {
            this.A02.A0p();
            this.A02 = null;
        }
    }

    public final void A03(AbstractC1100Tf abstractC1100Tf) {
        getEventBus().A05(abstractC1100Tf);
    }

    public final void A05(EnumC1493db enumC1493db) {
        A0h(enumC1493db, 13);
    }

    public final boolean A06() {
        return A0s();
    }

    public E1 getSimpleVideoView() {
        return this.A00;
    }

    public float getVolume() {
        return getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.A04.setImage(str);
    }

    private void setUpPlugins(C1477dL c1477dL) {
        A0b();
        this.A04 = new C04292p(c1477dL);
        A0i(this.A04);
        this.A03 = new D1(c1477dL, this.A07);
        A0i(new C3D(c1477dL));
        A0i(this.A03);
        this.A05 = new C2R(c1477dL, true, this.A07);
        A0i(this.A05);
        A0i(new D4(this.A05, EnumC1508dr.A02, true, true));
        if (!A0n()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(A08, A08, A08, A08);
        this.A03.setLayoutParams(layoutParams);
        addView(this.A03);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.5y] */
    private void setUpVideo(final C1477dL c1477dL) {
        this.A00 = new E1(c1477dL) { // from class: com.facebook.ads.redexgen.X.5y
            @Override // android.widget.RelativeLayout, android.view.View
            public final void onMeasure(int i2, int i8) {
                int newWidthSpec = View.MeasureSpec.getMode(i2);
                if (newWidthSpec == 1073741824) {
                    i8 = i2;
                } else {
                    int newWidthSpec2 = View.MeasureSpec.getMode(i8);
                    if (newWidthSpec2 == 1073741824) {
                        i2 = i8;
                    }
                }
                super.onMeasure(i2, i8);
            }
        };
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        XP.A0I(this.A00);
        addView(this.A00);
        setOnClickListener(new ViewOnClickListenerC1445co(this));
    }

    private void setUpView(C1477dL c1477dL) {
        setUpVideo(c1477dL);
        setUpPlugins(c1477dL);
    }

    public void setVideoURI(String str) {
        setVideoURI(str);
    }

    public void setVolume(float f4) {
        setVolume(f4);
        this.A03.A09();
    }
}
