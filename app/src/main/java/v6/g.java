package v6;

import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import q6.e0;
import q6.h0;
import q6.o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends q6.w implements h0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f17625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q6.w f17626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17628d;
    public final k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f17629f;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public g(q6.w wVar, int i2, String str) {
        h0 h0Var = wVar instanceof h0 ? (h0) wVar : null;
        this.f17625a = h0Var == null ? e0.f13545a : h0Var;
        this.f17626b = wVar;
        this.f17627c = i2;
        this.f17628d = str;
        this.e = new k();
        this.f17629f = new Object();
    }

    @Override // q6.w
    public final void dispatch(v5.h hVar, Runnable runnable) {
        Runnable runnableO;
        this.e.a(runnable);
        if (g.get(this) >= this.f17627c || !p() || (runnableO = o()) == null) {
            return;
        }
        this.f17626b.dispatch(this, new com.unity3d.scar.adapter.common.i(6, this, runnableO));
    }

    @Override // q6.w
    public final void dispatchYield(v5.h hVar, Runnable runnable) {
        Runnable runnableO;
        this.e.a(runnable);
        if (g.get(this) >= this.f17627c || !p() || (runnableO = o()) == null) {
            return;
        }
        this.f17626b.dispatchYield(this, new com.unity3d.scar.adapter.common.i(6, this, runnableO));
    }

    @Override // q6.h0
    public final o0 e(long j, Runnable runnable, v5.h hVar) {
        return this.f17625a.e(j, runnable, hVar);
    }

    @Override // q6.h0
    public final void l(long j, q6.l lVar) {
        this.f17625a.l(j, lVar);
    }

    @Override // q6.w
    public final q6.w limitedParallelism(int i2, String str) {
        a.a(i2);
        return i2 >= this.f17627c ? str != null ? new o(this, str) : this : super.limitedParallelism(i2, str);
    }

    public final Runnable o() {
        while (true) {
            Runnable runnable = (Runnable) this.e.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f17629f) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.e.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean p() {
        synchronized (this.f17629f) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            if (atomicIntegerFieldUpdater.get(this) >= this.f17627c) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // q6.w
    public final String toString() {
        String str = this.f17628d;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17626b);
        sb.append(".limitedParallelism(");
        return a0.c(sb, this.f17627c, ')');
    }
}
