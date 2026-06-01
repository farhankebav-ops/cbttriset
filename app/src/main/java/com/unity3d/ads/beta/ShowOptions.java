package com.unity3d.ads.beta;

import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ShowOptions {
    private final Map<String, String> extras;

    public ShowOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public ShowOptions(Map<String, String> extras) {
        k.e(extras, "extras");
        this.extras = extras;
    }

    public /* synthetic */ ShowOptions(Map map, int i2, f fVar) {
        this((i2 & 1) != 0 ? s.f13639a : map);
    }
}
