package com.ironsource;

import com.unity3d.mediation.impression.LevelPlayImpressionData;
import com.unity3d.mediation.impression.LevelPlayImpressionDataListener;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.eb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2307eb implements InterfaceC2233a9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LevelPlayImpressionDataListener f8457a;

    public C2307eb(LevelPlayImpressionDataListener listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f8457a = listener;
    }

    public final LevelPlayImpressionDataListener a() {
        return this.f8457a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2307eb) {
            return kotlin.jvm.internal.k.a(this.f8457a, ((C2307eb) obj).f8457a);
        }
        return false;
    }

    public int hashCode() {
        return this.f8457a.hashCode();
    }

    @Override // com.ironsource.InterfaceC2233a9
    public void a(Y8 impressionData) {
        kotlin.jvm.internal.k.e(impressionData, "impressionData");
        if (impressionData.d() != null) {
            JSONObject jSONObjectD = impressionData.d();
            kotlin.jvm.internal.k.d(jSONObjectD, "impressionData.allData");
            this.f8457a.onImpressionSuccess(new LevelPlayImpressionData(jSONObjectD));
        }
    }
}
