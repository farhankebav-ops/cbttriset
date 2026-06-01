package q4;

import i4.e1;
import i4.n1;
import i4.o0;
import i4.p0;
import i4.q0;
import j4.x1;
import j4.y4;
import j4.z4;
import java.util.List;
import java.util.Map;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u extends p0 {
    public static e1 d(Map map) {
        n nVar;
        n nVar2;
        Integer num;
        Integer num2;
        Integer num3 = 5;
        Integer num4 = 100;
        Long lI = x1.i("interval", map);
        Long lI2 = x1.i("baseEjectionTime", map);
        Long lI3 = x1.i("maxEjectionTime", map);
        Integer numF = x1.f("maxEjectionPercentage", map);
        Long lValueOf = lI != null ? lI : Long.valueOf(RealConnection.IDLE_CONNECTION_HEALTHY_NS);
        Long l = lI2 != null ? lI2 : 30000000000L;
        Long l8 = lI3 != null ? lI3 : 300000000000L;
        Integer num5 = numF != null ? numF : 10;
        Map mapG = x1.g("successRateEjection", map);
        List list = null;
        if (mapG != null) {
            Integer numF2 = x1.f("stdevFactor", mapG);
            Integer numF3 = x1.f("enforcementPercentage", mapG);
            Integer numF4 = x1.f("minimumHosts", mapG);
            Integer numF5 = x1.f("requestVolume", mapG);
            Integer num6 = numF2 != null ? numF2 : 1900;
            if (numF3 != null) {
                r2.q.x(numF3.intValue() >= 0 && numF3.intValue() <= 100);
                num = numF3;
            } else {
                num = num4;
            }
            if (numF4 != null) {
                r2.q.x(numF4.intValue() >= 0);
                num2 = numF4;
            } else {
                num2 = num3;
            }
            if (numF5 != null) {
                r2.q.x(numF5.intValue() >= 0);
            } else {
                numF5 = num4;
            }
            nVar = new n(num6, num, num2, numF5);
        } else {
            nVar = null;
        }
        Map mapG2 = x1.g("failurePercentageEjection", map);
        if (mapG2 != null) {
            Integer num7 = 85;
            Integer num8 = 50;
            Integer numF6 = x1.f("threshold", mapG2);
            Integer numF7 = x1.f("enforcementPercentage", mapG2);
            Integer numF8 = x1.f("minimumHosts", mapG2);
            Integer numF9 = x1.f("requestVolume", mapG2);
            if (numF6 != null) {
                r2.q.x(numF6.intValue() >= 0 && numF6.intValue() <= 100);
                num7 = numF6;
            }
            if (numF7 != null) {
                r2.q.x(numF7.intValue() >= 0 && numF7.intValue() <= 100);
                num4 = numF7;
            }
            if (numF8 != null) {
                r2.q.x(numF8.intValue() >= 0);
                num3 = numF8;
            }
            if (numF9 != null) {
                r2.q.x(numF9.intValue() >= 0);
                num8 = numF9;
            }
            nVar2 = new n(num7, num4, num3, num8);
        } else {
            nVar2 = null;
        }
        List listC = x1.c("childPolicy", map);
        if (listC != null) {
            x1.a(listC);
            list = listC;
        }
        List listS = z4.s(list);
        if (listS == null || listS.isEmpty()) {
            return new e1(n1.l.h("No child policy in outlier_detection_experimental LB policy: " + map));
        }
        e1 e1VarR = z4.r(listS, q0.b());
        if (e1VarR.f11855a != null) {
            return e1VarR;
        }
        y4 y4Var = (y4) e1VarR.f11856b;
        if (y4Var == null) {
            throw new IllegalStateException();
        }
        if (y4Var != null) {
            return new e1(new o(lValueOf, l, l8, num5, nVar, nVar2, y4Var));
        }
        throw new IllegalStateException();
    }

    @Override // i4.p0
    public final String a() {
        return "outlier_detection_experimental";
    }

    @Override // i4.p0
    public final o0 b(i4.x xVar) {
        return new t(xVar);
    }

    @Override // i4.p0
    public final e1 c(Map map) {
        try {
            return d(map);
        } catch (RuntimeException e) {
            return new e1(n1.m.g(e).h("Failed parsing configuration for outlier_detection_experimental"));
        }
    }
}
