package com.iab.omid.library.vungle.adsession.media;

import com.iab.omid.library.vungle.utils.d;
import com.iab.omid.library.vungle.utils.g;
import com.ironsource.C2300e4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f6169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f6170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f6171d;

    private VastProperties(boolean z2, Float f4, boolean z7, Position position) {
        this.f6168a = z2;
        this.f6169b = f4;
        this.f6170c = z7;
        this.f6171d = position;
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
            jSONObject.put("skippable", this.f6168a);
            if (this.f6168a) {
                jSONObject.put("skipOffset", this.f6169b);
            }
            jSONObject.put("autoPlay", this.f6170c);
            jSONObject.put(C2300e4.h.L, this.f6171d);
            return jSONObject;
        } catch (JSONException e) {
            d.a("VastProperties: JSON error", e);
            return jSONObject;
        }
    }

    public Position getPosition() {
        return this.f6171d;
    }

    public Float getSkipOffset() {
        return this.f6169b;
    }

    public boolean isAutoPlay() {
        return this.f6170c;
    }

    public boolean isSkippable() {
        return this.f6168a;
    }
}
