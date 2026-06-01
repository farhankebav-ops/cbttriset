package s5;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends r5.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f13714b;

    public /* synthetic */ g(f fVar, int i2) {
        this.f13713a = i2;
        this.f13714b = fVar;
    }

    @Override // r5.g
    public final int a() {
        switch (this.f13713a) {
        }
        return this.f13714b.f13712i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f13713a) {
            case 0:
                Map.Entry element = (Map.Entry) obj;
                k.e(element, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        switch (this.f13713a) {
            case 0:
                k.e(elements, "elements");
                throw new UnsupportedOperationException();
            default:
                k.e(elements, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f13713a) {
            case 0:
                this.f13714b.clear();
                break;
            default:
                this.f13714b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f13713a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                return this.f13714b.f((Map.Entry) obj);
            default:
                return this.f13714b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        switch (this.f13713a) {
            case 0:
                k.e(elements, "elements");
                return this.f13714b.e(elements);
            default:
                return super.containsAll(elements);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f13713a) {
        }
        return this.f13714b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f13713a) {
            case 0:
                f fVar = this.f13714b;
                fVar.getClass();
                return new d(fVar, 0);
            default:
                f fVar2 = this.f13714b;
                fVar2.getClass();
                return new d(fVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f13713a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    f fVar = this.f13714b;
                    fVar.getClass();
                    fVar.c();
                    int iH = fVar.h(entry.getKey());
                    if (iH >= 0) {
                        Object[] objArr = fVar.f13708b;
                        k.b(objArr);
                        if (k.a(objArr[iH], entry.getValue())) {
                            fVar.l(iH);
                            break;
                        }
                    }
                }
                break;
            default:
                f fVar2 = this.f13714b;
                fVar2.c();
                int iH2 = fVar2.h(obj);
                if (iH2 >= 0) {
                    fVar2.l(iH2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        switch (this.f13713a) {
            case 0:
                k.e(elements, "elements");
                this.f13714b.c();
                break;
            default:
                k.e(elements, "elements");
                this.f13714b.c();
                break;
        }
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        switch (this.f13713a) {
            case 0:
                k.e(elements, "elements");
                this.f13714b.c();
                break;
            default:
                k.e(elements, "elements");
                this.f13714b.c();
                break;
        }
        return super.retainAll(elements);
    }
}
