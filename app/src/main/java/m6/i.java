package m6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import q5.x;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends j implements Iterator, v5.c, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f12987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v5.c f12988d;

    @Override // m6.j
    public final void a(Object obj, x5.a aVar) {
        this.f12986b = obj;
        this.f12985a = 3;
        this.f12988d = aVar;
        w5.a aVar2 = w5.a.f17774a;
    }

    public final RuntimeException b() {
        int i2 = this.f12985a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f12985a);
    }

    @Override // v5.c
    public final v5.h getContext() {
        return v5.i.f17610a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i2 = this.f12985a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator it = this.f12987c;
                kotlin.jvm.internal.k.b(it);
                if (it.hasNext()) {
                    this.f12985a = 2;
                    return true;
                }
                this.f12987c = null;
            }
            this.f12985a = 5;
            v5.c cVar = this.f12988d;
            kotlin.jvm.internal.k.b(cVar);
            this.f12988d = null;
            cVar.resumeWith(x.f13520a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f12985a;
        if (i2 == 0 || i2 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i2 == 2) {
            this.f12985a = 1;
            Iterator it = this.f12987c;
            kotlin.jvm.internal.k.b(it);
            return it.next();
        }
        if (i2 != 3) {
            throw b();
        }
        this.f12985a = 0;
        Object obj = this.f12986b;
        this.f12986b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // v5.c
    public final void resumeWith(Object obj) throws Throwable {
        q.z0(obj);
        this.f12985a = 4;
    }
}
