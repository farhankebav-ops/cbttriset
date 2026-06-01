package com.onesignal.core.internal.application.impl;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.application.ActivityLifecycleHandlerBase;
import com.onesignal.core.internal.application.AppEntryAction;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ApplicationService implements IApplicationService, Application.ActivityLifecycleCallbacks, ViewTreeObserver.OnGlobalLayoutListener {
    private Context _appContext;
    private Activity _current;
    private int activityReferences;
    private boolean isActivityChangingConfigurations;
    private boolean nextResumeIsFirstActivity;
    private final EventProducer<IActivityLifecycleHandler> activityLifecycleNotifier = new EventProducer<>();
    private final EventProducer<IApplicationLifecycleHandler> applicationLifecycleNotifier = new EventProducer<>();
    private final EventProducer<ISystemConditionHandler> systemConditionNotifier = new EventProducer<>();
    private AppEntryAction entryState = AppEntryAction.APP_CLOSE;

    /* JADX INFO: renamed from: com.onesignal.core.internal.application.impl.ApplicationService$handleFocus$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IApplicationLifecycleHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IApplicationLifecycleHandler it) {
            k.e(it, "it");
            it.onFocus(false);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.application.impl.ApplicationService$handleLostFocus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26861 extends l implements e6.l {
        public static final C26861 INSTANCE = new C26861();

        public C26861() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IApplicationLifecycleHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IApplicationLifecycleHandler it) {
            k.e(it, "it");
            it.onUnfocused();
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.application.impl.ApplicationService$onActivityStopped$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26871 extends l implements e6.l {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26871(Activity activity) {
            super(1);
            this.$activity = activity;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IActivityLifecycleHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IActivityLifecycleHandler it) {
            k.e(it, "it");
            it.onActivityStopped(this.$activity);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.application.impl.ApplicationService$onGlobalLayout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26881 extends l implements e6.l {
        public static final C26881 INSTANCE = new C26881();

        public C26881() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ISystemConditionHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ISystemConditionHandler it) {
            k.e(it, "it");
            it.systemConditionChanged();
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.application.impl.ApplicationService$onOrientationChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26891 extends l implements e6.l {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26891(Activity activity) {
            super(1);
            this.$activity = activity;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IActivityLifecycleHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IActivityLifecycleHandler it) {
            k.e(it, "it");
            it.onActivityStopped(this.$activity);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.application.impl.ApplicationService$onOrientationChanged$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Activity activity) {
            super(1);
            this.$activity = activity;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IActivityLifecycleHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IActivityLifecycleHandler it) {
            k.e(it, "it");
            it.onActivityAvailable(this.$activity);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.application.impl.ApplicationService", f = "ApplicationService.kt", l = {309}, m = "waitUntilActivityReady")
    public static final class C26901 extends c {
        int label;
        /* synthetic */ Object result;

        public C26901(v5.c<? super C26901> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationService.this.waitUntilActivityReady(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.application.impl.ApplicationService", f = "ApplicationService.kt", l = {238, 269, 296}, m = "waitUntilSystemConditionsAvailable")
    public static final class C26911 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C26911(v5.c<? super C26911> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationService.this.waitUntilSystemConditionsAvailable(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: decorViewReady$lambda-1, reason: not valid java name */
    public static final void m3138decorViewReady$lambda1(final ApplicationService self, final Runnable runnable, final ApplicationService this$0) {
        k.e(self, "$self");
        k.e(runnable, "$runnable");
        k.e(this$0, "this$0");
        self.addActivityLifecycleHandler(new ActivityLifecycleHandlerBase() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$decorViewReady$1$1
            @Override // com.onesignal.core.internal.application.ActivityLifecycleHandlerBase, com.onesignal.core.internal.application.IActivityLifecycleHandler
            public void onActivityAvailable(Activity currentActivity) {
                k.e(currentActivity, "currentActivity");
                this.$self.removeActivityLifecycleHandler(this);
                if (AndroidUtils.INSTANCE.isActivityFullyReady(currentActivity)) {
                    runnable.run();
                } else {
                    this$0.decorViewReady(currentActivity, runnable);
                }
            }
        });
    }

    private final boolean getWasInBackground() {
        return !isInForeground() || this.nextResumeIsFirstActivity;
    }

    private final void handleFocus() {
        if (!getWasInBackground()) {
            Logging.debug$default("ApplicationService.handleFocus: application never lost focus", null, 2, null);
            return;
        }
        Logging.debug$default("ApplicationService.handleFocus: application is now in focus, nextResumeIsFirstActivity=" + this.nextResumeIsFirstActivity, null, 2, null);
        this.nextResumeIsFirstActivity = false;
        if (getEntryState() != AppEntryAction.NOTIFICATION_CLICK) {
            setEntryState(AppEntryAction.APP_OPEN);
        }
        this.applicationLifecycleNotifier.fire(AnonymousClass1.INSTANCE);
    }

    private final void handleLostFocus() {
        if (!isInForeground()) {
            Logging.debug$default("ApplicationService.handleLostFocus: application already out of focus", null, 2, null);
            return;
        }
        Logging.debug$default("ApplicationService.handleLostFocus: application is now out of focus", null, 2, null);
        setEntryState(AppEntryAction.APP_CLOSE);
        this.applicationLifecycleNotifier.fire(C26861.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onOrientationChanged(int i2, Activity activity) {
        if (i2 == 1) {
            Logging.debug$default("ApplicationService.onOrientationChanged: Configuration Orientation Change: PORTRAIT (" + i2 + ") on activity: " + activity, null, 2, null);
        } else if (i2 == 2) {
            Logging.debug$default("ApplicationService.onOrientationChanged: Configuration Orientation Change: LANDSCAPE (" + i2 + ") on activity: " + activity, null, 2, null);
        }
        handleLostFocus();
        this.activityLifecycleNotifier.fire(new C26891(activity));
        this.activityLifecycleNotifier.fire(new AnonymousClass2(activity));
        activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        handleFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: waitUntilActivityReady$lambda-0, reason: not valid java name */
    public static final void m3139waitUntilActivityReady$lambda0(Waiter waiter) {
        k.e(waiter, "$waiter");
        waiter.wake();
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void addActivityLifecycleHandler(IActivityLifecycleHandler handler) {
        k.e(handler, "handler");
        this.activityLifecycleNotifier.subscribe(handler);
        if (getCurrent() != null) {
            Activity current = getCurrent();
            k.b(current);
            handler.onActivityAvailable(current);
        }
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void addApplicationLifecycleHandler(IApplicationLifecycleHandler handler) {
        k.e(handler, "handler");
        this.applicationLifecycleNotifier.subscribe(handler);
        if (getCurrent() != null) {
            handler.onFocus(true);
        }
    }

    public final void decorViewReady(Activity activity, Runnable runnable) {
        k.e(activity, "activity");
        k.e(runnable, "runnable");
        runnable.toString();
        activity.getWindow().getDecorView().post(new androidx.camera.core.processing.c(this, runnable, this, 26));
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public Context getAppContext() {
        Context context = this._appContext;
        k.b(context);
        return context;
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public Activity getCurrent() {
        return this._current;
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public AppEntryAction getEntryState() {
        return this.entryState;
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public boolean isInForeground() {
        return getEntryState().isAppOpen() || getEntryState().isNotificationClick();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        k.e(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityCreated(" + this.activityReferences + ',' + getEntryState() + "): " + activity, null, 2, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        k.e(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityDestroyed(" + this.activityReferences + ',' + getEntryState() + "): " + activity, null, 2, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        k.e(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityPaused(" + this.activityReferences + ',' + getEntryState() + "): " + activity, null, 2, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        k.e(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityResumed(" + this.activityReferences + ',' + getEntryState() + "): " + activity, null, 2, null);
        if (!k.a(getCurrent(), activity)) {
            setCurrent(activity);
        }
        if (!getWasInBackground() || this.isActivityChangingConfigurations) {
            return;
        }
        this.activityReferences = 1;
        handleFocus();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity p02, Bundle p12) {
        k.e(p02, "p0");
        k.e(p12, "p1");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        k.e(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityStarted(" + this.activityReferences + ',' + getEntryState() + "): " + activity, null, 2, null);
        if (k.a(getCurrent(), activity)) {
            return;
        }
        setCurrent(activity);
        if (!getWasInBackground() || this.isActivityChangingConfigurations) {
            this.activityReferences++;
        } else {
            this.activityReferences = 1;
            handleFocus();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        k.e(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityStopped(" + this.activityReferences + ',' + getEntryState() + "): " + activity, null, 2, null);
        boolean zIsChangingConfigurations = activity.isChangingConfigurations();
        this.isActivityChangingConfigurations = zIsChangingConfigurations;
        if (!zIsChangingConfigurations) {
            int i2 = this.activityReferences - 1;
            this.activityReferences = i2;
            if (i2 <= 0) {
                setCurrent(null);
                this.activityReferences = 0;
                handleLostFocus();
            }
        }
        this.activityLifecycleNotifier.fire(new C26871(activity));
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.systemConditionNotifier.fire(C26881.INSTANCE);
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void removeActivityLifecycleHandler(IActivityLifecycleHandler handler) {
        k.e(handler, "handler");
        this.activityLifecycleNotifier.unsubscribe(handler);
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void removeApplicationLifecycleHandler(IApplicationLifecycleHandler handler) {
        k.e(handler, "handler");
        this.applicationLifecycleNotifier.unsubscribe(handler);
    }

    public void setCurrent(Activity activity) {
        this._current = activity;
        Logging.debug$default("ApplicationService: current activity=" + getCurrent(), null, 2, null);
        if (activity != null) {
            this.activityLifecycleNotifier.fire(new ApplicationService$current$1(activity));
            try {
                activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void setEntryState(AppEntryAction appEntryAction) {
        k.e(appEntryAction, "<set-?>");
        this.entryState = appEntryAction;
    }

    public final void start(Context context) {
        k.e(context, "context");
        this._appContext = context;
        Context applicationContext = context.getApplicationContext();
        k.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        application.registerActivityLifecycleCallbacks(this);
        application.registerComponentCallbacks(new ComponentCallbacks() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$start$configuration$1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration newConfig) {
                k.e(newConfig, "newConfig");
                if (this.this$0.getCurrent() != null) {
                    AndroidUtils androidUtils = AndroidUtils.INSTANCE;
                    Activity current = this.this$0.getCurrent();
                    k.b(current);
                    if (androidUtils.hasConfigChangeFlag(current, 128)) {
                        ApplicationService applicationService = this.this$0;
                        int i2 = newConfig.orientation;
                        Activity current2 = applicationService.getCurrent();
                        k.b(current2);
                        applicationService.onOrientationChanged(i2, current2);
                    }
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        });
        boolean z2 = context instanceof Activity;
        boolean z7 = getCurrent() == null;
        if (!z7 || z2) {
            setEntryState(AppEntryAction.APP_OPEN);
            if (z7 && z2) {
                setCurrent((Activity) context);
                this.activityReferences = 1;
                this.nextResumeIsFirstActivity = false;
            }
        } else {
            this.nextResumeIsFirstActivity = true;
            setEntryState(AppEntryAction.APP_CLOSE);
        }
        Logging.debug$default("ApplicationService.init: entryState=" + getEntryState(), null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.core.internal.application.IApplicationService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object waitUntilActivityReady(v5.c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.core.internal.application.impl.ApplicationService.C26901
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1 r0 = (com.onesignal.core.internal.application.impl.ApplicationService.C26901) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1 r0 = new com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            r2.q.z0(r7)
            goto L53
        L27:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L2f:
            r2.q.z0(r7)
            android.app.Activity r7 = r6.getCurrent()
            if (r7 != 0) goto L3b
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        L3b:
            com.onesignal.common.threading.Waiter r2 = new com.onesignal.common.threading.Waiter
            r2.<init>()
            a3.b r4 = new a3.b
            r5 = 21
            r4.<init>(r2, r5)
            r6.decorViewReady(r7, r4)
            r0.label = r3
            java.lang.Object r7 = r2.waitForWake(r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.application.impl.ApplicationService.waitUntilActivityReady(v5.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
    
        if (q6.c0.k(100, r0) == r1) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008c -> B:22:0x005a). Please report as a decompilation issue!!! */
    @Override // com.onesignal.core.internal.application.IApplicationService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object waitUntilSystemConditionsAvailable(v5.c<? super java.lang.Boolean> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable(v5.c):java.lang.Object");
    }
}
