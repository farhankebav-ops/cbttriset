package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.controller.impl.GmsLocationController;
import e6.p;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.w;
import q5.x;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.location.internal.controller.impl.GmsLocationController$start$2$1$2", f = "GmsLocationController.kt", l = {}, m = "invokeSuspend")
public final class GmsLocationController$start$2$1$2 extends i implements p {
    final /* synthetic */ a0 $self;
    final /* synthetic */ w $wasSuccessful;
    int label;
    final /* synthetic */ GmsLocationController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GmsLocationController$start$2$1$2(a0 a0Var, GmsLocationController gmsLocationController, w wVar, c<? super GmsLocationController$start$2$1$2> cVar) {
        super(2, cVar);
        this.$self = a0Var;
        this.this$0 = gmsLocationController;
        this.$wasSuccessful = wVar;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new GmsLocationController$start$2$1$2(this.$self, this.this$0, this.$wasSuccessful, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Location lastLocation;
        w5.a aVar = w5.a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        GmsLocationController.GoogleApiClientListener googleApiClientListener = new GmsLocationController.GoogleApiClientListener((GmsLocationController) this.$self.f12717a);
        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this.this$0._applicationService.getAppContext()).addApi(LocationServices.API).addConnectionCallbacks(googleApiClientListener).addOnConnectionFailedListener(googleApiClientListener).setHandler(this.this$0.locationHandlerThread.getMHandler()).build();
        k.d(googleApiClient, "googleApiClient");
        GoogleApiClientCompatProxy googleApiClientCompatProxy = new GoogleApiClientCompatProxy(googleApiClient);
        ConnectionResult connectionResultBlockingConnect = googleApiClientCompatProxy.blockingConnect();
        if (connectionResultBlockingConnect == null || !connectionResultBlockingConnect.isSuccess()) {
            StringBuilder sb = new StringBuilder("GMSLocationController connection to GoogleApiService failed: (");
            sb.append(connectionResultBlockingConnect != null ? new Integer(connectionResultBlockingConnect.getErrorCode()) : null);
            sb.append(") ");
            sb.append(connectionResultBlockingConnect != null ? connectionResultBlockingConnect.getErrorMessage() : null);
            Logging.debug$default(sb.toString(), null, 2, null);
        } else {
            if (this.this$0.lastLocation == null && (lastLocation = this.this$0._fusedLocationApiWrapper.getLastLocation(googleApiClient)) != null) {
                this.this$0.setLocationAndFire(lastLocation);
            }
            ((GmsLocationController) this.$self.f12717a).locationUpdateListener = new GmsLocationController.LocationUpdateListener(this.this$0._applicationService, (GmsLocationController) this.$self.f12717a, googleApiClientCompatProxy.getRealInstance(), this.this$0._fusedLocationApiWrapper);
            ((GmsLocationController) this.$self.f12717a).googleApiClient = googleApiClientCompatProxy;
            this.$wasSuccessful.f12728a = true;
        }
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(q6.a0 a0Var, c<? super x> cVar) {
        return ((GmsLocationController$start$2$1$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
