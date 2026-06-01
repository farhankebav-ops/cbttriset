package com.ironsource;

import com.ironsource.C2300e4;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Ve f7691a;

    public Ue(JSONObject config) {
        kotlin.jvm.internal.k.e(config, "config");
        this.f7691a = Ve.f7743b.a(config.optInt(C2300e4.a.f8302t, Ve.CurrentlyLoadedAds.b()));
    }

    public final Ve a() {
        return this.f7691a;
    }
}
