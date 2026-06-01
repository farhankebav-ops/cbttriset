package com.ironsource;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ge implements Fe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final N8 f6883a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6884a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f6885b = "sessionNumber";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f6886c = "firstSessionTimestamp";

        private a() {
        }
    }

    public Ge() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.He
    public void a(Context context, int i2) {
        kotlin.jvm.internal.k.e(context, "context");
        this.f6883a.a(context, a.f6885b, i2);
    }

    @Override // com.ironsource.He
    public int b(Context context, int i2) {
        kotlin.jvm.internal.k.e(context, "context");
        return this.f6883a.b(context, a.f6885b, i2);
    }

    public Ge(N8 sdkSharedPref) {
        kotlin.jvm.internal.k.e(sdkSharedPref, "sdkSharedPref");
        this.f6883a = sdkSharedPref;
    }

    @Override // com.ironsource.InterfaceC2491oe
    public long a(Context context, long j) {
        kotlin.jvm.internal.k.e(context, "context");
        return this.f6883a.b(context, "firstSessionTimestamp", j);
    }

    @Override // com.ironsource.InterfaceC2491oe
    public void b(Context context, long j) {
        kotlin.jvm.internal.k.e(context, "context");
        this.f6883a.a(context, "firstSessionTimestamp", j);
    }

    public /* synthetic */ Ge(N8 n8, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? new Ie() : n8);
    }
}
