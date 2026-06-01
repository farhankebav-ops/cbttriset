package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.ne, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2473ne {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9514c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9515d = 2070;
    public static final int e = 2080;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9516f = 2090;
    public static final int g = 2100;
    public static final int h = 2110;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9518b;

    /* JADX INFO: renamed from: com.ironsource.ne$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public C2473ne(int i2, String errorMessage) {
        kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
        this.f9517a = i2;
        this.f9518b = errorMessage;
    }

    public final int a() {
        return this.f9517a;
    }

    public final String b() {
        return this.f9518b;
    }

    public final int c() {
        return this.f9517a;
    }

    public final String d() {
        return this.f9518b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2473ne)) {
            return false;
        }
        C2473ne c2473ne = (C2473ne) obj;
        return this.f9517a == c2473ne.f9517a && kotlin.jvm.internal.k.a(this.f9518b, c2473ne.f9518b);
    }

    public int hashCode() {
        return this.f9518b.hashCode() + (this.f9517a * 31);
    }

    public String toString() {
        return "SdkError(errorCode=" + this.f9517a + ", errorMessage=" + this.f9518b + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C2473ne(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "error");
        int errorCode = error.getErrorCode();
        String errorMessage = error.getErrorMessage();
        kotlin.jvm.internal.k.d(errorMessage, "error.errorMessage");
        this(errorCode, errorMessage);
    }

    public final C2473ne a(int i2, String errorMessage) {
        kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
        return new C2473ne(i2, errorMessage);
    }

    public static /* synthetic */ C2473ne a(C2473ne c2473ne, int i2, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = c2473ne.f9517a;
        }
        if ((i8 & 2) != 0) {
            str = c2473ne.f9518b;
        }
        return c2473ne.a(i2, str);
    }
}
