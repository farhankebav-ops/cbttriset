package com.iab.omid.library.bytedance2.adsession.media;

import com.iab.omid.library.bytedance2.utils.d;
import com.iab.omid.library.bytedance2.utils.g;
import com.ironsource.C2300e4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f5854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f5856d;

    private VastProperties(boolean z2, Float f4, boolean z7, Position position) {
        this.f5853a = z2;
        this.f5854b = f4;
        this.f5855c = z7;
        this.f5856d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z2, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(false, null, z2, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f4, boolean z2, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f4), z2, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f5853a);
            if (this.f5853a) {
                jSONObject.put("skipOffset", this.f5854b);
            }
            jSONObject.put("autoPlay", this.f5855c);
            jSONObject.put(C2300e4.h.L, this.f5856d);
            return jSONObject;
        } catch (JSONException e) {
            d.a("VastProperties: JSON error", e);
            return jSONObject;
        }
    }

    public Position getPosition() {
        return this.f5856d;
    }

    public Float getSkipOffset() {
        return this.f5854b;
    }

    public boolean isAutoPlay() {
        return this.f5855c;
    }

    public boolean isSkippable() {
        return this.f5853a;
    }
}
