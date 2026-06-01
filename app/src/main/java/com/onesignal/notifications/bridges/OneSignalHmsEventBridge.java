package com.onesignal.notifications.bridges;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.push.RemoteMessage;
import com.onesignal.OneSignal;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import e6.l;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OneSignalHmsEventBridge {
    public static final String HMS_SENT_TIME_KEY = "hms.sent_time";
    public static final String HMS_TTL_KEY = "hms.ttl";
    public static final OneSignalHmsEventBridge INSTANCE = new OneSignalHmsEventBridge();
    private static final AtomicBoolean firstToken = new AtomicBoolean(true);

    /* JADX INFO: renamed from: com.onesignal.notifications.bridges.OneSignalHmsEventBridge$onNewToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.bridges.OneSignalHmsEventBridge$onNewToken$1", f = "OneSignalHmsEventBridge.kt", l = {43}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ a0 $registerer;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a0 a0Var, String str, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$registerer = a0Var;
            this.$token = str;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.$registerer, this.$token, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IPushRegistratorCallback iPushRegistratorCallback = (IPushRegistratorCallback) this.$registerer.f12717a;
                String str = this.$token;
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

    private OneSignalHmsEventBridge() {
    }

    public final void onMessageReceived(Context context, RemoteMessage message) {
        Bundle bundleJsonStringToBundle;
        k.e(context, "context");
        k.e(message, "message");
        if (OneSignal.initWithContext(context)) {
            OneSignal oneSignal = OneSignal.INSTANCE;
            ITime iTime = (ITime) oneSignal.getServices().getService(ITime.class);
            INotificationBundleProcessor iNotificationBundleProcessor = (INotificationBundleProcessor) oneSignal.getServices().getService(INotificationBundleProcessor.class);
            String data = message.getData();
            try {
                JSONObject jSONObject = new JSONObject(message.getData());
                if (message.getTtl() == 0) {
                    jSONObject.put("hms.ttl", 259200);
                } else {
                    jSONObject.put("hms.ttl", message.getTtl());
                }
                if (message.getSentTime() == 0) {
                    jSONObject.put("hms.sent_time", iTime.getCurrentTimeMillis());
                } else {
                    jSONObject.put("hms.sent_time", message.getSentTime());
                }
                data = jSONObject.toString();
            } catch (JSONException unused) {
                Logging.error$default("OneSignalHmsEventBridge error when trying to create RemoteMessage data JSON", null, 2, null);
            }
            if (data == null || (bundleJsonStringToBundle = JSONUtils.INSTANCE.jsonStringToBundle(data)) == null) {
                return;
            }
            iNotificationBundleProcessor.processBundleFromReceiver(context, bundleJsonStringToBundle);
        }
    }

    public final void onNewToken(Context context, String token, Bundle bundle) {
        k.e(context, "context");
        k.e(token, "token");
        if (!firstToken.compareAndSet(true, false)) {
            Logging.info$default("OneSignalHmsEventBridge ignoring onNewToken - HMS token: " + token + " Bundle: " + bundle, null, 2, null);
            return;
        }
        Logging.info$default("OneSignalHmsEventBridge onNewToken - HMS token: " + token + " Bundle: " + bundle, null, 2, null);
        a0 a0Var = new a0();
        a0Var.f12717a = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(a0Var, token, null), 1, null);
    }

    public final void onNewToken(Context context, String token) {
        k.e(context, "context");
        k.e(token, "token");
        onNewToken(context, token, null);
    }
}
