package com.ironsource;

import android.app.Activity;

/* JADX INFO: renamed from: com.ironsource.y6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2652y6 {

    /* JADX INFO: renamed from: com.ironsource.y6$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f10548a;

        public a(c strategyType) {
            kotlin.jvm.internal.k.e(strategyType, "strategyType");
            this.f10548a = strategyType;
        }

        public final c a() {
            return this.f10548a;
        }

        public final c b() {
            return this.f10548a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f10548a == ((a) obj).f10548a;
        }

        public int hashCode() {
            return this.f10548a.hashCode();
        }

        public String toString() {
            return "Config(strategyType=" + this.f10548a + ")";
        }

        public final a a(c strategyType) {
            kotlin.jvm.internal.k.e(strategyType, "strategyType");
            return new a(strategyType);
        }

        public static /* synthetic */ a a(a aVar, c cVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                cVar = aVar.f10548a;
            }
            return aVar.a(cVar);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.y6$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: com.ironsource.y6$b$a */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10549a;

            static {
                int[] iArr = new int[c.values().length];
                try {
                    iArr[c.SINGLE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[c.PROGRESSIVE_ON_SHOW_SUCCESS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[c.PROGRESSIVE_ON_LOAD_SUCCESS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f10549a = iArr;
            }
        }

        public final InterfaceC2652y6 a(C2459n0 adTools, a config, InterfaceC2584u6 fullscreenAdUnitFactory, InterfaceC2618w6 fullscreenAdUnitListener, InterfaceC2635x6 listener) {
            kotlin.jvm.internal.k.e(adTools, "adTools");
            kotlin.jvm.internal.k.e(config, "config");
            kotlin.jvm.internal.k.e(fullscreenAdUnitFactory, "fullscreenAdUnitFactory");
            kotlin.jvm.internal.k.e(fullscreenAdUnitListener, "fullscreenAdUnitListener");
            kotlin.jvm.internal.k.e(listener, "listener");
            int i2 = a.f10549a[config.b().ordinal()];
            if (i2 == 1) {
                return new M6(adTools, config, fullscreenAdUnitFactory, fullscreenAdUnitListener, listener);
            }
            if (i2 == 2) {
                return new F6(adTools, fullscreenAdUnitFactory, fullscreenAdUnitListener, listener);
            }
            if (i2 == 3) {
                return new C2669z6(adTools, fullscreenAdUnitFactory, fullscreenAdUnitListener, listener);
            }
            throw new e2.s(3);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.y6$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum c {
        SINGLE("Single"),
        PROGRESSIVE_ON_SHOW_SUCCESS("OnShowSuccess"),
        PROGRESSIVE_ON_LOAD_SUCCESS("OnLoadSuccess");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10553a;

        c(String str) {
            this.f10553a = str;
        }

        public final String b() {
            return this.f10553a;
        }
    }

    void a(Activity activity);

    void loadAd();
}
