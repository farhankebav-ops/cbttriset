package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS;
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
public final class NotificationOpenedActivityHMS extends Activity {

    /* JADX INFO: renamed from: com.onesignal.NotificationOpenedActivityHMS$processOpen$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.NotificationOpenedActivityHMS$processOpen$1", f = "NotificationOpenedActivityHMS.kt", l = {82}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ a0 $notificationPayloadProcessorHMS;
        final /* synthetic */ NotificationOpenedActivityHMS $self;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a0 a0Var, NotificationOpenedActivityHMS notificationOpenedActivityHMS, Intent intent, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$notificationPayloadProcessorHMS = a0Var;
            this.$self = notificationOpenedActivityHMS;
            this.$intent = intent;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.$notificationPayloadProcessorHMS, this.$self, this.$intent, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                INotificationOpenedProcessorHMS iNotificationOpenedProcessorHMS = (INotificationOpenedProcessorHMS) this.$notificationPayloadProcessorHMS.f12717a;
                NotificationOpenedActivityHMS notificationOpenedActivityHMS = this.$self;
                Intent intent = this.$intent;
                this.label = 1;
                if (iNotificationOpenedProcessorHMS.handleHMSNotificationOpenIntent(notificationOpenedActivityHMS, intent, this) == aVar) {
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

    private final void processIntent() throws Throwable {
        processOpen(getIntent());
        finish();
    }

    private final void processOpen(Intent intent) throws Throwable {
        Context applicationContext = getApplicationContext();
        k.d(applicationContext, "applicationContext");
        if (OneSignal.initWithContext(applicationContext)) {
            a0 a0Var = new a0();
            a0Var.f12717a = OneSignal.INSTANCE.getServices().getService(INotificationOpenedProcessorHMS.class);
            ThreadUtilsKt.suspendifyBlocking(new AnonymousClass1(a0Var, this, intent, null));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        processIntent();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) throws Throwable {
        k.e(intent, "intent");
        super.onNewIntent(intent);
        processIntent();
    }
}
