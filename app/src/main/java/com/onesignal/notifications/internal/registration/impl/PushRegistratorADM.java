package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import e6.p;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PushRegistratorADM implements IPushRegistrator, IPushRegistratorCallback {
    private final IApplicationService _applicationService;
    private WaiterWithValue<String> waiter;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorADM", f = "PushRegistratorADM.kt", l = {35}, m = "registerForPush")
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
            return PushRegistratorADM.this.registerForPush(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$2", f = "PushRegistratorADM.kt", l = {36}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ a0 $registrationId;
        Object L$0;
        int label;
        final /* synthetic */ PushRegistratorADM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(a0 a0Var, PushRegistratorADM pushRegistratorADM, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$registrationId = a0Var;
            this.this$0 = pushRegistratorADM;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass2(this.$registrationId, this.this$0, cVar);
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
                a0Var = this.$registrationId;
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

    public PushRegistratorADM(IApplicationService _applicationService) {
        k.e(_applicationService, "_applicationService");
        this._applicationService = _applicationService;
    }

    @Override // com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback
    public Object fireCallback(String str, v5.c<? super x> cVar) throws Exception {
        WaiterWithValue<String> waiterWithValue = this.waiter;
        if (waiterWithValue != null) {
            waiterWithValue.wake(str);
        }
        return x.f13520a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.registration.IPushRegistrator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object registerForPush(v5.c<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorADM.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorADM.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.a0 r0 = (kotlin.jvm.internal.a0) r0
            r2.q.z0(r9)
            goto L8e
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L35:
            r2.q.z0(r9)
            com.onesignal.common.threading.WaiterWithValue r9 = new com.onesignal.common.threading.WaiterWithValue
            r9.<init>()
            r8.waiter = r9
            com.amazon.device.messaging.ADM r9 = new com.amazon.device.messaging.ADM
            com.onesignal.core.internal.application.IApplicationService r2 = r8._applicationService
            android.content.Context r2 = r2.getAppContext()
            r9.<init>(r2)
            kotlin.jvm.internal.a0 r2 = new kotlin.jvm.internal.a0
            r2.<init>()
            java.lang.String r6 = r9.getRegistrationId()
            r2.f12717a = r6
            if (r6 == 0) goto L78
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "ADM Already registered with ID:"
            r9.<init>(r0)
            java.lang.Object r0 = r2.f12717a
            java.lang.String r0 = (java.lang.String) r0
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r5, r4, r5)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            java.lang.Object r0 = r2.f12717a
            java.lang.String r0 = (java.lang.String) r0
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED
            r9.<init>(r0, r1)
            return r9
        L78:
            r9.startRegister()
            com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$2 r9 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$2
            r9.<init>(r2, r8, r5)
            r0.L$0 = r2
            r0.label = r3
            r6 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r9 = q6.c0.I(r6, r9, r0)
            if (r9 != r1) goto L8d
            return r1
        L8d:
            r0 = r2
        L8e:
            java.lang.Object r9 = r0.f12717a
            if (r9 == 0) goto Lb3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r1 = "ADM registered with ID:"
            r9.<init>(r1)
            java.lang.Object r1 = r0.f12717a
            java.lang.String r1 = (java.lang.String) r1
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            com.onesignal.debug.internal.logging.Logging.error$default(r9, r5, r4, r5)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            java.lang.Object r0 = r0.f12717a
            java.lang.String r0 = (java.lang.String) r0
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED
            r9.<init>(r0, r1)
            return r9
        Lb3:
            java.lang.String r9 = "com.onesignal.ADMMessageHandler timed out, please check that your have the receiver, service, and your package name matches(NOTE: Case Sensitive) per the OneSignal instructions."
            com.onesignal.debug.internal.logging.Logging.error$default(r9, r5, r4, r5)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.ERROR
            r9.<init>(r5, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorADM.registerForPush(v5.c):java.lang.Object");
    }
}
