package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2645y implements InterfaceC2446m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final P8 f10541a;

    public C2645y(P8 sessionDepthService) {
        kotlin.jvm.internal.k.e(sessionDepthService, "sessionDepthService");
        this.f10541a = sessionDepthService;
    }

    @Override // com.ironsource.InterfaceC2446m7
    public void a(Map<String, Object> output) {
        kotlin.jvm.internal.k.e(output, "output");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Q6.I0, Integer.valueOf(this.f10541a.a(LevelPlay.AdFormat.INTERSTITIAL)));
        output.put("interstitial", linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put(Q6.I0, Integer.valueOf(this.f10541a.a(LevelPlay.AdFormat.REWARDED)));
        output.put(Q6.F0, linkedHashMap2);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put(Q6.I0, Integer.valueOf(this.f10541a.a(LevelPlay.AdFormat.BANNER)));
        output.put("banner", linkedHashMap3);
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        linkedHashMap4.put(Q6.I0, Integer.valueOf(this.f10541a.a(LevelPlay.AdFormat.NATIVE_AD)));
        output.put("nativeAd", linkedHashMap4);
    }
}
