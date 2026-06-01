package com.onesignal.location;

import com.ironsource.adqualitysdk.sdk.i.a0;
import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.location.internal.LocationManager;
import com.onesignal.location.internal.background.LocationBackgroundService;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.capture.impl.LocationCapturer;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.impl.FusedLocationApiWrapperImpl;
import com.onesignal.location.internal.controller.impl.GmsLocationController;
import com.onesignal.location.internal.controller.impl.HmsLocationController;
import com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper;
import com.onesignal.location.internal.controller.impl.NullLocationController;
import com.onesignal.location.internal.permissions.LocationPermissionController;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import com.onesignal.location.internal.preferences.impl.LocationPreferencesService;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationModule implements IModule {

    /* JADX INFO: renamed from: com.onesignal.location.LocationModule$register$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public final ILocationController invoke(IServiceProvider it) {
            k.e(it, "it");
            IDeviceService iDeviceService = (IDeviceService) it.getService(IDeviceService.class);
            return (iDeviceService.isAndroidDeviceType() && LocationUtils.INSTANCE.hasGMSLocationLibrary()) ? new GmsLocationController((IApplicationService) it.getService(IApplicationService.class), (IFusedLocationApiWrapper) it.getService(IFusedLocationApiWrapper.class)) : (iDeviceService.isHuaweiDeviceType() && LocationUtils.INSTANCE.hasHMSLocationLibrary()) ? new HmsLocationController((IApplicationService) it.getService(IApplicationService.class)) : new NullLocationController();
        }
    }

    @Override // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder builder) {
        k.e(builder, "builder");
        builder.register(LocationPermissionController.class).provides(LocationPermissionController.class).provides(IStartableService.class);
        builder.register(FusedLocationApiWrapperImpl.class).provides(IFusedLocationApiWrapper.class);
        builder.register((e6.l) AnonymousClass1.INSTANCE).provides(ILocationController.class);
        builder.register(LocationPreferencesService.class).provides(ILocationPreferencesService.class);
        a0.k(builder, LocationCapturer.class, ILocationCapturer.class, LocationBackgroundService.class, IBackgroundService.class);
        builder.register(LocationManager.class).provides(ILocationManager.class).provides(IStartableService.class);
    }
}
