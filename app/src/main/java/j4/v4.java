package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v4 extends z4 {
    @Override // j4.z4
    public final boolean p(w4 w4Var) {
        synchronized (w4Var) {
            try {
                if (w4Var.f12537c != 0) {
                    return false;
                }
                w4Var.f12537c = -1;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j4.z4
    public final void q(w4 w4Var) {
        synchronized (w4Var) {
            w4Var.f12537c = 0;
        }
    }
}
