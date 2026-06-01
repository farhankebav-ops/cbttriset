package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.c;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import v3.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SignalsHandler implements a {
    private GMAEventSender _gmaEventSender;

    public SignalsHandler(GMAEventSender gMAEventSender) {
        this._gmaEventSender = gMAEventSender;
    }

    @Override // v3.a
    public void onSignalsCollected(String str) {
        this._gmaEventSender.send(c.h, str);
    }

    @Override // v3.a
    public void onSignalsCollectionFailed(String str) {
        this._gmaEventSender.send(c.f10965i, str);
    }
}
