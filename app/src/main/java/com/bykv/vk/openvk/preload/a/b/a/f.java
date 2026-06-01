package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f4720a;

    public f(com.bykv.vk.openvk.preload.a.b.b bVar) {
        this.f4720a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Type typeB = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] typeArrB = com.bykv.vk.openvk.preload.a.b.a.b(typeB, com.bykv.vk.openvk.preload.a.b.a.b(typeB));
        Type type = typeArrB[0];
        return new a(this, dVar, typeArrB[0], (type == Boolean.TYPE || type == Boolean.class) ? m.f4753c : dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type)), typeArrB[1], dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(typeArrB[1])), this.f4720a.a(aVar));
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class a<K, V> extends r<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r<K> f4721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final r<V> f4722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bykv.vk.openvk.preload.a.b.h<? extends Map<K, V>> f4723c;

        public a(f fVar, com.bykv.vk.openvk.preload.a.d dVar, Type type, r<K> rVar, Type type2, r<V> rVar2, com.bykv.vk.openvk.preload.a.b.h<? extends Map<K, V>> hVar) {
            this.f4721a = new l(dVar, rVar, type);
            this.f4722b = new l(dVar, rVar2, type2);
            this.f4723c = hVar;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                cVar.h();
                return;
            }
            cVar.f();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                cVar.a(String.valueOf(entry.getKey()));
                this.f4722b.a(cVar, entry.getValue());
            }
            cVar.g();
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            com.bykv.vk.openvk.preload.a.d.b bVarF = aVar.f();
            if (bVarF == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> mapA = this.f4723c.a();
            if (bVarF == com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K kA = this.f4721a.a(aVar);
                    if (mapA.put(kA, this.f4722b.a(aVar)) == null) {
                        aVar.b();
                    } else {
                        throw new p("duplicate key: ".concat(String.valueOf(kA)));
                    }
                }
                aVar.b();
                return mapA;
            }
            aVar.c();
            while (aVar.e()) {
                com.bykv.vk.openvk.preload.a.b.e.f4810a.a(aVar);
                K kA2 = this.f4721a.a(aVar);
                if (mapA.put(kA2, this.f4722b.a(aVar)) != null) {
                    throw new p("duplicate key: ".concat(String.valueOf(kA2)));
                }
            }
            aVar.d();
            return mapA;
        }
    }
}
