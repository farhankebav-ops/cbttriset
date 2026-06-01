package com.ironsource;

import com.ironsource.C2422l1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.i1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2369i1 {

    /* JADX INFO: renamed from: com.ironsource.i1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0184a f8690a = new C0184a(null);

        /* JADX INFO: renamed from: com.ironsource.i1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0184a {
            public /* synthetic */ C0184a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final InterfaceC2369i1 a(C2422l1.j errorCode, C2422l1.k errorReason) {
                kotlin.jvm.internal.k.e(errorCode, "errorCode");
                kotlin.jvm.internal.k.e(errorReason, "errorReason");
                return new b(403, r5.m.I0(errorCode, errorReason));
            }

            public final InterfaceC2369i1 b(InterfaceC2440m1... entity) {
                kotlin.jvm.internal.k.e(entity, "entity");
                return new b(404, r5.m.I0(Arrays.copyOf(entity, entity.length)));
            }

            public final InterfaceC2369i1 c(InterfaceC2440m1... entity) {
                kotlin.jvm.internal.k.e(entity, "entity");
                return new b(409, r5.m.I0(Arrays.copyOf(entity, entity.length)));
            }

            public final InterfaceC2369i1 d(InterfaceC2440m1... entity) {
                kotlin.jvm.internal.k.e(entity, "entity");
                return new b(401, r5.m.I0(Arrays.copyOf(entity, entity.length)));
            }

            public final InterfaceC2369i1 e(InterfaceC2440m1... entity) {
                kotlin.jvm.internal.k.e(entity, "entity");
                return new b(408, r5.m.I0(Arrays.copyOf(entity, entity.length)));
            }

            public final InterfaceC2369i1 f(InterfaceC2440m1... entity) {
                kotlin.jvm.internal.k.e(entity, "entity");
                return new b(405, r5.m.I0(Arrays.copyOf(entity, entity.length)));
            }

            private C0184a() {
            }

            public final InterfaceC2369i1 a() {
                return new b(406, new ArrayList());
            }

            public final InterfaceC2369i1 a(InterfaceC2440m1... entity) {
                kotlin.jvm.internal.k.e(entity, "entity");
                return new b(407, r5.m.I0(Arrays.copyOf(entity, entity.length)));
            }

            public final InterfaceC2369i1 a(boolean z2) {
                if (z2) {
                    return new b(410, new ArrayList());
                }
                return new b(411, new ArrayList());
            }
        }

        /* JADX INFO: renamed from: com.ironsource.i1$a$b */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f8691a = new b();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f8692b = 401;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f8693c = 403;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f8694d = 404;
            public static final int e = 405;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f8695f = 406;
            public static final int g = 407;
            public static final int h = 408;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final int f8696i = 409;
            public static final int j = 410;
            public static final int k = 411;

            private b() {
            }
        }

        public static final InterfaceC2369i1 a() {
            return f8690a.a();
        }

        public static final InterfaceC2369i1 b(InterfaceC2440m1... interfaceC2440m1Arr) {
            return f8690a.b(interfaceC2440m1Arr);
        }

        public static final InterfaceC2369i1 c(InterfaceC2440m1... interfaceC2440m1Arr) {
            return f8690a.c(interfaceC2440m1Arr);
        }

        public static final InterfaceC2369i1 d(InterfaceC2440m1... interfaceC2440m1Arr) {
            return f8690a.d(interfaceC2440m1Arr);
        }

        public static final InterfaceC2369i1 e(InterfaceC2440m1... interfaceC2440m1Arr) {
            return f8690a.e(interfaceC2440m1Arr);
        }

        public static final InterfaceC2369i1 f(InterfaceC2440m1... interfaceC2440m1Arr) {
            return f8690a.f(interfaceC2440m1Arr);
        }

        public static final InterfaceC2369i1 a(InterfaceC2440m1... interfaceC2440m1Arr) {
            return f8690a.a(interfaceC2440m1Arr);
        }

        public static final InterfaceC2369i1 a(boolean z2) {
            return f8690a.a(z2);
        }

        public static final InterfaceC2369i1 a(C2422l1.j jVar, C2422l1.k kVar) {
            return f8690a.a(jVar, kVar);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.i1$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2369i1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<InterfaceC2440m1> f8698b;

        public b(int i2, List<InterfaceC2440m1> arrayList) {
            kotlin.jvm.internal.k.e(arrayList, "arrayList");
            this.f8697a = i2;
            this.f8698b = arrayList;
        }

        @Override // com.ironsource.InterfaceC2369i1
        public void a(InterfaceC2495p1 analytics) {
            kotlin.jvm.internal.k.e(analytics, "analytics");
            analytics.a(this.f8697a, this.f8698b);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.i1$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8699a = new a(null);

        /* JADX INFO: renamed from: com.ironsource.i1$c$a */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final InterfaceC2369i1 a() {
                return new b(201, new ArrayList());
            }

            public final InterfaceC2369i1 b() {
                return new b(206, new ArrayList());
            }

            private a() {
            }

            public final InterfaceC2369i1 a(C2422l1.l ext1) {
                kotlin.jvm.internal.k.e(ext1, "ext1");
                return new b(207, r5.m.I0(ext1));
            }

            public final InterfaceC2369i1 a(InterfaceC2440m1 duration) {
                kotlin.jvm.internal.k.e(duration, "duration");
                return new b(202, r5.m.I0(duration));
            }

            public final InterfaceC2369i1 a(C2422l1.j errorCode, C2422l1.k errorReason, C2422l1.f duration) {
                kotlin.jvm.internal.k.e(errorCode, "errorCode");
                kotlin.jvm.internal.k.e(errorReason, "errorReason");
                kotlin.jvm.internal.k.e(duration, "duration");
                return new b(203, r5.m.I0(errorCode, errorReason, duration));
            }

            public final InterfaceC2369i1 a(InterfaceC2440m1... entity) {
                kotlin.jvm.internal.k.e(entity, "entity");
                return new b(204, r5.m.I0(Arrays.copyOf(entity, entity.length)));
            }
        }

        /* JADX INFO: renamed from: com.ironsource.i1$c$b */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f8700a = new b();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f8701b = 201;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f8702c = 202;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f8703d = 203;
            public static final int e = 204;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f8704f = 205;
            public static final int g = 206;
            public static final int h = 207;

            private b() {
            }
        }

        public static final InterfaceC2369i1 a(InterfaceC2440m1... interfaceC2440m1Arr) {
            return f8699a.a(interfaceC2440m1Arr);
        }

        public static final InterfaceC2369i1 b() {
            return f8699a.b();
        }

        public static final InterfaceC2369i1 a() {
            return f8699a.a();
        }

        public static final InterfaceC2369i1 a(C2422l1.j jVar, C2422l1.k kVar, C2422l1.f fVar) {
            return f8699a.a(jVar, kVar, fVar);
        }

        public static final InterfaceC2369i1 a(InterfaceC2440m1 interfaceC2440m1) {
            return f8699a.a(interfaceC2440m1);
        }

        public static final InterfaceC2369i1 a(C2422l1.l lVar) {
            return f8699a.a(lVar);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.i1$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8705a = new a(null);

        /* JADX INFO: renamed from: com.ironsource.i1$d$a */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final InterfaceC2369i1 a() {
                return new b(101, new ArrayList());
            }

            public final InterfaceC2369i1 b(InterfaceC2440m1... entity) {
                kotlin.jvm.internal.k.e(entity, "entity");
                return new b(110, r5.m.I0(Arrays.copyOf(entity, entity.length)));
            }

            public final b c() {
                return new b(105, new ArrayList());
            }

            private a() {
            }

            public final InterfaceC2369i1 a(InterfaceC2440m1... entity) {
                kotlin.jvm.internal.k.e(entity, "entity");
                return new b(102, r5.m.I0(Arrays.copyOf(entity, entity.length)));
            }

            public final InterfaceC2369i1 b() {
                return new b(112, new ArrayList());
            }

            public final InterfaceC2369i1 a(C2422l1.f duration) {
                kotlin.jvm.internal.k.e(duration, "duration");
                return new b(103, r5.m.I0(duration));
            }

            public final InterfaceC2369i1 a(C2422l1.j errorCode, C2422l1.k errorReason, C2422l1.f duration, C2422l1.l loaderState) {
                kotlin.jvm.internal.k.e(errorCode, "errorCode");
                kotlin.jvm.internal.k.e(errorReason, "errorReason");
                kotlin.jvm.internal.k.e(duration, "duration");
                kotlin.jvm.internal.k.e(loaderState, "loaderState");
                return new b(104, r5.m.I0(errorCode, errorReason, duration, loaderState));
            }

            public final InterfaceC2369i1 a(C2422l1.j errorCode, C2422l1.k errorReason) {
                kotlin.jvm.internal.k.e(errorCode, "errorCode");
                kotlin.jvm.internal.k.e(errorReason, "errorReason");
                return new b(109, r5.m.I0(errorCode, errorReason));
            }

            public final InterfaceC2369i1 a(InterfaceC2440m1 ext1) {
                kotlin.jvm.internal.k.e(ext1, "ext1");
                return new b(111, r5.m.I0(ext1));
            }
        }

        /* JADX INFO: renamed from: com.ironsource.i1$d$b */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f8706a = new b();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f8707b = 101;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f8708c = 102;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f8709d = 103;
            public static final int e = 104;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f8710f = 105;
            public static final int g = 109;
            public static final int h = 110;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final int f8711i = 111;
            public static final int j = 112;

            private b() {
            }
        }

        public static final InterfaceC2369i1 a() {
            return f8705a.a();
        }

        public static final InterfaceC2369i1 b() {
            return f8705a.b();
        }

        public static final b c() {
            return f8705a.c();
        }

        public static final InterfaceC2369i1 a(InterfaceC2440m1... interfaceC2440m1Arr) {
            return f8705a.a(interfaceC2440m1Arr);
        }

        public static final InterfaceC2369i1 b(InterfaceC2440m1... interfaceC2440m1Arr) {
            return f8705a.b(interfaceC2440m1Arr);
        }

        public static final InterfaceC2369i1 a(C2422l1.j jVar, C2422l1.k kVar) {
            return f8705a.a(jVar, kVar);
        }

        public static final InterfaceC2369i1 a(C2422l1.j jVar, C2422l1.k kVar, C2422l1.f fVar, C2422l1.l lVar) {
            return f8705a.a(jVar, kVar, fVar, lVar);
        }

        public static final InterfaceC2369i1 a(InterfaceC2440m1 interfaceC2440m1) {
            return f8705a.a(interfaceC2440m1);
        }

        public static final InterfaceC2369i1 a(C2422l1.f fVar) {
            return f8705a.a(fVar);
        }
    }

    void a(InterfaceC2495p1 interfaceC2495p1);
}
