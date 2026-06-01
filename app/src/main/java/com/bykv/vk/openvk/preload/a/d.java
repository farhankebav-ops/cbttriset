package com.bykv.vk.openvk.preload.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bykv.vk.openvk.preload.a.c.a<?> f4837a = com.bykv.vk.openvk.preload.a.c.a.a(Object.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadLocal<Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>>> f4838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<com.bykv.vk.openvk.preload.a.c.a<?>, r<?>> f4839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f4840d;
    private final com.bykv.vk.openvk.preload.a.b.a.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<s> f4841f;
    private boolean g;

    public d() {
        this(com.bykv.vk.openvk.preload.a.b.c.f4799a, b.f4697a, Collections.EMPTY_MAP, true, q.f4875a, Collections.EMPTY_LIST);
    }

    public static void a(double d8) {
        if (Double.isNaN(d8) || Double.isInfinite(d8)) {
            throw new IllegalArgumentException(d8 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f4841f + ",instanceCreators:" + this.f4840d + "}";
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private r<T> f4844a;

        public final void a(r<T> rVar) {
            if (this.f4844a != null) {
                throw new AssertionError();
            }
            this.f4844a = rVar;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            r<T> rVar = this.f4844a;
            if (rVar != null) {
                return rVar.a(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t3) throws IOException {
            r<T> rVar = this.f4844a;
            if (rVar != null) {
                rVar.a(cVar, t3);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        boolean z2;
        r<T> rVar = (r) this.f4839c.get(aVar == null ? f4837a : aVar);
        if (rVar != null) {
            return rVar;
        }
        Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>> map = this.f4838b.get();
        if (map == null) {
            map = new HashMap<>();
            this.f4838b.set(map);
            z2 = true;
        } else {
            z2 = false;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            Iterator<s> it = this.f4841f.iterator();
            while (it.hasNext()) {
                r<T> rVarA = it.next().a(this, aVar);
                if (rVarA != null) {
                    aVar3.a((r<?>) rVarA);
                    this.f4839c.put(aVar, rVarA);
                    return rVarA;
                }
            }
            throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle ".concat(String.valueOf(aVar)));
        } finally {
            map.remove(aVar);
            if (z2) {
                this.f4838b.remove();
            }
        }
    }

    public d(com.bykv.vk.openvk.preload.a.b.c cVar, c cVar2, Map<Type, f<?>> map, boolean z2, q qVar, List<s> list) {
        final r<Number> rVar;
        this.f4838b = new ThreadLocal<>();
        this.f4839c = new ConcurrentHashMap();
        com.bykv.vk.openvk.preload.a.b.b bVar = new com.bykv.vk.openvk.preload.a.b.b(map);
        this.f4840d = bVar;
        this.g = z2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.B);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.g.f4724a);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.p);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.g);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4754d);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.e);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4755f);
        if (qVar == q.f4875a) {
            rVar = com.bykv.vk.openvk.preload.a.b.a.m.k;
        } else {
            rVar = new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.3
                @Override // com.bykv.vk.openvk.preload.a.r
                public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                    Number number2 = number;
                    if (number2 == null) {
                        cVar3.h();
                    } else {
                        cVar3.b(number2.toString());
                    }
                }

                @Override // com.bykv.vk.openvk.preload.a.r
                public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                    if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                        aVar.j();
                        return null;
                    }
                    return Long.valueOf(aVar.l());
                }
            };
        }
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Long.TYPE, Long.class, rVar));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Double.TYPE, Double.class, new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.1
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.doubleValue());
                    cVar3.a(number2);
                }
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Float.TYPE, Float.class, new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.2
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.floatValue());
                    cVar3.a(number2);
                }
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.l);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.h);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4756i);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLong.class, new r<AtomicLong>() { // from class: com.bykv.vk.openvk.preload.a.d.4
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLong atomicLong) throws IOException {
                rVar.a(cVar3, Long.valueOf(atomicLong.get()));
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ AtomicLong a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) rVar.a(aVar)).longValue());
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLongArray.class, new r<AtomicLongArray>() { // from class: com.bykv.vk.openvk.preload.a.d.5
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLongArray atomicLongArray) throws IOException {
                AtomicLongArray atomicLongArray2 = atomicLongArray;
                cVar3.d();
                int length = atomicLongArray2.length();
                for (int i2 = 0; i2 < length; i2++) {
                    rVar.a(cVar3, Long.valueOf(atomicLongArray2.get(i2)));
                }
                cVar3.e();
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ AtomicLongArray a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList2 = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList2.add(Long.valueOf(((Number) rVar.a(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList2.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList2.get(i2)).longValue());
                }
                return atomicLongArray;
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.j);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.m);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4759q);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4760r);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigDecimal.class, com.bykv.vk.openvk.preload.a.b.a.m.f4757n));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigInteger.class, com.bykv.vk.openvk.preload.a.b.a.m.f4758o));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4761s);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4762t);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4764v);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4765w);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4767z);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4763u);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4752b);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.c.f4716a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.y);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.j.f4741a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.i.f4739a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4766x);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.a.f4709a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f4751a);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.b(bVar));
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.f(bVar));
        com.bykv.vk.openvk.preload.a.b.a.d dVar = new com.bykv.vk.openvk.preload.a.b.a.d(bVar);
        this.e = dVar;
        arrayList.add(dVar);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.C);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.h(bVar, cVar2, cVar));
        this.f4841f = Collections.unmodifiableList(arrayList);
    }

    public final <T> r<T> a(s sVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        if (!this.f4841f.contains(sVar)) {
            sVar = this.e;
        }
        boolean z2 = false;
        for (s sVar2 : this.f4841f) {
            if (z2) {
                r<T> rVarA = sVar2.a(this, aVar);
                if (rVarA != null) {
                    return rVarA;
                }
            } else if (sVar2 == sVar) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(aVar)));
    }

    public final <T> r<T> a(Class<T> cls) {
        return a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Class) cls));
    }

    public final String a(Object obj) {
        com.bykv.vk.openvk.preload.a.d.c cVarA;
        boolean zA;
        boolean zB;
        boolean zC;
        if (obj == null) {
            k kVar = k.f4872a;
            StringWriter stringWriter = new StringWriter();
            try {
                cVarA = a((Writer) stringWriter);
                zA = cVarA.a();
                cVarA.a(true);
                zB = cVarA.b();
                cVarA.b(this.g);
                zC = cVarA.c();
                cVarA.c(false);
                try {
                    try {
                        com.bykv.vk.openvk.preload.geckox.h.a.a(kVar, cVarA);
                        return stringWriter.toString();
                    } catch (IOException e) {
                        throw new j(e);
                    } catch (AssertionError e4) {
                        AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e4.getMessage());
                        assertionError.initCause(e4);
                        throw assertionError;
                    }
                } finally {
                }
            } catch (IOException e8) {
                throw new j(e8);
            }
        }
        Class<?> cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            cVarA = a((Writer) stringWriter2);
            r rVarA = a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Type) cls));
            zA = cVarA.a();
            cVarA.a(true);
            zB = cVarA.b();
            cVarA.b(this.g);
            zC = cVarA.c();
            cVarA.c(false);
            try {
                try {
                    rVarA.a(cVarA, obj);
                    return stringWriter2.toString();
                } catch (IOException e9) {
                    throw new j(e9);
                } catch (AssertionError e10) {
                    AssertionError assertionError2 = new AssertionError("AssertionError (GSON pangle-v3200): " + e10.getMessage());
                    assertionError2.initCause(e10);
                    throw assertionError2;
                }
            } finally {
            }
        } catch (IOException e11) {
            throw new j(e11);
        }
    }

    private static com.bykv.vk.openvk.preload.a.d.c a(Writer writer) throws IOException {
        com.bykv.vk.openvk.preload.a.d.c cVar = new com.bykv.vk.openvk.preload.a.d.c(writer);
        cVar.c(false);
        return cVar;
    }

    private <T> T a(com.bykv.vk.openvk.preload.a.d.a aVar, Type type) throws j, p {
        boolean zP = aVar.p();
        boolean z2 = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.f();
                    z2 = false;
                    return a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type)).a(aVar);
                } catch (IOException e) {
                    throw new p(e);
                } catch (AssertionError e4) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e4.getMessage());
                    assertionError.initCause(e4);
                    throw assertionError;
                }
            } catch (EOFException e8) {
                if (z2) {
                    aVar.a(zP);
                    return null;
                }
                throw new p(e8);
            } catch (IllegalStateException e9) {
                throw new p(e9);
            }
        } finally {
            aVar.a(zP);
        }
    }

    public final <T> T a(Reader reader, Type type) throws j, p {
        com.bykv.vk.openvk.preload.a.d.a aVar = new com.bykv.vk.openvk.preload.a.d.a(reader);
        aVar.a(false);
        T t3 = (T) a(aVar, type);
        if (t3 != null) {
            try {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.END_DOCUMENT) {
                    throw new j("JSON document was not fully consumed.");
                }
            } catch (com.bykv.vk.openvk.preload.a.d.d e) {
                throw new p(e);
            } catch (IOException e4) {
                throw new j(e4);
            }
        }
        return t3;
    }
}
