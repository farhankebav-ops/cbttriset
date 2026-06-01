package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a<E> extends r<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f4709a = new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.a.1
        @Override // com.bykv.vk.openvk.preload.a.s
        public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
            Type typeB = aVar.b();
            if (!(typeB instanceof GenericArrayType) && (!(typeB instanceof Class) || !((Class) typeB).isArray())) {
                return null;
            }
            Type typeD = com.bykv.vk.openvk.preload.a.b.a.d(typeB);
            return new a(dVar, dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(typeD)), com.bykv.vk.openvk.preload.a.b.a.b(typeD));
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<E> f4710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r<E> f4711c;

    public a(com.bykv.vk.openvk.preload.a.d dVar, r<E> rVar, Class<E> cls) {
        this.f4711c = new l(dVar, rVar, cls);
        this.f4710b = cls;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.f4711c.a(aVar));
        }
        aVar.b();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f4710b, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.h();
            return;
        }
        cVar.d();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f4711c.a(cVar, (E) Array.get(obj, i2));
        }
        cVar.e();
    }
}
