package com.bykv.vk.openvk.preload.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Class<? extends d> f4889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.b.b.a f4890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f4891c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<? extends d> f4892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bykv.vk.openvk.preload.b.b.a f4893b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object[] f4894c;

        private a() {
        }

        public static a a() {
            return new a();
        }

        public final h b() {
            return new h(this, (byte) 0);
        }

        public final a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f4892a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public final a a(com.bykv.vk.openvk.preload.b.b.a aVar) {
            this.f4893b = aVar;
            return this;
        }

        public final a a(Object... objArr) {
            this.f4894c = objArr;
            return this;
        }
    }

    public /* synthetic */ h(a aVar, byte b8) {
        this(aVar);
    }

    public final com.bykv.vk.openvk.preload.b.b.a a() {
        return this.f4890b;
    }

    public final Object[] b() {
        return this.f4891c;
    }

    private h(a aVar) {
        this.f4889a = aVar.f4892a;
        this.f4890b = aVar.f4893b;
        this.f4891c = aVar.f4894c;
        if (this.f4889a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
