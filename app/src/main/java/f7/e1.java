package f7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class e1 implements d7.g, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f11442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11444d = -1;
    public final String[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List[] f11445f;
    public final boolean[] g;
    public Object h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f11446i;
    public final Object j;
    public final Object k;

    public e1(String str, e0 e0Var, int i2) {
        this.f11441a = str;
        this.f11442b = e0Var;
        this.f11443c = i2;
        String[] strArr = new String[i2];
        for (int i8 = 0; i8 < i2; i8++) {
            strArr[i8] = "[UNINITIALIZED]";
        }
        this.e = strArr;
        int i9 = this.f11443c;
        this.f11445f = new List[i9];
        this.g = new boolean[i9];
        this.h = r5.s.f13639a;
        q5.g gVar = q5.g.f13495b;
        final int i10 = 0;
        this.f11446i = n7.b.B(gVar, new e6.a(this) { // from class: f7.d1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e1 f11436b;

            {
                this.f11436b = this;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, q5.f] */
            @Override // e6.a
            public final Object invoke() {
                b7.c[] cVarArrChildSerializers;
                ArrayList arrayList;
                b7.c[] cVarArrTypeParametersSerializers;
                switch (i10) {
                    case 0:
                        e0 e0Var2 = this.f11436b.f11442b;
                        return (e0Var2 == null || (cVarArrChildSerializers = e0Var2.childSerializers()) == null) ? c1.f11428b : cVarArrChildSerializers;
                    case 1:
                        e0 e0Var3 = this.f11436b.f11442b;
                        if (e0Var3 == null || (cVarArrTypeParametersSerializers = e0Var3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(cVarArrTypeParametersSerializers.length);
                            for (b7.c cVar : cVarArrTypeParametersSerializers) {
                                arrayList.add(cVar.getDescriptor());
                            }
                        }
                        return c1.c(arrayList);
                    default:
                        e1 e1Var = this.f11436b;
                        return Integer.valueOf(c1.e(e1Var, (d7.g[]) e1Var.j.getValue()));
                }
            }
        });
        final int i11 = 1;
        this.j = n7.b.B(gVar, new e6.a(this) { // from class: f7.d1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e1 f11436b;

            {
                this.f11436b = this;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, q5.f] */
            @Override // e6.a
            public final Object invoke() {
                b7.c[] cVarArrChildSerializers;
                ArrayList arrayList;
                b7.c[] cVarArrTypeParametersSerializers;
                switch (i11) {
                    case 0:
                        e0 e0Var2 = this.f11436b.f11442b;
                        return (e0Var2 == null || (cVarArrChildSerializers = e0Var2.childSerializers()) == null) ? c1.f11428b : cVarArrChildSerializers;
                    case 1:
                        e0 e0Var3 = this.f11436b.f11442b;
                        if (e0Var3 == null || (cVarArrTypeParametersSerializers = e0Var3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(cVarArrTypeParametersSerializers.length);
                            for (b7.c cVar : cVarArrTypeParametersSerializers) {
                                arrayList.add(cVar.getDescriptor());
                            }
                        }
                        return c1.c(arrayList);
                    default:
                        e1 e1Var = this.f11436b;
                        return Integer.valueOf(c1.e(e1Var, (d7.g[]) e1Var.j.getValue()));
                }
            }
        });
        final int i12 = 2;
        this.k = n7.b.B(gVar, new e6.a(this) { // from class: f7.d1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e1 f11436b;

            {
                this.f11436b = this;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, q5.f] */
            @Override // e6.a
            public final Object invoke() {
                b7.c[] cVarArrChildSerializers;
                ArrayList arrayList;
                b7.c[] cVarArrTypeParametersSerializers;
                switch (i12) {
                    case 0:
                        e0 e0Var2 = this.f11436b.f11442b;
                        return (e0Var2 == null || (cVarArrChildSerializers = e0Var2.childSerializers()) == null) ? c1.f11428b : cVarArrChildSerializers;
                    case 1:
                        e0 e0Var3 = this.f11436b.f11442b;
                        if (e0Var3 == null || (cVarArrTypeParametersSerializers = e0Var3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(cVarArrTypeParametersSerializers.length);
                            for (b7.c cVar : cVarArrTypeParametersSerializers) {
                                arrayList.add(cVar.getDescriptor());
                            }
                        }
                        return c1.c(arrayList);
                    default:
                        e1 e1Var = this.f11436b;
                        return Integer.valueOf(c1.e(e1Var, (d7.g[]) e1Var.j.getValue()));
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // f7.l
    public final Set a() {
        return this.h.keySet();
    }

    @Override // d7.g
    public final boolean b() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    @Override // d7.g
    public final int c(String name) {
        kotlin.jvm.internal.k.e(name, "name");
        Integer num = (Integer) this.h.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // d7.g
    public final int d() {
        return this.f11443c;
    }

    @Override // d7.g
    public final String e(int i2) {
        return this.e[i2];
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, q5.f] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, q5.f] */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e1) {
            d7.g gVar = (d7.g) obj;
            if (this.f11441a.equals(gVar.h()) && Arrays.equals((d7.g[]) this.j.getValue(), (d7.g[]) ((e1) obj).j.getValue())) {
                int iD = gVar.d();
                int i2 = this.f11443c;
                if (i2 == iD) {
                    for (int i8 = 0; i8 < i2; i8++) {
                        if (kotlin.jvm.internal.k.a(g(i8).h(), gVar.g(i8).h()) && kotlin.jvm.internal.k.a(g(i8).getKind(), gVar.g(i8).getKind())) {
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
        List list = this.f11445f[i2];
        return list == null ? r5.r.f13638a : list;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, q5.f] */
    @Override // d7.g
    public d7.g g(int i2) {
        return ((b7.c[]) this.f11446i.getValue())[i2].getDescriptor();
    }

    @Override // d7.g
    public final List getAnnotations() {
        return r5.r.f13638a;
    }

    @Override // d7.g
    public a.a getKind() {
        return d7.m.f11201b;
    }

    @Override // d7.g
    public final String h() {
        return this.f11441a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, q5.f] */
    public int hashCode() {
        return ((Number) this.k.getValue()).intValue();
    }

    @Override // d7.g
    public final boolean i(int i2) {
        return this.g[i2];
    }

    @Override // d7.g
    public boolean isInline() {
        return false;
    }

    public final void j(String name, boolean z2) {
        kotlin.jvm.internal.k.e(name, "name");
        int i2 = this.f11444d + 1;
        this.f11444d = i2;
        String[] strArr = this.e;
        strArr[i2] = name;
        this.g[i2] = z2;
        this.f11445f[i2] = null;
        if (i2 == this.f11443c - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i8 = 0; i8 < length; i8++) {
                map.put(strArr[i8], Integer.valueOf(i8));
            }
            this.h = map;
        }
    }

    public String toString() {
        return r5.l.c1(r2.q.D0(0, this.f11443c), ", ", this.f11441a.concat("("), ")", new androidx.camera.core.impl.utils.a(this, 8), 24);
    }
}
