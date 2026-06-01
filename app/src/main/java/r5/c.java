package r5;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends d7.i implements ListIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f13627d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, int i2) {
        super(eVar, 6);
        this.f13627d = eVar;
        b bVar = e.Companion;
        int size = eVar.size();
        bVar.getClass();
        b.c(i2, size);
        this.f11195b = i2;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f11195b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f11195b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f11195b - 1;
        this.f11195b = i2;
        return this.f13627d.get(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f11195b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
