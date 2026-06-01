package h7;

import f7.c1;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class s extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g7.x f11774f;
    public final d7.g g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11775i;

    public /* synthetic */ s(g7.c cVar, g7.x xVar, String str, int i2) {
        this(cVar, xVar, (i2 & 4) != 0 ? null : str, (d7.g) null);
    }

    @Override // h7.a, e7.e
    public final e7.c beginStructure(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        d7.g gVar = this.g;
        if (descriptor != gVar) {
            return super.beginStructure(descriptor);
        }
        g7.m mVarD = d();
        String strH = gVar.h();
        if (mVarD instanceof g7.x) {
            return new s(this.f11734c, (g7.x) mVarD, this.f11735d, gVar);
        }
        throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.x.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarD.getClass()).f() + " as the serialized body of " + strH + " at element: " + s(), mVarD.toString(), -1);
    }

    @Override // h7.a
    public g7.m c(String tag) {
        kotlin.jvm.internal.k.e(tag, "tag");
        return (g7.m) r5.x.b0(q(), tag);
    }

    @Override // e7.c
    public int decodeElementIndex(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        while (this.h < descriptor.d()) {
            int i2 = this.h;
            this.h = i2 + 1;
            String strP = p(descriptor, i2);
            int i8 = this.h - 1;
            this.f11775i = false;
            if (!q().containsKey(strP)) {
                boolean z2 = (this.f11734c.f11598a.f11616d || descriptor.i(i8) || !descriptor.g(i8).b()) ? false : true;
                this.f11775i = z2;
                if (z2) {
                }
            }
            this.e.getClass();
            return i8;
        }
        return -1;
    }

    @Override // h7.a, e7.e
    public final boolean decodeNotNullMark() {
        return !this.f11775i && super.decodeNotNullMark();
    }

    @Override // h7.a, e7.c
    public void endStructure(d7.g descriptor) {
        Set setG;
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        g7.j jVar = this.e;
        if (jVar.f11614b || (descriptor.getKind() instanceof d7.d)) {
            return;
        }
        g7.c cVar = this.f11734c;
        o.m(descriptor, cVar);
        if (jVar.g) {
            Set setB = c1.b(descriptor);
            kotlin.jvm.internal.k.e(cVar, "<this>");
            Map map = (Map) cVar.f11600c.i(descriptor, o.f11766a);
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = r5.t.f13640a;
            }
            setG = n7.b.G(setB, setKeySet);
        } else {
            setG = c1.b(descriptor);
        }
        for (String key : q().f11628a.keySet()) {
            if (!setG.contains(key) && !kotlin.jvm.internal.k.a(key, this.f11735d)) {
                String input = q().toString();
                kotlin.jvm.internal.k.e(key, "key");
                kotlin.jvm.internal.k.e(input, "input");
                StringBuilder sbY = a1.a.y("Encountered an unknown key '", key, "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: ");
                sbY.append((Object) o.l(input, -1));
                throw o.c(-1, sbY.toString());
            }
        }
    }

    @Override // h7.a
    public String o(d7.g descriptor, int i2) {
        Object next;
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        g7.c cVar = this.f11734c;
        o.m(descriptor, cVar);
        String strE = descriptor.e(i2);
        if (this.e.g && !q().f11628a.keySet().contains(strE)) {
            kotlin.jvm.internal.k.e(cVar, "<this>");
            a4.a aVar = cVar.f11600c;
            f7.z zVar = new f7.z(1, descriptor, cVar);
            aVar.getClass();
            p pVar = o.f11766a;
            Object objI = aVar.i(descriptor, pVar);
            if (objI == null) {
                objI = zVar.invoke();
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) aVar.f3216b;
                Object concurrentHashMap2 = concurrentHashMap.get(descriptor);
                if (concurrentHashMap2 == null) {
                    concurrentHashMap2 = new ConcurrentHashMap(2);
                    concurrentHashMap.put(descriptor, concurrentHashMap2);
                }
                ((Map) concurrentHashMap2).put(pVar, objI);
            }
            Map map = (Map) objI;
            Iterator it = q().f11628a.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Integer num = (Integer) map.get((String) next);
                if (num != null && num.intValue() == i2) {
                    break;
                }
            }
            String str = (String) next;
            if (str != null) {
                return str;
            }
        }
        return strE;
    }

    @Override // h7.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public g7.x q() {
        return this.f11774f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(g7.c json, g7.x xVar, String str, d7.g gVar) {
        super(json, str);
        kotlin.jvm.internal.k.e(json, "json");
        this.f11774f = xVar;
        this.g = gVar;
    }
}
