package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.26, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass26 extends AbstractC0983Or<C1550eX> implements SM {
    public C1477dL A00;
    public boolean A01;

    public AnonymousClass26(C1550eX c1550eX, C1477dL c1477dL) {
        super(c1550eX);
        this.A00 = c1477dL;
        this.A01 = false;
    }

    private void A00(int i2) {
        if (!this.A01) {
            this.A00.A0F().A3n(i2);
        }
        this.A01 = true;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        C1550eX c1550eXA08 = A08();
        int iIntValue = 0;
        if (c1550eXA08 == null) {
            A00(0);
            return;
        }
        View view = c1550eXA08.A0C;
        AbstractC1549eW abstractC1549eW = (AbstractC1549eW) c1550eXA08.A0E.get();
        int i2 = 1;
        boolean z2 = view == null;
        if (!z2 && abstractC1549eW != null) {
            C1551eY c1551eYA0E = C1550eX.A0E(view, c1550eXA08.A0A, this.A00);
            if (c1551eYA0E.A04()) {
                C1550eX.A05(c1550eXA08);
            } else {
                c1550eXA08.A00 = 0;
            }
            boolean z7 = c1550eXA08.A00 > c1550eXA08.A09;
            boolean wasViewable = c1550eXA08.A05 != null && c1550eXA08.A05.A04();
            if (z7 || !c1551eYA0E.A04()) {
                c1550eXA08.A05 = c1551eYA0E;
            }
            String strValueOf = String.valueOf(c1551eYA0E.A01());
            synchronized (c1550eXA08) {
                if (c1550eXA08.A06.containsKey(strValueOf)) {
                    iIntValue = ((Integer) c1550eXA08.A06.get(strValueOf)).intValue();
                }
                c1550eXA08.A06.put(strValueOf, Integer.valueOf(iIntValue + 1));
            }
            if (z7 && !wasViewable) {
                this.A01 = true;
                c1550eXA08.A03 = System.currentTimeMillis();
                if (c1550eXA08.A07) {
                    this.A00.A0F().A3o();
                }
                abstractC1549eW.A03();
                if (BuildConfigApi.isDebug() && AdInternalSettings.isVisibleAnimation()) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(500L);
                    view.startAnimation(alphaAnimation);
                }
                if (!c1550eXA08.A0F) {
                    return;
                }
            } else if (!z7 && wasViewable) {
                this.A01 = true;
                if (c1550eXA08.A07) {
                    this.A00.A0F().A3K(c1551eYA0E.A02());
                }
                abstractC1549eW.A00();
            } else {
                abstractC1549eW.A02();
                if (!this.A01 && c1550eXA08.A07) {
                    this.A00.A0F().A3m(c1551eYA0E.A02());
                }
                this.A01 = true;
            }
            if (!c1550eXA08.A08 && c1550eXA08.A04 != null) {
                c1550eXA08.A0B.postDelayed(c1550eXA08.A04, c1550eXA08.A02);
                return;
            }
            return;
        }
        if (c1550eXA08.A07) {
            if (!z2) {
                i2 = 2;
            }
            A00(i2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.SM
    public final C1477dL A6e() {
        return this.A00;
    }
}
