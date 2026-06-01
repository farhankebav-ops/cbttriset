package com.ironsource.mediationsdk.adunit.adapter.utility;

import com.ironsource.C2531r4;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NativeAdProperties {
    private final AdOptionsPosition adOptionsPosition;
    private final AdOptionsPosition defaultAdOptionPosition;

    public NativeAdProperties(JSONObject config) {
        k.e(config, "config");
        this.defaultAdOptionPosition = AdOptionsPosition.BOTTOM_LEFT;
        this.adOptionsPosition = getAdOptionsPosition(config);
    }

    public final AdOptionsPosition getAdOptionsPosition() {
        return this.adOptionsPosition;
    }

    private final AdOptionsPosition getAdOptionsPosition(JSONObject jSONObject) {
        String position = jSONObject.optString(AdOptionsPosition.AD_OPTIONS_POSITION_KEY, this.defaultAdOptionPosition.toString());
        try {
            k.d(position, "position");
            return AdOptionsPosition.valueOf(position);
        } catch (Exception e) {
            C2531r4.d().a(e);
            return this.defaultAdOptionPosition;
        }
    }
}
