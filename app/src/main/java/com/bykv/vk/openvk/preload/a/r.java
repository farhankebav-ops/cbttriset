package com.bykv.vk.openvk.preload.a;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r<T> {
    public final r<T> a() {
        return new r<T>() { // from class: com.bykv.vk.openvk.preload.a.r.1
            @Override // com.bykv.vk.openvk.preload.a.r
            public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t3) throws IOException {
                if (t3 == null) {
                    cVar.h();
                } else {
                    r.this.a(cVar, t3);
                }
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return (T) r.this.a(aVar);
            }
        };
    }

    public abstract T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException;

    public abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t3) throws IOException;
}
