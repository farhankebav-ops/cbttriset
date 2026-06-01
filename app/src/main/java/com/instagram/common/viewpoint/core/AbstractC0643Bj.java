package com.instagram.common.viewpoint.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0643Bj implements InterfaceC1598fK {
    public final EnumC1590fC A00;
    public final AbstractC04151z A01;

    public AbstractC0643Bj(AbstractC04151z abstractC04151z, EnumC1590fC enumC1590fC) {
        this.A01 = abstractC04151z;
        this.A00 = enumC1590fC;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1598fK
    public void A45(Map<InterfaceC1581f2, EnumC1603fP> map, Map<SyncModifiableBundle, EnumC1590fC> map2) {
        map2.put(null, this.A00);
    }
}
