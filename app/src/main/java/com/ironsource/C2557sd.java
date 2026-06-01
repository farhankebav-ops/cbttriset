package com.ironsource;

import com.unity3d.mediation.LevelPlay;

/* JADX INFO: renamed from: com.ironsource.sd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2557sd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LevelPlay.AdFormat f9830b;

    public C2557sd(String placementName, LevelPlay.AdFormat adFormat) {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        this.f9829a = placementName;
        this.f9830b = adFormat;
    }

    public final String a() {
        return this.f9829a + "_" + this.f9830b;
    }
}
