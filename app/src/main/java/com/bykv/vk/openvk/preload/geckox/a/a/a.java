package com.bykv.vk.openvk.preload.geckox.a.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f4919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final c f4920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f4921c;

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.geckox.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C0022a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f4923b = b.f4925a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private c f4924c;

        public final C0022a a() {
            this.f4922a = 20;
            return this;
        }

        public final a b() {
            return new a(this, (byte) 0);
        }

        public final C0022a a(b bVar) {
            if (bVar == null) {
                bVar = b.f4925a;
            }
            this.f4923b = bVar;
            return this;
        }
    }

    public /* synthetic */ a(C0022a c0022a, byte b8) {
        this(c0022a);
    }

    public final b a() {
        return this.f4921c;
    }

    private a(C0022a c0022a) {
        this.f4919a = c0022a.f4922a;
        this.f4921c = c0022a.f4923b;
        this.f4920b = c0022a.f4924c;
    }
}
