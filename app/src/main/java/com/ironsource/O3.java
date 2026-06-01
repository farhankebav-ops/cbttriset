package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class O3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f7310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Q3 f7311b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7312a;

        static {
            int[] iArr = new int[Q3.values().length];
            try {
                iArr[Q3.Delivery.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Q3.Pacing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Q3.ShowCount.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f7312a = iArr;
        }
    }

    public O3(boolean z2, Q3 q32) {
        this.f7310a = z2;
        this.f7311b = q32;
    }

    public final boolean a() {
        return this.f7310a;
    }

    public final Q3 b() {
        return this.f7311b;
    }

    public final Q3 c() {
        return this.f7311b;
    }

    public final boolean d() {
        return this.f7310a;
    }

    public final String e() {
        Q3 q32 = this.f7311b;
        int i2 = q32 == null ? -1 : a.f7312a[q32.ordinal()];
        if (i2 == 1) {
            return "Placement delivery is false";
        }
        if (i2 == 2) {
            return "In pacing mode";
        }
        if (i2 != 3) {
            return null;
        }
        return "Max ad cap reached";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O3)) {
            return false;
        }
        O3 o3 = (O3) obj;
        return this.f7310a == o3.f7310a && this.f7311b == o3.f7311b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.f7310a;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int i2 = r02 * 31;
        Q3 q32 = this.f7311b;
        return i2 + (q32 == null ? 0 : q32.hashCode());
    }

    public String toString() {
        return "CappingStatus(isCapped=" + this.f7310a + " reason=" + this.f7311b + ")";
    }

    public /* synthetic */ O3(boolean z2, Q3 q32, int i2, kotlin.jvm.internal.f fVar) {
        this(z2, (i2 & 2) != 0 ? null : q32);
    }

    public final O3 a(boolean z2, Q3 q32) {
        return new O3(z2, q32);
    }

    public static /* synthetic */ O3 a(O3 o3, boolean z2, Q3 q32, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = o3.f7310a;
        }
        if ((i2 & 2) != 0) {
            q32 = o3.f7311b;
        }
        return o3.a(z2, q32);
    }
}
