package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class k<T> extends r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<T> f4743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.h<T> f4744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.a.d f4745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.c.a<T> f4746d;
    private final s e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private r<T> f4747f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class a {
        private a(byte b8) {
        }

        public /* synthetic */ a() {
            this((byte) 0);
        }
    }

    public k(o<T> oVar, com.bykv.vk.openvk.preload.a.h<T> hVar, com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar, s sVar) {
        new a();
        this.f4743a = oVar;
        this.f4744b = hVar;
        this.f4745c = dVar;
        this.f4746d = aVar;
        this.e = sVar;
    }

    private r<T> b() {
        r<T> rVar = this.f4747f;
        if (rVar != null) {
            return rVar;
        }
        r<T> rVarA = this.f4745c.a(this.e, this.f4746d);
        this.f4747f = rVarA;
        return rVarA;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (this.f4744b == null) {
            return b().a(aVar);
        }
        if (com.bykv.vk.openvk.preload.geckox.h.a.a(aVar) instanceof com.bykv.vk.openvk.preload.a.k) {
            return null;
        }
        com.bykv.vk.openvk.preload.a.h<T> hVar = this.f4744b;
        this.f4746d.b();
        return hVar.a();
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t3) throws IOException {
        o<T> oVar = this.f4743a;
        if (oVar == null) {
            b().a(cVar, t3);
        } else if (t3 == null) {
            cVar.h();
        } else {
            this.f4746d.b();
            com.bykv.vk.openvk.preload.geckox.h.a.a(oVar.a(), cVar);
        }
    }
}
