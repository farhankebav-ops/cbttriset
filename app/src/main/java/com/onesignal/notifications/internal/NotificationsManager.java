package com.onesignal.notifications.internal;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import com.vungle.ads.internal.protos.Sdk;
import e6.l;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;
import v5.c;
import v6.n;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationsManager implements INotificationsManager, INotificationPermissionChangedHandler, IApplicationLifecycleHandler {
    private final IApplicationService _applicationService;
    private final INotificationRepository _notificationDataController;
    private final INotificationLifecycleService _notificationLifecycleService;
    private final INotificationPermissionController _notificationPermissionController;
    private final INotificationRestoreWorkManager _notificationRestoreWorkManager;
    private final INotificationSummaryManager _summaryManager;
    private boolean permission;
    private final EventProducer<IPermissionObserver> permissionChangedNotifier;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.NotificationsManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.NotificationsManager$1", f = "NotificationsManager.kt", l = {Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return NotificationsManager.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                INotificationRepository iNotificationRepository = NotificationsManager.this._notificationDataController;
                this.label = 1;
                if (iNotificationRepository.deleteExpiredNotifications(this) == aVar) {
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

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.NotificationsManager$clearAllNotifications$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.NotificationsManager$clearAllNotifications$1", f = "NotificationsManager.kt", l = {126}, m = "invokeSuspend")
    public static final class C27651 extends i implements l {
        int label;

        public C27651(c<? super C27651> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return NotificationsManager.this.new C27651(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                INotificationRepository iNotificationRepository = NotificationsManager.this._notificationDataController;
                this.label = 1;
                if (iNotificationRepository.markAsDismissedForOutstanding(this) == aVar) {
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
            return ((C27651) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.NotificationsManager$removeGroupedNotifications$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.NotificationsManager$removeGroupedNotifications$1", f = "NotificationsManager.kt", l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "invokeSuspend")
    public static final class C27661 extends i implements l {
        final /* synthetic */ String $group;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27661(String str, c<? super C27661> cVar) {
            super(1, cVar);
            this.$group = str;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return NotificationsManager.this.new C27661(this.$group, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                INotificationRepository iNotificationRepository = NotificationsManager.this._notificationDataController;
                String str = this.$group;
                this.label = 1;
                if (iNotificationRepository.markAsDismissedForGroup(str, this) == aVar) {
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
            return ((C27661) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.NotificationsManager$removeNotification$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.NotificationsManager$removeNotification$1", f = "NotificationsManager.kt", l = {108, 109}, m = "invokeSuspend")
    public static final class C27671 extends i implements l {
        final /* synthetic */ int $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27671(int i2, c<? super C27671> cVar) {
            super(1, cVar);
            this.$id = i2;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return NotificationsManager.this.new C27671(this.$id, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        
            if (r5.updatePossibleDependentSummaryOnDismiss(r1, r4) == r0) goto L17;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                r2.q.z0(r5)
                goto L49
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L18:
                r2.q.z0(r5)
                goto L30
            L1c:
                r2.q.z0(r5)
                com.onesignal.notifications.internal.NotificationsManager r5 = com.onesignal.notifications.internal.NotificationsManager.this
                com.onesignal.notifications.internal.data.INotificationRepository r5 = com.onesignal.notifications.internal.NotificationsManager.access$get_notificationDataController$p(r5)
                int r1 = r4.$id
                r4.label = r3
                java.lang.Object r5 = r5.markAsDismissed(r1, r4)
                if (r5 != r0) goto L30
                goto L48
            L30:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L49
                com.onesignal.notifications.internal.NotificationsManager r5 = com.onesignal.notifications.internal.NotificationsManager.this
                com.onesignal.notifications.internal.summary.INotificationSummaryManager r5 = com.onesignal.notifications.internal.NotificationsManager.access$get_summaryManager$p(r5)
                int r1 = r4.$id
                r4.label = r2
                java.lang.Object r5 = r5.updatePossibleDependentSummaryOnDismiss(r1, r4)
                if (r5 != r0) goto L49
            L48:
                return r0
            L49:
                q5.x r5 = q5.x.f13520a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.NotificationsManager.C27671.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((C27671) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.NotificationsManager$requestPermission$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.NotificationsManager$requestPermission$2", f = "NotificationsManager.kt", l = {90}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ boolean $fallbackToSettings;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$fallbackToSettings = z2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationsManager.this.new AnonymousClass2(this.$fallbackToSettings, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            INotificationPermissionController iNotificationPermissionController = NotificationsManager.this._notificationPermissionController;
            boolean z2 = this.$fallbackToSettings;
            this.label = 1;
            Object objPrompt = iNotificationPermissionController.prompt(z2, this);
            return objPrompt == aVar ? aVar : objPrompt;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super Boolean> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.NotificationsManager$setPermissionStatusAndFire$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27681 extends kotlin.jvm.internal.l implements l {
        final /* synthetic */ boolean $isEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27681(boolean z2) {
            super(1);
            this.$isEnabled = z2;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IPermissionObserver) obj);
            return x.f13520a;
        }

        public final void invoke(IPermissionObserver it) {
            k.e(it, "it");
            it.onNotificationPermissionChange(this.$isEnabled);
        }
    }

    public NotificationsManager(IApplicationService _applicationService, INotificationPermissionController _notificationPermissionController, INotificationRestoreWorkManager _notificationRestoreWorkManager, INotificationLifecycleService _notificationLifecycleService, INotificationRepository _notificationDataController, INotificationSummaryManager _summaryManager) {
        k.e(_applicationService, "_applicationService");
        k.e(_notificationPermissionController, "_notificationPermissionController");
        k.e(_notificationRestoreWorkManager, "_notificationRestoreWorkManager");
        k.e(_notificationLifecycleService, "_notificationLifecycleService");
        k.e(_notificationDataController, "_notificationDataController");
        k.e(_summaryManager, "_summaryManager");
        this._applicationService = _applicationService;
        this._notificationPermissionController = _notificationPermissionController;
        this._notificationRestoreWorkManager = _notificationRestoreWorkManager;
        this._notificationLifecycleService = _notificationLifecycleService;
        this._notificationDataController = _notificationDataController;
        this._summaryManager = _summaryManager;
        this.permission = NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, _applicationService.getAppContext(), null, 2, null);
        this.permissionChangedNotifier = new EventProducer<>();
        _applicationService.addApplicationLifecycleHandler(this);
        _notificationPermissionController.subscribe(this);
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(null), 1, null);
    }

    private final void refreshNotificationState() {
        this._notificationRestoreWorkManager.beginEnqueueingWork(this._applicationService.getAppContext(), false);
        setPermissionStatusAndFire(NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, this._applicationService.getAppContext(), null, 2, null));
    }

    private final void setPermissionStatusAndFire(boolean z2) {
        boolean zMo3168getPermission = mo3168getPermission();
        setPermission(z2);
        if (zMo3168getPermission != z2) {
            this.permissionChangedNotifier.fireOnMain(new C27681(z2));
        }
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: addClickListener */
    public void mo3163addClickListener(INotificationClickListener listener) {
        k.e(listener, "listener");
        Logging.debug$default("NotificationsManager.addClickListener(handler: " + listener + ')', null, 2, null);
        this._notificationLifecycleService.addExternalClickListener(listener);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: addForegroundLifecycleListener */
    public void mo3164addForegroundLifecycleListener(INotificationLifecycleListener listener) {
        k.e(listener, "listener");
        Logging.debug$default("NotificationsManager.addForegroundLifecycleListener(listener: " + listener + ')', null, 2, null);
        this._notificationLifecycleService.addExternalForegroundLifecycleListener(listener);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: addPermissionObserver */
    public void mo3165addPermissionObserver(IPermissionObserver observer) {
        k.e(observer, "observer");
        Logging.debug$default("NotificationsManager.addPermissionObserver(observer: " + observer + ')', null, 2, null);
        this.permissionChangedNotifier.subscribe(observer);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: clearAllNotifications */
    public void mo3166clearAllNotifications() {
        Logging.debug$default("NotificationsManager.clearAllNotifications()", null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27651(null), 1, null);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: getCanRequestPermission */
    public boolean mo3167getCanRequestPermission() {
        return this._notificationPermissionController.getCanRequestPermission();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: getPermission */
    public boolean mo3168getPermission() {
        return this.permission;
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus(boolean z2) {
        refreshNotificationState();
    }

    @Override // com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler
    public void onNotificationPermissionChanged(boolean z2) {
        setPermissionStatusAndFire(z2);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removeClickListener */
    public void mo3169removeClickListener(INotificationClickListener listener) {
        k.e(listener, "listener");
        Logging.debug$default("NotificationsManager.removeClickListener(listener: " + listener + ')', null, 2, null);
        this._notificationLifecycleService.removeExternalClickListener(listener);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removeForegroundLifecycleListener */
    public void mo3170removeForegroundLifecycleListener(INotificationLifecycleListener listener) {
        k.e(listener, "listener");
        Logging.debug$default("NotificationsManager.removeForegroundLifecycleListener(listener: " + listener + ')', null, 2, null);
        this._notificationLifecycleService.removeExternalForegroundLifecycleListener(listener);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removeGroupedNotifications */
    public void mo3171removeGroupedNotifications(String group) {
        k.e(group, "group");
        Logging.debug$default("NotificationsManager.removeGroupedNotifications(group: " + group + ')', null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27661(group, null), 1, null);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removeNotification */
    public void mo3172removeNotification(int i2) {
        Logging.debug$default("NotificationsManager.removeNotification(id: " + i2 + ')', null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27671(i2, null), 1, null);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removePermissionObserver */
    public void mo3173removePermissionObserver(IPermissionObserver observer) {
        k.e(observer, "observer");
        Logging.debug$default("NotificationsManager.removePermissionObserver(observer: " + observer + ')', null, 2, null);
        this.permissionChangedNotifier.unsubscribe(observer);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    public Object requestPermission(boolean z2, c<? super Boolean> cVar) {
        Logging.debug$default("NotificationsManager.requestPermission()", null, 2, null);
        x6.e eVar = m0.f13566a;
        return c0.H(new AnonymousClass2(z2, null), n.f17641a, cVar);
    }

    public void setPermission(boolean z2) {
        this.permission = z2;
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }
}
