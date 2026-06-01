package com.onesignal.location.internal.permissions;

import android.app.Activity;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.location.R;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationPermissionController implements IRequestPermissionService.PermissionCallback, IStartableService, IEventNotifier<ILocationPermissionChangedHandler> {
    public static final Companion Companion = new Companion(null);
    private static final String PERMISSION_TYPE = "LOCATION";
    private final IApplicationService _applicationService;
    private final IRequestPermissionService _requestPermission;
    private String currPermission;
    private final EventProducer<ILocationPermissionChangedHandler> events;
    private final WaiterWithValue<Boolean> waiter;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.permissions.LocationPermissionController$onAccept$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ILocationPermissionChangedHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ILocationPermissionChangedHandler it) {
            k.e(it, "it");
            it.onLocationPermissionChanged(true);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.location.internal.permissions.LocationPermissionController$onReject$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27631 extends l implements e6.l {
        public static final C27631 INSTANCE = new C27631();

        public C27631() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ILocationPermissionChangedHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ILocationPermissionChangedHandler it) {
            k.e(it, "it");
            it.onLocationPermissionChanged(false);
        }
    }

    public LocationPermissionController(IRequestPermissionService _requestPermission, IApplicationService _applicationService) {
        k.e(_requestPermission, "_requestPermission");
        k.e(_applicationService, "_applicationService");
        this._requestPermission = _requestPermission;
        this._applicationService = _applicationService;
        this.waiter = new WaiterWithValue<>();
        this.events = new EventProducer<>();
        this.currPermission = "";
    }

    private final boolean showFallbackAlertDialog() {
        final Activity current = this._applicationService.getCurrent();
        if (current == null) {
            return false;
        }
        AlertDialogPrepromptForAndroidSettings alertDialogPrepromptForAndroidSettings = AlertDialogPrepromptForAndroidSettings.INSTANCE;
        String string = current.getString(R.string.location_permission_name_for_title);
        k.d(string, "activity.getString(R.str…ermission_name_for_title)");
        String string2 = current.getString(R.string.location_permission_settings_message);
        k.d(string2, "activity.getString(R.str…mission_settings_message)");
        alertDialogPrepromptForAndroidSettings.show(current, string, string2, new AlertDialogPrepromptForAndroidSettings.Callback() { // from class: com.onesignal.location.internal.permissions.LocationPermissionController.showFallbackAlertDialog.1
            @Override // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings.Callback
            public void onAccept() {
                IApplicationService iApplicationService = LocationPermissionController.this._applicationService;
                final LocationPermissionController locationPermissionController = LocationPermissionController.this;
                iApplicationService.addApplicationLifecycleHandler(new ApplicationLifecycleHandlerBase() { // from class: com.onesignal.location.internal.permissions.LocationPermissionController$showFallbackAlertDialog$1$onAccept$1
                    @Override // com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase, com.onesignal.core.internal.application.IApplicationLifecycleHandler
                    public void onFocus(boolean z2) {
                        if (z2) {
                            return;
                        }
                        super.onFocus(false);
                        locationPermissionController._applicationService.removeApplicationLifecycleHandler(this);
                        boolean zHasPermission = AndroidUtils.INSTANCE.hasPermission(locationPermissionController.currPermission, true, locationPermissionController._applicationService);
                        locationPermissionController.waiter.wake(Boolean.valueOf(zHasPermission));
                        locationPermissionController.events.fire(new LocationPermissionController$showFallbackAlertDialog$1$onAccept$1$onFocus$1(zHasPermission));
                    }
                });
                NavigateToAndroidSettingsForLocation.INSTANCE.show(current);
            }

            @Override // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings.Callback
            public void onDecline() {
                LocationPermissionController.this.waiter.wake(Boolean.FALSE);
                LocationPermissionController.this.events.fire(LocationPermissionController$showFallbackAlertDialog$1$onDecline$1.INSTANCE);
            }
        });
        return true;
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback
    public void onAccept() {
        this.waiter.wake(Boolean.TRUE);
        this.events.fire(AnonymousClass1.INSTANCE);
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback
    public void onReject(boolean z2) {
        if (z2 ? showFallbackAlertDialog() : false) {
            return;
        }
        this.waiter.wake(Boolean.FALSE);
        this.events.fire(C27631.INSTANCE);
    }

    public final Object prompt(boolean z2, String str, c<? super Boolean> cVar) {
        this.currPermission = str;
        this._requestPermission.startPrompt(z2, "LOCATION", str, LocationPermissionController.class);
        return this.waiter.waitForWake(cVar);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._requestPermission.registerAsCallback("LOCATION", this);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ILocationPermissionChangedHandler handler) {
        k.e(handler, "handler");
        this.events.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ILocationPermissionChangedHandler handler) {
        k.e(handler, "handler");
        this.events.subscribe(handler);
    }
}
