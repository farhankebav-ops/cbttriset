package z6;

import java.util.concurrent.atomic.AtomicReferenceArray;
import v6.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends s {
    public final /* synthetic */ AtomicReferenceArray e;

    public i(long j, i iVar, int i2) {
        super(j, iVar, i2);
        this.e = new AtomicReferenceArray(h.f18004f);
    }

    @Override // v6.s
    public final int g() {
        return h.f18004f;
    }

    @Override // v6.s
    public final void h(int i2, v5.h hVar) {
        this.e.set(i2, h.e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f17648c + ", hashCode=" + hashCode() + ']';
    }
}
