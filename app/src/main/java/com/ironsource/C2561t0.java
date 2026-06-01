package com.ironsource;

import com.ironsource.C2543s;
import com.ironsource.InterfaceC2568t7;
import com.unity3d.mediation.LevelPlay;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: renamed from: com.ironsource.t0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2561t0 implements N3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2623wb f10235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<LevelPlay.AdFormat, C2543s> f10236b;

    public C2561t0(C2623wb tools, Map<LevelPlay.AdFormat, C2543s> adFormatsConfigurations) {
        kotlin.jvm.internal.k.e(tools, "tools");
        kotlin.jvm.internal.k.e(adFormatsConfigurations, "adFormatsConfigurations");
        this.f10235a = tools;
        this.f10236b = adFormatsConfigurations;
    }

    private final void b(InterfaceC2568t7.a aVar, String str, C2543s.d dVar) throws JSONException {
        C2273cd c2273cdE = dVar.e();
        if (c2273cdE != null) {
            Q3 q32 = Q3.Pacing;
            a(aVar.a(str, q32, new H3(c2273cdE.a(), c2273cdE.b(), c2273cdE.c())), str, q32);
        }
    }

    @Override // com.ironsource.N3
    public void a(InterfaceC2568t7.a cappingService) {
        kotlin.jvm.internal.k.e(cappingService, "cappingService");
        Iterator<Map.Entry<LevelPlay.AdFormat, C2543s>> it = this.f10236b.entrySet().iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, C2543s.d> entry : it.next().getValue().a().entrySet()) {
                String key = entry.getKey();
                C2543s.d value = entry.getValue();
                a(cappingService, key, value);
                b(cappingService, key, value);
            }
        }
    }

    private final void a(InterfaceC2568t7.a aVar, String str, C2543s.d dVar) throws JSONException {
        K3 k3B = dVar.b();
        if (k3B != null) {
            Q3 q32 = Q3.ShowCount;
            a(aVar.a(str, q32, new H3(k3B.a(), k3B.b(), k3B.c())), str, q32);
        }
    }

    private final void a(Object obj, String str, Q3 q32) throws JSONException {
        Throwable thA = q5.k.a(obj);
        if (thA != null) {
            this.f10235a.a(str, new L3().a(q32), thA.getMessage());
        }
    }
}
