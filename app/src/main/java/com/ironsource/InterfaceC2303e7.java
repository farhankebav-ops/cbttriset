package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.e7, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2303e7 {

    /* JADX INFO: renamed from: com.ironsource.e7$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2303e7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC2249b7 f8432a;

        public a(InterfaceC2249b7 failure) {
            kotlin.jvm.internal.k.e(failure, "failure");
            this.f8432a = failure;
        }

        public final InterfaceC2249b7 a() {
            return this.f8432a;
        }

        public final InterfaceC2249b7 b() {
            return this.f8432a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && kotlin.jvm.internal.k.a(this.f8432a, ((a) obj).f8432a);
        }

        public int hashCode() {
            return this.f8432a.hashCode();
        }

        public String toString() {
            return "Failure(failure=" + this.f8432a + ")";
        }

        public final a a(InterfaceC2249b7 failure) {
            kotlin.jvm.internal.k.e(failure, "failure");
            return new a(failure);
        }

        public static /* synthetic */ a a(a aVar, InterfaceC2249b7 interfaceC2249b7, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                interfaceC2249b7 = aVar.f8432a;
            }
            return aVar.a(interfaceC2249b7);
        }

        @Override // com.ironsource.InterfaceC2303e7
        public void a(InterfaceC2321f7 handler) {
            kotlin.jvm.internal.k.e(handler, "handler");
            handler.a(this.f8432a);
        }
    }

    void a(InterfaceC2321f7 interfaceC2321f7);
}
