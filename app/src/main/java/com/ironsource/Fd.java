package com.ironsource;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.OutcomeReceiver;
import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final F7 f6767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e6.a f6768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final L7 f6769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f6770d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a extends kotlin.jvm.internal.j implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6771a = new a();

        public a() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements OutcomeReceiver {
        public b() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception error) {
            kotlin.jvm.internal.k.e(error, "error");
            Fd.this.a(error.getMessage());
        }

        public void onResult(Object obj) {
            Fd.this.c();
        }
    }

    public Fd() {
        this(null, null, null, null, 15, null);
    }

    private final boolean b(Context context) {
        return IronSourceUtils.c(context);
    }

    private final void d() {
        this.f6767a.a(new C5(D5.REGISTER_TRIGGER, (JSONObject) null));
    }

    public final void c(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        d();
        try {
            MeasurementManager measurementManagerA = C2385j0.a(context);
            if (measurementManagerA == null) {
                a("could not obtain measurement manager");
            } else {
                measurementManagerA.registerTrigger(a(context), this.f6770d, a());
            }
        } catch (Exception e) {
            a(e.getMessage());
            C2531r4.d().a(e);
        }
    }

    public Fd(F7 eventManager, e6.a getTimeFunction, L7 serviceProvider, Executor executor) {
        kotlin.jvm.internal.k.e(eventManager, "eventManager");
        kotlin.jvm.internal.k.e(getTimeFunction, "getTimeFunction");
        kotlin.jvm.internal.k.e(serviceProvider, "serviceProvider");
        kotlin.jvm.internal.k.e(executor, "executor");
        this.f6767a = eventManager;
        this.f6768b = getTimeFunction;
        this.f6769c = serviceProvider;
        this.f6770d = executor;
    }

    private final String b() {
        ConcurrentHashMap<String, List<String>> concurrentHashMapC = C2469na.b().c();
        List<String> list = concurrentHashMapC != null ? concurrentHashMapC.get(com.ironsource.mediationsdk.metadata.a.f9238b) : null;
        String str = list != null ? (String) r5.l.X0(list) : null;
        return str == null ? "" : str;
    }

    private final Uri a(Context context) {
        B7 b7I = this.f6769c.i();
        String strA = IronSourceUtils.a(context);
        Uri uriBuild = new Uri.Builder().scheme("https").authority("android-att.ironsrc.mobi").path("register_trigger").appendQueryParameter("osVersion", Build.VERSION.RELEASE).appendQueryParameter("apiLevel", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("deviceModel", Build.MODEL).appendQueryParameter("sdkVersion", LevelPlay.getSdkVersion()).appendQueryParameter("bundleID", context.getPackageName()).appendQueryParameter(Q6.U0, b7I.I(context)).appendQueryParameter(Q6.K0, b7I.y(context)).appendQueryParameter("auid", b7I.d(context)).appendQueryParameter("isFirstSession", String.valueOf(b(context))).appendQueryParameter("coppa", b()).appendQueryParameter(Q6.i0, String.valueOf(C2385j0.a())).appendQueryParameter("origin", "1").appendQueryParameter("timestamp", String.valueOf(((Number) this.f6768b.invoke()).longValue())).appendQueryParameter(C2300e4.i.f8424x, b7I.c(context)).appendQueryParameter("deviceCarrier", b7I.u(context)).appendQueryParameter("connectionType", strA).appendQueryParameter(C2228a4.f7946b, String.valueOf(n6.t.g0(strA, C2228a4.f7946b))).build();
        kotlin.jvm.internal.k.d(uriBuild, "Builder()\n        .schem…arameter\n        .build()");
        return uriBuild;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Fd(F7 f72, e6.a aVar, L7 l72, Executor executor, int i2, kotlin.jvm.internal.f fVar) {
        f72 = (i2 & 1) != 0 ? Mb.f7131s.d().q() : f72;
        aVar = (i2 & 2) != 0 ? a.f6771a : aVar;
        l72 = (i2 & 4) != 0 ? Mb.f7131s.d() : l72;
        if ((i2 & 8) != 0) {
            executor = Executors.newSingleThreadExecutor();
            kotlin.jvm.internal.k.d(executor, "newSingleThreadExecutor()");
        }
        this(f72, aVar, l72, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        this.f6767a.a(new C5(D5.REGISTER_TRIGGER_SUCCESS, (JSONObject) null));
    }

    private final OutcomeReceiver a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.f6767a.a(new C5(D5.REGISTER_TRIGGER_FAIL, new JSONObject().put("reason", str)));
    }
}
