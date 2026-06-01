package u6;

import com.ironsource.adqualitysdk.sdk.i.a0;
import kotlin.jvm.internal.d0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v5.c[] f17543a = new v5.c[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e2.f f17544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e2.f f17545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e2.f f17546d;

    static {
        int i2 = 5;
        boolean z2 = false;
        f17544b = new e2.f("NULL", i2, z2);
        f17545c = new e2.f("UNINITIALIZED", i2, z2);
        f17546d = new e2.f("DONE", i2, z2);
    }

    public static /* synthetic */ t6.e a(l lVar, r6.c cVar, int i2, s6.a aVar, int i8) {
        v5.h hVar = cVar;
        if ((i8 & 1) != 0) {
            hVar = v5.i.f17610a;
        }
        if ((i8 & 2) != 0) {
            i2 = -3;
        }
        if ((i8 & 4) != 0) {
            aVar = s6.a.f13718a;
        }
        return lVar.e(hVar, i2, aVar);
    }

    public static final Object b(v5.h hVar, Object obj, Object obj2, e6.p pVar, v5.c frame) {
        Object objInvoke;
        Object objL = v6.a.l(hVar, obj2);
        try {
            s sVar = new s(frame, hVar);
            if (a0.p(pVar)) {
                d0.d(2, pVar);
                objInvoke = pVar.invoke(obj, sVar);
            } else {
                objInvoke = a.a.Z(pVar, obj, sVar);
            }
            v6.a.g(hVar, objL);
            if (objInvoke == w5.a.f17774a) {
                kotlin.jvm.internal.k.e(frame, "frame");
            }
            return objInvoke;
        } catch (Throwable th) {
            v6.a.g(hVar, objL);
            throw th;
        }
    }
}
