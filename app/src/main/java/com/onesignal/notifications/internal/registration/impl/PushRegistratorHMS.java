package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import e6.p;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PushRegistratorHMS implements IPushRegistrator, IPushRegistratorCallback {
    public static final Companion Companion = new Companion(null);
    private static final String HMS_CLIENT_APP_ID = "client/app_id";
    private final IApplicationService _applicationService;
    private final IDeviceService _deviceService;
    private WaiterWithValue<String> waiter;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS", f = "PushRegistratorHMS.kt", l = {77}, m = "getHMSTokenTask")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushRegistratorHMS.this.getHMSTokenTask(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$2", f = "PushRegistratorHMS.kt", l = {78}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ a0 $pushToken;
        Object L$0;
        int label;
        final /* synthetic */ PushRegistratorHMS this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(a0 a0Var, PushRegistratorHMS pushRegistratorHMS, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$pushToken = a0Var;
            this.this$0 = pushRegistratorHMS;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass2(this.$pushToken, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a0 a0Var;
            String str;
            a0 a0Var2;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                a0Var = this.$pushToken;
                WaiterWithValue waiterWithValue = this.this$0.waiter;
                if (waiterWithValue == null) {
                    str = null;
                    a0Var.f12717a = str;
                    return x.f13520a;
                }
                this.L$0 = a0Var;
                this.label = 1;
                Object objWaitForWake = waiterWithValue.waitForWake(this);
                if (objWaitForWake == aVar) {
                    return aVar;
                }
                a0Var2 = a0Var;
                obj = objWaitForWake;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a0Var2 = (a0) this.L$0;
                q.z0(obj);
            }
            a0 a0Var3 = a0Var2;
            str = (String) obj;
            a0Var = a0Var3;
            a0Var.f12717a = str;
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(q6.a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS", f = "PushRegistratorHMS.kt", l = {34}, m = "registerForPush")
    public static final class C28131 extends c {
        int label;
        /* synthetic */ Object result;

        public C28131(v5.c<? super C28131> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushRegistratorHMS.this.registerForPush(this);
        }
    }

    public PushRegistratorHMS(IDeviceService _deviceService, IApplicationService _applicationService) {
        k.e(_deviceService, "_deviceService");
        k.e(_applicationService, "_applicationService");
        this._deviceService = _deviceService;
        this._applicationService = _applicationService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001b A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x0014, B:12:0x0020, B:15:0x002d, B:33:0x00ae, B:35:0x00b2, B:36:0x00d1, B:16:0x0036, B:17:0x003d, B:18:0x003e, B:20:0x0049, B:23:0x0052, B:25:0x007a, B:28:0x009a, B:11:0x001b), top: B:41:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.Object getHMSTokenTask(android.content.Context r11, v5.c<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r12) throws com.huawei.hms.common.ApiException {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.getHMSTokenTask(android.content.Context, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback
    public Object fireCallback(String str, v5.c<? super x> cVar) throws Exception {
        WaiterWithValue<String> waiterWithValue = this.waiter;
        if (waiterWithValue != null) {
            waiterWithValue.wake(str);
        }
        return x.f13520a;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.huawei.hms.common.ApiException */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.registration.IPushRegistrator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object registerForPush(v5.c<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.C28131
            if (r0 == 0) goto L13
            r0 = r5
            com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.C28131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            r2.q.z0(r5)     // Catch: com.huawei.hms.common.ApiException -> L27
            goto L43
        L27:
            r5 = move-exception
            goto L46
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            r2.q.z0(r5)
            com.onesignal.core.internal.application.IApplicationService r5 = r4._applicationService     // Catch: com.huawei.hms.common.ApiException -> L27
            android.content.Context r5 = r5.getAppContext()     // Catch: com.huawei.hms.common.ApiException -> L27
            r0.label = r3     // Catch: com.huawei.hms.common.ApiException -> L27
            java.lang.Object r5 = r4.getHMSTokenTask(r5, r0)     // Catch: com.huawei.hms.common.ApiException -> L27
            if (r5 != r1) goto L43
            return r1
        L43:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r5 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r5     // Catch: com.huawei.hms.common.ApiException -> L27
            goto L63
        L46:
            java.lang.String r0 = "HMS ApiException getting Huawei push token!"
            r1 = r5
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            com.onesignal.debug.internal.logging.Logging.error(r0, r1)
            int r5 = r5.getStatusCode()
            r0 = 907135000(0x3611c818, float:2.1723154E-6)
            if (r5 != r0) goto L5a
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r5 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.HMS_ARGUMENTS_INVALID
            goto L5c
        L5a:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r5 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.HMS_API_EXCEPTION_OTHER
        L5c:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r0 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            r1 = 0
            r0.<init>(r1, r5)
            r5 = r0
        L63:
            kotlin.jvm.internal.k.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.registerForPush(v5.c):java.lang.Object");
    }
}
