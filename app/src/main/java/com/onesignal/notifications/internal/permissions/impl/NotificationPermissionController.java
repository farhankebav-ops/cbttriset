package com.onesignal.notifications.internal.permissions.impl;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.Waiter;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.notifications.R;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import e6.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationPermissionController implements IRequestPermissionService.PermissionCallback, INotificationPermissionController {
    private static final String ANDROID_PERMISSION_STRING = "android.permission.POST_NOTIFICATIONS";
    public static final Companion Companion = new Companion(null);
    private static final String PERMISSION_TYPE = "NOTIFICATION";
    private final IApplicationService _application;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IPreferencesService _preferenceService;
    private final IRequestPermissionService _requestPermission;
    private final a0 coroutineScope;
    private boolean enabled;
    private final EventProducer<INotificationPermissionChangedHandler> events;
    private long pollingWaitInterval;
    private final Waiter pollingWaiter;

    @ChecksSdkIntAtLeast(api = 33)
    private final boolean supportsNativePrompt;
    private final WaiterWithValue<Boolean> waiter;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$1", f = "NotificationPermissionController.kt", l = {83}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationPermissionController.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                NotificationPermissionController notificationPermissionController = NotificationPermissionController.this;
                this.label = 1;
                if (notificationPermissionController.pollForPermission(this) == aVar) {
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

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$permissionPromptCompleted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C28061 extends l implements e6.l {
        final /* synthetic */ boolean $enabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28061(boolean z2) {
            super(1);
            this.$enabled = z2;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((INotificationPermissionChangedHandler) obj);
            return x.f13520a;
        }

        public final void invoke(INotificationPermissionChangedHandler it) {
            k.e(it, "it");
            it.onNotificationPermissionChanged(this.$enabled);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController", f = "NotificationPermissionController.kt", l = {112}, m = "pollForPermission")
    public static final class C28071 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C28071(c<? super C28071> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationPermissionController.this.pollForPermission(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        final /* synthetic */ boolean $enabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2) {
            super(1);
            this.$enabled = z2;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((INotificationPermissionChangedHandler) obj);
            return x.f13520a;
        }

        public final void invoke(INotificationPermissionChangedHandler it) {
            k.e(it, "it");
            it.onNotificationPermissionChanged(this.$enabled);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$3", f = "NotificationPermissionController.kt", l = {113}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements p {
        int label;

        public AnonymousClass3(c<? super AnonymousClass3> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationPermissionController.this.new AnonymousClass3(cVar);
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
            Waiter waiter = NotificationPermissionController.this.pollingWaiter;
            this.label = 1;
            Object objWaitForWake = waiter.waitForWake(this);
            return objWaitForWake == aVar ? aVar : objWaitForWake;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<Object> cVar) {
            return ((AnonymousClass3) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$prompt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController", f = "NotificationPermissionController.kt", l = {144, 165}, m = "prompt")
    public static final class C28081 extends x5.c {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C28081(c<? super C28081> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationPermissionController.this.prompt(false, this);
        }
    }

    public NotificationPermissionController(IApplicationService _application, IRequestPermissionService _requestPermission, IApplicationService _applicationService, IPreferencesService _preferenceService, ConfigModelStore _configModelStore) {
        k.e(_application, "_application");
        k.e(_requestPermission, "_requestPermission");
        k.e(_applicationService, "_applicationService");
        k.e(_preferenceService, "_preferenceService");
        k.e(_configModelStore, "_configModelStore");
        this._application = _application;
        this._requestPermission = _requestPermission;
        this._applicationService = _applicationService;
        this._preferenceService = _preferenceService;
        this._configModelStore = _configModelStore;
        this.waiter = new WaiterWithValue<>();
        this.pollingWaiter = new Waiter();
        this.events = new EventProducer<>();
        v6.c cVarB = c0.b(c0.w("NotificationPermissionController"));
        this.coroutineScope = cVarB;
        this.enabled = notificationsEnabled();
        _requestPermission.registerAsCallback(PERMISSION_TYPE, this);
        this.pollingWaitInterval = _configModelStore.getModel().getBackgroundFetchNotificationPermissionInterval();
        registerPollingLifecycleListener();
        c0.u(cVarB, null, new AnonymousClass1(null), 3);
        this.supportsNativePrompt = Build.VERSION.SDK_INT > 32 && AndroidUtils.INSTANCE.getTargetSdkVersion(_application.getAppContext()) > 32;
    }

    private final boolean notificationsEnabled() {
        return NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, this._application.getAppContext(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void permissionPromptCompleted(boolean z2) throws Exception {
        this.enabled = z2;
        this.waiter.wake(Boolean.valueOf(z2));
        this.events.fire(new C28061(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object pollForPermission(v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.C28071
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$1 r0 = (com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.C28071) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$1 r0 = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController r2 = (com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController) r2
            r2.q.z0(r8)
            goto L37
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L33:
            r2.q.z0(r8)
            r2 = r7
        L37:
            boolean r8 = r2.notificationsEnabled()
            boolean r4 = r2.enabled
            if (r4 == r8) goto L4b
            r2.enabled = r8
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler> r4 = r2.events
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$2 r5 = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$2
            r5.<init>(r8)
            r4.fire(r5)
        L4b:
            long r4 = r2.pollingWaitInterval
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$3 r8 = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$3
            r6 = 0
            r8.<init>(r6)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = q6.c0.J(r4, r8, r0)
            if (r8 != r1) goto L37
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.pollForPermission(v5.c):java.lang.Object");
    }

    private final void registerPollingLifecycleListener() {
        this._applicationService.addApplicationLifecycleHandler(new ApplicationLifecycleHandlerBase() { // from class: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.registerPollingLifecycleListener.1
            @Override // com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase, com.onesignal.core.internal.application.IApplicationLifecycleHandler
            public void onFocus(boolean z2) {
                super.onFocus(z2);
                NotificationPermissionController notificationPermissionController = NotificationPermissionController.this;
                notificationPermissionController.pollingWaitInterval = notificationPermissionController._configModelStore.getModel().getForegroundFetchNotificationPermissionInterval();
                NotificationPermissionController.this.pollingWaiter.wake();
            }

            @Override // com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase, com.onesignal.core.internal.application.IApplicationLifecycleHandler
            public void onUnfocused() {
                super.onUnfocused();
                NotificationPermissionController notificationPermissionController = NotificationPermissionController.this;
                notificationPermissionController.pollingWaitInterval = notificationPermissionController._configModelStore.getModel().getBackgroundFetchNotificationPermissionInterval();
            }
        });
    }

    private final boolean showFallbackAlertDialog() {
        final Activity current = this._application.getCurrent();
        if (current == null) {
            return false;
        }
        AlertDialogPrepromptForAndroidSettings alertDialogPrepromptForAndroidSettings = AlertDialogPrepromptForAndroidSettings.INSTANCE;
        String string = current.getString(R.string.notification_permission_name_for_title);
        k.d(string, "activity.getString(R.str…ermission_name_for_title)");
        String string2 = current.getString(R.string.notification_permission_settings_message);
        k.d(string2, "activity.getString(R.str…mission_settings_message)");
        alertDialogPrepromptForAndroidSettings.show(current, string, string2, new AlertDialogPrepromptForAndroidSettings.Callback() { // from class: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.showFallbackAlertDialog.1
            @Override // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings.Callback
            public void onAccept() {
                IApplicationService iApplicationService = NotificationPermissionController.this._applicationService;
                final NotificationPermissionController notificationPermissionController = NotificationPermissionController.this;
                iApplicationService.addApplicationLifecycleHandler(new ApplicationLifecycleHandlerBase() { // from class: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$showFallbackAlertDialog$1$onAccept$1
                    @Override // com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase, com.onesignal.core.internal.application.IApplicationLifecycleHandler
                    public void onFocus(boolean z2) throws Exception {
                        if (z2) {
                            return;
                        }
                        super.onFocus(false);
                        notificationPermissionController._applicationService.removeApplicationLifecycleHandler(this);
                        notificationPermissionController.permissionPromptCompleted(AndroidUtils.INSTANCE.hasPermission("android.permission.POST_NOTIFICATIONS", true, notificationPermissionController._applicationService));
                    }
                });
                NavigateToAndroidSettingsForNotifications.INSTANCE.show(current);
            }

            @Override // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings.Callback
            public void onDecline() throws Exception {
                NotificationPermissionController.this.permissionPromptCompleted(false);
            }
        });
        return true;
    }

    @Override // com.onesignal.notifications.internal.permissions.INotificationPermissionController
    public boolean getCanRequestPermission() {
        k.b(this._preferenceService.getBool(PreferenceStores.ONESIGNAL, "USER_RESOLVED_PERMISSION_android.permission.POST_NOTIFICATIONS", Boolean.FALSE));
        return !r0.booleanValue();
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    public final boolean getSupportsNativePrompt() {
        return this.supportsNativePrompt;
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback
    public void onAccept() throws Exception {
        permissionPromptCompleted(true);
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback
    public void onReject(boolean z2) throws Exception {
        if (z2 ? showFallbackAlertDialog() : false) {
            return;
        }
        permissionPromptCompleted(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.permissions.INotificationPermissionController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object prompt(boolean r8, v5.c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.C28081
            if (r0 == 0) goto L13
            r0 = r9
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$prompt$1 r0 = (com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.C28081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$prompt$1 r0 = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$prompt$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            r2.q.z0(r9)
            return r9
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            boolean r8 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController r2 = (com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController) r2
            r2.q.z0(r9)
            goto L4d
        L3c:
            r2.q.z0(r9)
            r0.L$0 = r7
            r0.Z$0 = r8
            r0.label = r4
            java.lang.Object r9 = q6.c0.K(r0)
            if (r9 != r1) goto L4c
            goto L78
        L4c:
            r2 = r7
        L4d:
            boolean r9 = r2.notificationsEnabled()
            if (r9 == 0) goto L56
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            return r8
        L56:
            boolean r9 = r2.supportsNativePrompt
            if (r9 == 0) goto L66
            com.onesignal.core.internal.permissions.IRequestPermissionService r9 = r2._requestPermission
            java.lang.String r4 = "android.permission.POST_NOTIFICATIONS"
            java.lang.Class<com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController> r5 = com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.class
            java.lang.String r6 = "NOTIFICATION"
            r9.startPrompt(r8, r6, r4, r5)
            goto L6b
        L66:
            if (r8 == 0) goto L7a
            r2.showFallbackAlertDialog()
        L6b:
            com.onesignal.common.threading.WaiterWithValue<java.lang.Boolean> r8 = r2.waiter
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r8 = r8.waitForWake(r0)
            if (r8 != r1) goto L79
        L78:
            return r1
        L79:
            return r8
        L7a:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.prompt(boolean, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(INotificationPermissionChangedHandler handler) {
        k.e(handler, "handler");
        this.events.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(INotificationPermissionChangedHandler handler) {
        k.e(handler, "handler");
        this.events.subscribe(handler);
    }
}
