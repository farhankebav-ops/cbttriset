package com.iab.omid.library.ironsrc.adsession.media;

import com.iab.omid.library.ironsrc.utils.d;
import com.iab.omid.library.ironsrc.utils.g;
import com.ironsource.C2300e4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f5958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f5960d;

    private VastProperties(boolean z2, Float f4, boolean z7, Position position) {
        this.f5957a = z2;
        this.f5958b = f4;
        this.f5959c = z7;
        this.f5960d = position;
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
            jSONObject.put("skippable", this.f5957a);
            if (this.f5957a) {
                jSONObject.put("skipOffset", this.f5958b);
            }
            jSONObject.put("autoPlay", this.f5959c);
            jSONObject.put(C2300e4.h.L, this.f5960d);
            return jSONObject;
        } catch (JSONException e) {
            d.a("VastProperties: JSON error", e);
            return jSONObject;
        }
    }

    public Position getPosition() {
        return this.f5960d;
    }

    public Float getSkipOffset() {
        return this.f5958b;
    }

    public boolean isAutoPlay() {
        return this.f5959c;
    }

    public boolean isSkippable() {
        return this.f5957a;
    }
}
