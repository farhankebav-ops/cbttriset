package com.bykv.vk.openvk.preload.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class m<IN> implements b<IN> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b<IN> f4905a;

    public m(b<IN> bVar) {
        this.f4905a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(IN in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final <O> O b(Class<? extends d<?, O>> cls) {
        return (O) this.f4905a.b(cls);
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final <I> I a(Class<? extends d<I, ?>> cls) {
        return (I) this.f4905a.a((Class) cls);
    }
}
