package com.ironsource.adapters.ironsource;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LoadAdData {
    private final JSONObject localAdData;

    public LoadAdData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String adUnitId() {
        String it = this.localAdData.optString("adUnitId");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final boolean isMultipleAdObjectsFlow() {
        return this.localAdData.optBoolean("isMultipleAdUnits", false);
    }

    public LoadAdData(JSONObject jSONObject) {
        this.localAdData = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public /* synthetic */ LoadAdData(JSONObject jSONObject, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : jSONObject);
    }
}
