package com.ironsource.mediationsdk.demandOnly;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface p {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9160a;

        public a(String plumbus) {
            kotlin.jvm.internal.k.e(plumbus, "plumbus");
            this.f9160a = plumbus;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.p
        public String value() {
            return this.f9160a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends a {
        public b() {
            super("");
        }
    }

    String value();
}
