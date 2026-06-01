package com.iab.omid.library.bigosg.adsession.media;

import com.iab.omid.library.bigosg.adsession.AdSession;
import com.iab.omid.library.bigosg.adsession.a;
import com.iab.omid.library.bigosg.b.f;
import com.iab.omid.library.bigosg.d.b;
import com.iab.omid.library.bigosg.d.e;
import com.ironsource.C2300e4;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class MediaEvents {
    private final a adSession;

    private MediaEvents(a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f4) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f4) {
        if (f4 < 0.0f || f4 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession) {
        a aVar = (a) adSession;
        e.a(adSession, "AdSession is null");
        e.g(aVar);
        e.a(aVar);
        e.b(aVar);
        e.e(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.getAdSessionStatePublisher().a(mediaEvents);
        return mediaEvents;
    }

    public final void adUserInteraction(InteractionType interactionType) {
        e.a(interactionType, "InteractionType is null");
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().a("adUserInteraction", jSONObject);
    }

    public final void bufferFinish() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferFinish");
    }

    public final void bufferStart() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferStart");
    }

    public final void complete() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("complete");
    }

    public final void firstQuartile() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("firstQuartile");
    }

    public final void loaded(VastProperties vastProperties) {
        e.a(vastProperties, "VastProperties is null");
        e.b(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(C2300e4.h.f8381r, vastProperties.a());
    }

    public final void midpoint() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("midpoint");
    }

    public final void pause() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("pause");
    }

    public final void playerStateChange(PlayerState playerState) {
        e.a(playerState, "PlayerState is null");
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "state", playerState);
        this.adSession.getAdSessionStatePublisher().a("playerStateChange", jSONObject);
    }

    public final void resume() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("resume");
    }

    public final void skipped() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("skipped");
    }

    public final void start(float f4, float f8) {
        confirmValidDuration(f4);
        confirmValidVolume(f8);
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "duration", Float.valueOf(f4));
        b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f8));
        b.a(jSONObject, C2300e4.i.P, Float.valueOf(f.a().d()));
        this.adSession.getAdSessionStatePublisher().a("start", jSONObject);
    }

    public final void thirdQuartile() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("thirdQuartile");
    }

    public final void volumeChange(float f4) {
        confirmValidVolume(f4);
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f4));
        b.a(jSONObject, C2300e4.i.P, Float.valueOf(f.a().d()));
        this.adSession.getAdSessionStatePublisher().a("volumeChange", jSONObject);
    }
}
