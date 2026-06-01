package m7;

import com.ironsource.adqualitysdk.sdk.i.a0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import l7.g0;
import l7.n0;
import l7.o0;
import l7.q;
import l7.r;
import l7.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g0 f13016d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f13017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f13018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q5.m f13019c;

    static {
        String str = g0.f12850b;
        f13016d = w1.f.d("/", false);
    }

    public i(ClassLoader classLoader) {
        t systemFileSystem = t.SYSTEM;
        kotlin.jvm.internal.k.e(systemFileSystem, "systemFileSystem");
        this.f13017a = classLoader;
        this.f13018b = systemFileSystem;
        this.f13019c = n7.b.C(new androidx.activity.result.b(this, 9));
    }

    public static String a(g0 g0Var) {
        g0 g0Var2 = f13016d;
        return g0Var2.f(g0Var, true).d(g0Var2).f12851a.t();
    }

    @Override // l7.t
    public final n0 appendingSink(g0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // l7.t
    public final void atomicMove(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // l7.t
    public final g0 canonicalize(g0 path) {
        kotlin.jvm.internal.k.e(path, "path");
        return f13016d.f(path, true);
    }

    @Override // l7.t
    public final void createDirectory(g0 dir, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // l7.t
    public final void createSymlink(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // l7.t
    public final void delete(g0 path, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // l7.t
    public final List list(g0 dir) throws FileNotFoundException {
        kotlin.jvm.internal.k.e(dir, "dir");
        String strA = a(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z2 = false;
        for (q5.i iVar : (List) this.f13019c.getValue()) {
            t tVar = (t) iVar.f13498a;
            g0 g0Var = (g0) iVar.f13499b;
            try {
                List list = tVar.list(g0Var.e(strA));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (r4.c.b((g0) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(r5.n.L0(arrayList, 10));
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    arrayList2.add(r4.c.h((g0) obj2, g0Var));
                }
                r5.l.Q0(arrayList2, linkedHashSet);
                z2 = true;
            } catch (IOException unused) {
            }
        }
        if (z2) {
            return r5.l.n1(linkedHashSet);
        }
        throw new FileNotFoundException(a0.e(dir, "file not found: "));
    }

    @Override // l7.t
    public final List listOrNull(g0 dir) {
        kotlin.jvm.internal.k.e(dir, "dir");
        String strA = a(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = ((List) this.f13019c.getValue()).iterator();
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            q5.i iVar = (q5.i) it.next();
            t tVar = (t) iVar.f13498a;
            g0 g0Var = (g0) iVar.f13499b;
            List listListOrNull = tVar.listOrNull(g0Var.e(strA));
            if (listListOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listListOrNull) {
                    if (r4.c.b((g0) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(r5.n.L0(arrayList2, 10));
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    arrayList3.add(r4.c.h((g0) obj2, g0Var));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                r5.l.Q0(arrayList, linkedHashSet);
                z2 = true;
            }
        }
        if (z2) {
            return r5.l.n1(linkedHashSet);
        }
        return null;
    }

    @Override // l7.t
    public final r metadataOrNull(g0 path) {
        kotlin.jvm.internal.k.e(path, "path");
        if (!r4.c.b(path)) {
            return null;
        }
        String strA = a(path);
        for (q5.i iVar : (List) this.f13019c.getValue()) {
            r rVarMetadataOrNull = ((t) iVar.f13498a).metadataOrNull(((g0) iVar.f13499b).e(strA));
            if (rVarMetadataOrNull != null) {
                return rVarMetadataOrNull;
            }
        }
        return null;
    }

    @Override // l7.t
    public final q openReadOnly(g0 file) throws FileNotFoundException {
        kotlin.jvm.internal.k.e(file, "file");
        if (!r4.c.b(file)) {
            throw new FileNotFoundException(a0.e(file, "file not found: "));
        }
        String strA = a(file);
        for (q5.i iVar : (List) this.f13019c.getValue()) {
            try {
                return ((t) iVar.f13498a).openReadOnly(((g0) iVar.f13499b).e(strA));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException(a0.e(file, "file not found: "));
    }

    @Override // l7.t
    public final q openReadWrite(g0 file, boolean z2, boolean z7) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // l7.t
    public final n0 sink(g0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // l7.t
    public final o0 source(g0 file) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        if (!r4.c.b(file)) {
            throw new FileNotFoundException(a0.e(file, "file not found: "));
        }
        g0 g0Var = f13016d;
        g0Var.getClass();
        URL resource = this.f13017a.getResource(f.b(g0Var, file, false).d(g0Var).f12851a.t());
        if (resource == null) {
            throw new FileNotFoundException(a0.e(file, "file not found: "));
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        kotlin.jvm.internal.k.d(inputStream, "getInputStream(...)");
        return l7.b.j(inputStream);
    }
}
