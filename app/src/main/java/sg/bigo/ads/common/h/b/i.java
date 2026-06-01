package sg.bigo.ads.common.h.b;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, a> f15779a = new HashMap();

    public static void a() {
        f15779a.clear();
    }

    public static Collection<a> b() {
        return f15779a.values();
    }

    public static a c(String str) {
        if (f15779a.containsKey(str)) {
            return f15779a.get(str);
        }
        return null;
    }

    public static void a(String str) {
        a aVarC = c(str);
        if (aVarC == null) {
            sg.bigo.ads.common.t.a.a(0, "TaskManager", "you add " + str + " to TaskQueue ?");
            return;
        }
        int i2 = aVarC.e;
        if (i2 == h.f15777d || i2 == h.f15778f) {
            sg.bigo.ads.common.t.a.a(0, 3, "TaskManager", "start downloadBean = ".concat(String.valueOf(aVarC)));
            return;
        }
        aVarC.e = h.f15775b;
        f.a().a(aVarC.f15760a);
        g.f15773a.execute(aVarC.f15762c);
    }

    public static void b(String str) {
        a aVarC = c(str);
        if (aVarC != null) {
            a(aVarC);
        } else {
            sg.bigo.ads.common.t.a.a(0, "TaskManager", "you add " + str + " to TaskQueue ?");
        }
        if (f15779a.containsKey(str)) {
            f15779a.remove(str);
        }
    }

    public static void a(a aVar) {
        aVar.f15764f = "It's remove !!!";
        if (aVar.e != h.f15778f) {
            aVar.e = h.g;
            f.a().a(aVar.f15760a);
        }
        f.a().b(aVar.f15760a);
        g.a(aVar.f15762c);
    }

    public static void b(a aVar) {
        if (f15779a.containsKey(aVar.f15760a)) {
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, "TaskManager", " " + f15779a.keySet().size());
        f15779a.put(aVar.f15760a, aVar);
    }
}
