package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.InterfaceC2610vf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class W6 implements InterfaceC2610vf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f7768a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void a(Runnable runnable, long j);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC2610vf.a f7769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f7770c;

        public b(InterfaceC2610vf.a aVar, Runnable runnable) {
            this.f7769b = aVar;
            this.f7770c = runnable;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            if (this.f7769b.b()) {
                return;
            }
            this.f7770c.run();
        }
    }

    public W6() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.InterfaceC2610vf
    public InterfaceC2610vf.a a(Runnable task, long j) {
        kotlin.jvm.internal.k.e(task, "task");
        InterfaceC2610vf.a aVar = new InterfaceC2610vf.a();
        this.f7768a.a(a(aVar, task), o6.a.d(j));
        return aVar;
    }

    public W6(a handler) {
        kotlin.jvm.internal.k.e(handler, "handler");
        this.f7768a = handler;
    }

    public /* synthetic */ W6(a aVar, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? X6.a(new Handler(Looper.getMainLooper())) : aVar);
    }

    private final AbstractRunnableC2382ie a(InterfaceC2610vf.a aVar, Runnable runnable) {
        return new b(aVar, runnable);
    }
}
