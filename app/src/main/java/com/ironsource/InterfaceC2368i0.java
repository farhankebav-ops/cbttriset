package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.i0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2368i0 {

    /* JADX INFO: renamed from: com.ironsource.i0$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2368i0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0183a f8685c = new C0183a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8687b;

        /* JADX INFO: renamed from: com.ironsource.i0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0183a {
            public /* synthetic */ C0183a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final a a(String str) {
                return new a(str);
            }

            private C0183a() {
            }
        }

        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final a a(String str) {
            return new a(str);
        }

        public final String b() {
            return this.f8686a;
        }

        public final String c() {
            return this.f8686a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && kotlin.jvm.internal.k.a(this.f8686a, ((a) obj).f8686a);
        }

        public int hashCode() {
            String str = this.f8686a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return a1.a.m("NotReady(reason=", this.f8686a, ")");
        }

        public a(String str) {
            this.f8686a = str;
        }

        public static /* synthetic */ a a(a aVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = aVar.f8686a;
            }
            return aVar.a(str);
        }

        public /* synthetic */ a(String str, int i2, kotlin.jvm.internal.f fVar) {
            this((i2 & 1) != 0 ? null : str);
        }

        @Override // com.ironsource.InterfaceC2368i0
        public boolean a() {
            return this.f8687b;
        }
    }

    /* JADX INFO: renamed from: com.ironsource.i0$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2368i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8688a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final boolean f8689b = true;

        private b() {
        }

        @Override // com.ironsource.InterfaceC2368i0
        public boolean a() {
            return f8689b;
        }
    }

    boolean a();
}
