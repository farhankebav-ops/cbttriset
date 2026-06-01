package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0733Ex extends AbstractC1549eW {
    public final /* synthetic */ US A00;
    public final /* synthetic */ XH A01;
    public final /* synthetic */ C1444cn A02;
    public final /* synthetic */ C0731Ev A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public C0733Ex(C0731Ev c0731Ev, String str, C1444cn c1444cn, US us, Map map, XH xh) {
        this.A03 = c0731Ev;
        this.A04 = str;
        this.A02 = c1444cn;
        this.A00 = us;
        this.A05 = map;
        this.A01 = xh;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1549eW
    public final void A03() {
        if (!this.A03.A02.A0Z() && !TextUtils.isEmpty(this.A04) && !this.A03.A08.get(this.A02.A02())) {
            this.A00.AB5(this.A04, new C1262Zp(this.A05).A03(this.A03.A03).A02(this.A01).A05());
            N3.A07(this.A03.A00, this.A03.A09);
            this.A03.A08.put(this.A02.A02(), true);
        }
    }
}
