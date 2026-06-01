package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonTokenNumberProvider$number$2 extends l implements e6.a {
    final /* synthetic */ SessionRepository $sessionRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTokenNumberProvider$number$2(SessionRepository sessionRepository) {
        super(0);
        this.$sessionRepository = sessionRepository;
    }

    @Override // e6.a
    public final Integer invoke() {
        return Integer.valueOf(this.$sessionRepository.getHeaderBiddingTokenCounter());
    }
}
