package e5;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends s4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11301b;

    public /* synthetic */ v(Object obj, int i2) {
        this.f11300a = i2;
        this.f11301b = obj;
    }

    @Override // s4.l
    public final void d(s4.m mVar) {
        switch (this.f11300a) {
            case 0:
                ((k) this.f11301b).b(new u(mVar));
                break;
            default:
                u4.b bVar = y4.b.f17849a;
                try {
                    Iterator it = ((Iterable) this.f11301b).iterator();
                    try {
                        if (!it.hasNext()) {
                            mVar.a(bVar);
                            mVar.onComplete();
                        } else {
                            f5.m mVar2 = new f5.m(mVar, it);
                            mVar.a(mVar2);
                            if (!mVar2.f11408d) {
                                while (!mVar2.f11407c) {
                                    try {
                                        Object next = mVar2.f11406b.next();
                                        z4.b.a(next, "The iterator returned a null value");
                                        mVar2.f11405a.b(next);
                                        if (mVar2.f11407c) {
                                            break;
                                        } else {
                                            try {
                                                if (!mVar2.f11406b.hasNext()) {
                                                    if (!mVar2.f11407c) {
                                                        mVar2.f11405a.onComplete();
                                                    }
                                                    break;
                                                }
                                            } catch (Throwable th) {
                                                r2.q.y0(th);
                                                mVar2.f11405a.onError(th);
                                                return;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        r2.q.y0(th2);
                                        mVar2.f11405a.onError(th2);
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        r2.q.y0(th3);
                        mVar.a(bVar);
                        mVar.onError(th3);
                        return;
                    }
                } catch (Throwable th4) {
                    r2.q.y0(th4);
                    mVar.a(bVar);
                    mVar.onError(th4);
                }
                break;
        }
    }
}
