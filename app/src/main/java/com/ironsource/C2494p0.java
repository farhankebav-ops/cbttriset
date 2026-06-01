package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.p0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2494p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, R0> f9571a = new HashMap<>();

    /* JADX INFO: renamed from: com.ironsource.p0$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        DidntAttemptToLoad,
        FailedToLoad,
        LoadedSuccessfully,
        FailedToShow,
        ShowedSuccessfully,
        NotPartOfWaterfall
    }

    public final R0 a(String adUnitId, List<? extends NetworkSettings> providers, int i2) {
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        kotlin.jvm.internal.k.e(providers, "providers");
        R0 r02 = this.f9571a.get(adUnitId);
        if (r02 != null) {
            return r02;
        }
        R0 r03 = new R0(providers, i2);
        this.f9571a.put(adUnitId, r03);
        return r03;
    }
}
