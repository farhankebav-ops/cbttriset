package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GmsLocationController$start$2$1$1 extends l implements e6.l {
    final /* synthetic */ GmsLocationController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GmsLocationController$start$2$1$1(GmsLocationController gmsLocationController) {
        super(1);
        this.this$0 = gmsLocationController;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ILocationUpdatedHandler) obj);
        return x.f13520a;
    }

    public final void invoke(ILocationUpdatedHandler it) {
        k.e(it, "it");
        Location location = this.this$0.lastLocation;
        k.b(location);
        it.onLocationChanged(location);
    }
}
