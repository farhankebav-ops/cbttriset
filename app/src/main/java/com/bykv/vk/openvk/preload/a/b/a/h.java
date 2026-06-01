package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f4727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.c f4728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.c f4729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b.b f4730d = com.bykv.vk.openvk.preload.a.b.b.b.a();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f4736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f4737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f4738c;

        public b(String str, boolean z2, boolean z7) {
            this.f4736a = str;
            this.f4737b = z2;
            this.f4738c = z7;
        }

        public abstract void a(com.bykv.vk.openvk.preload.a.d.a aVar, Object obj) throws IllegalAccessException, IOException;

        public abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IllegalAccessException, IOException;

        public abstract boolean a(Object obj) throws IllegalAccessException, IOException;
    }

    public h(com.bykv.vk.openvk.preload.a.b.b bVar, com.bykv.vk.openvk.preload.a.c cVar, com.bykv.vk.openvk.preload.a.b.c cVar2) {
        this.f4727a = bVar;
        this.f4728b = cVar;
        this.f4729c = cVar2;
    }

    private boolean a(Field field, boolean z2) {
        com.bykv.vk.openvk.preload.a.b.c cVar = this.f4729c;
        return (cVar.a(field.getType(), z2) || cVar.a(field, z2)) ? false : true;
    }

    private List<String> a(Field field) {
        com.bykv.vk.openvk.preload.a.a.b bVar = (com.bykv.vk.openvk.preload.a.a.b) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.b.class);
        if (bVar == null) {
            return Collections.singletonList(this.f4728b.a(field));
        }
        String strA = bVar.a();
        String[] strArrB = bVar.b();
        if (strArrB.length == 0) {
            return Collections.singletonList(strA);
        }
        ArrayList arrayList = new ArrayList(strArrB.length + 1);
        arrayList.add(strA);
        for (String str : strArrB) {
            arrayList.add(str);
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bykv.vk.openvk.preload.a.b.h<T> f4734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, b> f4735b;

        public a(com.bykv.vk.openvk.preload.a.b.h<T> hVar, Map<String, b> map) {
            this.f4734a = hVar;
            this.f4735b = map;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T tA = this.f4734a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.f4735b.get(aVar.g());
                    if (bVar == null || !bVar.f4738c) {
                        aVar.n();
                    } else {
                        bVar.a(aVar, tA);
                    }
                }
                aVar.d();
                return tA;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e4) {
                throw new p(e4);
            }
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t3) throws IOException {
            if (t3 == null) {
                cVar.h();
                return;
            }
            cVar.f();
            try {
                for (b bVar : this.f4735b.values()) {
                    if (bVar.a(t3)) {
                        cVar.a(bVar.f4736a);
                        bVar.a(cVar, t3);
                    }
                }
                cVar.g();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Class<? super T> clsA = aVar.a();
        if (Object.class.isAssignableFrom(clsA)) {
            return new a(this.f4727a.a(aVar), a(dVar, aVar, clsA));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [int] */
    /* JADX WARN: Type inference failed for: r13v8 */
    private Map<String, b> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<?> aVar, Class<?> cls) {
        com.bykv.vk.openvk.preload.a.c.a<?> aVar2;
        Field[] fieldArr;
        int i2;
        boolean z2;
        int i8;
        int i9;
        final boolean z7;
        final com.bykv.vk.openvk.preload.a.d dVar2 = dVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cls.isInterface()) {
            Type typeB = aVar.b();
            com.bykv.vk.openvk.preload.a.c.a<?> aVarA = aVar;
            Class<?> clsA = cls;
            while (clsA != Object.class) {
                Field[] declaredFields = clsA.getDeclaredFields();
                int length = declaredFields.length;
                boolean z8 = false;
                int i10 = 0;
                while (i10 < length) {
                    final Field field = declaredFields[i10];
                    boolean zA = a(field, true);
                    boolean z9 = true;
                    boolean zA2 = a(field, z8);
                    if (zA || zA2) {
                        this.f4730d.a(field);
                        Type typeA = com.bykv.vk.openvk.preload.a.b.a.a(aVarA.b(), clsA, field.getGenericType());
                        List<String> listA = a(field);
                        int size = listA.size();
                        aVar2 = aVarA;
                        fieldArr = declaredFields;
                        b bVar = null;
                        for (?? r13 = z8; r13 < size; r13++) {
                            String str = listA.get(r13);
                            if (r13 != 0) {
                                zA = z8;
                            }
                            List<String> list = listA;
                            final com.bykv.vk.openvk.preload.a.c.a<?> aVarA2 = com.bykv.vk.openvk.preload.a.c.a.a(typeA);
                            Class<? super Object> clsA2 = aVarA2.a();
                            if (clsA2 == null || !clsA2.isPrimitive()) {
                                i9 = size;
                                z7 = z8;
                            } else {
                                i9 = size;
                                z7 = z9;
                            }
                            com.bykv.vk.openvk.preload.a.a.a aVar3 = (com.bykv.vk.openvk.preload.a.a.a) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.a.class);
                            r<?> rVarA = aVar3 != null ? d.a(this.f4727a, dVar2, aVarA2, aVar3) : null;
                            int i11 = i10;
                            boolean z10 = zA;
                            final boolean z11 = rVarA != null;
                            if (rVarA == null) {
                                rVarA = dVar2.a((com.bykv.vk.openvk.preload.a.c.a) aVarA2);
                            }
                            int i12 = length;
                            final r<?> rVar = rVarA;
                            b bVar2 = (b) linkedHashMap.put(str, new b(str, z10, zA2) { // from class: com.bykv.vk.openvk.preload.a.b.a.h.1
                                @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                                public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IllegalAccessException, IOException {
                                    (z11 ? rVar : new l(dVar2, rVar, aVarA2.b())).a(cVar, field.get(obj));
                                }

                                @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                                public final void a(com.bykv.vk.openvk.preload.a.d.a aVar4, Object obj) throws IllegalAccessException, IOException {
                                    Object objA = rVar.a(aVar4);
                                    if (objA == null && z7) {
                                        return;
                                    }
                                    field.set(obj, objA);
                                }

                                @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                                public final boolean a(Object obj) throws IllegalAccessException, IOException {
                                    return this.f4737b && field.get(obj) != obj;
                                }
                            });
                            if (bVar == null) {
                                bVar = bVar2;
                            }
                            dVar2 = dVar;
                            zA = z10;
                            i10 = i11;
                            listA = list;
                            size = i9;
                            z8 = false;
                            z9 = true;
                            length = i12;
                        }
                        i2 = length;
                        z2 = z8;
                        i8 = i10;
                        if (bVar != null) {
                            throw new IllegalArgumentException(typeB + " declares multiple JSON fields named " + bVar.f4736a);
                        }
                    } else {
                        i2 = length;
                        z2 = z8;
                        i8 = i10;
                        aVar2 = aVarA;
                        fieldArr = declaredFields;
                    }
                    i10 = i8 + 1;
                    dVar2 = dVar;
                    aVarA = aVar2;
                    declaredFields = fieldArr;
                    z8 = z2;
                    length = i2;
                }
                aVarA = com.bykv.vk.openvk.preload.a.c.a.a(com.bykv.vk.openvk.preload.a.b.a.a(aVarA.b(), clsA, clsA.getGenericSuperclass()));
                clsA = aVarA.a();
                dVar2 = dVar;
            }
        }
        return linkedHashMap;
    }
}
