package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.common.LocationConstants;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import e6.p;
import java.io.Closeable;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.w;
import q5.x;
import q6.c0;
import q6.z1;
import r2.q;
import x5.c;
import x5.e;
import x5.i;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GmsLocationController implements ILocationController {
    private final IApplicationService _applicationService;
    private final IFusedLocationApiWrapper _fusedLocationApiWrapper;
    private final EventProducer<ILocationUpdatedHandler> event;
    private GoogleApiClientCompatProxy googleApiClient;
    private Location lastLocation;
    private final LocationHandlerThread locationHandlerThread;
    private LocationUpdateListener locationUpdateListener;
    private final z6.a startStopMutex;
    public static final Companion Companion = new Companion(null);
    private static final int API_FALLBACK_TIME = 30000;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final int getAPI_FALLBACK_TIME() {
            return GmsLocationController.API_FALLBACK_TIME;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class GoogleApiClientListener implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private final GmsLocationController _parent;

        public GoogleApiClientListener(GmsLocationController _parent) {
            k.e(_parent, "_parent");
            this._parent = _parent;
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            Logging.debug$default("GMSLocationController GoogleApiClientListener onConnected", null, 2, null);
        }

        @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
            k.e(connectionResult, "connectionResult");
            Logging.debug$default("GMSLocationController GoogleApiClientListener onConnectionSuspended connectionResult: " + connectionResult, null, 2, null);
            ThreadUtilsKt.suspendifyOnThread$default(0, new GmsLocationController$GoogleApiClientListener$onConnectionFailed$1(this, null), 1, null);
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public void onConnectionSuspended(int i2) {
            Logging.debug$default("GMSLocationController GoogleApiClientListener onConnectionSuspended i: " + i2, null, 2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class LocationHandlerThread extends HandlerThread {
        private Handler mHandler;

        public LocationHandlerThread() {
            super("OSH_LocationHandlerThread");
            start();
            this.mHandler = new Handler(getLooper());
        }

        public final Handler getMHandler() {
            return this.mHandler;
        }

        public final void setMHandler(Handler handler) {
            k.e(handler, "<set-?>");
            this.mHandler = handler;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class LocationUpdateListener implements LocationListener, IApplicationLifecycleHandler, Closeable {
        private final IApplicationService _applicationService;
        private final IFusedLocationApiWrapper _fusedLocationApiWrapper;
        private final GmsLocationController _parent;
        private final GoogleApiClient googleApiClient;
        private boolean hasExistingRequest;

        public LocationUpdateListener(IApplicationService _applicationService, GmsLocationController _parent, GoogleApiClient googleApiClient, IFusedLocationApiWrapper _fusedLocationApiWrapper) throws Exception {
            k.e(_applicationService, "_applicationService");
            k.e(_parent, "_parent");
            k.e(googleApiClient, "googleApiClient");
            k.e(_fusedLocationApiWrapper, "_fusedLocationApiWrapper");
            this._applicationService = _applicationService;
            this._parent = _parent;
            this.googleApiClient = googleApiClient;
            this._fusedLocationApiWrapper = _fusedLocationApiWrapper;
            if (!googleApiClient.isConnected()) {
                throw new Exception("googleApiClient not connected, cannot listen!");
            }
            _applicationService.addApplicationLifecycleHandler(this);
            refreshRequest();
        }

        private final void refreshRequest() {
            if (!this.googleApiClient.isConnected()) {
                Logging.warn$default("Attempt to refresh location request but not currently connected!", null, 2, null);
                return;
            }
            if (this.hasExistingRequest) {
                this._fusedLocationApiWrapper.cancelLocationUpdates(this.googleApiClient, this);
            }
            long j = this._applicationService.isInForeground() ? LocationConstants.FOREGROUND_UPDATE_TIME_MS : LocationConstants.BACKGROUND_UPDATE_TIME_MS;
            LocationRequest locationRequest = LocationRequest.create().setFastestInterval(j).setInterval(j).setMaxWaitTime((long) (j * 1.5d)).setPriority(102);
            Logging.debug$default("GMSLocationController GoogleApiClient requestLocationUpdates!", null, 2, null);
            IFusedLocationApiWrapper iFusedLocationApiWrapper = this._fusedLocationApiWrapper;
            GoogleApiClient googleApiClient = this.googleApiClient;
            k.d(locationRequest, "locationRequest");
            iFusedLocationApiWrapper.requestLocationUpdates(googleApiClient, locationRequest, this);
            this.hasExistingRequest = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._applicationService.removeApplicationLifecycleHandler(this);
            if (this.hasExistingRequest) {
                this._fusedLocationApiWrapper.cancelLocationUpdates(this.googleApiClient, this);
            }
        }

        @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
        public void onFocus(boolean z2) {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onFocus()");
            refreshRequest();
        }

        public void onLocationChanged(Location location) {
            k.e(location, "location");
            Logging.debug$default("GMSLocationController onLocationChanged: " + location, null, 2, null);
            this._parent.setLocationAndFire(location);
        }

        @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
        public void onUnfocused() {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onUnfocused()");
            refreshRequest();
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.controller.impl.GmsLocationController$setLocationAndFire$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ Location $location;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Location location) {
            super(1);
            this.$location = location;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ILocationUpdatedHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ILocationUpdatedHandler it) {
            k.e(it, "it");
            it.onLocationChanged(this.$location);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.controller.impl.GmsLocationController$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.controller.impl.GmsLocationController", f = "GmsLocationController.kt", l = {48}, m = "start")
    public static final class C27591 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27591(v5.c<? super C27591> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GmsLocationController.this.start(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.controller.impl.GmsLocationController$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.controller.impl.GmsLocationController$start$2", f = "GmsLocationController.kt", l = {250, 62}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ a0 $self;
        final /* synthetic */ w $wasSuccessful;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(w wVar, a0 a0Var, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$wasSuccessful = wVar;
            this.$self = a0Var;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return GmsLocationController.this.new AnonymousClass2(this.$wasSuccessful, this.$self, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            GmsLocationController gmsLocationController;
            w wVar;
            a0 a0Var;
            z6.a aVar;
            z6.a aVar2;
            Throwable th;
            long api_fallback_time;
            GmsLocationController$start$2$1$2 gmsLocationController$start$2$1$2;
            z6.a aVar3;
            z6.a aVar4;
            w5.a aVar5 = w5.a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    q.z0(obj);
                    z6.a aVar6 = GmsLocationController.this.startStopMutex;
                    gmsLocationController = GmsLocationController.this;
                    wVar = this.$wasSuccessful;
                    a0Var = this.$self;
                    this.L$0 = aVar6;
                    this.L$1 = gmsLocationController;
                    this.L$2 = wVar;
                    this.L$3 = a0Var;
                    this.label = 1;
                    z6.c cVar = (z6.c) aVar6;
                    Object objD = cVar.d(this);
                    aVar = cVar;
                    if (objD != aVar5) {
                    }
                    return aVar5;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar2 = (z6.a) this.L$0;
                    try {
                        try {
                            q.z0(obj);
                            aVar3 = aVar2;
                        } catch (Throwable th2) {
                            th = th2;
                            ((z6.c) aVar2).f(null);
                            throw th;
                        }
                    } catch (z1 unused) {
                        Logging.warn$default("Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.", null, 2, null);
                        aVar3 = aVar2;
                    }
                    aVar4 = aVar3;
                    ((z6.c) aVar4).f(null);
                    return x.f13520a;
                }
                a0Var = (a0) this.L$3;
                wVar = (w) this.L$2;
                gmsLocationController = (GmsLocationController) this.L$1;
                z6.a aVar7 = (z6.a) this.L$0;
                q.z0(obj);
                aVar = aVar7;
                if (gmsLocationController.googleApiClient != null) {
                    if (gmsLocationController.lastLocation != null) {
                        gmsLocationController.event.fire(new GmsLocationController$start$2$1$1(gmsLocationController));
                    } else {
                        Location lastLocation = gmsLocationController.getLastLocation();
                        if (lastLocation != null) {
                            gmsLocationController.setLocationAndFire(lastLocation);
                        }
                    }
                    wVar.f12728a = true;
                    aVar4 = aVar;
                    ((z6.c) aVar4).f(null);
                    return x.f13520a;
                }
                try {
                    api_fallback_time = GmsLocationController.Companion.getAPI_FALLBACK_TIME();
                    gmsLocationController$start$2$1$2 = new GmsLocationController$start$2$1$2(a0Var, gmsLocationController, wVar, null);
                    this.L$0 = aVar;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 2;
                } catch (z1 unused2) {
                    aVar2 = aVar;
                    Logging.warn$default("Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.", null, 2, null);
                    aVar3 = aVar2;
                }
                if (c0.I(api_fallback_time, gmsLocationController$start$2$1$2, this) != aVar5) {
                    aVar3 = aVar;
                    aVar4 = aVar3;
                    ((z6.c) aVar4).f(null);
                    return x.f13520a;
                }
                return aVar5;
            } catch (Throwable th3) {
                aVar2 = aVar;
                th = th3;
                ((z6.c) aVar2).f(null);
                throw th;
            }
        }

        @Override // e6.p
        public final Object invoke(q6.a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.controller.impl.GmsLocationController$stop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.controller.impl.GmsLocationController", f = "GmsLocationController.kt", l = {250}, m = "stop")
    public static final class C27601 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27601(v5.c<? super C27601> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GmsLocationController.this.stop(this);
        }
    }

    public GmsLocationController(IApplicationService _applicationService, IFusedLocationApiWrapper _fusedLocationApiWrapper) {
        k.e(_applicationService, "_applicationService");
        k.e(_fusedLocationApiWrapper, "_fusedLocationApiWrapper");
        this._applicationService = _applicationService;
        this._fusedLocationApiWrapper = _fusedLocationApiWrapper;
        this.locationHandlerThread = new LocationHandlerThread();
        this.startStopMutex = d.a();
        this.event = new EventProducer<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLocationAndFire(Location location) {
        Logging.debug$default("GMSLocationController lastLocation: " + this.lastLocation, null, 2, null);
        this.lastLocation = location;
        this.event.fire(new AnonymousClass1(location));
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.event.getHasSubscribers();
    }

    @Override // com.onesignal.location.internal.controller.ILocationController
    public Location getLastLocation() {
        GoogleApiClient realInstance;
        GoogleApiClientCompatProxy googleApiClientCompatProxy = this.googleApiClient;
        if (googleApiClientCompatProxy == null || (realInstance = googleApiClientCompatProxy.getRealInstance()) == null) {
            return null;
        }
        return this._fusedLocationApiWrapper.getLastLocation(realInstance);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.location.internal.controller.ILocationController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object start(v5.c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.onesignal.location.internal.controller.impl.GmsLocationController.C27591
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.location.internal.controller.impl.GmsLocationController$start$1 r0 = (com.onesignal.location.internal.controller.impl.GmsLocationController.C27591) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.location.internal.controller.impl.GmsLocationController$start$1 r0 = new com.onesignal.location.internal.controller.impl.GmsLocationController$start$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.w r0 = (kotlin.jvm.internal.w) r0
            r2.q.z0(r8)
            goto L58
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L33:
            r2.q.z0(r8)
            kotlin.jvm.internal.a0 r8 = new kotlin.jvm.internal.a0
            r8.<init>()
            r8.f12717a = r7
            kotlin.jvm.internal.w r2 = new kotlin.jvm.internal.w
            r2.<init>()
            x6.e r4 = q6.m0.f13566a
            x6.d r4 = x6.d.f17810a
            com.onesignal.location.internal.controller.impl.GmsLocationController$start$2 r5 = new com.onesignal.location.internal.controller.impl.GmsLocationController$start$2
            r6 = 0
            r5.<init>(r2, r8, r6)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = q6.c0.H(r5, r4, r0)
            if (r8 != r1) goto L57
            return r1
        L57:
            r0 = r2
        L58:
            boolean r8 = r0.f12728a
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.controller.impl.GmsLocationController.start(v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.location.internal.controller.ILocationController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object stop(v5.c<? super q5.x> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.onesignal.location.internal.controller.impl.GmsLocationController.C27601
            if (r0 == 0) goto L13
            r0 = r5
            com.onesignal.location.internal.controller.impl.GmsLocationController$stop$1 r0 = (com.onesignal.location.internal.controller.impl.GmsLocationController.C27601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.location.internal.controller.impl.GmsLocationController$stop$1 r0 = new com.onesignal.location.internal.controller.impl.GmsLocationController$stop$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r1 = r0.L$1
            z6.a r1 = (z6.a) r1
            java.lang.Object r0 = r0.L$0
            com.onesignal.location.internal.controller.impl.GmsLocationController r0 = (com.onesignal.location.internal.controller.impl.GmsLocationController) r0
            r2.q.z0(r5)
            goto L4d
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            r2.q.z0(r5)
            z6.a r5 = r4.startStopMutex
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            z6.c r5 = (z6.c) r5
            java.lang.Object r0 = r5.d(r0)
            if (r0 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
            r1 = r5
        L4d:
            r5 = 0
            com.onesignal.location.internal.controller.impl.GmsLocationController$LocationUpdateListener r2 = r0.locationUpdateListener     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L5a
            r2.close()     // Catch: java.lang.Throwable -> L58
            r0.locationUpdateListener = r5     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r0 = move-exception
            goto L6d
        L5a:
            com.onesignal.location.internal.controller.impl.GoogleApiClientCompatProxy r2 = r0.googleApiClient     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L63
            r2.disconnect()     // Catch: java.lang.Throwable -> L58
            r0.googleApiClient = r5     // Catch: java.lang.Throwable -> L58
        L63:
            r0.lastLocation = r5     // Catch: java.lang.Throwable -> L58
            z6.c r1 = (z6.c) r1
            r1.f(r5)
            q5.x r5 = q5.x.f13520a
            return r5
        L6d:
            z6.c r1 = (z6.c) r1
            r1.f(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.controller.impl.GmsLocationController.stop(v5.c):java.lang.Object");
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ILocationUpdatedHandler handler) {
        k.e(handler, "handler");
        this.event.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ILocationUpdatedHandler handler) {
        k.e(handler, "handler");
        this.event.unsubscribe(handler);
    }
}
