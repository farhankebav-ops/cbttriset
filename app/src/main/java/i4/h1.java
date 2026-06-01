package i4;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f11869d = Logger.getLogger(h1.class.getName());
    public static h1 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11870a = "unknown";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f11871b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f2.h f11872c = f2.p.g;

    public final synchronized void a(g1 g1Var) {
        g1Var.getClass();
        this.f11871b.add(g1Var);
    }

    public final g1 b(String str) {
        f2.h hVar;
        if (str == null) {
            return null;
        }
        synchronized (this) {
            hVar = this.f11872c;
        }
        return (g1) ((f2.p) hVar).get(str.toLowerCase(Locale.US));
    }

    public final synchronized void c() {
        try {
            HashMap map = new HashMap();
            String str = "unknown";
            byte b8 = -2147483648;
            for (g1 g1Var : this.f11871b) {
                g1Var.getClass();
                if (((g1) map.get("dns")) == null) {
                    map.put("dns", g1Var);
                }
                if (b8 < 5) {
                    str = "dns";
                    b8 = 5;
                }
            }
            Set setEntrySet = map.entrySet();
            f2.g gVar = new f2.g(com.ironsource.adqualitysdk.sdk.i.a0.p(setEntrySet) ? setEntrySet.size() : 4);
            gVar.e(setEntrySet);
            this.f11872c = gVar.a();
            this.f11870a = str;
        } catch (Throwable th) {
            throw th;
        }
    }
}
