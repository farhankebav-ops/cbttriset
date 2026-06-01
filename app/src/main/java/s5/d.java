package s5;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements Iterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f13699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13702d;
    public final /* synthetic */ int e;

    public d(f map, int i2) {
        this.e = i2;
        k.e(map, "map");
        this.f13699a = map;
        this.f13701c = -1;
        this.f13702d = map.h;
        b();
    }

    public final void a() {
        if (this.f13699a.h != this.f13702d) {
            throw new ConcurrentModificationException();
        }
    }

    public final void b() {
        while (true) {
            int i2 = this.f13700b;
            f fVar = this.f13699a;
            if (i2 >= fVar.f13711f || fVar.f13709c[i2] >= 0) {
                return;
            } else {
                this.f13700b = i2 + 1;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13700b < this.f13699a.f13711f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.e) {
            case 0:
                a();
                int i2 = this.f13700b;
                f fVar = this.f13699a;
                if (i2 >= fVar.f13711f) {
                    throw new NoSuchElementException();
                }
                this.f13700b = i2 + 1;
                this.f13701c = i2;
                e eVar = new e(fVar, i2);
                b();
                return eVar;
            case 1:
                a();
                int i8 = this.f13700b;
                f fVar2 = this.f13699a;
                if (i8 >= fVar2.f13711f) {
                    throw new NoSuchElementException();
                }
                this.f13700b = i8 + 1;
                this.f13701c = i8;
                Object obj = fVar2.f13707a[i8];
                b();
                return obj;
            default:
                a();
                int i9 = this.f13700b;
                f fVar3 = this.f13699a;
                if (i9 >= fVar3.f13711f) {
                    throw new NoSuchElementException();
                }
                this.f13700b = i9 + 1;
                this.f13701c = i9;
                Object[] objArr = fVar3.f13708b;
                k.b(objArr);
                Object obj2 = objArr[this.f13701c];
                b();
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        if (this.f13701c == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        f fVar = this.f13699a;
        fVar.c();
        fVar.l(this.f13701c);
        this.f13701c = -1;
        this.f13702d = fVar.h;
    }
}
