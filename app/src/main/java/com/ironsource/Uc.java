package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Uc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f7685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7686b;

    public Uc() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public final boolean a() {
        return this.f7685a;
    }

    public final int b() {
        return this.f7686b;
    }

    public final int c() {
        return this.f7686b;
    }

    public final boolean d() {
        return this.f7685a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uc)) {
            return false;
        }
        Uc uc = (Uc) obj;
        return this.f7685a == uc.f7685a && this.f7686b == uc.f7686b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.f7685a;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        return (r02 * 31) + this.f7686b;
    }

    public String toString() {
        return "OpenUrlConfigurations(isImmersive=" + this.f7685a + ", flags=" + this.f7686b + ")";
    }

    public Uc(boolean z2, int i2) {
        this.f7685a = z2;
        this.f7686b = i2;
    }

    public final Uc a(boolean z2, int i2) {
        return new Uc(z2, i2);
    }

    public static /* synthetic */ Uc a(Uc uc, boolean z2, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z2 = uc.f7685a;
        }
        if ((i8 & 2) != 0) {
            i2 = uc.f7686b;
        }
        return uc.a(z2, i2);
    }

    public /* synthetic */ Uc(boolean z2, int i2, int i8, kotlin.jvm.internal.f fVar) {
        this((i8 & 1) != 0 ? false : z2, (i8 & 2) != 0 ? 805306368 : i2);
    }
}
