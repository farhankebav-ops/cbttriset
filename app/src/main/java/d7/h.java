package d7;

import f7.c1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r2.q;
import r5.u;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements g, f7.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.a f11189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11191d;
    public final HashSet e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f11192f;
    public final g[] g;
    public final List[] h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean[] f11193i;
    public final Map j;
    public final g[] k;
    public final q5.m l;

    public h(String serialName, a.a aVar, int i2, List list, a aVar2) {
        kotlin.jvm.internal.k.e(serialName, "serialName");
        this.f11188a = serialName;
        this.f11189b = aVar;
        this.f11190c = i2;
        this.f11191d = aVar2.f11174b;
        ArrayList arrayList = aVar2.f11175c;
        kotlin.jvm.internal.k.e(arrayList, "<this>");
        HashSet hashSet = new HashSet(x.d0(r5.n.L0(arrayList, 12)));
        r5.l.l1(arrayList, hashSet);
        this.e = hashSet;
        int i8 = 0;
        this.f11192f = (String[]) arrayList.toArray(new String[0]);
        this.g = c1.c(aVar2.e);
        this.h = (List[]) aVar2.f11177f.toArray(new List[0]);
        ArrayList arrayList2 = aVar2.g;
        kotlin.jvm.internal.k.e(arrayList2, "<this>");
        boolean[] zArr = new boolean[arrayList2.size()];
        int size = arrayList2.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList2.get(i9);
            i9++;
            zArr[i8] = ((Boolean) obj).booleanValue();
            i8++;
        }
        this.f11193i = zArr;
        String[] strArr = this.f11192f;
        kotlin.jvm.internal.k.e(strArr, "<this>");
        j jVar = new j(new androidx.activity.result.b(strArr, 15), 2);
        ArrayList arrayList3 = new ArrayList(r5.n.L0(jVar, 10));
        Iterator it = jVar.iterator();
        while (true) {
            m6.b bVar = (m6.b) it;
            if (!bVar.f12973c.hasNext()) {
                this.j = x.m0(arrayList3);
                this.k = c1.c(list);
                this.l = n7.b.C(new androidx.activity.result.b(this, 6));
                return;
            }
            u uVar = (u) bVar.next();
            arrayList3.add(new q5.i(uVar.f13642b, Integer.valueOf(uVar.f13641a)));
        }
    }

    @Override // f7.l
    public final Set a() {
        return this.e;
    }

    @Override // d7.g
    public final boolean b() {
        return false;
    }

    @Override // d7.g
    public final int c(String name) {
        kotlin.jvm.internal.k.e(name, "name");
        Integer num = (Integer) this.j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // d7.g
    public final int d() {
        return this.f11190c;
    }

    @Override // d7.g
    public final String e(int i2) {
        return this.f11192f[i2];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            g gVar = (g) obj;
            if (kotlin.jvm.internal.k.a(this.f11188a, gVar.h()) && Arrays.equals(this.k, ((h) obj).k)) {
                int iD = gVar.d();
                int i2 = this.f11190c;
                if (i2 == iD) {
                    for (int i8 = 0; i8 < i2; i8++) {
                        g[] gVarArr = this.g;
                        if (kotlin.jvm.internal.k.a(gVarArr[i8].h(), gVar.g(i8).h()) && kotlin.jvm.internal.k.a(gVarArr[i8].getKind(), gVar.g(i8).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d7.g
    public final List f(int i2) {
        return this.h[i2];
    }

    @Override // d7.g
    public final g g(int i2) {
        return this.g[i2];
    }

    @Override // d7.g
    public final List getAnnotations() {
        return this.f11191d;
    }

    @Override // d7.g
    public final a.a getKind() {
        return this.f11189b;
    }

    @Override // d7.g
    public final String h() {
        return this.f11188a;
    }

    public final int hashCode() {
        return ((Number) this.l.getValue()).intValue();
    }

    @Override // d7.g
    public final boolean i(int i2) {
        return this.f11193i[i2];
    }

    @Override // d7.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return r5.l.c1(q.D0(0, this.f11190c), ", ", a1.a.e('(', this.f11188a, new StringBuilder()), ")", new androidx.camera.core.impl.utils.a(this, 6), 24);
    }
}
