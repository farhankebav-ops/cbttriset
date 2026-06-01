package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NullLocationController implements ILocationController {
    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return false;
    }

    @Override // com.onesignal.location.internal.controller.ILocationController
    public Location getLastLocation() {
        return null;
    }

    @Override // com.onesignal.location.internal.controller.ILocationController
    public Object start(c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    @Override // com.onesignal.location.internal.controller.ILocationController
    public Object stop(c<? super x> cVar) {
        return x.f13520a;
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ILocationUpdatedHandler handler) {
        k.e(handler, "handler");
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ILocationUpdatedHandler handler) {
        k.e(handler, "handler");
    }
}
