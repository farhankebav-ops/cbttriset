package com.onesignal.location.internal.permissions;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationPermissionController$showFallbackAlertDialog$1$onAccept$1$onFocus$1 extends l implements e6.l {
    final /* synthetic */ boolean $hasPermission;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationPermissionController$showFallbackAlertDialog$1$onAccept$1$onFocus$1(boolean z2) {
        super(1);
        this.$hasPermission = z2;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ILocationPermissionChangedHandler) obj);
        return x.f13520a;
    }

    public final void invoke(ILocationPermissionChangedHandler it) {
        k.e(it, "it");
        it.onLocationPermissionChanged(this.$hasPermission);
    }
}
