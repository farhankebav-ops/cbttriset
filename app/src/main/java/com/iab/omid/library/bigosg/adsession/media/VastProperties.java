package com.iab.omid.library.bigosg.adsession.media;

import com.iab.omid.library.bigosg.d.c;
import com.iab.omid.library.bigosg.d.e;
import com.ironsource.C2300e4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f5757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f5759d;

    private VastProperties(boolean z2, Float f4, boolean z7, Position position) {
        this.f5756a = z2;
        this.f5757b = f4;
        this.f5758c = z7;
        this.f5759d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z2, Position position) {
        e.a(position, "Position is null");
        return new VastProperties(false, null, z2, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f4, boolean z2, Position position) {
        e.a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f4), z2, position);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f5756a);
            if (this.f5756a) {
                jSONObject.put("skipOffset", this.f5757b);
            }
            jSONObject.put("autoPlay", this.f5758c);
            jSONObject.put(C2300e4.h.L, this.f5759d);
            return jSONObject;
        } catch (JSONException e) {
            c.a("VastProperties: JSON error", e);
            return jSONObject;
        }
    }

    public final Position getPosition() {
        return this.f5759d;
    }

    public final Float getSkipOffset() {
        return this.f5757b;
    }

    public final boolean isAutoPlay() {
        return this.f5758c;
    }

    public final boolean isSkippable() {
        return this.f5756a;
    }
}
