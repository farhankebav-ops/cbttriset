package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.b7, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2249b7 {

    /* JADX INFO: renamed from: com.ironsource.b7$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2249b7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EnumC2285d7 f8056a;

        public a(EnumC2285d7 strategy) {
            kotlin.jvm.internal.k.e(strategy, "strategy");
            this.f8056a = strategy;
        }

        @Override // com.ironsource.InterfaceC2249b7
        public String a() {
            return "WebView is unavailable";
        }

        @Override // com.ironsource.InterfaceC2249b7
        public EnumC2285d7 b() {
            return this.f8056a;
        }

        public final EnumC2285d7 c() {
            return this.f8056a;
        }
    }

    String a();

    EnumC2285d7 b();
}
