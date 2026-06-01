package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.x1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2630x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<LevelPlay.AdFormat, C2493p> f10498a;

    public C2630x1(JSONObject applicationAuctionSettings) {
        kotlin.jvm.internal.k.e(applicationAuctionSettings, "applicationAuctionSettings");
        LevelPlay.AdFormat[] adFormatArrValues = LevelPlay.AdFormat.values();
        int iD0 = r5.x.d0(adFormatArrValues.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0 < 16 ? 16 : iD0);
        for (LevelPlay.AdFormat adFormat : adFormatArrValues) {
            JSONObject jSONObjectOptJSONObject = applicationAuctionSettings.optJSONObject(C2627wf.a(adFormat));
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            linkedHashMap.put(adFormat, new C2493p(jSONObjectOptJSONObject));
        }
        this.f10498a = linkedHashMap;
    }

    public final Map<LevelPlay.AdFormat, C2493p> a() {
        return this.f10498a;
    }
}
