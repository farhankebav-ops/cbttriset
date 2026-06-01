package q5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r implements Collection, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f13514a;

    public /* synthetic */ r(int[] iArr) {
        this.f13514a = iArr;
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        int i2 = ((q) obj).f13513a;
        int[] iArr = this.f13514a;
        int length = iArr.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                i8 = -1;
                break;
            }
            if (i2 == iArr[i8]) {
                break;
            }
            i8++;
        }
        return i8 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        if (!elements.isEmpty()) {
            for (Object obj : elements) {
                if (obj instanceof q) {
                    int i2 = ((q) obj).f13513a;
                    int[] iArr = this.f13514a;
                    int length = iArr.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length) {
                            i8 = -1;
                            break;
                        }
                        if (i2 == iArr[i8]) {
                            break;
                        }
                        i8++;
                    }
                    if (i8 >= 0) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return kotlin.jvm.internal.k.a(this.f13514a, ((r) obj).f13514a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f13514a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f13514a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new d7.i(this.f13514a, 3);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f13514a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.k.m(this);
    }

    public final String toString() {
        return "UIntArray(storage=" + Arrays.toString(this.f13514a) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        return kotlin.jvm.internal.k.n(this, array);
    }
}
