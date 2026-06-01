package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Bb {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6383c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6384d = "revenue";
    public static final String e = "precision";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f6385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6386b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Bb a(JSONObject json) {
            kotlin.jvm.internal.k.e(json, "json");
            try {
                double d8 = json.getDouble("revenue");
                String precision = json.getString("precision");
                kotlin.jvm.internal.k.d(precision, "precision");
                return new Bb(d8, precision);
            } catch (Exception e) {
                C2531r4.d().a(e);
                C2627wf.a(e);
                return null;
            }
        }

        private a() {
        }
    }

    public Bb(double d8, String precision) {
        kotlin.jvm.internal.k.e(precision, "precision");
        this.f6385a = d8;
        this.f6386b = precision;
    }

    public final double a() {
        return this.f6385a;
    }

    public final String b() {
        return this.f6386b;
    }

    public final String c() {
        return this.f6386b;
    }

    public final double d() {
        return this.f6385a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bb)) {
            return false;
        }
        Bb bb = (Bb) obj;
        return Double.compare(this.f6385a, bb.f6385a) == 0 && kotlin.jvm.internal.k.a(this.f6386b, bb.f6386b);
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f6385a);
        return this.f6386b.hashCode() + (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31);
    }

    public String toString() {
        return "LoadArmData(revenue=" + this.f6385a + ", precision=" + this.f6386b + ")";
    }

    public final Bb a(double d8, String precision) {
        kotlin.jvm.internal.k.e(precision, "precision");
        return new Bb(d8, precision);
    }

    public static /* synthetic */ Bb a(Bb bb, double d8, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d8 = bb.f6385a;
        }
        if ((i2 & 2) != 0) {
            str = bb.f6386b;
        }
        return bb.a(d8, str);
    }

    public static final Bb a(JSONObject jSONObject) {
        return f6383c.a(jSONObject);
    }
}
