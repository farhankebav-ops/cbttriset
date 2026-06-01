package com.ironsource;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: renamed from: com.ironsource.je, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2399je extends ScheduledThreadPoolExecutor implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e6.l f8803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e6.l f8804b;

    /* JADX INFO: renamed from: com.ironsource.je$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends kotlin.jvm.internal.l implements e6.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8806a = new b();

        public b() {
            super(1);
        }

        public final void a(String it) {
            kotlin.jvm.internal.k.e(it, "it");
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return q5.x.f13520a;
        }
    }

    public C2399je() {
        this(0, null, null, 7, null);
    }

    private final String a(String str) {
        return a1.a.D(C2399je.class.getName(), " RuntimeException caught: ", str);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th != null) {
            this.f8804b.invoke(a(th.toString()));
            this.f8803a.invoke(th);
            return;
        }
        if ((runnable instanceof Future) && ((Future) runnable).isDone()) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException e) {
                C2531r4.d().a(e);
                this.f8804b.invoke(a(e.toString()));
                Thread.currentThread().interrupt();
            } catch (CancellationException e4) {
                C2531r4.d().a(e4);
                this.f8804b.invoke(a(e4.toString()));
                this.f8803a.invoke(e4);
            } catch (ExecutionException e8) {
                C2531r4.d().a(e8);
                this.f8804b.invoke(a(e8.toString()));
                this.f8803a.invoke(e8.getCause());
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        hi.o(this);
    }

    public /* synthetic */ C2399je(int i2, e6.l lVar, e6.l lVar2, int i8, kotlin.jvm.internal.f fVar) {
        this((i8 & 1) != 0 ? C2417ke.f8864a : i2, (i8 & 2) != 0 ? a.f8805a : lVar, (i8 & 4) != 0 ? b.f8806a : lVar2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2399je(int i2, e6.l report, e6.l log) {
        super(i2, new ThreadFactoryC2342ga());
        kotlin.jvm.internal.k.e(report, "report");
        kotlin.jvm.internal.k.e(log, "log");
        this.f8803a = report;
        this.f8804b = log;
    }

    /* JADX INFO: renamed from: com.ironsource.je$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8805a = new a();

        public a() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return q5.x.f13520a;
        }

        public final void a(Throwable th) {
        }
    }
}
