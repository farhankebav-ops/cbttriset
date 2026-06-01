package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class TreeIterator<T> implements Iterator<T>, f6.a {
    private final e6.l getChildIterator;
    private Iterator<? extends T> iterator;
    private final List<Iterator<T>> stack = new ArrayList();

    public TreeIterator(Iterator<? extends T> it, e6.l lVar) {
        this.getChildIterator = lVar;
        this.iterator = it;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private final void prepareNextIterator(T t3) {
        Iterator<? extends T> it = (Iterator) this.getChildIterator.invoke(t3);
        if (it != null && it.hasNext()) {
            this.stack.add((Iterator<T>) this.iterator);
            this.iterator = it;
        } else {
            while (!this.iterator.hasNext() && !this.stack.isEmpty()) {
                this.iterator = (Iterator) r5.l.d1(this.stack);
                r5.l.h1(this.stack);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        T next = this.iterator.next();
        prepareNextIterator(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
