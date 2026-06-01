package w4;

import d5.p0;
import d5.q0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import s4.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends d {
    public final void f() {
        p0 p0Var;
        q0 q0Var = (q0) this;
        loop0: while (true) {
            AtomicReference atomicReference = q0Var.f11143c;
            p0Var = (p0) atomicReference.get();
            if (p0Var != null && !p0Var.d()) {
                break;
            }
            p0 p0Var2 = new p0(atomicReference, q0Var.f11144d);
            while (!atomicReference.compareAndSet(p0Var, p0Var2)) {
                if (atomicReference.get() != p0Var) {
                    break;
                }
            }
            p0Var = p0Var2;
            break loop0;
        }
        AtomicBoolean atomicBoolean = p0Var.f11138d;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        q0Var.f11142b.d(p0Var);
    }
}
