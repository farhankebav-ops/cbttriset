package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.a.h;
import com.bykv.vk.openvk.preload.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class l<T> extends r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.d f4748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r<T> f4749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f4750c;

    public l(com.bykv.vk.openvk.preload.a.d dVar, r<T> rVar, Type type) {
        this.f4748a = dVar;
        this.f4749b = rVar;
        this.f4750c = type;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        return this.f4749b.a(aVar);
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t3) throws IOException {
        r<T> rVarA = this.f4749b;
        Type type = this.f4750c;
        if (t3 != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t3.getClass();
        }
        if (type != this.f4750c) {
            rVarA = this.f4748a.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type));
            if (rVarA instanceof h.a) {
                r<T> rVar = this.f4749b;
                if (!(rVar instanceof h.a)) {
                    rVarA = rVar;
                }
            }
        }
        rVarA.a(cVar, t3);
    }
}
