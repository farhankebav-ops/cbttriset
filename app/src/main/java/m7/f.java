package m7;

import l7.g0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l7.m f13007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l7.m f13008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l7.m f13009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l7.m f13010d;
    public static final l7.m e;

    static {
        l7.m mVar = l7.m.f12880d;
        f13007a = r4.c.e("/");
        f13008b = r4.c.e("\\");
        f13009c = r4.c.e("/\\");
        f13010d = r4.c.e(".");
        e = r4.c.e("..");
    }

    public static final int a(g0 g0Var) {
        l7.m mVar = g0Var.f12851a;
        if (mVar.d() != 0) {
            if (mVar.i(0) != 47) {
                if (mVar.i(0) == 92) {
                    if (mVar.d() > 2 && mVar.i(1) == 92) {
                        l7.m other = f13008b;
                        kotlin.jvm.internal.k.e(other, "other");
                        int iF = mVar.f(other.h(), 2);
                        return iF == -1 ? mVar.d() : iF;
                    }
                } else if (mVar.d() > 2 && mVar.i(1) == 58 && mVar.i(2) == 92) {
                    char cI = (char) mVar.i(0);
                    if ('a' <= cI && cI < '{') {
                        return 3;
                    }
                    if ('A' <= cI && cI < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final g0 b(g0 g0Var, g0 child, boolean z2) {
        kotlin.jvm.internal.k.e(child, "child");
        if (a(child) != -1 || child.h() != null) {
            return child;
        }
        l7.m mVarC = c(g0Var);
        if (mVarC == null && (mVarC = c(child)) == null) {
            mVarC = f(g0.f12850b);
        }
        l7.j jVar = new l7.j();
        jVar.w(g0Var.f12851a);
        if (jVar.f12868b > 0) {
            jVar.w(mVarC);
        }
        jVar.w(child.f12851a);
        return d(jVar, z2);
    }

    public static final l7.m c(g0 g0Var) {
        l7.m mVar = g0Var.f12851a;
        l7.m mVar2 = f13007a;
        if (l7.m.g(mVar, mVar2) != -1) {
            return mVar2;
        }
        l7.m mVar3 = g0Var.f12851a;
        l7.m mVar4 = f13008b;
        if (l7.m.g(mVar3, mVar4) != -1) {
            return mVar4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011b A[EDGE_INSN: B:101:0x011b->B:84:0x011b BREAK  A[LOOP:1: B:53:0x00ab->B:116:0x00ab], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final l7.g0 d(l7.j r17, boolean r18) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.f.d(l7.j, boolean):l7.g0");
    }

    public static final l7.m e(byte b8) {
        if (b8 == 47) {
            return f13007a;
        }
        if (b8 == 92) {
            return f13008b;
        }
        throw new IllegalArgumentException(a1.a.g(b8, "not a directory separator: "));
    }

    public static final l7.m f(String str) {
        if (kotlin.jvm.internal.k.a(str, "/")) {
            return f13007a;
        }
        if (kotlin.jvm.internal.k.a(str, "\\")) {
            return f13008b;
        }
        throw new IllegalArgumentException(a1.a.l("not a directory separator: ", str));
    }
}
