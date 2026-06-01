package j4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class z4 implements e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i4.a f12572a = new i4.a("io.grpc.internal.GrpcAttributes.securityLevel");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i4.a f12573b = new i4.a("io.grpc.internal.GrpcAttributes.clientEagAttrs");

    public static c2 c() {
        return v3.e == null ? new v3() : new g(0);
    }

    public static Set f(String str, Map map) {
        i4.m1 m1VarValueOf;
        List listC = x1.c(str, map);
        if (listC == null) {
            return null;
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(i4.m1.class);
        for (Object obj : listC) {
            if (obj instanceof Double) {
                Double d8 = (Double) obj;
                int iIntValue = d8.intValue();
                n7.b.V(obj, "Status code %s is not integral", ((double) iIntValue) == d8.doubleValue());
                m1VarValueOf = i4.n1.d(iIntValue).f11918a;
                n7.b.V(obj, "Status code %s is not valid", m1VarValueOf.f11909a == d8.intValue());
            } else {
                if (!(obj instanceof String)) {
                    throw new e2.s("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass(), 0);
                }
                try {
                    m1VarValueOf = i4.m1.valueOf((String) obj);
                } catch (IllegalArgumentException e) {
                    throw new e2.s("Status code " + obj + " is not valid", e, 0);
                }
            }
            enumSetNoneOf.add(m1VarValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    public static List g(Map map) {
        String strH;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            List listC = x1.c("loadBalancingConfig", map);
            if (listC == null) {
                listC = null;
            } else {
                x1.a(listC);
            }
            arrayList.addAll(listC);
        }
        if (arrayList.isEmpty() && (strH = x1.h("loadBalancingPolicy", map)) != null) {
            arrayList.add(Collections.singletonMap(strH.toLowerCase(Locale.ROOT), Collections.EMPTY_MAP));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static i4.e1 r(List list, i4.q0 q0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            x4 x4Var = (x4) it.next();
            String str = x4Var.f12552a;
            i4.p0 p0VarC = q0Var.c(str);
            if (p0VarC != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(z4.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                i4.e1 e1VarC = p0VarC.c(x4Var.f12553b);
                return e1VarC.f11855a != null ? e1VarC : new i4.e1(new y4(p0VarC, e1VarC.f11856b));
            }
            arrayList.add(str);
        }
        return new i4.e1(i4.n1.g.h("None of " + arrayList + " specified by Service Config are available."));
    }

    public static List s(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            if (map.size() != 1) {
                throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
            }
            String str = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
            arrayList.add(new x4(str, x1.g(str, map)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // j4.e5
    public void b(i4.k kVar) {
        ((d) this).f12152d.b(kVar);
    }

    @Override // j4.e5
    public void e(o4.a aVar) {
        try {
            if (!((d) this).f12152d.isClosed()) {
                ((d) this).f12152d.c(aVar);
            }
        } finally {
            f1.b(aVar);
        }
    }

    @Override // j4.e5
    public void flush() {
        c1 c1Var = ((d) this).f12152d;
        if (c1Var.isClosed()) {
            return;
        }
        c1Var.flush();
    }

    @Override // j4.e5
    public void j() {
        k4.j jVar = ((k4.k) this).f12652n;
        a3 a3Var = jVar.f12137d;
        a3Var.f12108a = jVar;
        jVar.f12134a = a3Var;
    }

    public abstract int o();

    public abstract boolean p(w4 w4Var);

    public abstract void q(w4 w4Var);

    @Override // j4.e5
    public void request() {
        k4.j jVar = ((k4.k) this).f12652n;
        jVar.getClass();
        r4.b.b();
        a4.c cVar = new a4.c(jVar, 2);
        synchronized (jVar.f12648w) {
            cVar.run();
        }
    }
}
