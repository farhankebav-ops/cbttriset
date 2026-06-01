package com.onesignal.location.internal;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.ILocationManager;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationConstants;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.permissions.ILocationPermissionChangedHandler;
import com.onesignal.location.internal.permissions.LocationPermissionController;
import e6.l;
import e6.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.w;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationManager implements ILocationManager, IStartableService, ILocationPermissionChangedHandler {
    private final IApplicationService _applicationService;
    private final ILocationCapturer _capturer;
    private boolean _isShared;
    private final ILocationController _locationController;
    private final LocationPermissionController _locationPermissionController;
    private final IPreferencesService _prefs;

    /* JADX INFO: renamed from: com.onesignal.location.internal.LocationManager$onLocationPermissionChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.LocationManager$onLocationPermissionChanged$1", f = "LocationManager.kt", l = {53}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return LocationManager.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                LocationManager locationManager = LocationManager.this;
                this.label = 1;
                if (locationManager.startGetLocation(this) == aVar) {
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

    /* JADX INFO: renamed from: com.onesignal.location.internal.LocationManager$requestPermission$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.LocationManager", f = "LocationManager.kt", l = {79}, m = "requestPermission")
    public static final class C27561 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27561(c<? super C27561> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationManager.this.requestPermission(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.LocationManager$requestPermission$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.LocationManager$requestPermission$2", f = "LocationManager.kt", l = {109, 150, ModuleDescriptor.MODULE_VERSION, 158}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ w $result;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(w wVar, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$result = wVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return LocationManager.this.new AnonymousClass2(this.$result, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:57:0x010f, code lost:
        
            if (r2.startGetLocation(r16) == r1) goto L58;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 277
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.LocationManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<Object> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.LocationManager$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.LocationManager$start$1", f = "LocationManager.kt", l = {45}, m = "invokeSuspend")
    public static final class C27571 extends i implements l {
        int label;

        public C27571(c<? super C27571> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return LocationManager.this.new C27571(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                LocationManager locationManager = LocationManager.this;
                this.label = 1;
                if (locationManager.startGetLocation(this) == aVar) {
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
            return ((C27571) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.LocationManager$startGetLocation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.location.internal.LocationManager", f = "LocationManager.kt", l = {195}, m = "startGetLocation")
    public static final class C27581 extends x5.c {
        int label;
        /* synthetic */ Object result;

        public C27581(c<? super C27581> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationManager.this.startGetLocation(this);
        }
    }

    public LocationManager(IApplicationService _applicationService, ILocationCapturer _capturer, ILocationController _locationController, LocationPermissionController _locationPermissionController, IPreferencesService _prefs) {
        k.e(_applicationService, "_applicationService");
        k.e(_capturer, "_capturer");
        k.e(_locationController, "_locationController");
        k.e(_locationPermissionController, "_locationPermissionController");
        k.e(_prefs, "_prefs");
        this._applicationService = _applicationService;
        this._capturer = _capturer;
        this._locationController = _locationController;
        this._locationPermissionController = _locationPermissionController;
        this._prefs = _prefs;
        Boolean bool = _prefs.getBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_LOCATION_SHARED, Boolean.FALSE);
        k.b(bool);
        this._isShared = bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object backgroundLocationPermissionLogic(boolean z2, c<? super Boolean> cVar) {
        return AndroidUtils.INSTANCE.hasPermission(LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING, false, this._applicationService) ? this._locationPermissionController.prompt(z2, LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING, cVar) : Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startGetLocation(v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.onesignal.location.internal.LocationManager.C27581
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.location.internal.LocationManager$startGetLocation$1 r0 = (com.onesignal.location.internal.LocationManager.C27581) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.location.internal.LocationManager$startGetLocation$1 r0 = new com.onesignal.location.internal.LocationManager$startGetLocation$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            q5.x r4 = q5.x.f13520a
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L35
            if (r2 != r5) goto L2d
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L2b
            goto L4f
        L2b:
            r8 = move-exception
            goto L5d
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            r2.q.z0(r8)
            boolean r8 = r7.isShared()
            if (r8 != 0) goto L3f
            return r4
        L3f:
            java.lang.String r8 = "LocationManager.startGetLocation()"
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r6, r3, r6)
            com.onesignal.location.internal.controller.ILocationController r8 = r7._locationController     // Catch: java.lang.Throwable -> L2b
            r0.label = r5     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r8 = r8.start(r0)     // Catch: java.lang.Throwable -> L2b
            if (r8 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L2b
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L2b
            if (r8 != 0) goto L62
            java.lang.String r8 = "LocationManager.startGetLocation: not possible, no location dependency found"
            com.onesignal.debug.internal.logging.Logging.warn$default(r8, r6, r3, r6)     // Catch: java.lang.Throwable -> L2b
            goto L62
        L5d:
            java.lang.String r0 = "LocationManager.startGetLocation: Location permission exists but there was an error initializing: "
            com.onesignal.debug.internal.logging.Logging.warn(r0, r8)
        L62:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.LocationManager.startGetLocation(v5.c):java.lang.Object");
    }

    @Override // com.onesignal.location.ILocationManager
    public boolean isShared() {
        return this._isShared;
    }

    @Override // com.onesignal.location.internal.permissions.ILocationPermissionChangedHandler
    public void onLocationPermissionChanged(boolean z2) {
        if (z2) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(null), 1, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.location.ILocationManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object requestPermission(v5.c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.location.internal.LocationManager.C27561
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.location.internal.LocationManager$requestPermission$1 r0 = (com.onesignal.location.internal.LocationManager.C27561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.location.internal.LocationManager$requestPermission$1 r0 = new com.onesignal.location.internal.LocationManager$requestPermission$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.w r0 = (kotlin.jvm.internal.w) r0
            r2.q.z0(r7)
            goto L58
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L33:
            r2.q.z0(r7)
            com.onesignal.debug.LogLevel r7 = com.onesignal.debug.LogLevel.DEBUG
            java.lang.String r2 = "LocationManager.requestPermission()"
            com.onesignal.debug.internal.logging.Logging.log(r7, r2)
            kotlin.jvm.internal.w r7 = new kotlin.jvm.internal.w
            r7.<init>()
            x6.e r2 = q6.m0.f13566a
            r6.c r2 = v6.n.f17641a
            com.onesignal.location.internal.LocationManager$requestPermission$2 r4 = new com.onesignal.location.internal.LocationManager$requestPermission$2
            r5 = 0
            r4.<init>(r7, r5)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = q6.c0.H(r4, r2, r0)
            if (r0 != r1) goto L57
            return r1
        L57:
            r0 = r7
        L58:
            boolean r7 = r0.f12728a
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.LocationManager.requestPermission(v5.c):java.lang.Object");
    }

    @Override // com.onesignal.location.ILocationManager
    public void setShared(boolean z2) {
        Logging.debug$default("LocationManager.setIsShared(value: " + z2 + ')', null, 2, null);
        this._prefs.saveBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_LOCATION_SHARED, Boolean.valueOf(z2));
        this._isShared = z2;
        onLocationPermissionChanged(z2);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._locationPermissionController.subscribe((ILocationPermissionChangedHandler) this);
        if (LocationUtils.INSTANCE.hasLocationPermission(this._applicationService.getAppContext())) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new C27571(null), 1, null);
        }
    }
}
