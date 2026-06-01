package com.onesignal.notifications.internal.generation.impl;

import com.onesignal.common.AndroidUtils;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.Notification;
import com.onesignal.notifications.internal.NotificationReceivedEvent;
import com.onesignal.notifications.internal.NotificationWillDisplayEvent;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.generation.INotificationGenerationProcessor;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.w;
import org.json.JSONException;
import org.json.JSONObject;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import q6.u1;
import q6.z0;
import r2.q;
import w5.a;
import x5.c;
import x5.e;
import x5.i;
import x6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationGenerationProcessor implements INotificationGenerationProcessor {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationLifecycleService _lifecycleService;
    private final INotificationDisplayer _notificationDisplayer;
    private final INotificationSummaryManager _notificationSummaryManager;
    private final ITime _time;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor", f = "NotificationGenerationProcessor.kt", l = {304, 307}, m = "markNotificationAsDismissed")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationGenerationProcessor.this.markNotificationAsDismissed(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor", f = "NotificationGenerationProcessor.kt", l = {230, 234, 238}, m = "postProcessNotification")
    public static final class C27901 extends c {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C27901(v5.c<? super C27901> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationGenerationProcessor.this.postProcessNotification(null, false, false, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor", f = "NotificationGenerationProcessor.kt", l = {Sdk.SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE}, m = "processCollapseKey")
    public static final class C27911 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27911(v5.c<? super C27911> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationGenerationProcessor.this.processCollapseKey(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor", f = "NotificationGenerationProcessor.kt", l = {171, 189, 194}, m = "processHandlerResponse")
    public static final class C27921 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27921(v5.c<? super C27921> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationGenerationProcessor.this.processHandlerResponse(null, false, false, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor", f = "NotificationGenerationProcessor.kt", l = {49, Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE, 72, 94, 105, Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, Sdk.SDKError.Reason.PRIVACY_URL_ERROR_VALUE, 142, 148}, m = "processNotificationData")
    public static final class C27931 extends c {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C27931(v5.c<? super C27931> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationGenerationProcessor.this.processNotificationData(null, 0, null, false, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$2", f = "NotificationGenerationProcessor.kt", l = {85}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Notification $notification;
        final /* synthetic */ NotificationReceivedEvent $notificationReceivedEvent;
        final /* synthetic */ w $wantsToDisplay;
        int label;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$2$1", f = "NotificationGenerationProcessor.kt", l = {83}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements p {
            final /* synthetic */ Notification $notification;
            final /* synthetic */ NotificationReceivedEvent $notificationReceivedEvent;
            final /* synthetic */ w $wantsToDisplay;
            Object L$0;
            int label;
            final /* synthetic */ NotificationGenerationProcessor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(NotificationGenerationProcessor notificationGenerationProcessor, NotificationReceivedEvent notificationReceivedEvent, w wVar, Notification notification, v5.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = notificationGenerationProcessor;
                this.$notificationReceivedEvent = notificationReceivedEvent;
                this.$wantsToDisplay = wVar;
                this.$notification = notification;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$notificationReceivedEvent, this.$wantsToDisplay, this.$notification, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w wVar;
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    this.this$0._lifecycleService.externalRemoteNotificationReceived(this.$notificationReceivedEvent);
                    if (this.$notificationReceivedEvent.getDiscard()) {
                        this.$wantsToDisplay.f12728a = false;
                    } else if (this.$notificationReceivedEvent.isPreventDefault()) {
                        w wVar2 = this.$wantsToDisplay;
                        wVar2.f12728a = false;
                        WaiterWithValue<Boolean> displayWaiter = this.$notification.getDisplayWaiter();
                        this.L$0 = wVar2;
                        this.label = 1;
                        Object objWaitForWake = displayWaiter.waitForWake(this);
                        if (objWaitForWake == aVar) {
                            return aVar;
                        }
                        wVar = wVar2;
                        obj = objWaitForWake;
                    }
                    return x.f13520a;
                }
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                wVar = (w) this.L$0;
                q.z0(obj);
                wVar.f12728a = ((Boolean) obj).booleanValue();
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
                return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(NotificationReceivedEvent notificationReceivedEvent, w wVar, Notification notification, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$notificationReceivedEvent = notificationReceivedEvent;
            this.$wantsToDisplay = wVar;
            this.$notification = notification;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return NotificationGenerationProcessor.this.new AnonymousClass2(this.$notificationReceivedEvent, this.$wantsToDisplay, this.$notification, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                x6.e eVar = m0.f13566a;
                u1 u1VarU = c0.u(z0.f13606a, d.f17810a, new AnonymousClass1(NotificationGenerationProcessor.this, this.$notificationReceivedEvent, this.$wantsToDisplay, this.$notification, null), 2);
                this.label = 1;
                if (u1VarU.M(this) == aVar) {
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
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3", f = "NotificationGenerationProcessor.kt", l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ Notification $notification;
        final /* synthetic */ NotificationWillDisplayEvent $notificationWillDisplayEvent;
        final /* synthetic */ w $wantsToDisplay;
        int label;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3$1", f = "NotificationGenerationProcessor.kt", l = {116}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements p {
            final /* synthetic */ Notification $notification;
            final /* synthetic */ NotificationWillDisplayEvent $notificationWillDisplayEvent;
            final /* synthetic */ w $wantsToDisplay;
            Object L$0;
            int label;
            final /* synthetic */ NotificationGenerationProcessor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(NotificationGenerationProcessor notificationGenerationProcessor, NotificationWillDisplayEvent notificationWillDisplayEvent, w wVar, Notification notification, v5.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = notificationGenerationProcessor;
                this.$notificationWillDisplayEvent = notificationWillDisplayEvent;
                this.$wantsToDisplay = wVar;
                this.$notification = notification;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$notificationWillDisplayEvent, this.$wantsToDisplay, this.$notification, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w wVar;
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    this.this$0._lifecycleService.externalNotificationWillShowInForeground(this.$notificationWillDisplayEvent);
                    if (this.$notificationWillDisplayEvent.getDiscard()) {
                        this.$wantsToDisplay.f12728a = false;
                    } else if (this.$notificationWillDisplayEvent.isPreventDefault()) {
                        w wVar2 = this.$wantsToDisplay;
                        wVar2.f12728a = false;
                        WaiterWithValue<Boolean> displayWaiter = this.$notification.getDisplayWaiter();
                        this.L$0 = wVar2;
                        this.label = 1;
                        Object objWaitForWake = displayWaiter.waitForWake(this);
                        if (objWaitForWake == aVar) {
                            return aVar;
                        }
                        wVar = wVar2;
                        obj = objWaitForWake;
                    }
                    return x.f13520a;
                }
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                wVar = (w) this.L$0;
                q.z0(obj);
                wVar.f12728a = ((Boolean) obj).booleanValue();
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
                return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(NotificationWillDisplayEvent notificationWillDisplayEvent, w wVar, Notification notification, v5.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$notificationWillDisplayEvent = notificationWillDisplayEvent;
            this.$wantsToDisplay = wVar;
            this.$notification = notification;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return NotificationGenerationProcessor.this.new AnonymousClass3(this.$notificationWillDisplayEvent, this.$wantsToDisplay, this.$notification, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                x6.e eVar = m0.f13566a;
                u1 u1VarU = c0.u(z0.f13606a, d.f17810a, new AnonymousClass1(NotificationGenerationProcessor.this, this.$notificationWillDisplayEvent, this.$wantsToDisplay, this.$notification, null), 2);
                this.label = 1;
                if (u1VarU.M(this) == aVar) {
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
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass3) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$saveNotification$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor", f = "NotificationGenerationProcessor.kt", l = {279}, m = "saveNotification")
    public static final class C27941 extends c {
        int label;
        /* synthetic */ Object result;

        public C27941(v5.c<? super C27941> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationGenerationProcessor.this.saveNotification(null, false, this);
        }
    }

    public NotificationGenerationProcessor(IApplicationService _applicationService, INotificationDisplayer _notificationDisplayer, ConfigModelStore _configModelStore, INotificationRepository _dataController, INotificationSummaryManager _notificationSummaryManager, INotificationLifecycleService _lifecycleService, ITime _time) {
        k.e(_applicationService, "_applicationService");
        k.e(_notificationDisplayer, "_notificationDisplayer");
        k.e(_configModelStore, "_configModelStore");
        k.e(_dataController, "_dataController");
        k.e(_notificationSummaryManager, "_notificationSummaryManager");
        k.e(_lifecycleService, "_lifecycleService");
        k.e(_time, "_time");
        this._applicationService = _applicationService;
        this._notificationDisplayer = _notificationDisplayer;
        this._configModelStore = _configModelStore;
        this._dataController = _dataController;
        this._notificationSummaryManager = _notificationSummaryManager;
        this._lifecycleService = _lifecycleService;
        this._time = _time;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object isDuplicateNotification(Notification notification, v5.c<? super Boolean> cVar) {
        return this._dataController.doesNotificationExist(notification.getNotificationId(), cVar);
    }

    private final boolean isNotificationWithinTTL(Notification notification) {
        if (this._configModelStore.getModel().getRestoreTTLFilter()) {
            return notification.getSentTime() + ((long) notification.getTtl()) > this._time.getCurrentTimeMillis() / ((long) 1000);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object markNotificationAsDismissed(com.onesignal.notifications.internal.common.NotificationGenerationJob r8, v5.c<? super q5.x> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            q5.x r4 = q5.x.f13520a
            r5 = 2
            r6 = 0
            if (r2 == 0) goto L41
            if (r2 == r3) goto L35
            if (r2 != r5) goto L2d
            r2.q.z0(r9)
            goto L8b
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            java.lang.Object r8 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r8 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r8
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r2 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r2
            r2.q.z0(r9)
            goto L70
        L41:
            r2.q.z0(r9)
            boolean r9 = r8.isNotificationToDisplay()
            if (r9 != 0) goto L4b
            return r4
        L4b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r2 = "Marking restored or disabled notifications as dismissed: "
            r9.<init>(r2)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r6, r5, r6)
            com.onesignal.notifications.internal.data.INotificationRepository r9 = r7._dataController
            int r2 = r8.getAndroidId()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r9.markAsDismissed(r2, r0)
            if (r9 != r1) goto L6f
            goto L8a
        L6f:
            r2 = r7
        L70:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L8b
            com.onesignal.notifications.internal.summary.INotificationSummaryManager r9 = r2._notificationSummaryManager
            int r8 = r8.getAndroidId()
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r5
            java.lang.Object r8 = r9.updatePossibleDependentSummaryOnDismiss(r8, r0)
            if (r8 != r1) goto L8b
        L8a:
            return r1
        L8b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.markNotificationAsDismissed(com.onesignal.notifications.internal.common.NotificationGenerationJob, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object postProcessNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r8, boolean r9, boolean r10, v5.c<? super q5.x> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.C27901
            if (r0 == 0) goto L13
            r0 = r11
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.C27901) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            q5.x r3 = q5.x.f13520a
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L49
            if (r2 == r6) goto L3b
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            r2.q.z0(r11)
            goto L7c
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            r2.q.z0(r11)
            goto L6c
        L3b:
            boolean r10 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r8 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r8
            java.lang.Object r9 = r0.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r9 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r9
            r2.q.z0(r11)
            goto L5c
        L49:
            r2.q.z0(r11)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.Z$0 = r10
            r0.label = r6
            java.lang.Object r9 = r7.saveNotification(r8, r9, r0)
            if (r9 != r1) goto L5b
            goto L7b
        L5b:
            r9 = r7
        L5c:
            r11 = 0
            if (r10 != 0) goto L6d
            r0.L$0 = r11
            r0.L$1 = r11
            r0.label = r5
            java.lang.Object r8 = r9.markNotificationAsDismissed(r8, r0)
            if (r8 != r1) goto L6c
            goto L7b
        L6c:
            return r3
        L6d:
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r9 = r9._lifecycleService
            r0.L$0 = r11
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r8 = r9.notificationReceived(r8, r0)
            if (r8 != r1) goto L7c
        L7b:
            return r1
        L7c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.postProcessNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, boolean, boolean, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processCollapseKey(com.onesignal.notifications.internal.common.NotificationGenerationJob r7, v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.C27911
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.C27911) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            q5.x r4 = q5.x.f13520a
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            com.onesignal.notifications.internal.common.NotificationGenerationJob r7 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r7
            r2.q.z0(r8)
            goto L76
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            r2.q.z0(r8)
            boolean r8 = r7.isRestoring()
            if (r8 == 0) goto L3f
            return r4
        L3f:
            org.json.JSONObject r8 = r7.getJsonPayload()
            java.lang.String r2 = "collapse_key"
            boolean r8 = r8.has(r2)
            if (r8 == 0) goto L85
            org.json.JSONObject r8 = r7.getJsonPayload()
            java.lang.String r8 = r8.optString(r2)
            java.lang.String r5 = "do_not_collapse"
            boolean r8 = r5.equals(r8)
            if (r8 == 0) goto L5c
            goto L85
        L5c:
            org.json.JSONObject r8 = r7.getJsonPayload()
            java.lang.String r8 = r8.optString(r2)
            com.onesignal.notifications.internal.data.INotificationRepository r2 = r6._dataController
            java.lang.String r5 = "collapseId"
            kotlin.jvm.internal.k.d(r8, r5)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r2.getAndroidIdFromCollapseKey(r8, r0)
            if (r8 != r1) goto L76
            return r1
        L76:
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto L85
            com.onesignal.notifications.internal.Notification r7 = r7.getNotification()
            int r8 = r8.intValue()
            r7.setAndroidNotificationId(r8)
        L85:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processCollapseKey(com.onesignal.notifications.internal.common.NotificationGenerationJob, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processHandlerResponse(com.onesignal.notifications.internal.common.NotificationGenerationJob r7, boolean r8, boolean r9, v5.c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.C27921
            if (r0 == 0) goto L13
            r0 = r10
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.C27921) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L42
            if (r2 == r5) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            goto L32
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            r2.q.z0(r10)
            goto L96
        L36:
            java.lang.Object r7 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r7 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r7
            java.lang.Object r8 = r0.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r8 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r8
            r2.q.z0(r10)
            goto L6f
        L42:
            r2.q.z0(r10)
            if (r8 == 0) goto L7e
            com.onesignal.common.AndroidUtils r8 = com.onesignal.common.AndroidUtils.INSTANCE
            com.onesignal.notifications.internal.Notification r10 = r7.getNotification()
            java.lang.String r10 = r10.getBody()
            boolean r8 = r8.isStringNotEmpty(r10)
            com.onesignal.notifications.internal.Notification r10 = r7.getNotification()
            boolean r10 = r6.isNotificationWithinTTL(r10)
            if (r8 == 0) goto L7e
            if (r10 == 0) goto L7e
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.processCollapseKey(r7, r0)
            if (r8 != r1) goto L6e
            goto L95
        L6e:
            r8 = r6
        L6f:
            boolean r8 = r8.shouldDisplayNotification(r7)
            if (r8 == 0) goto L7b
            r7.setNotificationToDisplay(r5)
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            return r7
        L7b:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        L7e:
            if (r9 == 0) goto L89
            r0.label = r4
            java.lang.Object r7 = r6.markNotificationAsDismissed(r7, r0)
            if (r7 != r1) goto L96
            goto L95
        L89:
            r8 = 0
            r7.setNotificationToDisplay(r8)
            r0.label = r3
            java.lang.Object r7 = r6.postProcessNotification(r7, r5, r8, r0)
            if (r7 != r1) goto L96
        L95:
            return r1
        L96:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processHandlerResponse(com.onesignal.notifications.internal.common.NotificationGenerationJob, boolean, boolean, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object saveNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r18, boolean r19, v5.c<? super q5.x> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.saveNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, boolean, v5.c):java.lang.Object");
    }

    private final boolean shouldDisplayNotification(NotificationGenerationJob notificationGenerationJob) {
        return notificationGenerationJob.hasExtender() || AndroidUtils.INSTANCE.isStringNotEmpty(notificationGenerationJob.getJsonPayload().optString("alert"));
    }

    private final boolean shouldFireForegroundHandlers(NotificationGenerationJob notificationGenerationJob) {
        if (!this._applicationService.isInForeground()) {
            Logging.info$default("App is in background, show notification", null, 2, null);
            return false;
        }
        if (!notificationGenerationJob.isRestoring()) {
            return true;
        }
        Logging.info$default("Not firing notificationWillShowInForegroundHandler for restored notifications", null, 2, null);
        return false;
    }

    public final JSONObject getCustomJSONObject(JSONObject jsonObject) throws JSONException {
        k.e(jsonObject, "jsonObject");
        return new JSONObject(jsonObject.optString(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x02e2, code lost:
    
        if (r8 != r4) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x016b, code lost:
    
        if (r5 == r4) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0175, code lost:
    
        if (((java.lang.Boolean) r5).booleanValue() != false) goto L133;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0242  */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    @Override // com.onesignal.notifications.internal.generation.INotificationGenerationProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object processNotificationData(android.content.Context r25, int r26, org.json.JSONObject r27, boolean r28, long r29, v5.c<? super q5.x> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 884
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData(android.content.Context, int, org.json.JSONObject, boolean, long, v5.c):java.lang.Object");
    }
}
