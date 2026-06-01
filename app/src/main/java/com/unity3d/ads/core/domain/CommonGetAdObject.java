package com.unity3d.ads.core.domain;

import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.AdRepository;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonGetAdObject implements GetAdObject {
    private final AdRepository adRepository;

    public CommonGetAdObject(AdRepository adRepository) {
        k.e(adRepository, "adRepository");
        this.adRepository = adRepository;
    }

    @Override // com.unity3d.ads.core.domain.GetAdObject
    public AdObject invoke(String opportunityId) {
        k.e(opportunityId, "opportunityId");
        return this.adRepository.getAd(ByteStringsKt.toByteStringUtf8(opportunityId));
    }
}
