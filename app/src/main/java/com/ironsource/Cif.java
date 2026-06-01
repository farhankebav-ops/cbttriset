package com.ironsource;

import android.content.Context;

/* JADX INFO: renamed from: com.ironsource.if, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Cif implements J3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f8734d = new a(null);
    public static final int e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f8735f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final N8 f8738c;

    /* JADX INFO: renamed from: com.ironsource.if$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public Cif(Context context, String baseName, N8 sdkSharedPref) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(baseName, "baseName");
        kotlin.jvm.internal.k.e(sdkSharedPref, "sdkSharedPref");
        this.f8736a = context;
        this.f8737b = baseName;
        this.f8738c = sdkSharedPref;
    }

    @Override // com.ironsource.J3
    public void a(String identifier, int i2) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        this.f8738c.a(this.f8736a, new C2400jf(identifier, a1.a.C(this.f8737b, ".show_count_show_counter")).a(), i2);
    }

    @Override // com.ironsource.J3
    public Long b(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        return a(Long.valueOf(this.f8738c.b(this.f8736a, new C2400jf(identifier, a1.a.C(this.f8737b, ".pacing_last_show_time")).a(), -1L)));
    }

    @Override // com.ironsource.J3
    public Integer c(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        return a(Integer.valueOf(this.f8738c.b(this.f8736a, new C2400jf(identifier, a1.a.C(this.f8737b, ".show_count_show_counter")).a(), -1)));
    }

    public /* synthetic */ Cif(Context context, String str, N8 n8, int i2, kotlin.jvm.internal.f fVar) {
        this(context, str, (i2 & 4) != 0 ? new Ie() : n8);
    }

    @Override // com.ironsource.J3
    public void a(String identifier, long j) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        this.f8738c.a(this.f8736a, new C2400jf(identifier, a1.a.C(this.f8737b, ".pacing_last_show_time")).a(), j);
    }

    @Override // com.ironsource.J3
    public void b(String identifier, long j) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        this.f8738c.a(this.f8736a, new C2400jf(identifier, a1.a.C(this.f8737b, ".show_count_threshold")).a(), j);
    }

    @Override // com.ironsource.J3
    public Long a(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        return a(Long.valueOf(this.f8738c.b(this.f8736a, new C2400jf(identifier, a1.a.C(this.f8737b, ".show_count_threshold")).a(), -1L)));
    }

    private final Long a(Long l) {
        if (l != null && l.longValue() == -1) {
            return null;
        }
        return l;
    }

    private final Integer a(Integer num) {
        if (num != null && num.intValue() == -1) {
            return null;
        }
        return num;
    }
}
