package com.instagram.common.viewpoint.core;

import com.facebook.ads.Ad;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAdListener;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1685gm implements SN {
    public int A00 = -1;
    public long A01 = -1;
    public AdExperienceType A02;
    public RewardData A03;
    public RewardedVideoAdListener A04;
    public String A05;
    public String A06;
    public String A07;
    public boolean A08;
    public Ad A09;
    public WeakReference<Ad> A0A;
    public final C1477dL A0B;
    public final TL A0C;
    public final String A0D;

    public C1685gm(C1477dL c1477dL, String str, Ad ad, TL tl) {
        this.A0B = c1477dL;
        this.A0D = str;
        this.A09 = ad;
        this.A0A = new WeakReference<>(ad);
        this.A0C = tl;
        c1477dL.A0N(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.SN
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final RewardedVideoAdListener A6g() {
        return this.A04;
    }

    public final C1477dL A01() {
        return this.A0B;
    }

    public final void A02(Ad ad) {
        if (ad == null && !U7.A0u(this.A0B)) {
            return;
        }
        this.A09 = ad;
    }

    @Override // com.instagram.common.viewpoint.core.SN
    public final Ad A6c() {
        return this.A09 != null ? this.A09 : this.A0A.get();
    }
}
