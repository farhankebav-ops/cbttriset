package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonTokenNumberProvider implements TokenNumberProvider {
    private final f number$delegate;

    public CommonTokenNumberProvider(SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        this.number$delegate = b.C(new CommonTokenNumberProvider$number$2(sessionRepository));
    }

    private final int getNumber() {
        return ((Number) this.number$delegate.getValue()).intValue();
    }

    @Override // com.unity3d.ads.core.domain.TokenNumberProvider
    public int invoke() {
        return getNumber();
    }
}
