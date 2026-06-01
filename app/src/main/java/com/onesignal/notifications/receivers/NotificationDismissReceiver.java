package com.onesignal.notifications.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
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
public final class NotificationDismissReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: com.onesignal.notifications.receivers.NotificationDismissReceiver$onReceive$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.receivers.NotificationDismissReceiver$onReceive$1", f = "NotificationDismissReceiver.kt", l = {46}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ a0 $notificationOpenedProcessor;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a0 a0Var, Context context, Intent intent, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$notificationOpenedProcessor = a0Var;
            this.$context = context;
            this.$intent = intent;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.$notificationOpenedProcessor, this.$context, this.$intent, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                INotificationOpenedProcessor iNotificationOpenedProcessor = (INotificationOpenedProcessor) this.$notificationOpenedProcessor.f12717a;
                Context context = this.$context;
                Intent intent = this.$intent;
                this.label = 1;
                if (iNotificationOpenedProcessor.processFromContext(context, intent, this) == aVar) {
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Throwable {
        k.e(context, "context");
        k.e(intent, "intent");
        Context applicationContext = context.getApplicationContext();
        k.d(applicationContext, "context.applicationContext");
        if (OneSignal.initWithContext(applicationContext)) {
            a0 a0Var = new a0();
            a0Var.f12717a = OneSignal.INSTANCE.getServices().getService(INotificationOpenedProcessor.class);
            ThreadUtilsKt.suspendifyBlocking(new AnonymousClass1(a0Var, context, intent, null));
        }
    }
}
