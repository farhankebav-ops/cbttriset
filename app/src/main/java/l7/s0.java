package l7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 extends t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g0 f12903d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f12904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f12905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f12906c;

    static {
        String str = g0.f12850b;
        f12903d = w1.f.d("/", false);
    }

    public s0(g0 g0Var, t tVar, LinkedHashMap linkedHashMap) {
        this.f12904a = g0Var;
        this.f12905b = tVar;
        this.f12906c = linkedHashMap;
    }

    public final List a(g0 g0Var, boolean z2) throws IOException {
        m7.k kVar = (m7.k) this.f12906c.get(f12903d.f(g0Var, true));
        if (kVar != null) {
            return r5.l.n1(kVar.f13029q);
        }
        if (z2) {
            throw new IOException(com.ironsource.adqualitysdk.sdk.i.a0.e(g0Var, "not a directory: "));
        }
        return null;
    }

    @Override // l7.t
    public final n0 appendingSink(g0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // l7.t
    public final void atomicMove(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // l7.t
    public final g0 canonicalize(g0 path) throws FileNotFoundException {
        kotlin.jvm.internal.k.e(path, "path");
        g0 g0Var = f12903d;
        g0Var.getClass();
        g0 g0VarB = m7.f.b(g0Var, path, true);
        if (this.f12906c.containsKey(g0VarB)) {
            return g0VarB;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override // l7.t
    public final void createDirectory(g0 dir, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // l7.t
    public final void createSymlink(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // l7.t
    public final void delete(g0 path, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // l7.t
    public final List list(g0 dir) throws IOException {
        kotlin.jvm.internal.k.e(dir, "dir");
        List listA = a(dir, true);
        kotlin.jvm.internal.k.b(listA);
        return listA;
    }

    @Override // l7.t
    public final List listOrNull(g0 dir) {
        kotlin.jvm.internal.k.e(dir, "dir");
        return a(dir, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0125  */
    @Override // l7.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final l7.r metadataOrNull(l7.g0 r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.s0.metadataOrNull(l7.g0):l7.r");
    }

    @Override // l7.t
    public final q openReadOnly(g0 file) {
        kotlin.jvm.internal.k.e(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // l7.t
    public final q openReadWrite(g0 file, boolean z2, boolean z7) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // l7.t
    public final n0 sink(g0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // l7.t
    public final o0 source(g0 file) throws Throwable {
        Throwable th;
        j0 j0VarC;
        kotlin.jvm.internal.k.e(file, "file");
        g0 g0Var = f12903d;
        g0Var.getClass();
        m7.k kVar = (m7.k) this.f12906c.get(m7.f.b(g0Var, file, true));
        if (kVar == null) {
            throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(file, "no such file: "));
        }
        long j = kVar.f13025f;
        q qVarOpenReadOnly = this.f12905b.openReadOnly(this.f12904a);
        try {
            j0VarC = b.c(qVarOpenReadOnly.k(kVar.h));
            try {
                qVarOpenReadOnly.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (qVarOpenReadOnly != null) {
                try {
                    qVarOpenReadOnly.close();
                } catch (Throwable th4) {
                    a.a.h(th3, th4);
                }
            }
            th = th3;
            j0VarC = null;
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.k.e(j0VarC, "<this>");
        m7.b.h(j0VarC, null);
        if (kVar.g == 0) {
            return new m7.h(j0VarC, j, true);
        }
        return new m7.h(new a0(b.c(new m7.h(j0VarC, kVar.e, true)), new Inflater(true)), j, false);
    }
}
