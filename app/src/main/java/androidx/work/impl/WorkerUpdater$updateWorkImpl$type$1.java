package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WorkerUpdater$updateWorkImpl$type$1 extends l implements e6.l {
    public static final WorkerUpdater$updateWorkImpl$type$1 INSTANCE = new WorkerUpdater$updateWorkImpl$type$1();

    public WorkerUpdater$updateWorkImpl$type$1() {
        super(1);
    }

    @Override // e6.l
    public final String invoke(WorkSpec spec) {
        k.e(spec, "spec");
        return spec.isPeriodic() ? "Periodic" : "OneTime";
    }
}
