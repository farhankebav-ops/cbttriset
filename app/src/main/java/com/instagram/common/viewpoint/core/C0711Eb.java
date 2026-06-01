package com.instagram.common.viewpoint.core;

import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0711Eb extends QC<EZ> {
    public final int A00;
    public final C1477dL A01;
    public final KE A02;
    public final List<String> A03;

    public C0711Eb(C1477dL c1477dL, List<String> screenshotUrls, int i2, KE ke) {
        this.A03 = screenshotUrls;
        this.A00 = i2;
        this.A01 = c1477dL;
        this.A02 = ke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.QC
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final EZ A0F(ViewGroup viewGroup, int i2) {
        C0710Ea c0710Ea = new C0710Ea(this.A01);
        if (U7.A1C(this.A01)) {
            c0710Ea.setOnClickListener(new ViewOnClickListenerC1473dH(this));
        }
        return new EZ(c0710Ea);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.QC
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0K(EZ ez, int i2) {
        String str = this.A03.get(i2);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int startSpacing = this.A00 * 4;
        if (i2 != 0) {
            startSpacing = this.A00;
        }
        marginLayoutParams.setMargins(startSpacing, 0, i2 >= A0B() + (-1) ? this.A00 * 4 : this.A00, 0);
        ez.A0p().setLayoutParams(marginLayoutParams);
        ez.A0p().A00(str);
    }

    @Override // com.instagram.common.viewpoint.core.QC
    public final int A0B() {
        return this.A03.size();
    }
}
