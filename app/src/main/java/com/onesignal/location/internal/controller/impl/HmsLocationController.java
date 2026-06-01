package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.common.threading.Waiter;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.common.LocationConstants;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import e6.l;
import e6.p;
import java.io.Closeable;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.w;
import q5.x;
import r2.q;
import v5.c;
import x5.e;
import x5.i;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HmsLocationController implements ILocationController {
    private final IApplicationService _applicationService;
    private final EventProducer<ILocationUpdatedHandler> event;
    private FusedLocationProviderClient hmsFusedLocationClient;
    private Location lastLocation;
    private final LocationHandlerThread locationHandlerThread;
    private LocationUpdateListener locationUpdateListener;
    private final z6.a startStopMutex;

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
    public static final class LocationUpdateListener extends LocationCallback implements IApplicationLifecycleHandler, Closeable {
        private final IApplicationService _applicationService;
        private final HmsLocationController _parent;
        private boolean hasExistingRequest;
        private final FusedLocationProviderClient huaweiFusedLocationProviderClient;

        public LocationUpdateListener(HmsLocationController _parent, IApplicationService _applicationService, FusedLocationProviderClient huaweiFusedLocationProviderClient) {
            k.e(_parent, "_parent");
            k.e(_applicationService, "_applicationService");
            k.e(huaweiFusedLocationProviderClient, "huaweiFusedLocationProviderClient");
            this._parent = _parent;
            this._applicationService = _applicationService;
            this.huaweiFusedLocationProviderClient = huaweiFusedLocationProviderClient;
            _applicationService.addApplicationLifecycleHandler(this);
            refreshRequest();
        }

        private final void refreshRequest() {
            if (this.hasExistingRequest) {
                this.huaweiFusedLocationProviderClient.removeLocationUpdates(this);
            }
            long j = this._applicationService.isInForeground() ? LocationConstants.FOREGROUND_UPDATE_TIME_MS : LocationConstants.BACKGROUND_UPDATE_TIME_MS;
            LocationRequest priority = LocationRequest.create().setFastestInterval(j).setInterval(j).setMaxWaitTime((long) (j * 1.5d)).setPriority(102);
            Logging.debug$default("HMSLocationController Huawei LocationServices requestLocationUpdates!", null, 2, null);
            this.huaweiFusedLocationProviderClient.requestLocationUpdates(priority, this, this._parent.locationHandlerThread.getLooper());
            this.hasExistingRequest = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._applicationService.removeApplicationLifecycleHandler(this);
            if (this.hasExistingRequest) {
                this.huaweiFusedLocationProviderClient.removeLocationUpdates(this);
            }
        }

        @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
        public void onFocus(boolean z2) {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onFocus()");
            refreshRequest();
        }

        public void onLocationResult(LocationResult locationResult) {
            k.e(locationResult, "locationResult");
            Logging.debug$default("HMSLocationController onLocationResult: " + locationResult, null, 2, null);
            this._parent.lastLocation = locationResult.getLastLocation();
        }

        @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
        public void onUnfocused() {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onUnfocused()");
            refreshRequest();
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.controller.impl.HmsLocationController$getLastLocation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.controller.impl.HmsLocationController$getLastLocation$1", f = "HmsLocationController.kt", l = {139}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ FusedLocationProviderClient $locationClient;
        final /* synthetic */ a0 $retVal;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FusedLocationProviderClient fusedLocationProviderClient, a0 a0Var, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$locationClient = fusedLocationProviderClient;
            this.$retVal = a0Var;
        }

        /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        private static final void m3157invokeSuspend$lambda0(a0 a0Var, a0 a0Var2, Location location) {
            Logging.warn$default("Huawei LocationServices getLastLocation returned location: " + location, null, 2, null);
            if (location == null) {
                ((Waiter) a0Var.f12717a).wake();
            } else {
                a0Var2.f12717a = location;
                ((Waiter) a0Var.f12717a).wake();
            }
        }

        /* JADX INFO: renamed from: invokeSuspend$lambda-1, reason: not valid java name */
        private static final void m3158invokeSuspend$lambda1(a0 a0Var, Exception exc) {
            Logging.error("Huawei LocationServices getLastLocation failed!", exc);
            ((Waiter) a0Var.f12717a).wake();
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.$locationClient, this.$retVal, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                Waiter waiter = new Waiter();
                this.$locationClient.getLastLocation().addOnSuccessListener(new a()).addOnFailureListener(new b());
                this.label = 1;
                if (waiter.waitForWake(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.controller.impl.HmsLocationController$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.controller.impl.HmsLocationController", f = "HmsLocationController.kt", l = {46}, m = "start")
    public static final class C27611 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27611(c<? super C27611> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HmsLocationController.this.start(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.controller.impl.HmsLocationController$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.controller.impl.HmsLocationController$start$2", f = "HmsLocationController.kt", l = {229, 81}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ a0 $self;
        final /* synthetic */ w $wasSuccessful;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(w wVar, a0 a0Var, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$wasSuccessful = wVar;
            this.$self = a0Var;
        }

        /* JADX INFO: renamed from: invokeSuspend$lambda-2$lambda-0, reason: not valid java name */
        private static final void m3159invokeSuspend$lambda2$lambda0(a0 a0Var, HmsLocationController hmsLocationController, Location location) {
            Logging.warn$default("Huawei LocationServices getLastLocation returned location: " + location, null, 2, null);
            if (location == null) {
                ((WaiterWithValue) a0Var.f12717a).wake(Boolean.FALSE);
            } else {
                hmsLocationController.lastLocation = location;
                ((WaiterWithValue) a0Var.f12717a).wake(Boolean.TRUE);
            }
        }

        /* JADX INFO: renamed from: invokeSuspend$lambda-2$lambda-1, reason: not valid java name */
        private static final void m3160invokeSuspend$lambda2$lambda1(a0 a0Var, Exception exc) {
            Logging.error("Huawei LocationServices getLastLocation failed!", exc);
            ((WaiterWithValue) a0Var.f12717a).wake(Boolean.FALSE);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return HmsLocationController.this.new AnonymousClass2(this.$wasSuccessful, this.$self, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00a4 A[Catch: all -> 0x0084, TryCatch #0 {all -> 0x0084, blocks: (B:18:0x006e, B:20:0x0074, B:26:0x009e, B:28:0x00a4, B:29:0x00b1, B:25:0x008a), top: B:41:0x006e, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b1 A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #0 {all -> 0x0084, blocks: (B:18:0x006e, B:20:0x0074, B:26:0x009e, B:28:0x00a4, B:29:0x00b1, B:25:0x008a), top: B:41:0x006e, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f7 A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #2 {all -> 0x0028, blocks: (B:7:0x0023, B:33:0x00eb, B:35:0x00f7), top: B:44:0x0023 }] */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 297
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.controller.impl.HmsLocationController.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(q6.a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.controller.impl.HmsLocationController$stop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.controller.impl.HmsLocationController", f = "HmsLocationController.kt", l = {229}, m = "stop")
    public static final class C27621 extends x5.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27621(c<? super C27621> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HmsLocationController.this.stop(this);
        }
    }

    public HmsLocationController(IApplicationService _applicationService) {
        k.e(_applicationService, "_applicationService");
        this._applicationService = _applicationService;
        this.locationHandlerThread = new LocationHandlerThread();
        this.startStopMutex = d.a();
        this.event = new EventProducer<>();
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.event.getHasSubscribers();
    }

    @Override // com.onesignal.location.internal.controller.ILocationController
    public Location getLastLocation() {
        FusedLocationProviderClient fusedLocationProviderClient = this.hmsFusedLocationClient;
        if (fusedLocationProviderClient == null) {
            return null;
        }
        a0 a0Var = new a0();
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(fusedLocationProviderClient, a0Var, null), 1, null);
        return (Location) a0Var.f12717a;
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
            boolean r0 = r8 instanceof com.onesignal.location.internal.controller.impl.HmsLocationController.C27611
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$1 r0 = (com.onesignal.location.internal.controller.impl.HmsLocationController.C27611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$1 r0 = new com.onesignal.location.internal.controller.impl.HmsLocationController$start$1
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
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$2 r5 = new com.onesignal.location.internal.controller.impl.HmsLocationController$start$2
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
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.controller.impl.HmsLocationController.start(v5.c):java.lang.Object");
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
            boolean r0 = r5 instanceof com.onesignal.location.internal.controller.impl.HmsLocationController.C27621
            if (r0 == 0) goto L13
            r0 = r5
            com.onesignal.location.internal.controller.impl.HmsLocationController$stop$1 r0 = (com.onesignal.location.internal.controller.impl.HmsLocationController.C27621) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.location.internal.controller.impl.HmsLocationController$stop$1 r0 = new com.onesignal.location.internal.controller.impl.HmsLocationController$stop$1
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
            com.onesignal.location.internal.controller.impl.HmsLocationController r0 = (com.onesignal.location.internal.controller.impl.HmsLocationController) r0
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
            com.onesignal.location.internal.controller.impl.HmsLocationController$LocationUpdateListener r2 = r0.locationUpdateListener     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L5a
            r2.close()     // Catch: java.lang.Throwable -> L58
            r0.locationUpdateListener = r5     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r0 = move-exception
            goto L6a
        L5a:
            com.huawei.hms.location.FusedLocationProviderClient r2 = r0.hmsFusedLocationClient     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L60
            r0.hmsFusedLocationClient = r5     // Catch: java.lang.Throwable -> L58
        L60:
            r0.lastLocation = r5     // Catch: java.lang.Throwable -> L58
            z6.c r1 = (z6.c) r1
            r1.f(r5)
            q5.x r5 = q5.x.f13520a
            return r5
        L6a:
            z6.c r1 = (z6.c) r1
            r1.f(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.controller.impl.HmsLocationController.stop(v5.c):java.lang.Object");
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
