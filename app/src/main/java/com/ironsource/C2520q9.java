package com.ironsource;

import android.os.Handler;
import com.ironsource.environment.thread.IronSourceThreadManager;

/* JADX INFO: renamed from: com.ironsource.q9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2520q9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f9704a;

    /* JADX INFO: renamed from: com.ironsource.q9$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f9705b;

        public a(Runnable runnable) {
            this.f9705b = runnable;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            this.f9705b.run();
        }
    }

    public C2520q9() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void c(Runnable runnable) {
        AbstractRunnableC2382ie aVar = runnable instanceof AbstractRunnableC2382ie ? (AbstractRunnableC2382ie) runnable : new a(runnable);
        if (Thread.currentThread().getId() == this.f9704a.getLooper().getThread().getId()) {
            aVar.run();
        } else {
            a(this, aVar, 0L, 2, null);
        }
    }

    public final Handler a() {
        return this.f9704a;
    }

    public final void b(Runnable runnable) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        c(runnable);
    }

    public C2520q9(Handler handler) {
        kotlin.jvm.internal.k.e(handler, "handler");
        this.f9704a = handler;
    }

    public static /* synthetic */ void a(C2520q9 c2520q9, AbstractRunnableC2382ie abstractRunnableC2382ie, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        c2520q9.a(abstractRunnableC2382ie, j);
    }

    public /* synthetic */ C2520q9(Handler handler, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? new Handler(IronSourceThreadManager.INSTANCE.getSharedManagersThread().getLooper()) : handler);
    }

    public final void a(AbstractRunnableC2382ie task, long j) {
        kotlin.jvm.internal.k.e(task, "task");
        this.f9704a.postDelayed(task, j);
    }

    public final void a(AbstractRunnableC2382ie task) {
        kotlin.jvm.internal.k.e(task, "task");
        this.f9704a.removeCallbacks(task);
    }

    public final void a(Runnable callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        c(callback);
    }
}
