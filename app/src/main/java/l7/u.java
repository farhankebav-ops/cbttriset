package l7;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.C2300e4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u extends t {
    private final t delegate;

    public u(t delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // l7.t
    public n0 appendingSink(g0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        return this.delegate.appendingSink(onPathParameter(file, "appendingSink", C2300e4.h.f8363b), z2);
    }

    @Override // l7.t
    public void atomicMove(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", "source"), onPathParameter(target, "atomicMove", TypedValues.AttributesType.S_TARGET));
    }

    @Override // l7.t
    public g0 canonicalize(g0 path) throws IOException {
        kotlin.jvm.internal.k.e(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    @Override // l7.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // l7.t
    public void createDirectory(g0 dir, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", "dir"), z2);
    }

    @Override // l7.t
    public void createSymlink(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        this.delegate.createSymlink(onPathParameter(source, "createSymlink", "source"), onPathParameter(target, "createSymlink", TypedValues.AttributesType.S_TARGET));
    }

    public final t delegate() {
        return this.delegate;
    }

    @Override // l7.t
    public void delete(g0 path, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), z2);
    }

    @Override // l7.t
    public List<g0> list(g0 dir) throws IOException {
        kotlin.jvm.internal.k.e(dir, "dir");
        List list = this.delegate.list(onPathParameter(dir, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((g0) it.next(), "list"));
        }
        r5.p.M0(arrayList);
        return arrayList;
    }

    @Override // l7.t
    public List<g0> listOrNull(g0 dir) {
        kotlin.jvm.internal.k.e(dir, "dir");
        List listListOrNull = this.delegate.listOrNull(onPathParameter(dir, "listOrNull", "dir"));
        if (listListOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listListOrNull.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((g0) it.next(), "listOrNull"));
        }
        r5.p.M0(arrayList);
        return arrayList;
    }

    @Override // l7.t
    public m6.h listRecursively(g0 dir, boolean z2) {
        kotlin.jvm.internal.k.e(dir, "dir");
        return m6.k.J0(this.delegate.listRecursively(onPathParameter(dir, "listRecursively", "dir"), z2), new androidx.camera.core.impl.utils.a(this, 13));
    }

    @Override // l7.t
    public r metadataOrNull(g0 path) throws IOException {
        kotlin.jvm.internal.k.e(path, "path");
        r rVarMetadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (rVarMetadataOrNull == null) {
            return null;
        }
        g0 g0Var = rVarMetadataOrNull.f12900c;
        if (g0Var == null) {
            return rVarMetadataOrNull;
        }
        g0 g0VarOnPathResult = onPathResult(g0Var, "metadataOrNull");
        boolean z2 = rVarMetadataOrNull.f12898a;
        boolean z7 = rVarMetadataOrNull.f12899b;
        Long l = rVarMetadataOrNull.f12901d;
        Long l8 = rVarMetadataOrNull.e;
        Long l9 = rVarMetadataOrNull.f12902f;
        Long l10 = rVarMetadataOrNull.g;
        Map extras = rVarMetadataOrNull.h;
        kotlin.jvm.internal.k.e(extras, "extras");
        return new r(z2, z7, g0VarOnPathResult, l, l8, l9, l10, extras);
    }

    public g0 onPathParameter(g0 path, String functionName, String parameterName) {
        kotlin.jvm.internal.k.e(path, "path");
        kotlin.jvm.internal.k.e(functionName, "functionName");
        kotlin.jvm.internal.k.e(parameterName, "parameterName");
        return path;
    }

    public g0 onPathResult(g0 path, String functionName) {
        kotlin.jvm.internal.k.e(path, "path");
        kotlin.jvm.internal.k.e(functionName, "functionName");
        return path;
    }

    @Override // l7.t
    public q openReadOnly(g0 file) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        return this.delegate.openReadOnly(onPathParameter(file, "openReadOnly", C2300e4.h.f8363b));
    }

    @Override // l7.t
    public q openReadWrite(g0 file, boolean z2, boolean z7) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        return this.delegate.openReadWrite(onPathParameter(file, "openReadWrite", C2300e4.h.f8363b), z2, z7);
    }

    @Override // l7.t
    public n0 sink(g0 file, boolean z2) {
        kotlin.jvm.internal.k.e(file, "file");
        return this.delegate.sink(onPathParameter(file, "sink", C2300e4.h.f8363b), z2);
    }

    @Override // l7.t
    public o0 source(g0 file) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        return this.delegate.source(onPathParameter(file, "source", C2300e4.h.f8363b));
    }

    public String toString() {
        return kotlin.jvm.internal.b0.a(getClass()).f() + '(' + this.delegate + ')';
    }
}
