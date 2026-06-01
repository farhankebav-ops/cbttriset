package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1641g1 extends AbstractC0973Oh {
    public final AbstractC0973Oh A00 = new C1642g2(this);
    public final C05246g A01;

    public C1641g1(C05246g c05246g) {
        this.A01 = c05246g;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0973Oh
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(C05246g.class.getName());
        if ((view instanceof C05246g) && !A0B()) {
            C05246g c05246g = (C05246g) view;
            if (c05246g.getLayoutManager() != null) {
                c05246g.getLayoutManager().A1v(accessibilityEvent);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0973Oh
    public final void A08(View view, PS ps) {
        super.A08(view, ps);
        ps.A0O(C05246g.class.getName());
        if (!A0B() && this.A01.getLayoutManager() != null) {
            this.A01.getLayoutManager().A1H(ps);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0973Oh
    public final boolean A09(View view, int i2, Bundle bundle) {
        if (super.A09(view, i2, bundle)) {
            return true;
        }
        if (!A0B() && this.A01.getLayoutManager() != null) {
            return this.A01.getLayoutManager().A1X(i2, bundle);
        }
        return false;
    }

    public final AbstractC0973Oh A0A() {
        return this.A00;
    }

    public final boolean A0B() {
        return this.A01.A1r();
    }
}
