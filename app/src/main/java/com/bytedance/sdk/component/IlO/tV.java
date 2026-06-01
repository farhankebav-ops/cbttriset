package com.bytedance.sdk.component.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tV<P, R> extends com.bytedance.sdk.component.IlO.MY<P, R> {
    private vCE EO;
    private boolean IlO = true;
    private IlO MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(Object obj);

        void IlO(Throwable th);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        tV IlO();
    }

    private boolean vCE() {
        if (this.IlO) {
            return true;
        }
        DmF.IlO(new IllegalStateException("Jsb async call already finished: " + IlO() + ", hashcode: " + hashCode()));
        return false;
    }

    public void Cc() {
        tV();
    }

    public final void EO() {
        IlO((Throwable) null);
    }

    @Override // com.bytedance.sdk.component.IlO.MY
    public /* bridge */ /* synthetic */ String IlO() {
        return super.IlO();
    }

    public abstract void IlO(P p, vCE vce) throws Exception;

    public void tV() {
        this.IlO = false;
        this.EO = null;
    }

    public final void IlO(R r7) {
        if (vCE()) {
            this.MY.IlO(r7);
            tV();
        }
    }

    public final void IlO(Throwable th) {
        if (vCE()) {
            this.MY.IlO(th);
            tV();
        }
    }

    public void IlO(P p, vCE vce, IlO ilO) throws Exception {
        this.EO = vce;
        this.MY = ilO;
        IlO(p, vce);
    }
}
