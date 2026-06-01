package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;
import u3.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ScarInterstitialAdHandler extends ScarAdHandlerBase {
    public ScarInterstitialAdHandler(c cVar, EventSubject<com.unity3d.scar.adapter.common.c> eventSubject, GMAEventSender gMAEventSender) {
        super(cVar, eventSubject, gMAEventSender);
    }

    @Override // com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase, com.unity3d.scar.adapter.common.e
    public void onAdClosed() {
        if (!this._eventSubject.eventQueueIsEmpty()) {
            onAdSkipped();
        }
        super.onAdClosed();
    }

    public void onAdFailedToShow(int i2, String str) {
        GMAEventSender gMAEventSender = this._gmaEventSender;
        c cVar = this._scarAdMetadata;
        gMAEventSender.send(com.unity3d.scar.adapter.common.c.f10972u, cVar.f17527a, cVar.f17528b, str, Integer.valueOf(i2));
    }

    public void onAdImpression() {
        this._gmaEventSender.send(com.unity3d.scar.adapter.common.c.l, new Object[0]);
    }

    public void onAdLeftApplication() {
        this._gmaEventSender.send(com.unity3d.scar.adapter.common.c.C, new Object[0]);
    }

    public void onAdSkipped() {
        this._gmaEventSender.send(com.unity3d.scar.adapter.common.c.B, new Object[0]);
    }
}
