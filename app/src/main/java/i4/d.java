package i4;

import com.ironsource.C2300e4;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d {
    public static final d h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f11841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f11842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[][] f11843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11844d;
    public final Boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f11845f;
    public final Integer g;

    static {
        c cVar = new c();
        cVar.f11832c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        cVar.f11833d = Collections.EMPTY_LIST;
        h = new d(cVar);
    }

    public d(c cVar) {
        this.f11841a = cVar.f11830a;
        this.f11842b = cVar.f11831b;
        this.f11843c = cVar.f11832c;
        this.f11844d = cVar.f11833d;
        this.e = cVar.e;
        this.f11845f = cVar.f11834f;
        this.g = cVar.g;
    }

    public static c b(d dVar) {
        c cVar = new c();
        cVar.f11830a = dVar.f11841a;
        cVar.f11831b = dVar.f11842b;
        cVar.f11832c = dVar.f11843c;
        cVar.f11833d = dVar.f11844d;
        cVar.e = dVar.e;
        cVar.f11834f = dVar.f11845f;
        cVar.g = dVar.g;
        return cVar;
    }

    public final Object a(e2.f fVar) {
        r2.q.D(fVar, C2300e4.h.W);
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f11843c;
            if (i2 >= objArr.length) {
                return null;
            }
            if (fVar.equals(objArr[i2][0])) {
                return objArr[i2][1];
            }
            i2++;
        }
    }

    public final d c(e2.f fVar, Object obj) {
        Object[][] objArr;
        r2.q.D(fVar, C2300e4.h.W);
        c cVarB = b(this);
        int i2 = 0;
        while (true) {
            objArr = this.f11843c;
            if (i2 >= objArr.length) {
                i2 = -1;
                break;
            }
            if (fVar.equals(objArr[i2][0])) {
                break;
            }
            i2++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length + (i2 == -1 ? 1 : 0), 2);
        cVarB.f11832c = objArr2;
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        if (i2 == -1) {
            cVarB.f11832c[objArr.length] = new Object[]{fVar, obj};
        } else {
            cVarB.f11832c[i2] = new Object[]{fVar, obj};
        }
        return new d(cVarB);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f11841a, "deadline");
        iVarY.c(null, "authority");
        iVarY.c(null, "callCredentials");
        Executor executor = this.f11842b;
        iVarY.c(executor != null ? executor.getClass() : null, "executor");
        iVarY.c(null, "compressorName");
        iVarY.c(Arrays.deepToString(this.f11843c), "customOptions");
        iVarY.e("waitForReady", Boolean.TRUE.equals(this.e));
        iVarY.c(this.f11845f, "maxInboundMessageSize");
        iVarY.c(this.g, "maxOutboundMessageSize");
        iVarY.c(this.f11844d, "streamTracerFactories");
        return iVarY.toString();
    }
}
