package com.instagram.common.viewpoint.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0642Bi implements InterfaceC1598fK {
    public final By A00;
    public final EnumC1603fP A01;

    public AbstractC0642Bi(By by, EnumC1603fP enumC1603fP) {
        this.A00 = by;
        this.A01 = enumC1603fP;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1598fK
    public void A45(Map<InterfaceC1581f2, EnumC1603fP> map, Map<SyncModifiableBundle, EnumC1590fC> map2) {
        map.put(this.A00, this.A01);
    }
}
