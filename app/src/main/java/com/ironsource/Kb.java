package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Kb extends AbstractC2345gd {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f7059d = new a(null);
    private static final String e = "ManualTrigger";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public Kb() {
        this(false, 1, null);
    }

    @Override // com.ironsource.AbstractC2345gd
    public String b() {
        return e;
    }

    public final void e() {
        a(true);
    }

    public final void f() {
        a(false);
    }

    public Kb(boolean z2) {
        super(z2);
    }

    public /* synthetic */ Kb(boolean z2, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? false : z2);
    }
}
