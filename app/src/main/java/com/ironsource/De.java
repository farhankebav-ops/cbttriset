package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.Me;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.utils.IronSourceUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class De {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V9 f6624a = new V9();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2520q9 f6625b = new C2520q9(IronSourceThreadManager.INSTANCE.getInitHandler());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final B7 f6626c = Mb.f7131s.d().i();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f6627b;

        public a(Runnable runnable) {
            this.f6627b = runnable;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            this.f6627b.run();
        }
    }

    public final void a(AbstractRunnableC2382ie safeRunnable) {
        kotlin.jvm.internal.k.e(safeRunnable, "safeRunnable");
        a(this, safeRunnable, 0L, 2, (Object) null);
    }

    public final B7 b() {
        return this.f6626c;
    }

    public final V9 c() {
        return this.f6624a;
    }

    public final void d(Runnable callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, callback, 0L, 2, null);
    }

    public final void e(Runnable callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new a(callback), 0L, 2, null);
    }

    public final void f() {
        com.ironsource.mediationsdk.r.m().S();
    }

    public final void g() {
        Mb.f7131s.d().q().a(new C5(D5.USING_CACHE_FOR_INIT_EVENT, IronSourceUtils.b(false)));
    }

    public static /* synthetic */ void a(De de, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        de.a(runnable, j);
    }

    public final void b(AbstractRunnableC2382ie safeRunnable) {
        kotlin.jvm.internal.k.e(safeRunnable, "safeRunnable");
        this.f6625b.a(safeRunnable);
    }

    public final void c(Runnable runnable) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        this.f6625b.b(runnable);
    }

    public final C2270ca d() {
        return com.ironsource.mediationsdk.r.m().s();
    }

    public final void a(Runnable runnable, long j) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(runnable, j);
    }

    public final void b(Runnable runnable) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        IronSourceThreadManager.postMediationBackgroundTask$default(IronSourceThreadManager.INSTANCE, runnable, 0L, 2, null);
    }

    public final boolean c(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        return IronSourceUtils.g(context);
    }

    public final void a(Runnable callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        this.f6625b.a(callback);
    }

    public final String b(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        String strM = this.f6626c.M(context);
        kotlin.jvm.internal.k.d(strM, "deviceInfoService.getOrG…UniqueIdentifier(context)");
        return strM;
    }

    public final boolean e() {
        return IronSourceUtils.g();
    }

    public final void a(AbstractRunnableC2382ie safeRunnable, long j) {
        kotlin.jvm.internal.k.e(safeRunnable, "safeRunnable");
        this.f6625b.a(safeRunnable, j);
    }

    public static /* synthetic */ void a(De de, AbstractRunnableC2382ie abstractRunnableC2382ie, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        de.a(abstractRunnableC2382ie, j);
    }

    public final void a(String key, String value) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(value, "value");
        if (TextUtils.isEmpty(value)) {
            return;
        }
        N6.a().a(key, value);
    }

    public final void a(long j, Me.a responseOrigin) {
        kotlin.jvm.internal.k.e(responseOrigin, "responseOrigin");
        com.ironsource.mediationsdk.r.m().a(j, responseOrigin);
    }

    public final String a(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        String strB = com.ironsource.mediationsdk.r.m().b(context);
        kotlin.jvm.internal.k.d(strB, "getInstance().getAdvertiserId(context)");
        return strB;
    }

    public final Me a(Context context, String appKey) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(appKey, "appKey");
        return com.ironsource.mediationsdk.r.m().a(context, appKey);
    }

    public final void a(D1 reporterSettings) {
        kotlin.jvm.internal.k.e(reporterSettings, "reporterSettings");
        C2531r4.d().a(reporterSettings.b(), reporterSettings.d(), reporterSettings.c(), reporterSettings.e(), IronSourceUtils.d(), reporterSettings.a(), reporterSettings.g());
    }

    public final void a(Be initStatus) {
        kotlin.jvm.internal.k.e(initStatus, "initStatus");
        Ce.f6411a.a(initStatus);
    }

    public final void a() {
        Dd.c().a();
    }
}
