package com.onesignal.notifications;

import com.ironsource.adqualitysdk.sdk.i.a0;
import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.NotificationsManager;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import com.onesignal.notifications.internal.analytics.impl.FirebaseAnalyticsTracker;
import com.onesignal.notifications.internal.analytics.impl.NoAnalyticsTracker;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.backend.impl.NotificationBackendService;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.badges.impl.BadgeCountUpdater;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.channels.impl.NotificationChannelManager;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.data.impl.NotificationQueryHelper;
import com.onesignal.notifications.internal.data.impl.NotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayer;
import com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer;
import com.onesignal.notifications.internal.generation.INotificationGenerationProcessor;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor;
import com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager;
import com.onesignal.notifications.internal.listeners.DeviceRegistrationListener;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS;
import com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor;
import com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController;
import com.onesignal.notifications.internal.pushtoken.IPushTokenManager;
import com.onesignal.notifications.internal.pushtoken.PushTokenManager;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor;
import com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorADM;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorNone;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor;
import com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationsModule implements IModule {

    /* JADX INFO: renamed from: com.onesignal.notifications.NotificationsModule$register$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public final IAnalyticsTracker invoke(IServiceProvider it) {
            k.e(it, "it");
            return FirebaseAnalyticsTracker.Companion.canTrack() ? new FirebaseAnalyticsTracker((IApplicationService) it.getService(IApplicationService.class), (ConfigModelStore) it.getService(ConfigModelStore.class), (ITime) it.getService(ITime.class)) : new NoAnalyticsTracker();
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.NotificationsModule$register$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // e6.l
        public final Object invoke(IServiceProvider it) {
            k.e(it, "it");
            IDeviceService iDeviceService = (IDeviceService) it.getService(IDeviceService.class);
            return iDeviceService.isFireOSDeviceType() ? new PushRegistratorADM((IApplicationService) it.getService(IApplicationService.class)) : iDeviceService.isAndroidDeviceType() ? iDeviceService.getHasFCMLibrary() ? new PushRegistratorFCM((ConfigModelStore) it.getService(ConfigModelStore.class), (IApplicationService) it.getService(IApplicationService.class), (GooglePlayServicesUpgradePrompt) it.getService(GooglePlayServicesUpgradePrompt.class), iDeviceService) : new PushRegistratorNone() : new PushRegistratorHMS(iDeviceService, (IApplicationService) it.getService(IApplicationService.class));
        }
    }

    @Override // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder builder) {
        k.e(builder, "builder");
        builder.register(NotificationBackendService.class).provides(INotificationBackendService.class);
        builder.register(NotificationRestoreWorkManager.class).provides(INotificationRestoreWorkManager.class);
        builder.register(NotificationQueryHelper.class).provides(INotificationQueryHelper.class);
        a0.k(builder, BadgeCountUpdater.class, IBadgeCountUpdater.class, NotificationRepository.class, INotificationRepository.class);
        a0.k(builder, NotificationGenerationWorkManager.class, INotificationGenerationWorkManager.class, NotificationBundleProcessor.class, INotificationBundleProcessor.class);
        a0.k(builder, NotificationChannelManager.class, INotificationChannelManager.class, NotificationLimitManager.class, INotificationLimitManager.class);
        a0.k(builder, NotificationDisplayer.class, INotificationDisplayer.class, SummaryNotificationDisplayer.class, ISummaryNotificationDisplayer.class);
        a0.k(builder, NotificationDisplayBuilder.class, INotificationDisplayBuilder.class, NotificationGenerationProcessor.class, INotificationGenerationProcessor.class);
        a0.k(builder, NotificationRestoreProcessor.class, INotificationRestoreProcessor.class, NotificationSummaryManager.class, INotificationSummaryManager.class);
        a0.k(builder, NotificationOpenedProcessor.class, INotificationOpenedProcessor.class, NotificationOpenedProcessorHMS.class, INotificationOpenedProcessorHMS.class);
        builder.register(NotificationPermissionController.class).provides(INotificationPermissionController.class);
        builder.register(NotificationLifecycleService.class).provides(INotificationLifecycleService.class).provides(INotificationActivityOpener.class);
        builder.register((e6.l) AnonymousClass1.INSTANCE).provides(IAnalyticsTracker.class);
        builder.register((e6.l) AnonymousClass2.INSTANCE).provides(IPushRegistrator.class).provides(IPushRegistratorCallback.class);
        builder.register(GooglePlayServicesUpgradePrompt.class).provides(GooglePlayServicesUpgradePrompt.class);
        builder.register(PushTokenManager.class).provides(IPushTokenManager.class);
        a0.k(builder, ReceiveReceiptWorkManager.class, IReceiveReceiptWorkManager.class, ReceiveReceiptProcessor.class, IReceiveReceiptProcessor.class);
        a0.k(builder, DeviceRegistrationListener.class, IStartableService.class, NotificationsManager.class, INotificationsManager.class);
    }
}
