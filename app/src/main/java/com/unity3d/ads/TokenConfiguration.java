package com.unity3d.ads;

import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TokenConfiguration {
    private final AdFormat adFormat;
    private final Map<String, String> extras;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TokenConfiguration(AdFormat adFormat) {
        this(adFormat, null, 2, 0 == true ? 1 : 0);
        k.e(adFormat, "adFormat");
    }

    public final AdFormat getAdFormat() {
        return this.adFormat;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public TokenConfiguration(AdFormat adFormat, Map<String, String> extras) {
        k.e(adFormat, "adFormat");
        k.e(extras, "extras");
        this.adFormat = adFormat;
        this.extras = extras;
    }

    public /* synthetic */ TokenConfiguration(AdFormat adFormat, Map map, int i2, f fVar) {
        this(adFormat, (i2 & 2) != 0 ? s.f13639a : map);
    }
}
