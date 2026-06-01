package com.onesignal.notifications.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import e6.l;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ADMMessageHandler extends ADMMessageHandlerBase {

    /* JADX INFO: renamed from: com.onesignal.notifications.services.ADMMessageHandler$onRegistered$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.services.ADMMessageHandler$onRegistered$1", f = "ADMMessageHandler.kt", l = {32}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ String $newRegistrationId;
        final /* synthetic */ a0 $registerer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a0 a0Var, String str, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$registerer = a0Var;
            this.$newRegistrationId = str;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.$registerer, this.$newRegistrationId, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IPushRegistratorCallback iPushRegistratorCallback = (IPushRegistratorCallback) this.$registerer.f12717a;
                String str = this.$newRegistrationId;
                this.label = 1;
                if (iPushRegistratorCallback.fireCallback(str, this) == aVar) {
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

    /* JADX INFO: renamed from: com.onesignal.notifications.services.ADMMessageHandler$onRegistrationError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.services.ADMMessageHandler$onRegistrationError$1", f = "ADMMessageHandler.kt", l = {47}, m = "invokeSuspend")
    public static final class C28171 extends i implements l {
        final /* synthetic */ a0 $registerer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28171(a0 a0Var, c<? super C28171> cVar) {
            super(1, cVar);
            this.$registerer = a0Var;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new C28171(this.$registerer, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IPushRegistratorCallback iPushRegistratorCallback = (IPushRegistratorCallback) this.$registerer.f12717a;
                this.label = 1;
                if (iPushRegistratorCallback.fireCallback(null, this) == aVar) {
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
            return ((C28171) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    public ADMMessageHandler() {
        super("ADMMessageHandler");
    }

    public void onMessage(Intent intent) {
        k.e(intent, "intent");
        Context context = getApplicationContext();
        k.d(context, "context");
        if (OneSignal.initWithContext(context)) {
            Bundle extras = intent.getExtras();
            INotificationBundleProcessor iNotificationBundleProcessor = (INotificationBundleProcessor) OneSignal.INSTANCE.getServices().getService(INotificationBundleProcessor.class);
            k.b(extras);
            iNotificationBundleProcessor.processBundleFromReceiver(context, extras);
        }
    }

    public void onRegistered(String newRegistrationId) {
        k.e(newRegistrationId, "newRegistrationId");
        Logging.info$default("ADM registration ID: ".concat(newRegistrationId), null, 2, null);
        a0 a0Var = new a0();
        a0Var.f12717a = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(a0Var, newRegistrationId, null), 1, null);
    }

    public void onRegistrationError(String error) {
        k.e(error, "error");
        Logging.error$default("ADM:onRegistrationError: ".concat(error), null, 2, null);
        if ("INVALID_SENDER".equals(error)) {
            Logging.error$default("Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.", null, 2, null);
        }
        a0 a0Var = new a0();
        a0Var.f12717a = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new C28171(a0Var, null), 1, null);
    }

    public void onUnregistered(String info) {
        k.e(info, "info");
        Logging.info$default("ADM:onUnregistered: ".concat(info), null, 2, null);
    }
}
