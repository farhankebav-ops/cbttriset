package com.ironsource;

import android.content.Context;
import com.ironsource.InterfaceC2565t4;
import com.ironsource.M8;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ee implements M8, M8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fe f6722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2626we f6723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2565t4 f6724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6725d;
    private long e;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6726a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6727b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6728c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f6729d = -1;

        private a() {
        }
    }

    public Ee(Fe storage, InterfaceC2626we initResponseStorage, InterfaceC2565t4 currentTimeProvider) {
        kotlin.jvm.internal.k.e(storage, "storage");
        kotlin.jvm.internal.k.e(initResponseStorage, "initResponseStorage");
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        this.f6722a = storage;
        this.f6723b = initResponseStorage;
        this.f6724c = currentTimeProvider;
        this.f6725d = -1;
        this.e = -1L;
    }

    private final int b(Context context, Fe fe) {
        int iB = fe.b(context, 0) + 1;
        fe.a(context, iB);
        return iB;
    }

    @Override // com.ironsource.M8.a
    public void a(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        this.f6725d = b(context, this.f6722a);
        this.e = a(context, this.f6722a);
    }

    @Override // com.ironsource.M8
    public int c() {
        return this.f6725d;
    }

    private final long a(Context context, Fe fe) {
        long jA = fe.a(context, -1L);
        if (this.f6723b.a(context) || jA != -1) {
            return jA;
        }
        long jA2 = this.f6724c.a();
        IronLog.INTERNAL.verbose("set first session timestamp = " + jA2);
        fe.b(context, jA2);
        return jA2;
    }

    @Override // com.ironsource.M8
    public String b() {
        String strD = IronSourceUtils.d();
        kotlin.jvm.internal.k.d(strD, "getSessionId()");
        return strD;
    }

    public /* synthetic */ Ee(Fe fe, InterfaceC2626we interfaceC2626we, InterfaceC2565t4 interfaceC2565t4, int i2, kotlin.jvm.internal.f fVar) {
        this(fe, (i2 & 2) != 0 ? new C2643xe() : interfaceC2626we, (i2 & 4) != 0 ? new InterfaceC2565t4.a() : interfaceC2565t4);
    }

    @Override // com.ironsource.M8
    public long a() {
        return this.e;
    }
}
