package j4;

import androidx.core.app.NotificationCompat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2 f12527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f12528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f12529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n4 f12530d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f12531f;

    public w2(u2 u2Var, HashMap map, HashMap map2, n4 n4Var, Object obj, Map map3) {
        this.f12527a = u2Var;
        this.f12528b = Collections.unmodifiableMap(new HashMap(map));
        this.f12529c = Collections.unmodifiableMap(new HashMap(map2));
        this.f12530d = n4Var;
        this.e = obj;
        this.f12531f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public static w2 a(Map map, boolean z2, int i2, int i8, Object obj) {
        n4 n4Var;
        Map mapG;
        n4 n4Var2;
        if (z2) {
            if (map == null || (mapG = x1.g("retryThrottling", map)) == null) {
                n4Var2 = null;
            } else {
                float fFloatValue = x1.e("maxTokens", mapG).floatValue();
                float fFloatValue2 = x1.e("tokenRatio", mapG).floatValue();
                r2.q.H(fFloatValue > 0.0f, "maxToken should be greater than zero");
                r2.q.H(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
                n4Var2 = new n4(fFloatValue, fFloatValue2);
            }
            n4Var = n4Var2;
        } else {
            n4Var = null;
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Map mapG2 = map == null ? null : x1.g("healthCheckConfig", map);
        List<Map> listC = x1.c("methodConfig", map);
        if (listC == null) {
            listC = null;
        } else {
            x1.a(listC);
        }
        if (listC == null) {
            return new w2(null, map2, map3, n4Var, obj, mapG2);
        }
        u2 u2Var = null;
        for (Map map4 : listC) {
            u2 u2Var2 = new u2(map4, z2, i2, i8);
            List<Map> listC2 = x1.c("name", map4);
            if (listC2 == null) {
                listC2 = null;
            } else {
                x1.a(listC2);
            }
            if (listC2 != null && !listC2.isEmpty()) {
                for (Map map5 : listC2) {
                    String strH = x1.h(NotificationCompat.CATEGORY_SERVICE, map5);
                    String strH2 = x1.h("method", map5);
                    if (n7.b.R(strH)) {
                        r2.q.w(strH2, "missing service name for method %s", n7.b.R(strH2));
                        r2.q.w(map, "Duplicate default method config in service config %s", u2Var == null);
                        u2Var = u2Var2;
                    } else if (n7.b.R(strH2)) {
                        r2.q.w(strH, "Duplicate service %s", !map3.containsKey(strH));
                        map3.put(strH, u2Var2);
                    } else {
                        String strD = i4.c1.d(strH, strH2);
                        r2.q.w(strD, "Duplicate method name %s", !map2.containsKey(strD));
                        map2.put(strD, u2Var2);
                    }
                }
            }
        }
        return new w2(u2Var, map2, map3, n4Var, obj, mapG2);
    }

    public final v2 b() {
        if (this.f12529c.isEmpty() && this.f12528b.isEmpty() && this.f12527a == null) {
            return null;
        }
        return new v2(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && w2.class == obj.getClass()) {
            w2 w2Var = (w2) obj;
            if (Objects.equals(this.f12527a, w2Var.f12527a) && Objects.equals(this.f12528b, w2Var.f12528b) && Objects.equals(this.f12529c, w2Var.f12529c) && Objects.equals(this.f12530d, w2Var.f12530d) && Objects.equals(this.e, w2Var.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f12527a, this.f12528b, this.f12529c, this.f12530d, this.e);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f12527a, "defaultMethodConfig");
        iVarY.c(this.f12528b, "serviceMethodMap");
        iVarY.c(this.f12529c, "serviceMap");
        iVarY.c(this.f12530d, "retryThrottling");
        iVarY.c(this.e, "loadBalancingConfig");
        return iVarY.toString();
    }
}
