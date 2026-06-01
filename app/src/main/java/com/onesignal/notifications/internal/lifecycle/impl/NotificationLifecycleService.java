package com.onesignal.notifications.internal.lifecycle.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.events.CallbackProducer;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationReceivedEvent;
import com.onesignal.notifications.INotificationServiceExtension;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.common.GenerateNotificationOpenIntentFromPushPayload;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.common.OSNotificationOpenAppSettings;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import e6.p;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.x;
import r2.q;
import r5.i;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationLifecycleService implements INotificationLifecycleService, INotificationActivityOpener {
    private final IAnalyticsTracker _analyticsTracker;
    private final IApplicationService _applicationService;
    private final INotificationBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IInfluenceManager _influenceManager;
    private final IReceiveReceiptWorkManager _receiveReceiptWorkManager;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private final EventProducer<INotificationClickListener> extOpenedCallback;
    private final CallbackProducer<INotificationServiceExtension> extRemoteReceivedCallback;
    private final EventProducer<INotificationLifecycleListener> extWillShowInForegroundCallback;
    private final CallbackProducer<INotificationLifecycleCallback> intLifecycleCallback;
    private final Set<String> postedOpenedNotifIds;
    private final i unprocessedOpenedNotifs;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$addExternalClickListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ NotificationClickEvent $openedResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(NotificationClickEvent notificationClickEvent) {
            super(1);
            this.$openedResult = notificationClickEvent;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((INotificationClickListener) obj);
            return x.f13520a;
        }

        public final void invoke(INotificationClickListener it) {
            k.e(it, "it");
            it.onClick(this.$openedResult);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService", f = "NotificationLifecycleService.kt", l = {120}, m = "canOpenNotification")
    public static final class C27951 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27951(v5.c<? super C27951> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationLifecycleService.this.canOpenNotification(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$2", f = "NotificationLifecycleService.kt", l = {120}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends x5.i implements p {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ w $canOpen;
        final /* synthetic */ JSONObject $data;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(w wVar, Activity activity, JSONObject jSONObject, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$canOpen = wVar;
            this.$activity = activity;
            this.$data = jSONObject;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$canOpen, this.$activity, this.$data, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // e6.p
        public final Object invoke(INotificationLifecycleCallback iNotificationLifecycleCallback, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(iNotificationLifecycleCallback, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w wVar;
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                INotificationLifecycleCallback iNotificationLifecycleCallback = (INotificationLifecycleCallback) this.L$0;
                w wVar2 = this.$canOpen;
                Activity activity = this.$activity;
                JSONObject jSONObject = this.$data;
                this.L$0 = wVar2;
                this.label = 1;
                obj = iNotificationLifecycleCallback.canOpenNotification(activity, jSONObject, this);
                if (obj == aVar) {
                    return aVar;
                }
                wVar = wVar2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                wVar = (w) this.L$0;
                q.z0(obj);
            }
            wVar.f12728a = ((Boolean) obj).booleanValue();
            return x.f13520a;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService", f = "NotificationLifecycleService.kt", l = {92}, m = "canReceiveNotification")
    public static final class C27961 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27961(v5.c<? super C27961> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationLifecycleService.this.canReceiveNotification(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$2", f = "NotificationLifecycleService.kt", l = {92}, m = "invokeSuspend")
    public static final class C27972 extends x5.i implements p {
        final /* synthetic */ w $canReceive;
        final /* synthetic */ JSONObject $jsonPayload;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27972(w wVar, JSONObject jSONObject, v5.c<? super C27972> cVar) {
            super(2, cVar);
            this.$canReceive = wVar;
            this.$jsonPayload = jSONObject;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            C27972 c27972 = new C27972(this.$canReceive, this.$jsonPayload, cVar);
            c27972.L$0 = obj;
            return c27972;
        }

        @Override // e6.p
        public final Object invoke(INotificationLifecycleCallback iNotificationLifecycleCallback, v5.c<? super x> cVar) {
            return ((C27972) create(iNotificationLifecycleCallback, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w wVar;
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                INotificationLifecycleCallback iNotificationLifecycleCallback = (INotificationLifecycleCallback) this.L$0;
                w wVar2 = this.$canReceive;
                JSONObject jSONObject = this.$jsonPayload;
                this.L$0 = wVar2;
                this.label = 1;
                obj = iNotificationLifecycleCallback.canReceiveNotification(jSONObject, this);
                if (obj == aVar) {
                    return aVar;
                }
                wVar = wVar2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                wVar = (w) this.L$0;
                q.z0(obj);
            }
            wVar.f12728a = ((Boolean) obj).booleanValue();
            return x.f13520a;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$externalNotificationWillShowInForeground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27981 extends l implements e6.l {
        final /* synthetic */ INotificationWillDisplayEvent $willDisplayEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27981(INotificationWillDisplayEvent iNotificationWillDisplayEvent) {
            super(1);
            this.$willDisplayEvent = iNotificationWillDisplayEvent;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((INotificationLifecycleListener) obj);
            return x.f13520a;
        }

        public final void invoke(INotificationLifecycleListener it) {
            k.e(it, "it");
            it.onWillDisplay(this.$willDisplayEvent);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$externalRemoteNotificationReceived$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27991 extends l implements e6.l {
        final /* synthetic */ INotificationReceivedEvent $notificationReceivedEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27991(INotificationReceivedEvent iNotificationReceivedEvent) {
            super(1);
            this.$notificationReceivedEvent = iNotificationReceivedEvent;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((INotificationServiceExtension) obj);
            return x.f13520a;
        }

        public final void invoke(INotificationServiceExtension it) {
            k.e(it, "it");
            it.onNotificationReceived(this.$notificationReceivedEvent);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService", f = "NotificationLifecycleService.kt", l = {173}, m = "notificationOpened")
    public static final class C28001 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C28001(v5.c<? super C28001> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationLifecycleService.this.notificationOpened(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$2", f = "NotificationLifecycleService.kt", l = {144}, m = "invokeSuspend")
    public static final class C28012 extends x5.i implements e6.l {
        final /* synthetic */ String $appId;
        final /* synthetic */ IDeviceService.DeviceType $deviceType;
        final /* synthetic */ String $notificationId;
        final /* synthetic */ String $subscriptionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28012(String str, String str2, String str3, IDeviceService.DeviceType deviceType, v5.c<? super C28012> cVar) {
            super(1, cVar);
            this.$appId = str;
            this.$notificationId = str2;
            this.$subscriptionId = str3;
            this.$deviceType = deviceType;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return NotificationLifecycleService.this.new C28012(this.$appId, this.$notificationId, this.$subscriptionId, this.$deviceType, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    q.z0(obj);
                    INotificationBackendService iNotificationBackendService = NotificationLifecycleService.this._backend;
                    String str = this.$appId;
                    String str2 = this.$notificationId;
                    String str3 = this.$subscriptionId;
                    IDeviceService.DeviceType deviceType = this.$deviceType;
                    this.label = 1;
                    if (iNotificationBackendService.updateNotificationAsOpened(str, str2, str3, deviceType, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                }
            } catch (BackendException e) {
                Logging.error$default("Notification opened confirmation failed with statusCode: " + e.getStatusCode() + " response: " + e.getResponse(), null, 2, null);
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C28012) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass3 extends l implements e6.l {
        final /* synthetic */ NotificationClickEvent $openResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(NotificationClickEvent notificationClickEvent) {
            super(1);
            this.$openResult = notificationClickEvent;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((INotificationClickListener) obj);
            return x.f13520a;
        }

        public final void invoke(INotificationClickListener it) {
            k.e(it, "it");
            it.onClick(this.$openResult);
        }
    }

    public NotificationLifecycleService(IApplicationService _applicationService, ITime _time, ConfigModelStore _configModelStore, IInfluenceManager _influenceManager, ISubscriptionManager _subscriptionManager, IDeviceService _deviceService, INotificationBackendService _backend, IReceiveReceiptWorkManager _receiveReceiptWorkManager, IAnalyticsTracker _analyticsTracker) {
        k.e(_applicationService, "_applicationService");
        k.e(_time, "_time");
        k.e(_configModelStore, "_configModelStore");
        k.e(_influenceManager, "_influenceManager");
        k.e(_subscriptionManager, "_subscriptionManager");
        k.e(_deviceService, "_deviceService");
        k.e(_backend, "_backend");
        k.e(_receiveReceiptWorkManager, "_receiveReceiptWorkManager");
        k.e(_analyticsTracker, "_analyticsTracker");
        this._applicationService = _applicationService;
        this._time = _time;
        this._configModelStore = _configModelStore;
        this._influenceManager = _influenceManager;
        this._subscriptionManager = _subscriptionManager;
        this._deviceService = _deviceService;
        this._backend = _backend;
        this._receiveReceiptWorkManager = _receiveReceiptWorkManager;
        this._analyticsTracker = _analyticsTracker;
        this.intLifecycleCallback = new CallbackProducer<>();
        this.extRemoteReceivedCallback = new CallbackProducer<>();
        this.extWillShowInForegroundCallback = new EventProducer<>();
        this.extOpenedCallback = new EventProducer<>();
        this.unprocessedOpenedNotifs = new i();
        this.postedOpenedNotifIds = new LinkedHashSet();
        setupNotificationServiceExtension(_applicationService.getAppContext());
    }

    private final String getLatestNotificationId(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject;
        if (jSONArray.length() > 0) {
            Object obj = jSONArray.get(0);
            k.c(obj, "null cannot be cast to non-null type org.json.JSONObject");
            jSONObject = (JSONObject) obj;
        } else {
            jSONObject = null;
        }
        return NotificationFormatHelper.INSTANCE.getOSNotificationIdFromJson(jSONObject);
    }

    private final boolean shouldInitDirectSessionFromNotificationOpen(Activity activity) {
        if (this._applicationService.isInForeground()) {
            return false;
        }
        try {
            return OSNotificationOpenAppSettings.INSTANCE.getShouldOpenActivity(activity);
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void addExternalClickListener(INotificationClickListener callback) {
        k.e(callback, "callback");
        this.extOpenedCallback.subscribe(callback);
        if (this.extOpenedCallback.getHasSubscribers()) {
            i iVar = this.unprocessedOpenedNotifs;
            k.e(iVar, "<this>");
            if (iVar.isEmpty()) {
                return;
            }
            Iterator<E> it = this.unprocessedOpenedNotifs.iterator();
            while (it.hasNext()) {
                this.extOpenedCallback.fireOnMain(new AnonymousClass1(NotificationHelper.INSTANCE.generateNotificationOpenedResult$com_onesignal_notifications((JSONArray) it.next(), this._time)));
            }
        }
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void addExternalForegroundLifecycleListener(INotificationLifecycleListener listener) {
        k.e(listener, "listener");
        this.extWillShowInForegroundCallback.subscribe(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object canOpenNotification(android.app.Activity r7, org.json.JSONObject r8, v5.c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.C27951
            if (r0 == 0) goto L13
            r0 = r9
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1 r0 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.C27951) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1 r0 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.w r7 = (kotlin.jvm.internal.w) r7
            r2.q.z0(r9)
            goto L51
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            r2.q.z0(r9)
            kotlin.jvm.internal.w r9 = new kotlin.jvm.internal.w
            r9.<init>()
            r9.f12728a = r3
            com.onesignal.common.events.CallbackProducer<com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback> r2 = r6.intLifecycleCallback
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$2 r4 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$2
            r5 = 0
            r4.<init>(r9, r7, r8, r5)
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r7 = r2.suspendingFire(r4, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r7 = r9
        L51:
            boolean r7 = r7.f12728a
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification(android.app.Activity, org.json.JSONObject, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object canReceiveNotification(org.json.JSONObject r7, v5.c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.C27961
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1 r0 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.C27961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1 r0 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.w r7 = (kotlin.jvm.internal.w) r7
            r2.q.z0(r8)
            goto L51
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            r2.q.z0(r8)
            kotlin.jvm.internal.w r8 = new kotlin.jvm.internal.w
            r8.<init>()
            r8.f12728a = r3
            com.onesignal.common.events.CallbackProducer<com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback> r2 = r6.intLifecycleCallback
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$2 r4 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$2
            r5 = 0
            r4.<init>(r8, r7, r5)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r2.suspendingFire(r4, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r7 = r8
        L51:
            boolean r7 = r7.f12728a
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification(org.json.JSONObject, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void externalNotificationWillShowInForeground(INotificationWillDisplayEvent willDisplayEvent) {
        k.e(willDisplayEvent, "willDisplayEvent");
        this.extWillShowInForegroundCallback.fire(new C27981(willDisplayEvent));
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void externalRemoteNotificationReceived(INotificationReceivedEvent notificationReceivedEvent) {
        k.e(notificationReceivedEvent, "notificationReceivedEvent");
        this.extRemoteReceivedCallback.fire(new C27991(notificationReceivedEvent));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object notificationOpened(android.app.Activity r13, org.json.JSONArray r14, v5.c<? super q5.x> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened(android.app.Activity, org.json.JSONArray, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public Object notificationReceived(NotificationGenerationJob notificationGenerationJob, v5.c<? super x> cVar) {
        this._receiveReceiptWorkManager.enqueueReceiveReceipt(notificationGenerationJob.getApiNotificationId());
        this._influenceManager.onNotificationReceived(notificationGenerationJob.getApiNotificationId());
        try {
            JSONObject jSONObject = new JSONObject(notificationGenerationJob.getJsonPayload().toString());
            jSONObject.put(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, notificationGenerationJob.getAndroidId());
            NotificationHelper notificationHelper = NotificationHelper.INSTANCE;
            NotificationClickEvent notificationClickEventGenerateNotificationOpenedResult$com_onesignal_notifications = notificationHelper.generateNotificationOpenedResult$com_onesignal_notifications(JSONUtils.INSTANCE.wrapInJsonArray(jSONObject), this._time);
            IAnalyticsTracker iAnalyticsTracker = this._analyticsTracker;
            String notificationId = notificationClickEventGenerateNotificationOpenedResult$com_onesignal_notifications.getNotification().getNotificationId();
            k.b(notificationId);
            iAnalyticsTracker.trackReceivedEvent(notificationId, notificationHelper.getCampaignNameFromNotification(notificationClickEventGenerateNotificationOpenedResult$com_onesignal_notifications.getNotification()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return x.f13520a;
    }

    @Override // com.onesignal.notifications.internal.INotificationActivityOpener
    public Object openDestinationActivity(Activity activity, JSONArray jSONArray, v5.c<? super x> cVar) {
        try {
            JSONObject firstPayloadItem = jSONArray.getJSONObject(0);
            GenerateNotificationOpenIntentFromPushPayload generateNotificationOpenIntentFromPushPayload = GenerateNotificationOpenIntentFromPushPayload.INSTANCE;
            k.d(firstPayloadItem, "firstPayloadItem");
            Intent intentVisible = generateNotificationOpenIntentFromPushPayload.create(activity, firstPayloadItem).getIntentVisible();
            if (intentVisible != null) {
                Logging.info$default("SDK running startActivity with Intent: " + intentVisible, null, 2, null);
                activity.startActivity(intentVisible);
            } else {
                Logging.info$default("SDK not showing an Activity automatically due to it's settings.", null, 2, null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return x.f13520a;
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void removeExternalClickListener(INotificationClickListener listener) {
        k.e(listener, "listener");
        this.extOpenedCallback.unsubscribe(listener);
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void removeExternalForegroundLifecycleListener(INotificationLifecycleListener listener) {
        k.e(listener, "listener");
        this.extWillShowInForegroundCallback.unsubscribe(listener);
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void setInternalNotificationLifecycleCallback(INotificationLifecycleCallback iNotificationLifecycleCallback) {
        this.intLifecycleCallback.set(iNotificationLifecycleCallback);
    }

    public final void setupNotificationServiceExtension(Context context) {
        k.e(context, "context");
        String manifestMeta = AndroidUtils.INSTANCE.getManifestMeta(context, NotificationConstants.EXTENSION_SERVICE_META_DATA_TAG_NAME);
        if (manifestMeta == null) {
            Logging.verbose$default("No class found, not setting up OSRemoteNotificationReceivedHandler", null, 2, null);
            return;
        }
        Logging.verbose$default(a1.a.m("Found class: ", manifestMeta, ", attempting to call constructor"), null, 2, null);
        try {
            Object objNewInstance = Class.forName(manifestMeta).newInstance();
            if (!(objNewInstance instanceof INotificationServiceExtension) || this.extRemoteReceivedCallback.getHasCallback()) {
                return;
            }
            this.extRemoteReceivedCallback.set((INotificationServiceExtension) objNewInstance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (InstantiationException e8) {
            e8.printStackTrace();
        }
    }
}
