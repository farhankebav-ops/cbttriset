package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.c;
import com.unity3d.scar.adapter.common.e;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;
import com.unity3d.services.core.misc.IEventListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ScarAdHandlerBase implements e {
    protected final EventSubject<c> _eventSubject;
    protected final GMAEventSender _gmaEventSender;
    protected final u3.c _scarAdMetadata;

    public ScarAdHandlerBase(u3.c cVar, EventSubject<c> eventSubject, GMAEventSender gMAEventSender) {
        this._scarAdMetadata = cVar;
        this._eventSubject = eventSubject;
        this._gmaEventSender = gMAEventSender;
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdClicked() {
        this._gmaEventSender.send(c.A, new Object[0]);
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdClosed() {
        this._gmaEventSender.send(c.D, new Object[0]);
        this._eventSubject.unsubscribe();
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdFailedToLoad(int i2, String str) {
        GMAEventSender gMAEventSender = this._gmaEventSender;
        u3.c cVar = this._scarAdMetadata;
        gMAEventSender.send(c.f10967o, cVar.f17527a, cVar.f17528b, str, Integer.valueOf(i2));
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdLoaded() {
        GMAEventSender gMAEventSender = this._gmaEventSender;
        u3.c cVar = this._scarAdMetadata;
        gMAEventSender.send(c.k, cVar.f17527a, cVar.f17528b);
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdOpened() {
        this._gmaEventSender.send(c.f10968q, new Object[0]);
        this._eventSubject.subscribe(new IEventListener<c>() { // from class: com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase.1
            @Override // com.unity3d.services.core.misc.IEventListener
            public void onNextEvent(c cVar) {
                ScarAdHandlerBase.this._gmaEventSender.send(cVar, new Object[0]);
            }
        });
    }
}
