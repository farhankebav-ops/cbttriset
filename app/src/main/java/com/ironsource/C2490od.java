package com.ironsource;

import com.ironsource.C2543s;
import com.ironsource.N7;
import com.unity3d.mediation.LevelPlay;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: renamed from: com.ironsource.od, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2490od {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2623wb f9560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<LevelPlay.AdFormat, C2543s> f9561b;

    public C2490od(C2623wb tools, Map<LevelPlay.AdFormat, C2543s> adFormatsConfigurations) {
        kotlin.jvm.internal.k.e(tools, "tools");
        kotlin.jvm.internal.k.e(adFormatsConfigurations, "adFormatsConfigurations");
        this.f9560a = tools;
        this.f9561b = adFormatsConfigurations;
    }

    private final void b(N7.a aVar, String str, LevelPlay.AdFormat adFormat, C2543s.d dVar) throws JSONException {
        Q3 q32 = Q3.Delivery;
        R4 r4C = dVar.c();
        a(aVar.a(str, adFormat, q32, new H3(r4C != null ? Boolean.valueOf(r4C.a()) : null, null, null, 6, null)), str, adFormat, q32);
    }

    private final void c(N7.a aVar, String str, LevelPlay.AdFormat adFormat, C2543s.d dVar) throws JSONException {
        C2273cd c2273cdE = dVar.e();
        if (c2273cdE != null) {
            Q3 q32 = Q3.Pacing;
            a(aVar.a(str, adFormat, q32, new H3(c2273cdE.a(), c2273cdE.b(), P3.Second)), str, adFormat, q32);
        }
    }

    public final void a(N7.a cappingService) {
        kotlin.jvm.internal.k.e(cappingService, "cappingService");
        for (Map.Entry<LevelPlay.AdFormat, C2543s> entry : this.f9561b.entrySet()) {
            LevelPlay.AdFormat key = entry.getKey();
            for (Map.Entry<String, C2543s.d> entry2 : entry.getValue().c().entrySet()) {
                String key2 = entry2.getKey();
                C2543s.d value = entry2.getValue();
                b(cappingService, key2, key, value);
                a(cappingService, key2, key, value);
                c(cappingService, key2, key, value);
            }
        }
    }

    private final void a(N7.a aVar, String str, LevelPlay.AdFormat adFormat, C2543s.d dVar) throws JSONException {
        K3 k3B = dVar.b();
        if (k3B != null) {
            Q3 q32 = Q3.ShowCount;
            a(aVar.a(str, adFormat, q32, new H3(k3B.a(), k3B.b(), k3B.c())), str, adFormat, q32);
        }
    }

    private final void a(Object obj, String str, LevelPlay.AdFormat adFormat, Q3 q32) throws JSONException {
        Throwable thA = q5.k.a(obj);
        if (thA != null) {
            this.f9560a.a(str, adFormat, new L3().a(q32), thA.getMessage());
        }
    }
}
