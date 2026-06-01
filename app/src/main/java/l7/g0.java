package l7;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12850b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f12851a;

    static {
        String separator = File.separator;
        kotlin.jvm.internal.k.d(separator, "separator");
        f12850b = separator;
    }

    public g0(m bytes) {
        kotlin.jvm.internal.k.e(bytes, "bytes");
        this.f12851a = bytes;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iA = m7.f.a(this);
        m mVar = this.f12851a;
        if (iA == -1) {
            iA = 0;
        } else if (iA < mVar.d() && mVar.i(iA) == 92) {
            iA++;
        }
        int iD = mVar.d();
        int i2 = iA;
        while (iA < iD) {
            if (mVar.i(iA) == 47 || mVar.i(iA) == 92) {
                arrayList.add(mVar.p(i2, iA));
                i2 = iA + 1;
            }
            iA++;
        }
        if (i2 < mVar.d()) {
            arrayList.add(mVar.p(i2, mVar.d()));
        }
        return arrayList;
    }

    public final String b() {
        m mVar = m7.f.f13007a;
        m mVarQ = this.f12851a;
        int iK = m.k(mVarQ, mVar);
        if (iK == -1) {
            iK = m.k(mVarQ, m7.f.f13008b);
        }
        if (iK != -1) {
            mVarQ = m.q(mVarQ, iK + 1, 0, 2);
        } else if (h() != null && mVarQ.d() == 2) {
            mVarQ = m.f12880d;
        }
        return mVarQ.t();
    }

    public final g0 c() {
        m mVar = m7.f.f13010d;
        m mVar2 = this.f12851a;
        if (kotlin.jvm.internal.k.a(mVar2, mVar)) {
            return null;
        }
        m mVar3 = m7.f.f13007a;
        if (kotlin.jvm.internal.k.a(mVar2, mVar3)) {
            return null;
        }
        m mVar4 = m7.f.f13008b;
        if (kotlin.jvm.internal.k.a(mVar2, mVar4)) {
            return null;
        }
        m suffix = m7.f.e;
        mVar2.getClass();
        kotlin.jvm.internal.k.e(suffix, "suffix");
        int iD = mVar2.d();
        byte[] bArr = suffix.f12881a;
        if (mVar2.l(iD - bArr.length, suffix, bArr.length) && (mVar2.d() == 2 || mVar2.l(mVar2.d() - 3, mVar3, 1) || mVar2.l(mVar2.d() - 3, mVar4, 1))) {
            return null;
        }
        int iK = m.k(mVar2, mVar3);
        if (iK == -1) {
            iK = m.k(mVar2, mVar4);
        }
        if (iK == 2 && h() != null) {
            if (mVar2.d() == 3) {
                return null;
            }
            return new g0(m.q(mVar2, 0, 3, 1));
        }
        if (iK == 1 && mVar2.n(mVar4)) {
            return null;
        }
        if (iK != -1 || h() == null) {
            return iK == -1 ? new g0(mVar) : iK == 0 ? new g0(m.q(mVar2, 0, 1, 1)) : new g0(m.q(mVar2, 0, iK, 1));
        }
        if (mVar2.d() == 2) {
            return null;
        }
        return new g0(m.q(mVar2, 0, 2, 1));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g0 other = (g0) obj;
        kotlin.jvm.internal.k.e(other, "other");
        return this.f12851a.compareTo(other.f12851a);
    }

    public final g0 d(g0 other) {
        kotlin.jvm.internal.k.e(other, "other");
        m mVar = other.f12851a;
        int iA = m7.f.a(this);
        m mVar2 = this.f12851a;
        g0 g0Var = iA == -1 ? null : new g0(mVar2.p(0, iA));
        int iA2 = m7.f.a(other);
        if (!kotlin.jvm.internal.k.a(g0Var, iA2 != -1 ? new g0(mVar.p(0, iA2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        ArrayList arrayListA = a();
        ArrayList arrayListA2 = other.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i2 = 0;
        while (i2 < iMin && kotlin.jvm.internal.k.a(arrayListA.get(i2), arrayListA2.get(i2))) {
            i2++;
        }
        if (i2 == iMin && mVar2.d() == mVar.d()) {
            return w1.f.d(".", false);
        }
        if (arrayListA2.subList(i2, arrayListA2.size()).indexOf(m7.f.e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        if (kotlin.jvm.internal.k.a(mVar, m7.f.f13010d)) {
            return this;
        }
        j jVar = new j();
        m mVarC = m7.f.c(other);
        if (mVarC == null && (mVarC = m7.f.c(this)) == null) {
            mVarC = m7.f.f(f12850b);
        }
        int size = arrayListA2.size();
        for (int i8 = i2; i8 < size; i8++) {
            jVar.w(m7.f.e);
            jVar.w(mVarC);
        }
        int size2 = arrayListA.size();
        while (i2 < size2) {
            jVar.w((m) arrayListA.get(i2));
            jVar.w(mVarC);
            i2++;
        }
        return m7.f.d(jVar, false);
    }

    public final g0 e(String child) {
        kotlin.jvm.internal.k.e(child, "child");
        j jVar = new j();
        jVar.d0(child);
        return m7.f.b(this, m7.f.d(jVar, false), false);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof g0) && kotlin.jvm.internal.k.a(((g0) obj).f12851a, this.f12851a);
    }

    public final g0 f(g0 child, boolean z2) {
        kotlin.jvm.internal.k.e(child, "child");
        return m7.f.b(this, child, z2);
    }

    public final Path g() {
        Path path = Paths.get(this.f12851a.t(), new String[0]);
        kotlin.jvm.internal.k.d(path, "get(...)");
        return path;
    }

    public final Character h() {
        m mVar = m7.f.f13007a;
        m mVar2 = this.f12851a;
        if (m.g(mVar2, mVar) != -1 || mVar2.d() < 2 || mVar2.i(1) != 58) {
            return null;
        }
        char cI = (char) mVar2.i(0);
        if (('a' > cI || cI >= '{') && ('A' > cI || cI >= '[')) {
            return null;
        }
        return Character.valueOf(cI);
    }

    public final int hashCode() {
        return this.f12851a.hashCode();
    }

    public final File toFile() {
        return new File(this.f12851a.t());
    }

    public final String toString() {
        return this.f12851a.t();
    }
}
