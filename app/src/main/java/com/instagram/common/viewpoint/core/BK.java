package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class BK implements InterfaceC1825jG {
    public final /* synthetic */ BZ A00;

    public BK(final BZ val$separatorMatcher) {
        this.A00 = val$separatorMatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.1o] */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1825jG
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C04041o AAc(final C1826jH splitter, final CharSequence toSplit) {
        return new BJ(splitter, toSplit) { // from class: com.facebook.ads.redexgen.X.1o
            @Override // com.instagram.common.viewpoint.core.BJ
            public final int A04(int separatorPosition) {
                return separatorPosition + 1;
            }

            @Override // com.instagram.common.viewpoint.core.BJ
            public final int A05(int start) {
                return this.A00.A00.A08(this.A03, start);
            }
        };
    }
}
