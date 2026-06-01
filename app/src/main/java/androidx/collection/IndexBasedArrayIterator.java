package androidx.collection;

import f6.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, a {
    private boolean canRemove;
    private int index;
    private int size;

    public IndexBasedArrayIterator(int i2) {
        this.size = i2;
    }

    public abstract T elementAt(int i2);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.size;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T tElementAt = elementAt(this.index);
        this.index++;
        this.canRemove = true;
        return tElementAt;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i2 = this.index - 1;
        this.index = i2;
        removeAt(i2);
        this.size--;
        this.canRemove = false;
    }

    public abstract void removeAt(int i2);
}
