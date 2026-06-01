package sg.bigo.ads.common.h.b;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static sg.bigo.ads.common.h.a a(String str) {
        a aVarC = i.c(str);
        if (aVarC != null) {
            return aVarC.f15761b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void b(T t3) {
        if (t3 == 0) {
            return;
        }
        if (t3.getClass() == String.class) {
            i.a((String) t3);
        } else {
            sg.bigo.ads.common.t.a.a(0, "DownloadHandler", "argument is only String or List ");
        }
    }

    public static void a() {
        Iterator<a> it = i.b().iterator();
        while (it.hasNext()) {
            i.a(it.next());
        }
        i.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(Context context, T t3) {
        if (t3 == 0) {
            return;
        }
        if (t3.getClass() == sg.bigo.ads.common.h.a.class) {
            a(context, (sg.bigo.ads.common.h.a) t3);
            return;
        }
        if (!(t3 instanceof List)) {
            sg.bigo.ads.common.t.a.a(0, "DownloadHandler", "argument is only Downloader or List ");
            return;
        }
        List list = (List) t3;
        if (list.size() <= 0 || list.get(0).getClass() != sg.bigo.ads.common.h.a.class) {
            sg.bigo.ads.common.t.a.a(0, "DownloadHandler", "argument of collect is only Downloader");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a(context, (sg.bigo.ads.common.h.a) it.next());
        }
    }

    private static void a(Context context, sg.bigo.ads.common.h.a aVar) {
        a aVarC = i.c(aVar.f15727a);
        if (aVarC != null) {
            if (aVarC.f15761b.equals(aVar)) {
                aVarC.b(aVar.g);
                aVarC.a(aVar.f15732i);
                aVarC.e = h.f15774a;
                f.a().a(aVar.f15727a);
                return;
            }
            a(aVar.f15727a);
        }
        a aVar2 = new a(aVar);
        aVar2.f15762c = new d(context, aVar2);
        aVar2.e = h.f15774a;
        i.b(aVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(T t3) {
        if (t3 == 0) {
            return;
        }
        if (t3.getClass() == String.class) {
            i.b((String) t3);
        } else {
            sg.bigo.ads.common.t.a.a(0, "DownloadHandler", "argument is only String or List ");
        }
    }

    public static void a(String str, e eVar) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList;
        f fVarA = f.a();
        if (!fVarA.f15771a.containsKey(str) || (copyOnWriteArrayList = fVarA.f15771a.get(str)) == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        if (copyOnWriteArrayList.contains(eVar)) {
            return;
        }
        copyOnWriteArrayList.add(eVar);
        fVarA.f15771a.put(str, copyOnWriteArrayList);
    }

    public static void a(boolean z2) {
        g.a(z2);
    }
}
