package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC0763Gb {
    public static final InterfaceC0763Gb A00 = new InterfaceC0763Gb() { // from class: com.facebook.ads.redexgen.X.lL
        @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
        public final GX[] A5F() {
            return AbstractC0762Ga.A00();
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
        public final /* synthetic */ GX[] A5G(Uri uri, Map map) {
            return AbstractC0762Ga.A01(this, uri, map);
        }
    };

    GX[] A5F();

    GX[] A5G(Uri uri, Map<String, List<String>> map);
}
