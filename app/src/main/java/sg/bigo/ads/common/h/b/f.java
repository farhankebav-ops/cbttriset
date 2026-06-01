package sg.bigo.ads.common.h.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes6.dex */
final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f f15770b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HashMap<String, CopyOnWriteArrayList<e>> f15771a = new HashMap<>();

    /* JADX INFO: renamed from: sg.bigo.ads.common.h.b.f$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15772a;

        static {
            int[] iArr = new int[h.a().length];
            f15772a = iArr;
            try {
                iArr[h.f15774a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15772a[h.f15775b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15772a[h.f15776c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15772a[h.f15777d - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15772a[h.e - 1] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15772a[h.f15778f - 1] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15772a[h.g - 1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static f a() {
        return f15770b;
    }

    public final void b(String str) {
        if (!this.f15771a.containsKey(str) || this.f15771a.get(str) == null) {
            return;
        }
        this.f15771a.get(str).clear();
    }

    public final void a(String str) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList;
        a aVarC;
        if (!this.f15771a.containsKey(str) || (copyOnWriteArrayList = this.f15771a.get(str)) == null || (aVarC = i.c(str)) == null) {
            return;
        }
        a(aVarC, copyOnWriteArrayList);
    }

    private void a(String str, e eVar) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList;
        if (this.f15771a.containsKey(str) && (copyOnWriteArrayList = this.f15771a.get(str)) != null && copyOnWriteArrayList.contains(eVar)) {
            copyOnWriteArrayList.remove(eVar);
        }
    }

    private void a(a aVar, CopyOnWriteArrayList<e> copyOnWriteArrayList) {
        switch (AnonymousClass1.f15772a[aVar.e - 1]) {
            case 1:
                Iterator<e> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                break;
            case 2:
                Iterator<e> it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
                break;
            case 3:
                Iterator<e> it3 = copyOnWriteArrayList.iterator();
                while (it3.hasNext()) {
                    it3.next().a(aVar.f15760a);
                }
                break;
            case 4:
                for (e eVar : copyOnWriteArrayList) {
                    String str = aVar.f15760a;
                    j.a(aVar.f15763d);
                    eVar.b(str);
                }
                break;
            case 5:
                Iterator<e> it4 = copyOnWriteArrayList.iterator();
                while (it4.hasNext()) {
                    it4.next().c(aVar.f15760a);
                }
                break;
            case 6:
                for (e eVar2 : copyOnWriteArrayList) {
                    eVar2.d(aVar.f15760a);
                    a(aVar.f15760a, eVar2);
                }
                break;
            case 7:
                for (e eVar3 : copyOnWriteArrayList) {
                    eVar3.a(aVar.f15760a, aVar.f15764f, aVar.f15761b.g);
                    a(aVar.f15760a, eVar3);
                }
                break;
        }
    }
}
