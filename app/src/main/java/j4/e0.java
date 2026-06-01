package j4;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e0 extends e {
    public static final e3 e = new e3(4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e3 f12164f = new e3(5);
    public static final e3 g = new e3(6);
    public static final e3 h = new e3(7);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e3 f12165i = new e3(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f12166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f12167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12169d;

    public e0() {
        new ArrayDeque(2);
        this.f12166a = new ArrayDeque();
    }

    @Override // j4.e
    public final void b() throws IOException {
        ArrayDeque arrayDeque = this.f12167b;
        ArrayDeque arrayDeque2 = this.f12166a;
        if (arrayDeque == null) {
            this.f12167b = new ArrayDeque(Math.min(arrayDeque2.size(), 16));
        }
        while (!this.f12167b.isEmpty()) {
            ((e) this.f12167b.remove()).close();
        }
        this.f12169d = true;
        e eVar = (e) arrayDeque2.peek();
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // j4.e, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        while (true) {
            ArrayDeque arrayDeque = this.f12166a;
            if (arrayDeque.isEmpty()) {
                break;
            } else {
                ((e) arrayDeque.remove()).close();
            }
        }
        if (this.f12167b != null) {
            while (!this.f12167b.isEmpty()) {
                ((e) this.f12167b.remove()).close();
            }
        }
    }

    @Override // j4.e
    public final boolean e() {
        Iterator it = this.f12166a.iterator();
        while (it.hasNext()) {
            if (!((e) it.next()).e()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [j4.e] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [j4.e] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [j4.e0] */
    /* JADX WARN: Type inference failed for: r1v3, types: [j4.e0] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // j4.e
    public final e g(int i2) throws IOException {
        e eVarG;
        int i8;
        e eVarG2;
        ?? r1;
        ?? r02;
        if (i2 <= 0) {
            return u3.f12491a;
        }
        a(i2);
        this.f12168c -= i2;
        ?? r03 = 0;
        ?? e0Var = 0;
        while (true) {
            ArrayDeque arrayDeque = this.f12166a;
            e eVar = (e) arrayDeque.peek();
            int iN = eVar.n();
            if (iN > i2) {
                eVarG2 = eVar.g(i2);
                i8 = 0;
            } else {
                if (this.f12169d) {
                    eVarG = eVar.g(iN);
                    r();
                } else {
                    eVarG = (e) arrayDeque.poll();
                }
                e eVar2 = eVarG;
                i8 = i2 - iN;
                eVarG2 = eVar2;
            }
            if (r03 == 0) {
                r02 = eVarG2;
                r1 = e0Var;
            } else {
                if (e0Var == 0) {
                    e0Var = new e0(i8 != 0 ? Math.min(arrayDeque.size() + 2, 16) : 2);
                    e0Var.q(r03);
                    r03 = e0Var;
                }
                e0Var.q(eVarG2);
                r02 = r03;
                r1 = e0Var;
            }
            if (i8 <= 0) {
                return r02;
            }
            i2 = i8;
            r03 = r02;
            e0Var = r1;
        }
    }

    @Override // j4.e
    public final void i(OutputStream outputStream, int i2) throws IOException {
        s(f12165i, i2, outputStream, 0);
    }

    @Override // j4.e
    public final void j(ByteBuffer byteBuffer) {
        t(h, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // j4.e
    public final void k(byte[] bArr, int i2, int i8) {
        t(g, i8, bArr, i2);
    }

    @Override // j4.e
    public final int l() {
        return t(e, 1, null, 0);
    }

    @Override // j4.e
    public final int n() {
        return this.f12168c;
    }

    @Override // j4.e
    public final void o() {
        if (!this.f12169d) {
            throw new InvalidMarkException();
        }
        ArrayDeque arrayDeque = this.f12166a;
        e eVar = (e) arrayDeque.peek();
        if (eVar != null) {
            int iN = eVar.n();
            eVar.o();
            this.f12168c = (eVar.n() - iN) + this.f12168c;
        }
        while (true) {
            e eVar2 = (e) this.f12167b.pollLast();
            if (eVar2 == null) {
                return;
            }
            eVar2.o();
            arrayDeque.addFirst(eVar2);
            this.f12168c = eVar2.n() + this.f12168c;
        }
    }

    @Override // j4.e
    public final void p(int i2) {
        t(f12164f, i2, null, 0);
    }

    public final void q(e eVar) throws IOException {
        boolean z2 = this.f12169d;
        ArrayDeque arrayDeque = this.f12166a;
        boolean z7 = z2 && arrayDeque.isEmpty();
        if (eVar instanceof e0) {
            e0 e0Var = (e0) eVar;
            ArrayDeque arrayDeque2 = e0Var.f12166a;
            while (!arrayDeque2.isEmpty()) {
                arrayDeque.add((e) arrayDeque2.remove());
            }
            this.f12168c += e0Var.f12168c;
            e0Var.f12168c = 0;
            e0Var.close();
        } else {
            arrayDeque.add(eVar);
            this.f12168c = eVar.n() + this.f12168c;
        }
        if (z7) {
            ((e) arrayDeque.peek()).b();
        }
    }

    public final void r() throws IOException {
        boolean z2 = this.f12169d;
        ArrayDeque arrayDeque = this.f12166a;
        if (!z2) {
            ((e) arrayDeque.remove()).close();
            return;
        }
        this.f12167b.add((e) arrayDeque.remove());
        e eVar = (e) arrayDeque.peek();
        if (eVar != null) {
            eVar.b();
        }
    }

    public final int s(d0 d0Var, int i2, Object obj, int i8) throws IOException {
        a(i2);
        ArrayDeque arrayDeque = this.f12166a;
        if (!arrayDeque.isEmpty() && ((e) arrayDeque.peek()).n() == 0) {
            r();
        }
        while (i2 > 0 && !arrayDeque.isEmpty()) {
            e eVar = (e) arrayDeque.peek();
            int iMin = Math.min(i2, eVar.n());
            i8 = d0Var.f(eVar, iMin, obj, i8);
            i2 -= iMin;
            this.f12168c -= iMin;
            if (((e) arrayDeque.peek()).n() == 0) {
                r();
            }
        }
        if (i2 <= 0) {
            return i8;
        }
        throw new AssertionError("Failed executing read operation");
    }

    public final int t(c0 c0Var, int i2, Object obj, int i8) {
        try {
            return s(c0Var, i2, obj, i8);
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    public e0(int i2) {
        new ArrayDeque(2);
        this.f12166a = new ArrayDeque(i2);
    }
}
