package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.md, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2452md {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EnumC2524qd f8964d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8965f;

    /* JADX INFO: renamed from: com.ironsource.md$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8966a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8967b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f8968c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private EnumC2524qd f8969d = null;
        private int e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f8970f = 0;

        public a a(boolean z2) {
            this.f8966a = z2;
            return this;
        }

        public a a(boolean z2, EnumC2524qd enumC2524qd, int i2) {
            this.f8967b = z2;
            if (enumC2524qd == null) {
                enumC2524qd = EnumC2524qd.PER_DAY;
            }
            this.f8969d = enumC2524qd;
            this.e = i2;
            return this;
        }

        public a a(boolean z2, int i2) {
            this.f8968c = z2;
            this.f8970f = i2;
            return this;
        }

        public C2452md a() {
            return new C2452md(this.f8966a, this.f8967b, this.f8968c, this.f8969d, this.e, this.f8970f, 0);
        }
    }

    public /* synthetic */ C2452md(boolean z2, boolean z7, boolean z8, EnumC2524qd enumC2524qd, int i2, int i8, int i9) {
        this(z2, z7, z8, enumC2524qd, i2, i8);
    }

    public EnumC2524qd a() {
        return this.f8964d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f8965f;
    }

    public boolean d() {
        return this.f8962b;
    }

    public boolean e() {
        return this.f8961a;
    }

    public boolean f() {
        return this.f8963c;
    }

    private C2452md(boolean z2, boolean z7, boolean z8, EnumC2524qd enumC2524qd, int i2, int i8) {
        this.f8961a = z2;
        this.f8962b = z7;
        this.f8963c = z8;
        this.f8964d = enumC2524qd;
        this.e = i2;
        this.f8965f = i8;
    }
}
