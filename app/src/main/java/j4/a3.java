package j4;

import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a3 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f12108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d5 f12110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g5 f12111d;
    public i4.k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f12112f;
    public int g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12113i;
    public boolean j;
    public e0 k;
    public e0 l;
    public long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12115o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12116q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f12117r;

    public a3(c cVar, int i2, d5 d5Var, g5 g5Var) {
        i4.j jVar = i4.j.f11874b;
        this.h = 1;
        this.f12113i = 5;
        this.l = new e0();
        this.f12114n = false;
        this.f12115o = -1;
        this.f12116q = false;
        this.f12117r = false;
        this.f12108a = cVar;
        this.e = jVar;
        this.f12109b = i2;
        this.f12110c = d5Var;
        r2.q.D(g5Var, "transportTracer");
        this.f12111d = g5Var;
    }

    public final void a() {
        if (this.f12114n) {
            return;
        }
        boolean z2 = true;
        this.f12114n = true;
        while (!this.f12117r && this.m > 0 && g()) {
            try {
                int iB = q0.c.b(this.h);
                if (iB == 0) {
                    e();
                } else {
                    if (iB != 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid state: ");
                        int i2 = this.h;
                        sb.append(i2 != 1 ? i2 != 2 ? "null" : "BODY" : "HEADER");
                        throw new AssertionError(sb.toString());
                    }
                    b();
                    this.m--;
                }
            } catch (Throwable th) {
                this.f12114n = false;
                throw th;
            }
        }
        if (this.f12117r) {
            close();
            this.f12114n = false;
            return;
        }
        if (this.f12116q) {
            if (this.l.f12168c != 0) {
                z2 = false;
            }
            if (z2) {
                close();
            }
        }
        this.f12114n = false;
    }

    public final void b() {
        Object z2Var;
        int i2 = this.f12115o;
        long j = this.p;
        d5 d5Var = this.f12110c;
        boolean z2 = false;
        for (i4.i iVar : d5Var.f12162a) {
            iVar.d(i2, j);
        }
        this.p = 0;
        if (this.j) {
            i4.k kVar = this.e;
            if (kVar == i4.j.f11874b) {
                throw i4.n1.l.h("Can't decode compressed gRPC message as compression not configured").a();
            }
            try {
                e0 e0Var = this.k;
                t3 t3Var = u3.f12491a;
                s3 s3Var = new s3();
                r2.q.D(e0Var, "buffer");
                s3Var.f12448a = e0Var;
                z2Var = new z2(kVar.e(s3Var), this.f12109b, d5Var);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            long j3 = this.k.f12168c;
            i4.i[] iVarArr = d5Var.f12162a;
            for (i4.i iVar2 : iVarArr) {
                iVar2.f(j3);
            }
            e0 e0Var2 = this.k;
            t3 t3Var2 = u3.f12491a;
            s3 s3Var2 = new s3();
            r2.q.D(e0Var2, "buffer");
            s3Var2.f12448a = e0Var2;
            z2Var = s3Var2;
        }
        this.k.getClass();
        this.k = null;
        c cVar = this.f12108a;
        a4.a aVar = new a4.a(18, z2);
        aVar.f3216b = z2Var;
        cVar.j.g(aVar);
        this.h = 1;
        this.f12113i = 5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (isClosed()) {
            return;
        }
        e0 e0Var = this.k;
        boolean z2 = e0Var != null && e0Var.f12168c > 0;
        try {
            e0 e0Var2 = this.l;
            if (e0Var2 != null) {
                e0Var2.close();
            }
            e0 e0Var3 = this.k;
            if (e0Var3 != null) {
                e0Var3.close();
            }
            this.l = null;
            this.k = null;
            this.f12108a.c(z2);
        } catch (Throwable th) {
            this.l = null;
            this.k = null;
            throw th;
        }
    }

    public final void e() {
        int iL = this.k.l();
        if ((iL & 254) != 0) {
            throw i4.n1.l.h("gRPC frame header malformed: reserved bits not zero").a();
        }
        this.j = (iL & 1) != 0;
        e0 e0Var = this.k;
        e0Var.a(4);
        int iL2 = e0Var.l() | (e0Var.l() << 24) | (e0Var.l() << 16) | (e0Var.l() << 8);
        this.f12113i = iL2;
        if (iL2 < 0 || iL2 > this.f12109b) {
            i4.n1 n1Var = i4.n1.j;
            Locale locale = Locale.US;
            throw n1Var.h("gRPC message exceeds maximum size " + this.f12109b + ": " + iL2).a();
        }
        int i2 = this.f12115o + 1;
        this.f12115o = i2;
        for (i4.i iVar : this.f12110c.f12162a) {
            iVar.c(i2);
        }
        g5 g5Var = this.f12111d;
        ((c2) g5Var.f12230c).a();
        ((e3) g5Var.f12229b).p();
        this.h = 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r0.a(r3);
        r8.p += r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        if (r8.h == 2) goto L17;
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g() throws java.lang.Throwable {
        /*
            r8 = this;
            j4.d5 r0 = r8.f12110c
            r1 = 2
            r2 = 0
            j4.e0 r3 = r8.k     // Catch: java.lang.Throwable -> L10
            if (r3 != 0) goto L12
            j4.e0 r3 = new j4.e0     // Catch: java.lang.Throwable -> L10
            r3.<init>()     // Catch: java.lang.Throwable -> L10
            r8.k = r3     // Catch: java.lang.Throwable -> L10
            goto L12
        L10:
            r3 = move-exception
            goto L5b
        L12:
            r3 = r2
        L13:
            int r4 = r8.f12113i     // Catch: java.lang.Throwable -> L48
            j4.e0 r5 = r8.k     // Catch: java.lang.Throwable -> L48
            int r5 = r5.f12168c     // Catch: java.lang.Throwable -> L48
            int r4 = r4 - r5
            if (r4 <= 0) goto L4d
            j4.e0 r5 = r8.l     // Catch: java.lang.Throwable -> L48
            int r5 = r5.f12168c     // Catch: java.lang.Throwable -> L48
            if (r5 != 0) goto L37
            if (r3 <= 0) goto L36
            j4.c r4 = r8.f12108a
            r4.a(r3)
            int r4 = r8.h
            if (r4 != r1) goto L36
        L2d:
            long r4 = (long) r3
            r0.a(r4)
            int r0 = r8.p
            int r0 = r0 + r3
            r8.p = r0
        L36:
            return r2
        L37:
            int r4 = java.lang.Math.min(r4, r5)     // Catch: java.lang.Throwable -> L48
            int r3 = r3 + r4
            j4.e0 r5 = r8.k     // Catch: java.lang.Throwable -> L48
            j4.e0 r6 = r8.l     // Catch: java.lang.Throwable -> L48
            j4.e r4 = r6.g(r4)     // Catch: java.lang.Throwable -> L48
            r5.q(r4)     // Catch: java.lang.Throwable -> L48
            goto L13
        L48:
            r2 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L5b
        L4d:
            r2 = 1
            if (r3 <= 0) goto L5a
            j4.c r4 = r8.f12108a
            r4.a(r3)
            int r4 = r8.h
            if (r4 != r1) goto L5a
            goto L2d
        L5a:
            return r2
        L5b:
            if (r2 <= 0) goto L6f
            j4.c r4 = r8.f12108a
            r4.a(r2)
            int r4 = r8.h
            if (r4 != r1) goto L6f
            long r4 = (long) r2
            r0.a(r4)
            int r0 = r8.p
            int r0 = r0 + r2
            r8.p = r0
        L6f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.a3.g():boolean");
    }

    public final boolean isClosed() {
        return this.l == null;
    }
}
