package c6;

import e2.s;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements Iterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f4228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f4229d;
    public final /* synthetic */ m6.h e;

    public g(i iVar) {
        this.f4226a = 0;
        this.e = iVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f4229d = arrayDeque;
        File rootFile = (File) iVar.f4232b;
        if (rootFile.isDirectory()) {
            arrayDeque.push(c(rootFile));
        } else if (!rootFile.isFile()) {
            this.f4227b = 2;
        } else {
            kotlin.jvm.internal.k.e(rootFile, "rootFile");
            arrayDeque.push(new e(rootFile));
        }
    }

    public void a() {
        m6.f fVar = (m6.f) this.e;
        Iterator it = (Iterator) this.f4228c;
        while (it.hasNext()) {
            Object next = it.next();
            boolean zBooleanValue = ((Boolean) fVar.f12980c.invoke(next)).booleanValue();
            fVar.getClass();
            if (zBooleanValue) {
                this.f4229d = next;
                this.f4227b = 1;
                return;
            }
        }
        this.f4227b = 0;
    }

    public void b() {
        Iterator it = (Iterator) this.f4228c;
        if (it.hasNext()) {
            Object next = it.next();
            if (((Boolean) ((m6.f) this.e).f12980c.invoke(next)).booleanValue()) {
                this.f4227b = 1;
                this.f4229d = next;
                return;
            }
        }
        this.f4227b = 0;
    }

    public c c(File rootDir) {
        int iOrdinal = ((j) ((i) this.e).f4233c).ordinal();
        if (iOrdinal == 0) {
            kotlin.jvm.internal.k.e(rootDir, "rootDir");
            return new f(rootDir);
        }
        if (iOrdinal != 1) {
            throw new s(3);
        }
        kotlin.jvm.internal.k.e(rootDir, "rootDir");
        return new d(rootDir);
    }

    public boolean d() {
        File file;
        File fileA;
        this.f4227b = 3;
        ArrayDeque arrayDeque = (ArrayDeque) this.f4229d;
        while (true) {
            h hVar = (h) arrayDeque.peek();
            if (hVar == null) {
                file = null;
                break;
            }
            fileA = hVar.a();
            if (fileA == null) {
                arrayDeque.pop();
            } else {
                if (fileA.equals(hVar.f4230a) || !fileA.isDirectory() || arrayDeque.size() >= Integer.MAX_VALUE) {
                    break;
                }
                arrayDeque.push(c(fileA));
            }
        }
        file = fileA;
        if (file != null) {
            this.f4228c = file;
            this.f4227b = 1;
        } else {
            this.f4227b = 2;
        }
        return this.f4227b == 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4226a) {
            case 0:
                int i2 = this.f4227b;
                if (i2 == 0) {
                    return d();
                }
                if (i2 == 1) {
                    return true;
                }
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
            case 1:
                if (this.f4227b == -1) {
                    a();
                }
                return this.f4227b == 1;
            default:
                if (this.f4227b == -1) {
                    b();
                }
                return this.f4227b == 1;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4226a) {
            case 0:
                int i2 = this.f4227b;
                if (i2 == 1) {
                    this.f4227b = 0;
                    return (File) this.f4228c;
                }
                if (i2 == 2 || !d()) {
                    throw new NoSuchElementException();
                }
                this.f4227b = 0;
                return (File) this.f4228c;
            case 1:
                if (this.f4227b == -1) {
                    a();
                }
                if (this.f4227b == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.f4229d;
                this.f4229d = null;
                this.f4227b = -1;
                return obj;
            default:
                if (this.f4227b == -1) {
                    b();
                }
                if (this.f4227b == 0) {
                    throw new NoSuchElementException();
                }
                Object obj2 = this.f4229d;
                this.f4229d = null;
                this.f4227b = -1;
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4226a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public g(m6.f fVar) {
        this.f4226a = 1;
        this.e = fVar;
        this.f4228c = fVar.f12979b.iterator();
        this.f4227b = -1;
    }

    public g(m6.f fVar, byte b8) {
        this.f4226a = 2;
        this.e = fVar;
        this.f4228c = fVar.f12979b.iterator();
        this.f4227b = -1;
    }
}
