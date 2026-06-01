package m6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements Iterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f12983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f12984d;

    public g(m mVar) {
        this.f12981a = 1;
        this.f12984d = mVar;
        this.f12983c = mVar.f12991a.iterator();
    }

    public void a() {
        Object objInvoke;
        c6.i iVar = (c6.i) this.f12984d;
        if (this.f12982b == -2) {
            objInvoke = ((e6.a) iVar.f4232b).invoke();
        } else {
            e6.l lVar = (e6.l) iVar.f4233c;
            Object obj = this.f12983c;
            kotlin.jvm.internal.k.b(obj);
            objInvoke = lVar.invoke(obj);
        }
        this.f12983c = objInvoke;
        this.f12982b = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f12981a) {
            case 0:
                if (this.f12982b < 0) {
                    a();
                }
                if (this.f12982b == 1) {
                }
                break;
            default:
                m mVar = (m) this.f12984d;
                Iterator it = (Iterator) this.f12983c;
                while (this.f12982b < mVar.f12992b && it.hasNext()) {
                    it.next();
                    this.f12982b++;
                }
                if (this.f12982b >= mVar.f12993c || !it.hasNext()) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f12981a) {
            case 0:
                if (this.f12982b < 0) {
                    a();
                }
                if (this.f12982b == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.f12983c;
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f12982b = -1;
                return obj;
            default:
                m mVar = (m) this.f12984d;
                Iterator it = (Iterator) this.f12983c;
                while (this.f12982b < mVar.f12992b && it.hasNext()) {
                    it.next();
                    this.f12982b++;
                }
                int i2 = this.f12982b;
                if (i2 >= mVar.f12993c) {
                    throw new NoSuchElementException();
                }
                this.f12982b = i2 + 1;
                return it.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f12981a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public g(c6.i iVar) {
        this.f12981a = 0;
        this.f12984d = iVar;
        this.f12982b = -2;
    }
}
