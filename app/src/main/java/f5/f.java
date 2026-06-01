package f5;

import com.google.firebase.inappmessaging.internal.t;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements s4.m, a5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.m f11374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u4.b f11375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a5.c f11376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11377d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f11378f;

    public f(s4.m mVar, Object obj, int i2) {
        this.e = i2;
        this.f11374a = mVar;
        this.f11378f = obj;
    }

    @Override // s4.m
    public final void a(u4.b bVar) {
        if (y4.a.f(this.f11375b, bVar)) {
            this.f11375b = bVar;
            if (bVar instanceof a5.c) {
                this.f11376c = (a5.c) bVar;
            }
            this.f11374a.a(this);
        }
    }

    @Override // s4.m
    public final void b(Object obj) {
        switch (this.e) {
            case 0:
                try {
                    if (((t) this.f11378f).test(obj)) {
                        this.f11374a.b(obj);
                    }
                } catch (Throwable th) {
                    q.y0(th);
                    this.f11375b.dispose();
                    onError(th);
                    return;
                }
                break;
            default:
                if (!this.f11377d) {
                    try {
                        Object objApply = ((x4.c) this.f11378f).apply(obj);
                        z4.b.a(objApply, "The mapper function returned a null value.");
                        this.f11374a.b(objApply);
                    } catch (Throwable th2) {
                        q.y0(th2);
                        this.f11375b.dispose();
                        onError(th2);
                    }
                    break;
                }
                break;
        }
    }

    @Override // a5.h
    public final void clear() {
        this.f11376c.clear();
    }

    @Override // a5.d
    public final int d(int i2) {
        switch (this.e) {
        }
        return 0;
    }

    @Override // u4.b
    public final void dispose() {
        this.f11375b.dispose();
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return this.f11376c.isEmpty();
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // s4.m
    public final void onComplete() {
        if (this.f11377d) {
            return;
        }
        this.f11377d = true;
        this.f11374a.onComplete();
    }

    @Override // s4.m
    public final void onError(Throwable th) {
        if (this.f11377d) {
            n7.b.F(th);
        } else {
            this.f11377d = true;
            this.f11374a.onError(th);
        }
    }

    @Override // a5.h
    public final Object poll() {
        Object objPoll;
        switch (this.e) {
            case 0:
                break;
            default:
                Object objPoll2 = this.f11376c.poll();
                if (objPoll2 == null) {
                    return null;
                }
                Object objApply = ((x4.c) this.f11378f).apply(objPoll2);
                z4.b.a(objApply, "The mapper function returned a null value.");
                return objApply;
        }
        do {
            objPoll = this.f11376c.poll();
            if (objPoll != null) {
            }
            return objPoll;
        } while (!((t) this.f11378f).test(objPoll));
        return objPoll;
    }
}
