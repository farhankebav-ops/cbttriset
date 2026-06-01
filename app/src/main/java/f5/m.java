package f5;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m implements a5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.m f11405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator f11406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f11407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11408d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11409f;

    public m(s4.m mVar, Iterator it) {
        this.f11405a = mVar;
        this.f11406b = it;
    }

    @Override // a5.h
    public final void clear() {
        this.e = true;
    }

    @Override // a5.d
    public final int d(int i2) {
        this.f11408d = true;
        return 1;
    }

    @Override // u4.b
    public final void dispose() {
        this.f11407c = true;
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return this.e;
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // a5.h
    public final Object poll() {
        if (this.e) {
            return null;
        }
        boolean z2 = this.f11409f;
        Iterator it = this.f11406b;
        if (!z2) {
            this.f11409f = true;
        } else if (!it.hasNext()) {
            this.e = true;
            return null;
        }
        Object next = it.next();
        z4.b.a(next, "The iterator returned a null value");
        return next;
    }
}
