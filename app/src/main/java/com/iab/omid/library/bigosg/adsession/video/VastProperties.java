package com.iab.omid.library.bigosg.adsession.video;

import com.iab.omid.library.bigosg.d.e;

/* JADX INFO: loaded from: classes3.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f5761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f5763d;
    private com.iab.omid.library.bigosg.adsession.media.VastProperties e;

    private VastProperties(boolean z2, Float f4, boolean z7, Position position, com.iab.omid.library.bigosg.adsession.media.VastProperties vastProperties) {
        this.f5760a = z2;
        this.f5761b = f4;
        this.f5762c = z7;
        this.f5763d = position;
        this.e = vastProperties;
    }

    public static VastProperties createVastPropertiesForNonSkippableVideo(boolean z2, Position position) {
        e.a(position, "Position is null");
        return new VastProperties(false, null, z2, position, com.iab.omid.library.bigosg.adsession.media.VastProperties.createVastPropertiesForNonSkippableMedia(z2, com.iab.omid.library.bigosg.adsession.media.Position.valueOf(position.toString().toUpperCase())));
    }

    public static VastProperties createVastPropertiesForSkippableVideo(float f4, boolean z2, Position position) {
        e.a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f4), z2, position, com.iab.omid.library.bigosg.adsession.media.VastProperties.createVastPropertiesForSkippableMedia(f4, z2, com.iab.omid.library.bigosg.adsession.media.Position.valueOf(position.toString().toUpperCase())));
    }

    public final com.iab.omid.library.bigosg.adsession.media.VastProperties a() {
        return this.e;
    }

    public final Position getPosition() {
        return this.f5763d;
    }

    public final Float getSkipOffset() {
        return this.f5761b;
    }

    public final boolean isAutoPlay() {
        return this.f5762c;
    }

    public final boolean isSkippable() {
        return this.f5760a;
    }
}
