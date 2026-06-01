package androidx.lifecycle;

import q6.m0;
import q6.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcher extends w {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // q6.w
    public void dispatch(v5.h context, Runnable block) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // q6.w
    public boolean isDispatchNeeded(v5.h context) {
        kotlin.jvm.internal.k.e(context, "context");
        x6.e eVar = m0.f13566a;
        if (v6.n.f17641a.f13648c.isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
